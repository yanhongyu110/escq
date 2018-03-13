package com.jero.esc.common.utils.wechat.entity.order;


import com.alibaba.fastjson.JSONArray;
import com.jero.esc.common.utils.DateUtil;
import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.utils.Configure;

import java.util.Date;

/**
 * @ClassName: OrderReq
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0 
 * @date 2016年12月19日
 * @description  微信支付订单表
 */
public class OrderReq {
	
	
	private String appid;// 公众账号ID(32)
	private String mch_id;// 商户号(32)
	private String device_info;//设备号(32)
	private String nonce_str;// 随机字符串(32)
	private String sign;// 签名(32)
	private String sign_type; //签名类型(32)
	private String body;// 商品描述(128)
	private String detail;//商品详情 String(6000)
	private String attach;//附加数据 String(127)
	private String out_trade_no;// 商户订单号(32)
	private String fee_type; //标价币种 （16）
	private int total_fee;// 订单总金额，单位为分
	private String spbill_create_ip;// APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	private String time_start; //交易起始时间 String（14）
	private String time_expire; //交易结束时间（14）
	private String goods_tag; //商品标记 （32）
	private String notify_url;// 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
	private String trade_type;// 取值如下：JSAPI，NATIVE，APP
	private String product_id; //商品Id (32)
	private String limit_pay; //指定支付方式（32）
	private String openid; //用户标识（128）
	private String key;//商户密钥

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/** 
	*创建一个新的实例 OrderReq.
	*@param appid  公众账号ID(32)
	*@param mch_id 商户号(32)
	*@param key 密钥
	*@param trade_type 支付类型
	*@param spbill_create_ip APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	*@param notify_url   接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
	*@param  body 商品描述(128)
	*@param detail   商品详情 String(6000)
	*@param attach  附加数据 String(127)
	*@param out_trade_no 商户订单号(32)
	*@param total_fee 订单总金额，单位为分
	*@param product_id 商品Id (32)
	*@param nonce_str 随机字符串(32)
	*/ 
	public OrderReq(String appid,String mchid,String key,String trade_type,String notify_url,String body,String detail,String attach,String out_trade_no,int total_fee,String product_id,String nonce_str){
		setBody(body);
		setDetail(detail);
		setAttach(attach);
		setOut_trade_no(out_trade_no);
		setTotal_fee(total_fee);
		setProduct_id(product_id);
		setNonce_str(nonce_str);
		//默认设置
		setAppid(appid);
		setMch_id(mchid);
		setDevice_info("WEB");
		setFee_type("CNY");
		setKey(key);
		setSpbill_create_ip(Configure.getIp());
		setTime_start(DateUtil.dateToString(new Date(),"yyyyMMddHHmmss"));
		setTime_expire(DateUtil.dateToString(new Date(new Date().getTime()+Configure.getTime_out()), "yyyyMMddHHmmss"));
		setNotify_url(notify_url);
		setTrade_type(trade_type);

//		JSONArray.toJSONString(object);
	}
	
	/*public static void main(String[] args) {
		System.out.println(DateUtil.dateToString(new Date(new Date().getTime()+1000*60*20), "yyyyMMddHHmmss"));
	}*/
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String yyyyMMddHHmmss) {
		this.time_expire = time_expire;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
