package com.jju.sshweb.mapper;

import com.jju.sshweb.model.Adminuser;

public interface AdminuserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Adminuser record);

    int insertSelective(Adminuser record);

    Adminuser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Adminuser record);

    int updateByPrimaryKey(Adminuser record);
}