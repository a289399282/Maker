package com.gdpi.maker.pojo;

import java.util.Date;

public class ForumWithBLOBsRankings{

    private String forumName;
    private String forumId;

    private String forummemId;
    private String forummemIdName;

    private Integer forumWhat;

    private String forumRoute;
    private String forumForid;

    private Date forumReltime;

    private String forumInfo;

    private String forumType;
    private Integer forumHeat;

    public String getForummemIdName() {
        return forummemIdName;
    }

    public void setForummemIdName(String forummemIdName) {
        this.forummemIdName = forummemIdName;
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

    public String getForumType() {
        return forumType;
    }

    public void setForumType(String forumType) {
        this.forumType = forumType == null ? null : forumType.trim();
    }

    public Integer getForumHeat() {
        return forumHeat;
    }

    public void setForumHeat(Integer forumHeat) {
        this.forumHeat = forumHeat;
    }

    public String getForumInfo() {
        return forumInfo;
    }

    public void setForumInfo(String forumInfo) {
        this.forumInfo = forumInfo == null ? null : forumInfo.trim();
    }

}