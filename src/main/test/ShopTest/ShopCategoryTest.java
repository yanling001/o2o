package ShopTest;

import Base.BaseTest;
import com.o2o.dao.ShopCategoryMapper;
import com.o2o.pojo.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryTest extends BaseTest {
    @Autowired
    ShopCategoryMapper shopCategoryMapper;
    @Test
    public void mytest()
    {
        ShopCategory shopCategory=new ShopCategory();
        shopCategory.setShopCategoryName("可乐");
        shopCategory.setShopCategoryPriorty(0);
        shopCategoryMapper.insert(shopCategory);
       List<ShopCategory>list= shopCategoryMapper.findParent(new ShopCategory());
       for (ShopCategory shopCategory1:list){
           System.out.println(shopCategory1.getShopCategoryName());
       }
    }
}
