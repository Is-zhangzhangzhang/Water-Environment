package com.dlut.test;

import org.junit.Test;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 * Created by zhonghua on 2016/8/16.
 */
public class DataImputionTest {

    @Test
    public void rtest(){
        try {
            RConnection c = new RConnection();// make a new local connection on default port (6311)
            double d[] = c.eval("rnorm(10)").asDoubles();
            org.rosuda.REngine.REXP x0 = c.eval("data(Insurance)");
            System.out.println(x0.asString());
        } catch (Exception e) {
            //manipulation
            e.printStackTrace();
        }


    }
}
