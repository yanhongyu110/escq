package com.jero.esc.po.saleinfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.goodsinfo.ServiceRemark;
import com.jero.esc.po.goodsinfo.ServiceSnapshot;
import com.jero.esc.po.goodsinfo.ServiceStep;

import java.util.List;

public class OrderService {

    private String osId;

    private String orderId;

    private String sersId;

    private Float osGoodsNum;

    private String ssId;

    private String osComment;

    //属性 json
    private String osAttrs;

    //价格
    private Float osPrice;

    //积分
    private Float osPoint;

    private String osSource;

    private  String osSetps;

    private  Object box;

    //商品快照
    private ServiceSnapshot serviceSnapshot;

    private ServiceInfo serviceInfo;

    //得到阶段
    public List<ServiceStep> getJieDuan(){
            return JSONArray.parseArray(osSetps,ServiceStep.class);
    }

    private ServiceRemark serviceRemark;

    private  OrderInfo orderInfo;


    public ServiceInfo getServiceInfo() {
        if (serviceInfo==null){
            JSONArray.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
            this.serviceInfo= JSONObject.parseObject(serviceSnapshot.getSersInfo(),ServiceInfo.class);
        }
        return this.serviceInfo;
    }


    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public ServiceRemark getServiceRemark() {
        return serviceRemark;
    }

    public void setServiceRemark(ServiceRemark serviceRemark) {
        this.serviceRemark = serviceRemark;
    }

    public String getOsSetps() {
        return osSetps;
    }

    public void setOsSetps(String osSetps) {
        this.osSetps = osSetps;
    }

    public Object getBox() {
        return box;
    }

    public void setBox(Object box) {
        this.box = box;
    }

    public ServiceSnapshot getServiceSnapshot() {
        return serviceSnapshot;
    }

    public void setServiceSnapshot(ServiceSnapshot serviceSnapshot) {
        this.serviceSnapshot = serviceSnapshot;
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

    public String getSersId() {
        return sersId;
    }

    public void setSersId(String sersId) {
        this.sersId = sersId == null ? null : sersId.trim();
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


}