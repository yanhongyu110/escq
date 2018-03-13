package com.jero.esc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description <类描述>
 * @author  郑启阳
 * @date  2016年6月29日 上午10:08:36
 * @version   1.0
 */
public class OrdersNum extends Thread{
	private static long orderNum = 0l;  
    private static String date ;  
    /** 
     * 生成订单编号 
     * @return 
     */  
    public static synchronized String getOrderNo() throws InterruptedException{  
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());  
        if(date==null||!date.equals(str)){  
            date = str;  
            orderNum  = 0l;  
        }  
        orderNum ++;  
        long orderNo = Long.parseLong((date)) * 10000;  
        orderNo += orderNum;  
        return orderNo+"";  
    }  
    
    /**
     * 根据年月日生成订单号
     * 
     * @return 根据年月日生成订单号
     */
    public static String getOrderByRandom(){  
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());  
        StringBuilder strb = new StringBuilder(str);
        for (int i = 0; i < 6; i++) {
        	strb.append((int)(Math.random()*10));
		}
        return strb.toString();  
    } 
    
   
    
  
}
