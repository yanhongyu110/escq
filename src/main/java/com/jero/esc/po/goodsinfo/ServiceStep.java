package com.jero.esc.po.goodsinfo;

import com.alibaba.fastjson.JSONArray;
import com.jero.esc.po.details.PriceSet;

import java.util.List;

public class ServiceStep {
    private String ssId;

    private String ssName;

    private String ssDescribe;
    //json
    private String ssPrice;

    private String serviceId;

    private Integer ssSort;

    private String logId;

    private String ssComment;

    private List<PriceSet> p;


    //服务表
    private  ServiceInfo serviceInfo;


    public List<PriceSet> getP() {
        return p;
    }

    public void setP(List<PriceSet> p) {
        this.p = p;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId == null ? null : ssId.trim();
    }

    public String getSsName() {
        return ssName;
    }

    public void setSsName(String ssName) {
        this.ssName = ssName == null ? null : ssName.trim();
    }

    public String getSsDescribe() {
        return ssDescribe;
    }

    public void setSsDescribe(String ssDescribe) {
        this.ssDescribe = ssDescribe == null ? null : ssDescribe.trim();
    }

    public String getSsPrice() {
        return ssPrice;
    }

    public void setSsPrice(String ssPrice) {
        this.ssPrice = ssPrice;
        List<PriceSet> priceSets = JSONArray.parseArray(ssPrice, PriceSet.class);
        p=priceSets;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public Integer getSsSort() {
        return ssSort;
    }

    public void setSsSort(Integer ssSort) {
        this.ssSort = ssSort;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getSsComment() {
        return ssComment;
    }

    public void setSsComment(String ssComment) {
        this.ssComment = ssComment == null ? null : ssComment.trim();
    }
}