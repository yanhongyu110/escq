package com.jero.esc.vo.saleinfo;


import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.goodsinfo.ServiceStep;

public class OrderService {

    private String osId;

    private String orderId;

    private String oSersId;

    private Float osGoodsNum;

    private String ssId;

    private String osComment;
    //属性 json
    private String osAttrs;
    //价格
    private Float osPrice;
    //积分
    private Float osPoint;
    //商品来源
    private String osSource;
    //自定义阶段
    private  String osSetps;
    
    private  String osServicetitle;
    
    private String sersId;

    private String sersInfo;

    private String sersChoose;

    private String sersPrice;

    private String sersPerprice;

    private Date sersCreatetime;

    private String sersComment;

    private  String serviceId;
    
    private ServiceInfo serviceInfo;
    
    public ServiceInfo getServiceInfo() {
    	if(sersInfo == null || "".equals(sersInfo)){
    		return null;
    	}
    	if(serviceInfo == null){
    		return JSONObject.parseObject(sersInfo, ServiceInfo.class);
    	}
    	return serviceInfo;
	}

	public void setServiceInfo(ServiceInfo servceInfo) {
		this.serviceInfo = servceInfo;
	}

	//商品阶段
    private List<ServiceStep> serviceStep;
    
    public String getOsServicetitle() {
		return osServicetitle;
	}

	public void setOsServicetitle(String osServicetitle) {
		this.osServicetitle = osServicetitle;
	}

	public List<ServiceStep> getServiceStep(){
    	if(osSetps == null || "".equals(osSetps)){
    		return null;
    	}
    	if(serviceStep == null){
    		return JSONArray.parseArray(osSetps,ServiceStep.class);
    	}
    	return serviceStep;
    }

    public String getOsSetps() {
        return osSetps;
    }

    public void setOsSetps(String osSetps) {
        this.osSetps = osSetps;
    }

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId == null ? null : osId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getoSersId() {
        return oSersId;
    }

    public void setoSersId(String oSersId) {
        this.oSersId = oSersId == null ? null : oSersId.trim();
    }

    public Float getOsGoodsNum() {
        return osGoodsNum;
    }

    public void setOsGoodsNum(Float osGoodsNum) {
        this.osGoodsNum = osGoodsNum;
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId == null ? null : ssId.trim();
    }

    public String getOsComment() {
        return osComment;
    }

    public void setOsComment(String osComment) {
        this.osComment = osComment == null ? null : osComment.trim();
    }

    public String getOsAttrs() {
        return osAttrs;
    }

    public void setOsAttrs(String osAttrs) {
        this.osAttrs = osAttrs == null ? null : osAttrs.trim();
    }

    public String getOsSource() {
        return osSource;
    }

    public void setOsSource(String osSource) {
        this.osSource = osSource == null ? null : osSource.trim();
    }

    public Float getOsPrice() {
        return osPrice;
    }

    public void setOsPrice(Float osPrice) {
        this.osPrice = osPrice;
    }

    public Float getOsPoint() {
        return osPoint;
    }

    public void setOsPoint(Float osPoint) {
        this.osPoint = osPoint;
    }

	public String getSersId() {
		return sersId;
	}

	public void setSersId(String sersId) {
		this.sersId = sersId;
	}

	public String getSersInfo() {
		return sersInfo;
	}

	public void setSersInfo(String sersInfo) {
		this.sersInfo = sersInfo;
	}

	public String getSersChoose() {
		return sersChoose;
	}

	public void setSersChoose(String sersChoose) {
		this.sersChoose = sersChoose;
	}

	public String getSersPrice() {
		return sersPrice;
	}

	public void setSersPrice(String sersPrice) {
		this.sersPrice = sersPrice;
	}

	public String getSersPerprice() {
		return sersPerprice;
	}

	public void setSersPerprice(String sersPerprice) {
		this.sersPerprice = sersPerprice;
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
		this.sersComment = sersComment;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public void setServiceStep(List<ServiceStep> serviceStep) {
		this.serviceStep = serviceStep;
	}

}