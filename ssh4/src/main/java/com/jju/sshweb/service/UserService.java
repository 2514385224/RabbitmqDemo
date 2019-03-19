package com.jju.sshweb.service;

import org.apache.ibatis.annotations.Param;

import com.jju.sshweb.model.User;

public interface UserService {
	   int deleteByPrimaryKey(Integer uid);

	    int insert(User record);

	    int insertSelective(User record);

	    User selectByPrimaryKey(Integer uid);

	    int updateByPrimaryKeySelective(User record);

	    int updateByPrimaryKey(User record);
	    
	    /**
	     * 按照用户名进行查询
	     * @param username
	     * @return
	     */
	    User selectByPrimaryUserName(String username);
	    /**
	     * 按照姓名进行查询
	     */
	    User selectByPrimaryName(String name);
	    
	    
	    /**
	     * 按照email进行查询
	     */
	    User selectByPrimaryEmail(String email);
	    /**
	     * 按照手机号进行查询
	     */
	    User selectByPrimaryPhone(String phone);
	    
}
