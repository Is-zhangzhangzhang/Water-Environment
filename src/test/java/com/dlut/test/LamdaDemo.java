package com.dlut.test;

import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhonghua on 2017/3/14.
 */
public class LamdaDemo {
    @Test
    public void test1(){
        List<String> list= Arrays.asList("a","b","v","d");
        Collections.sort(list,(a,b)->a.compareTo(b));
        System.out.println(list.toString());
    }
    @Test
    public void test2(){
        Converter<String,Integer> converter=Integer::valueOf;
        System.out.println(converter.convert("123456")==123456);
    }
}
