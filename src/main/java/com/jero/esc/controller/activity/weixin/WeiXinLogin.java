package com.jero.esc.controller.activity.weixin;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.utils.FileUtil;
import com.jero.esc.common.utils.StringUtil;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.mapper.userinfo.LogInfoMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.userinfo.ThirdPartyLoginService;
import com.jero.esc.vo.userinfo.ProviderVo;
import com.jero.esc.vo.userinfo.ThirdPartyLogin;

/**
 * 
 * <pre>
 * <b> 微信第三方登录 .</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> yanhongyu
 * <b>Date:</b> 2018-1-16下午1:24:31
 * <b>Changelog:</b>
 *   ----------------------------------------------------------------------------
 *   Ver   Date                     Detail
 *   ----------------------------------------------------------------------------
 *   1.0   2018-1-16下午1:24:31         new file.
 * </pre>
 */
@Controller
@RequestMapping(value="/weiXinLogin")
public class WeiXinLogin {
	private static final String APPID = "wxded1f8728c67ab10";
	private static final String SECRET = "6305056bfeacfff2faa1d38b52f97968";
	
	
	@Autowired
	private LogInfoMapper logInfoMapper;
	@Autowired
	private CommonTypeMapper commonTypeMapper;
	@Autowired
	private ProviderInfoMapper providerInfoMapper;
	@Autowired
	private ThirdPartyLoginService thirdPartyLoginService;
	
	/**
	 * 
	 *<pre>
	 *<b> PC端 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2018-1-23 上午11:03:39
	 *@param session
	 *@param code
	 *@param state
	 *@return
	 *</pre>
	 */
	@RequestMapping(value="/getCode")
	public ModelAndView getCode(HttpSession session, String code,  String state){
		ModelAndView temp = new ModelAndView();
		try {
			//设置参数获取token openid
			CloseableHttpClient client=HttpClients.createDefault();
			List<NameValuePair> parm = new ArrayList<NameValuePair>();
			parm.add(new BasicNameValuePair("appid", APPID));
			parm.add(new BasicNameValuePair("secret", SECRET));
			parm.add(new BasicNameValuePair("code", code));
			parm.add(new BasicNameValuePair("grant_type", "authorization_code"));
			HttpPost post=new HttpPost("https://api.weixin.qq.com/sns/oauth2/access_token");
			UrlEncodedFormEntity entity=new UrlEncodedFormEntity(parm,"UTF-8");
			post.setEntity(entity);
			HttpResponse response=client.execute(post);
			String result = EntityUtils.toString(response.getEntity(),Charset.forName("utf-8"));
			Map<String, Object> mapData = JSON.parseObject(result);
			for(String key : mapData.keySet()){
				System.out.println("key>>>>>>>>" + key);
				System.out.println("value>>>>>>>>" + mapData.get(key));
			}
			//token凭证
			String access_token = (String) mapData.get("access_token");
			//扫码openId
			String openid = (String) mapData.get("openid");
			if(StringUtil.isNotEmptys(access_token, openid)){
				//判断时候已经存在,存在直接登录
				ThirdPartyLogin login = thirdPartyLoginService.selectLog(openid);
				if(login != null){
					LogInfo logInfo = new LogInfo();
					logInfo.setLogId(login.getLogId());
					logInfo = logInfoMapper.selectLogInfoByLogId(logInfo);
			        session.setAttribute("company",null);
			        session.setAttribute("logInfo", logInfo);
			        List<CommonType> commonTypes = commonTypeMapper.selectChainByFid("0");
			        List<CommonType> types1=commonTypes.subList(0, 9);
			        System.out.println(commonTypes.size());
			        List<CommonType> types2=commonTypes.subList(9, commonTypes.size());
			        List<ProviderVo> providerVos = providerInfoMapper.selectProviderByOrder(RowBounds.DEFAULT,"PI_MEETNUM DESC",null);
			        temp.addObject("providerVos", providerVos);
			        temp.addObject("types1", types1);
			        temp.addObject("types2", types2);
			        temp.setViewName("company/companySelect");
					return temp;
				}
				//获取用户信息
				parm = new ArrayList<NameValuePair>();
				parm.add(new BasicNameValuePair("access_token", access_token));
				parm.add(new BasicNameValuePair("openid", openid));
				parm.add(new BasicNameValuePair("lang", "zh_CN"));
				post=new HttpPost("https://api.weixin.qq.com/sns/userinfo");
				//发送请求获取扫码用户的信息
				entity=new UrlEncodedFormEntity(parm,"UTF-8");
				post.setEntity(entity);
				response=client.execute(post);
				String userInfoData = EntityUtils.toString(response.getEntity(),Charset.forName("utf-8"));
				System.out.println("userInfoData>>>>>>>>>"+userInfoData);
				Map<String, Object> userInfoMap = JSON.parseObject(userInfoData);
				for(String key : userInfoMap.keySet()){
					System.out.println("key>>>>>>>>" + key);
					System.out.println("value>>>>>>>>" + userInfoMap.get(key));
				}
				//性别 1男2女
				int sex = (int) userInfoMap.get("sex");
				//微信昵称
				String nickname = (String) userInfoMap.get("nickname");
				//头像
				String headimgurl = (String) userInfoMap.get("headimgurl");
				if(StringUtil.isNotEmptys(nickname, headimgurl)){
					//保存图像到本地
					headimgurl = FileUtil.saveImg(headimgurl);
					if(headimgurl == null){
						temp.setViewName("/userinfo/login");
						return temp;
					}
					
					temp.addObject("type", 1);
					temp.addObject("sex", sex);
					temp.addObject("nickname", nickname);
					temp.addObject("headimgurl", headimgurl);
					temp.addObject("openid", openid);
					temp.setViewName("/userinfo/bd_phone");
				}else{
					temp.setViewName("/userinfo/login");
				}
			}else{
				temp.setViewName("/userinfo/login");
			}
		} catch (IOException | ParseException e) {
			temp.setViewName("/userinfo/login");
			e.printStackTrace();
		}
		return temp;
	}
	
	@RequestMapping(value="/getAppCode")
	public ModelAndView getAppCode(HttpSession session, String code,  String state){
		ModelAndView temp = new ModelAndView();
		try {
			//设置参数获取token openid
			CloseableHttpClient client=HttpClients.createDefault();
			List<NameValuePair> parm = new ArrayList<NameValuePair>();
			parm.add(new BasicNameValuePair("appid", APPID));
			parm.add(new BasicNameValuePair("secret", SECRET));
			parm.add(new BasicNameValuePair("code", code));
			parm.add(new BasicNameValuePair("grant_type", "authorization_code"));
			HttpPost post=new HttpPost("https://api.weixin.qq.com/sns/oauth2/access_token");
			UrlEncodedFormEntity entity=new UrlEncodedFormEntity(parm,"UTF-8");
			post.setEntity(entity);
			HttpResponse response=client.execute(post);
			String result = EntityUtils.toString(response.getEntity(),Charset.forName("utf-8"));
			Map<String, Object> mapData = JSON.parseObject(result);
			for(String key : mapData.keySet()){
				System.out.println("key>>>>>>>>" + key);
				System.out.println("value>>>>>>>>" + mapData.get(key));
			}
			//token凭证
			String access_token = (String) mapData.get("access_token");
			//扫码openId
			String openid = (String) mapData.get("openid");
			if(StringUtil.isNotEmptys(access_token, openid)){
				//判断openid是否已经存在,存在直接登录
				ThirdPartyLogin login = thirdPartyLoginService.selectLog(openid);
				if(login != null){
					LogInfo logInfo = new LogInfo();
					logInfo.setLogId(login.getLogId());
					logInfo = logInfoMapper.selectLogInfoByLogId(logInfo);
					session.setAttribute("company",null);
					session.setAttribute("logInfo", logInfo);
					List<CommonType> commonTypes = commonTypeMapper.selectChainByFid("0");
					List<CommonType> types1=commonTypes.subList(0, 9);
					System.out.println(commonTypes.size());
					List<CommonType> types2=commonTypes.subList(9, commonTypes.size());
					List<ProviderVo> providerVos = providerInfoMapper.selectProviderByOrder(RowBounds.DEFAULT,"PI_MEETNUM DESC",null);
					temp.addObject("providerVos", providerVos);
					temp.addObject("types1", types1);
					temp.addObject("types2", types2);
					temp.setViewName("company/companySelect");
					return temp;
				}
				//获取用户信息
				parm = new ArrayList<NameValuePair>();
				parm.add(new BasicNameValuePair("access_token", access_token));
				parm.add(new BasicNameValuePair("openid", openid));
				parm.add(new BasicNameValuePair("lang", "zh_CN"));
				post=new HttpPost("https://api.weixin.qq.com/sns/userinfo");
				//发送请求获取扫码用户的信息
				entity=new UrlEncodedFormEntity(parm,"UTF-8");
				post.setEntity(entity);
				response=client.execute(post);
				String userInfoData = EntityUtils.toString(response.getEntity(),Charset.forName("utf-8"));
				System.out.println("userInfoData>>>>>>>>>"+userInfoData);
				Map<String, Object> userInfoMap = JSON.parseObject(userInfoData);
				for(String key : userInfoMap.keySet()){
					System.out.println("key>>>>>>>>" + key);
					System.out.println("value>>>>>>>>" + userInfoMap.get(key));
				}
				//性别 1男2女
				int sex = (int) userInfoMap.get("sex");
				//微信昵称
				String nickname = (String) userInfoMap.get("nickname");
				//头像
				String headimgurl = (String) userInfoMap.get("headimgurl");
				if(StringUtil.isNotEmptys(nickname, headimgurl)){
					temp.addObject("sex", sex);
					temp.addObject("nickname", nickname);
					temp.addObject("headimgurl", headimgurl);
					temp.addObject("openid", openid);
					temp.setViewName("/userinfo/bd_phone");
				}else{
					temp.setViewName("/userinfo/login");
				}
			}else{
				temp.setViewName("/userinfo/login");
			}
		} catch (IOException | ParseException e) {
			temp.setViewName("/userinfo/login");
			e.printStackTrace();
		}
		return temp;
	}
}
