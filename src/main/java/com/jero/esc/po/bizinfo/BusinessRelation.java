package com.jero.esc.po.bizinfo;

import java.util.Date;

public class BusinessRelation {
    private String brId;

    private String brSeller;

    private String brBuyer;

    private Date brCreateTime;

    private Integer brType;

    private Integer brState;

    private Boolean brIsdelete;

    private String brComment;

    public String getBrId() {
        return brId;
    }

    public void setBrId(String brId) {
        this.brId = brId == null ? null : brId.trim();
    }

    public String getBrSeller() {
        return brSeller;
    }

    public void setBrSeller(String brSeller) {
        this.brSeller = brSeller == null ? null : brSeller.trim();
    }

    public String getBrBuyer() {
        return brBuyer;
    }

    public void setBrBuyer(String brBuyer) {
        this.brBuyer = brBuyer == null ? null : brBuyer.trim();
    }

    public Date getBrCreateTime() {
        return brCreateTime;
    }

    public void setBrCreateTime(Date brCreateTime) {
        this.brCreateTime = brCreateTime;
    }

    public Integer getBrType() {
        return brType;
    }

    public void setBrType(Integer brType) {
        this.brType = brType;
    }

    public Integer getBrState() {
        return brState;
    }

    public void setBrState(Integer brState) {
        this.brState = brState;
    }

    public Boolean getBrIsdelete() {
        return brIsdelete;
    }

    public void setBrIsdelete(Boolean brIsdelete) {
        this.brIsdelete = brIsdelete;
    }

    public String getBrComment() {
        return brComment;
    }

    public void setBrComment(String brComment) {
        this.brComment = brComment == null ? null : brComment.trim();
    }
}