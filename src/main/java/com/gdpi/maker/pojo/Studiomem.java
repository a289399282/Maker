package com.gdpi.maker.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Studiomem {
    private String stuId;

    private String devId;

    private Integer stumemPower;

    private Integer stumemIs;

    private Integer stumemSum;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date stumemTime;

    private Date stumemRegistime;

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

    public Integer getStumemSum() {
        return stumemSum;
    }

    public void setStumemSum(Integer stumemSum) {
        this.stumemSum = stumemSum;
    }

    public Date getStumemTime() {
        return stumemTime;
    }

    public void setStumemTime(Date stumemTime) {
        this.stumemTime = stumemTime;
    }

    public Date getStumemRegistime() {
        return stumemRegistime;
    }

    public void setStumemRegistime(Date stumemRegistime) {
        this.stumemRegistime = stumemRegistime;
    }
}