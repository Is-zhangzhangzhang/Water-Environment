package com.scau.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/8/11.
 */
public interface IRunService {
    public void startHadoop();
    public void stopHadoop();
    public void run(String cmd);
}
