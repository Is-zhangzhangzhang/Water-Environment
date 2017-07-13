package com.dlut.test;

import com.scau.dao.UserMapper;
import com.scau.pojo.User;
import com.scau.service.IUserService;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhonghua on 2016/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RegisterTest {

    private static Logger logger=Logger.getLogger(SMTest.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private IUserService userService;

    @Test
    public void register(){
        User user=new User();
        user.setUserName("zh");
        user.setUserPassword("zh");
        user.setUserEmail("cszhonghua@yeah.net");

        int result=userService.register(user);
        System.out.println(result);
    }
}
