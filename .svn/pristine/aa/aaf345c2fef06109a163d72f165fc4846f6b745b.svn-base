package com.jero.esc.po.goodsinfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValidateAnnotation;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;
import com.jero.esc.po.details.PriceSet;

import java.util.Date;
import java.util.List;

public class ServiceInfo {
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

    private String serviceId;

    private String logId;

    private String serviceRemark;
    
    private int count;
    
    private float total;
    
    private float aver;
    
    public float getAver() {
		return aver;
	}

	public void setAver(float aver) {
		if(count!=0){
			this.aver = total/count;
		}else{
			this.aver = 0;
		}
		
	}

	public String getServiceRemark() {
        return serviceRemark;
    }

    public void setServiceRemark(String serviceRemark) {
        this.serviceRemark = serviceRemark;
    }
	
	private JSONObject temp=JSONObject.parseObject(serviceRemark);

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if(temp != null){
			this.count = temp.getInteger("count");
		}
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		if(temp != null){
			this.total = temp.getFloat("total");
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

    //0 待审核  1 审核通过
    private Integer serviceState;

    private Float serviceMeettime;

    private String serviceType;

    private String serviceAttrinfo;

    private String serviceKeywords;

    private String serviceComment;

    private  String servicePic;

    private  String typeTree;
    
    private Float serviceMark;

    public String getTypeTree() {
        return typeTree;
    }

    public void setTypeTree(String typeTree) {
        this.typeTree = typeTree;
    }

    public String getServicePic() {
        return servicePic;
    }

    public void setServicePic(String servicePic) {
        this.servicePic = servicePic;
    }

    private Object box;

    //快照
    private List<ServiceSnapshot> serviceSnapshots;

    //评价
    private List<ServiceRemark> serviceRemarks;

    private List<PriceSet> priceSets;

    //阶段
    private  List<ServiceStep> serviceSteps;


    public PriceSet getPriceBySource(int Source)throws Exception{
        List<PriceSet> priceSets = JSONArray.parseArray(this.getServicePrice(), PriceSet.class);
        for (int i = 0; i < priceSets.size(); i++) {
            if (priceSets.get(i).getPsetDiscountType()==Source){
                return priceSets.get(i);
            }
            if (i>=(priceSets.size()-1)){
                throw  new ExceptionWithMessage("取得金额失败");
            }
        }
        return null;
    }














    public List<ServiceStep> getServiceSteps() {
        return serviceSteps;
    }

    public void setServiceSteps(List<ServiceStep> serviceSteps) {
        this.serviceSteps = serviceSteps;
    }

    public List<ServiceSnapshot> getServiceSnapshots() {
        return serviceSnapshots;
    }

    public void setServiceSnapshots(List<ServiceSnapshot> serviceSnapshots) {
        this.serviceSnapshots = serviceSnapshots;
    }

    public List<ServiceRemark> getServiceRemarks() {
        return serviceRemarks;
    }

    public void setServiceRemarks(List<ServiceRemark> serviceRemarks) {
        this.serviceRemarks = serviceRemarks;
    }

    public List<PriceSet> getPriceSets() {
        return priceSets;
    }

    public void setPriceSets(List<PriceSet> priceSets) {
        this.priceSets = priceSets;
    }

    public Object getBox() {
        return box;
    }

    public void setBox(Object box) {
        this.box = box;
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
    
    public Float getServiceMark() {
		return serviceMark;
	}

	public void setServiceMark(Float serviceMark) {
		this.serviceMark = serviceMark;
	}
    
}