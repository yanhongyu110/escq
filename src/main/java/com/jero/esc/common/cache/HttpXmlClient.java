package com.jero.esc.common.cache;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class HttpXmlClient {

	@SuppressWarnings("unchecked")
	public static String getToken(){
		 String access_token = "";  
		    String grant_type = "client_credential";//获取access_token填写client_credential   
		    String AppId="wxd0c763640d4b8f08";//第三方用户唯一凭证  
		    String secret="3efc3786db25c423b44dcdbcc35d63f7";//第三方用户唯一凭证密钥，即appsecret   
		    //这个url链接地址和参数皆不能变  
		    String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+AppId+"&secret="+secret;  
		    try {  
		        URL urlGet = new URL(url);  
		        HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();  
		        http.setRequestMethod("GET"); // 必须是get方式请求  
		        http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
		        http.setDoOutput(true);  
		        http.setDoInput(true);  
		        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
		        System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
		        http.connect();  
		        InputStream is = http.getInputStream();  
		        int size = is.available();  
		        byte[] jsonBytes = new byte[size];  
		        is.read(jsonBytes);  
		        String message = new String(jsonBytes, "UTF-8");  
		        Map<String, String> map = (Map<String, String>) JSON.parse(message);
//		        JSONObject demoJson = JSONObject.fromObject(message);  
//		        System.out.println("JSON字符串："+demoJson);  
		        access_token = map.get("access_token");  
		        is.close();  
		    } catch (Exception e) {  
		            e.printStackTrace();  
		    }  
		    return access_token;  
	}
	
	@SuppressWarnings("unchecked")
	public static String getTicket(String access_token) {  
	    String ticket = null;  
	    String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ access_token +"&type=jsapi";//这个url链接和参数不能变  
	    try {  
	        URL urlGet = new URL(url);  
	        HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();  
	        http.setRequestMethod("GET"); // 必须是get方式请求  
	        http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
	        http.setDoOutput(true);  
	        http.setDoInput(true);  
	        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒  
	        System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒  
	        http.connect();  
	        InputStream is = http.getInputStream();  
	        int size = is.available();  
	        byte[] jsonBytes = new byte[size];  
	        is.read(jsonBytes);  
	        String message = new String(jsonBytes, "UTF-8");  
	        Map<String, String> map = (Map<String, String>) JSON.parse(message);
//	        JSONObject demoJson = JSONObject.fromObject(message);  
//	        System.out.println("JSON字符串："+demoJson);  
	        ticket = map.get("ticket");  
	        is.close();  
	    } catch (Exception e) {  
	            e.printStackTrace();  
	    }  
	    return ticket;  
	}  
	
	public static String SHA1(String decript) {  
	    try {  
	        MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");  
	        digest.update(decript.getBytes());  
	        byte messageDigest[] = digest.digest();  
	        // Create Hex String  
	        StringBuffer hexString = new StringBuffer();  
	        // 字节数组转换为 十六进制 数  
	            for (int i = 0; i < messageDigest.length; i++) {  
	                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);  
	                if (shaHex.length() < 2) {  
	                    hexString.append(0);  
	                }  
	                hexString.append(shaHex);  
	            }  
	            return hexString.toString();  
	   
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	        }  
	        return "";  
	}  
}
