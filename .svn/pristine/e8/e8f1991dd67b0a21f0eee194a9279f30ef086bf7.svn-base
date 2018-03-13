package com.jero.esc.common.appapi;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.po.JsonResult;

public class AppJsonResult {

    public  static  AppJsonResult formJsonResult(JsonResult jsonResult){
        AppJsonResult appJsonResult = new AppJsonResult();
        appJsonResult.setSuccess(jsonResult.isSuccess());
        appJsonResult.setErrorMsg(jsonResult.getErrorMsg());
        appJsonResult.setResult(jsonResult.getObj());
        return appJsonResult;
    }


    public  static  AppJsonResult success(Object result){
        AppJsonResult appJsonResult = new AppJsonResult();
        appJsonResult.setSuccess(true);
        appJsonResult.setResult(result);
        return  appJsonResult;
    }

    public  static  AppJsonResult success(){
        AppJsonResult appJsonResult = new AppJsonResult();
        appJsonResult.setSuccess(true);
        return  appJsonResult;
    }


    public  static  AppJsonResult error(String msg,Object result){
        AppJsonResult appJsonResult = new AppJsonResult();
        appJsonResult.setSuccess(false);
        appJsonResult.setResult(result);
        return  appJsonResult;
    }

    public  static  AppJsonResult error(String msg){
        AppJsonResult appJsonResult = new AppJsonResult();
        appJsonResult.setSuccess(false);
        appJsonResult.setErrorMsg(msg);
        return  appJsonResult;
    }
    public AppJsonResult(){
    	
    }
    public AppJsonResult(boolean isSuccess, String errorMsg, Object obj) {
        this.success = isSuccess;
        this.errorMsg = errorMsg;
        this.result = obj;
    }

    private  boolean success;


    private  String errorMsg;

    private Object result;

    public String  Json(){
        return JSON.toJSONString(this);
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean sucess) {
        this.success = sucess;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
