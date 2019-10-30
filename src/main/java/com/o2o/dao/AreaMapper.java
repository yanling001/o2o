package com.o2o.dao;

import com.o2o.pojo.Area;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);
    List<Area> findAreasList();
    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}
