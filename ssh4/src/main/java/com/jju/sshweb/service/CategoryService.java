package com.jju.sshweb.service;

import java.util.List;

import com.jju.sshweb.model.Category;

public interface CategoryService {
		int deleteByPrimaryKey(Integer cid);

	    int insert(Category record);

	    int insertSelective(Category record);

	    Category selectByPrimaryKey(Integer cid);

	    int updateByPrimaryKeySelective(Category record);

	    int updateByPrimaryKey(Category record);
	    /**
	     * ������һ���˵����в�ѯ
	     */
	    List<Category> selectAll();
}
