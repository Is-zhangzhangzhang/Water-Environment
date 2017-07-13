package com.scau.controller;

import com.scau.pojo.User;
import com.scau.service.IUserService;
import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhonghua on 2016/7/14.
 */
@Controller
public class LoginController {

    @Resource
    private IUserService userService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/WaterEnvironment");
    }

    /**
     * 检测用户名与密码
     * 返回1表示成功登录，返回0表示登录失败
     * @return int(1,0)
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public void login(String username, String password, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        User user=new User();
        user.setUserName(username);
        user.setUserPassword(password);

        User checkedUser=this.userService.checkUser(user);

        if(checkedUser == null){
            out.print("no");

        }else{
            request.getSession().setAttribute("user", checkedUser);
            if(checkedUser.getUserAuthority() == 0){
           	 request.getSession().setAttribute("authority", "user");
            }
            else{
           	 request.getSession().setAttribute("authority", "admin");
            }
            //System.out.println("login success:" + checkedUser.toString());
            out.print("yes");
        }
        out.flush();
        out.close();
    }

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String showMain(HttpServletRequest request,Model model){
        User user=(User)request.getSession().getAttribute("user");
        if(user == null){
            return "404";
        }else{
        	// model.addAttribute((new User()));
            model.addAttribute(user);
            return "main";
        }
        //测试时使用
       // model.addAttribute(new User());
       // return "main";
    }

    @RequestMapping(value="/dashboard", method=RequestMethod.GET)
    public String toBashBoard(){
        return "redirect:/class/number";
    }


    @RequestMapping(value="/success",method = RequestMethod.GET)
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
    }

}
