package com.jero.esc.common.utils.wx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpSession;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.http.FastHttp;
import com.jero.esc.common.utils.json.JsonReader;
import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.sha1.SHA1;

/**
 * 微信工具类
 * @ClassName: WeiChatUtill
 * @Description: <>
 * @author: blazh
 * @date: 2016年11月9日下午1:22:25
 * @version:
 */
public class WeiChatUtill {

	// 需要配置的选项
	// 微信配置路径
	private static String WEICHAT_CONFIG_PATH = "WeiChatConfig.json";
	// 开发者APPID
	private static String APPID;
	// 开发者APP密钥
	private static String APPSECRET;
	// token更新时间
	private static long TOKEN_TIMEOUT = 5400000;
	// 是否使用微信
	private static boolean IS_USE_WEICHAT = true;

	private WeiChatUtill(HttpSession httpSession) {
	}

	// 初始化
	public static void start(HttpSession httpSession) {
		BASE_PATH = httpSession.getServletContext().getRealPath("/");
		mainThead.start();
	}

	// 开发公众号Token
	private static String ACCECCTOKEN = "";
	// 开发公众号JS票据
	private static String JSAPITICKET = "";
	// 开发者公众号的卡卷
	private static String APITICKET = "";
	// 基本路径
	private static String BASE_PATH = "";
	// 错误连续次数
	public static int ERR_COUNT;

	private static boolean FORCE_MODE = false;

	// 主线程
	public static Thread mainThead = new Thread() {
		@Override
		public void run() {
			while (true) {

				try {
					getWeiChatConfig();
				} catch (Exception e1) {
					IS_USE_WEICHAT = false;
					System.out.println("读取配置错误,请检查配置,50s后将会重新读取配置");
					e1.printStackTrace();
					try {
						Thread.sleep(50000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}

				if (FORCE_MODE) {
				} else {
					if (ERR_COUNT > 10) {
						System.out.println("微信初始化连续错误次数大于10次，请联系管理员测试");
						IS_USE_WEICHAT = false;
					}
				}

				if (IS_USE_WEICHAT) {
					System.out.println("开始获取微信认证");
					try {
						getMyToken();
						getJsApiTicket();
						ERR_COUNT = 0;
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InvalidTokenException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("已经停止了微信的获取");
				}

				if (FORCE_MODE) {
					try {
						Thread.sleep(50000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("启用了强制微信初始化,待测试完毕请关掉强制模式");
				} else {
					try {
						Thread.sleep(TOKEN_TIMEOUT);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		};
	};

	private static void getWeiChatConfig() throws IOException {
		String path = BASE_PATH + WEICHAT_CONFIG_PATH;// 获取web项目的路径
		JSONObject json = JsonReader.readFromPath(path, "utf-8", JSONObject.class);
		APPID = json.getString("APPID");
		APPSECRET = json.getString("APPSECRET");
		TOKEN_TIMEOUT = json.getLong("TOKEN_TIMEOUT");
		IS_USE_WEICHAT = json.getBoolean("IS_USE_WEICHAT");
		FORCE_MODE = json.getBoolean("FORCE_MODE");
		System.out.println(json.toJSONString());
	}

	// 得到开发着公众号的Token
	private static void getMyToken() throws ParseException, IOException, InvalidTokenException {
		CloseableHttpClient http = HttpClients.createDefault();
		try {
			HttpGet get = new HttpGet(String.format(
					"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", APPID,
					APPSECRET));
			CloseableHttpResponse res = http.execute(get);
			String jsonStr = EntityUtils.toString(res.getEntity(), "utf-8");
			JSONObject json = JSONObject.parseObject(jsonStr);
			ACCECCTOKEN = json.getString("access_token");
			if (ACCECCTOKEN == null && ACCECCTOKEN.equals("")) {
				throw new InvalidTokenException();
			} else {
				System.out.println("token成功");
			}
		} finally {
			try {
				http.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 得到JsApi的票据
	private static void getJsApiTicket() throws ClientProtocolException, IOException, InvalidTokenException {
		CloseableHttpClient http1 = HttpClients.createDefault();
		try {
			String url = String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi",
					ACCECCTOKEN);
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse res = http1.execute(get);
			String jsonStr = EntityUtils.toString(res.getEntity(), "utf-8");
			JSONObject json = JSONObject.parseObject(jsonStr);
			JSAPITICKET = json.getString("ticket");
			if (JSAPITICKET == null && JSAPITICKET.equals("")) {
				throw new InvalidTokenException();
			} else {
				System.out.println("apiTicket成功");
			}
		} finally {
			try {
				http1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	// 得到卡卷
	private static void getApiTicket() throws ClientProtocolException, IOException {
		CloseableHttpClient http = HttpClients.createDefault();
		HttpGet get = new HttpGet(String.format(
				"https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=wx_card", ACCECCTOKEN));
		CloseableHttpResponse res = http.execute(get);
		String jsonStr = EntityUtils.toString(res.getEntity(), "utf-8");
		JSONObject json = JSONObject.parseObject(jsonStr);
		APITICKET = json.getString("ticket");
	}

	// 得到JsApi的设置
	public static String getJsApiConfig(String url) {
		// 开发公众号JS随机数
		String NONCESTR = FastRandom.getRandom(15);
		// 开发公众号JS时间戳 只能10位以下
		String TIMESTAMP = String.valueOf(new Date().getTime()).substring(0, 10);

		Map<String, String> json = new HashMap<String, String>();

		json.put("timestamp", TIMESTAMP);
		json.put("noncestr", NONCESTR);
		json.put("url", url);
		json.put("jsapi_ticket", JSAPITICKET);
		json.put("signature", getSign(json));
		json.remove("jsapi_ticket");
		json.remove("url");
		json.put("appId", APPID);
		return JSONObject.toJSONString(json);
	}

	// 得到卡券签名
	public static String getApiSign(String url, String NONCESTR, String TIMESTAMP) {
		String signature = new SHA1().getDigestOfString(
				String.format("jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s", JSAPITICKET, NONCESTR, TIMESTAMP, url)
						.getBytes())
				.toLowerCase();
		return signature;
	}

	// 得到签名
	private static String getSign(Map map) {
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			// 重写改为升序
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		String re = "";
		for (Map.Entry<String, String> mapping : list) {
			re += mapping.getKey() + "=" + mapping.getValue() + '&';
		}
		re = re.substring(0, re.length() - 1);
		String signature = new SHA1().getDigestOfString(re.getBytes()).toLowerCase();
		System.out.println(re);
		return signature;
	}

	// 生成用于获取access_token的Code的Url
	// 拼在你在开发者中心填写的回调域名后面
	public static String getRequestCodeUrl(String redirectUrl, String state) throws NotUseWeiChatException {
		if (!IS_USE_WEICHAT) {
			throw new NotUseWeiChatException();
		}
		return String.format(
				"https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
				APPID, redirectUrl, "snsapi_userinfo", state);
	}

	/**
	 * 获取请求用户信息的access_token
	 */
	public static JSONObject getUserInfoAccessToken(String code)
			throws InvalidUserTokenException, NotUseWeiChatException, ParseException, IOException {
		if (!IS_USE_WEICHAT) {
			throw new NotUseWeiChatException();
		}
		String url = String.format(
				"https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
				APPID, APPSECRET, code);
		JSONObject object = FastHttp.getJSON(url);
		if (object.getString("access_token") == null) {
			throw new InvalidUserTokenException();
		}
		return object;
	}

	// 验证token是否有效s
	public static boolean checkUserInfoAccessToken(String token, String openid)
			throws ParseException, IOException, NotUseWeiChatException {
		if (!IS_USE_WEICHAT) {
			throw new NotUseWeiChatException();
		}
		String url = String.format("https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s", token, openid);
		JSONObject object = FastHttp.getJSON(url);
		if (object.getInteger("errcode") != 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 刷新UserInfoAccess
	 */
	public static JSONObject refreshUserInfoAccessToken(String refresh_token)
			throws InvalidUserTokenException, NotUseWeiChatException, ParseException, IOException {
		if (!IS_USE_WEICHAT) {
			throw new NotUseWeiChatException();
		}
		String url = String.format(
				"https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s",
				APPID, refresh_token);
		JSONObject object = FastHttp.getJSON(url);
		if (object.getString("access_token") == null) {
			throw new InvalidUserTokenException();
		}
		return object;
	}

	/**
	 * 获取用户信息
	 */
	public static JSONObject getUserInfo(String accessToken, String openId)
			throws NotUseWeiChatException, NotGetUserInforException, ParseException, IOException {
		if (!IS_USE_WEICHAT) {
			throw new NotUseWeiChatException();
		}
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId
				+ "&lang=zh_CN";
		JSONObject userInfo = FastHttp.getJSON(url);
		if (userInfo.getString("openid") == null) {
			throw new NotGetUserInforException();
		}
		return userInfo;
	}

}
