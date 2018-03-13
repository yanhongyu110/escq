package com.jero.esc.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * <pre>
 * <b> 发送请求 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2018-1-3下午3:36:23
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018-1-3下午3:36:23         new file.
 * </pre>
 */
public class HttpClientUtil {

	/**
	 * 
	 *<pre>
	 *<b> 发送post请求 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2018-1-3 下午3:40:04
	 *@param url 访问url
	 *@param list 参数
	 *@return
	 *</pre>
	 */
	public static String sendUrlPost(String url, List<NameValuePair> list){
		CloseableHttpClient client=HttpClients.createDefault();
		try {
			HttpPost post=new HttpPost(url);
			System.out.println("连接"+url);
			try {
				UrlEncodedFormEntity entity=new UrlEncodedFormEntity(list,"UTF-8");
				post.setEntity(entity);
				HttpResponse response=client.execute(post);
				String result=EntityUtils.toString(response.getEntity(),Charset.forName("utf-8"));
				System.out.println("响应信息："+result);
				System.out.println("响应code" + response.getStatusLine().getStatusCode());
				
				return result;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("连接"+url+"失败");
		}finally{
			try {
				client.close();
			} catch (IOException e) {
				System.out.println("关闭连接失败");
				e.printStackTrace();
			}
		}
		return null;
	}
}
