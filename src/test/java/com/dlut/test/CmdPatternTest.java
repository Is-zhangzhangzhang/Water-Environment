package com.dlut.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhonghua on 2016/12/20.
 */
public class CmdPatternTest {
    private static Logger log = Logger.getLogger(CmdPatternTest.class);

    @Test
    public void exe(){
        String cmdRegex="\\s*kmeans\\s*(\\s*(-i|-c|-o|-k|-dm|-x|-cd|-ow|-cl|-xm)){0,10}";
        String cmd="               kmeans   ";
        Pattern p=Pattern.compile(cmdRegex);
        Matcher m=p.matcher(cmd);
        if (m.matches()){
            System.out.println("success");
        }else{
            System.out.println("please again");
        }
    }
}
