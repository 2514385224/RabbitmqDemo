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
	     * �����Ƿ�������Ʒ���в�ѯ
	     */
	    List<Product> selectByPrimaryHot(Integer hot);
	    /**
	     * ������Ʒ�����в�ѯ
	     */
	    List<Product> selectByPrimaryCsid(Integer csid);
	    /**
	     * ������Ʒ���ʱ����������ѯ
	     */
	    List<Product> selectByPrimaryPdate();
}
