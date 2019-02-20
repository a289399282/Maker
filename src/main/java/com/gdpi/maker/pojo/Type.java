package com.gdpi.maker.pojo;

public class Type {
    private String tpId;

    private String tpName;

    private String tpCareer;

    private String tpStyle;

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId == null ? null : tpId.trim();
    }

    public String getTpName() {
        return tpName;
    }

    public void setTpName(String tpName) {
        this.tpName = tpName == null ? null : tpName.trim();
    }

    public String getTpCareer() {
        return tpCareer;
    }

    public void setTpCareer(String tpCareer) {
        this.tpCareer = tpCareer == null ? null : tpCareer.trim();
    }

    public String getTpStyle() {
        return tpStyle;
    }

    public void setTpStyle(String tpStyle) {
        this.tpStyle = tpStyle == null ? null : tpStyle.trim();
    }
}