package com.o2o.dao;

import com.o2o.pojo.LocalAuth;

public interface LocalAuthMapper {
    int deleteByPrimaryKey(Integer localAuthId);

    int insert(LocalAuth record);

    int insertSelective(LocalAuth record);

    LocalAuth selectByPrimaryKey(Integer localAuthId);

    int updateByPrimaryKeySelective(LocalAuth record);

    int updateByPrimaryKey(LocalAuth record);
}