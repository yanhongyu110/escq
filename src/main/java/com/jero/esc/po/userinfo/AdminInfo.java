package com.jero.esc.po.userinfo;

import java.util.Date;

public class AdminInfo {
    private String adminId;

    private String adminName;

    private String adminPass;

    private String adminRealname;

    private Date adminCreatetime;

    private String adminCreater;

    private String adminCell;

    private String adminComment;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass == null ? null : adminPass.trim();
    }

    public String getAdminRealname() {
        return adminRealname;
    }

    public void setAdminRealname(String adminRealname) {
        this.adminRealname = adminRealname == null ? null : adminRealname.trim();
    }

    public Date getAdminCreatetime() {
        return adminCreatetime;
    }

    public void setAdminCreatetime(Date adminCreatetime) {
        this.adminCreatetime = adminCreatetime;
    }

    public String getAdminCreater() {
        return adminCreater;
    }

    public void setAdminCreater(String adminCreater) {
        this.adminCreater = adminCreater == null ? null : adminCreater.trim();
    }

    public String getAdminCell() {
        return adminCell;
    }

    public void setAdminCell(String adminCell) {
        this.adminCell = adminCell == null ? null : adminCell.trim();
    }

    public String getAdminComment() {
        return adminComment;
    }

    public void setAdminComment(String adminComment) {
        this.adminComment = adminComment == null ? null : adminComment.trim();
    }
    private  String company;
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
}