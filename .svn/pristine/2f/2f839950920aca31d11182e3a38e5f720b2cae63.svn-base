package com.jero.esc.po.saleinfo;


import java.util.Date;
import java.util.List;

import com.jero.esc.common.utils.fastvalidate.FastValidateAnnotation;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;
import com.jero.esc.po.details.OrderDoneDetails;
import com.jero.esc.po.details.PayDetails;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.po.userinfo.UserInfo;

public class OrderInfo {

    private String orderId;
        
    private String orderBuyer;
    
    @FastValidateAnnotation(emptyMessage="订单买家为空")
    private String orderSeller;

    private Date orderCreatetime;

    @FastValidateAnnotation(validateType=FastValidateType.EMAIL)
    private String orderNo;

    @FastValidateAnnotation(comment = "0:用户提交,1:未通过,2:专家通过,3:资金托管,4:确认收款,5:评价完成,6:取消")
    private Integer orderState;

    @FastValidateAnnotation(emptyMessage="订单约见时间为空")
    private Date orderMeettime;
    
    @FastValidateAnnotation(emptyMessage="订单约见人为空")
    private String orderPerson;

    //@FastValidateAnnotation(emptyMessage="订单约见人电话为空",validateType=FastValidateType.CELL)
    private String orderPersoncell;

    @FastValidateAnnotation(emptyMessage="订单约见区域电话为空")
    private String orderArea;

    //@FastValidateAnnotation(name = "约见地址详情",emptyMessage="订单约见地点电话为空", invalidMessage = "订单约见地点格式不对",comment = "{addr:详细位置,potin:{lng:经度,lat:纬度}}",validateType = FastValidateType.JSON)
    private String orderAddr;

    private String orderRequest;

    @FastValidateAnnotation(emptyMessage="订单是否使用发票为空")
    private Boolean orderIsbill;

    @FastValidateAnnotation(emptyMessage="订单发票地址为空")
    private String orderBilladdr;

    @FastValidateAnnotation(emptyMessage="订单发票详情为空")
    private String orderBillcontent;

    @FastValidateAnnotation(validateType = FastValidateType.JSON)
    private String orderAq;

    @FastValidateAnnotation(name = "确认时间")
    private Date orderConfirmtime;

    private String orderBuyerrepaycontent;

    private String orderSellerrepaycontent;

    private String orderAdminrepaycontent;

    private String orderComment;

    private  Float orderPrice;

    private  Float orderPoint;

    private Integer orderRefundstate;
    
    private Float orderRefundprice;
    
    private Date orderRefunddate;


    //关系字段****************************************************************
    //****************************************************************

    //订单商品
    private List<OrderService> orderService;
    //订单阶段
    private  List<OrderDoneDetails> orderDoneDetailses;
    //付款明细
    private  List<PayDetails> payDetailses;
    //卖家
    private ProviderInfo providerInfo;
    //买家
    private UserInfo userInfo;

    //****************************************************************
    //关系字段****************************************************************


    private  Object box;



    public Integer getOrderRefundstate() {
		return orderRefundstate;
	}

	public void setOrderRefundstate(Integer orderRefundstate) {
		this.orderRefundstate = orderRefundstate;
	}

	public Float getOrderRefundprice() {
		return orderRefundprice;
	}

	public void setOrderRefundprice(Float orderRefundprice) {
		this.orderRefundprice = orderRefundprice;
	}
	
	public Date getOrderRefunddate() {
		return orderRefunddate;
	}

	public void setOrderRefunddate(Date orderRefunddate) {
		this.orderRefunddate = orderRefunddate;
	}

	public Object getBox() {
        return box;
    }

    public void setBox(Object box) {
        this.box = box;
    }

    public ProviderInfo getProviderInfo() {
        return providerInfo;
    }public void setProviderInfo(ProviderInfo providerInfo) {
        this.providerInfo = providerInfo;
    }public UserInfo getUserInfo() {
        return userInfo;
    }public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    public List<OrderDoneDetails> getOrderDoneDetailses() {
        return orderDoneDetailses;
    }public void setOrderDoneDetailses(List<OrderDoneDetails> orderDoneDetailses) {
        this.orderDoneDetailses = orderDoneDetailses;
    }public List<PayDetails> getPayDetailses() {
        return payDetailses;
    }public void setPayDetailses(List<PayDetails> payDetailses) {
        this.payDetailses = payDetailses;
    }

    public List<OrderService> getOrderService() {
        return orderService;
    }

    public void setOrderService(List<OrderService> orderService) {
        this.orderService = orderService;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Float getOrderPoint() {
        return orderPoint;
    }

    public void setOrderPoint(Float orderPoint) {
        this.orderPoint = orderPoint;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderBuyer() {
        return orderBuyer;
    }

    public void setOrderBuyer(String orderBuyer) {
        this.orderBuyer = orderBuyer == null ? null : orderBuyer.trim();
    }

    public String getOrderSeller() {
        return orderSeller;
    }

    public void setOrderSeller(String orderSeller) {
        this.orderSeller = orderSeller == null ? null : orderSeller.trim();
    }

    public Date getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(Date orderCreatetime) {
        this.orderCreatetime = orderCreatetime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderMeettime() {
        return orderMeettime;
    }

    public void setOrderMeettime(Date orderMeettime) {
        this.orderMeettime = orderMeettime;
    }

    public String getOrderPerson() {
        return orderPerson;
    }

    public void setOrderPerson(String orderPerson) {
        this.orderPerson = orderPerson == null ? null : orderPerson.trim();
    }

    public String getOrderPersoncell() {
        return orderPersoncell;
    }

    public void setOrderPersoncell(String orderPersoncell) {
        this.orderPersoncell = orderPersoncell == null ? null : orderPersoncell.trim();
    }

    public String getOrderArea() {
        return orderArea;
    }

    public void setOrderArea(String orderArea) {
        this.orderArea = orderArea == null ? null : orderArea.trim();
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr == null ? null : orderAddr.trim();
    }

    public String getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(String orderRequest) {
        this.orderRequest = orderRequest == null ? null : orderRequest.trim();
    }

    public Boolean getOrderIsbill() {
        return orderIsbill;
    }

    public void setOrderIsbill(Boolean orderIsbill) {
        this.orderIsbill = orderIsbill;
    }

    public String getOrderBilladdr() {
        return orderBilladdr;
    }

    public void setOrderBilladdr(String orderBilladdr) {
        this.orderBilladdr = orderBilladdr == null ? null : orderBilladdr.trim();
    }

    public String getOrderBillcontent() {
        return orderBillcontent;
    }

    public void setOrderBillcontent(String orderBillcontent) {
        this.orderBillcontent = orderBillcontent == null ? null : orderBillcontent.trim();
    }

    public String getOrderAq() {
        return orderAq;
    }

    public void setOrderAq(String orderAq) {
        this.orderAq = orderAq == null ? null : orderAq.trim();
    }

    public Date getOrderConfirmtime() {
        return orderConfirmtime;
    }

    public void setOrderConfirmtime(Date orderConfirmtime) {
        this.orderConfirmtime = orderConfirmtime;
    }

    public String getOrderBuyerrepaycontent() {
        return orderBuyerrepaycontent;
    }

    public void setOrderBuyerrepaycontent(String orderBuyerrepaycontent) {
        this.orderBuyerrepaycontent = orderBuyerrepaycontent == null ? null : orderBuyerrepaycontent.trim();
    }

    public String getOrderSellerrepaycontent() {
        return orderSellerrepaycontent;
    }

    public void setOrderSellerrepaycontent(String orderSellerrepaycontent) {
        this.orderSellerrepaycontent = orderSellerrepaycontent == null ? null : orderSellerrepaycontent.trim();
    }

    public String getOrderAdminrepaycontent() {
        return orderAdminrepaycontent;
    }

    public void setOrderAdminrepaycontent(String orderAdminrepaycontent) {
        this.orderAdminrepaycontent = orderAdminrepaycontent == null ? null : orderAdminrepaycontent.trim();
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment == null ? null : orderComment.trim();
    }
    private  String company;
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
}