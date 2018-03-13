package com.jero.esc.common.utils.fastvalidate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by blazh on 2016/12/8.
 */


public class ValidateResult<T>{


    private Class<T> class0;
    private  List reqiureList;
    private T obj;
    private List unwantedList;

    public ValidateResult(T obj,List reqiureList,List unwantedList) {
        this.obj=obj;
        this.reqiureList=reqiureList;
        this.unwantedList=unwantedList;
        class0= (Class<T>) obj.getClass();
    }




    public  T getModelValid(){
        try {
            T t=  class0.newInstance();
            Field[] declaredFields = class0.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);


                List<String> invalidList=new ArrayList<String>();
                for (SingleValidateResult singleValidateResult : this.list) {
                    invalidList.add(singleValidateResult.name);
                }
                if (!invalidList.contains(declaredField.getName())){
                    declaredField.set(t,declaredField.get(obj));
                }


            }
            return  t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }




    public T getModelWithRequireList(){
        try {
            T t = class0.newInstance();
            Field[] declaredFields = class0.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                if (reqiureList.contains(declaredField.getName())){
                    declaredField.set(t,declaredField.get(obj));
                }
            }

            return  t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }



    public  T getModelWithUnwantedList(){
        try {
            T t= class0.newInstance();
            Field[] declaredFields = class0.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                if (!unwantedList.contains(declaredField.getName())){
                    declaredField.set(t,declaredField.get(obj));
                }
            }

            return  t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }




    public void printAllMeassage() {
        for (SingleValidateResult singleValidateResult : this.list) {
            System.out.println(singleValidateResult.message);
        }
    }

    public void printAllInvalidateName() {
        for (SingleValidateResult singleValidateResult : this.list) {
            System.out.println(singleValidateResult.name);
        }
    }

    public SingleValidateResult getSingleValidateResult(String name){
        for (SingleValidateResult singleValidateResult : this.list) {
            if (singleValidateResult.name.equals(name)){
                return singleValidateResult;
            }
        }
        return  null;
    }

    public boolean validate = true;
    public ArrayList<SingleValidateResult> list;
}
