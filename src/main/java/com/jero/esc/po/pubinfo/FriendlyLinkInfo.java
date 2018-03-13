package com.jero.esc.po.pubinfo;

public class FriendlyLinkInfo {
    private String flId;

    private String flTitle;

    private String flUrl;

    private Integer flSort;

    private String adminId;

    private String flComment;

    public String getFlId() {
        return flId;
    }

    public void setFlId(String flId) {
        this.flId = flId == null ? null : flId.trim();
    }

    public String getFlTitle() {
        return flTitle;
    }

    public void setFlTitle(String flTitle) {
        this.flTitle = flTitle == null ? null : flTitle.trim();
    }

    public String getFlUrl() {
        return flUrl;
    }

    public void setFlUrl(String flUrl) {
        this.flUrl = flUrl == null ? null : flUrl.trim();
    }

    public Integer getFlSort() {
        return flSort;
    }

    public void setFlSort(Integer flSort) {
        this.flSort = flSort;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getFlComment() {
        return flComment;
    }

    public void setFlComment(String flComment) {
        this.flComment = flComment == null ? null : flComment.trim();
    }
}