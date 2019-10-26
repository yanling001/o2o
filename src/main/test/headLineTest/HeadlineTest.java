package headLineTest;

import Base.BaseTest;
import com.o2o.dao.LineMapper;
import com.o2o.pojo.Line;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class HeadlineTest extends BaseTest {
    @Autowired
    LineMapper lineMapper;
    @Test
    public void test(){
        Line line=new Line();
        line.setLineImg(" http://localhost:8080/o2o/9f885c14-91c2-4fd4-b1f3-ade8c808706a..jpg");
        line.setLineName("二手车");
        line.setLineLink("http:baidu.com");
        lineMapper.insertSelective(line);
    }
}
