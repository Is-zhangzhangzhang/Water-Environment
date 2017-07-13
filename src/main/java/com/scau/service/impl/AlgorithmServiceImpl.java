package com.scau.service.impl;

import com.scau.dao.AlgorithmMapper;
import com.scau.pojo.Algorithm;
import com.scau.pojo.AlgorithmExample;
import com.scau.pojo.AlgorithmWithBLOBs;
import com.scau.pojo.Rank;
import com.scau.service.IAlgorithmService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Service("algorithmService")
public class AlgorithmServiceImpl implements IAlgorithmService{

    @Resource
    private AlgorithmMapper algorithmMapper;

    public List<AlgorithmWithBLOBs> getAlgorithmListByClassId(int classId) {

        AlgorithmExample algorithmExample=new AlgorithmExample();
        AlgorithmExample.Criteria criteria=algorithmExample.createCriteria();
        criteria.andClassIdEqualTo(classId);
        List<AlgorithmWithBLOBs> algorithms = algorithmMapper.selectByExampleWithBLOBs(algorithmExample);
        return algorithms;
    }

    public AlgorithmWithBLOBs getAlgorithmTooltipById(int algorithmId) {
        return algorithmMapper.selectByPrimaryKey(algorithmId);
    }

    public int addAlgorithm(AlgorithmWithBLOBs algorithm) throws Exception {
        return algorithmMapper.insert(algorithm);
    }

    public List<Rank> getMonthRank() {
        return algorithmMapper.getMonthRank();
    }

    public List<Rank> getYearRank() {
        return algorithmMapper.getYearRank();
    }

}
