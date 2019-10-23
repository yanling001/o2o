package com.o2o.Controller;

import com.google.code.kaptcha.Constants;
import com.o2o.common.ShopMessge;
import com.o2o.pojo.Area;
import com.o2o.pojo.Shop;
import com.o2o.pojo.ShopCategory;
import com.o2o.pojo.vo.ShopVo;
import com.o2o.service.AreaService;
import com.o2o.service.ShopCategoryService;
import com.o2o.service.ShopServcie;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/shopmin/")
public class ShopController {
    @Autowired
    ShopServcie shopServcie;
    @Autowired
    ShopCategoryService shopCategoryService;
    @Autowired
    AreaService areaService;

    @ResponseBody
    @RequestMapping("registershop")
    public Map<String,Object> registershop(Shop shop,HttpServletRequest httpServletRequest){
        Map <String,Object>map =new HashMap<String, Object>();
        //校验二维码
        //获取二维码的值
        //期望的二维码
        String ercodeExpected=(String) httpServletRequest.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
       //前端得到的二维码
        String ercode=(String) httpServletRequest.getAttribute("verifyCodeActual");
        System.out.println(ercode+"   "+ercodeExpected);
        if (!ercode.equals(ercodeExpected)){
            map.put("eroor","验证码错误");
            map.put("success",false);
            return  map;
        }
       //两个信息 商铺类别列表  地域列表
        List<ShopCategory> shopCategoryList=new ArrayList<ShopCategory>();
        List<Area> areaList=new ArrayList<Area>();
        map.put("shopCategoryList",shopCategoryList);
        map.put("areaList",areaList);
        map.put("success",true);
      return map;
    }
    @ResponseBody
    @RequestMapping("init")
    public Map<String,Object> init(){
        System.out.println("---------");
        Map <String,Object>map =new HashMap<String, Object>();
        //两个信息 商铺类别列表  地域列表
        List<ShopCategory> shopCategoryList=shopCategoryService.getParents(new ShopCategory());
        List<Area> areaList=areaService.findAreasList();
        map.put("shopCategoryList",shopCategoryList);
        map.put("areaList",areaList);
        map.put("success",true);
        return map;

    }
    @RequestMapping("insert.action")
    @ResponseBody
    public ShopMessge insert( HttpServletRequest httpServletRequest) {
    System.out.println("insert..........");
      String shopmess =   httpServletRequest.getParameter("shopStr");
      System.out.println(shopmess);
        JSONObject jsonObject=JSONObject.fromObject(shopmess);
        Shop shop= (Shop) JSONObject.toBean(jsonObject,Shop.class);
        shop.setStatus(0);
        shop.setOwnerId(1);
        System.out.println(shop.getAdvice());
        if (shop == null) {
            return ShopMessge.createfail("参数错误");
        }
        String path = httpServletRequest.getSession().getServletContext().getRealPath("/");
        System.out.println(path);
        //获取文件
        //Spring的文件上传
        CommonsMultipartFile shopImg = null;
        //从session的上下文中获取此次的上传流
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(httpServletRequest.
                getSession().getServletContext());
        //判断是不是有上传的文件流
        if (commonsMultipartResolver.isMultipart(httpServletRequest)) {
            //将httpServletRequest强转成multipartHttpServletRequest并从中获取文件流
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("Img");//获取前端的文件shopImg
        } else return ShopMessge.createfail("上传文件不能为空");
        //注册检验
        if (shop == null && shopImg == null) {
            return ShopMessge.createfail("参数错误");
        } else {

            return shopServcie.insert(shop, shopImg,path);

        }

    }
    @RequestMapping("shopoperation")
    public  String shopOperation(){
        return "shop/index";
    }
  /*  public ShopVo findShopVo(Integer shopId){
        Map map=new HashMap();

    }*/
}
