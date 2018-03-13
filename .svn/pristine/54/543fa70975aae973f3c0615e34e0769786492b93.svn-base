package com.jero.esc.common.utils.exception;


import com.jero.esc.common.appapi.AppJsonResult;

public class AppException  extends  RuntimeException{

    private AppJsonResult appJsonResult;

    public AppJsonResult getAppJsonResult() {
        return appJsonResult;
    }

    public void setAppJsonResult(AppJsonResult appJsonResult) {
        this.appJsonResult = appJsonResult;
    }

    static  public  AppException  build(String msg,Object result){
        AppException appException = new AppException();
        appException.appJsonResult=new AppJsonResult();
        appException.appJsonResult.setSuccess(false);
        appException.appJsonResult.setErrorMsg(msg);
        appException.appJsonResult.setResult(result);
        throw  appException;
    }

}
