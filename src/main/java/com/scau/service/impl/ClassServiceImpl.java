package com.scau.service.impl;

import com.scau.dao.ClassMapper;
import com.scau.pojo.*;
import com.scau.pojo.Class;
import com.scau.service.IClassService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/18.
 */
@Service("classService")
public class ClassServiceImpl implements IClassService {
    @Resource
    private ClassMapper classMapper;

//得到每一个class类和class类下算法的个数
    public List<ClassNumber> getEachClassNum() {
        return classMapper.countClassNum();
    }
//通过主键查找对应的class类
    public Class getClassDetails(int classId) {

        return classMapper.selectByPrimaryKey(classId);
    }
//添加class类
    public int addClass(String className, String classDescribe) throws Exception {
        return classMapper.insert(new Class(className,classDescribe));
    }
	

}
