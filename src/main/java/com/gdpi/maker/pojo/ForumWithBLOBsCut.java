package com.gdpi.maker.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ForumWithBLOBsCut{
    private String forumInfo;

    private String forumText;

    private String forumId;

    private String forummemId;

    private String forummemIdName;

    private Integer forumWhat;

    private String forumRoute;

    private String forumForid;

    @JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Date forumReltime;

    private String forumName;

    private Integer forumHeat;

    private Integer forumStart;

    private String forumTextafter;

    public String getForumTextafter() {
        return forumTextafter;
    }

    public void setForumTextafter(String forumTextafter) {
        this.forumTextafter = forumTextafter == null ? null : forumTextafter.trim();
    }

    public String getForummemIdName() {
        return forummemIdName;
    }

    public void setForummemIdName(String forummemIdName) {
        this.forummemIdName = forummemIdName ==null ? null: forummemIdName.trim();
    }

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String forumId) {
        this.forumId = forumId == null ? null : forumId.trim();
    }

    public String getForummemId() {
        return forummemId;
    }

    public void setForummemId(String forummemId) {
        this.forummemId = forummemId == null ? null : forummemId.trim();
    }

    public Integer getForumWhat() {
        return forumWhat;
    }

    public void setForumWhat(Integer forumWhat) {
        this.forumWhat = forumWhat;
    }

    public String getForumRoute() {
        return forumRoute;
    }

    public void setForumRoute(String forumRoute) {
        this.forumRoute = forumRoute == null ? null : forumRoute.trim();
    }

    public String getForumForid() {
        return forumForid;
    }

    public void setForumForid(String forumForid) {
        this.forumForid = forumForid == null ? null : forumForid.trim();
    }

    public Date getForumReltime() {
        return forumReltime;
    }

    public void setForumReltime(Date forumReltime) {
        this.forumReltime = forumReltime;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName == null ? null : forumName.trim();
    }

    public Integer getForumHeat() {
        return forumHeat;
    }

    public void setForumHeat(Integer forumHeat) {
        this.forumHeat = forumHeat;
    }

    public Integer getForumStart() {
        return forumStart;
    }

    public void setForumStart(Integer forumStart) {
        this.forumStart = forumStart;
    }
    
    public String getForumInfo() {
        return forumInfo;
    }
    
    public void setForumInfo(String forumInfo) {
        this.forumInfo = forumInfo == null ? null : forumInfo;
    }

    public String getForumText() {
        return forumText;
    }

    public void setForumText(String forumText) {
        this.forumText = forumText == null ? null : forumText;
    }
}