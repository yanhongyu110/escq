package com.jero.esc.common.utils.fastvalidate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.utils.baidumap.FastParser;


/**
 * Created by blazh on 2016/12/6.
 */
public class FastValidate<T> {

	public FastValidate(T obj) {
        this.obj = obj;
        this.class0=obj.getClass();
    }

    private T obj;
    private Class class0;
    private ValidateResult<T> validateResult;

    private List<String> requireList;
    private List<String> unwantedList;
    private boolean isOverRangePattenValidate;
    private boolean perfomance;
    
    




    public  static  boolean validateByPatten(Object obj,FastValidateType fastValidateType) {

        switch (fastValidateType) {
            case NOT_EMPTY:
                return obj != null && obj.toString().matches(FastValidateType.NOT_EMPTY.getReg());
            case JSON:
                try {
                    JSON.parse(obj.toString());
                    return true;
                } catch (Exception e) {
                    return false;
                }
            default:
                return obj.toString().matches(fastValidateType.getReg());
        }

    }



    public  static  boolean validateByPatten(Object obj,String s){
        return  obj.toString().matches(s);
    }


    public void setReqiureList(String list,boolean isOverRangePattenValidate) {
        String[] split = list.split(",");
        this.requireList =   new ArrayList<String>();
        for (String s : split) {
            this.requireList.add(s);
        }
        this.isOverRangePattenValidate=isOverRangePattenValidate;
    }


    
    //设置
    public void setUnwantedList(String list) {
        String[] split = list.split(",");
        this.unwantedList =   new ArrayList<String>();
        for (String s : split) {
            this.unwantedList.add(s);
        }
        this.isOverRangePattenValidate=isOverRangePattenValidate;
    }


    //验证是否符合
    public Boolean validatePattener(Object o,String name, FastValidateAnnotation annotation) throws IllegalAccessException {
        if (annotation != null) {
            FastValidateType fastValidateType = annotation.validateType();
            if (fastValidateType != FastValidateType.NULL) {//指定了类型
                boolean matches=FastValidate.validateByPatten(o,fastValidateType);
                String mes = matches ? null : (!annotation.invalidMessage().equals("") ? annotation.invalidMessage() : name + " is invalidate");
                validateResult.list.add(new SingleValidateResult(name, false, mes));
                return false;
            } else if (!annotation.pattern().equals("")) {
                boolean matches = o.toString().matches(annotation.pattern());
                String mes = matches ? null : (!annotation.invalidMessage().equals("") ? annotation.invalidMessage() : name+ " is invalidate");
                validateResult.list.add(new SingleValidateResult(name, false, mes));
                return false;
            }
        }
        return true;
    }

    //验证是否为空
    public Boolean validateReqiure(Object o,String name, FastValidateAnnotation annotation) throws IllegalAccessException {
        if (o == null || o.toString().equals("")) {
            String mes = annotation != null && !annotation.emptyMessage().equals("") ? annotation.emptyMessage() :name + " is Empty";
            validateResult.list.add(new SingleValidateResult(name, false, mes));
            return false;
        }
        return true;
    }


    public  Boolean validateField(Object o,String name,FastValidateAnnotation annotation) throws IllegalAccessException {
        if (!validateReqiure(o, name, annotation)) {
            return false;
        }
        if (!validatePattener(o, name, annotation)){
            return false;
        }
        return  true;
    }

    public  ValidateResult<T> validateObject() throws Exception {
       return _validateObject();
    }

    public  ValidateResult<T> validateObject(boolean perfomance) throws Exception {
        this.perfomance=perfomance;
        return _validateObject();
    }

    public  ValidateResult<T> _validateObject() throws Exception {
        validateResult = new ValidateResult<T>(obj,requireList,unwantedList);
        validateResult.list= new ArrayList<SingleValidateResult>();
        Field[] declaredFields = this.class0.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            boolean aBoolean=true;
            declaredField.setAccessible(true);
            String name=declaredField.getName();
            Object feild=declaredField.get(obj);
            FastValidateAnnotation annotation = declaredField.getAnnotation(FastValidateAnnotation.class);
            if (requireList!=null){
                if (requireList.contains(name)){
                    aBoolean = validateField(feild, name, annotation);
                }else if (isOverRangePattenValidate&&feild!=null){
                    aBoolean=validatePattener(feild, name, annotation);
                }
            }else if (unwantedList!=null){
                if (!unwantedList.contains(name)) {
                    aBoolean = validateField(feild, name, annotation);
                }else if (isOverRangePattenValidate&&feild!=null){
                    aBoolean=validatePattener(feild, name, annotation);
                }
            }
            if (!aBoolean){
                validateResult.validate=false;
                if (perfomance)
                    break;
            }
        }
        return validateResult;
    }


}
