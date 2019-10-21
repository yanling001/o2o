package com.o2o.Controller;

import com.o2o.common.ShopMessge;
import com.o2o.pojo.Shop;
import com.o2o.service.ShopServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/shopmin/")
public class ShopController {
    @Autowired
    ShopServcie shopServcie;
    @RequestMapping("insert.action")
    @ResponseBody
    public ShopMessge insert(Shop shop, HttpServletRequest httpServletRequest) {

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
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");//获取前端的文件shopImg
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
}
