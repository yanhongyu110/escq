package com.jero.esc.vo.userinfo;

import java.util.Date;

import com.jero.esc.common.utils.fastvalidate.FastValidateAnnotation;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;

public class ProviderVo {


	private String userPhoto;

	//服务商
    private String piId;
    @FastValidateAnnotation(name = "所属区域")
    private String piArea;
    @FastValidateAnnotation(name = "生活照片")
    private String piPhoto;
    @FastValidateAnnotation(name = "关键字")
    private String piKeywords;

    private String piRemark;

    private Integer piType;
    @FastValidateAnnotation(name = "真实姓名",validateType = FastValidateType.CHINESE_NAME)
    private String piRealname;
    @FastValidateAnnotation(name = "任职机构")
    private String piCompany;
    @FastValidateAnnotation(name = "任职职位")
    private String piPosition;
    @FastValidateAnnotation(name = "工作年限")
    private Integer piWorkyear;
    @FastValidateAnnotation(name = "邮箱",validateType = FastValidateType.EMAIL)
    private String piEmail;
    @FastValidateAnnotation(name = "电话",validateType = FastValidateType.CELL)
    private String piCell;
    @FastValidateAnnotation(name = "地址")
    private String piAddr;

    private Boolean piIsdelete;
    @FastValidateAnnotation(name = "服务商介绍")
    private String piContent;

    private String piLogId;
    @FastValidateAnnotation(name = "服务商简介")
    private String piBrief;

    private Integer piMeetnum;

    private Integer piDealnum;

    private Integer piResponsetime;



    private String piUrls;

    private String piComment;
    
    private Float piRek;
    
    private Float piMark;
    
    private String piVideo;
    
    //登录信息表
    
    private String logId;

    private String logCell;

    private String logEmail;

    private String logName;

    private String logPass;

    private Date logCreatetime;

    private Boolean logIsdelete;

    private Integer logState;

    private Integer logType;

    private String logRegip;

    private Boolean logIslog;

    private String logComment;
    
    private String prId;

    private String prDetails;

    private String prPhoto;

    private Date prCreatetime;

    private Integer prState;

    private Integer prSort;

    private String prLogId;

    private String prComment;
    
    //价格表
    private String psetId;

    private Integer psetDiscountType;

    private Integer psetPointType;

    private Float psetPrice;

    private Float psetPoint;

    private Date psetCreateTime;

    private String psetLogId;

    private String serviceId;

    private String psetComment;

	public String getPiId() {
		return piId;
	}

	public void setPiId(String piId) {
		this.piId = piId;
	}

	public String getPiArea() {
		return piArea;
	}

	public void setPiArea(String piArea) {
		this.piArea = piArea;
	}

	public String getPiPhoto() {
		return piPhoto;
	}

	public void setPiPhoto(String piPhoto) {
		this.piPhoto = piPhoto;
	}

	public String getPiKeywords() {
		return piKeywords;
	}

	public void setPiKeywords(String piKeywords) {
		this.piKeywords = piKeywords;
	}

	public String getPiRemark() {
		return piRemark;
	}

	public void setPiRemark(String piRemark) {
		this.piRemark = piRemark;
	}

	public Integer getPiType() {
		return piType;
	}

	public void setPiType(Integer piType) {
		this.piType = piType;
	}

	public String getPiRealname() {
		return piRealname;
	}

	public void setPiRealname(String piRealname) {
		this.piRealname = piRealname;
	}

	public String getPiCompany() {
		return piCompany;
	}

	public void setPiCompany(String piCompany) {
		this.piCompany = piCompany;
	}

	public String getPiPosition() {
		return piPosition;
	}

	public void setPiPosition(String piPosition) {
		this.piPosition = piPosition;
	}

	public Integer getPiWorkyear() {
		return piWorkyear;
	}

	public void setPiWorkyear(Integer piWorkyear) {
		this.piWorkyear = piWorkyear;
	}

	public String getPiEmail() {
		return piEmail;
	}

	public void setPiEmail(String piEmail) {
		this.piEmail = piEmail;
	}

	public String getPiCell() {
		return piCell;
	}

	public void setPiCell(String piCell) {
		this.piCell = piCell;
	}

	public String getPiAddr() {
		return piAddr;
	}

	public void setPiAddr(String piAddr) {
		this.piAddr = piAddr;
	}

	public Boolean getPiIsdelete() {
		return piIsdelete;
	}

	public void setPiIsdelete(Boolean piIsdelete) {
		this.piIsdelete = piIsdelete;
	}

	public String getPiContent() {
		return piContent;
	}

	public void setPiContent(String piContent) {
		this.piContent = piContent;
	}

	public String getPiLogId() {
		return piLogId;
	}

	public void setPiLogId(String piLogId) {
		this.piLogId = piLogId;
	}

	public String getPiBrief() {
		return piBrief;
	}

	public void setPiBrief(String piBrief) {
		this.piBrief = piBrief;
	}

	public Integer getPiMeetnum() {
		return piMeetnum;
	}

	public void setPiMeetnum(Integer piMeetnum) {
		this.piMeetnum = piMeetnum;
	}

	public Integer getPiDealnum() {
		return piDealnum;
	}

	public void setPiDealnum(Integer piDealnum) {
		this.piDealnum = piDealnum;
	}

	public Integer getPiResponsetime() {
		return piResponsetime;
	}

	public void setPiResponsetime(Integer piResponsetime) {
		this.piResponsetime = piResponsetime;
	}

	public String getPiUrls() {
		return piUrls;
	}

	public void setPiUrls(String piUrls) {
		this.piUrls = piUrls;
	}

	public String getPiComment() {
		return piComment;
	}

	public void setPiComment(String piComment) {
		this.piComment = piComment;
	}

	public Float getPiRek() {
		return piRek;
	}

	public void setPiRek(Float piRek) {
		this.piRek = piRek;
	}
	
	public Float getPiMark() {
		return piMark;
	}

	public void setPiMark(Float piMark) {
		this.piMark = piMark;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogCell() {
		return logCell;
	}

	public void setLogCell(String logCell) {
		this.logCell = logCell;
	}

	public String getLogEmail() {
		return logEmail;
	}

	public void setLogEmail(String logEmail) {
		this.logEmail = logEmail;
	}

	public String getLogName() {
		return logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	public String getLogPass() {
		return logPass;
	}

	public void setLogPass(String logPass) {
		this.logPass = logPass;
	}

	public Date getLogCreatetime() {
		return logCreatetime;
	}

	public void setLogCreatetime(Date logCreatetime) {
		this.logCreatetime = logCreatetime;
	}

	public Boolean getLogIsdelete() {
		return logIsdelete;
	}

	public void setLogIsdelete(Boolean logIsdelete) {
		this.logIsdelete = logIsdelete;
	}

	public Integer getLogState() {
		return logState;
	}

	public void setLogState(Integer logState) {
		this.logState = logState;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public String getLogRegip() {
		return logRegip;
	}

	public void setLogRegip(String logRegip) {
		this.logRegip = logRegip;
	}

	public Boolean getLogIslog() {
		return logIslog;
	}

	public void setLogIslog(Boolean logIslog) {
		this.logIslog = logIslog;
	}

	public String getLogComment() {
		return logComment;
	}

	public void setLogComment(String logComment) {
		this.logComment = logComment;
	}

	public String getPrId() {
		return prId;
	}

	public void setPrId(String prId) {
		this.prId = prId;
	}

	public String getPrDetails() {
		return prDetails;
	}

	public void setPrDetails(String prDetails) {
		this.prDetails = prDetails;
	}

	public String getPrPhoto() {
		return prPhoto;
	}

	public void setPrPhoto(String prPhoto) {
		this.prPhoto = prPhoto;
	}

	public Date getPrCreatetime() {
		return prCreatetime;
	}

	public void setPrCreatetime(Date prCreatetime) {
		this.prCreatetime = prCreatetime;
	}

	public Integer getPrState() {
		return prState;
	}

	public void setPrState(Integer prState) {
		this.prState = prState;
	}

	public Integer getPrSort() {
		return prSort;
	}

	public void setPrSort(Integer prSort) {
		this.prSort = prSort;
	}

	public String getPrLogId() {
		return prLogId;
	}

	public void setPrLogId(String prLogId) {
		this.prLogId = prLogId;
	}

	public String getPrComment() {
		return prComment;
	}

	public void setPrComment(String prComment) {
		this.prComment = prComment;
	}

	public String getPsetId() {
		return psetId;
	}

	public void setPsetId(String psetId) {
		this.psetId = psetId;
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
		this.psetPrice = psetPrice;
	}

	public Float getPsetPoint() {
		return psetPoint;
	}

	public void setPsetPoint(Float psetPoint) {
		this.psetPoint = psetPoint;
	}

	public Date getPsetCreateTime() {
		return psetCreateTime;
	}

	public void setPsetCreateTime(Date psetCreateTime) {
		this.psetCreateTime = psetCreateTime;
	}

	public String getPsetLogId() {
		return psetLogId;
	}

	public void setPsetLogId(String psetLogId) {
		this.psetLogId = psetLogId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getPsetComment() {
		return psetComment;
	}

	public void setPsetComment(String psetComment) {
		this.psetComment = psetComment;
	}

	public String getPiVideo() {
		return piVideo;
	}

	public void setPiVideo(String piVideo) {
		this.piVideo = piVideo;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
}
