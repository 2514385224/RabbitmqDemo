package com.jju.sshweb.mapper;

import org.apache.ibatis.annotations.Param;

import com.jju.sshweb.model.User;

public interface UserMapper {
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
    User selectByPrimaryUserName(@Param("username")String username);
    /**
     * �����������в�ѯ
     */
    User selectByPrimaryName(@Param("name")String name);
    
    
    /**
     * ����email���в�ѯ
     */
    User selectByPrimaryEmail(@Param("email")String email);
    /**
     * �����ֻ��Ž��в�ѯ
     */
    User selectByPrimaryPhone(@Param("phone")String phone);
}