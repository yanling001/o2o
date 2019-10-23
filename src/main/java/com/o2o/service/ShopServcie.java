package com.o2o.service;

import com.o2o.common.ShopMessge;
import com.o2o.pojo.Shop;
import com.o2o.pojo.vo.ShopVo;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.List;

public interface ShopServcie {
     ShopMessge insert(Shop shop, CommonsMultipartFile shopImg,String path);
     ShopVo findShopVo(Integer id);
     ShopMessge updateShop(Shop shop, CommonsMultipartFile shopImg,String path);
     ShopMessge getShopList( ShopVo shopCondition, int pageIndex,int pageSize);
}
