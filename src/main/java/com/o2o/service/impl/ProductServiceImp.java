package com.o2o.service.impl;
import com.o2o.dao.ProductMapper;
import com.o2o.pojo.Product;
import com.o2o.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public int insertProudct(Product product) {
        return productMapper.insertSelective(product);
    }

    @Override
    public Product selectproduct(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> selectproductlist(Integer shopId) {
        return productMapper.selectproductList(shopId);
    }
}
