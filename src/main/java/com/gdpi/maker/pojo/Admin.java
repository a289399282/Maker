package com.gdpi.maker.pojo;

import java.util.Date;

public class Admin {
    private String adId;

    private String adName;

    private String adPhone;

    private String adPassword;

    private String adPasswordmd5;

    private String adTruename;

    private String adIdcard;

    private Integer adTrue;

    private String adEmail;

    private String adImg;

    private Date adRegistime;

    private Date adEndtime;

    private Integer adStart;

    private Integer adPower;

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId == null ? null : adId.trim();
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone == null ? null : adPhone.trim();
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword == null ? null : adPassword.trim();
    }

    public String getAdPasswordmd5() {
        return adPasswordmd5;
    }

    public void setAdPasswordmd5(String adPasswordmd5) {
        this.adPasswordmd5 = adPasswordmd5 == null ? null : adPasswordmd5.trim();
    }

    public String getAdTruename() {
        return adTruename;
    }

    public void setAdTruename(String adTruename) {
        this.adTruename = adTruename == null ? null : adTruename.trim();
    }

    public String getAdIdcard() {
        return adIdcard;
    }

    public void setAdIdcard(String adIdcard) {
        this.adIdcard = adIdcard == null ? null : adIdcard.trim();
    }

    public Integer getAdTrue() {
        return adTrue;
    }

    public void setAdTrue(Integer adTrue) {
        this.adTrue = adTrue;
    }

    public String getAdEmail() {
        return adEmail;
    }

    public void setAdEmail(String adEmail) {
        this.adEmail = adEmail == null ? null : adEmail.trim();
    }

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg == null ? null : adImg.trim();
    }

    public Date getAdRegistime() {
        return adRegistime;
    }

    public void setAdRegistime(Date adRegistime) {
        this.adRegistime = adRegistime;
    }

    public Date getAdEndtime() {
        return adEndtime;
    }

    public void setAdEndtime(Date adEndtime) {
        this.adEndtime = adEndtime;
    }

    public Integer getAdStart() {
        return adStart;
    }

    public void setAdStart(Integer adStart) {
        this.adStart = adStart;
    }

    public Integer getAdPower() {
        return adPower;
    }

    public void setAdPower(Integer adPower) {
        this.adPower = adPower;
    }
}