package com.jju.sshweb.mapper;

import com.jju.sshweb.model.Student3;

public interface Student3Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student3 record);

    int insertSelective(Student3 record);

    Student3 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student3 record);

    int updateByPrimaryKey(Student3 record);
}