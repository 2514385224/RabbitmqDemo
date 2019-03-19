package com.jju.sshweb.service;

import com.jju.sshweb.model.Orderitem;

public interface OrderitemService {
		int deleteByPrimaryKey(Integer itemid);

	    int insert(Orderitem record);

	    int insertSelective(Orderitem record);

	    Orderitem selectByPrimaryKey(Integer itemid);

	    int updateByPrimaryKeySelective(Orderitem record);

	    int updateByPrimaryKey(Orderitem record);
}
