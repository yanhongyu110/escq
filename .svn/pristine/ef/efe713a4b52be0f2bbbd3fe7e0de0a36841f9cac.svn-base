package com.jero.esc.controller.wap.common;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.utils.HttpRequest;
import com.jero.esc.common.utils.JsonUtil;

/**
 * 
 * <pre>
 * <b> 微信工具类 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2018-1-8上午9:41:04
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018-1-8上午9:41:04         new file.
 * </pre>
 */
@Controller
@RequestMapping(value="/weiXin")
public class WeiXinUtils extends BaseController{
	
	@RequestMapping(value="/getCode")
	public void getCode(HttpServletRequest request, HttpServletResponse response, String url){
		try {
			String appid = URLEncoder.encode("wxd0c763640d4b8f08", "utf-8");
			String redirect_uri = request.getScheme()+"://"+ request.getServerName()+"/weiXin/getOpenId.html?url="+url;
			redirect_uri = URLEncoder.encode(redirect_uri, "utf-8");
//			String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
			HttpRequest.sendGet("https://open.weixin.qq.com/connect/oauth2/authorize", 
					"appid="+appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonUtil.printByJSON(response, null);
	}
	
	@RequestMapping(value="/getOpenId")
	public ModelAndView getOpenId(HttpServletRequest request, HttpServletResponse response, String code, String state, String url){
		ModelAndView temp = new ModelAndView(url);
		String reString = HttpRequest.sendGet(
				"https://api.weixin.qq.com/sns/oauth2/access_token",
				"appid=wxd0c763640d4b8f08&secret=3efc3786db25c423b44dcdbcc35d63f7&code="
						+ code + "&grant_type=authorization_code");
		try {
			JSONObject jsonObject;
			jsonObject = new JSONObject(reString);
			if(jsonObject != null){
				if (jsonObject.has("errcode")) { // 错误
					response.sendRedirect(URLDecoder.decode(state, "utf-8"));
					System.out.println("获取openid失败");
				} else { // 正确
					Cookie openidCookie = new Cookie("weichatOpenId",
							jsonObject.getString("openid"));
					System.out.println("openId:>>>>>>>>>>>>>>>>>>>>>"+jsonObject.getString("openid"));
					openidCookie.setMaxAge(60 * 60 * 24 * 15);
					openidCookie.setPath("/");// 设置cookie存储的虚拟目录
					response.addCookie(openidCookie);// 保存cookie
					response.sendRedirect(URLDecoder.decode(state, "utf-8"));
					temp.addObject("openId", jsonObject.getString("openid"));
				}	
			}
		}catch (Exception e) {
		}
		return temp;
	}
}
