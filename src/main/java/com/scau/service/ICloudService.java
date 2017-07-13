package com.scau.service;

import java.util.List;

import com.scau.pojo.Cluster;
import com.scau.pojo.Node;

/**
 * Created by zhonghua on 2016/7/20.
 */
public interface ICloudService {

    public Cluster getClusterInfoById(int clusterId);

    public List<Node> getNodeList();

    public boolean updateNodeByIp(String status,String ip);
}
