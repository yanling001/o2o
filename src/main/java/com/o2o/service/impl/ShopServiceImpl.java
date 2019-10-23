package com.o2o.service.impl;

import com.o2o.common.ShopMessge;
import com.o2o.common.enmu.Shopenum;
import com.o2o.dao.ShopMapper;
import com.o2o.pojo.Shop;
import com.o2o.pojo.vo.ShopVo;
import com.o2o.service.ShopServcie;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service("shopService")
public class ShopServiceImpl implements ShopServcie {
    @Autowired
    private ShopMapper shopMapper;
    @Override
    public ShopMessge insert(Shop shop, CommonsMultipartFile shopImg,String path) {
        if (shop==null){
            return  ShopMessge.createSucceful(Shopenum.DEFAULT.getCode(),Shopenum.DEFAULT.getMsg());
        }

          if (shopImg!=null) {
              int i=shopMapper.insert(shop);
              if (i<=0){
                  return  ShopMessge.createfail("数据库操作失败");

              }
              //存储图片
              addShopping(shop, shopImg, path);
          }

            return ShopMessge.createSucceful();
        }

    @Override
    public ShopVo findShopVo(Integer id) {
        return shopMapper.findShopVo(id);
    }

    @Override
    public ShopMessge updateShop(Shop shop, CommonsMultipartFile shopImg, String path) {
        if (shop==null){
            return  ShopMessge.createSucceful(Shopenum.DEFAULT.getCode(),Shopenum.DEFAULT.getMsg());
        }

        if (shopImg!=null){
            //删除旧的图片
            //存储图片
            addShopping(shop,shopImg,path);

        }
        int i=shopMapper.updateByPrimaryKeySelective(shop);
        if (i<=0){
            return  ShopMessge.createfail("数据库操作失败");

        }
        return ShopMessge.createSucceful();
    }

    @Override
    public ShopMessge getShopList(ShopVo shopCondition, int pageIndex, int pageSize) {
        int rowLine;
        if (pageIndex>0)
         rowLine = (pageIndex-1)*pageSize;
        else rowLine=0;
        List<ShopVo> list=shopMapper.findShopList(shopCondition,rowLine,pageSize);
        int shopcount= shopMapper.findShopListNum(shopCondition);
        if (list!=null){
            return ShopMessge.createSucceful(shopcount,list);
        }else return ShopMessge.createfail("没有此信息");

    }


    private void addShopping(Shop shop, CommonsMultipartFile shopImg,String path) {
        //获取文件的路径
        String filepath = path+"/image";
        System.out.println(filepath);
        File file=new File(filepath);
        if (!file.exists()){
            file.setWritable(true);//设置文件可写权限
            file.mkdirs();//mkdirs()与mkdir()的区别前者再上传的时候a/b/c/d 只会上传d。
        }
        //获取文本文件的名称
        String realname = shopImg.getOriginalFilename();
        String last = realname.substring(realname.lastIndexOf("."));
        System.out.println(last);
        String filename = UUID.randomUUID().toString()+"."+last;
        System.out.println(filename);
        File targetfile = new File(file,filename);
        try {
            Thumbnails.of(shopImg.getInputStream()).size(200, 200).outputQuality(0.25f).toFile(targetfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取文件url
        String url = "http://localhost:8080/o2o/"+filename;
        shop.setImg(url);

    }


}
