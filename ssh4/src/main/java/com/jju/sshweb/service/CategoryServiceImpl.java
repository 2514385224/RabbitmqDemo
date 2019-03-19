package com.jju.sshweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jju.sshweb.mapper.CategoryMapper;
import com.jju.sshweb.model.Category;
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Override
	public int deleteByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return categoryMapper.deleteByPrimaryKey(cid);
	}

	@Override
	public int insert(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.insert(record);
	}

	@Override
	public int insertSelective(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.insertSelective(record);
	}

	@Override
	public Category selectByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(cid);
	}

	@Override
	public int updateByPrimaryKeySelective(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.updateByPrimaryKey(record);
	}
	/**
	 * 对所有一级菜单进行查询
	 */
	public List<Category> selectAll()
	{
		return categoryMapper.selectAll();
	}

}
