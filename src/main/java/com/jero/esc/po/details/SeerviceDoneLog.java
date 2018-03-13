package com.jero.esc.po.details;

import java.util.Date;

public class SeerviceDoneLog {
    private String sdlId;

    private String ssId;

    private Date sdlCreatetime;

    private Integer sdlState;

    private String sdlReverse;

    private String sdlCustomer;

    private String sdlComment;

    public String getSdlId() {
        return sdlId;
    }

    public void setSdlId(String sdlId) {
        this.sdlId = sdlId == null ? null : sdlId.trim();
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId == null ? null : ssId.trim();
    }

    public Date getSdlCreatetime() {
        return sdlCreatetime;
    }

    public void setSdlCreatetime(Date sdlCreatetime) {
        this.sdlCreatetime = sdlCreatetime;
    }

    public Integer getSdlState() {
        return sdlState;
    }

    public void setSdlState(Integer sdlState) {
        this.sdlState = sdlState;
    }

    public String getSdlReverse() {
        return sdlReverse;
    }

    public void setSdlReverse(String sdlReverse) {
        this.sdlReverse = sdlReverse == null ? null : sdlReverse.trim();
    }

    public String getSdlCustomer() {
        return sdlCustomer;
    }

    public void setSdlCustomer(String sdlCustomer) {
        this.sdlCustomer = sdlCustomer == null ? null : sdlCustomer.trim();
    }

    public String getSdlComment() {
        return sdlComment;
    }

    public void setSdlComment(String sdlComment) {
        this.sdlComment = sdlComment == null ? null : sdlComment.trim();
    }
}