package com.jero.esc.common.utils.wechat.utils;

import java.beans.PropertyDescriptor;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONArray;
import com.jero.esc.common.utils.MD5Util;


public class Util{
	 private final static Log log = LogFactory.getLog(Util.class);

public static boolean isTenpaySign(SortedMap<Object, Object> packageParams) {  
        StringBuffer sb = new StringBuffer();  
        Set es = packageParams.entrySet();  
        Iterator it = es.iterator();  
        while(it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            String k = (String)entry.getKey();  
            String v = (String)entry.getValue();  
            if(!"sign".equals(k) && null != v && !"".equals(v)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
          
        sb.append("key=" + Configure.getKey());  
          
        //算出摘要  
        String mysign=null;
		try {
			mysign = MD5Util.getMD5(sb.toString()).toLowerCase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();  
          
        //System.out.println(tenpaySign + "    " + mysign);  
        return tenpaySign.equals(mysign);  
    }  
  
/**
*@description 将类对象转换为map 并将空属性去掉 
*@param obj
*@param filterNull
*@param params
*@throws IllegalAccessException
*@throws InstantiationException
*@return SortedMap<Object,Object>
*@method beanToMap
 */
public  static SortedMap<Object, Object> beanToMap(Object obj,Boolean filterNull,SortedMap<Object, Object> params) throws IllegalAccessException, InstantiationException {
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

    /** 
     * @author 
     * @date 2016-4-22 
     * @Description：sign签名 
     * @param characterEncoding 
     *            编码格式 
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String createSign(SortedMap<Object, Object> parameters,String key) {  
        StringBuffer sb = new StringBuffer();  
        Set es = parameters.entrySet();  
        Iterator it = es.iterator();
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            Object k = (Object) entry.getKey();  
            Object v = (Object) entry.getValue();  
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {  
                sb.append(k + "=" + v + "&");  
            }  
        }  
        sb.append("key=" +key);  
       log.debug("key===="+ key);
        String sign=null;
		try {
			sign = MD5Util.getMD5(sb.toString()).toUpperCase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        log.debug(sign);
        return sign;  
    }  
  
    /** 
     * @author 
     * @date 2016-4-22 
     * @Description：将请求参数转换为xml格式的string 
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String getRequestXml(SortedMap<Object, Object> parameters) {  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        Set es = parameters.entrySet();  
        Iterator it = es.iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            String k = (String) entry.getKey();  
            String v = (String) entry.getValue();  
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {  
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");  
            } else {  
                sb.append("<" + k + ">" + v + "</" + k + ">");  
            }  
        }  
        sb.append("</xml>");  
        return sb.toString();  
    }  
  
    /** 
     * 取出一个指定长度大小的随机正整数. 
     *  
     * @param length 
     *            int 设定所取出随机数的长度。length小于11 
     * @return int 返回生成的随机数。 
     */  
    public static int buildRandom(int length) {  
        int num = 1;  
        double random = Math.random();  
        if (random < 0.1) {  
            random = random + 0.1;  
        }  
        for (int i = 0; i < length; i++) {  
            num = num * 10;  
        }  
        return (int) ((random * num));  
    }  
 // 特殊字符处理  
    public static String UrlEncode(String src)  throws UnsupportedEncodingException {  
        return URLEncoder.encode(src, "UTF-8").replace("+", "%20");  
    }  
 public static void notify(HttpServletRequest request,HttpServletResponse response) throws Exception{  
        
        //读取参数  
        InputStream inputStream ;  
        StringBuffer sb = new StringBuffer();  
        inputStream = request.getInputStream();  
        String s ;  
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));  
        while ((s = in.readLine()) != null){  
            sb.append(s);  
        }  
        in.close();  
        inputStream.close();  
  
        //解析xml成map  
        Map<String, String> m = new HashMap<String, String>();  
        m = XmlParser.getMapFromXml(sb.toString());  
          
        //过滤空 设置 TreeMap  
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();        
        Iterator it = m.keySet().iterator();  
        while (it.hasNext()) {  
            String parameter = (String) it.next();  
            String parameterValue = m.get(parameter);  
              
            String v = "";  
            if(null != parameterValue) {  
                v = parameterValue.trim();  
            }  
            packageParams.put(parameter, v);  
        }  
          
        // 账号信息  
        String key = Configure.getKey(); // key  
        	
        log.debug(packageParams);  
        //判断签名是否正确  
        if(Util.isTenpaySign(packageParams)) {  
            //------------------------------  
            //处理业务开始  
            //------------------------------  
            String resXml = "";  
            if("SUCCESS".equals((String)packageParams.get("result_code"))){  
                
                  
                log.info("请求成功");  
                //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.  
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"  
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                log.debug(resXml);
                  
            } else {  
                log.info("请求失败,错误信息：" + packageParams.get("err_code"));  
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"  
                        + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";  
                log.debug(resXml);
            }  
            //------------------------------  
            //处理业务完毕  
            //------------------------------  
            BufferedOutputStream out = new BufferedOutputStream(  
                    response.getOutputStream());  
            out.write(resXml.getBytes());  
            out.flush();  
            out.close();  
        } else{  
            log.info("通知签名验证失败");  
        }  
          
    } 

  
} 

  
