package com.o2o.service;

import com.o2o.common.ShopMessge;
import com.o2o.pojo.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

public interface ShopServcie {
     ShopMessge insert(Shop shop, CommonsMultipartFile shopImg,String path);
}
