package com.jero.esc.common.utils.wechat.entity.queryrefund;

/**
 * Created by fxy on 2016/12/19.
 */
public class QueryRefundRes {


    private String return_code;//返回状态码 16
    private String return_msg; // 返回信息 128
    private String result_code; //业务结果 16
    private String err_code;//错误代码 32
    private String err_code_des;//错误代码描述 128
    private String appid;// 公众账号ID(32)
    private String mch_id;// 商户号(32)
    private String device_info;//设备号(32)
    private String nonce_str;// 随机字符串(32)
    private String sign;// 签名(32)
    private String transaction_id;//微信订单号(28)
    private String out_trade_no;//商户订单号(32)
    private int total_fee;//订单金额
    private int settlement_total_fee;//应结订单金额
    private int fee_type; //货币种类
    private int cash_fee;//现金支付金额
    private int refund_count;//退款笔数
    private String out_refund_no;//商户退款单号(32)
    private String refund_id;//微信退款单号(28)
    private String refund_channel;//退款渠道(16)
    private int refund_fee_$n;//申请退款金额
    private int refund_fee; //退款金额
    private String refund_account;//退款资金来源 (30)
    private String coupon_type_$n;//代金券类型(8)
    private int coupon_refund_fee;//代金券退款总金额
    private int coupon_refund_count;//退款代金券使用数量
    private String coupon_refund_id_$n;//退款代金券ID(20)
    private  int coupon_refund_fee_$n;//单个代金券退款金额
    private String refund_status_$n;//退款状态 (16)
    private String refund_recv_accout_$n; //退款入账账户(64)

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
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

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public void setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public int getFee_type() {
        return fee_type;
    }

    public void setFee_type(int fee_type) {
        this.fee_type = fee_type;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
    }

    public int getRefund_count() {
        return refund_count;
    }

    public void setRefund_count(int refund_count) {
        this.refund_count = refund_count;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public String getRefund_channel() {
        return refund_channel;
    }

    public void setRefund_channel(String refund_channel) {
        this.refund_channel = refund_channel;
    }

    public int getRefund_fee_$n() {
        return refund_fee_$n;
    }

    public void setRefund_fee_$n(int refund_fee_$n) {
        this.refund_fee_$n = refund_fee_$n;
    }

    public int getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(int refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getRefund_account() {
        return refund_account;
    }

    public void setRefund_account(String refund_account) {
        this.refund_account = refund_account;
    }

    public String getCoupon_type_$n() {
        return coupon_type_$n;
    }

    public void setCoupon_type_$n(String coupon_type_$n) {
        this.coupon_type_$n = coupon_type_$n;
    }

    public int getCoupon_refund_fee() {
        return coupon_refund_fee;
    }

    public void setCoupon_refund_fee(int coupon_refund_fee) {
        this.coupon_refund_fee = coupon_refund_fee;
    }

    public int getCoupon_refund_count() {
        return coupon_refund_count;
    }

    public void setCoupon_refund_count(int coupon_refund_count) {
        this.coupon_refund_count = coupon_refund_count;
    }

    public String getCoupon_refund_id_$n() {
        return coupon_refund_id_$n;
    }

    public void setCoupon_refund_id_$n(String coupon_refund_id_$n) {
        this.coupon_refund_id_$n = coupon_refund_id_$n;
    }

    public int getCoupon_refund_fee_$n() {
        return coupon_refund_fee_$n;
    }

    public void setCoupon_refund_fee_$n(int coupon_refund_fee_$n) {
        this.coupon_refund_fee_$n = coupon_refund_fee_$n;
    }

    public String getRefund_status_$n() {
        return refund_status_$n;
    }

    public void setRefund_status_$n(String refund_status_$n) {
        this.refund_status_$n = refund_status_$n;
    }

    public String getRefund_recv_accout_$n() {
        return refund_recv_accout_$n;
    }

    public void setRefund_recv_accout_$n(String refund_recv_accout_$n) {
        this.refund_recv_accout_$n = refund_recv_accout_$n;
    }
}
