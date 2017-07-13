package com.scau.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhonghua on 2016/7/19.
 */
@Controller
public class ExceptionController {

    @RequestMapping("404")
    public String fourOFour(){
        return "404";
    }

    @RequestMapping("500")
    public String fiveOO(){
        return "500";
    }

    @RequestMapping("401")
    public String fourOOne(){
        return "401";
    }
}
