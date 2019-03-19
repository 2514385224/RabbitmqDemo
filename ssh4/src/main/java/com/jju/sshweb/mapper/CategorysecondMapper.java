package com.jju.sshweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jju.sshweb.model.Categorysecond;

public interface CategorysecondMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(Categorysecond record);

    int insertSelective(Categorysecond record);

    Categorysecond selectByPrimaryKey(Integer csid);

    int updateByPrimaryKeySelective(Categorysecond record);

    int updateByPrimaryKey(Categorysecond record);
    
    /**
     * ����һ��������Ϣ��ѯ����������Ϣ cid
     */
    List<Categorysecond> selectByPrimaryCid(@Param("cid")Integer cid);
    
}