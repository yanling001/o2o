package com.o2o.pojo;

import java.util.Date;

public class LocalAuth {
    private Integer localAuthId;

    private Integer userId;

    private String userName;

    private String password;

    private Date createTime;

    private Date updateTime;

    public LocalAuth(Integer localAuthId, Integer userId, String userName, String password, Date createTime, Date updateTime) {
        this.localAuthId = localAuthId;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public LocalAuth() {
        super();
    }

    public Integer getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(Integer localAuthId) {
        this.localAuthId = localAuthId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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