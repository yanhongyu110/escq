package com.jero.esc.po.goodsinfo;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class ServiceSnapshot {
    private String sersId;

    private String sersInfo;

    private String sersChoose;

    private String sersPrice;

    private String sersPerprice;

    private Date sersCreatetime;

    private String sersComment;

    private  String serviceId;
    
    private  ServiceInfo serviceInfo;;
    
    

    public ServiceInfo getServiceInfo() {
    	if(serviceInfo==null){
    		serviceInfo=JSONObject.parseObject(sersInfo,ServiceInfo.class);
    	}
		return serviceInfo;
	}

	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSersId() {
        return sersId;
    }

    public void setSersId(String sersId) {
        this.sersId = sersId == null ? null : sersId.trim();
    }

    public String getSersInfo() {
        return sersInfo;
    }

    public void setSersInfo(String sersInfo) {
        this.sersInfo = sersInfo == null ? null : sersInfo.trim();
    }

    public String getSersChoose() {
        return sersChoose;
    }

    public void setSersChoose(String sersChoose) {
        this.sersChoose = sersChoose == null ? null : sersChoose.trim();
    }

    public String getSersPrice() {
        return sersPrice;
    }

    public void setSersPrice(String sersPrice) {
        this.sersPrice = sersPrice == null ? null : sersPrice.trim();
    }

    public String getSersPerprice() {
        return sersPerprice;
    }

    public void setSersPerprice(String sersPerprice) {
        this.sersPerprice = sersPerprice == null ? null : sersPerprice.trim();
    }

    public Date getSersCreatetime() {
        return sersCreatetime;
    }

    public void setSersCreatetime(Date sersCreatetime) {
        this.sersCreatetime = sersCreatetime;
    }

    public String getSersComment() {
        return sersComment;
    }

    public void setSersComment(String sersComment) {
        this.sersComment = sersComment == null ? null : sersComment.trim();
    }
}