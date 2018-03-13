package com.jero.esc.common.interceptor;

import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.po.bizinfo.CompanyInfo;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.pubinfo.CommonTypeExample;
import com.jero.esc.po.userinfo.LogInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//模块拦截器
public class ModuleInterceptor implements HandlerInterceptor {

    @Autowired
    private CommonTypeMapper commonTypeMapper;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println(httpServletRequest.getRequestURL()+httpServletRequest.getParameter("module"));
        try {
            HttpSession session = httpServletRequest.getSession();
            String module = (String)session.getAttribute("module");
            String module1 = httpServletRequest.getParameter("module");
            if (StringUtils.isBlank(module)&&StringUtils.isBlank(module1)){
                //############这段不要
//            	if (1==1){
//                    module="17061213550001";
//                }else {
                    throw  new Exception();
//                }
            }
            if (!StringUtils.isBlank(module1))module=module1;
            CommonTypeExample commonTypeExample = new CommonTypeExample();
            commonTypeExample.or()
                    .andCtTypeEqualTo(5)
                    .andCtFidEqualTo("0");
            List<CommonType> commonTypes = commonTypeMapper.selectByExample(commonTypeExample);
            for (int i = 0; i < commonTypes.size(); i++) {
                if (commonTypes.get(i).getCtId().equals(module)) break;
                if (i>=commonTypes.size())throw  new Exception();
            }
            session.setAttribute("module",module==null?module1:module);
            return  true;
        } catch (Exception e) {
        	e.printStackTrace();
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
