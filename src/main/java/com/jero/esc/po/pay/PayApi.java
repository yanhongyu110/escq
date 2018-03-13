package com.jero.esc.po.pay;

import com.alibaba.fastjson.JSONObject;

public class PayApi {

	private String payId;
	
	private String compId;
	
	private int payType;
	
	private String payJson;
	
	private JSONObject payObj;

	public JSONObject getPayObj() {
		this.setPayObj(JSONObject.parseObject(payJson));
		return payObj;
	}

	public void setPayObj(JSONObject payObj) {
		this.payObj = payObj;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public String getPayJson() {
		return payJson;
	}

	public void setPayJson(String payJson) {
		this.payJson = payJson;
	}
	
	
}
