package com.jero.esc.vo.goodsinfo;

import java.util.Date;

import com.jero.esc.common.utils.DateUtil;

public class ServiceRemarkVo {
	private String srId;

	private Float srRemark;

	private Date srCreatetime;

	private String srContent;

	private Date srAppendtime;

	private String srAppendcontent;

	private Date srResponsetime;

	private String srResponsecontent;

	private Date srResponseappendtime;

	private String srResponseappendcontent;
	
	private String srOrder;

	private String logId;

	private String serviceId;

	private String srComment;
	
	private String logName;
	
	private String userPhoto;
	
	private int[] srLevel;
	
	private String serviceTitle;
	
	private String serviceContent;
	
	

	public String getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	public String getSrId() {
		return srId;
	}

	public void setSrId(String srId) {
		this.srId = srId;
	}

	public Float getSrRemark() {
		return srRemark;
	}

	public void setSrRemark(Float srRemark) {
		this.srRemark = srRemark;
	}

	public Date getSrCreatetime() {
		return srCreatetime;
	}
	
	public String getSrCreatetimeStr() {
		return DateUtil.dateToChinaString(srCreatetime);
	}

	public void setSrCreatetime(Date srCreatetime) {
		this.srCreatetime = srCreatetime;
	}

	public String getSrContent() {
		return srContent;
	}

	public void setSrContent(String srContent) {
		this.srContent = srContent;
	}

	public Date getSrAppendtime() {
		return srAppendtime;
	}

	public void setSrAppendtime(Date srAppendtime) {
		this.srAppendtime = srAppendtime;
	}

	public String getSrAppendcontent() {
		return srAppendcontent;
	}

	public void setSrAppendcontent(String srAppendcontent) {
		this.srAppendcontent = srAppendcontent;
	}

	public Date getSrResponsetime() {
		return srResponsetime;
	}

	public void setSrResponsetime(Date srResponsetime) {
		this.srResponsetime = srResponsetime;
	}

	public String getSrResponsecontent() {
		return srResponsecontent;
	}

	public void setSrResponsecontent(String srResponsecontent) {
		this.srResponsecontent = srResponsecontent;
	}

	public Date getSrResponseappendtime() {
		return srResponseappendtime;
	}

	public void setSrResponseappendtime(Date srResponseappendtime) {
		this.srResponseappendtime = srResponseappendtime;
	}

	public String getSrResponseappendcontent() {
		return srResponseappendcontent;
	}

	public void setSrResponseappendcontent(String srResponseappendcontent) {
		this.srResponseappendcontent = srResponseappendcontent;
	}

	public String getSrOrder() {
		return srOrder;
	}

	public void setSrOrder(String srOrder) {
		this.srOrder = srOrder;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getSrComment() {
		return srComment;
	}

	public void setSrComment(String srComment) {
		this.srComment = srComment;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public int[] getSrLevel() {
		return srLevel;
	}

	public void setSrLevel(int[] srLevel) {
		this.srLevel = srLevel;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	
}
