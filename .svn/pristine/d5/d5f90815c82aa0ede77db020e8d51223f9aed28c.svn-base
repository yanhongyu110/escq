package com.jero.esc.common.utils.wechat.entity.queryorder;

import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.utils.Configure;

/**
 * Created by fxy on 2016/12/19.
 */
public class QueryOrderReq {
    private String appid; //公众账号ID
    private String mch_id; //商户号
    private String transaction_id;//微信订单号
    private String out_trade_no;//商户订单号
    private String nonce_str;//随机字符串
    private String sign;//签名
    private String sign_type;//签名类型

    public QueryOrderReq(String out_trade_no,String transaction_id){
    	//微信订单号
    	setTransaction_id(transaction_id);
    	//商户订单号
    	setOut_trade_no(out_trade_no);
    	
    	setAppid(Configure.getAppID());
    	setMch_id(Configure.getMchID());
    	setNonce_str(FastRandom.getRandom(32));
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
}
