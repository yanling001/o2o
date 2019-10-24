package com.o2o.service;

import com.o2o.common.ProductImagUpdate;
import com.o2o.pojo.Product;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.util.List;

public interface ProductImgService {
     void insertProudctImgs(List<ProductImagUpdate> productImglist, Product product,CommonsMultipartFile file, String path);

    int updateproduct(List<ProductImagUpdate> list, Product product, CommonsMultipartFile shopImg, String path);
}
