package com.jero.esc.common.utils.exception;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.po.JsonResult;


public class ExceptionWithMessage extends  Exception {

    public static   String  toJson(Exception e){
        if (e instanceof  ExceptionWithMessage){
            return ((ExceptionWithMessage) e).jsonResult.toJSON();
        }else {
            JsonResult jsonResult=new JsonResult();
            jsonResult.setSuccess(false);
            jsonResult.setErrorMsg(e.getMessage());
            jsonResult.setObj(null);
            return  jsonResult.toJSON();
        }
    }

    public ExceptionWithMessage(String message,Object resultContent){
        super(message);
        this.jsonResult.setSuccess(false);
        this.jsonResult.setErrorMsg(message);
        this.jsonResult.setObj(resultContent);
    }

    public ExceptionWithMessage(JsonResult jsonResult){
        super(jsonResult.getErrorMsg());
        this.jsonResult=jsonResult;
    }


    public ExceptionWithMessage(String message){
        super(message);
        this.jsonResult.setSuccess(false);
        this.jsonResult.setErrorMsg(message);
    }

    public JsonResult jsonResult=new JsonResult();

}
