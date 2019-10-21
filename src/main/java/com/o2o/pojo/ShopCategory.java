package com.o2o.pojo;

import java.util.Date;

public class ShopCategory {
    private Integer shopCategoryId;

    private String shopCategoryName;

    private String shopCategoryDescrible;

    private String shopCategoryImg;

    private Integer shopCategoryPriorty;

    private Integer parentId;

    private Date createTime;

    private Date updateTime;

    public ShopCategory(Integer shopCategoryId, String shopCategoryName, String shopCategoryDescrible, String shopCategoryImg, Integer shopCategoryPriorty, Integer parentId, Date createTime, Date updateTime) {
        this.shopCategoryId = shopCategoryId;
        this.shopCategoryName = shopCategoryName;
        this.shopCategoryDescrible = shopCategoryDescrible;
        this.shopCategoryImg = shopCategoryImg;
        this.shopCategoryPriorty = shopCategoryPriorty;
        this.parentId = parentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ShopCategory() {
        super();
    }

    public Integer getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Integer shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public String getShopCategoryName() {
        return shopCategoryName;
    }

    public void setShopCategoryName(String shopCategoryName) {
        this.shopCategoryName = shopCategoryName == null ? null : shopCategoryName.trim();
    }

    public String getShopCategoryDescrible() {
        return shopCategoryDescrible;
    }

    public void setShopCategoryDescrible(String shopCategoryDescrible) {
        this.shopCategoryDescrible = shopCategoryDescrible == null ? null : shopCategoryDescrible.trim();
    }

    public String getShopCategoryImg() {
        return shopCategoryImg;
    }

    public void setShopCategoryImg(String shopCategoryImg) {
        this.shopCategoryImg = shopCategoryImg == null ? null : shopCategoryImg.trim();
    }

    public Integer getShopCategoryPriorty() {
        return shopCategoryPriorty;
    }

    public void setShopCategoryPriorty(Integer shopCategoryPriorty) {
        this.shopCategoryPriorty = shopCategoryPriorty;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}