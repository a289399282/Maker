package com.gdpi.maker.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PositionCut {
    private String positionId;
    private String positionName;

    private String positionmemId;
    private String positionmemIdName;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date positionReltime;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date positionEndtime;

    private Integer positionAmount;

    private Integer positionHeat;

    private Integer positionState;

    private String positionInfo;

    private String positionType;

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType ==null ? null :positionType.trim();
    }

    public String getPositionmemIdName() {
        return positionmemIdName;
    }

    public void setPositionmemIdName(String positionmemIdName) {
        this.positionmemIdName = positionmemIdName ==null ?null : positionmemIdName.trim();
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public String getPositionmemId() {
        return positionmemId;
    }

    public void setPositionmemId(String positionmemId) {
        this.positionmemId = positionmemId == null ? null : positionmemId.trim();
    }

    public Date getPositionReltime() {
        return positionReltime;
    }

    public void setPositionReltime(Date positionReltime) {
        this.positionReltime = positionReltime;
    }

    public Date getPositionEndtime() {
        return positionEndtime;
    }

    public void setPositionEndtime(Date positionEndtime) {
        this.positionEndtime = positionEndtime;
    }

    public Integer getPositionAmount() {
        return positionAmount;
    }

    public void setPositionAmount(Integer positionAmount) {
        this.positionAmount = positionAmount;
    }

    public Integer getPositionHeat() {
        return positionHeat;
    }

    public void setPositionHeat(Integer positionHeat) {
        this.positionHeat = positionHeat;
    }

    public Integer getPositionState() {
        return positionState;
    }

    public void setPositionState(Integer positionState) {
        this.positionState = positionState;
    }

    public String getPositionInfo() {
        return positionInfo;
    }

    public void setPositionInfo(String positionInfo) {
        this.positionInfo = positionInfo == null ? null : positionInfo.trim();
    }
}