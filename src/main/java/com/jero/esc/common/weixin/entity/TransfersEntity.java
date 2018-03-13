package com.jero.esc.common.weixin.entity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import com.jero.esc.common.utils.DateUtil;

/**
 * 
 * <pre>
 * <b> 微信提现实体类 .</b>
 * <b>Description:</b> 
 *    微信商户号转账到个人账户
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2017-12-12上午9:34:50
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2017-12-12上午9:34:50         new file.
 * </pre>
 */
public class TransfersEntity {
	//微信公众号
	private String mch_appid;
	//微信商户号
	private String mchid;
	//随机字符串 不长于32位
	private String nonce_str;
	//订单号 保证唯一性
	private String partner_trade_no;
	//收账的用户
	private String openid;
	/**
	 * NO_CHECK：不校验真实姓名
	 * FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）
	 * OPTION_CHECK：针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
	 */
	private String check_name;
	//企业付款金额 单位:分
	private String amount;
	//企业付款操作说明信息。必填
	private String desc;
	//调用接口的ip
	private String spbill_create_ip;
	//签名
	private String sign;
	
	public TransfersEntity() throws UnknownHostException {
		super();
		this.mch_appid = "wxd0c763640d4b8f08";
		this.mchid = "1486272382";
		this.nonce_str = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
		this.partner_trade_no = DateUtil.getPayMentId();
		this.desc = "近到家公众平台提现";
		this.spbill_create_ip = InetAddress.getLocalHost().getHostAddress();
		this.check_name = "NO_CHECK";//不校验
	}
	/**  
	 * 获取 mch_appid  
	 * @return mch_appid mch_appid  
	 */
	public String getMch_appid() {
		return mch_appid;
	}
	/**  
	 * 设置 mch_appid  
	 * @param mch_appid mch_appid  
	 */
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}
	/**  
	 * 获取 mchid  
	 * @return mchid mchid  
	 */
	public String getMchid() {
		return mchid;
	}
	/**  
	 * 设置 mchid  
	 * @param mchid mchid  
	 */
	public void setMchid(String mchid) {
		this.mchid = mchid;
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
	 * 获取 partner_trade_no  
	 * @return partner_trade_no partner_trade_no  
	 */
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	/**  
	 * 设置 partner_trade_no  
	 * @param partner_trade_no partner_trade_no  
	 */
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
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
	/**  
	 * 获取 check_name  
	 * @return check_name check_name  
	 */
	public String getCheck_name() {
		return check_name;
	}
	/**  
	 * 设置 check_name  
	 * @param check_name check_name  
	 */
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	/**  
	 * 获取 amount  
	 * @return amount amount  
	 */
	public String getAmount() {
		return amount;
	}
	/**  
	 * 设置 amount  
	 * @param amount amount  
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**  
	 * 获取 desc  
	 * @return desc desc  
	 */
	public String getDesc() {
		return desc;
	}
	/**  
	 * 设置 desc  
	 * @param desc desc  
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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
}
