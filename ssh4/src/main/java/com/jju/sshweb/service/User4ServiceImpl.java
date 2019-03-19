package com.jju.sshweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jju.sshweb.mapper.User4Mapper;
import com.jju.sshweb.model.User4;

@Service("user4Service")
public class User4ServiceImpl implements User4Service{
	@Autowired
	private User4Mapper user4Mapper;
	@Override
	public User4 selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return user4Mapper.selectByPrimaryKey(id);
	}

}
