package com.jero.esc.controller.wap.userinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.po.userinfo.ProviderRecommend;
import com.jero.esc.service.userinfo.IProviderRecommendService;

/**
 * @copyright 上善云图信息技术有限公司
 * @author tjh
 * @version v1.0
 * @date 2016年12月15日
 * @description
 */
@Controller
@RequestMapping(value = "/wap/userinfo")
public class WapProviderRecommendController extends BaseController {

	@Autowired
	private IProviderRecommendService providerRecommendService;

	@RequestMapping(value = "/providerRecommend/jumpProviderRecommend")
	public ModelAndView providerRecommend(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		if (this.retrievalCurrentUserInfo(session) == null) {
			mv.setViewName("wap/userinfo/login");
		} else {
			ProviderRecommend pr = providerRecommendService
					.queryByLogId(this.retrievalCurrentUserInfo(session).getLogId());
			if (pr == null) {
				mv.addObject("logInfo", this.retrievalCurrentUserInfo(session));
			} else {
				mv.addObject("providerRecommend", pr);
			}
			mv.setViewName("/wap/userinfo/providerrecommend");
		}
		return mv;
	}

	@RequestMapping(value = "/providerRecommend/addProviderRecommend")
	public void addProviderRecommend(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ProviderRecommend record) throws InstantiationException, IllegalAccessException {
		JsonResult jr = new JsonResult();
		if(HtmlFilter.filter(record)){
			jr.setSuccess(false);
			jr.setErrorCode("3");
			jr.setErrorMsg("输入内容不能为HTML代码！！！");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		
		if (record == null) {
			jr.setSuccess(false);
			jr.setErrorCode("1");
			jr.setErrorMsg("信息为空");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if (record.getPrDetails().length() > 200) {
			jr.setSuccess(false);
			jr.setErrorCode("2");
			jr.setErrorMsg("个人说明需要在200字以内");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		
		
		record.setLogId(this.retrievalCurrentUserInfo(session).getLogId());
		record.setPrSort(99);
		int res = providerRecommendService.addProviderRecommend(record);
		if (res > 0) {
			jr.setSuccess(true);
			jr.setErrorMsg("申请提交成功！");
		}
		JsonUtil.printByJSON(response, jr);
	}

	@RequestMapping(value = "/providerRecommend/modifyStateByLogId")
	public void modifyStateByLogId(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			ProviderRecommend record) throws InstantiationException, IllegalAccessException {
		JsonResult jr = new JsonResult();
		int res = providerRecommendService.removeProviderRecommend(this.retrievalCurrentUserInfo(session).getLogId());
		if(HtmlFilter.filter(record)){
			jr.setSuccess(false);
			jr.setErrorCode("2");
			jr.setErrorMsg("输入内容不能为HTML代码！！！");
			JsonUtil.printByJSON(response, jr);
			return;
		}

		if (res <= 0) {
			jr.setSuccess(false);
			jr.setErrorCode("1");
			jr.setErrorMsg("修改失败");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		jr.setSuccess(true);
		jr.setErrorMsg("修改成功");
		JsonUtil.printByJSON(response, jr);
	}
}
