package com.dlut.test;

/**
 * Created by zhonghua on 2017/3/14.
 */
@FunctionalInterface
public interface LamdaExpr {
    String getStr();
    default int sum(int a,int b){
        return a+b;
    }
}
