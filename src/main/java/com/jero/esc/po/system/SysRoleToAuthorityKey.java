package com.jero.esc.po.system;

public class SysRoleToAuthorityKey {
    private String rtaRole;

    private Integer rtaAuthority;

    public String getRtaRole() {
        return rtaRole;
    }

    public void setRtaRole(String rtaRole) {
        this.rtaRole = rtaRole == null ? null : rtaRole.trim();
    }

    public Integer getRtaAuthority() {
        return rtaAuthority;
    }

    public void setRtaAuthority(Integer rtaAuthority) {
        this.rtaAuthority = rtaAuthority;
    }
}