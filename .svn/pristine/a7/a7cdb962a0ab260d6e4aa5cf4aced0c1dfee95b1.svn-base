package com.jero.esc.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;


public class AppInterceptor  implements HandlerInterceptor {


    public static Logger log= LoggerFactory.getLogger(AppInterceptor.class);




    @Override
    public boolean preHandle(final HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

//        HandlerMethod m=(HandlerMethod)o;
//        Class<?> beanType = m.getBeanType();


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        OutputStream outputStream = httpServletResponse.getOutputStream();


        ByteArrayOutputStream   baos=new ByteArrayOutputStream();
        baos=(ByteArrayOutputStream) outputStream;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());


        System.out.println(swapStream.toString());
//        System.out.println(modelAndView.getModelMap());
    }

//    @Test
//    public void  test(){
//        System.out.println(System.getProperty("user.dir"));
//    }

    @Override
    public void afterCompletion(final HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, final Object o, Exception e) throws Exception {




    }
}
