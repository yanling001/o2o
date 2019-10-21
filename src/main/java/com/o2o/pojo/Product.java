package com.o2o.pojo;

import java.util.Date;

public class Product {
    private Integer productId;

    private String productName;

    private String productDescrible;

    private String productImgAddress;

    private String productPrice;

    private String productCountPrice;

    private Integer priority;

    private Integer status;

    private Integer shopId;

    private Integer productCategoryId;

    private Date createTime;

    private Date updateTime;

    public Product(Integer productId, String productName, String productDescrible, String productImgAddress, String productPrice, String productCountPrice, Integer priority, Integer status, Integer shopId, Integer productCategoryId, Date createTime, Date updateTime) {
        this.productId = productId;
        this.productName = productName;
        this.productDescrible = productDescrible;
        this.productImgAddress = productImgAddress;
        this.productPrice = productPrice;
        this.productCountPrice = productCountPrice;
        this.priority = priority;
        this.status = status;
        this.shopId = shopId;
        this.productCategoryId = productCategoryId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Product() {
        super();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductDescrible() {
        return productDescrible;
    }

    public void setProductDescrible(String productDescrible) {
        this.productDescrible = productDescrible == null ? null : productDescrible.trim();
    }

    public String getProductImgAddress() {
        return productImgAddress;
    }

    public void setProductImgAddress(String productImgAddress) {
        this.productImgAddress = productImgAddress == null ? null : productImgAddress.trim();
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice == null ? null : productPrice.trim();
    }

    public String getProductCountPrice() {
        return productCountPrice;
    }

    public void setProductCountPrice(String productCountPrice) {
        this.productCountPrice = productCountPrice == null ? null : productCountPrice.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
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