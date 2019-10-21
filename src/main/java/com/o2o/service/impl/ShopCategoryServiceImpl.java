package com.o2o.service.impl;

import com.o2o.dao.ShopCategoryMapper;
import com.o2o.pojo.ShopCategory;
import com.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopCategoryService")
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    ShopCategoryMapper shopCategoryMapper;
    @Override
    public List<ShopCategory> getParents(ShopCategory shopCategory) {
        return shopCategoryMapper.findParent(shopCategory);
    }
}
