package com.jero.esc.common.weixin.token;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.utils.StringUtil;

/**
 * 
 * <pre>
 * <b> 微信token .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2017-12-26上午10:54:57
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2017-12-26上午10:54:57         new file.
 * </pre>
 */
public class WeiXinToken {
	private static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd0c763640d4b8f08&secret=3efc3786db25c423b44dcdbcc35d63f7";
	private static final String OPENID_URL = "https://api.weixin.qq.com/cgi-bin/user/get";
	
	public String sendUrl(String url){
		String result = "";
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 *获取token
	 */
	public String selectToken(){
		String result = sendUrl(TOKEN_URL);
		String token = "";
		try {
			JSONObject jsonObj = new JSONObject(result);
			token = (String) jsonObj.get("access_token");	
			System.out.println("token value>>>>>>>> : "+token);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return token;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> selectOpenIdList(String nextOpenId){
		System.out.println("select openId start>>>>>>>>>>>>>>");
		List<String> openIdList = new ArrayList<String>();
		String token = selectToken();
		System.out.println("token >>>>>>>>>>>>>" + token);
		String url = OPENID_URL + "?access_token=" + token + "&next_openid=" + nextOpenId;
		String result = sendUrl(url);
//		String result = "{\"total\":23000,\"count\":10000,\"data\":{\"openid\":[\"OPENID1\",\"OPENID2\",\"OPENID10000\"]},\"next_openid\":\"1\"}";
		Map<String, Object> map = (Map<String, Object>) JSON.parse(result);
		for (String key : map.keySet()) {
			System.out.println(key + "--->" + map.get(key));
		}
//		System.out.println(map);
		//关注的总数
//		int total = (int) map.get("total");	
		//拉取的条数
//		int count = (int) map.get("count");	
		//openIDlist
		Map<String, List<String>> openIdMap = (Map<String, List<String>>) map.get("data");
		if(openIdMap != null){
			openIdList = openIdMap.get("openid");
			//下一个openId
			String next_openid = (String) map.get("next_openid");	
			//如果nextOpenId 为空,openId获取完
			if(StringUtil.isNotEmpty(next_openid)){
				List<String> nextList = selectOpenIdList(next_openid);
				openIdList.addAll(nextList);
				openIdList.add(nextOpenId);
			}
			System.out.println("select openId end>>>>>>>>:"+openIdList);
		}
		return openIdList;
	}
	
	public static void main(String[] args) {
		WeiXinToken wx = new WeiXinToken();
		List<String> list = wx.selectOpenIdList("");
		Object[] arr = list.toArray();
		System.out.println(arr[0]);
	}
}
