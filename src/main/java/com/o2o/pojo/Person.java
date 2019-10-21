package com.o2o.pojo;

import java.util.Date;

public class Person {
    private Integer personId;

    private String name;

    private String email;

    private String profileimg;

    private String gender;

    private Integer personStatus;

    private Integer personType;

    private Date createTime;

    private Date updateTime;

    public Person(Integer personId, String name, String email, String profileimg, String gender, Integer personStatus, Integer personType, Date createTime, Date updateTime) {
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.profileimg = profileimg;
        this.gender = gender;
        this.personStatus = personStatus;
        this.personType = personType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Person() {
        super();
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProfileimg() {
        return profileimg;
    }

    public void setProfileimg(String profileimg) {
        this.profileimg = profileimg == null ? null : profileimg.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(Integer personStatus) {
        this.personStatus = personStatus;
    }

    public Integer getPersonType() {
        return personType;
    }

    public void setPersonType(Integer personType) {
        this.personType = personType;
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