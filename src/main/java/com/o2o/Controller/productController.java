package com.o2o.Controller;


import com.o2o.common.ProductImagUpdate;
import com.o2o.pojo.Product;
import com.o2o.pojo.ProductCategory;
import com.o2o.pojo.ProductImg;
import com.o2o.pojo.Shop;
import com.o2o.service.ProductCategoryService;
import com.o2o.service.ProductImgService;
import com.o2o.service.ProductService;
import net.sf.json.JSONObject;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/productmin/")
public class productController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    ProductImgService productImgService;
    @ResponseBody
    @RequestMapping("getproductcategorylist")
    public Map<String,Object> getproductlist(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        List<ProductCategory> list=null;
        try {
            list = productCategoryService.findProductCategory(1);
        }catch (Exception e){
            map.put("success",false);
            map.put("errMsg",e.getMessage());
        }

       map.put("success",true);
        map.put("data", list);
        return  map;

    }
    @RequestMapping("productcategorymanage")
    public String productcategorymanage(){

        return "product/productlcategoryist";
    }
    @RequestMapping("productoperation")  //shopoperation
    public String productcategoryedit(){

        return "product/productedit";
    }
    @RequestMapping("addproductcategorys")
    @ResponseBody
    public Map<String,Object> addproductcategorys(@RequestBody List<ProductCategory> list
         ,  HttpServletRequest request){
        Map<String,Object> map=new HashMap<String, Object>();
        //从session中获取 当前shop（因为product要加在当前的shop下）
       Shop shop = (Shop) request.getSession().getAttribute("cutrentshop");
           if (list!=null&& list.size()>0){
          for (ProductCategory productCategory: list){
             // productCategory.setShopId(shop.getShopId());
              //测试
              productCategory.setShopId(1);
          }
          productCategoryService.batchInsertProductCategory(list);
          map.put("success",true);
          return  map;
      }else {
               map.put("success", false);
               map.put("errMsg","list 为空");
           }

      return map;
    }

    /*
          product文件流的上传，
           product包括： product的缩略图
                         和批量上传的详情图片
     */
    @ResponseBody
    @RequestMapping("addproduct") //添加商品信息
    public Map<String,Object> addproductImags(HttpServletRequest request) {
        //从session中获取shop
        String path = request.getSession().getServletContext().getRealPath("/");
        //校验验证码

        //获取Product的信息  josn转对象
        String productstr = request.getParameter("productStr");
        JSONObject jsonObject = JSONObject.fromObject(productstr);
        Product product = (Product) JSONObject.toBean(jsonObject, Product.class);
        product.setShopId(1); //先默认shopid为1
        //保存缩略图
        //Spring的文件上传
        CommonsMultipartFile shopImg = null;
        //从session的上下文中获取此次的上传流
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.
                getSession().getServletContext());
        //详情图
        List<ProductImagUpdate> list = new ArrayList<ProductImagUpdate>();
        //判断是不是有上传的文件流
        if (commonsMultipartResolver.isMultipart(request)) {
            //将httpServletRequest强转成multipartHttpServletRequest并从中获取文件流
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("thumbnail");//获取缩略图
            for (int i = 0; i < 6; i++) {  //最多支持上传6个文件
                CommonsMultipartFile imge = null;
                imge = (CommonsMultipartFile) multipartHttpServletRequest.getFile("productImg" + i);
                if (imge != null) {
                    //保存
                    ProductImg productImg = new ProductImg();
                    productImg.setProductId(product.getProductId());
                    ProductImagUpdate productImagUpdate = new ProductImagUpdate(productImg, imge);
                    list.add(productImagUpdate);
                }
            }

        }
        //批量保存详情图
        productImgService.insertProudctImgs(list, product, shopImg, path);
        Map map = new HashMap();
        map.put("success", true);
        return map;
    }

  //updateproduct   更新商品
    @RequestMapping("updateproduct")
    @ResponseBody
    public Map<String,Object> updateproduct(HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("/");
        //从session中获取shop


        //获取product 对象
        String productStr = request.getParameter("productStr");
        //保存缩略图
        //Spring的文件上传
        CommonsMultipartFile shopImg = null;
        //从session的上下文中获取此次的上传流
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.
                getSession().getServletContext());
        //详情图
        List<ProductImagUpdate> list = new ArrayList<ProductImagUpdate>();
        JSONObject jsonObject = JSONObject.fromObject(productStr);
        Product product = (Product) JSONObject.toBean(jsonObject, Product.class);
        product.setShopId(1); //先默认shopid为1
        //判断是不是有上传的文件流
        if (commonsMultipartResolver.isMultipart(request)) {
            //将httpServletRequest强转成multipartHttpServletRequest并从中获取文件流
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("thumbnail");//获取缩略图
           for (int i = 0; i < 6; i++) {  //最多支持上传6个文件
                CommonsMultipartFile imges = null;
                imges = (CommonsMultipartFile) multipartHttpServletRequest.getFile("productImg" + i);
                if (imges != null) {
                    //保存
                    ProductImg productImg = new ProductImg();

                    productImg.setProductId(product.getProductId());
                    ProductImagUpdate productImagUpdate = new ProductImagUpdate(productImg, imges);
                    list.add(productImagUpdate);
                }
            }

        }
        //判断是不是有文件
        //调用方法
        productImgService.updateproduct(list, product, shopImg, path);
        Map<String,Object> map = new HashMap();
        map.put("success",true);
        return map;
    }
    @RequestMapping("getproductbyid")
    @ResponseBody
    public  Map<String,Object> getproductbyid(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("productId"));
        Product product=productService.selectproduct(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",true);
        map.put("product",product);
        return map;
    }
     @RequestMapping("getproductlist")
    @ResponseBody
    public Map<String,Object> getproductlist(Integer shopId){
        //获取shopid
         List<Product> list = productService.selectproductlist(shopId);
         Map<String,Object> map = new HashMap<String, Object>();
         map.put("success",true);
         map.put("data",list);
         return map;
     }
     @RequestMapping("productmanage")
    public  String productmanage(){
        return "product/productmanage";
     }

}
