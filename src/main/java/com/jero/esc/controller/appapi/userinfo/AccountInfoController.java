package com.jero.esc.controller.appapi.userinfo;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.shiro.realms.TokenDao;
import com.jero.esc.common.utils.CheckCode;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.MD5Util;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.userinfo.AccountInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.userinfo.IAccountInfoService;
import com.jero.esc.vo.userinfo.AccountVo;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Controller("appAccountInfoController")
@RequestMapping(value = "/appapi/userinfo")
public class AccountInfoController extends AppBaseController {

	private Logger log = Logger.getLogger(getClass());
	@Autowired
	private IAccountInfoService accountInfoService;

	@Autowired
	private TokenDao tokenDao;

	/**
	 * 账户收支查询
	 * @param page 分页页数
	 * @param pageSize 分页大小
	 */
	@ResponseBody
	@RequestMapping(value = "/accountInfo/list",method = RequestMethod.GET)
	public Object list(Integer page,Integer pageSize) {
		if (FastValid.isEmp(page,pageSize)){page=1;pageSize=10;}
		String logId =logId();
		RowBounds rb = this.getRowBounds(1,10);
		List<AccountVo> accList = accountInfoService.queryLogAccById(rb, logId);
		Integer count = accountInfoService.queryLogAccCountById(logId);
		return  AppJsonResult.success(new FastPage(accList,count,page,pageSize));
	}


	/**
	 * 是否设定密码
	 * @param payPass 支付密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/accountInfo/judgePayPass", method = RequestMethod.POST)
	public AppJsonResult judgePayPass(String payPass) {
		AccountInfo acc = new AccountInfo();
		String logId = logId();
		if (payPass == null || payPass.isEmpty()) {
			return  AppJsonResult.error("请先输入密码");
		}
		acc.setLogId(logId);
		acc.setAccPaypass(payPass);
		try {
			Boolean temp = accountInfoService.judgePayPass(acc);
			return AppJsonResult.success(temp);
		} catch (ExceptionWithMessage e) {
			return AppJsonResult.formJsonResult(e.jsonResult);
		} catch (Exception e) {
			return AppJsonResult.error("添加失败");
		}
	}



	/**
	 * 修改支付密码
	 * @param checkCode 验证码
	 * @param logPass 登陆密码
	 *@param newPass 新密码
	 */
	@ResponseBody
	@RequestMapping(value = "/accountInfo/modify",method = RequestMethod.POST)
	public Object modifyPassId(String checkCode, String logPass, String newPass) {

		if (checkCode == null || checkCode.isEmpty()) {
			return AppJsonResult.error("手机验证码不能为空");
		}
		if (logPass == null || logPass.isEmpty()) {
			return  AppJsonResult.error("密码不能为空");
		}
		if (newPass.length() < 6 || newPass.length() > 20) {
			return  AppJsonResult.error("密码必须在6至20位之间");
		}

		if (getAttr("checkCode") == null) {
			return AppJsonResult.error("您未获取手机验证码");
		}
		if (!checkCode.equals(getAttr("checkCode").toString())) {
			return AppJsonResult.error("手机验证码错误");
		}
		AccountInfo accountInfo=new AccountInfo();
		accountInfo.setLogId(logId());
		try {
			accountInfo.setAccPaypass(MD5Util.getMD5(logPass));
		} catch (Exception e) {
			return  AppJsonResult.error("修改密码加密错误！");
		}
		if(accountInfoService.modifyPayPassById(accountInfo)<=0){
			return  AppJsonResult.error("修改密码错误！");
		}
		return  AppJsonResult.success();
	}


	/**
	 * 获取短信验证码
	 * @param logCell  手机号码
	 */
	@ResponseBody
	@RequestMapping(value = "/accountInfo/sendMes",method = RequestMethod.GET)
	public Object sendMes( String logCell) {
		if (logCell == null || logCell.isEmpty()) {
			return  AppJsonResult.error("手机号不能为空");
		}
		Pattern p = Pattern.compile("^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
		Matcher m = p.matcher(logCell);
		if (false == m.matches()) {
			return  AppJsonResult.error("手机号格式不正确");
		}
		try {
			String param = "您正在进行近到家互联网专家平台密码修改";
			CheckCode.getAppCheckCode(tokenDao, logCell, param);
			return  AppJsonResult.success();
		} catch (Exception e) {
			return  AppJsonResult.error("获取验证码异常,请联系网站客服");
		}
	}
}
