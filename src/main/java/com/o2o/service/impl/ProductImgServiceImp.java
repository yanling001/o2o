package com.o2o.service.impl;

import com.o2o.common.ProductImagUpdate;
import com.o2o.dao.ProductImgMapper;
import com.o2o.dao.ProductMapper;
import com.o2o.pojo.Product;
import com.o2o.pojo.ProductImg;
import com.o2o.service.ProductImgService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service("productImgService")
public class ProductImgServiceImp implements ProductImgService {
    @Autowired
    ProductImgMapper productImgMapper;
    @Autowired
    ProductMapper productMapper;

    @Override
    public void insertProudctImgs(List<ProductImagUpdate> productImglist,Product product,CommonsMultipartFile file, String path) {
        List<ProductImg> productImgs = new ArrayList<ProductImg>();
    for (ProductImagUpdate productImg:productImglist) {
        if (productImg != null) {
            //删除旧的图片
            //存储图片
           String url = addShopping(productImg.getFile(), path);
           productImg.getProductImg().setImgAddres(url);
           productImg.getProductImg().setPriority(0);
            productImgs.add(productImg.getProductImg());
        }
    }
        if (file!=null) {
            String url = addShopping(file, path);
            product.setProductImgAddress(url);
        }

    productMapper.insertSelective(product);
        productImgMapper.insetProductImgs(productImgs);
    }

    @Override
    public int updateproduct(List<ProductImagUpdate> list, Product product, CommonsMultipartFile shopImg, String path) {
        List<ProductImg> productImgs = new ArrayList<ProductImg>();
        Product productpro = productMapper.selectByPrimaryKey(product.getProductId());
            //删除旧的图片
            for (ProductImagUpdate productImg : list) {
                if (productImg != null) {
                    //删除旧的图片
                    //存储图片
                    String url = addShopping(productImg.getFile(), path);
                    productImg.getProductImg().setImgAddres(url);
                    productImg.getProductImg().setPriority(0);
                    productImgs.add(productImg.getProductImg());
                }
            }

        if (shopImg!=null) {
            String url = addShopping(shopImg, path);
            product.setProductImgAddress(url);
        }else {
            product.setProductImgAddress(productpro.getProductImgAddress());
        }

     int i =   productMapper.updateByPrimaryKeySelective(product);
        if (productImgs.size()>0)
        productImgMapper.insetProductImgs(productImgs);
        return i;
    }

    private String addShopping(CommonsMultipartFile file1,String path) {
        //获取文件的路径
        String filepath = path+"productimage";
        System.out.println(filepath);
        File file=new File(filepath);
        if (!file.exists()){
            file.setWritable(true);//设置文件可写权限
            file.mkdirs();//mkdirs()与mkdir()的区别前者再上传的时候a/b/c/d 只会上传d。
        }
        //获取文本文件的名称
        String realname = file1.getOriginalFilename();
        String last = realname.substring(realname.lastIndexOf("."));
        System.out.println(last);
        String filename = UUID.randomUUID().toString()+"."+last;
        System.out.println(filename);
        File targetfile = new File(file,filename);
        try {
            Thumbnails.of(file1.getInputStream()).size(200, 200).outputQuality(0.25f).toFile(targetfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取文件url
        String url = "http://localhost:8080/o2o/productimage/"+filename;
       return url;

    }


}
