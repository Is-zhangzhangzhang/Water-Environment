package com.scau.service;

import java.util.List;

import com.scau.pojo.AlgorithmWithBLOBs;
import com.scau.pojo.Rank;

/**
 * Created by zhonghua on 2016/7/18.
 */
public interface IAlgorithmService {

    List<AlgorithmWithBLOBs> getAlgorithmListByClassId(int classId);

    AlgorithmWithBLOBs getAlgorithmTooltipById(int algorithmId);

    int addAlgorithm(AlgorithmWithBLOBs algorithm) throws Exception;

    List<Rank> getMonthRank();

    List<Rank> getYearRank();

}
