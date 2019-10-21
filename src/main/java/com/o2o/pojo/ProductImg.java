package com.o2o.pojo;

import java.util.Date;

public class ProductImg {
    private Integer productImgId;

    private String imgAddres;

    private String imgDescrible;

    private Integer priority;

    private Integer productId;

    private Date createTime;

    public ProductImg(Integer productImgId, String imgAddres, String imgDescrible, Integer priority, Integer productId, Date createTime) {
        this.productImgId = productImgId;
        this.imgAddres = imgAddres;
        this.imgDescrible = imgDescrible;
        this.priority = priority;
        this.productId = productId;
        this.createTime = createTime;
    }

    public ProductImg() {
        super();
    }

    public Integer getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(Integer productImgId) {
        this.productImgId = productImgId;
    }

    public String getImgAddres() {
        return imgAddres;
    }

    public void setImgAddres(String imgAddres) {
        this.imgAddres = imgAddres == null ? null : imgAddres.trim();
    }

    public String getImgDescrible() {
        return imgDescrible;
    }

    public void setImgDescrible(String imgDescrible) {
        this.imgDescrible = imgDescrible == null ? null : imgDescrible.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}