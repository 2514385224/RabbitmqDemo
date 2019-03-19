package com.jju.sshweb.mapper;

import com.jju.sshweb.model.Orderitem;

public interface OrderitemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    Orderitem selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);
}