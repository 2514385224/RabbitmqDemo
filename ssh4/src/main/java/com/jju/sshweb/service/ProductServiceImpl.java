package com.jju.sshweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jju.sshweb.mapper.ProductMapper;
import com.jju.sshweb.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productMapper;
	@Override
	public int deleteByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return productMapper.deleteByPrimaryKey(pid);
	}

	@Override
	public int insert(Product record) {
		// TODO Auto-generated method stub
		return productMapper.insert(record);
	}

	@Override
	public int insertSelective(Product record) {
		// TODO Auto-generated method stub
		return productMapper.insertSelective(record);
	}

	@Override
	public Product selectByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public int updateByPrimaryKeySelective(Product record) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Product record) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Product> selectByPrimaryHot(Integer hot) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryHot(hot);
	}

	public List<Product> selectByPrimaryCsid(Integer csid)
	{
		return productMapper.selectByPrimaryCsid(csid);
	}
	 /**
     * 按照商品最近时间进行排序查询
     */
    public List<Product> selectByPrimaryPdate()
    {
    	return productMapper.selectByPrimaryPdate();
    }
	
}
