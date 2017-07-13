package com.scau.controller;

import com.scau.pojo.QueryResult;
import com.scau.service.ILandDataMineService;
import com.scau.util.RServeHelper;
import com.scau.util.SolrHelper;

import org.apache.log4j.Logger;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhonghua on 2016/7/21.
 */
@Controller
@RequestMapping("/land")
public class LandDataMineController {

    private static Logger log = Logger.getLogger(LandDataMineController.class);

    @Resource
    private ILandDataMineService landDataMineService;
//在跳转landmore时使用
    @RequestMapping(value = "/text/mine",method = RequestMethod.GET)
    public String textMine(){
        return "land/mine";
    }

//在简单搜索中用到
    @RequestMapping(value = "/text/mine",method = RequestMethod.POST)
    public @ResponseBody ModelAndView textMine(String qt,ModelAndView m) throws IOException {
        List<QueryResult> qrresults=landDataMineService.getQueryResults(qt);
        if(qrresults==null){
            return m;
        }
        m.addObject("fileurl", SolrHelper.getFileUrl());//得到solr.prop配置文件中的fileurl
        m.addObject("queryresults",qrresults);
        m.setViewName("land/queryresult");
        return m;
    }

    @RequestMapping(value = "/text/advmine",method = RequestMethod.POST)
    public @ResponseBody ModelAndView advancedTextMine(String title,String content,String contentType,String startDate,String endDate,ModelAndView m) throws IOException {
        System.out.println(title+"\n"+content+"\n"+contentType+"\n"+startDate+"\n"+endDate);
        List<QueryResult> qrresults=landDataMineService.getdvancedQueryResults(title, content, contentType, startDate, endDate);
        if(qrresults==null){
            return m;
        }
        m.addObject("fileurl", SolrHelper.getFileUrl());
        m.addObject("queryresults",qrresults);
        m.setViewName("land/queryresult");
        return m;
    }

    /**
     * 测试时使用ubuntu服务器中的文件
     * 项目部署在ubuntu服务器后，可直接读取上传的文件
     * @param m
     * @param request
     * @return
     */
    @RequestMapping(value = "/data/imputation",method = RequestMethod.POST)
    public @ResponseBody ModelAndView dataImputation(ModelAndView m,HttpServletRequest request){
        //String filePath=(String)request.getSession().getAttribute("uploadfile");
        String filePath="/home/slave/MongoDB/sample.csv";
        try {
            m.addObject("dataHead", RServeHelper.getDataHead(filePath));
            m.addObject("mdPattern", RServeHelper.mdPattern(filePath));
            m.addObject("miceResult",RServeHelper.mice(filePath,request));
        }catch (Exception e){
            m.addObject("exception","yes");
            e.printStackTrace();
            return m;
        }
        m.setViewName("land/miceresult");
        return m;
    }

    @RequestMapping(value = "/data/imputation",method = RequestMethod.GET)
    public String dataImputation(Model model){
        return "land/imputation";
    }

    @RequestMapping(value = "/data/transfer",method = RequestMethod.GET)
    public String dataTransfer(Model model){
        return "land/transfer";
    }
}
