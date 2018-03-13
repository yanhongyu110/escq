package com.jero.esc.po.system;

public class SysAdminRole {
    private String adminRoleId;

    private String adminRoleName;

    private Integer adminRoleStatus;

    private String adminRoleRemark;

    private Boolean adminRoleManage;

    public String getAdminRoleId() {
        return adminRoleId;
    }

    public void setAdminRoleId(String adminRoleId) {
        this.adminRoleId = adminRoleId == null ? null : adminRoleId.trim();
    }

    public String getAdminRoleName() {
        return adminRoleName;
    }

    public void setAdminRoleName(String adminRoleName) {
        this.adminRoleName = adminRoleName == null ? null : adminRoleName.trim();
    }

    public Integer getAdminRoleStatus() {
        return adminRoleStatus;
    }

    public void setAdminRoleStatus(Integer adminRoleStatus) {
        this.adminRoleStatus = adminRoleStatus;
    }

    public String getAdminRoleRemark() {
        return adminRoleRemark;
    }

    public void setAdminRoleRemark(String adminRoleRemark) {
        this.adminRoleRemark = adminRoleRemark == null ? null : adminRoleRemark.trim();
    }

    public Boolean getAdminRoleManage() {
        return adminRoleManage;
    }

    public void setAdminRoleManage(Boolean adminRoleManage) {
        this.adminRoleManage = adminRoleManage;
    }
}