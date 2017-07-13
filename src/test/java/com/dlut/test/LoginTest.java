package com.dlut.test;

import com.scau.dao.UserMapper;
import com.scau.pojo.User;
import com.scau.pojo.UserExample;
import com.scau.service.IUserService;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class LoginTest {

    private static Logger logger=Logger.getLogger(SMTest.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private IUserService userService;
    @org.junit.Test
    public void testCheckUser(){
        User user=new User();
        user.setUserName("zhonghua");
        user.setUserPassword("zhonghua");
        User u=userService.checkUser(user);
        System.out.println(u.toString());
    }

    @Test
    public void testSelect(){
        User user=new User();
        user.setUserName("zhonghua");
        user.setUserPassword("zhonghua");

        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());

        List<User> users=userMapper.selectByExample(userExample);

        System.out.println(users.toString());
    }

}
