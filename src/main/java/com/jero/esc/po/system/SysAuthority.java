package com.jero.esc.po.system;

public class SysAuthority {
    private Integer authorityId;

    private String authorityName;

    private Integer authorityParent;

    private Boolean authorityIsleaf;

    private String authorityRemark;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    public Integer getAuthorityParent() {
        return authorityParent;
    }

    public void setAuthorityParent(Integer authorityParent) {
        this.authorityParent = authorityParent;
    }

    public Boolean getAuthorityIsleaf() {
        return authorityIsleaf;
    }

    public void setAuthorityIsleaf(Boolean authorityIsleaf) {
        this.authorityIsleaf = authorityIsleaf;
    }

    public String getAuthorityRemark() {
        return authorityRemark;
    }

    public void setAuthorityRemark(String authorityRemark) {
        this.authorityRemark = authorityRemark == null ? null : authorityRemark.trim();
    }
}