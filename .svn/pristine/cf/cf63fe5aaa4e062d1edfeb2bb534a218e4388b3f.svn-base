package com.jero.esc.controller.userinfo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.po.userinfo.AccountCard;
import com.jero.esc.service.userinfo.IAccountCardService;

/**
 *@copyright 上善云图信息技术有限公司
 *@author xfj
 *@version v1.0
 *@date 2016年12月8日
 *@description 银行卡管理功能
 */
@Controller
@RequestMapping(value="/userinfo")
public class AccountCardController extends BaseController{
	private Logger log = Logger.getLogger(getClass());
	@Autowired
	private IAccountCardService accountCardService;
	
	@RequestMapping(value="/accountCard/listBankCard")
	public ModelAndView listBankCard(HttpSession session){
		String logId = this.retrievalCurrentUserInfo(session).getLogId();
		List<AccountCard> cardList = accountCardService.queryAllCard(logId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cardList", cardList);
		modelAndView.setViewName("");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/accountCard/addBankCard")
	public ModelAndView addBankCard(AccountCard record,HttpSession session){
		record.setAcId(UUIDUtil.getUUID());
		record.setAcIsdelete(false);
		record.setLogId(this.retrievalCurrentUserInfo(session).getLogId());
		Integer count = accountCardService.addCard(record);
		JsonResult jr = new JsonResult();
		try{
			if(count>0){
				jr.setSuccess(true);
				jr.setErrorMsg("添加银行卡成功");
			}else{
				jr.setSuccess(false);
				jr.setErrorMsg("添加银行卡失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error("添加银行卡异常" + e);
			jr.setErrorMsg("添加异常");
			jr.setSuccess(false);
		}
		return new ModelAndView("redirect:/userinfo/accountCard/listBankCard.html");
	}
	
	@RequestMapping(value="/accountCard/deleteBankCard.html")
	public ModelAndView deleteBankCard(HttpSession session,AccountCard record){
		record.setAcIsdelete(true);
		Integer count = accountCardService.removeCard(record);
		JsonResult jr = new JsonResult();
		try{
			if(count>0){
				jr.setSuccess(true);
				jr.setErrorMsg("删除银行卡成功");
			}else{
				jr.setSuccess(false);
				jr.setErrorMsg("删除银行卡失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			log.error("删除银行卡异常" + e);
			jr.setErrorMsg("删除异常");
			jr.setSuccess(false);
		}
		return new ModelAndView("redirect:/userinfo/accountCard/listBankCard.html");
	}
}
