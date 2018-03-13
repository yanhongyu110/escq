package com.jero.esc.common.filter;

import java.io.IOException;  
import java.util.Iterator;  
import java.util.List;  
  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;  
  
  
public class XssFilter implements Filter  {  
    FilterConfig    filterConfig    = null;  
  
    public void init(FilterConfig filterConfig) throws ServletException {  
        this.filterConfig = filterConfig;  
    }  
  
    public void destroy() {  
        this.filterConfig = null;  
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException { 
    	 HttpServletRequest req = (HttpServletRequest) request;  
         
         if("POST".equalsIgnoreCase(req.getMethod())){
        	 chain.doFilter(new XssHttpServletRequestWrapper(  
                     (HttpServletRequest) request), response);
         }else{
        	 chain.doFilter(request, response);
         }
          
    }  
} 
