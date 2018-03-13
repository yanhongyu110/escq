package com.jero.esc.common.interceptor;

import com.jero.esc.common.CompanyLoader;
import com.jero.esc.po.bizinfo.CompanyInfo;
import com.jero.esc.po.userinfo.LogInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CompanyInterceptor implements HandlerInterceptor {

    @Autowired
    CompanyLoader companyLoader;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(httpServletRequest.getRequestURL()+httpServletRequest.getParameter("comId"));
        try {
            if (httpServletRequest.getServletPath().equals("/")||httpServletRequest.getServletPath().equals("")){
                throw  new Exception();
            }

//            if(
//                    httpServletRequest.getServletPath().endsWith("/pay/wxpay/paynotify.html")
//                    ||httpServletRequest.getServletPath().endsWith("/pay/alipay/appPay.html")
//                    ){
//            	return true;
//            }

            //***************************
            //这个是我们到时候需要解除的
            if (1!=1){
                HttpSession session = httpServletRequest.getSession();
                Object companyObj = session.getAttribute("company");
                if (companyObj!=null){
                    return true;
                }else {
                    CompanyInfo companyInfo = companyLoader.takeCompany("111");
                    session.setAttribute("company",companyInfo);
                    return true;
                }
            }
            //*************************************



            HttpSession session = httpServletRequest.getSession();
            Object companyObj = session.getAttribute("company");
            String comId = httpServletRequest.getParameter("comId");

            if (!StringUtils.isBlank(comId)){


//                StringBuffer requestURL = httpServletRequest.getRequestURL();
//                String substring = requestURL.substring(requestURL.indexOf("://") + 3, requestURL.length());
//                String com = substring.substring(0, substring.indexOf("/"));
//                if (com.contains(":")) com = com.substring(0, com.indexOf(":"));

                LogInfo logInfo= (LogInfo)session.getAttribute("logInfo");
                if (logInfo!=null&&!logInfo.getCompany().equals(comId)){
                    session.setAttribute("logInfo",null);
                }

                CompanyInfo companyInfo = companyLoader.takeCompany(comId);
                session.setAttribute("company",companyInfo);
            }else if (companyObj==null&&comId==null){
                throw  new Exception();
            }
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
//            httpServletRequest.getRequestDispatcher("/goodsinfo/ServiceInfo/homeShow.html").forward(httpServletRequest, httpServletResponse);
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/company/companyIndex.html");
            return  false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }



}
