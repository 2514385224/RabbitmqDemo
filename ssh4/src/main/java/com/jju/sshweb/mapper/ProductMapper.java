package com.jju.sshweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jju.sshweb.model.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    /**
     * �����Ƿ�������Ʒ���в�ѯ
     */
    List<Product> selectByPrimaryHot(@Param("hot")Integer hot);
    /**
     * ������Ʒ�����в�ѯ
     */
    List<Product> selectByPrimaryCsid(@Param("csid")Integer csid);
    /**
     * ������Ʒ���ʱ����������ѯ
     */
    List<Product> selectByPrimaryPdate();
    
    
}