package com.jero.esc.common.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.PrintWriter;

public class WxFilters  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String ua = ((HttpServletRequest) servletRequest).getHeader("user-agent").toLowerCase();
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
            session.setAttribute("wxFlag",0);
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            session.setAttribute("wxFlag",1);
            filterChain.doFilter(servletRequest,servletResponse);
        }




    }

    @Override
    public void destroy() {

    }

}
