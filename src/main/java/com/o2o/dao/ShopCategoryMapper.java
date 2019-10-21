package com.o2o.dao;

import com.o2o.pojo.ShopCategory;

import java.util.List;

public interface ShopCategoryMapper {
    int deleteByPrimaryKey(Integer shopCategoryId);

    int insert(ShopCategory record);

    int insertSelective(ShopCategory record);

    ShopCategory selectByPrimaryKey(Integer shopCategoryId);

    int updateByPrimaryKeySelective(ShopCategory record);

    int updateByPrimaryKey(ShopCategory record);

    List<ShopCategory> findParent(ShopCategory shopCategory);
}