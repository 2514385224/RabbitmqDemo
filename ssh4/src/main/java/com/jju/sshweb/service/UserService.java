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
	     * �����û������в�ѯ
	     * @param username
	     * @return
	     */
	    User selectByPrimaryUserName(String username);
	    /**
	     * �����������в�ѯ
	     */
	    User selectByPrimaryName(String name);
	    
	    
	    /**
	     * ����email���в�ѯ
	     */
	    User selectByPrimaryEmail(String email);
	    /**
	     * �����ֻ��Ž��в�ѯ
	     */
	    User selectByPrimaryPhone(String phone);
	    
}
