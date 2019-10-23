package com.o2o.dao;

import com.o2o.pojo.Shop;
import com.o2o.pojo.vo.ShopVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    int insertSelective(Shop record);
    int findShopListNum(@Param("shopCondition") ShopVo shopCondition);
    /*
      分页查询：条件查询：店铺名，店铺状态，店铺类别，区域，owner
     */
    List<ShopVo>  findShopList(@Param("shopCondition") ShopVo shopCondition,@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize);
    Shop selectByPrimaryKey(Integer shopId);
    ShopVo findShopVo(Integer id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}