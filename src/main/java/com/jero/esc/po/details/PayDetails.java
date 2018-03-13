package com.jero.esc.po.details;

import java.util.Date;

public class PayDetails {
    private String paydId;

    private String orderId;

    private Date paydPaytime;

    private String paydPayer;

    private String paydReceiver;

    private Float paydPayammount;

    private Float paydPoints;

    private String paydStep;

    private String paydComment;

    public String getPaydId() {
        return paydId;
    }

    public void setPaydId(String paydId) {
        this.paydId = paydId == null ? null : paydId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getPaydPaytime() {
        return paydPaytime;
    }

    public void setPaydPaytime(Date paydPaytime) {
        this.paydPaytime = paydPaytime;
    }

    public String getPaydPayer() {
        return paydPayer;
    }

    public void setPaydPayer(String paydPayer) {
        this.paydPayer = paydPayer == null ? null : paydPayer.trim();
    }

    public String getPaydReceiver() {
        return paydReceiver;
    }

    public void setPaydReceiver(String paydReceiver) {
        this.paydReceiver = paydReceiver == null ? null : paydReceiver.trim();
    }

    public Float getPaydPayammount() {
        return paydPayammount;
    }

    public void setPaydPayammount(Float paydPayammount) {
        this.paydPayammount = paydPayammount;
    }

    public Float getPaydPoints() {
        return paydPoints;
    }

    public void setPaydPoints(Float paydPoints) {
        this.paydPoints = paydPoints;
    }

    public String getPaydStep() {
        return paydStep;
    }

    public void setPaydStep(String paydStep) {
        this.paydStep = paydStep == null ? null : paydStep.trim();
    }

    public String getPaydComment() {
        return paydComment;
    }

    public void setPaydComment(String paydComment) {
        this.paydComment = paydComment == null ? null : paydComment.trim();
    }
}