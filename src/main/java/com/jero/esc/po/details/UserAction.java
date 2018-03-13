package com.jero.esc.po.details;

import java.util.Date;

public class UserAction {
    private String uaId;

    private String uaContent;

    private Integer uaType;

    private Date uaCreatetime;

    private String logId;

    private String uaComment;

    public String getUaId() {
        return uaId;
    }

    public void setUaId(String uaId) {
        this.uaId = uaId == null ? null : uaId.trim();
    }

    public String getUaContent() {
        return uaContent;
    }

    public void setUaContent(String uaContent) {
        this.uaContent = uaContent == null ? null : uaContent.trim();
    }

    public Integer getUaType() {
        return uaType;
    }

    public void setUaType(Integer uaType) {
        this.uaType = uaType;
    }

    public Date getUaCreatetime() {
        return uaCreatetime;
    }

    public void setUaCreatetime(Date uaCreatetime) {
        this.uaCreatetime = uaCreatetime;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getUaComment() {
        return uaComment;
    }

    public void setUaComment(String uaComment) {
        this.uaComment = uaComment == null ? null : uaComment.trim();
    }
}