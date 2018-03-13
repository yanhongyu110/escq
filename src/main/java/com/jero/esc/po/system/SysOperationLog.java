package com.jero.esc.po.system;

import java.util.Date;

public class SysOperationLog {
    private String sysOplogId;

    private String sysOplogUserName;

    private Date sysOplogDate;

    private String sysOplogCont;

    private Boolean sysOplogIsdelete;

    public String getSysOplogId() {
        return sysOplogId;
    }

    public void setSysOplogId(String sysOplogId) {
        this.sysOplogId = sysOplogId == null ? null : sysOplogId.trim();
    }

    public String getSysOplogUserName() {
        return sysOplogUserName;
    }

    public void setSysOplogUserName(String sysOplogUserName) {
        this.sysOplogUserName = sysOplogUserName == null ? null : sysOplogUserName.trim();
    }

    public Date getSysOplogDate() {
        return sysOplogDate;
    }

    public void setSysOplogDate(Date sysOplogDate) {
        this.sysOplogDate = sysOplogDate;
    }

    public String getSysOplogCont() {
        return sysOplogCont;
    }

    public void setSysOplogCont(String sysOplogCont) {
        this.sysOplogCont = sysOplogCont == null ? null : sysOplogCont.trim();
    }

    public Boolean getSysOplogIsdelete() {
        return sysOplogIsdelete;
    }

    public void setSysOplogIsdelete(Boolean sysOplogIsdelete) {
        this.sysOplogIsdelete = sysOplogIsdelete;
    }
}