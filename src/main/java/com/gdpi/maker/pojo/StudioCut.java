package com.gdpi.maker.pojo;


public class StudioCut {
    private String stuId;
    private String stuName;

    private String devId;
    private String devIdName;

    private String stuImg;

    private String stuPhone;

    private String stuEmail;

    private String stuLocation;

    private String stuSpeciality;

    private String stuInfo;

    private Integer stuPraise;

    public Integer getStuPraise() {
        return stuPraise;
    }

    public void setStuPraise(Integer stuPraise) {
        this.stuPraise = stuPraise;
    }

    public String getDevIdName() {
        return devIdName;
    }

    public void setDevIdName(String devIdName) {
        this.devIdName = devIdName ==null ?null:devIdName.trim();
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

    public String getStuInfo() {
        return stuInfo;
    }

    public void setStuInfo(String stuInfo) {
        this.stuInfo = stuInfo == null ? null : stuInfo.trim();
    }
}