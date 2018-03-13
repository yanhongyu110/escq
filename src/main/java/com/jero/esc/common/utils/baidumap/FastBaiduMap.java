package com.jero.esc.common.utils.baidumap;

import sun.applet.Main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by blazh on 2016/12/15.
 */
public class FastBaiduMap {


    public  static  void  main(String[] args){
        System.out.println("");
    }

    public static String SK="gEMbaf8PL22ChY55yDIAD3ykGokXLaIO";
    
    public static String AK="ZKdaE3UIUmMVnZLl9IxLU5gsFTQAGaMV";

    public static String getSn(String head,String[] urls,Poi poi) throws UnsupportedEncodingException, InstantiationException, IllegalAccessException {

        Map para=null;
        String url="";

        Pattern compile = Pattern.compile(head + "(.*)");
        Matcher matcher = compile.matcher(urls[0]);
        if (matcher.find()){
            url= matcher.group(1);
        }

        if (urls[1].equals("post")){
            para=FastParser.beanToMap(poi, true,TreeMap.class);
        }else {
            para=FastParser.beanToMap(poi,true,LinkedHashMap.class);
        }

         // 调用下面的toQueryString方法，对LinkedHashMap内所有value作utf8编码，拼接返回结果address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourak
         String paramsStr = toQueryString(para);
         // 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接yoursk得到/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourakyoursk
         String wholeStr = new String(url+"?"+ paramsStr +SK);
         // 对上面wholeStr再作utf8编码
         String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
         // 调用下面的MD5方法得到最后的sn签名7de5a22212ffaa9e326444c75a58f9a0
         return MD5(tempStr);
    }

    public static  String toQueryString(Map<?, ?> data)
            throws UnsupportedEncodingException {
        StringBuffer queryString = new StringBuffer();
        for (Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey() + "=");
            queryString.append(URLEncoder.encode((String) pair.getValue().toString(),
                    "UTF-8") + "&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }




}
