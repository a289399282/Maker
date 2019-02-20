package com.gdpi.maker.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Positionmem {
    private String positionId;

    private String positionmemId;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date positionmemTime;

    private Integer positionmemState;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date positionmenReltime;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date positionmenEndime;

    private Integer positionmenSum;

    private Integer OrderByClause;

    public Integer getOrderByClause() {
        return OrderByClause;
    }

    public void setOrderByClause(Integer orderByClause) {
        OrderByClause = orderByClause;
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

    public Date getPositionmenReltime() {
        return positionmenReltime;
    }

    public void setPositionmenReltime(Date positionmenReltime) {
        this.positionmenReltime = positionmenReltime;
    }

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
}