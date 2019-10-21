package ShopTest;

import Base.BaseTest;
import com.o2o.dao.ShopMapper;
import com.o2o.pojo.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopTest extends BaseTest {
    @Autowired
    private ShopMapper shopMapper;
    @Test
    public void test(){
          Shop shop=new Shop();
          shop.setAreaId(2);
          shop.setOwnerId(1);
          shop.setStatus(0);
          shop.setShopName("xiaozhang");
          shop.setShopPhone("111111");
          shop.setShopAdress("xunyang");

        System.out.println( shopMapper.insert(shop));
    }
}
