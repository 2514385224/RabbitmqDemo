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
     * 按照是否热门商品进行查询
     */
    List<Product> selectByPrimaryHot(@Param("hot")Integer hot);
    /**
     * 按照商品类别进行查询
     */
    List<Product> selectByPrimaryCsid(@Param("csid")Integer csid);
    /**
     * 按照商品最近时间进行排序查询
     */
    List<Product> selectByPrimaryPdate();
    
    
}