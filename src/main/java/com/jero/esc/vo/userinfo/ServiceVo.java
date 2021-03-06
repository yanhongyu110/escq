package com.jero.esc.vo.userinfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.ConstUtil;
import com.jero.esc.common.utils.fastvalidate.FastValidateAnnotation;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;
import com.jero.esc.po.details.PriceSet;
import com.jero.esc.po.goodsinfo.ServiceStep;

/**
 * @copyright 上善云图信息技术有限公司
 * @author lcq
 * @version v1.0
 * @date 2016年12月18日
 * @description
 */
public class ServiceVo {


	private String  company;

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
	private  String start;

	private  String end;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	private  List<PriceSet> priceSets;

	private List<ServiceStep> serviceSteps;

	// 服务信息表
	private String serviceId;

	private String logId;

	private String serviceRemark;
	
	private int serviceCount;
    
    private float serviceTotal;
    
    private float serviceAver;
    
    public int getServiceCount() {
    	this.setServiceCount(this.serviceRemark);
		return serviceCount;
	}

	public void setServiceCount(String serviceRemark) {
		JSONObject temp=JSONObject.parseObject(this.serviceRemark);
		this.serviceCount = temp.getInteger("count");
	}

	public float getServiceTotal() {
		this.setServiceTotal(serviceRemark);
		return serviceTotal;
	}

	public void setServiceTotal(String serviceRemark) {
		JSONObject temp=JSONObject.parseObject(this.serviceRemark);
		this.serviceTotal = temp.getFloat("total");
	}

	public float getServiceAver() {
		setServiceAver(serviceAver);
		return serviceAver;
	}

	public void setServiceAver(float serviceAver) {
		if(serviceCount!=0){
			this.serviceAver = serviceTotal/serviceCount;
		}else{
			this.serviceAver = 0;
		}
	}

	


	private String serviceTitle;

	private String serviceBiref;

	private String serviceContent;

	@FastValidateAnnotation(validateType = FastValidateType.MONEY)
	private String servicePrice;

	private Float serviceResponse;

	private Integer serviceMeetnum;

	private Integer serviceSuccessnum;

	private Boolean serviceIsdelete;

	private Date serviceCreatetime;

	// 0 待审核 1 审核通过
	private Integer serviceState;

	private Float serviceMeettime;

	private String serviceType;

	private String serviceAttrinfo;

	private String serviceKeywords;

	private String serviceComment;

	private String servicePic;

	private String typeTree;

	private Float serviceMark;

	// 收藏数
	private Integer serviceCollectNum;
	// 点赞数
	private Integer serviceZanNum;

	public Integer getServiceCollectNum() {
		return serviceCollectNum;
	}

	public void setServiceCollectNum(Integer serviceCollectNum) {
		this.serviceCollectNum = serviceCollectNum;
	}

	public Integer getServiceZanNum() {
		return serviceZanNum;
	}

	public void setServiceZanNum(Integer serviceZanNum) {
		this.serviceZanNum = serviceZanNum;
	}

	public Float getServiceMark() {
		return serviceMark;
	}

	public void setServiceMark(Float serviceMark) {
		this.serviceMark = serviceMark;
	}

	public String getRemarkCount() {
		return remarkCount;
	}

	public void setRemarkCount(String remarkCount) {
		this.remarkCount = remarkCount;
	}

	private String ctName;
	// 服务商信息表

	private String piId;
	@FastValidateAnnotation(name = "所属区域")
	private String piArea;
	@FastValidateAnnotation(name = "生活照片")
	private String piPhoto;
	@FastValidateAnnotation(name = "关键字")
	private String piKeywords;

	private String piRemark;
	
private int piCount;
    
    private float piTotal;
    
    private float piAver;
    
    public int getPiCount() {
		return piCount;
	}

	public void setPiCount(int piCount) {
		JSONObject temp=JSONObject.parseObject(piRemark);
		this.piCount = temp.getInteger("count");
	}

	public float getPiTotal() {
		setPiTotal(piTotal);
		return piTotal;
	}

	public void setPiTotal(float piTotal) {
		if(piRemark!=null){
		JSONObject temp=JSONObject.parseObject(piRemark);
		this.piTotal = temp.getFloat("total");
		}
	}

	public float getPiAver() {
		setPiAver(piAver);
		return piAver;
	}

	public void setPiAver(float piAver) {
		if(piCount!=0){
			this.piAver = piTotal/piCount;
		}else{
			this.piAver = 0;
		}
	}


	private Integer piType;
	@FastValidateAnnotation(name = "真实姓名", validateType = FastValidateType.CHINESE_NAME)
	private String piRealname;
	@FastValidateAnnotation(name = "任职机构")
	private String piCompany;
	@FastValidateAnnotation(name = "任职职位")
	private String piPosition;
	@FastValidateAnnotation(name = "工作年限")
	private Integer piWorkyear;
	@FastValidateAnnotation(name = "邮箱", validateType = FastValidateType.EMAIL)
	private String piEmail;
	@FastValidateAnnotation(name = "电话", validateType = FastValidateType.CELL)
	private String piCell;
	@FastValidateAnnotation(name = "地址")
	private String piAddr;

	private Boolean piIsdelete;
	@FastValidateAnnotation(name = "服务商介绍")
	private String piContent;

	@FastValidateAnnotation(name = "服务商简介")
	private String piBrief;

	private Integer piMeetnum;

	private Integer piDealnum;

	private Integer piResponsetime;

	private String piUrls;

	private String piComment;

	private Integer countRemark;
	
	private Float piMark;

	public Float getPiMark() {
		return piMark;
	}

	public void setPiMark(Float piMark) {
		this.piMark = piMark;
	}




	// 价格表
	private String psetId;

	private Integer psetDiscountType;

	private Integer psetPointType;

	private Float psetPrice;

	private Float psetPoint;

	private Date psetCreateTime;

	private String psetLogId;

	private String psetServiceId;

	private String psetComment;

	private JSONObject piAreaJson;



	private String remarkCount;

	
	public String getSsComment() {
		return ssComment;
	}

	public void setSsComment(String ssComment) {
		this.ssComment = ssComment;
	}

	private String ssComment;

	public JSONObject getPiAreaJson() {
		if (piArea == null || "".equals(piArea)) {
			return null;
		}
//		if (piAreaJson == null) {
//			piAreaJson = JSONObject.parseObject(piArea);
//		}
		return piAreaJson;
	}


	public List<PriceSet> getPriceSets() {
		return priceSets;
	}

	public void setPriceSets(List<PriceSet> priceSets) {
		this.priceSets = priceSets;
	}

	public List<ServiceStep> getServiceSteps() {
		return serviceSteps;
	}

	public void setServiceSteps(List<ServiceStep> serviceSteps) {
		this.serviceSteps = serviceSteps;
	}

	public void setPiAreaJson(JSONObject piAreaJson) {
		this.piAreaJson = piAreaJson;
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

	public String getPsetServiceId() {
		return psetServiceId;
	}

	public void setPsetServiceId(String psetServiceId) {
		this.psetServiceId = psetServiceId;
	}

	public String getPsetComment() {
		return psetComment;
	}

	public void setPsetComment(String psetComment) {
		this.psetComment = psetComment;
	}

	public String getPiId() {
		return piId;
	}

	public void setPiId(String piId) {
		this.piId = piId == null ? null : piId.trim();
	}

	public String getPiArea() {
		return piArea;
	}

	public void setPiArea(String piArea) {
		this.piArea = piArea == null ? null : piArea.trim();
	}

	public String getPiPhoto() {
		return piPhoto;
	}

	public void setPiPhoto(String piPhoto) {
		this.piPhoto = piPhoto == null ? null : piPhoto.trim();
	}

	public String getPiKeywords() {
		return piKeywords;
	}

	public void setPiKeywords(String piKeywords) {
		this.piKeywords = piKeywords == null ? null : piKeywords.trim();
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
		this.piRealname = piRealname == null ? null : piRealname.trim();
	}

	public String getPiCompany() {
		return piCompany;
	}

	public void setPiCompany(String piCompany) {
		this.piCompany = piCompany == null ? null : piCompany.trim();
	}

	public String getPiPosition() {
		return piPosition;
	}

	public void setPiPosition(String piPosition) {
		this.piPosition = piPosition == null ? null : piPosition.trim();
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
		this.piEmail = piEmail == null ? null : piEmail.trim();
	}

	public String getPiCell() {
		return piCell;
	}

	public void setPiCell(String piCell) {
		this.piCell = piCell == null ? null : piCell.trim();
	}

	public String getPiAddr() {
		return piAddr;
	}

	public void setPiAddr(String piAddr) {
		this.piAddr = piAddr == null ? null : piAddr.trim();
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
		this.piContent = piContent == null ? null : piContent.trim();
	}

	public String getPiBrief() {
		return piBrief;
	}

	public void setPiBrief(String piBrief) {
		this.piBrief = piBrief == null ? null : piBrief.trim();
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
		this.piComment = piComment == null ? null : piComment.trim();
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId == null ? null : serviceId.trim();
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId == null ? null : logId.trim();
	}

	public String getServiceRemark() {
		return serviceRemark;
	}

	public void setServiceRemark(String serviceRemark) {
		this.serviceRemark = serviceRemark;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle == null ? null : serviceTitle.trim();
	}

	public String getServiceBiref() {
		return serviceBiref;
	}

	public void setServiceBiref(String serviceBiref) {
		this.serviceBiref = serviceBiref == null ? null : serviceBiref.trim();
	}

	public String getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent == null ? null : serviceContent.trim();
	}

	public String getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice == null ? null : servicePrice.trim();
	}

	public Float getServiceResponse() {
		return serviceResponse;
	}

	public void setServiceResponse(Float serviceResponse) {
		this.serviceResponse = serviceResponse;
	}

	public Integer getServiceMeetnum() {
		return serviceMeetnum;
	}

	public void setServiceMeetnum(Integer serviceMeetnum) {
		this.serviceMeetnum = serviceMeetnum;
	}

	public Integer getServiceSuccessnum() {
		return serviceSuccessnum;
	}

	public void setServiceSuccessnum(Integer serviceSuccessnum) {
		this.serviceSuccessnum = serviceSuccessnum;
	}

	public Boolean getServiceIsdelete() {
		return serviceIsdelete;
	}

	public void setServiceIsdelete(Boolean serviceIsdelete) {
		this.serviceIsdelete = serviceIsdelete;
	}

	public Date getServiceCreatetime() {
		return serviceCreatetime;
	}

	public void setServiceCreatetime(Date serviceCreatetime) {
		this.serviceCreatetime = serviceCreatetime;
	}

	public Integer getServiceState() {
		return serviceState;
	}
	
	public String getServiceStateStr() {
		return ConstUtil.SERVICE_STATE_MAP.get(serviceState);
	}

	public void setServiceState(Integer serviceState) {
		this.serviceState = serviceState;
	}

	public Float getServiceMeettime() {
		return serviceMeettime;
	}

	public void setServiceMeettime(Float serviceMeettime) {
		this.serviceMeettime = serviceMeettime;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceAttrinfo() {
		return serviceAttrinfo;
	}

	public void setServiceAttrinfo(String serviceAttrinfo) {
		this.serviceAttrinfo = serviceAttrinfo == null ? null : serviceAttrinfo.trim();
	}

	public String getServiceKeywords() {
		return serviceKeywords;
	}

	public void setServiceKeywords(String serviceKeywords) {
		this.serviceKeywords = serviceKeywords == null ? null : serviceKeywords.trim();
	}

	public String getServiceComment() {
		return serviceComment;
	}

	public void setServiceComment(String serviceComment) {
		this.serviceComment = serviceComment == null ? null : serviceComment.trim();
	}

	public String getServicePic() {
		return servicePic;
	}

	public void setServicePic(String servicePic) {
		this.servicePic = servicePic;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public Integer getCountRemark() {
		return countRemark;
	}

	public void setCountRemark(Integer countRemark) {
		this.countRemark = countRemark;
	}

	private String psetCreateTimeString;

	public String getTypeTree() {
		return typeTree;
	}

	public void setTypeTree(String typeTree) {
		this.typeTree = typeTree;
	}

	public String getPsetCreateTimeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (serviceCreatetime != null) {
			psetCreateTimeString = sdf.format(serviceCreatetime);
		}
		return psetCreateTimeString;
	}

	public void setPsetCreateTimeString(String psetCreateTimeString) {
		this.psetCreateTimeString = psetCreateTimeString;
	}
	private String distance;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
	
}
