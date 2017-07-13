package com.scau.service.impl;

import com.scau.dao.ClusterMapper;
import com.scau.dao.NodeMapper;
import com.scau.pojo.Cluster;
import com.scau.pojo.Node;
import com.scau.pojo.NodeExample;
import com.scau.service.ICloudService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/20.
 */
@Service("cloudService")
public class CloudServiceImpl implements ICloudService {

    @Resource
    private ClusterMapper clusterMapper;
    @Resource
    private NodeMapper nodeMapper;

    public Cluster getClusterInfoById(int clusterId) {
        return clusterMapper.selectByPrimaryKey(clusterId);
    }

    public List<Node> getNodeList() {
        NodeExample nodeExample = new NodeExample();
        return nodeMapper.selectByExample(nodeExample);
    }

    public boolean updateNodeByIp(String status,String ip){
        NodeExample nodeExample=new NodeExample();
        nodeExample.createCriteria().andNodeIpLike(ip);
        Node node=nodeMapper.selectByExample(nodeExample).get(0);
        node.setNodeStatus(status);
        if(nodeMapper.updateByPrimaryKey(node)==1){
            return true;
        }
        return false;
    }
}
