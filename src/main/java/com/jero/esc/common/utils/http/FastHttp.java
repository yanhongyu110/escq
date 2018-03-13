package com.jero.esc.common.utils.http;

import java.io.IOException;
import java.util.*;

import com.jero.esc.common.utils.baidumap.FastBaiduMap;
import com.jero.esc.common.utils.baidumap.FastParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;


/**
 * 简单的Http请求
* @ClassName: FastHttp 
* @Description: <>
* @author: blazh
* @date: 2016年11月15日下午4:32:26
* @version:
 */
public class FastHttp {
	
	public  static JSONObject getJSON(String url) throws ParseException, IOException{
	return  null;
	}


	public  static JSONObject doGet(String url,Map param) throws ParseException, IOException{
		HttpClient aDefault = HttpClients.createDefault();
		HttpGet httpPost = new HttpGet(url+"?"+ FastBaiduMap.toQueryString(param));
		httpPost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).setSocketTimeout(10000).build());
		HttpResponse execute = aDefault.execute(httpPost);
		String s = EntityUtils.toString(execute.getEntity(), "UTF-8");
		JSONObject map = JSONObject.parseObject(s);
		return map;
	}


	public  static JSONObject doGet(String url) throws ParseException, IOException{
		HttpClient aDefault = HttpClients.createDefault();			
		HttpGet httpPost = new HttpGet(url);
		httpPost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).setSocketTimeout(10000).build());
		HttpResponse execute = aDefault.execute(httpPost);
		String s = EntityUtils.toString(execute.getEntity(), "UTF-8");
		JSONObject map = JSONObject.parseObject(s);
		return map;
	}



	public  static JSONObject doPost(String url,Map<Object,Object> param) throws ParseException, IOException{	
		JSONObject map = JSONObject.parseObject(FastHttp.postString(url, param));
		return map;
	}
	
	public  static String postString(String url,Map<Object,Object> param) throws ParseException, IOException{
		HttpClient aDefault = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).setSocketTimeout(10000).build());
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (Map.Entry en : param.entrySet()){
			nvps.add(new BasicNameValuePair(en.getKey().toString(),en.getValue().toString()));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		HttpResponse execute = aDefault.execute(httpPost);
		String s = EntityUtils.toString(execute.getEntity(), "UTF-8");
		return s;
	}




	
	
}
