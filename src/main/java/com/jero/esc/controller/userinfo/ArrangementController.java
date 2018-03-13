package com.jero.esc.controller.userinfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.po.userinfo.ArrangementInfo;
import com.jero.esc.service.userinfo.IArrangementInfoService;

@Controller
@RequestMapping(value="/userinfo")
public class ArrangementController extends BaseController{
	
	@Autowired
	IArrangementInfoService arrangementInfoService;
	
	/**
	 * 跳转到档期管理页面
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/arrangement/jumparrangement")
	public ModelAndView jumpArrangement(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		ModelAndView modelAndView = new ModelAndView();
		if (this.retrievalCurrentUserInfo(session) == null) {
			modelAndView.setViewName("userinfo/login");
		} else {
			modelAndView.setViewName("userinfo/arrangement");
		}
		return modelAndView;
	}
	
	
	/**
	 * 客户查看服务商档期
	 * @return
	 */
	@RequestMapping(value="/arrangement/showcustomer")
	public ModelAndView showCustomer(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/arrange/customer");
		return modelAndView;
	}
	
	
	/**
	 * 根据日期查询
	 */
	@Cacheable(value = "homeChae",key = "'selectArrangeByDate:'+#arrange.arrSeverid+':'+#arrange.arrCurday")
	@CachePut(value = "homeChae",key = "'selectArrangeByDate:'+#arrange.arrSeverid+':'+#arrange.arrCurday")
	@RequestMapping(value="/arrangement/selectarrangebydate")
	public void selectArrangeByDate(ArrangementInfo arrange,HttpServletResponse response){

		JsonResult jr = new JsonResult();
		try {
			List<ArrangementInfo> arranges =  arrangementInfoService.queryArrangeByDate(arrange);
			if (arranges.size()<1) {
				jr.setSuccess(false);
				jr.setErrorMsg("没有预约");
			}else{
				jr.setSuccess(true);
				jr.setObj(arranges);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jr.setSuccess(false);
			jr.setErrorMsg("查询出错!");
		}
		JsonUtil.printByJSON(response, jr);
	}
	
	
	/**
	 * 根据ID查询档期
	 * @param arrange
	 * @param response
	 */
	@RequestMapping(value="/arrangement/selectarrangebyid")
	public void selectArrangeById(ArrangementInfo arrange,HttpServletResponse response){
		
		JsonResult jr = new JsonResult();
		try {
			ArrangementInfo info =  arrangementInfoService.queryArrangeById(arrange);
			jr.setSuccess(true);
			jr.setObj(info);
		} catch (Exception e) {
			e.printStackTrace();
			jr.setSuccess(false);
			jr.setErrorMsg("查询出错!");
		}
		JsonUtil.printByJSON(response, jr);
	}
	
	
	/**
	 * 根据ID删除档期
	 * @param arrange
	 * @param response
	 */
	@RequestMapping(value="/arrangement/removearrangebyid")
	@NoRepeatRequest
	public void removeArrangeById(ArrangementInfo arrange,HttpServletResponse response){
		JsonResult jr = new JsonResult();
		try {
			Integer res =  arrangementInfoService.removeArrangeById(arrange);
			if (res>0) {
				jr.setSuccess(true);
			}else{
				jr.setSuccess(false);
				jr.setErrorMsg("删除失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jr.setSuccess(false);
			jr.setErrorMsg("删除出错!");
		}
		JsonUtil.printByJSON(response, jr);
	}
	
	/**
	 * 添加档期
	 * @param arrange
	 * @param response
	 */
	@RequestMapping(value="/arrangement/addarrange")
	@NoRepeatRequest
	public void addArrange(ArrangementInfo arrange,HttpServletResponse response){
		arrange.setArrId(UUIDUtil.getUUID());
		JsonResult jr = new JsonResult();
		try {
			if (arrange.getArrSeverid()==null||arrange.getArrStarttime()==""||
					arrange.getArrEndtime()==null||arrange.getArrEndtime()==""||
					arrange.getArrContent()==null||arrange.getArrContent()=="") {
				jr.setSuccess(false);
				jr.setErrorMsg("含有空值，添加失败!");
			}else if (arrange.getArrContent().length()>45) {
				jr.setSuccess(false);
				jr.setErrorMsg("备注信息超过45个字符!");
			}else if (arrange.getArrStarttime().compareTo(arrange.getArrEndtime())>0) {
				jr.setSuccess(false);
				jr.setErrorMsg("请选择正确的时间!");
			}else{
				Integer res =  arrangementInfoService.addArrange(arrange);
				if (res>0) {
					jr.setSuccess(true);
				}else{
					jr.setSuccess(false);
					jr.setErrorMsg("添加失败!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jr.setSuccess(false);
			jr.setErrorMsg("添加出错!");
		}
		JsonUtil.printByJSON(response, jr);
	}
	
	/**
	 * 修改档期
	 * @param arrange
	 * @param response
	 */
	@RequestMapping(value="/arrangement/updatearrange")
	@NoRepeatRequest
	public void updateArrange(ArrangementInfo arrange,HttpServletResponse response){
		JsonResult jr = new JsonResult();
		try {
			if (arrange.getArrStarttime()==null||arrange.getArrStarttime()==""||
					arrange.getArrEndtime()==null||arrange.getArrEndtime()==""||
					arrange.getArrContent()==null||arrange.getArrContent()=="") {
				jr.setSuccess(false);
				jr.setErrorMsg("含有空值，添加失败!");
			}else{
				Integer res =  arrangementInfoService.modifyArrange(arrange);
				if (res>0) {
					jr.setSuccess(true);
				}else{
					jr.setSuccess(false);
					jr.setErrorMsg("修改失败!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jr.setSuccess(false);
			jr.setErrorMsg("修改出错!");
		}
		JsonUtil.printByJSON(response, jr);
	}
	
	/**
	 * 获取session
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/arrangement/getlogid")
	public void getLogId(HttpServletRequest request,HttpServletResponse response){
		JsonResult jr = new JsonResult();
		try {
		jr.setObj(request.getSession().getAttribute("logInfo"));
		jr.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			jr.setSuccess(false);
			jr.setErrorMsg("获取session失败!");
		}
		JsonUtil.printByJSON(response, jr);
	}
	
}
