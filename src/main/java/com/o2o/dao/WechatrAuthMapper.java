package com.o2o.dao;

import com.o2o.pojo.WechatrAuth;

public interface WechatrAuthMapper {
    int deleteByPrimaryKey(Integer wechatAuthId);

    int insert(WechatrAuth record);

    int insertSelective(WechatrAuth record);

    WechatrAuth selectByPrimaryKey(Integer wechatAuthId);

    int updateByPrimaryKeySelective(WechatrAuth record);

    int updateByPrimaryKey(WechatrAuth record);
}