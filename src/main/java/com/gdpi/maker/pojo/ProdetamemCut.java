package com.gdpi.maker.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProdetamemCut {
    private String proId;
    private String proName;

    private String prdememId;
    private String prdeIswinName;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date prdememTime;

    private Integer prdememState;

    private Integer prdememSum;

    public Integer getPrdememSum() {
        return prdememSum;
    }

    public void setPrdememSum(Integer prdememSum) {
        this.prdememSum = prdememSum;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName ==null ?null : proName.trim();
    }

    public String getPrdeIswinName() {
        return prdeIswinName;
    }

    public void setPrdeIswinName(String prdeIswinName) {
        this.prdeIswinName = prdeIswinName == null ? null :prdeIswinName;
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
}