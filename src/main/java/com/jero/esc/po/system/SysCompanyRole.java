package com.jero.esc.po.system;

public class SysCompanyRole {
    private String companyRoleId;

    private String companyRoleName;

    private Integer companyRoleStatus;

    private String companyRoleRemark;

    private String companyRoleCompanyid;

    public String getCompanyRoleId() {
        return companyRoleId;
    }

    public void setCompanyRoleId(String companyRoleId) {
        this.companyRoleId = companyRoleId == null ? null : companyRoleId.trim();
    }

    public String getCompanyRoleName() {
        return companyRoleName;
    }

    public void setCompanyRoleName(String companyRoleName) {
        this.companyRoleName = companyRoleName == null ? null : companyRoleName.trim();
    }

    public Integer getCompanyRoleStatus() {
        return companyRoleStatus;
    }

    public void setCompanyRoleStatus(Integer companyRoleStatus) {
        this.companyRoleStatus = companyRoleStatus;
    }

    public String getCompanyRoleRemark() {
        return companyRoleRemark;
    }

    public void setCompanyRoleRemark(String companyRoleRemark) {
        this.companyRoleRemark = companyRoleRemark == null ? null : companyRoleRemark.trim();
    }

    public String getCompanyRoleCompanyid() {
        return companyRoleCompanyid;
    }

    public void setCompanyRoleCompanyid(String companyRoleCompanyid) {
        this.companyRoleCompanyid = companyRoleCompanyid == null ? null : companyRoleCompanyid.trim();
    }
}