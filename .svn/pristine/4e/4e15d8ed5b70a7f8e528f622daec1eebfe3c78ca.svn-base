package com.jero.esc.common.shiro.realms;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.po.shiro.Apptoken;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class TokenFilter extends AccessControlFilter {

    @Autowired
    TokenDao tokenDao;

    @Autowired
    CacheManager sss;

    void reJson(String msg,ServletResponse servletResponse){
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        AppJsonResult appJsonResult = new AppJsonResult();
        appJsonResult.setSuccess(false);
//        appJsonResult.setIslogin(false);
        appJsonResult.setErrorMsg(msg);
        try(PrintWriter writer = servletResponse.getWriter()) {
            writer.write(JSON.toJSONString(appJsonResult));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    String signature(String secret,TreeMap<String,String> treeMap){
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> stringStringEntry : treeMap.entrySet()) {
            stringBuffer.append(stringStringEntry.getKey()).append("=").append(stringStringEntry.getValue()).append("&");
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        String s = HmacUtils.hmacSha256Hex(secret, stringBuffer.toString());
        return  s;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {

        HttpServletRequest request=(HttpServletRequest)servletRequest;


        //取得参数相关的东西
        String token=servletRequest.getParameter("token");
        String signature=servletRequest.getParameter("signature");
        String timestamp = servletRequest.getParameter("timestamp");
        if (StringUtils.isBlank(token)||StringUtils.isBlank(signature)||StringUtils.isBlank(timestamp)){
            reJson("参数缺失",servletResponse);
            return false;
        }




        //得到token对象，进行token时间过期检验
        Apptoken take = tokenDao.take(token);
        if (take==null||take.getApptokenEndtime().getTime()<new Date().getTime()){
            reJson("token过期",servletResponse);
            return  false;
        }


        Cache action = sss.getCache("action");

        Cache.ValueWrapper valueWrapper = action.get(take.getApptokenLog());
        if (valueWrapper!=null){
            Object[] os=(Object[])valueWrapper.get();
            if (request.getRequestURL().toString().equals((String) os[0])&&timestamp.equals((String) os[1])){
                reJson("重复提交",servletResponse);
                return  false;
            }
        }
        action.put(take.getApptokenLog(),new Object[]{request.getRequestURL().toString(),timestamp});


        //处理参数集合，排除签名之后进行键ascii的从小到大的排序
        Map<String,String> parameterMap = servletRequest.getParameterMap();
        TreeMap<String, String> treeMap = new TreeMap<>();
        for (Map.Entry<String, String> stringStringEntry : parameterMap.entrySet()) {
            if (!stringStringEntry.getKey().equals("signature")){
                    treeMap.put(stringStringEntry.getKey(),servletRequest.getParameter(stringStringEntry.getKey()));
            }
        }
        //加入密钥，进行签名
        String signature1 = signature(take.getApptokenToken(),treeMap);
        if (!signature1.equals(signature)){
            reJson("签名错误",servletResponse);
            return false;
        }


        SignToken signToken = new SignToken(null);
        signToken.setApptoken(take);
        //登陆
        try {
            getSubject(servletRequest,servletResponse).login(signToken);
        } catch (AuthenticationException e) {
            reJson("登陆出错",servletResponse);
            return  false;
        }

        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }


}
