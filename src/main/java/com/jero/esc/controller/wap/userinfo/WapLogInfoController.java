package com.jero.esc.controller.wap.userinfo;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.CheckCode;
import com.jero.esc.common.utils.HttpRequest;
import com.jero.esc.common.utils.ImagesCode;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.MD5Util;
import com.jero.esc.common.utils.StringUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.weixin.token.WeiXinToken;
import com.jero.esc.mapper.details.MegDetailsMapper;
import com.jero.esc.mapper.map.WxAdminMapper;
import com.jero.esc.mapper.userinfo.LogInfoMapper;
import com.jero.esc.po.details.MegDetails;
import com.jero.esc.po.map.WxAdminExample;
import com.jero.esc.po.pubinfo.SwitchInfo;
import com.jero.esc.po.userinfo.FenXiao;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.demand.IDemandService;
import com.jero.esc.service.pubinfo.ISwitchInfoService;
import com.jero.esc.service.userinfo.ILogInfoService;
import com.jero.esc.vo.demand.DemandVo;

/**
 * @copyright 上善云图信息技术有限公司
 * @author zqy
 * @version v1.0 （版本号）
 * @date 2016年12月8日
 * @description
 */
@Controller
@RequestMapping(value = "/wap/userinfo")
public class WapLogInfoController extends BaseController {
	private Logger log = Logger.getLogger(getClass());
	@Autowired
	private MegDetailsMapper megDetailsMapper;
	@Autowired
	private ILogInfoService logInfoService;
    @Autowired
    ISwitchInfoService  switchInfoService;
    @Autowired
    IDemandService demandService;
	@Autowired
	private WxAdminMapper wxAdminMapper;

	@Autowired
	private LogInfoMapper logInfoMapper;
	
	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 用户注册
	 * @param response
	 * @param request
	 * @param session
	 * @param logInfo
	 * @param checkCode
	 * @param logPass
	 * @return void
	 * @method register
	 */
	@ResponseBody
	@RequestMapping(value = "/logInfo/register",produces = "text/html;charset=UTF-8")
	@Transactional(rollbackFor = Exception.class)
	public String register(String provider,HttpServletResponse response, HttpServletRequest request, HttpSession session, LogInfo logInfo,
			String checkCode, String savelogPass, String imagesCode, String flag,Boolean isBang,String isWeiXin,String openId) {
		JsonResult jr = new JsonResult();
		if (checkCode == null || checkCode.isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机验证码不能为空");
			jr.setErrorCode("2");
			return jr.toJSON();
		}
		if ( !isBang &&(logInfo.getLogPass() == null || logInfo.getLogPass().isEmpty())) {
			jr.setSuccess(false);
			jr.setErrorMsg("密码不能为空");
			jr.setErrorCode("3");
			return jr.toJSON();
		}
		if (flag == null || flag.isEmpty()) {
			if (imagesCode == null || imagesCode.isEmpty()) {
				jr.setSuccess(false);
				jr.setErrorMsg("验证码不能为空");
				jr.setErrorCode("5");
				JsonUtil.printByJSON(response, jr);
				return jr.toJSON();
			}
		}
		if ( !isBang  &&(flag == null || flag.isEmpty())) {
			if (savelogPass.length() < 6 || savelogPass.length() > 20) {
				jr.setSuccess(false);
				jr.setErrorMsg("密码必须在6至20位之间");
				jr.setErrorCode("3");
				JsonUtil.printByJSON(response, jr);
				return jr.toJSON();
			}

		}
		if (flag == null || flag.isEmpty()) {
			if (session.getAttribute("code") == null) {
				jr.setSuccess(false);
				jr.setErrorMsg("验证码不对");
				jr.setErrorCode("2");
				JsonUtil.printByJSON(response, jr);
				return jr.toJSON();
			}

		}

		if (flag == null || flag.isEmpty()) {
			if (!ImagesCode.validateImagesCode(session, imagesCode)) {
				jr.setSuccess(false);
				jr.setErrorMsg("验证码不对");
				jr.setErrorCode("2");
				JsonUtil.printByJSON(response, jr);
				return jr.toJSON();
			}

		}

		if (session.getAttribute("checkCode") == null) {
			jr.setSuccess(false);
			jr.setErrorMsg("您未获取手机验证码");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return jr.toJSON();
		}
		if (!checkCode.equals(session.getAttribute("checkCode").toString())) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机验证码错误");
			jr.setErrorCode("2");
			return jr.toJSON();
		}

		/*
		 * if(logInfo.getLogName().length() < 2 || logInfo.getLogName().length()
		 * > 6){ jr.setSuccess(false); jr.setErrorMsg("用户名必须在2至6位之间");
		 * jr.setErrorCode("2"); JsonUtil.printByJSON(response, jr); return; }
		 */
		/*
		 * if(logInfoService.selectLogInfoLogName(logInfo.getLogName()) > 0){
		 * jr.setSuccess(false); jr.setErrorMsg("用户名已经注册过");
		 * jr.setErrorCode("2"); JsonUtil.printByJSON(response, jr); return; }
		 */


		//如果是wap登陆
		/*if ((int)session.getAttribute("wxFlag")==1){*/


			try {
				logInfo.setLogId(UUIDUtil.getUUID());
				logInfo.setLogCell(session.getAttribute("logCell").toString());
				logInfo.setLogCreatetime(new Date());
				logInfo.setLogIsdelete(false);
				logInfo.setLogState(1);
				if(provider!=null&provider!=""){
					logInfo.setLogComment(provider);
				}
				String temp=session.getAttribute("logCell").toString();
//				session.setMaxInactiveInterval(30*60);
				logInfo.setLogName("jdj"+temp.substring(5));
				logInfo.setLogType(1);
				logInfo.setLogRegip(getRequestIP(request));
				logInfo.setLogIslog(true);
				logInfo.setLogPass(MD5Util.getMD5(logInfo.getLogPass()));
			} catch (Exception e) {
				e.printStackTrace();
				log.error("注册密码加密错误" + e);
			}
			try {
				String company=getModule(session);
				logInfo.setCompany(company);
				//判断是否是微信浏览器注册
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("isWeiXin:          "+isWeiXin);
				System.out.println("openId:             "+openId);
				if ("1".equals(isWeiXin)) {
					//发送红包
					logInfo.setOpenId(openId);
				}
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				jr = logInfoService.addLogInfo(logInfo, isWeiXin);
				
//				if(StringUtil.isNotEmpty(parentId)){
//					logInfo.setParentId(parentId);
//					//添加推广关系
//					int i = logInfoService.addExtension(logInfo);
//					if(i<=0){
//						jr.setSuccess(false);
//						jr.setErrorMsg("系统异常");
//					}
//				}
				session.setAttribute("logInfo", logInfo);
				String sessionid=session.getId();
				jr.setObj(sessionid);
			} catch (ExceptionWithMessage e) {
				e.printStackTrace();
				jr = e.jsonResult;
			}
			return  jr.toJSON();


		/*}else {



			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = (WxMpOAuth2AccessToken)session.getAttribute("token_");
			WxMpUser wxMpUser=(WxMpUser)session.getAttribute("user_");
			WxAdminExample wxAdminExample = new WxAdminExample();
			wxAdminExample.or().andWxAdminOpenidEqualTo(wxMpUser.getOpenId());
			List<WxAdmin> i = wxAdminMapper.selectByExample(wxAdminExample);
			if (i!=null&&i.size()>0){
				jr.setSuccess(false);
				jr.setErrorMsg("非法登录");
				return  jr.toJSON();
			}



			WxAdmin wxAdmin = new WxAdmin();
			try {
				//第一次登录
				wxAdmin.setWxAdminId(UUIDUtil.getUUID());
				wxAdmin.setWxAdminCreatetim(new Date());
				wxAdmin.setWxAdminUpdatetime(new Date());
				wxAdmin.setWxAdminOpenid(wxMpUser.getOpenId());
				wxAdmin.setWxAdminToken(JSON.toJSONString(wxMpOAuth2AccessToken));
				wxAdmin.setWxAdminRToken(wxMpOAuth2AccessToken.getRefreshToken());
				wxAdmin.setWxAdminTimeout(wxMpOAuth2AccessToken.getExpiresIn());

				List<LogInfo> logInfos = logInfoMapper.selectLogInfoLogCelll(logInfo.getLogCell());

				if (logInfos!=null&&logInfos.size()>=1){
					wxAdmin.setWxAdminLog(logInfos.get(0).getLogId());
				}else {
					logInfo.setLogComment(session.getAttribute("jihema")!=null?(String)session.getAttribute("jihema"):null);
					logInfo.setLogId(UUIDUtil.getUUID());
					logInfo.setLogCell(session.getAttribute("logCell").toString());
					logInfo.setLogCreatetime(new Date());
					logInfo.setLogIsdelete(false);
					logInfo.setLogState(1);
					logInfo.setLogType(1);
					logInfo.setLogName(wxMpUser.getNickname());
					logInfo.setUserPhoto(wxMpUser.getHeadImgUrl());
					logInfo.setLogRegip(getRequestIP(request));
					logInfo.setLogIslog(true);
					logInfo.setLogPass(MD5Util.getMD5(logInfo.getLogPass()));
					logInfoService.addLogInfo(logInfo);
					wxAdmin.setWxAdminLog(logInfo.getLogId());
				}

				wxAdminMapper.insert(wxAdmin);
				jr.setSuccess(true);
				session.setAttribute("logInfo",logInfo);
				session.setAttribute("wxUser",wxMpUser);
				session.setMaxInactiveInterval(30*60);
				session.removeAttribute("token_");
				session.removeAttribute("user_");
			} catch (Exception e) {
				jr.setSuccess(false);
				jr.setErrorMsg("注册失败");
			}
			return  jr.toJSON();
		}*/


	}

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 跳转注册页面
	 * @return ModelAndView
	 * @method jumpRegister
	 */
	@RequestMapping(value = "/logInfo/jumpRegister")
	public ModelAndView jumpRegister(HttpServletResponse response, HttpServletRequest request,String isWeiXin) {
		ModelAndView mav = new ModelAndView("wap/userinfo/register");
		System.out.println("isWeiXin>>>>>>>>>>>>>>>>>>>>>>>>>>>>:"+isWeiXin);
		isWeiXin = request.getParameter("isWeiXin");
		System.out.println("isWeiXin>>>>>>>>>>>>>>>>>>>>>>>>>>>>:"+isWeiXin);
		if("1".equals(isWeiXin)){
			String code = request.getParameter("code");//
			String state = request.getParameter("state");
			System.out.println("code:" + code + ",state:" + state);
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
						String openid = jsonObject.getString("openid");
						System.out.println("获取openid为  :"+openid);
						mav.addObject("openId", openid);
					}	
				}
			} catch (JSONException | IOException e) {
				e.printStackTrace();
			}
		}
		return mav;
//		return new ModelAndView("wap/userinfo/register");
	}
	@RequestMapping(value="/getWeichatOpenId")
	public void getWeichatOpenId(HttpServletResponse response, HttpServletRequest request) {
		try {
			String code = request.getParameter("code");//
			String state = request.getParameter("state");
			System.out.println("code:" + code + ",state:" + state);
			String reString = HttpRequest.sendGet(
					"https://api.weixin.qq.com/sns/oauth2/access_token",
					"appid=wxd0c763640d4b8f08&secret=3efc3786db25c423b44dcdbcc35d63f7&code="
							+ code + "&grant_type=authorization_code");
			JSONObject jsonObject = new JSONObject(reString);
			if (jsonObject.has("errcode")) { // 错误
				response.sendRedirect(URLDecoder.decode(state, "utf-8"));
			} else { // 正确
				Cookie openidCookie = new Cookie("weichatOpenId",
						jsonObject.getString("openid"));
				System.out.println("openId:>>>>>>>>>>>>>>>>>>>>>"+jsonObject.getString("openid"));
				openidCookie.setMaxAge(60 * 60 * 24 * 15);
				openidCookie.setPath("/");// 设置cookie存储的虚拟目录
				response.addCookie(openidCookie);// 保存cookie
				response.sendRedirect(URLDecoder.decode(state, "utf-8"));
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 
	 *<pre>
	 *<b> 扫码进入近到家二维码 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-8 上午11:50:52
	 *@return
	 *</pre>
	 */
	@RequestMapping(value="/logInfo/jumpJdjerweima")
	public ModelAndView jumpJdjerweima(HttpServletResponse response, HttpServletRequest request, HttpSession session ,String parentId){
		
		String code = request.getParameter("code");//
		String state = request.getParameter("state");
		System.out.println("code:" + code + ",state:" + state);
		String reString = HttpRequest.sendGet(
				"https://api.weixin.qq.com/sns/oauth2/access_token",
				"appid=wxd0c763640d4b8f08&secret=3efc3786db25c423b44dcdbcc35d63f7&code="
						+ code + "&grant_type=authorization_code");
		try {
			JSONObject jsonObject;
			jsonObject = new JSONObject(reString);
			if (jsonObject.has("errcode")) { // 错误
				response.sendRedirect(URLDecoder.decode(state, "utf-8"));
				System.out.println("获取openid失败");
			} else { // 正确
				String openid = jsonObject.getString("openid");
//			WeChatUtils  wu = new WeChatUtils();
				System.out.println("获取openid为  :"+openid);
				FenXiao fx = new FenXiao(openid, parentId);
				//添加前先删除
				logInfoMapper.deleteFenXiao(fx);
				wxAdminMapper.saveFenXiaoId(fx);
//			Map<String, String> map = wu.sendRedPack(openid);
			}
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("wap/userinfo/jdjerweima");
	}
	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 获取验证码
	 * @param response
	 * @param request
	 * @param session
	 * @return void
	 * @method getImagesCode
	 */
	@RequestMapping(value = "/logInfo/getImagesCode")
	public void getImagesCode(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		try {
			ImagesCode.getImagesCode(response, request, session);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("获取图片验证码异常" + e);
		}
	}

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 注册时获取手机验证码
	 * @param response
	 * @param request
	 * @param session
	 * @param imageCode
	 * @param logCell
	 * @return void
	 * @method validateLoginName
	 */
	@RequestMapping(value = "/logInfo/validateLoginName")
	public void validateLoginName(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			String logCell) {
		JsonResult jr = new JsonResult();

		if (logCell == null || logCell.isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机号不能为空");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(logCell);
		if (false == m.matches()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机号格式不正确");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}


		List<LogInfo> logInfo = logInfoMapper.selectLogInfoLogCelll(logCell);
		WxAdminExample wxAdminExample = new WxAdminExample();
		wxAdminExample.or().andWxAdminLogEqualTo((logInfo==null||logInfo.size()<=0||logInfo.get(0)==null)?"":logInfo.get(0).getLogId());
		int i = wxAdminMapper.countByExample(wxAdminExample);

		if (logInfo.size() > 0&&i>0) {
			jr.setSuccess(false);
			jr.setErrorMsg("您已经注册过，请重新进入微信公众号");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		 else if (i==0&&logInfo.size()>0){
			jr.setSuccess(false);
			jr.setErrorMsg("您已经注册过，您的微信将绑定到这个手机");
			jr.setErrorCode("3");
			String param = "您正在进行近到家互联网专家平台注册,";
			try {
				CheckCode.getCheckCode(session, logCell, param);
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonUtil.printByJSON(response, jr);
			return;
		}
        else if (i==0&&logInfo.size()==0){
            jr.setSuccess(true);
            String param = "您正在进行近到家互联网专家平台注册,";
            try {
                CheckCode.getCheckCode(session, logCell, param);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JsonUtil.printByJSON(response, jr);
            return;
        }else {
            log.error("用户获取验证码异常" );
            jr.setSuccess(false);
            jr.setErrorMsg("获取验证码异常,请联系网站客服");
            jr.setErrorCode("1");
            JsonUtil.printByJSON(response, jr);
        }
	}

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 跳转登录页面
	 * @return ModelAndView
	 * @method jumpLogin
	 */
	@RequestMapping(value = "/logInfo/jumpLogin")
	public ModelAndView jumpLogin( HttpServletRequest request) {
		ModelAndView  mav  =  new ModelAndView("wap/userinfo/login");
		String menuTag = request.getParameter("menuTag");
		mav.addObject("menuTag",menuTag);
		return mav;
	}

	@RequestMapping(value = "/logInfo/login")
	public void login(HttpServletResponse response, HttpServletRequest request, HttpSession session, LogInfo logInfo) {
		JsonResult jr = new JsonResult();
		if (logInfo.getLogName() == null || "".equals(logInfo.getLogName())) {
			jr.setSuccess(false);
			jr.setErrorMsg("账号不能为空");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (logInfo.getLogPass() == null || "".equals(logInfo.getLogPass())) {
			jr.setSuccess(false);
			jr.setErrorMsg("密码不能为空");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		try {
			logInfo.setLogPass(MD5Util.getMD5(logInfo.getLogPass()));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("登录密码加密错误" + e);
		}
		LogInfo logInfoRes = logInfoService.queryLogInfoLogin(logInfo);
		if (logInfoRes == null || logInfoRes.getLogCell() == null || logInfoRes.getLogCell().isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorCode("2");
			jr.setErrorMsg("用户名或者密码错误");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (logInfoRes.getLogState() == 0) {
			jr.setSuccess(false);
			jr.setErrorCode("2");
			jr.setErrorMsg("您的账号已经被冻结,请联系客服");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		session.setAttribute("logInfo", logInfoRes);
//		session.setMaxInactiveInterval(43200*60);
		String sessionid=session.getId();
		jr.setObj(sessionid);
		//jr.setObj(logInfoRes);
		jr.setSuccess(true);
		jr.setErrorMsg("登录成功");
		JsonUtil.printByJSON(response, jr);
	}

	/**
	 * @version v1.0 (版本号)
	 * @date 2017年1月3日
	 * @description 退出登录
	 * @param session
	 * @return ModelAndView
	 * @method logOut
	 */
	@RequestMapping(value = "/logInfo/logOut")
	public ModelAndView logOut(HttpSession session) {
		session.invalidate();
		ModelAndView mav  = new ModelAndView("/wap/userinfo/login");
		mav.addObject("menuTag","4");
		return mav;
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月26日
	 * @description 跳转忘记密码页面
	 * @return ModelAndView
	 * @method jumpForgetPass
	 */
	@RequestMapping(value = "/logInfo/jumpForgetPass")
	public ModelAndView jumpForgetPass() {
		return new ModelAndView("wap/userinfo/forgetPass");
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月8日
	 * @description 获取手机验证码（忘记密码）
	 * @param response
	 * @param request
	 * @param session
	 * @param logCell
	 *            void
	 * @method validateLoginCell
	 */
	@RequestMapping(value = "/logInfo/validateLoginCell")
	public void validateLoginCell(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			String logCell) {
		JsonResult jr = new JsonResult();
		if (logCell == null || logCell.isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机号不能为空");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		int res = logInfoService.selectLogInfoLogCell(logCell);
		if (res <= 0) {
			jr.setSuccess(false);
			jr.setErrorMsg("用户不存在");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return;
		}

		Pattern p = Pattern.compile("^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
		Matcher m = p.matcher(logCell);
		if (false == m.matches()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机号格式不正确");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		try {
			String param = "您正在进行近到家互联网专家平台密码修改";
			CheckCode.getCheckCode(session, logCell, param);
			jr.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户获取验证码异常" + e);
			jr.setSuccess(false);
			jr.setErrorMsg("获取验证码异常,请联系网站客服");
			jr.setErrorCode("1");
		}
		JsonUtil.printByJSON(response, jr);
	}

	/**
	 * @version v1.0 (版本号)
	 * @date 2017年1月8日
	 * @description 忘记密码，通过手机号码修改密码
	 * @param request
	 * @param response
	 * @param session
	 * @param checkCode
	 * @param logPass
	 * @param newPass
	 * @param logCell
	 *            void
	 * @method modifyPassByCell
	 */
	@RequestMapping(value = "/logInfo/modifyPassByCell")
	public void modifyPassByCell(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String checkCode, String logPass, String newPass, String logCell) {
		JsonResult jr = new JsonResult();

		if (logCell == null || logCell.isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机号不能为空");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		Pattern p = Pattern.compile("^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
		Matcher m = p.matcher(logCell);
		if (false == m.matches()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机号格式不正确");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (checkCode == null || checkCode.isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机验证码不能为空");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (logPass == null || logPass.isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorMsg("密码不能为空");
			jr.setErrorCode("3");
			JsonUtil.printByJSON(response, jr);
			return;
		}

		if (newPass.length() < 6 || newPass.length() > 20) {
			jr.setSuccess(false);
			jr.setErrorMsg("密码必须在6至20位之间");
			jr.setErrorCode("3");
			JsonUtil.printByJSON(response, jr);
			return;
		}

		if (session.getAttribute("checkCode") == null) {
			jr.setSuccess(false);
			jr.setErrorMsg("您未获取手机验证码");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (!checkCode.equals(session.getAttribute("checkCode").toString())) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机验证码错误");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		LogInfo logInfo = new LogInfo();
		logInfo.setLogCell(logCell);
		try {
			logInfo.setLogPass(MD5Util.getMD5(logPass));
		} catch (Exception e) {
			jr.setErrorMsg("修改密码加密错误！");
			e.printStackTrace();
		}
		logInfoService.modifyPassByCell(logInfo);

		JsonUtil.printByJSON(response, jr);

	}
	
	/**
	 * 
	 *<pre>
	 *<b> 获取公众号的所有openId .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-26 下午2:15:36
	 *</pre>
	 */
	@RequestMapping(value="/selectAllOpenId")
	public void selectAllOpenId(){
		//获取关注公众号的openId
		WeiXinToken wx = new WeiXinToken();
		List<String> list = wx.selectOpenIdList("");
		if(list.size() != 0){
			wxAdminMapper.delOpenId();
			for(String openId : list){
				wxAdminMapper.addOpenId(openId);
			}
		}
	}
	
	@RequestMapping(value="/getCode")
	public void getCode(HttpServletRequest request, String url){
		ModelAndView temp = new ModelAndView(url);

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
//		return temp;
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
	@RequestMapping(value="/getWxUserInfo")
	public ModelAndView getWxUserInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response, String code, String state){
		ModelAndView temp = new ModelAndView();
		String reString = HttpRequest.sendGet(
				"https://api.weixin.qq.com/sns/oauth2/access_token",
				"appid=wxd0c763640d4b8f08&secret=3efc3786db25c423b44dcdbcc35d63f7&code="
						+ code + "&grant_type=authorization_code");
		try {
			
			Map<String, Object> userInfoMap1 = JSON.parseObject(reString);
			for(String key : userInfoMap1.keySet()){
				System.out.println("key>>>>>>>>" + key);
				System.out.println("value>>>>>>>>" + userInfoMap1.get(key));
			}
			
			JSONObject jsonObject;
			jsonObject = new JSONObject(reString);
			if(jsonObject != null){
				if (jsonObject.has("errcode")) { // 错误
//					response.sendRedirect(URLDecoder.decode(state, "utf-8"));
					temp.setViewName("wap/userinfo/erro");
				} else { // 正确
					String openid = jsonObject.getString("openid");
					String access_token = jsonObject.getString("access_token");
//					String access_token = SingletonUtil.getAccessToken();
					System.out.println("openid>>>>>>>>>>>"+openid);
					System.out.println("access_token>>>>>>>>>>>"+access_token);
					if(StringUtil.isNotEmptys(openid, access_token)){
						//判断该openId是否已经绑定账户
						List<LogInfo> listLogInfo = logInfoMapper.selectLog(openid);
						if(listLogInfo.size() > 0){
					    	clearModule(session);
					    	ModelAndView modelAndView = new ModelAndView();
					    	modelAndView.setViewName("/wap/goodsinfo/main");
//					    	String ua = ((HttpServletRequest) request).getHeader("user-agent")  
//					    	        .toLowerCase();  
//					    	if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器  
					    		LogInfo logInfo = this.retrievalCurrentUserInfo(session);
					    		if(logInfo != null){
					    			List<MegDetails> list = megDetailsMapper.selectListByLogId(logInfo.getLogId());
									modelAndView.addObject("logInfo", list.size());
					    		}else{
					    			modelAndView.addObject("logInfo", -1);
					    		}
//					    	}  
					        // 简单获取轮播数据
					        SwitchInfo  si  = new SwitchInfo();
					        si.setSwitchPos(2);
					        si.setCompany("00001");
					        List<SwitchInfo> siList = switchInfoService.queryPicByPosition(si);
					        if(siList!=null&&siList.size()>0){
					        	modelAndView.addObject("banner1", siList.get(0));
					        }
					        List<DemandVo> demands=demandService.takeTopByCount1(3, null);
					        modelAndView.addObject("demands", demands);
							session.setAttribute("logInfo", listLogInfo.get(0));
					        return  modelAndView;
						}
//						CloseableHttpClient client=HttpClients.createDefault();
//						List<NameValuePair> parm = new ArrayList<NameValuePair>();
//						parm.add(new BasicNameValuePair("access_token", access_token));
//						parm.add(new BasicNameValuePair("openid", openid));
//						parm.add(new BasicNameValuePair("lang", "zh_CN"));
						
//						String result = HttpClientUtil.sendUrlPost("https://api.weixin.qq.com/cgi-bin/user/info", parm);
						String result = HttpRequest.sendGet(
								"https://api.weixin.qq.com/sns/userinfo",
								"access_token="+access_token+"&openid="+openid);
						Map<String, Object> userInfoMap = JSON.parseObject(result);
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
							temp.setViewName("wap/userinfo/bd_phone");
						}else{
							temp.setViewName("wap/userinfo/erro");
						}
					}else{
						temp.setViewName("wap/userinfo/erro");
					}
				}	
			}
		}catch (Exception e) {
			temp.setViewName("wap/userinfo/erro");
		}
		return temp;
	}
	
	@RequestMapping(value="/saveWxUserInfo")
	public void saveWxUserInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session, String logCell, String checkCode, String sex,
			String nickname, String headimgurl, String openid, String password){
		JsonResult jr = new JsonResult();
		List<LogInfo> listLog = logInfoMapper.selectLog(openid);
		if(listLog.size() != 0){
			jr.setSuccess(false);
			jr.setErrorMsg("该用户已经绑定");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (logCell == null || logCell.isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机号不能为空");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		Pattern p = Pattern.compile("^((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8}$");
		Matcher m = p.matcher(logCell);
		if (false == m.matches()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机号格式不正确");
			jr.setErrorCode("1");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (checkCode == null || checkCode.isEmpty()) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机验证码不能为空");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (session.getAttribute("checkCode") == null) {
			jr.setSuccess(false);
			jr.setErrorMsg("您未获取手机验证码");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (!checkCode.equals(session.getAttribute("checkCode").toString())) {
			jr.setSuccess(false);
			jr.setErrorMsg("手机验证码错误");
			jr.setErrorCode("2");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		//判断手机号码是否存在
		LogInfo logInfo = new LogInfo();
		List<LogInfo> listLogInfo = logInfoMapper.selectLogInfoLogCelll(logCell);
		if(listLogInfo.size() == 1){
			//添加成功
			logInfo = listLogInfo.get(0);
			logInfo.setOpenId(openid);
			logInfoMapper.updateByLogInfo(logInfo);
			session.setAttribute("logInfo", logInfo);
			JsonUtil.printByJSON(response, new JsonResult(true));
			return;
		}
		try {
			logInfo.setLogCell(logCell);
			logInfo.setLogId(UUIDUtil.getUUID());
			logInfo.setLogCreatetime(new Date());
			logInfo.setLogIsdelete(false);
			logInfo.setLogPass(MD5Util.getMD5(password));
			logInfo.setLogState(1);
			logInfo.setLogType(1);
			logInfo.setLogRegip(getRequestIP(request));
			logInfo.setLogIslog(true);
			logInfo.setUserPhoto(headimgurl);
			logInfo.setLogName(nickname);
			logInfo.setOpenId(openid);
			logInfo.setLogMode("1");
			jr = logInfoService.addLogInfo(logInfo,null);
			session.setAttribute("logInfo", logInfo);
			JsonUtil.printByJSON(response, jr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}