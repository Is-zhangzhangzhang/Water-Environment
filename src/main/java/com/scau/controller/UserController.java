package com.scau.controller;

import com.scau.pojo.Rank;
import com.scau.pojo.User;
import com.scau.service.IAlgorithmService;
import com.scau.service.IUserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;







import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by zhonghua on 2016/7/17.
 */

@Controller
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private IAlgorithmService algorithmService;

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, Model model){
        System.out.println(user.toString());
        userService.register(user);
        model.addAttribute("result","yes");
        return "success";

    }

//    @RequestMapping(value="/ranking",method = RequestMethod.GET)
//    public String getRanking(){
//        return "rankpage";
//    }

    @RequestMapping(value = "/ranking",method = RequestMethod.GET)
    public @ResponseBody ModelAndView getMonthRank(ModelAndView m){
        List<Rank> monthRank = algorithmService.getMonthRank();
        List<Rank> yearRank = algorithmService.getYearRank();

        m.addObject("month",monthRank);
        m.addObject("year",yearRank);
        m.setViewName("rankpage");
        return m;
    }

//    @RequestMapping(value="/update",method = RequestMethod.POST)
//    public @ResponseBody ModelAndView updateUserInfo(@ModelAttribute("user") User user, ModelAndView m){
//        userService.update(user);
//        m.addObject("result","yes");
//        m.setViewName("list");
//        return m;
//    }
    
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public @ResponseBody String update(User user, HttpSession session){
    	
    	User sessionUser = (User)session.getAttribute("user");
    	if(sessionUser != null && sessionUser.getUserId() != null && sessionUser.getUserName() != null){
   			user.setUserId(sessionUser.getUserId());
    		user.setUserName(sessionUser.getUserName());
   			
   			if(userService.updateSelective(user) > 0){
   				return "ok";
   			}
    		else{
    			return "no";
    		}
    	}
    	else{
    		return "no user";
    	}
    }
    
    @RequestMapping(value = "/user/modifyPassword", method = RequestMethod.POST)
    public @ResponseBody String modifyPassword(String oldPassword, String newPassword, HttpSession session){
    	System.out.println("/user/modifyPassword");
    	User sessionUser = (User)session.getAttribute("user");
    	if(sessionUser != null && sessionUser.getUserId() != null && sessionUser.getUserName() != null){
    		return userService.modifyPassword(sessionUser.getUserId(), sessionUser.getUserName(), oldPassword, newPassword);
    	}
    	else{
    		return "no user";
    	}
    }

    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    public ModelAndView getUserInfo(HttpServletRequest request, ModelAndView m){
        User sessionUser=(User)request.getSession().getAttribute("user");
        User updateUser= userService.selectById(sessionUser.getUserId());
        m.addObject("user",updateUser);
        return m;
    }
  //628修改 
    @RequestMapping(value = "/user/list",method = RequestMethod.GET)
    public String getUserList( Model model){
    	model.addAttribute("users",userService.getUserList());
        return "user/list";
    }
    //628修改 
    @RequestMapping(value = "/user/delete",method = RequestMethod.GET)
    public void deleteUser(@RequestParam(value = "username")String username,HttpServletResponse response){
    	PrintWriter out=null;
        try {
			out=response.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
    	try{
            if(userService.deleteUser(username)!=0)
                out.print("ok");
            else
                out.print("err");

        }finally {
            out.flush();
            out.close();
        }
}
}
