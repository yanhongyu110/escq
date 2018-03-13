package com.jero.esc.po.details;

import java.util.Date;

public class SelectCodeLogInfo {
    private String scliId;

    private Date scliCreatetime;

    private String logId;

    private String scliContent;

    private String scliComment;

    public String getScliId() {
        return scliId;
    }

    public void setScliId(String scliId) {
        this.scliId = scliId == null ? null : scliId.trim();
    }

    public Date getScliCreatetime() {
        return scliCreatetime;
    }

    public void setScliCreatetime(Date scliCreatetime) {
        this.scliCreatetime = scliCreatetime;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getScliContent() {
        return scliContent;
    }

    public void setScliContent(String scliContent) {
        this.scliContent = scliContent == null ? null : scliContent.trim();
    }

    public String getScliComment() {
        return scliComment;
    }

    public void setScliComment(String scliComment) {
        this.scliComment = scliComment == null ? null : scliComment.trim();
    }
}