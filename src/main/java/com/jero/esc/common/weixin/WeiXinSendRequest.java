package com.jero.esc.common.weixin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * <pre>
 * <b> 微信发送请求 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2017-12-12上午10:21:01
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2017-12-12上午10:21:01         new file.
 * </pre>
 */
@SuppressWarnings("deprecation")
public class WeiXinSendRequest {
	/** 证书路径 */
	private static final String CERT_PATH= "E:/service/tomcat7/service704/webapps/esc/apiclient/apiclient_cert.p12";
//	private static final String CERT_PATH= "D:/workspace/escq/src/main/webapp/apiclient/apiclient_cert.p12";

	/**
	 * 
	 *<pre>
	 *<b> 发送请求给微信 .</b>
	 *<b>Description:</b> 
	 *    需要验证凭证
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-12 上午10:29:43
	 *@param data 请求参数 Xml封装
	 *@param mch_id 商户号
	 *@param url 请求地址
	 *@return 结果集
	 *</pre>
	 */
	public static String sendRequest(String data, String mch_id, String url){
		/*
		 * 证书验证
		 * 证书密码是商户ID
		 */
		KeyStore keyStore;
		try {
			keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File(CERT_PATH));
			keyStore.load(instream, mch_id.toCharArray());
			instream.close();
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mch_id.toCharArray()).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			//发送请求
			CloseableHttpResponse response = httpclient.execute(setHttp(data, url));
			//获取返回结果
			HttpEntity entity = response.getEntity();
			String jsonStr = EntityUtils.toString(entity, "UTF-8");
			return jsonStr;
		} catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 *<pre>
	 *<b> 发送请求 .</b>
	 *<b>Description:</b> 
	 *    无需验证
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-18 下午1:47:52
	 *@param data
	 *@param url
	 *@return
	 *</pre>
	 */
	public static String sendRequestNoMchId(String data, String url){
		try {
			CloseableHttpClient client=HttpClients.createDefault();
			HttpResponse response=client.execute(setHttp(data,url));
			String jsonStr = EntityUtils.toString(response.getEntity(),Charset.forName("utf-8"));
			return jsonStr;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 *<pre>
	 *<b> 请求处理 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-11 下午6:14:32
	 *@param openId
	 *</pre>
	 */
	public static HttpPost setHttp(String data, String url){
		HttpPost httpost = new HttpPost(url); //
		httpost.addHeader("Connection", "keep-alive");
		httpost.addHeader("Accept", "*/*");
		httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		httpost.addHeader("Host", "api.mch.weixin.qq.com");
		httpost.addHeader("X-Requested-With", "XMLHttpRequest");
		httpost.addHeader("Cache-Control", "max-age=0");
		httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
		httpost.setEntity(new StringEntity(data, "UTF-8"));
		return httpost;
	}
}
