package com.jero.esc.common.utils.wechat.business;

import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.entity.bill.BillReq;
import com.jero.esc.common.utils.wechat.entity.queryrefund.QueryRefundReq;
import com.jero.esc.common.utils.wechat.utils.Configure;
import com.jero.esc.common.utils.wechat.utils.HttpsRequest;
import com.jero.esc.common.utils.wechat.utils.Util;
import com.jero.esc.common.utils.wechat.utils.XmlParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by fxy on 2016/12/28.
 */
public class BillDownloadBusiness {

    private final Log log = LogFactory.getLog(QueryRefundBusiness.class);

    public String sendPost(BillReq billReq) throws Exception {

  /*      SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters = Util.beanToMap(billReq, true, parameters);
        //获取MD5签名
        String sign = Util.createSign(parameters);
        parameters.put("sign", sign);
        log.debug(parameters.toString());
        //将信息转成XML
        String requestXML = XmlParser.getXmlFromMap(parameters);
        log.debug(requestXML);

        String resXml = HttpsRequest.postData(Configure.DOWNLOADBILL, requestXML);
        Map map = XmlParser.getMapFromXml(resXml);
        log.debug(resXml);
        // String res = (String) map.get("op_user_id");
        return resXml;*/
    	 return null;
    }
}
