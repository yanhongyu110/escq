package com.jero.esc.common.weixin.entity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * 
 * <pre>
 * <b> 微信公众号支付 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2017-12-15下午5:45:15
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2017-12-15下午5:45:15         new file.
 * </pre>
 */
public class PaymentEntity {
	private String appid;//微信分配的公众账号ID（企业号corpid即为此appId）,例如：wxd678efh567hg6787
	private String mch_id;//商户id
	private String nonce_str;//随机字符串:数字+大写字母的组合，32位
	private String sign;//签名
	private String body;//商品或支付单简要描述
	private String out_trade_no;//商户系统内部的订单号
	private String total_fee;//总金额
	private String spbill_create_ip;//APP和网页支付提交[用户端ip]，Native支付填调用微信支付API的机器IP。
	private String notify_url;//接收微信支付异步通知回调地址
	private String trade_type;//交易类型:JSAPI，NATIVE，APP
	private String openid;//trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识
	
	
	public PaymentEntity() throws UnknownHostException {
		super();
		this.appid = "wxd0c763640d4b8f08";
		this.mch_id = "1486272382";
		this.nonce_str = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
		this.spbill_create_ip = InetAddress.getLocalHost().getHostAddress();
		this.trade_type = "JSAPI";
		this.notify_url = "";
	}
	public PaymentEntity(String appid, String mch_id, String nonce_str, String sign, String body,
			String out_trade_no, String total_fee, String spbill_create_ip, String notify_url, String trade_type, String openid) {
		super();
		this.appid = appid;
		this.mch_id = mch_id;
		this.nonce_str = nonce_str;
		this.sign = sign;
		this.body = body;
		this.out_trade_no = out_trade_no;
		this.total_fee = total_fee;
		this.spbill_create_ip = spbill_create_ip;
		this.notify_url = notify_url;
		this.trade_type = trade_type;
		this.openid = openid;
	}
	/**  
	 * 获取 appid  
	 * @return appid appid  
	 */
	public String getAppid() {
		return appid;
	}
	/**  
	 * 设置 appid  
	 * @param appid appid  
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**  
	 * 获取 mch_id  
	 * @return mch_id mch_id  
	 */
	public String getMch_id() {
		return mch_id;
	}
	/**  
	 * 设置 mch_id  
	 * @param mch_id mch_id  
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	/**  
	 * 获取 nonce_str  
	 * @return nonce_str nonce_str  
	 */
	public String getNonce_str() {
		return nonce_str;
	}
	/**  
	 * 设置 nonce_str  
	 * @param nonce_str nonce_str  
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	/**  
	 * 获取 sign  
	 * @return sign sign  
	 */
	public String getSign() {
		return sign;
	}
	/**  
	 * 设置 sign  
	 * @param sign sign  
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**  
	 * 获取 body  
	 * @return body body  
	 */
	public String getBody() {
		return body;
	}
	/**  
	 * 设置 body  
	 * @param body body  
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**  
	 * 获取 out_trade_no  
	 * @return out_trade_no out_trade_no  
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/**  
	 * 设置 out_trade_no  
	 * @param out_trade_no out_trade_no  
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	/**  
	 * 获取 total_fee  
	 * @return total_fee total_fee  
	 */
	public String getTotal_fee() {
		return total_fee;
	}
	/**  
	 * 设置 total_fee  
	 * @param total_fee total_fee  
	 */
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	/**  
	 * 获取 spbill_create_ip  
	 * @return spbill_create_ip spbill_create_ip  
	 */
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	/**  
	 * 设置 spbill_create_ip  
	 * @param spbill_create_ip spbill_create_ip  
	 */
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	/**  
	 * 获取 notify_url  
	 * @return notify_url notify_url  
	 */
	public String getNotify_url() {
		return notify_url;
	}
	/**  
	 * 设置 notify_url  
	 * @param notify_url notify_url  
	 */
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	/**  
	 * 获取 trade_type  
	 * @return trade_type trade_type  
	 */
	public String getTrade_type() {
		return trade_type;
	}
	/**  
	 * 设置 trade_type  
	 * @param trade_type trade_type  
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	/**  
	 * 获取 openid  
	 * @return openid openid  
	 */
	public String getOpenid() {
		return openid;
	}
	/**  
	 * 设置 openid  
	 * @param openid openid  
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentEntity [appid=" + appid + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", sign=" + sign
				+ ", body=" + body + ", out_trade_no=" + out_trade_no + ", total_fee=" + total_fee
				+ ", spbill_create_ip=" + spbill_create_ip + ", notify_url=" + notify_url + ", trade_type=" + trade_type
				+ ", openid=" + openid + "]";
	}
}
