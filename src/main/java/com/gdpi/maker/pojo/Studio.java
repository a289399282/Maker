package com.gdpi.maker.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Studio {
    private String stuId;

    private String devId;

    private String stuName;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date stuRegistime;

    private String stuImg;

    private String stuPhone;

    private String stuEmail;

    private String stuLocation;

    private String stuSpeciality;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date stuEndtime;

    private Integer stuStart;

    private Integer stuPraise;

    private String stuInfo;

    private Integer OrderByClause;

    public Integer getOrderByClause() {
        return OrderByClause;
    }

    public void setOrderByClause(Integer orderByClause) {
        OrderByClause = orderByClause;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Date getStuRegistime() {
        return stuRegistime;
    }

    public void setStuRegistime(Date stuRegistime) {
        this.stuRegistime = stuRegistime;
    }

    public String getStuImg() {
        return stuImg;
    }

    public void setStuImg(String stuImg) {
        this.stuImg = stuImg == null ? null : stuImg.trim();
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail == null ? null : stuEmail.trim();
    }

    public String getStuLocation() {
        return stuLocation;
    }

    public void setStuLocation(String stuLocation) {
        this.stuLocation = stuLocation == null ? null : stuLocation.trim();
    }

    public String getStuSpeciality() {
        return stuSpeciality;
    }

    public void setStuSpeciality(String stuSpeciality) {
        this.stuSpeciality = stuSpeciality == null ? null : stuSpeciality.trim();
    }

    public Date getStuEndtime() {
        return stuEndtime;
    }

    public void setStuEndtime(Date stuEndtime) {
        this.stuEndtime = stuEndtime;
    }

    public Integer getStuStart() {
        return stuStart;
    }

    public void setStuStart(Integer stuStart) {
        this.stuStart = stuStart;
    }

    public Integer getStuPraise() {
        return stuPraise;
    }

    public void setStuPraise(Integer stuPraise) {
        this.stuPraise = stuPraise;
    }

    public String getStuInfo() {
        return stuInfo;
    }

    public void setStuInfo(String stuInfo) {
        this.stuInfo = stuInfo == null ? null : stuInfo.trim();
    }
}