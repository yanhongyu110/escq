package com.jero.esc.common.exception;

import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.mapper.details.UserActionMapper;
import com.jero.esc.po.details.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;


/*@Component*/
public class ExceptionHandler implements HandlerExceptionResolver {

    @Autowired
    UserActionMapper userActionMapper;


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        try {
            UserAction userAction = new UserAction();
            userAction.setUaCreatetime(new Date());
            userAction.setUaId(UUIDUtil.getUUID());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            e.printStackTrace(new PrintStream(baos));
            userAction.setUaContent(baos.toString());
            userAction.setUaComment(e.getMessage());
            userActionMapper.insertSelective(userAction);
//            if (e.getMessage().equals("home")){
//                return null;
//            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        boolean isMoblie = false;
        String[] mobileAgents = {"iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
                "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
                "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
                "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
                "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
                "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
                "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
                "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
                "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
                "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
                "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
                "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
                "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", "vk-v",
                "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
                "Googlebot-Mobile"};
        if (httpServletRequest.getHeader("User-Agent") != null) {
            for (String mobileAgent : mobileAgents) {
                if (httpServletRequest.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
                    isMoblie = true;
                    break;
                }
            }
        }


        ModelAndView modelAndView = new ModelAndView();
        String ua = ((HttpServletRequest) httpServletRequest).getHeader("user-agent").toLowerCase();
        if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
            modelAndView.setViewName("redirect:/wap/main/view.html");
        }else if (isMoblie){
            modelAndView.setViewName("redirect:/wap/main/view.html");
        }else {
            modelAndView.setViewName("redirect:/company/companyIndex.html");
        }
        return modelAndView;
    }
}
