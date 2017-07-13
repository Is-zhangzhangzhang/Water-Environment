package com.scau.util;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;


/**
 * Created by zhonghua on 2016/8/6.
 */
public class SolrHelper {

    private static Logger log=Logger.getLogger(SolrHelper.class);

    private static String SOLR_URL=null;
    private static String FILE_URL=null;


    /**
     * 多条件高级查询
     * @param solr
     * @param title
     * @param content
     * @param contentType
     * @param startDate
     * @param endDate
     * @return
     * @throws SolrServerException
     */
    public static QueryResponse solrAdvancedQuery(SolrServer solr,String title,String content,String contentType,String startDate,String endDate) throws Exception {

        StringBuilder advQuery=new StringBuilder();
        if(!title.equals("")){
            advQuery.append("id:"+title+" AND ");
        }
        if(!content.equals("")){
            advQuery.append("attr_content:"+content+" AND ");
        }
        if(!contentType.equals("")){
            advQuery.append("attr_meta:"+contentType);
        }
        //此处有solr的一个问题,text文本文档没有attr_date属性
        if(!contentType.equals("text") && !contentType.equals("*") && !startDate.equals("") && !endDate.equals("")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            advQuery.append(" AND attr_date:["+sdf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate))+" TO "+sdf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate))+"]");
        }
        log.info("查询条件:"+advQuery);

        SolrQuery query=new SolrQuery(String.valueOf(advQuery));
        query.setHighlight(true);
        query.setParam("hl.fl", "attr_content");//高亮显示字段
        query.setHighlightSimplePre("<font color=\'red\'>");//前缀
        query.setHighlightSimplePost("</font>");//后缀
        query.setHighlightFragsize(300);//返回字符数

        QueryResponse rsp=solr.query(query);
        return rsp;
    }

    /**
     * 单字段查询
     * @param solr
     * @param qt
     * @return
     */
    public static QueryResponse solrQuery(SolrServer solr,String qt){

        SolrQuery query=new SolrQuery("attr_content:"+qt);
        query.setHighlight(true);
        query.setParam("hl.fl", "attr_content");//高亮显示字段
        query.setHighlightSimplePre("<font color=\'red\'>");//前缀
        query.setHighlightSimplePost("</font>");//后缀
        query.setHighlightFragsize(200);//返回字符数

        QueryResponse rsp = null;
        try {
            rsp = solr.query(query);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return rsp;
    }

    /**
     * 读取配置文件中的SOLR服务地址和索引文件路径
     * @throws IOException
     */
    public static void loadProperties() throws IOException{
        Properties prop=PropertieHelper.getPropInstance("solr.properties");
        SOLR_URL = prop.getProperty("solrurl");
        FILE_URL = prop.getProperty("fileurl");
        log.info(SOLR_URL + "\n" + FILE_URL);
    }

    /**
     * 初始化solrserver
     * @return
     */
    public static SolrServer initSolrServer(){
        try {
            loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SolrServer solr=new HttpSolrServer(SOLR_URL);
        return solr;
    }

    /**
     * 索引文件路径接口
     * @return
     * @throws IOException
     */
    public static String getFileUrl() throws IOException {
        if(FILE_URL==null){
            loadProperties();
        }
        return FILE_URL;
    }

    /**
     * 文件夹索引
     * @throws Exception
     */
    public static SolrServer indexFilesSolr() throws Exception {
        SolrServer solr=initSolrServer();
        File file=new File(FILE_URL);
        String files[]=file.list();
        for(int i=0;i<files.length;i++){
            indexFileSolr(files[i],FILE_URL+files[i],files[i],solr);
        }
        return solr;
    }


    /**
     * 单文件索引
     * @param id
     * @param fileurl
     * @param filename
     * @param solr
     * @throws Exception
     */
    public static void indexFileSolr(String id,String fileurl,String filename,SolrServer solr) throws Exception
    {
        ContentStreamUpdateRequest up=new ContentStreamUpdateRequest("/update/extract");
        String contenttype=getFileContentType(filename);

        if(!contenttype.equals("othertype"))
        {
            log.error(fileurl);
            File file=new File(fileurl);

            if(file.exists()){
                log.info("create index:" + fileurl);
                up.addFile(file, contenttype);
                up.setParam("literal.id", id);
                up.setParam("uprefix", "attr_");
                up.setParam("fmap.content", "attr_content");
                up.setAction(AbstractUpdateRequest.ACTION.COMMIT, true, true);
                solr.request(up);
                log.info("end index:"+fileurl);
            }else
            {
                log.info("file no exist!");
            }
        }
    }

    /**
     * 根据文件名获取文件的ContentType类型
     * @param filename
     * @return
     */
    public static String getFileContentType(String filename)
    {
        String contentType=null;
        String prefix=filename.substring(filename.lastIndexOf(".")+1);
        if(prefix.equals("xlsx"))
        {
            contentType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }else if(prefix.equals("pdf"))
        {
            contentType="application/pdf";
        }else if(prefix.equals("doc"))
        {
            contentType="application/msword";
        }else if(prefix.equals("txt"))
        {
            contentType="text/plain";
        }else if(prefix.equals("xls"))
        {
            contentType="application/vnd.ms-excel";
        }else if(prefix.equals("docx"))
        {
            contentType="application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        }else if(prefix.equals("ppt"))
        {
            contentType="application/vnd.ms-powerpoint";
        }else if(prefix.equals("pptx"))
        {
            contentType="application/vnd.openxmlformats-officedocument.presentationml.presentation";
        }
        else
        {
            contentType="othertype";
        }
        return contentType;
    }


    /**
     * 返回文件ContentType
     * @param paths
     * @return
     */
    public static String getContentType(String paths)
    {
        Path path = Paths.get(paths);
        String contentType = null;
        try {
            contentType = Files.probeContentType(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("文件类型 : " + contentType);
        return contentType;
    }

}
