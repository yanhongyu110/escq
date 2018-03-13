package com.jero.esc.common.utils.wechat.entity.bill;

import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.utils.Configure;

/**
 * Created by fxy on 2016/12/19.
 */
public class BillReq {

    private String appid;// 公众账号ID(32)
    private String mch_id;// 商户号(32)
    private String device_info;//设备号(32)
    private String nonce_str;// 随机字符串(32)
    private String sign;// 签名(32)
    private String sign_type; //签名类型(32)
    private String bill_date;//对账单日期(8) String(8) 20140603
    private String bill_type;//账单类型(8)
    private String tar_type;//压缩账单(8)

    public  BillReq(String bill_date,String bill_type){
    	setAppid(Configure.getAppID());
    	setMch_id(Configure.getMchID());
    	setDevice_info("WEB");
    	setNonce_str(FastRandom.getRandom(32));
    	//setTar_type("GZIP");
    	//账单类型(8)
        setBill_type(bill_type);
    	//对账单日期(8) String(8) 20140603
        setBill_date(bill_date);
        
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

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }

    public String getTar_type() {
        return tar_type;
    }

    public void setTar_type(String tar_type) {
        this.tar_type = tar_type;
    }
}
