package com.o2o.Controller;


import com.o2o.pojo.Line;
import com.o2o.pojo.ShopCategory;
import com.o2o.service.HeadLineService;
import com.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/frontend/")
//处理主页的controller
public class MainPageController {
   @Autowired
    HeadLineService headLineService;
   @Autowired
    ShopCategoryService shopCategoryService;
   @RequestMapping("getheadline")
   @ResponseBody
   public Map<String,Object> getHeadline(HttpServletRequest request){
       Map<String,Object> map = new HashMap<String, Object>();
       List<Line> list = headLineService.getHeadlinelist();
       map.put("headlist",list);
       map.put("success",true);
       return map;
}
    @RequestMapping("getfirstshopcategory")
    @ResponseBody
    public Map<String,Object> getfirstshopcategory(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        List<ShopCategory> list = shopCategoryService.getFirstLine(new ShopCategory());
        map.put("shopcategorylist",list);
        map.put("success",true);
        return map;
    }
    @RequestMapping("listmainpageinfo")
    @ResponseBody
    public Map<String,Object> listmainpageinfo(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        List<ShopCategory> list = shopCategoryService.getFirstLine(new ShopCategory());
        List<Line> lineShop =headLineService.getHeadlinelist();
        map.put("shopCategoryList",list);
        map.put("headLineList",lineShop);
        map.put("success",true);
        return map;
    }
    @RequestMapping("mainindex")
    public String getMainidex(){
       return "frontend/first" ;
    }


}
