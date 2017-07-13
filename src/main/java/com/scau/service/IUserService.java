package com.scau.service;

import java.util.List;

import com.scau.pojo.User;


/**
 * Created by zhonghua on 2016/7/10.
 */
public interface IUserService {

    public User checkUser(User user);

    public int register(User user);

    public int update(User user);

    public User selectById(int userId);
    
    public String modifyPassword(Integer userId, String userName, String oldPassword, String newPassword);
    
    public int updateSelective(User user);
    
    //628修改 
   	public List<User> getUserList();
   	//628修改 
   	public Integer deleteUser(String username);

}
