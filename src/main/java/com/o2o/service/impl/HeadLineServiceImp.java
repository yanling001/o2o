package com.o2o.service.impl;

import com.o2o.dao.LineMapper;
import com.o2o.pojo.Line;
import com.o2o.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("headLineService")
public class HeadLineServiceImp implements HeadLineService {
    @Autowired
    LineMapper lineMapper;
    @Override
    public List<Line> getHeadlinelist() {
        return lineMapper.selectLines();
    }
}
