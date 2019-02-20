package com.gdpi.maker.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Prodeta {
    private String proId;

    private String prdeIswin;
    
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date prdeRectime;
    
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date prdeComtime;

    private Integer prdeState;

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

    public String getPrdeIswin() {
        return prdeIswin;
    }

    public void setPrdeIswin(String prdeIswin) {
        this.prdeIswin = prdeIswin == null ? null : prdeIswin.trim();
    }

    public Date getPrdeRectime() {
        return prdeRectime;
    }

    public void setPrdeRectime(Date prdeRectime) {
        this.prdeRectime = prdeRectime;
    }

    public Date getPrdeComtime() {
        return prdeComtime;
    }

    public void setPrdeComtime(Date prdeComtime) {
        this.prdeComtime = prdeComtime;
    }

    public Integer getPrdeState() {
        return prdeState;
    }

    public void setPrdeState(Integer prdeState) {
        this.prdeState = prdeState;
    }
}