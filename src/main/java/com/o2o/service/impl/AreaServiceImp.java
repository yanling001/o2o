package com.o2o.service.impl;

import com.o2o.dao.AreaMapper;
import com.o2o.pojo.Area;
import com.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImp implements AreaService {
    @Autowired
    AreaMapper areaMapper;
    @Override
    public List<Area> findAreasList() {
        return    areaMapper.findAreasList();
    }
}
