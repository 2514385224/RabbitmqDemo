package com.jju.sshweb.mapper;

import com.jju.sshweb.model.User4;

public interface User4Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User4 record);

    int insertSelective(User4 record);

    User4 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User4 record);

    int updateByPrimaryKey(User4 record);
}