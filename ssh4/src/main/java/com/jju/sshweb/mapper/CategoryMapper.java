package com.jju.sshweb.mapper;

import java.util.List;

import com.jju.sshweb.model.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    /**
     * ��ѯ��Ӵһ���˵�
     */
    List<Category> selectAll(); 
}