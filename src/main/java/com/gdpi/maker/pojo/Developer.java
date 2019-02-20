package com.gdpi.maker.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Developer {
    private String devId;

    private String devName;

    private String devPassword;

    private String devPasswordmd5;

    private String devNumber;

    private String devSchool;

    private String devTruename;

    private String devIdcard;

    private Integer devTrue;

    private String devImg;

    private String devPhone;

    private String devEmail;

    private String devLocation;

    private String devSpeciality;

    private Integer devBack;

    private Integer devPraise;
    
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date devRegistime;

    private Integer devIdchange;

    private Integer devCancellation;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date devCancellationtime;

    private String devInfo;

    private Integer OrderByClause;

    public Integer getOrderByClause() {
        return OrderByClause;
    }

    public void setOrderByClause(Integer orderByClause) {
        OrderByClause = orderByClause;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId == null ? null : devId.trim();
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
    }

    public String getDevPassword() {
        return devPassword;
    }

    public void setDevPassword(String devPassword) {
        this.devPassword = devPassword == null ? null : devPassword.trim();
    }

    public String getDevPasswordmd5() {
        return devPasswordmd5;
    }

    public void setDevPasswordmd5(String devPasswordmd5) {
        this.devPasswordmd5 = devPasswordmd5 == null ? null : devPasswordmd5.trim();
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

    public String getDevTruename() {
        return devTruename;
    }

    public void setDevTruename(String devTruename) {
        this.devTruename = devTruename == null ? null : devTruename.trim();
    }

    public String getDevIdcard() {
        return devIdcard;
    }

    public void setDevIdcard(String devIdcard) {
        this.devIdcard = devIdcard == null ? null : devIdcard.trim();
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

    public Date getDevRegistime() {
        return devRegistime;
    }

    public void setDevRegistime(Date devRegistime) {
        this.devRegistime = devRegistime;
    }

    public Integer getDevIdchange() {
        return devIdchange;
    }

    public void setDevIdchange(Integer devIdchange) {
        this.devIdchange = devIdchange;
    }

    public Integer getDevCancellation() {
        return devCancellation;
    }

    public void setDevCancellation(Integer devCancellation) {
        this.devCancellation = devCancellation;
    }

    public Date getDevCancellationtime() {
        return devCancellationtime;
    }

    public void setDevCancellationtime(Date devCancellationtime) {
        this.devCancellationtime = devCancellationtime;
    }

    public String getDevInfo() {
        return devInfo;
    }

    public void setDevInfo(String devInfo) {
        this.devInfo = devInfo == null ? null : devInfo.trim();
    }
}