package ShopTest;

import Base.BaseTest;
import com.o2o.common.ShopMessge;
import com.o2o.dao.ShopMapper;
import com.o2o.pojo.Shop;
import com.o2o.pojo.ShopCategory;
import com.o2o.pojo.vo.ShopVo;
import com.o2o.service.ShopServcie;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopTest extends BaseTest {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    ShopServcie shopServcie;
    @Test
    public void test2(){
        ShopVo shopCondition =new ShopVo();
        ShopMessge shopMessge=shopServcie.getShopList(shopCondition,0,100);
       // map.put("success",true);
        //map.put("shoplist",shopMessge.getShopList());
        for (ShopVo shopVo : shopMessge.getShopList()){
            System.out.println(shopVo.getShopName());
        }
    }
    @Test
    @Ignore
    public void test(){
          Shop shop=new Shop();
          shop.setAreaId(2);
          shop.setOwnerId(1);
          shop.setStatus(0);
          shop.setShopName("xiaozhang");
          shop.setShopPhone("111111");
          shop.setShopAdress("xunyang");

      //    shopMapper.findShopVo(47);
     /*  ShopVo shopVo1=new ShopVo();
        ShopCategory shopCategory=new ShopCategory();
        shopCategory.setShopCategoryId(6);
        shopVo1.setShopCategory(shopCategory);
        System.out.println(shopMapper.findShopListNum(shopVo1));
    List<ShopVo> list = shopMapper.findShopList(shopVo1,0,4);
    for (ShopVo s:list){
        System.out.println(s.getShopCategory().getShopCategoryName()+"   "+s.getShopId());
    }*/

    }
}
