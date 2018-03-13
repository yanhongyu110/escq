package com.jero.esc.common.utils.jdpay.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jero.esc.common.utils.alipay.config.AlipayConfig;

/**
 * 
 * @copyright 上善云图信息技术有限公司
 * @author  tjh
 * @version  v1.0
 * @date  2017年2月7日
 * @description 将jd第三方支付 需要支付的信息  加密 封装并传递到  jd 服务器
 */
public class JdpaySubmit {

	public static String JDPAY_GETEWAY_NEW="https://tmapi.jdpay.com/PayGate";
	
	/**
	 * 
	 * @version  v1.0
	 * @date  2017年2月8日
	 * @description 创建提交的 表单字符串 便于  客户端浏览器发送支付请求
	 * @param sParaTemp 需要提交的参数
	 * @param strMethod 提交的方式 POST  GET
	 * @param strButtonName 提交按钮的名称
	 * @return String
	 * @method buildRequest
	 */
	public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName){
		//待请求参数数组
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());
        
        StringBuffer sbHtml = new StringBuffer();
        
        sbHtml.append("<form id=\"jdpaysubmit\" name=\"jdpaysubmit\" action=\"" + JDPAY_GETEWAY_NEW
                + "\" method=\"" + strMethod
                + "\">");
        
        for (int i = 0; i < keys.size(); i++) {
            String name = keys.get(i);
            String value = sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }
        
        
        //submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['jdpaysubmit'].submit();</script>");

        return sbHtml.toString();
        
	}
	
	
	/**
	 * 
	 * @version  v1.0
	 * @date  2017年2月8日
	 * @description 生成jd支付需要的参数集合，去空或者添加必要的参数
	 * @param sParaTemp 前台传递过来的参数集合
	 * @return Map<String, String> 
	 * @method buildRequestPara
	 */
	public static  Map<String, String> buildRequestPara(Map<String, String> sParaTemp){

        Map<String, String> result = new HashMap<String, String>();

        if (sParaTemp == null || sParaTemp.size() <= 0) {
            return result;
        }

        for (String key : sParaTemp.keySet()) {
            String value = sParaTemp.get(key);
            if (value == null || value.equals("")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
	}
}
