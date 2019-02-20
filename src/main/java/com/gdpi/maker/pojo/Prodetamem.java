package com.gdpi.maker.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Prodetamem {
    private String proId;

    private String prdememId;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date prdememTime;

    private Integer prdememState;

    private Integer prdememSum;

    private Integer OrderByClause;

    public Integer getOrderByClause() {
        return OrderByClause;
    }

    public void setOrderByClause(Integer orderByClause) {
        OrderByClause = orderByClause;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getPrdememId() {
        return prdememId;
    }

    public void setPrdememId(String prdememId) {
        this.prdememId = prdememId == null ? null : prdememId.trim();
    }

    public Date getPrdememTime() {
        return prdememTime;
    }

    public void setPrdememTime(Date prdememTime) {
        this.prdememTime = prdememTime;
    }

    public Integer getPrdememState() {
        return prdememState;
    }

    public void setPrdememState(Integer prdememState) {
        this.prdememState = prdememState;
    }

    public Integer getPrdememSum() {
        return prdememSum;
    }

    public void setPrdememSum(Integer prdememSum) {
        this.prdememSum = prdememSum;
    }
}