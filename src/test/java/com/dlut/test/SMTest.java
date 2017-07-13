package com.dlut.test;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

import com.scau.dao.ClassMapper;
import com.scau.pojo.ClassNumber;
import com.scau.service.IClassService;
import com.scau.service.ICloudService;
import com.scau.service.IUserService;
import com.scau.util.SSHHelper;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.RequestContextListener;


import java.io.IOException;

import java.lang.reflect.Member;
import java.util.List;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

/**
 * Created by zhonghua on 2016/7/10.
 */
public class SMTest {

    private static Logger logger=Logger.getLogger(SMTest.class);

    @Resource
    private IUserService userService;
    @Resource
    private IClassService classService;

    @Resource
    private ClassMapper classMapper;

    @Resource
    private ICloudService cloudService;

    private ServletContext context;
    private HttpServletRequest request;

    @org.junit.Test
    public void test(){

    }

    @Test
    public void testEachClassNum() throws Exception {
        List<ClassNumber> lists=classMapper.countClassNum();
        System.out.println(lists.get(0).toString());
    }

    @Test
    public void testClassDetails(){
        System.out.println(classService.getClassDetails(1));
    }

    @Test
    public void testNodeList(){
        System.out.println(cloudService.getNodeList().toString());
    }

    @Before
    public void before(){
        context = new MockServletContext();
        request = new MockHttpServletRequest(context);
    }

    @Test
    public void testSSH() throws IOException {
       // SSHHelper.ssh(request,"ls");
    }

}
