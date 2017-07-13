package com.scau.controller;

import com.alibaba.fastjson.JSON;
import com.scau.pojo.AlgorithmWithBLOBs;
import com.scau.pojo.Class;
import com.scau.pojo.Rank;
import com.scau.pojo.User;
import com.scau.service.IAlgorithmService;
import com.scau.service.IClassService;
import com.scau.util.SSHHelper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Controller
@RequestMapping("/algorithm")
public class AlgorithmController {

    @Resource
    private IAlgorithmService algorithmService;
    @Resource
    private IClassService classService;

    /**
     * 列出某类算法列表
     * @param id
     * @param response
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(int id, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
    	 //Spring MVC会自动实例化一个Model对象用于向视图中传值
    	//得到对应classId的Class 类
        Class cs=classService.getClassDetails(id);
        //找到对应classId的AlgorithmWithBLOBs类
        List<AlgorithmWithBLOBs> algorithms=algorithmService.getAlgorithmListByClassId(id);
        model.addAttribute("cls", cs);
        model.addAttribute("algorithms", algorithms);
        return "algorithm/list";
    }

    /**
     * 算法详情页数据显示
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/tooltip",method = RequestMethod.GET)
    public String tooltip(int id,Model model){
        model.addAttribute("algorithm",algorithmService.getAlgorithmTooltipById(id));
        return "algorithm/tooltip";
    }

    /**
     * 检测上传文件状态，如果判断没有文件，返回前端command无法执行
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public void checkFile(String command,HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        String fileStatus=(String)request.getSession().getAttribute("uploadfile");
        System.out.println(fileStatus);
        Map<String,Object> map=new HashMap<String, Object>();

    /*    String cmdRegex="\\s*kmeans\\s*(\\s*(-i|-c|-o|-k|-dm|-x|-cd|-ow|-cl|-xm)\\s*(\\w)+){0,10}";
        Pattern p=Pattern.compile(cmdRegex);
        Matcher m=p.matcher(command);

        if(fileStatus!=null && m.matches()){
            map.put("result","bothyes");
        }else if(fileStatus!=null && !m.matches()){
            map.put("result","nomatch");
        }else if(fileStatus==null && m.matches()){
            map.put("result", "nofile");
        }else if(fileStatus==null && !m.matches()){
            map.put("result","bothno");
        }
*/
        map.put("result","bothyes");
        String json= JSON.toJSONString(map);
        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 接收前端ajax.post的command请求,建立ssh的connection与session连接
     * 如果改进该方法，规范从数据库读取command命令
     * @param command
     * @throws IOException
     */
    @Deprecated
    @RequestMapping(value = "/execute",method = RequestMethod.POST)
    public void execute(String command,PrintWriter out) throws IOException {
        /**
         * 这块还需进一步细化，规范从数据库读取command命令
         */
        SSHHelper.ssh(command);
    }

    /**
     * 前端ajax.get轮询请求,获取实时log返回前端
     * 如果返回为null，前端判断停止
     * 该方法为重载方法，主要负责ajax的轮询请求
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/execute",method = RequestMethod.GET)
    public void execute(HttpServletResponse response) throws IOException {
        System.out.println("**********************************************************");
        PrintWriter out=response.getWriter();
        /*
         *获取实时log,如果为空返回前端null，停止发送请求
         */
       
        String logs=SSHHelper.getLogs();
        if(logs==null){
            out.print("null");
            SSHHelper.close();
        }else{
            /*
             *返回日志字符串截取，输出有效内容
             */
            if(logs.contains("Welcome to Ubuntu 15.04") && logs.contains("slave@master:~$")){
                int sIndex=logs.indexOf("slave@master:~$");
                int len=logs.length();
                logs=logs.substring(sIndex,len);
                /*替换部分无意义内容*/
                logs=logs.replace("slave@master:~$","");
            }
            System.out.println("logs:"+logs);
            out.print(logs.trim());
        }
        out.flush();
        out.close();
    }

    /**
     * 添加算法，ajax传JSON数据请求
     * 绑定pojo实体AlgorithmWithBLOBs
     * @param algorithm
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public Map<String,String> addAlgorithm(@RequestBody AlgorithmWithBLOBs algorithm, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        algorithm.setAlgorithmAuthor(user.getUserName());
        algorithm.setAlgorithmTime(new Date());

        Map<String,String> map=new HashMap<String, String>();
        boolean existNull=false;
        try {
            for (Field f : algorithm.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(algorithm) == null && f.getName() != "algorithmId") {
                    existNull = true;
                }
            }
            int insertFlag=algorithmService.addAlgorithm(algorithm);
            if (!existNull && insertFlag==1) {
                map.put("addStatus","success");
            } else {
                map.put("addStatus", "failed");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("addStatus", "failed");
        }
        return map;
    }

}
