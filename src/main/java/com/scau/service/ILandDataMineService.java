package com.scau.service;

import java.util.List;

import com.scau.pojo.QueryResult;

/**
 * Created by zhonghua on 2016/8/9.
 */
public interface ILandDataMineService {

    public List<QueryResult> getQueryResults(String qt);

    public List<QueryResult> getdvancedQueryResults(String title,String content,String contentType,String startDate,String endDate);
}
