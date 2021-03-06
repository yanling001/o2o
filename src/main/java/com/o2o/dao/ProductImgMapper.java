package com.o2o.dao;

import com.o2o.pojo.ProductImg;

import java.util.List;

public interface ProductImgMapper {
    int deleteByPrimaryKey(Integer productImgId);

    int insert(ProductImg record);

    int insertSelective(ProductImg record);

    ProductImg selectByPrimaryKey(Integer productImgId);

    int updateByPrimaryKeySelective(ProductImg record);

    int updateByPrimaryKey(ProductImg record);
    int insetProductImgs(List<ProductImg> list);
}