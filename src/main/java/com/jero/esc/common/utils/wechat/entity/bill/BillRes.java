package com.jero.esc.common.utils.wechat.entity.bill;

/**
 * Created by fxy on 2016/12/19.
 */
public class BillRes {

    private String return_code;//返回状态码(16)
    private String return_msg;//返回信息(128)

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
}
