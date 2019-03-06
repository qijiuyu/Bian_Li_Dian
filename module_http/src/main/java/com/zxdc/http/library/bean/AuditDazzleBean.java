package com.zxdc.http.library.bean;

import java.io.Serializable;

public class AuditDazzleBean implements Serializable {
    private String imgUrl;
    private String id;
    private int    auditStatus;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
