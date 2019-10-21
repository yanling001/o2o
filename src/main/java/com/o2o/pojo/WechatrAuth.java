package com.o2o.pojo;

import java.util.Date;

public class WechatrAuth {
    private Integer wechatAuthId;

    private Integer userId;

    private String openId;

    private Date createTime;

    public WechatrAuth(Integer wechatAuthId, Integer userId, String openId, Date createTime) {
        this.wechatAuthId = wechatAuthId;
        this.userId = userId;
        this.openId = openId;
        this.createTime = createTime;
    }

    public WechatrAuth() {
        super();
    }

    public Integer getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Integer wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}