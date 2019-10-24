package com.o2o.common;

import com.o2o.pojo.ProductImg;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

public class ProductImagUpdate {
    public ProductImg productImg;
    public CommonsMultipartFile file;

    public ProductImagUpdate(ProductImg productImg, CommonsMultipartFile file) {
        this.productImg = productImg;
        this.file = file;
    }

    public ProductImg getProductImg() {
        return productImg;
    }

    public CommonsMultipartFile getFile() {
        return file;
    }
}
