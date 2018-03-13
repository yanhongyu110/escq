package com.jero.esc.common.weixin;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jero.esc.common.utils.HttpRequest;
@Controller
@RequestMapping(value="/weixin")
public class WeiXinGetOpenId {
	@SuppressWarnings("unused")
	@RequestMapping(value="/getOpenId")
	public void getOpenId(HttpServletRequest request, HttpServletResponse response){
		try {
			String code = request.getParameter("code");//
			String state = request.getParameter("state");
			String reString = HttpRequest.sendGet(
					"https://api.weixin.qq.com/sns/oauth2/access_token",
					"appid=wxd0c763640d4b8f08&secret=3efc3786db25c423b44dcdbcc35d63f7&code="
							+ code + "&grant_type=authorization_code");
			JSONObject jsonObject = new JSONObject(reString);
			if (jsonObject.has("errcode")) { // 错误
				response.sendRedirect(URLDecoder.decode(state, "utf-8"));
				System.out.println("获取openid失败");
			} else { // 正确
				String openid = jsonObject.getString("openid");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
