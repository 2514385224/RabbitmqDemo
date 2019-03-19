package com.jju.sshweb.service;

import com.jju.sshweb.model.Adminuser;

public interface AdminuserService {
	int deleteByPrimaryKey(Integer uid);

    int insert(Adminuser record);

    int insertSelective(Adminuser record);

    Adminuser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Adminuser record);

    int updateByPrimaryKey(Adminuser record);
}
