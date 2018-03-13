package com.jero.esc.controller.wap.userinfo;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.CheckCode;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.MD5Util;
import com.jero.esc.common.utils.StringUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.mapper.details.MegDetailsMapper;
import com.jero.esc.mapper.userinfo.AccountInfoMapper;
import com.jero.esc.po.userinfo.AccountInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.userinfo.IAccountInfoService;
import com.jero.esc.service.userinfo.IUserInfoService;
import com.jero.esc.vo.userinfo.AccountVo;
import com.jero.esc.vo.userinfo.SystemMesVo;
import com.jero.esc.vo.userinfo.UserInfoVo;

/**
 * @copyright 上善云图信息技术有限公司
 * @author gb
 * @version v1.0
 * @date 2016年12月9日
 * @description
 */
@Controller
@RequestMapping(value = "/wap/userinfo")
public class WapUserInfoController extends BaseController {
	private Logger log = Logger.getLogger(getClass());
	@Autowired
	private MegDetailsMapper megDetailsMapper;
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private IAccountInfoService accountInfoService;
	@Autowired
	private AccountInfoMapper accountInfoMapper;

	/**
	 * 进入个人中心
	 * @return
     */
	@RequestMapping("/personalAdmin")
	public  ModelAndView personalAdmin(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		try {
			UserInfoVo user = userInfoService.showUserinfoByCon(retrievalCurrentUserInfo(session).getLogId());
			modelAndView.addObject("user", user);
			modelAndView.setViewName("/wap/userinfo/personerAdmin");
		} catch (Exception e) {
			modelAndView.setViewName("wap/userinfo/login");
		}
		return  modelAndView;
	}
	/**
	 * 
	 *<pre>
	 *<b> 跳转二维码页面 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-27 上午9:46:14
	 *@param session
	 *@return
	 *</pre>
	 */
	@RequestMapping(value="//personerErweima")
	public ModelAndView goErWeiMa(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		try {
			UserInfoVo user = userInfoService.showUserinfoByCon(retrievalCurrentUserInfo(session).getLogId());
			modelAndView.addObject("user", user);
			modelAndView.setViewName("/wap/userinfo/erweima");
		} catch (Exception e) {
			modelAndView.setViewName("wap/userinfo/login");
		}
		return modelAndView;
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月23日
	 * @description跳转到修改密码页面
	 * @return ModelAndView
	 * @method jumpmodifyPass
	 */
	@RequestMapping(value = "/jumpmodifyUserInfo")
	public ModelAndView jumpmodifyUserInfo(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (retrievalCurrentUserInfo(session) != null) {
			UserInfoVo user = userInfoService.showUserinfoByCon(retrievalCurrentUserInfo(session).getLogId());
			mv.addObject("user", user);
			mv.setViewName("/wap/userinfo/showUserInfo");
			return mv;
		}
		mv.setViewName("/wap/userinfo/login");
		return mv;
	}
	
	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月23日
	 * @description跳转到信息修改页面
	 * @return ModelAndView
	 * @method jumpmodifyPass
	 */
	@RequestMapping("/jumpModifyUserInfoPage")
	public ModelAndView jumpModifyUserInfoPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (retrievalCurrentUserInfo(session) != null) {
			UserInfoVo user = userInfoService.showUserinfoByCon(retrievalCurrentUserInfo(session).getLogId());
			mv.addObject("user", user);
		}
		mv.setViewName("/wap/userinfo/modifyUserInfo");
		return mv;
	}
	
	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月14日
	 * @description修改用户信息
	 * @param session
	 * @param userInfo
	 * @throws ExceptionWithMessage
	 * @method modifyUserinfo
	 */
	@RequestMapping(value = "/modifyUserinfo")
	public void modifyUserinfo(HttpServletResponse response, HttpSession session, String val,int i)
			throws ExceptionWithMessage {
		JsonResult jr = new JsonResult();
		UserInfoVo user = new UserInfoVo();
		UserInfoVo ui = userInfoService.showUserinfoByCon(retrievalCurrentUserInfo(session).getLogId());
		if (val == null) {
			jr.setSuccess(false);
			jr.setErrorCode("1");
			jr.setErrorMsg("输入信息为空");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		user.setUserRealName(ui.getUserRealName());
		user.setLogCell(ui.getLogCell());
		switch(i){
			case 1:
				user.setUserPhoto(val);
				user.setLogName(ui.getLogName());
				
				user.setUserWechat(ui.getUserWechat());
				break;
			case 2:
				user.setUserPhoto(ui.getUserPhoto());
				user.setLogName(val);
				user.setUserWechat(ui.getUserWechat());
				break;
			case 3:
				user.setUserPhoto(ui.getUserPhoto());
				user.setLogName(ui.getLogName());
				user.setUserWechat(val);
				break;
		}
		
		user.setLogId(this.retrievalCurrentUserInfo(session).getLogId());
		int res = userInfoService.modifyUserinfo(user);
		if (res <= 0) {
			jr.setSuccess(false);
			jr.setErrorCode("2");
			jr.setErrorMsg("修改信息失败");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		refresh(session);
		jr.setSuccess(true);
		jr.setErrorMsg("修改成功");
		jr.getErrorCode();
		JsonUtil.printByJSON(response, jr);
	}

	@RequestMapping(value="/tixian")
	public void tixianForGZH(){
		
	}
	
	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月14日
	 * @description 重置用户登陆密码
	 * @param session
	 * @return String
	 * @throws Exception
	 * @method modifyPassByPrimaryKey
	 */
	@RequestMapping(value = "/modifyPassByPrimaryKey")
	public void modifyPassByPrimaryKey(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String checkCode, String logPass, String newPass) {
		JsonResult jr = new JsonResult();

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
		LogInfo logInfo = this.retrievalCurrentUserInfo(session);
		try {
			logInfo.setLogPass(MD5Util.getMD5(logPass));
		} catch (Exception e) {
			jr.setErrorMsg("修改密码加密错误！");
			e.printStackTrace();
		}
		userInfoService.modifyPassByPrimaryKey(logInfo);
		session.removeAttribute("logInfo");
		JsonUtil.printByJSON(response, jr);

	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月23日
	 * @description跳转到修改密码页面
	 * @return ModelAndView
	 * @method jumpmodifyPass
	 */
	@RequestMapping(value = "/jumpModifyPass")
	public ModelAndView jumpmodifyPass() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userinfo/modifyPass");
		return mv;
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月23日
	 * @description获取短信验证码
	 * @param response
	 * @param request
	 * @param session
	 * @param logCell
	 * @method sendMesToUser
	 */
	@RequestMapping(value = "/sendMesToUser")
	public void sendMesToUser(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			String logCell) {
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
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月29日
	 * @description 查看所有系统消息
	 * @param response
	 * @param request
	 * @param session
	 * @return ModelAndView
	 * @method queryAllSystemMes
	 */
	@RequestMapping(value = "/queryAllSystemMes")
	public ModelAndView queryAllSystemMes(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			Integer smType, Integer page) {
		if (page == null) {
			page = 1;
		}
		RowBounds rw = this.getRowBounds(page, 10);
		ModelAndView mv = new ModelAndView();
		if (session != null) {
			String logId = this.retrievalCurrentUserInfo(session).getLogId();
			SystemMesVo mesVo = new SystemMesVo();
			mesVo.setSmType(smType);
			mesVo.setLogId(logId);
			if(StringUtil.isNotEmpty(logId)){//标记为已查看
				megDetailsMapper.updateMegIsSee(logId);
			}
			Integer count = userInfoService.selectMesCountBylogId(mesVo);
			List<SystemMesVo> list = userInfoService.queryAllSystemMes(mesVo, rw);
			mv.addObject("smType", smType);
			mv.addObject("list", list);
			mv.addObject("count", count);
			mv.addObject("pageNo", page);
		}
		mv.setViewName("wap/userinfo/userSystemMes");
		return mv;
	}

	@RequestMapping(value = "/queryAllSystemMesByAjax")
	public void queryAllSystemMesByAjax(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			int smType, Integer page) {
		if (page == null) {
			page = 1;
		}
		RowBounds rw = this.getRowBounds(page, 10);
		String logId = this.retrievalCurrentUserInfo(session).getLogId();
		if(StringUtil.isNotEmpty(logId)){//标记为已查看
			megDetailsMapper.updateMegIsSee(logId);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		SystemMesVo mesVo = new SystemMesVo();
		mesVo.setSmType(smType);
		mesVo.setLogId(logId);
		Integer count = userInfoService.selectMesCountBylogId(mesVo);
		List<SystemMesVo> list = userInfoService.queryAllSystemMes(mesVo, rw);
		map.put("count", count);
		map.put("list", list);
		map.put("smType", smType);
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, map);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月29日
	 * @description删除系统消息
	 * @param response
	 * @param request
	 * @param session
	 * @param smId
	 * @method removeMesByPrimaryKey
	 */
	@RequestMapping(value = "/removeMesByPrimaryKey")
	public void removeMesByPrimaryKey(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			String smId) {
		int res = userInfoService.removeMesByPrimaryKey(smId);
		if (res > 0) {
			JsonUtil.printByJSON(response, "删除成功");
		}
	}
	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月5日
	 * @description 修改支付密码 
	 * @param request
	 * @param response
	 * @param session
	 * @param checkCode
	 * @param logPass
	 * @param newPass void
	 * @method  modifyPassByPrimaryKey
	 */
	@RequestMapping(value = "/accountInfo/modifyPassById")
	public void modifyPassId(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			String checkCode, String logPass, String newPass, String logId) {
		JsonResult jr = new JsonResult();

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
		 
		AccountInfo accountInfo=new AccountInfo();
		accountInfo.setLogId(logId);
//		accountInfo.setLogId(this.retrievalCurrentUserInfo(session).getLogId());
		try {
			accountInfo.setAccPaypass(MD5Util.getMD5(logPass));
		} catch (Exception e) {
			jr.setErrorMsg("修改密码加密错误！");
			e.printStackTrace();
		}
		int res=accountInfoService.modifyPayPassById(accountInfo);
		if(res<=0){
			jr.setErrorCode("4");
			jr.setErrorMsg("修改密码错误！");
		}
		session.removeAttribute("checkCode");
		JsonUtil.printByJSON(response, jr);
	}
	
	/**
	 * 
	 *<pre>
	 *<b> 验证支付密码 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2018-1-5 下午3:06:48
	 *@param response
	 *@param password
	 *@param logId
	 *</pre>
	 */
	@RequestMapping(value="/validatePwd")
	public void validatePwd(HttpServletResponse response, String password, String logId){
		try {
			AccountVo accountInfo = accountInfoMapper.selectByLogId(logId);
			if(accountInfo != null){
				if(StringUtil.isNotEmpty(accountInfo.getAccPaypass())){
					password = MD5Util.getMD5(password);
					if(accountInfo.getAccPaypass().equals(password)){
						JsonUtil.printByJSON(response, new JsonResult(true, "", null));
					}else{
						JsonUtil.printByJSON(response, new JsonResult(false, "支付密码错误", null));
					}
				}else{
					JsonUtil.printByJSON(response, new JsonResult(false, "还未设置支付密码", null));
				}
			}else{
				JsonUtil.printByJSON(response, new JsonResult(false, "未找到用户,请重新登录", null));
			}
		} catch (Exception e) {
			JsonUtil.printByJSON(response, new JsonResult(false, "系统异常", null));
		}
	}
}
