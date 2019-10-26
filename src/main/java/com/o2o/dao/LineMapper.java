package com.o2o.dao;

import com.o2o.pojo.Line;

import java.util.List;

public interface LineMapper {
    int deleteByPrimaryKey(Integer lineId);

    int insert(Line record);

    int insertSelective(Line record);

    Line selectByPrimaryKey(Integer lineId);

    int updateByPrimaryKeySelective(Line record);

    int updateByPrimaryKey(Line record);

    List<Line> selectLines();
}