package com.scau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scau.service.ICloudService;
import com.scau.service.IRunService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhonghua on 2016/7/20.
 */
@Controller
public class CloudController {

    @Resource
    private ICloudService cloudService;

    @Resource
    private IRunService runService;

    @RequestMapping(value = "/cluster/info",method = RequestMethod.GET)
    public String clusterInfo(Model model){
        model.addAttribute("clusters",cloudService.getClusterInfoById(1));
        return "cloud/clusterinfo";
    }

    @RequestMapping(value = "/node/list",method = RequestMethod.GET)
    public String nodeList(Model model){
        model.addAttribute("nodes",cloudService.getNodeList());
        return "cloud/nodelist";
    }

    @RequestMapping(value = "/node/switch",method = RequestMethod.GET)
    public void nodeOnOff(@RequestParam(value = "ip")String ip,
                                         @RequestParam(value = "cmd")String cmd,
                                         HttpServletResponse response){
        PrintWriter out=null;
        String status=null;
        try {
            if(cmd.trim().equals("on")) {
                runService.startHadoop();
                status="运行中";
            }
            else if(cmd.trim().equals("off")) {
                runService.stopHadoop();
                status="已关闭";
            }
            out=response.getWriter();
            if(cloudService.updateNodeByIp(status,ip))
                out.print("ok");
            else
                out.print("err");

        }catch (IOException e){
            e.printStackTrace();
            out.print("err");
        }finally {
            out.flush();
            out.close();
        }
    }
}
