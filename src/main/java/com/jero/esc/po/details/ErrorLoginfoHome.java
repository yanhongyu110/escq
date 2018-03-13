package com.jero.esc.po.details;

import java.util.Date;

public class ErrorLoginfoHome {
    private String elhId;

    private String elhInfo;

    private Date elhCreatetime;

    private String logId;

    private String elhComment;

    public String getElhId() {
        return elhId;
    }

    public void setElhId(String elhId) {
        this.elhId = elhId == null ? null : elhId.trim();
    }

    public String getElhInfo() {
        return elhInfo;
    }

    public void setElhInfo(String elhInfo) {
        this.elhInfo = elhInfo == null ? null : elhInfo.trim();
    }

    public Date getElhCreatetime() {
        return elhCreatetime;
    }

    public void setElhCreatetime(Date elhCreatetime) {
        this.elhCreatetime = elhCreatetime;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getElhComment() {
        return elhComment;
    }

    public void setElhComment(String elhComment) {
        this.elhComment = elhComment == null ? null : elhComment.trim();
    }
}