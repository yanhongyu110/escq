package com.jero.esc.vo.saleinfo;

import java.util.Date;
import java.util.List;

import com.jero.esc.common.utils.ConstUtil;
import com.jero.esc.common.utils.DateUtil;


public class OrderInfo {
	//订单表
    private String orderId;

    private String orderBuyer;

    private String orderSeller;

    private Date orderCreatetime;
    
    private String orderCreatetimestr;
    
	private String orderStarttime;
    
    private String orderEndtime;
    
    private String orderNo;

    private Integer orderState;

    private Date orderMeettime;

    private String orderPerson;

    private String orderPersoncell;

    private String orderArea;

    private String orderAddr;

    private String orderRequest;

    private Boolean orderIsbill;

    private String orderBilladdr;

    private String orderBillcontent;

    private String orderAq;

    private Date orderConfirmtime;

    private String orderBuyerrepaycontent;

    private String orderSellerrepaycontent;

    private String orderAdminrepaycontent;

    private String orderComment;
    
    private String osServicetitle;
    
    private String orderPrice;
    
    private String title;
    
    private Date startDate;
    
    private Date endDate;
    
    private String orderPoint;
    
    private String osServiceTitle;
    
    private Integer orderRefundstate;
    
    private Float orderRefundprice;
    
    private Date orderRefunddate;
    
    private Boolean orderIsdelete;
    
    public Boolean getOrderIsdelete() {
		return orderIsdelete;
	}

	public void setOrderIsdelete(Boolean orderIsdelete) {
		this.orderIsdelete = orderIsdelete;
	}
    
    public String getOrderPoint() {
		return orderPoint;
	}

	public void setOrderPoint(String orderPoint) {
		this.orderPoint = orderPoint;
	}

	public String getOrderStarttime() {
		return orderStarttime;
	}

	public void setOrderStarttime(String orderStarttime) {
		this.orderStarttime = orderStarttime;
	}

	public String getOrderEndtime() {
		return orderEndtime;
	}

	public void setOrderEndtime(String orderEndtime) {
		this.orderEndtime = orderEndtime;
	}

	public String getOsServiceTitle() {
		return osServiceTitle;
	}

	public void setOsServiceTitle(String osServiceTitle) {
		this.osServiceTitle = osServiceTitle;
	}

	public String getOrderMeettimestr() {
		return DateUtil.dateToFullString(orderMeettime);
	}

	public void setOrderMeettimestr(String orderMeettimestr) {
		this.orderMeettimestr = orderMeettimestr;
	}

	private String orderMeettimestr;
    
    List<OrderService> orderService;
    
    public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setOrderService(List<OrderService> orderService) {
		this.orderService = orderService;
	}
    
	public List<OrderService> getOrderService() {
		return orderService;
	}

    public String getOsServicetitle() {
		return osServicetitle;
	}

	public void setOsServicetitle(String osServicetitle) {
		this.osServicetitle = osServicetitle;
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

    public String getOrderCreatetimestr() {
		return DateUtil.dateToBarString(orderCreatetime);
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
    
    
    
    public Integer getOrderRefundstate() {
    	return orderRefundstate;
	}
    
    public String getOrderRefundstateStr() {
    	return ConstUtil.ORDER_REFUNDSTATE.get(orderRefundstate);
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

	public String getOrderConfirmtimeStr() {
        return DateUtil.dateToFullString(getOrderConfirmtime());
    }
    
    public String getOrderCreatetimeStr() {
        return DateUtil.dateToFullString(getOrderCreatetime());
    }
    
    public String getOrderMeettimeStr() {
        return DateUtil.dateToFullString(getOrderMeettime());
    }
    
    public String getOrderStateStr(){
    	return ConstUtil.ORDER_STATE_MAP.get(orderState);
    }
}