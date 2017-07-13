package com.scau.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scau.service.IFileService;
import com.scau.util.SSHHelper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhonghua on 2016/7/20.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static Logger logger=Logger.getLogger(FileController.class);

    @RequestMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response,Model model) {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        String fileName=file.getOriginalFilename();
        System.out.println("upload to "+path+"\\"+fileName);

        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("uploadfile",path+"\\"+fileName);

        PrintWriter out= null;
         try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print("{\"result\":\"upload success\"}");
        String[] file1 = new String[1];
        file1[0] = path+"\\"+fileName;
        SSHHelper.uploadFilesToRemote(file1, "/home/hadoop/tmp");
        System.out.println("cmd:"+"hdfs dfs -put /home/hadoop/tmp/"+fileName+" /tmp");
        try {
			SSHHelper.ssh("hdfs dfs -put /home/hadoop/tmp/"+fileName+" /tmp");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
        out.flush();
        out.close();
    }

    /**
     * 检测上传文件状态和类型
     * 此部分后期可扩展，加入对数据的合法性（约束）检测，现在是后缀名对即有效
     * @param request
     * @throws IOException
     */
    
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public @ResponseBody Map<String,String> checkFile(HttpServletRequest request) throws IOException {
        String filePath=(String)request.getSession().getAttribute("uploadfile");
        System.out.println(filePath);
        //判断是否为可导入的文件类型
        Boolean fileValidation=false;
        if(filePath!=null){
            String prefix=filePath.substring(filePath.lastIndexOf(".")+1);
            fileValidation=prefix.equals("txt")||prefix.equals("xls")||prefix.equals("xlsx")||prefix.equals("csv");
            System.out.println(fileValidation);
        }
        Map<String,String> m=new HashMap<String, String>();
        if(filePath!=null && fileValidation){
            m.put("result","existfile");
        }else if(filePath==null){
            m.put("result", "nofile");
        }else if(filePath!=null && !fileValidation){
            m.put("result", "badfile");
        }
        return m;
    }

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(String fileName,HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/download/");
        FileInputStream fis=new FileInputStream(path+"\\"+fileName);
        System.out.println("download path:"+path+"\\"+fileName);
        OutputStream out=response.getOutputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        while((len=fis.read(buffer))>0){
            out.write(buffer,0,len);
        }
        fis.close();
        out.close();

    }

}
