package com.o2o.service.impl;

import com.o2o.dao.ProductCategoryMapper;
import com.o2o.pojo.ProductCategory;
import com.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productCategoryService")
public class ProductCategoryImp implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Override
    public List<ProductCategory> findProductCategory(Integer shopId) {
        return productCategoryMapper.findproductcategoryList(shopId);
    }

    @Override
    public int deleteproductCategory(Integer productCategoryid, Integer shopId) {
        return productCategoryMapper.deleteProductCategory(productCategoryid,shopId);
    }

    @Override
    public void batchInsertProductCategory(List<ProductCategory> list) {
        productCategoryMapper.batchInsertProductCategory(list);
    }
}
