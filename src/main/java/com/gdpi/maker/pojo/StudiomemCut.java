package com.gdpi.maker.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudiomemCut {
    private String stuId;
    private String stuName;

    private String devId;
    private String devName;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date stumemTime;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date stumemRegistime;

    private Integer stumemSum;

    private Integer stumemIs;

    private Integer stumemPower;

    private String stuSpeciality;

    public String getStuSpeciality() {
        return stuSpeciality;
    }

    public void setStuSpeciality(String stuSpeciality) {
        this.stuSpeciality = stuSpeciality;
    }

    public Integer getStumemSum() {
        return stumemSum;
    }

    public void setStumemSum(Integer stumemSum) {
        this.stumemSum = stumemSum;
    }

    public Date getStumemRegistime() {
        return stumemRegistime;
    }

    public void setStumemRegistime(Date stumemRegistime) {
        this.stumemRegistime = stumemRegistime;
    }

    public Integer getStumemPower() {
        return stumemPower;
    }

    public void setStumemPower(Integer stumemPower) {
        this.stumemPower = stumemPower;
    }

    public Integer getStumemIs() {
        return stumemIs;
    }

    public void setStumemIs(Integer stumemIs) {
        this.stumemIs = stumemIs;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName ==null ? null :devName.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
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

    public Date getStumemTime() {
        return stumemTime;
    }

    public void setStumemTime(Date stumemTime) {
        this.stumemTime = stumemTime;
    }
}