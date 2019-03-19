package com.jju.sshweb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jju.sshweb.model.Product;

public interface ProductService {
	  int deleteByPrimaryKey(Integer pid);

	    int insert(Product record);

	    int insertSelective(Product record);

	    Product selectByPrimaryKey(Integer pid);

	    int updateByPrimaryKeySelective(Product record);

	    int updateByPrimaryKey(Product record);
	    
	    /**
	     * 按照是否热门商品进行查询
	     */
	    List<Product> selectByPrimaryHot(Integer hot);
	    /**
	     * 按照商品类别进行查询
	     */
	    List<Product> selectByPrimaryCsid(Integer csid);
	    /**
	     * 按照商品最近时间进行排序查询
	     */
	    List<Product> selectByPrimaryPdate();
}
