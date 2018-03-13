package com.jero.esc.common.weixin.result;

/**
 * 
 * <pre>
 * <b> 发送现金红包返回实体类 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2017-12-13上午9:46:53
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2017-12-13上午9:46:53         new file.
 * </pre>
 */
public class RedPacketResult {

	/** 返回状态码 */
	private String return_code;
	/** 返回信息 */
	private String return_msg;
	/** 签名 */
	private String sign;
	/** 业务结果 */
	private String result_code;
	/** 错误代码 */
	private String err_code;
	/** 错误代码描述 */
	private String err_code_des;
	/** 商户订单号 */
	private String mch_billno;
	/** 商户号 */
	private String mch_id;
	/** 公众账号appid */
	private String wxappid;
	/** 用户openid	 */
	private String re_openid;
	/** 付款金额 */
	private String total_amount;
	/** 微信单号 */
	private String send_listid;
	/**  
	 * 获取 return_code  
	 * @return return_code return_code  
	 */
	public String getReturn_code() {
		return return_code;
	}
	/**  
	 * 设置 return_code  
	 * @param return_code return_code  
	 */
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	/**  
	 * 获取 return_msg  
	 * @return return_msg return_msg  
	 */
	public String getReturn_msg() {
		return return_msg;
	}
	/**  
	 * 设置 return_msg  
	 * @param return_msg return_msg  
	 */
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
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
	 * 获取 result_code  
	 * @return result_code result_code  
	 */
	public String getResult_code() {
		return result_code;
	}
	/**  
	 * 设置 result_code  
	 * @param result_code result_code  
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	/**  
	 * 获取 err_code  
	 * @return err_code err_code  
	 */
	public String getErr_code() {
		return err_code;
	}
	/**  
	 * 设置 err_code  
	 * @param err_code err_code  
	 */
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	/**  
	 * 获取 err_code_des  
	 * @return err_code_des err_code_des  
	 */
	public String getErr_code_des() {
		return err_code_des;
	}
	/**  
	 * 设置 err_code_des  
	 * @param err_code_des err_code_des  
	 */
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
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
	 * 获取 send_listid  
	 * @return send_listid send_listid  
	 */
	public String getSend_listid() {
		return send_listid;
	}
	/**  
	 * 设置 send_listid  
	 * @param send_listid send_listid  
	 */
	public void setSend_listid(String send_listid) {
		this.send_listid = send_listid;
	}
}
