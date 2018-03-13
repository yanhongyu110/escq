package com.jero.esc.common.weixin.entity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import com.jero.esc.common.utils.DateUtil;

/**
 * 
 * <pre>
 * <b> 发送红包实体类 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2017-11-29下午3:17:46
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2017-11-29下午3:17:46         new file.
 * </pre>
 */
public class RedPacketEntity {
    private String nonce_str;// 随机字符串
    private String mch_billno;// 商户订单号
    private String mch_id;// 商户号
    private String wxappid;// 公众账号
    private String send_name;// 商户名称
    private String re_openid;// 用户
    private String total_amount;// 付款金额 单位：分
    private String total_num;// 红包发放总人数
    private String wishing;// 红包祝福语
    private String client_ip;// Ip地址
    private String act_name;// 活动名称
    private String remark;// 备注
    private String sign;// 签名 
    
    
    
    
    public RedPacketEntity(String nonce_str, String sign, String mch_billno, String mch_id, String wxappid, String send_name,
			String re_openid, String total_amount, String total_num, String wishing, String client_ip, String act_name, String remark) {
		super();
		this.nonce_str = nonce_str;
		this.sign = sign;
		this.mch_billno = mch_billno;
		this.mch_id = mch_id;
		this.wxappid = wxappid;
		this.send_name = send_name;
		this.re_openid = re_openid;
		this.total_amount = total_amount;
		this.total_num = total_num;
		this.wishing = wishing;
		this.client_ip = client_ip;
		this.act_name = act_name;
		this.remark = remark;
	}
	public RedPacketEntity() throws UnknownHostException{
    	this.nonce_str = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    	this.mch_billno = DateUtil.getPayMentId();
    	this.mch_id = "1486272382";
    	this.wxappid = "wxd0c763640d4b8f08";
    	this.send_name = "近到家公众平台";
    	this.total_amount = "200";
    	this.total_num = "1";
    	this.wishing = "注册新用户,万元红包等你拿";
    	this.client_ip = InetAddress.getLocalHost().getHostAddress();
    	this.act_name = "注册有奖";
    	this.remark = "近到家";
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
	 * 获取 mch_billno  
	 * @return mch_billno mch_billno  
	 */
	public String getMch_billno() {
		return mch_billno;
	}
	/**  
	 * 设置 mch_billno  
	 * @param mch_billno mch_billno  
	 */
	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
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
	 * 获取 wxappid  
	 * @return wxappid wxappid  
	 */
	public String getWxappid() {
		return wxappid;
	}
	/**  
	 * 设置 wxappid  
	 * @param wxappid wxappid  
	 */
	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}
	/**  
	 * 获取 send_name  
	 * @return send_name send_name  
	 */
	public String getSend_name() {
		return send_name;
	}
	/**  
	 * 设置 send_name  
	 * @param send_name send_name  
	 */
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	/**  
	 * 获取 re_openid  
	 * @return re_openid re_openid  
	 */
	public String getRe_openid() {
		return re_openid;
	}
	/**  
	 * 设置 re_openid  
	 * @param re_openid re_openid  
	 */
	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}
	/**  
	 * 获取 total_amount  
	 * @return total_amount total_amount  
	 */
	public String getTotal_amount() {
		return total_amount;
	}
	/**  
	 * 设置 total_amount  
	 * @param total_amount total_amount  
	 */
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	/**  
	 * 获取 total_num  
	 * @return total_num total_num  
	 */
	public String getTotal_num() {
		return total_num;
	}
	/**  
	 * 设置 total_num  
	 * @param total_num total_num  
	 */
	public void setTotal_num(String total_num) {
		this.total_num = total_num;
	}
	/**  
	 * 获取 wishing  
	 * @return wishing wishing  
	 */
	public String getWishing() {
		return wishing;
	}
	/**  
	 * 设置 wishing  
	 * @param wishing wishing  
	 */
	public void setWishing(String wishing) {
		this.wishing = wishing;
	}
	/**  
	 * 获取 client_ip  
	 * @return client_ip client_ip  
	 */
	public String getClient_ip() {
		return client_ip;
	}
	/**  
	 * 设置 client_ip  
	 * @param client_ip client_ip  
	 */
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	/**  
	 * 获取 act_name  
	 * @return act_name act_name  
	 */
	public String getAct_name() {
		return act_name;
	}
	/**  
	 * 设置 act_name  
	 * @param act_name act_name  
	 */
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}
	/**  
	 * 获取 remark  
	 * @return remark remark  
	 */
	public String getRemark() {
		return remark;
	}
	/**  
	 * 设置 remark  
	 * @param remark remark  
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RedPacketEntity [nonce_str=" + nonce_str + ", sign=" + sign + ", mch_billno=" + mch_billno + ", mch_id="
				+ mch_id + ", wxappid=" + wxappid + ", send_name=" + send_name + ", re_openid=" + re_openid + ", total_amount="
				+ total_amount + ", total_num=" + total_num + ", wishing=" + wishing + ", client_ip=" + client_ip
				+ ", act_name=" + act_name + ", remark=" + remark + "]";
	}
}
