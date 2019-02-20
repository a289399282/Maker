package com.gdpi.maker.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PositionmemCut {
    private String positionId;
    private String positionIdName;

    private String positionmemId;
    private String positionmemIdName;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date positionmemTime;
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date positionmenReltime;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date positionmenEndime;

    private Integer positionmemState;

    private Integer positionmenSum;

    public Date getPositionmenEndime() {
        return positionmenEndime;
    }

    public void setPositionmenEndime(Date positionmenEndime) {
        this.positionmenEndime = positionmenEndime;
    }

    public Integer getPositionmenSum() {
        return positionmenSum;
    }

    public void setPositionmenSum(Integer positionmenSum) {
        this.positionmenSum = positionmenSum;
    }

    public String getPositionIdName() {
        return positionIdName;
    }

    public void setPositionIdName(String positionIdName) {
        this.positionIdName = positionIdName;
    }

    public String getPositionmemIdName() {
        return positionmemIdName;
    }

    public void setPositionmemIdName(String positionmemIdName) {
        this.positionmemIdName = positionmemIdName;
    }

    public Date getPositionmenReltime() {
        return positionmenReltime;
    }

    public void setPositionmenReltime(Date positionmenReltime) {
        this.positionmenReltime = positionmenReltime;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public String getPositionmemId() {
        return positionmemId;
    }

    public void setPositionmemId(String positionmemId) {
        this.positionmemId = positionmemId == null ? null : positionmemId.trim();
    }

    public Date getPositionmemTime() {
        return positionmemTime;
    }

    public void setPositionmemTime(Date positionmemTime) {
        this.positionmemTime = positionmemTime;
    }

    public Integer getPositionmemState() {
        return positionmemState;
    }

    public void setPositionmemState(Integer positionmemState) {
        this.positionmemState = positionmemState;
    }
}