package com.jero.esc.common.utils.wechat.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.*;
import java.security.MessageDigest;
import java.util.*;

public class XmlParser {



    /** 
     * 除去数组中的空值和签名参数
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param logPath 要写入日志里的文本路径
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String logPath, String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(logPath + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




  
    public static String getXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
    }



    /**
     * 解析xml文件流并转化为Map<String,String>值
     * @param String content
     * @return
     */
    public static Map<String, String> getMapFromXml(String  content){

    	 if (null == content || "".equals(content)) {
             return null;
         }

         Map m = new HashMap();

         SAXBuilder builder = new SAXBuilder();
         Document doc = null;
         InputStream in = null;
         try {
              in = new ByteArrayInputStream(content.getBytes("UTF-8"));
             doc = builder.build(in);
             Element root = doc.getRootElement();
             List list = root.getChildren();
             Iterator it = list.iterator();
             while (it.hasNext()) {
                 Element e = (Element) it.next();
                 String k = e.getName();
                 String v = "";
                 List children = e.getChildren();
                 if (children.isEmpty()) {
                     v = e.getTextNormalize();
                 } else {
                     v = getChildrenText(children);
                 }
                 m.put(k, v);
             }
         } catch (JDOMException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }finally {
             // 关闭流
             try {
                 if (null != in ) in.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         return m;

     }


    /**
     * 获取子结点的xml
     *
     * @param children
     * @return String
     */
    public static String getChildrenText(List children) {
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()) {
            Iterator it = children.iterator();
            while (it.hasNext()) {
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if (!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }

        return sb.toString();
    }


    /**
     * @Description：将请求参数转换为xml格式的string
     * @param parameters 请求参数
     * @return
     */
    public static String getXmlFromMap(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        for (Object key : parameters.keySet()){
            if ("detail".equalsIgnoreCase((String) key)) {
                sb.append("<" + key + ">" + "<![CDATA[" + parameters.get(key) + "]]></" + key + ">");
            } else {
                sb.append("<" + key + ">" +  parameters.get(key) + "</" + key + ">");
            }

        }

        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 获取随机字符串
     * @return
     */
    public static String genNonceStr() {
        Random random = new Random();
        return DigestUtils.md5Hex(String.valueOf(random.nextInt(10000)).getBytes());
    }

}
