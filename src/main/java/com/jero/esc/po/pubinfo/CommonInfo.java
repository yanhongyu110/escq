package com.jero.esc.po.pubinfo;

import java.util.Date;

public class CommonInfo {
    private String ciId;

    private String ciTitle;

    private String ciContent;

    private Integer ciPos;

    private String adminId;

    private Date ciCreatetime;

    private Integer ciSort;

    private String ciComment;

    public String getCiId() {
        return ciId;
    }

    public void setCiId(String ciId) {
        this.ciId = ciId == null ? null : ciId.trim();
    }

    public String getCiTitle() {
        return ciTitle;
    }

    public void setCiTitle(String ciTitle) {
        this.ciTitle = ciTitle == null ? null : ciTitle.trim();
    }

    public String getCiContent() {
        return ciContent;
    }

    public void setCiContent(String ciContent) {
        this.ciContent = ciContent == null ? null : ciContent.trim();
    }

    public Integer getCiPos() {
        return ciPos;
    }

    public void setCiPos(Integer ciPos) {
        this.ciPos = ciPos;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public Date getCiCreatetime() {
        return ciCreatetime;
    }

    public void setCiCreatetime(Date ciCreatetime) {
        this.ciCreatetime = ciCreatetime;
    }

    public Integer getCiSort() {
        return ciSort;
    }

    public void setCiSort(Integer ciSort) {
        this.ciSort = ciSort;
    }

    public String getCiComment() {
        return ciComment;
    }

    public void setCiComment(String ciComment) {
        this.ciComment = ciComment == null ? null : ciComment.trim();
    }
}