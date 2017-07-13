package com.scau.service.impl;

import com.scau.dao.UserMapper;
import com.scau.pojo.User;
import com.scau.pojo.UserExample;
import com.scau.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

import java.util.List;


/**
 * Created by zhonghua on 2016/7/10.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User checkUser(User user) {
        //Example不能定义成属性，否则就成为了缓存，下次查询依然还保持上次的结果
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andUserPasswordEqualTo(user.getUserPassword());

        List<User> users=userMapper.selectByExample(userExample);
        if(users.isEmpty()){
            return null;
        }else if(users.size()==1){
            return users.get(0);
        }
        return null;
    }

    @Override
    public int register(User user) {
        //默认权限
        user.setUserAuthority(0);
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User selectById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
    
    @Override
    public String modifyPassword(Integer userId, String userName, String oldPassword, String newPassword){
    	User user = new User();
    	user.setUserId(userId);
    	user.setUserName(userName);
    	user.setUserPassword(oldPassword);
    	
    	if(checkUser(user) != null){
    		user.setUserPassword(newPassword);
    		if(updateSelective(user) > 0){
    			return "ok";
    		}
    		else{
    			return "no";
    		}
    	}
    	else{
    		return "op wrong";
    	}
    }
    
    @Override
    public int updateSelective(User user){
    	return userMapper.updateByPrimaryKeySelective(user);
    }

  //628修改 
  	@Override
  	public List<User> getUserList() {
  		 UserExample userExample = new UserExample();
  	     return userMapper.selectByExample(userExample);
  	}

  	@Override
  	public Integer deleteUser(String username) {
  		
  		return userMapper.deleteByUsername(username);
  	}

}
