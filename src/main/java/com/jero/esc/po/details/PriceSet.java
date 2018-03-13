package com.jero.esc.po.details;

import java.util.Date;

public class PriceSet {
    private String psetId;
    
    //价格来源
    private Integer psetDiscountType;
    
    private Integer psetPointType;

    //价格
    private Float psetPrice;

    //积分
    private Float psetPoint;

   
    private Date psetCreateTime;

    private String logId;

    private String serviceId;

    private String psetComment;

    public String getPsetId() {
        return psetId;
    }

    public void setPsetId(String psetId) {
        this.psetId = psetId == null ? null : psetId.trim();
    }

    public Integer getPsetDiscountType() {
        return psetDiscountType;
    }

    public void setPsetDiscountType(Integer psetDiscountType) {
        this.psetDiscountType = psetDiscountType;
    }

    public Integer getPsetPointType() {
        return psetPointType;
    }

    public void setPsetPointType(Integer psetPointType) {
        this.psetPointType = psetPointType;
    }

    public Float getPsetPrice() {
        return psetPrice;
    }

    public void setPsetPrice(Float psetPrice) {
        float b = (float)(Math.round(psetPrice*100))/100;
        this.psetPrice = b;
    }

    public Float getPsetPoint() {
        return psetPoint;
    }

    public void setPsetPoint(Float psetPoint) {
            float b = (float)(Math.round(psetPoint*100))/100;
        this.psetPoint = b;
    }

    public Date getPsetCreateTime() {
        return psetCreateTime;
    }

    public void setPsetCreateTime(Date psetCreateTime) {
        this.psetCreateTime = psetCreateTime;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getPsetComment() {
        return psetComment;
    }

    public void setPsetComment(String psetComment) {
        this.psetComment = psetComment == null ? null : psetComment.trim();
    }
}