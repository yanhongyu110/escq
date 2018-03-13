package com.jero.esc.po.userinfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.fastvalidate.FastValidateAnnotation;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;
import com.jero.esc.po.map.Point;

public class ProviderInfo {

	
	//服务商
	
	private int serviceNum;

	public int getServiceNum() {
		return serviceNum;
	}
	public void setServiceNum(int serviceNum) {
		this.serviceNum = serviceNum;
	}

	private  String piCom;

    public String getPiCom() {
        return piCom;
    }
    public void setPiCom(String piCom) {
        this.piCom = piCom;
    }

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
		return piTotal;
	}

	public void setPiTotal(float piTotal) {
		JSONObject temp=JSONObject.parseObject(piRemark);
		this.piTotal = temp.getFloat("total");
	}

	public float getPiAver() {
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

    private String logId;
    @FastValidateAnnotation(name = "服务商简介")
    private String piBrief;

    private Integer piMeetnum;

    private Integer piDealnum;

    private Integer piResponsetime;

    private Point point;

    private String piUrls;

    private String piComment;
    
    private Float piMark;
    
    private String pointt;
    
    private String piVideo;
    

	
	
	public String getPiVideo() {
		return piVideo;
	}

	public void setPiVideo(String piVideo) {
		this.piVideo = piVideo;
	}

	public String getPointt() {
		return pointt;
	}

	public void setPointt(String pointt) {
		this.point = JSONObject.parseObject(pointt,Point.class);
	}

	//服务商头像
    private String userPhoto;
    
    //服务信息
    private List<ServiceInfo> serviceInfos;


    //region Description


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

    public List<ServiceInfo> getServiceInfos() {
		return serviceInfos;
	}

	public void setServiceInfos(List<ServiceInfo> serviceInfos) {
		this.serviceInfos = serviceInfos;
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

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
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

	public Float getPiMark() {
		return piMark;
	}

	public void setPiMark(Float piMark) {
		this.piMark = piMark;
	}
    
    //endregion
    

}