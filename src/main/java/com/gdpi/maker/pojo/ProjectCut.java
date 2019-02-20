package com.gdpi.maker.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectCut {
    private String proId;

    private String proPublisher;
    private String proPubname;

    private String proName;

    private String proType;

    private Double proMoney;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date proFoutime;
    
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date proReltime;
    
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date proEndtime;

    private String proCity;

    private Integer proHeat;

    private Integer proState;

    private String proInfo;

    public Double getProMoney() {
        return proMoney;
    }

    public void setProMoney(Double proMoney) {
        this.proMoney = proMoney;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getProPublisher() {
        return proPublisher;
    }

    public void setProPublisher(String proPublisher) {
        this.proPublisher = proPublisher == null ? null : proPublisher.trim();
    }

    public String getProPubname() {
        return proPubname;
    }

    public void setProPubname(String proPubname) {
        this.proPubname = proPubname == null ? null : proPubname.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType == null ? null : proType.trim();
    }

    public Date getProFoutime() {
        return proFoutime;
    }

    public void setProFoutime(Date proFoutime) {
        this.proFoutime = proFoutime;
    }

    public Date getProReltime() {
        return proReltime;
    }

    public void setProReltime(Date proReltime) {
        this.proReltime = proReltime;
    }

    public Date getProEndtime() {
        return proEndtime;
    }

    public void setProEndtime(Date proEndtime) {
        this.proEndtime = proEndtime;
    }

    public String getProCity() {
        return proCity;
    }

    public void setProCity(String proCity) {
        this.proCity = proCity == null ? null : proCity.trim();
    }

    public Integer getProHeat() {
        return proHeat;
    }

    public void setProHeat(Integer proHeat) {
        this.proHeat = proHeat;
    }

    public Integer getProState() {
        return proState;
    }

    public void setProState(Integer proState) {
        this.proState = proState;
    }

    public String getProInfo() {
        return proInfo;
    }

    public void setProInfo(String proInfo) {
        this.proInfo = proInfo == null ? null : proInfo.trim();
    }
}