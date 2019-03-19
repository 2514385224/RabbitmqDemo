package com.jju.sshweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jju.sshweb.mapper.CategorysecondMapper;
import com.jju.sshweb.model.Categorysecond;

@Service("categorySecondService")
public class CategorySecondServiceImpl implements CategorySecondService{

	@Autowired
	private CategorysecondMapper categorysecondMapper;
	@Override
	public int deleteByPrimaryKey(Integer csid) {
		// TODO Auto-generated method stub
		return categorysecondMapper.deleteByPrimaryKey(csid);
	}

	@Override
	public int insert(Categorysecond record) {
		// TODO Auto-generated method stub
		return categorysecondMapper.insert(record);
	}

	@Override
	public int insertSelective(Categorysecond record) {
		// TODO Auto-generated method stub
		return categorysecondMapper.insertSelective(record);
	}

	@Override
	public Categorysecond selectByPrimaryKey(Integer csid) {
		// TODO Auto-generated method stub
		return categorysecondMapper.selectByPrimaryKey(csid);
	}

	@Override
	public int updateByPrimaryKeySelective(Categorysecond record) {
		// TODO Auto-generated method stub
		return categorysecondMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Categorysecond record) {
		// TODO Auto-generated method stub
		return categorysecondMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Categorysecond> selectByPrimaryCid(Integer cid) {
		// TODO Auto-generated method stub
		return categorysecondMapper.selectByPrimaryCid(cid);
	}

}
