package productTest;

import Base.BaseTest;
import com.o2o.dao.ProductCategoryMapper;
import com.o2o.pojo.ProductCategory;
import com.o2o.service.ProductCategoryService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class productTest extends BaseTest {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Autowired
    ProductCategoryService productCategoryService;
    @Test
    public  void test2(){
        List<ProductCategory> list =new ArrayList<ProductCategory>();
        ProductCategory productCategory =new ProductCategory();
        productCategory.setProductCategoryName("类被7");
        productCategory.setPriority(0);
        productCategory.setShopId(1);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryName("类别8");
        productCategory1.setShopId(1);
        productCategory1.setPriority(3);
        list.add(productCategory);
        list.add(productCategory1);
       productCategoryMapper.batchInsertProductCategory(list);

    }
    @Ignore
    @Test
    public  void test1(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("类别6");
        productCategory.setShopId(1);
        productCategoryMapper.insertSelective(productCategory);
    }
    @Test
    @Ignore
    public  void test(){
       List<ProductCategory> list = productCategoryService.findProductCategory(1);

       for (ProductCategory productCategory :list){
           System.out.println(productCategory.getProductCategoryName());
       }

    }
}
