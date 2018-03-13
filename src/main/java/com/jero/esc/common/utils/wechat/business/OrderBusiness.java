package com.jero.esc.common.utils.wechat.business;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.*;
import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.entity.order.OrderReq;
import com.jero.esc.common.utils.wechat.entity.order.OrderRes;
import com.jero.esc.common.utils.wechat.utils.Configure;
import com.jero.esc.common.utils.wechat.utils.HttpsRequest;
import com.jero.esc.common.utils.wechat.utils.Util;
import com.jero.esc.common.utils.wechat.utils.XmlParser;


public class OrderBusiness {
	 private final Log log = LogFactory.getLog(OrderBusiness.class);
	
	 public static void main(String[] args) throws Exception {
		 OrderBusiness wechat=new OrderBusiness();
		 String url=wechat.getCodeUrl(null);
		 System.out.println(url);
	}
	 

	/**
	*@description 获取用于生成二维码的Url
	*@return String
	 * @throws Exception 
	*@method getCodeUrl
	 */
	public String getCodeUrl(OrderReq orderReq) throws Exception{

	//String details="[{\"goods_detail\": [{\"goods_id\": \"iphone6s_16G\",\"wxpay_goods_id\": \"1001\",\"goods_name\": \"iPhone6s 16G\",\"quantity\": 1,\"price\":150},{\"goods_id\": \"iphone6s_32G\",\"wxpay_goods_id\": \"1002\",\"goods_name\": \"iPhone6s 32G\",\"quantity\": 1,\"price\": 200}]}]";
		//OrderReq orderReq=new OrderReq("goods1",details,"hehe",FastRandom.getRandom(32),301,"123");

		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		System.out.println("====="+JSONArray.toJSONString(orderReq));
		String key=orderReq.getKey();
		orderReq.setKey(null);
		parameters=Util.beanToMap(orderReq, true, parameters);
		//System.out.println("=====0132"+JSONArray.toJSONString(parameters));
        //获取MD5签名
        String sign = Util.createSign(parameters,key);
        parameters.put("sign", sign);
        
        log.debug("=+++===="+parameters.toString());
        //将需订单的订单信息转成XML
        String requestXML = XmlParser.getXmlFromMap(parameters);
        log.debug(requestXML);
        
        String resXml=HttpsRequest.postData(Configure.UNIFIEDORDER, requestXML);
        Map map=XmlParser.getMapFromXml(resXml);
        log.debug(resXml);
        String urlCode=(String) map.get("code_url");
		return urlCode;
	}

	public Map<String,String> getResult(OrderReq orderReq) throws Exception{

	//String details="[{\"goods_detail\": [{\"goods_id\": \"iphone6s_16G\",\"wxpay_goods_id\": \"1001\",\"goods_name\": \"iPhone6s 16G\",\"quantity\": 1,\"price\":150},{\"goods_id\": \"iphone6s_32G\",\"wxpay_goods_id\": \"1002\",\"goods_name\": \"iPhone6s 32G\",\"quantity\": 1,\"price\": 200}]}]";
		//OrderReq orderReq=new OrderReq("goods1",details,"hehe",FastRandom.getRandom(32),301,"123");

		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		System.out.println("====="+JSONArray.toJSONString(orderReq));
		String key=orderReq.getKey();
		orderReq.setKey(null);
		parameters=Util.beanToMap(orderReq, true, parameters);
		//System.out.println("=====0132"+JSONArray.toJSONString(parameters));
        //获取MD5签名
        String sign = Util.createSign(parameters,key);
        parameters.put("sign", sign);
        
        log.debug("=+++===="+parameters.toString());
        //将需订单的订单信息转成XML
        String requestXML = XmlParser.getXmlFromMap(parameters);
        log.debug(requestXML);
        
        String resXml=HttpsRequest.postData(Configure.UNIFIEDORDER, requestXML);
        Map map=XmlParser.getMapFromXml(resXml);
        log.debug(resXml);
        return map;
	}
   
    public JsonResult payNotify(HttpServletRequest request,HttpServletResponse response) throws Exception{  
        
    	JsonResult jr=new JsonResult();
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
                OrderRes orderRes=new OrderRes();
               // orderRes.setAppid(appid);
                log.info("请求成功");  
                //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.  
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"  
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                log.debug(resXml);
                jr.setSuccess(true);
                jr.setObj(packageParams);
            } else {  
                log.debug("请求失败,错误信息：" + packageParams.get("err_code"));  
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"  
                        + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";  
                log.debug(resXml);
                jr.setSuccess(false);
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
        	jr.setSuccess(false);
            jr.setErrorMsg("支付失败，刷新页面支付");
            log.info("通知签名验证失败");  
        }  
          return jr;
    } 
    
 public void payReturn(HttpServletRequest request,HttpServletResponse response) throws Exception{  
        

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
                OrderRes orderRes=new OrderRes();
               // orderRes.setAppid(appid);
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
