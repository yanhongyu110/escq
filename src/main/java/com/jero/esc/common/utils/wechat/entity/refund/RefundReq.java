package com.jero.esc.common.utils.wechat.entity.refund;

import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.utils.Configure;

/**
 * Created by fxy on 2016/12/19.
 */
public class RefundReq {

    private String appid;// 公众账号ID(32)
    private String mch_id;// 商户号(32)
    private String device_info;//设备号(32)
    private String nonce_str;// 随机字符串(32)
    private String sign;// 签名(32)
    private String sign_type; //签名类型(32)
    private String transaction_id;//微信订单号(28)
    private String out_trade_no;//商户订单号(32)
    private String out_refund_no;//商户退款单号(32)
    private int total_fee;//订单金额
    private int refund_fee; //退款金额
    private String refund_fee_type;//货币种类
    private String op_user_id;//操作员(32)
    private String refund_account;//退款资金来源(30)

    public RefundReq(String out_trade_no,String transaction_id,String out_refund_no,int total_fee,int refund_fee){
    	setAppid(Configure.getAppID());
    	setMch_id(Configure.getMchID());
    	setDevice_info("WEB");
    	setNonce_str(FastRandom.getRandom(32));
    	setRefund_fee_type("CNY");
    	setOp_user_id(Configure.getMchID());
    	
    	//商户订单号(32)
    	setOut_trade_no(out_trade_no);
    	//微信订单号(28)
    	setTransaction_id(transaction_id);
    	//商户退款单号(32)
    	setOut_refund_no(out_refund_no);
    	//订单金额
    	setTotal_fee(total_fee);    
    	//退款金额
    	setRefund_fee(refund_fee);
    	
    }
    
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

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public int getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(int refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getRefund_fee_type() {
        return refund_fee_type;
    }

    public void setRefund_fee_type(String refund_fee_type) {
        this.refund_fee_type = refund_fee_type;
    }

    public String getOp_user_id() {
        return op_user_id;
    }

    public void setOp_user_id(String op_user_id) {
        this.op_user_id = op_user_id;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public void setRefund_account(String refund_account) {
        this.refund_account = refund_account;
    }
}
