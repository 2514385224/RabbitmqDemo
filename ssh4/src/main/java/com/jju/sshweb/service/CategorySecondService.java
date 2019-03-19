package com.jju.sshweb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jju.sshweb.model.Categorysecond;

public interface CategorySecondService {
		int deleteByPrimaryKey(Integer csid);

	    int insert(Categorysecond record);

	    int insertSelective(Categorysecond record);

	    Categorysecond selectByPrimaryKey(Integer csid);

	    int updateByPrimaryKeySelective(Categorysecond record);

	    int updateByPrimaryKey(Categorysecond record);
	    
	    /**
	     * 根据一级分类信息查询二级分类信息 cid
	     */
	    List<Categorysecond> selectByPrimaryCid(Integer cid);
}
