package com.jero.esc.po.pubinfo;

import java.util.Date;

public class NavigationInfo {
    private String navId;

    private String navType;

    private String navPosition;

    private String navContent;

    private Date navCreatetime;

    private String navCreator;

    private String navComment;

    public String getNavId() {
        return navId;
    }

    public void setNavId(String navId) {
        this.navId = navId == null ? null : navId.trim();
    }

    public String getNavType() {
        return navType;
    }

    public void setNavType(String navType) {
        this.navType = navType == null ? null : navType.trim();
    }

    public String getNavPosition() {
        return navPosition;
    }

    public void setNavPosition(String navPosition) {
        this.navPosition = navPosition == null ? null : navPosition.trim();
    }

    public String getNavContent() {
        return navContent;
    }

    public void setNavContent(String navContent) {
        this.navContent = navContent == null ? null : navContent.trim();
    }

    public Date getNavCreatetime() {
        return navCreatetime;
    }

    public void setNavCreatetime(Date navCreatetime) {
        this.navCreatetime = navCreatetime;
    }

    public String getNavCreator() {
        return navCreator;
    }

    public void setNavCreator(String navCreator) {
        this.navCreator = navCreator == null ? null : navCreator.trim();
    }

    public String getNavComment() {
        return navComment;
    }

    public void setNavComment(String navComment) {
        this.navComment = navComment == null ? null : navComment.trim();
    }
}