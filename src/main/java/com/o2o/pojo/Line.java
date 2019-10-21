package com.o2o.pojo;

import java.util.Date;

public class Line {
    private Integer lineId;

    private String lineName;

    private String lineLink;

    private String lineImg;

    private Integer priority;

    private Integer lineStatus;

    private Date createTime;

    private Date updateTime;

    public Line(Integer lineId, String lineName, String lineLink, String lineImg, Integer priority, Integer lineStatus, Date createTime, Date updateTime) {
        this.lineId = lineId;
        this.lineName = lineName;
        this.lineLink = lineLink;
        this.lineImg = lineImg;
        this.priority = priority;
        this.lineStatus = lineStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Line() {
        super();
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    public String getLineLink() {
        return lineLink;
    }

    public void setLineLink(String lineLink) {
        this.lineLink = lineLink == null ? null : lineLink.trim();
    }

    public String getLineImg() {
        return lineImg;
    }

    public void setLineImg(String lineImg) {
        this.lineImg = lineImg == null ? null : lineImg.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(Integer lineStatus) {
        this.lineStatus = lineStatus;
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