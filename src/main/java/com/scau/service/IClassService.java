package com.scau.service;

import java.util.List;

import com.scau.pojo.*;

/**
 * Created by zhonghua on 2016/7/18.
 */
public interface IClassService {
    /**
     * 获取每一类数目
     * @return
     */
    public List<ClassNumber> getEachClassNum();

    /**
     * 获取类详情
     * @param classId
     * @return
     */
    public com.scau.pojo.Class getClassDetails(int classId);

    public int addClass(String className,String classDescribe) throws Exception;
}
