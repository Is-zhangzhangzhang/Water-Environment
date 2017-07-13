package com.scau.util;

import org.math.R.RserverConf;
import org.math.R.Rsession;
import org.rosuda.REngine.REXPMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by zhonghua on 2016/8/16.
 */
public class RServeHelper {

    private static Rsession rsession=null;

    /**
     * 利用Rsession初始化RServe
     * @return
     * @throws IOException
     */
    public static Rsession initRserve() throws IOException {
        //Rserve的服务器地址与ssh连接地址相同,直接读取ssh.properties中的内容
        Properties prop = PropertieHelper.getPropInstance("ssh.properties");

        String hostname = prop.getProperty("innerip");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        RserverConf rconf=new RserverConf(hostname,6311,username,password,new Properties());
        rsession = Rsession.newInstanceTry(System.out, rconf);
        return rsession;
    }

    /**
     * 创建Rsession单例
     * @return
     * @throws IOException
     */
    private static Rsession getRsessionInstance() throws IOException {
        if(rsession==null){
            rsession=initRserve();
        }
        return rsession;
    }

    /**
     * 统计缺失数据情况
     * @return
     * @throws Exception
     */
    public static String mdPattern(String filePath) throws Exception{
        getRsessionInstance();
        rsession.eval("library(mice);library(readxl);");
        if(loadFileContent(filePath)){
            return rsession.asHTML("md.pattern(missData)");
        }else{
            return null;
        }
    }

    /**
     * 调用R中的mice包对缺失数据进行填充,返回填充结果
     * 项目部署到ubuntu服务器后方可得到正确的导出文件
     * @param filePath
     * @throws IOException
     */
    public static String mice(String filePath,HttpServletRequest request) throws IOException {
        getRsessionInstance();
        rsession.eval("library(mice);library(readxl);");
        if(loadFileContent(filePath)){
            rsession.eval("tmp <- mice(missData,m=5,maxit=50,meth='pmm',seed=500)");
            String path = request.getSession().getServletContext().getRealPath("/WEB-INF/download/");
            //String downloadPath=path+"\\"+"result.csv";
            //rsession.eval("write.csv(complete(tmp,1),\""+downloadPath+"\")");
            return rsession.asHTML("head(complete(tmp,1),10)");
        }else {
            return null;
        }
    }

    /**
     * 获取填充后数据的前20行
     * @param filePath
     * @return
     * @throws IOException
     * @throws REXPMismatchException
     */
    public static String getDataHead(String filePath) throws IOException, REXPMismatchException {
        getRsessionInstance();
        rsession.eval("library(mice);library(readxl);");
        if(loadFileContent(filePath)){
            return rsession.asHTML("head(missData,10)");
        }else {
            return null;
        }
    }

    /**
     * 载入文件语句,文件路径为上传至服务器的路径
     * 返回语句的原因是不能通过set方法保存读取出的文件，使用数据时需要实时读取数据
     *
     * latest version 2016/09/04
     * 可直接用eval()方法将读出文件保存，直接在语句中写即可，读出文件内容保存在missData变量中
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Boolean loadFileContent(String filePath) throws IOException {
        String contentType=null;
        String prefix=filePath.substring(filePath.lastIndexOf(".")+1);

        if( prefix.equals("xls") || prefix.equals("xlsx") ){
            readXLSFile(filePath);
        }else if(prefix.equals("csv")){
            readCSVFile(filePath);
        }else if(prefix.equals("txt")){
            readTXTFile(filePath);
        }else{
            return false;
        }
        return true;
    }

    /**
     * 读取csv文件
     * @param filePath
     * @throws IOException
     */
    private static void readCSVFile(String filePath) throws IOException {
        getRsessionInstance();
        rsession.eval("missData <- read.csv(\"" + filePath + "\",header=T,na.strings = c(\"NA\"))");
    }

    /**
     * 读取txt文件
     * @param filePath
     * @throws IOException
     */
    private static void readTXTFile(String filePath) throws IOException {
        getRsessionInstance();
        rsession.eval("missData <- read.table(\""+filePath+"\",header=T,na.strings = c(\"NA\"))");
    }

    /**
     * 读取xls文件
     * @param filePath
     * @throws IOException
     */
    private static void readXLSFile(String filePath) throws IOException {
        getRsessionInstance();
        rsession.eval("missData <- read_excel(\"" + filePath+"\",na = (\"NA\"))");
    }


    /**
     * 封装eval()方法
     * @param e
     * @return
     * @throws IOException
     */
    /*
    private static REXP eval(String e) throws IOException {
        rsession=getRsessionInstance();
        REXP m=rsession.eval(e);
        return m;
    }*/

    /**
     * 封装set()方法
     * set方法的e中只能是本地的数据,不能放入字符串,否则该变量存储字符串
     * @param varname
     * @param e
     * @throws IOException
     */
    /*
    private static void set(String varname,Object e) throws IOException {
        rsession=getRsessionInstance();
        rsession.set(varname, e);
    }*/

    /**
     * 封装save()方法
     * @param downloadPath
     * @param varname
     * @throws IOException
     */
    /*
    private static void save(String downloadPath,String varname) throws IOException {
        rsession=getRsessionInstance();
        rsession.save(new File(downloadPath), varname);
    }*/


}
