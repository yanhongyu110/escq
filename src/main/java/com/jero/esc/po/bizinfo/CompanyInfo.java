package com.jero.esc.po.bizinfo;

import java.io.Serializable;
import java.util.Date;

public class CompanyInfo implements Serializable {



    private String compId;

    private String compName;

    private String compAddr;

    private String compOwner;

    private String compType;

    private String compContact;

    private String compCell;

    private String compSite;

    private String compOwnerphoto;

    private String compCharterfront;

    private String compCharterback;

    private Date compRestime;

    private String compBrier;

    private String compIntroduce;

    private Boolean compIsdelete;

    private Integer compState;

    private String compComments;

    private String compLog;

    private String compProvice;

    private String compLogs;

    private String compViewcell;

    private String compViewaddr;

    private String compViewzip;

    private String compViewemail;

    private String compViewqr;

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId == null ? null : compId.trim();
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public String getCompAddr() {
        return compAddr;
    }

    public void setCompAddr(String compAddr) {
        this.compAddr = compAddr == null ? null : compAddr.trim();
    }

    public String getCompOwner() {
        return compOwner;
    }

    public void setCompOwner(String compOwner) {
        this.compOwner = compOwner == null ? null : compOwner.trim();
    }

    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType == null ? null : compType.trim();
    }

    public String getCompContact() {
        return compContact;
    }

    public void setCompContact(String compContact) {
        this.compContact = compContact == null ? null : compContact.trim();
    }

    public String getCompCell() {
        return compCell;
    }

    public void setCompCell(String compCell) {
        this.compCell = compCell == null ? null : compCell.trim();
    }

    public String getCompSite() {
        return compSite;
    }

    public void setCompSite(String compSite) {
        this.compSite = compSite == null ? null : compSite.trim();
    }

    public String getCompOwnerphoto() {
        return compOwnerphoto;
    }

    public void setCompOwnerphoto(String compOwnerphoto) {
        this.compOwnerphoto = compOwnerphoto == null ? null : compOwnerphoto.trim();
    }

    public String getCompCharterfront() {
        return compCharterfront;
    }

    public void setCompCharterfront(String compCharterfront) {
        this.compCharterfront = compCharterfront == null ? null : compCharterfront.trim();
    }

    public String getCompCharterback() {
        return compCharterback;
    }

    public void setCompCharterback(String compCharterback) {
        this.compCharterback = compCharterback == null ? null : compCharterback.trim();
    }

    public Date getCompRestime() {
        return compRestime;
    }

    public void setCompRestime(Date compRestime) {
        this.compRestime = compRestime;
    }

    public String getCompBrier() {
        return compBrier;
    }

    public void setCompBrier(String compBrier) {
        this.compBrier = compBrier == null ? null : compBrier.trim();
    }

    public String getCompIntroduce() {
        return compIntroduce;
    }

    public void setCompIntroduce(String compIntroduce) {
        this.compIntroduce = compIntroduce == null ? null : compIntroduce.trim();
    }

    public Boolean getCompIsdelete() {
        return compIsdelete;
    }

    public void setCompIsdelete(Boolean compIsdelete) {
        this.compIsdelete = compIsdelete;
    }

    public Integer getCompState() {
        return compState;
    }

    public void setCompState(Integer compState) {
        this.compState = compState;
    }

    public String getCompComments() {
        return compComments;
    }

    public void setCompComments(String compComments) {
        this.compComments = compComments == null ? null : compComments.trim();
    }

    public String getCompLog() {
        return compLog;
    }

    public void setCompLog(String compLog) {
        this.compLog = compLog == null ? null : compLog.trim();
    }

    public String getCompProvice() {
        return compProvice;
    }

    public void setCompProvice(String compProvice) {
        this.compProvice = compProvice == null ? null : compProvice.trim();
    }

    public String getCompLogs() {
        return compLogs;
    }

    public void setCompLogs(String compLogs) {
        this.compLogs = compLogs == null ? null : compLogs.trim();
    }

    public String getCompViewcell() {
        return compViewcell;
    }

    public void setCompViewcell(String compViewcell) {
        this.compViewcell = compViewcell == null ? null : compViewcell.trim();
    }

    public String getCompViewaddr() {
        return compViewaddr;
    }

    public void setCompViewaddr(String compViewaddr) {
        this.compViewaddr = compViewaddr == null ? null : compViewaddr.trim();
    }

    public String getCompViewzip() {
        return compViewzip;
    }

    public void setCompViewzip(String compViewzip) {
        this.compViewzip = compViewzip == null ? null : compViewzip.trim();
    }

    public String getCompViewemail() {
        return compViewemail;
    }

    public void setCompViewemail(String compViewemail) {
        this.compViewemail = compViewemail == null ? null : compViewemail.trim();
    }

    public String getCompViewqr() {
        return compViewqr;
    }

    public void setCompViewqr(String compViewqr) {
        this.compViewqr = compViewqr == null ? null : compViewqr.trim();
    }
}