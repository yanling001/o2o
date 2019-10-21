package com.o2o.pojo;

import java.util.Date;

public class Shop {
    private Integer shopId;

    private Integer priority;

    private Integer ownerId;

    private Integer areaId;

    private Integer shopCategoryId;

    private Integer userId;

    private Integer status;

    private String img;

    private String shopName;

    private String shopDescrible;

    private String shopPhone;

    private String shopAdress;

    private String advice;

    private Date createTime;

    private Date updateTime;

    public Shop(Integer shopId, Integer priority, Integer ownerId, Integer areaId, Integer shopCategoryId, Integer userId, Integer status, String img, String shopName, String shopDescrible, String shopPhone, String shopAdress, String advice, Date createTime, Date updateTime) {
        this.shopId = shopId;
        this.priority = priority;
        this.ownerId = ownerId;
        this.areaId = areaId;
        this.shopCategoryId = shopCategoryId;
        this.userId = userId;
        this.status = status;
        this.img = img;
        this.shopName = shopName;
        this.shopDescrible = shopDescrible;
        this.shopPhone = shopPhone;
        this.shopAdress = shopAdress;
        this.advice = advice;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Shop() {
        super();
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Integer shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopDescrible() {
        return shopDescrible;
    }

    public void setShopDescrible(String shopDescrible) {
        this.shopDescrible = shopDescrible == null ? null : shopDescrible.trim();
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone == null ? null : shopPhone.trim();
    }

    public String getShopAdress() {
        return shopAdress;
    }

    public void setShopAdress(String shopAdress) {
        this.shopAdress = shopAdress == null ? null : shopAdress.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
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