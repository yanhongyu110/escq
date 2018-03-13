package com.jero.esc.vo.demand;

import java.util.Date;

import com.jero.esc.common.utils.DateUtil;
import com.jero.esc.po.userinfo.LogInfo;

public class DemandVo {

	private  String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	private String logName;

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}
	private String demId;
	
	private String demLogid;
	
	private String demContact;
	
	private String demCell;
	
	private String demTitle;
	
	private String demBrief;
	
	private String demContent;
	
	private String demTypetree;
	
	private String demType;
	
	private String ctName;
	
	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	private Date demCreatetime;
	
	private int demState;
	
	private String demImage;
	
	private String demKeyword;
	
	private Boolean demIsdelete;
	
	private String demComments;

	private String starttime;
	
	private String endtime;

	private LogInfo logInfo;
	
	private String userPhoto;

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public LogInfo getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(LogInfo logInfo) {
		this.logInfo = logInfo;
	}

	public String getDemId() {
		return demId;
	}

	public void setDemId(String demId) {
		this.demId = demId;
	}

	public String getDemLogid() {
		return demLogid;
	}

	public void setDemLogid(String demLogid) {
		this.demLogid = demLogid;
	}

	public String getDemContact() {
		return demContact;
	}

	public void setDemContact(String demContact) {
		this.demContact = demContact;
	}

	public String getDemCell() {
		return demCell;
	}

	public void setDemCell(String demCell) {
		this.demCell = demCell;
	}

	public String getDemTitle() {
		return demTitle;
	}

	public void setDemTitle(String demTitle) {
		this.demTitle = demTitle;
	}

	public String getDemBrief() {
		return demBrief;
	}

	public void setDemBrief(String demBrief) {
		this.demBrief = demBrief;
	}

	public String getDemContent() {
		return demContent;
	}

	public void setDemContent(String demContent) {
		this.demContent = demContent;
	}

	public String getDemTypetree() {
		return demTypetree;
	}

	public void setDemTypetree(String demTypetree) {
		this.demTypetree = demTypetree;
	}

	public String getDemType() {
		return demType;
	}

	public void setDemType(String demType) {
		this.demType = demType;
	}

	public Date getDemCreatetime() {
		return demCreatetime;
	}
	
	public String getDemCreatetimeStr() {
		return DateUtil.dateToFull1String(demCreatetime);
	}

	public void setDemCreatetime(Date demCreatetime) {
		this.demCreatetime = demCreatetime;
	}

	public int getDemState() {
		return demState;
	}

	public void setDemState(int demState) {
		this.demState = demState;
	}

	public String getDemImage() {
		return demImage;
	}

	public void setDemImage(String demImage) {
		this.demImage = demImage;
	}

	public String getDemKeyword() {
		return demKeyword;
	}

	public void setDemKeyword(String demKeyword) {
		this.demKeyword = demKeyword;
	}

	public Boolean getDemIsdelete() {
		return demIsdelete;
	}

	public void setDemIsdelete(Boolean demIsdelete) {
		this.demIsdelete = demIsdelete;
	}

	public String getDemComments() {
		return demComments;
	}

	public void setDemComments(String demComments) {
		this.demComments = demComments;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}
