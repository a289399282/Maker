package com.gdpi.maker.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DeveloperRankings {
    //private String devId;

    private String devName;

    //private String devNumber;

   //private String devSchool;

    private String devImg;

    private String devPhone;

    private String devEmail;

    private String devLocation;

    private String devSpeciality;

    private Integer devPraise;

    private String devInfo;


    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName == null ? null : devName.trim();
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

    public String getDevInfo() {
        return devInfo;
    }

    public void setDevInfo(String devInfo) {
        this.devInfo = devInfo == null ? null : devInfo.trim();
    }

    public Integer getDevPraise() {
        return devPraise;
    }

    public void setDevPraise(Integer devPraise) {
        this.devPraise = devPraise;
    }
}