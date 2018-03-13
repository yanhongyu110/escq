package com.jero.esc.po.goodsinfo;

import java.util.Date;

public class OfflineUsedGoodsinfo {
    private String ougId;

    private String ougContent;

    private String ougDescribe;

    private String logId;

    private Date ougCreatetime;

    private Integer ougState;

    private String ougComment;

    public String getOugId() {
        return ougId;
    }

    public void setOugId(String ougId) {
        this.ougId = ougId == null ? null : ougId.trim();
    }

    public String getOugContent() {
        return ougContent;
    }

    public void setOugContent(String ougContent) {
        this.ougContent = ougContent == null ? null : ougContent.trim();
    }

    public String getOugDescribe() {
        return ougDescribe;
    }

    public void setOugDescribe(String ougDescribe) {
        this.ougDescribe = ougDescribe == null ? null : ougDescribe.trim();
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public Date getOugCreatetime() {
        return ougCreatetime;
    }

    public void setOugCreatetime(Date ougCreatetime) {
        this.ougCreatetime = ougCreatetime;
    }

    public Integer getOugState() {
        return ougState;
    }

    public void setOugState(Integer ougState) {
        this.ougState = ougState;
    }

    public String getOugComment() {
        return ougComment;
    }

    public void setOugComment(String ougComment) {
        this.ougComment = ougComment == null ? null : ougComment.trim();
    }
}