package com.gdpi.maker.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProdetaCut {
    private String proId;

    private String proName;

    private String prdeIswin;
    
    private String prdeIswinName;
    
    public String getPrdeIswinName() {
		return prdeIswinName;
	}

	public void setPrdeIswinName(String prdeIswinName) {
		this.prdeIswinName = prdeIswinName ==null ? null : prdeIswinName.trim();
	}

	@JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date prdeRectime;
    
    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date prdeComtime;

    private Integer prdeState;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName ==null ? null :proName.trim();
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