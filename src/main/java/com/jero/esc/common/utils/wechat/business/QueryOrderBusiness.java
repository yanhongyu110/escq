package com.jero.esc.common.utils.wechat.business;

import com.jero.esc.common.utils.DateUtil;
import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.entity.order.OrderReq;
import com.jero.esc.common.utils.wechat.entity.queryorder.QueryOrderReq;
import com.jero.esc.common.utils.wechat.utils.Configure;
import com.jero.esc.common.utils.wechat.utils.HttpsRequest;
import com.jero.esc.common.utils.wechat.utils.Util;
import com.jero.esc.common.utils.wechat.utils.XmlParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class QueryOrderBusiness {
    private final Log log = LogFactory.getLog(QueryOrderBusiness.class);

    public static void main(String[] args) throws Exception {
        QueryOrderBusiness temp=new QueryOrderBusiness();
        String res=temp.sendpost(null);
        System.out.println(res);
    }


    /**
     *@description 获取用于生成二维码的Url
     *@return String
     * @throws Exception
     *@method getCodeUrl
     */
    public String sendpost(QueryOrderReq queryOrderReq) throws Exception{


       /* SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters= Util.beanToMap(queryOrderReq, true, parameters);

        //获取MD5签名
        String sign = Util.createSign(parameters);
        parameters.put("sign", sign);
        log.debug(parameters.toString());
        //将需订单的订单信息转成XML
        String requestXML = XmlParser.getXmlFromMap(parameters);
        log.debug(requestXML);

        String resXml= HttpsRequest.postData(Configure.QUERYORDER, requestXML);
        Map map=XmlParser.getMapFromXml(resXml);
        log.debug(map.toString());
        String state=(String) map.get("trade_state");
        log.debug(state);
        return resXml;*/
    	return null;
    }




}
