package com.jero.esc.common.utils.baidumap;

import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.util.Map;

/**
 * Created by blazh on 2016/12/15.
 */
public class FastParser {

    public  static <T extends Map> Map<String, Object> beanToMap(Object obj,Boolean filterNull,Class<T> tClass) throws IllegalAccessException, InstantiationException {
        Map<String, Object> params = tClass.newInstance();
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    if (filterNull&&propertyUtilsBean.getNestedProperty(obj, name)!=null){
                        params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                    }else if (!filterNull){
                        params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

}
