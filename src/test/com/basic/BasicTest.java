package com.basic;

import com.dlut.util.SSHHelper;
import org.junit.Test;

/**
 * Created by Administrator on 2016/8/11.
 */
public class BasicTest {
    @Test
    public void testGetDir(){
       /* String src=getClass().getResource("/").toString();
        System.out.println(src.substring(0,src.lastIndexOf("LandBigData")+12));
        src+="src/main/resources/";*/
        System.out.println(SSHHelper.class.getClass().getResource("/").getPath());
    }
}
