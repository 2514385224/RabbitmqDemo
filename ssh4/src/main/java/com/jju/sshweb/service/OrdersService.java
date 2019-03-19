package com.jju.sshweb.service;

import com.jju.sshweb.model.Orders;

public interface OrdersService {
	  int deleteByPrimaryKey(Integer oid);

	    int insert(Orders record);

	    int insertSelective(Orders record);

	    Orders selectByPrimaryKey(Integer oid);

	    int updateByPrimaryKeySelective(Orders record);

	    int updateByPrimaryKey(Orders record);
}
