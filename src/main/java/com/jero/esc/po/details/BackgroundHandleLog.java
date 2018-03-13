package com.jero.esc.po.details;

import java.util.Date;

public class BackgroundHandleLog {
    private String bhlId;

    private String adminId;

    private Date bhlTime;

    private String bhlContent;

    private String bhlComment;

    public String getBhlId() {
        return bhlId;
    }

    public void setBhlId(String bhlId) {
        this.bhlId = bhlId == null ? null : bhlId.trim();
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public Date getBhlTime() {
        return bhlTime;
    }

    public void setBhlTime(Date bhlTime) {
        this.bhlTime = bhlTime;
    }

    public String getBhlContent() {
        return bhlContent;
    }

    public void setBhlContent(String bhlContent) {
        this.bhlContent = bhlContent == null ? null : bhlContent.trim();
    }

    public String getBhlComment() {
        return bhlComment;
    }

    public void setBhlComment(String bhlComment) {
        this.bhlComment = bhlComment == null ? null : bhlComment.trim();
    }
}