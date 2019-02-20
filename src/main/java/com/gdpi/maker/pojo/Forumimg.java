package com.gdpi.maker.pojo;

import java.util.Date;

public class Forumimg {
    private String imgId;

    private String imgRoute;

    private Date imgRectime;

    private String imgAuthorid;

    private Double imgSize;

    private Integer imgStart;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }

    public String getImgRoute() {
        return imgRoute;
    }

    public void setImgRoute(String imgRoute) {
        this.imgRoute = imgRoute == null ? null : imgRoute.trim();
    }

    public Date getImgRectime() {
        return imgRectime;
    }

    public void setImgRectime(Date imgRectime) {
        this.imgRectime = imgRectime;
    }

    public String getImgAuthorid() {
        return imgAuthorid;
    }

    public void setImgAuthorid(String imgAuthorid) {
        this.imgAuthorid = imgAuthorid == null ? null : imgAuthorid.trim();
    }

    public Double getImgSize() {
        return imgSize;
    }

    public void setImgSize(Double imgSize) {
        this.imgSize = imgSize;
    }

    public Integer getImgStart() {
        return imgStart;
    }

    public void setImgStart(Integer imgStart) {
        this.imgStart = imgStart;
    }
}