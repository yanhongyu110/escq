package com.jero.esc.common.interceptor;

import com.jero.esc.common.annotation.NoRepeatRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


/**
 * 用于过滤掉重复提交
 */
public class RepeatRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (!(o instanceof HandlerMethod)) return true;
        HandlerMethod m=(HandlerMethod)o;

        NoRepeatRequest annotation = m.getMethod().getAnnotation(NoRepeatRequest.class);
        if (annotation!=null) {
            Object repeat = httpServletRequest.getSession().getAttribute("repeat");
            String val = getVal(httpServletRequest);
            if (repeat!=null&&val.equals(repeat.toString())){
                return false;
            }
            httpServletRequest.getSession().setAttribute("repeat",val);
        }
        return true;
    }


    public String getVal(HttpServletRequest request){
            TreeMap<String, Object> stringStringTreeMap = new TreeMap<String, Object>();
            String queryString = request.getQueryString();
            Map<String,Object> parameterMap = request.getParameterMap();
            stringStringTreeMap.put("{q",queryString);
            stringStringTreeMap.put("{u",request.getRequestURL().toString());
            for (Map.Entry<String, Object> stringObjectEntry : parameterMap.entrySet()) {
                String[] array= (String[])stringObjectEntry.getValue();
                ArrayList<String> strings = new ArrayList<String>();
                for (String s : array) {
                    strings.add(s);
                }
                stringStringTreeMap.put(stringObjectEntry.getKey(),strings);
            }
            return DigestUtils.md5Hex(stringStringTreeMap.toString());
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        if (!(o instanceof HandlerMethod)) return;
        HandlerMethod m=(HandlerMethod)o;
        NoRepeatRequest annotation = m.getMethod().getAnnotation(NoRepeatRequest.class);
        if (annotation!=null) {
            httpServletRequest.getSession().setAttribute("repeat",null);
        }
    }
}
