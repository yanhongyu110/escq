package com.jero.esc.common.utils.wechat.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jero.esc.common.utils.wechat.business.OrderBusiness;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultClientConnectionReuseStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;

public class HttpsRequest {

    private static final Log logger = LogFactory.getLog(OrderBusiness.class);
    ;
    private final static int CONNECT_TIMEOUT = 5000; // in milliseconds
    private final static String DEFAULT_ENCODING = "UTF-8";

    public static String postData(String urlStr, String data) {
        return postData(urlStr, data, null);
    }

    public static String postData(String urlStr, String data, String contentType) {


        CloseableHttpClient aDefault = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost(urlStr);
            StringEntity stringEntity = new StringEntity(data, "UTF-8");
            httpPost.setConfig(RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).setConnectionRequestTimeout(10000).build());
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse execute = aDefault.execute(httpPost);
            String s = EntityUtils.toString(execute.getEntity(),"UTF-8");
            return s;
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            try {
                aDefault.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;



//        BufferedReader reader = null;
//        OutputStreamWriter writer=null;
//        try {
//            URL url = new URL(urlStr);
//            URLConnection conn = url.openConnection();
//            conn.setDoOutput(true);
//            conn.setConnectTimeout(CONNECT_TIMEOUT);
//            conn.setReadTimeout(CONNECT_TIMEOUT);
//            if (contentType != null)
//                conn.setRequestProperty("content-type", contentType);
//            writer = new OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);
//            if (data == null)
//                data = "";
//            writer.write(data);
//            writer.flush();
//            writer.close();
//
//            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));
//            StringBuilder sb = new StringBuilder();
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line);
//                sb.append("\r\n");
//            }
//            return sb.toString();
//        } catch (IOException e) {
//            logger.error("Error connecting to " + urlStr + ": " + e.getMessage());
//        } finally {
//            try {
//                if (reader != null)
//                    reader.close();
//
//                reader.close();
//            } catch (IOException e) {
//            }
//        }
//
//        return null;
    }

    //请求证书
    public static String doRefund(String url, String data) throws Exception {
        /**
         * 注意PKCS12证书 是从微信商户平台-》账户设置-》 API安全 中下载的
         */

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(""));//P12文件目录 ConfProperties.getSSLPath()
        try {
            /**
             * 此处要改
             * */
            keyStore.load(instream, "你的MCHID".toCharArray());//这里写密码..默认是你的MCHID
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        /**
         * 此处要改
         * */
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, "你的MCHID".toCharArray())//这里也是写密码的
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[]{"TLSv1"},
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        try {
            HttpPost httpost = new HttpPost(url); // 设置响应头信息
            httpost.addHeader("Connection", "keep-alive");
            httpost.addHeader("Accept", "*/*");
            httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpost.addHeader("Host", "api.mch.weixin.qq.com");
            httpost.addHeader("X-Requested-With", "XMLHttpRequest");
            httpost.addHeader("Cache-Control", "max-age=0");
            httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
            httpost.setEntity(new StringEntity(data, "UTF-8"));
            CloseableHttpResponse response = httpclient.execute(httpost);
            try {
                HttpEntity entity = response.getEntity();

                String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                EntityUtils.consume(entity);
                return jsonStr;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }


}