package com.jero.esc.common.utils;

import java.lang.reflect.Field;

/**
 * Created by blazh on 2017/2/27.
 */
public class HtmlFilter {

    public  static boolean  filter(Object object)  {
        try {
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Object o = declaredField.get(object);
                if (o!=null){
                    String s = o.toString();
                    if (s.contains(">")||s.contains("<")){
                        return true;
                    }
                }
            }
            return  false;
        } catch (Exception e) {
            return  true;
        }
    }

}
