package com.dlut.test;

import com.scau.pojo.QueryResult;
import com.scau.util.SolrHelper;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhonghua on 2016/8/2.
 */
public class SolrTest {
    private static Logger log = Logger.getLogger(SolrTest.class);

    public static final String SOLR_URL="http://localhost:8080/solr/core";
    private SolrServer solr=null;


    @Test
    public void getSolrTest() throws Exception{

        String fileName = "D:\\projects\\solr\\home\\docs\\sanguo.txt";
        String solrId = "sanguo.txt";
        solr = new HttpSolrServer(SOLR_URL);

        ContentStreamUpdateRequest up = new ContentStreamUpdateRequest("/update/extract");
        String contentType="text/plain";
        up.addFile(new File(fileName), contentType);
        up.setParam("literal.id", solrId);
        up.setParam("uprefix", "attr_");
        up.setParam("fmap.content", "attr_content");
        up.setAction(AbstractUpdateRequest.ACTION.COMMIT, true, true);

        solr.request(up);

        QueryResponse rsp = solr.query(new SolrQuery("*:*"));
        System.out.println(rsp);
    }

    @Test
    public void solrIndexTest() throws Exception {

//        String fileName = "D:\\projects\\solr\\home\\docs\\basic-info.txt";
//        String solrId = "basic-info.txt";

    //    SolrHelper.indexFileSolr(solrId, fileName, solrId, SOLR_URL);


//        SolrServer solrServer=SolrHelper.initSolrServer();
//        SolrHelper.solrQuery(solrServer,"软件工程 专业");


        QueryResult qr=new QueryResult();
        try {
            SolrServer solr= SolrHelper.initSolrServer();
            QueryResponse rsp=SolrHelper.solrQuery(solr, "*");
            SolrDocumentList list = rsp.getResults();
            Map<String, Map<String, List<String>>> map = rsp.getHighlighting();
            for (SolrDocument doc : list) {

                //qr.setResultTitle(doc.getFieldValue("id").toString());
                //qr.setResultContent(map.get(doc.getFieldValue("id").toString()).toString());

                //log.info(doc);

                log.info(doc.getFieldValue("id").toString());
                log.info(map.get(doc.getFieldValue("id").toString()).get("attr_content"));
                //log.info(doc.getFieldValue("attr_date").toString());
                //System.out.println(map.get(doc.getFieldValue("id").toString()));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FilePathIndex() throws Exception {
        SolrHelper.indexFilesSolr();
    }

    @Test
    public void riqi() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String date="2015-01-01 00:00:00";

        System.out.println(sdf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date)));
    }
}
