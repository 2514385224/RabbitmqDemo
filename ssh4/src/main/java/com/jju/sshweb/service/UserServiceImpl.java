package com.jju.sshweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jju.sshweb.mapper.UserMapper;
import com.jju.sshweb.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Override
	public int deleteByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(uid);
	}
	  /**
     * 按照用户名进行查询
     * @param username
     * @return
     */
    public User selectByPrimaryUserName(String username)
    {
    	return userMapper.selectByPrimaryUserName(username);
    }
    /**
     * 按照姓名进行查询
     */
    public User selectByPrimaryName(String name)
    {
    	return userMapper.selectByPrimaryName(name);
    }
    
    
    /**
     * 按照email进行查询
     */
   public User selectByPrimaryEmail(String email)
   {
	   return userMapper.selectByPrimaryEmail(email);
   }
    /**
     * 按照手机号进行查询
     */
    public User selectByPrimaryPhone(String phone)
    {
    	return userMapper.selectByPrimaryPhone(phone);
    }
	
	
	
	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}
	

}
