package com.o2o.pojo;

import java.util.Date;

public class ProductCategory {
    private Integer productCategoryId;

    private String productCategoryName;

    private Integer priority;

    private Integer shopId;

    private Date createTime;

    public ProductCategory(Integer productCategoryId, String productCategoryName, Integer priority, Integer shopId, Date createTime) {
        this.productCategoryId = productCategoryId;
        this.productCategoryName = productCategoryName;
        this.priority = priority;
        this.shopId = shopId;
        this.createTime = createTime;
    }

    public ProductCategory() {
        super();
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName == null ? null : productCategoryName.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}