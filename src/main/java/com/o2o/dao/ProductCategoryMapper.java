package com.o2o.dao;

import com.o2o.pojo.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer productCategoryId);
     List<ProductCategory> findproductcategoryList(Integer shopId);
    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer productCategoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
    void batchInsertProductCategory(List<ProductCategory> list);
    int deleteProductCategory(@Param("productCategoryId") Integer productCategoryId,@Param("shopId") Integer shopId);
}