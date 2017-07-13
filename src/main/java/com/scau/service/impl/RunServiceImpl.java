package com.scau.service.impl;

import com.scau.service.IRunService;
import com.scau.util.SSHHelper;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/8/11.
 */
@Service("runService")
public class RunServiceImpl implements IRunService {
    public void startHadoop() {
        System.out.println("启动Hadoop集群中....");
        SSHHelper.executeOnly("start-all.sh");
    }

    public void stopHadoop() {
        System.out.println("关闭Hadoop集群中....");
        SSHHelper.executeOnly("stop-all.sh");
    }

    public void run(String cmd) {
        SSHHelper.executeCmd(cmd);
    }

    public String getRunLog(){
        return SSHHelper.readStdout();
    }
}
