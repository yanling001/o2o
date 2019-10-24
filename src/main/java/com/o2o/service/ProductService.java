package com.o2o.service;

import com.o2o.pojo.Product;

import java.util.List;

public interface ProductService {
    int insertProudct(Product product);

    Product selectproduct(int id);

    List<Product> selectproductlist(Integer shopId);
}
