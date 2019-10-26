package com.o2o.service;

import com.o2o.pojo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
     List<ProductCategory> findProductCategory(Integer shopId);
     int deleteproductCategory(Integer productCategoryid,Integer shopId);
     void batchInsertProductCategory(List<ProductCategory> list);

}
