package com.jero.esc.po.details;

import java.util.Date;

public class ErrorLoginfoAdmin {
    private String elaId;

    private String elaInfo;

    private Date elaCreatetime;

    private String adminId;

    private String elaComment;

    public String getElaId() {
        return elaId;
    }

    public void setElaId(String elaId) {
        this.elaId = elaId == null ? null : elaId.trim();
    }

    public String getElaInfo() {
        return elaInfo;
    }

    public void setElaInfo(String elaInfo) {
        this.elaInfo = elaInfo == null ? null : elaInfo.trim();
    }

    public Date getElaCreatetime() {
        return elaCreatetime;
    }

    public void setElaCreatetime(Date elaCreatetime) {
        this.elaCreatetime = elaCreatetime;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getElaComment() {
        return elaComment;
    }

    public void setElaComment(String elaComment) {
        this.elaComment = elaComment == null ? null : elaComment.trim();
    }
}