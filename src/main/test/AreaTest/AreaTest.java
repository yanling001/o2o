package AreaTest;

import Base.BaseTest;
import com.o2o.dao.AreaMapper;
import com.o2o.pojo.Area;
import com.o2o.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaTest extends BaseTest {
    @Autowired
    AreaMapper areaMapper;
    @Autowired
    AreaService areaService;
    @Test
    public void  test(){
        Area area = new Area();
        area.setAreaName("樱花广场");
        area.setPriority(0);
        areaMapper.insert(area);
       List<Area>list = areaService.findAreasList();
       for (Area area1: list){
           System.out.println(area1.getAreaName());
       }
    }
}
