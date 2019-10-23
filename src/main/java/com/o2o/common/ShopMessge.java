package com.o2o.common;


import com.o2o.pojo.vo.ShopVo;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.o2o.common.enmu.Shopenum;
import com.o2o.pojo.Shop;

import java.io.Serializable;
import java.util.List;

//前端查询商铺的时候返回类型
//服务端json实例化对象
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ShopMessge implements Serializable {
    //商铺信息

    private  Shop shop ;
    //状态

    private int state;
    //状态描述

    private String desc;
    //查询到商铺的数量

    private int count;
    //返回商铺的集合

    private List<ShopVo> shopList;
    public ShopMessge(){
        super();
    }
    public ShopMessge(int state, String desc){
        this.state=state; this.desc=desc;
    }
    public ShopMessge(int state,String desc,Shop shop){
        this.state=state; this.desc=desc; this.shop=shop;
    }
    public ShopMessge(int state,String desc,int count ,List<ShopVo> shopList){
        this.state=state; this.desc=desc; this.count=count; this.shopList=shopList;
    }

    public Shop getShop() {
        return shop;
    }

    public int getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }

    public int getCount() {
        return count;
    }

    public List<ShopVo> getShopList() {
        return shopList;
    }


    public static ShopMessge createSucceful(int state,String desc){
        return new ShopMessge(Shopenum.SUCCESS.getCode(),Shopenum.SUCCESS.getMsg());

    }

    public static ShopMessge createSucceful(){
        return new ShopMessge(Shopenum.SUCCESS.getCode(),Shopenum.SUCCESS.getMsg());

    }
    public static ShopMessge createSucceful(int count,List<ShopVo> shopList){
        return new ShopMessge(Shopenum.SUCCESS.getCode(),Shopenum.SUCCESS.getMsg(),count,shopList);

    }

    public static ShopMessge createfail(String desc){
        return new ShopMessge(Shopenum.DEFAULT.getCode(),desc);

    }
}
