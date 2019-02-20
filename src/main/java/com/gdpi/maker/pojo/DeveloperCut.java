package com.gdpi.maker.pojo;


public class DeveloperCut {
    private String devId;

    private String devName;

    private String devNumber;

    private String devSchool;

    private Integer devTrue;

    private String devImg;

    private String devPhone;

    private String devEmail;

    private String devLocation;

    private String devSpeciality;

    private Integer devBack;

    private Integer devPraise;

    private String devInfo;

    public String getDevId() {
        return devId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }

    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    public String getDevNumber() {
        return devNumber;
    }

    public void setDevNumber(String devNumber) {
        this.devNumber = devNumber == null ? null : devNumber.trim();
    }

    public String getDevSchool() {
        return devSchool;
    }

    public void setDevSchool(String devSchool) {
        this.devSchool = devSchool == null ? null : devSchool.trim();
    }

    public Integer getDevTrue() {
        return devTrue;
    }

    public void setDevTrue(Integer devTrue) {
        this.devTrue = devTrue;
    }

    public String getDevImg() {
        return devImg;
    }

    public void setDevImg(String devImg) {
        this.devImg = devImg == null ? null : devImg.trim();
    }

    public String getDevPhone() {
        return devPhone;
    }

    public void setDevPhone(String devPhone) {
        this.devPhone = devPhone == null ? null : devPhone.trim();
    }

    public String getDevEmail() {
        return devEmail;
    }

    public void setDevEmail(String devEmail) {
        this.devEmail = devEmail == null ? null : devEmail.trim();
    }

    public String getDevLocation() {
        return devLocation;
    }

    public void setDevLocation(String devLocation) {
        this.devLocation = devLocation == null ? null : devLocation.trim();
    }

    public String getDevSpeciality() {
        return devSpeciality;
    }

    public void setDevSpeciality(String devSpeciality) {
        this.devSpeciality = devSpeciality == null ? null : devSpeciality.trim();
    }

    public Integer getDevBack() {
        return devBack;
    }

    public void setDevBack(Integer devBack) {
        this.devBack = devBack;
    }

    public Integer getDevPraise() {
        return devPraise;
    }

    public void setDevPraise(Integer devPraise) {
        this.devPraise = devPraise;
    }

    public String getDevInfo() {
        return devInfo;
    }

    public void setDevInfo(String devInfo) {
        this.devInfo = devInfo == null ? null : devInfo.trim();
    }
}