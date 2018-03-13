package com.jero.esc.controller.wap.bizinfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.mapper.bizinfo.FocusUtopMapper;
import com.jero.esc.mapper.details.MegDetailsMapper;
import com.jero.esc.mapper.system.SystemMegsMapper;
import com.jero.esc.po.bizinfo.FocusUtop;
import com.jero.esc.po.details.MegDetails;
import com.jero.esc.po.system.SystemMegs;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.bizinfo.IFocusUtopService;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;

@Controller
@RequestMapping("/wap/bizinfo")
public class WapFocusController extends BaseController{

	@Autowired
	private SystemMegsMapper systemMegsMapper;
	@Autowired
	private MegDetailsMapper megDetailsMapper;
	@Autowired
	private IFocusUtopService focusUtopService;
	@Autowired
	private FocusUtopMapper focusUtopMapper;
	
	@RequestMapping(value="/focus/gotoFocusMenu")
	public ModelAndView gotoFocusMenu(){
		return new ModelAndView("wap/bizinfo/focusMenu");
	}
	
	@RequestMapping(value="/focus/showFocusList")
	public ModelAndView showFocusList(HttpSession session,Integer page,FocusProvider fp){
   		if(page==null){
			page = 1;
   		}
   		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<FocusProvider> focusList = focusUtopMapper.selectByUser(retrievalCurrentUserInfo(session).getLogId(), rb);
		FocusUtop fu = new FocusUtop();
		fu.setFutpUser(retrievalCurrentUserInfo(session).getLogId());
		Integer count = focusUtopMapper.countByCon(fu);
		String jsonList = JSON.toJSONString(focusList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("jsonList", jsonList);
		modelAndView.addObject("count", count);
		modelAndView.setViewName("wap/bizinfo/myfocus");
		return modelAndView;
	}
   
   	@RequestMapping(value="/focus/showFocusListByAjax")
	public void showFocusListByAjax(HttpSession session,HttpServletResponse response,Integer page){
		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<FocusProvider> focusList = focusUtopMapper.selectByUser(retrievalCurrentUserInfo(session).getLogId(), rb);
		FocusUtop fu = new FocusUtop();
		fu.setFutpUser(retrievalCurrentUserInfo(session).getLogId());
		Integer count = focusUtopMapper.countByCon(fu);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("focusList", focusList);
		map.put("count", count);
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, map);
	}
   	
   	@RequestMapping(value = "/focus/focuUsers")
    public ModelAndView focuUsers(HttpSession session,Integer page) throws Exception{
   		if(page==null){
			page = 1;
   		}
   		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<FocusUser> focusList = focusUtopMapper.selectByProvider(retrievalCurrentUserInfo(session).getLogId(), rb);
		FocusUtop fu = new FocusUtop();
		fu.setFutpProvider(retrievalCurrentUserInfo(session).getLogId());
		Integer count = focusUtopMapper.countByCon(fu);
		String jsonList = JSON.toJSONString(focusList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("jsonList", jsonList);
		modelAndView.addObject("count", count);
		modelAndView.setViewName("wap/bizinfo/focusUser");
		return modelAndView;
    }
   	
   	@RequestMapping(value="/focus/focuUsersByAjax")
	public void focuUsersByAjax(HttpSession session,HttpServletResponse response,Integer page){
		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<FocusUser> focusList = focusUtopMapper.selectByProvider(retrievalCurrentUserInfo(session).getLogId(), rb);
		FocusUtop fu = new FocusUtop();
		fu.setFutpProvider(retrievalCurrentUserInfo(session).getLogId());
		Integer count = focusUtopMapper.countByCon(fu);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("focusList", focusList);
		map.put("count", count);
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, map);
	}
   	
   	
   	@ResponseBody
	 @RequestMapping(value = "/focus/deleteFocus", produces = "text/html;charset=UTF-8")
	 public String deleteFocus(HttpSession session,String providerLogId ){
		 if (isValidate){
	         if (FastValid.isEmp(providerLogId)){
	             return  new JsonResult("参数错误").toJSON();
	         }
	     }	
		 LogInfo info=retrievalCurrentUserInfo(session);
		 FocusUtop record=new FocusUtop();
		 record.setFutpUser(info.getLogId());
		 record.setFutpProvider(providerLogId);
		 Boolean temp = false;
		 String mes="";
		try {
			temp = focusUtopService.delete(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes=e.getMessage();
		}
		 if(temp){
			 return  new JsonResult("删除成功").toJSON();
		}else{
			if(mes!=""&mes!=null){
				return  new JsonResult(mes).toJSON();
			}else{
				return  new JsonResult("删除失败").toJSON();
			}
		}
	 }	
   	
   	@ResponseBody
	 @RequestMapping(value = "/focus/addFocus", produces = "text/html;charset=UTF-8")
	 public String addFocus(HttpSession session,String providerLogId){
	 if (isValidate){
        if (FastValid.isEmp(providerLogId)){
            return  new JsonResult("参数错误").toJSON();
        }
    }	
	 	Boolean temp = false;
	 	String mes="";
	 	LogInfo info = new LogInfo();
	 try {
		 info=retrievalCurrentUserInfo(session);
		 FocusUtop record=new FocusUtop();
		 record.setFutpUser(info.getLogId());
		 record.setFutpProvider(providerLogId);
			temp = focusUtopService.add(record);
		
		}
	 	catch (NullPointerException ne) {
			// TODO Auto-generated catch block
			ne.printStackTrace();
			mes="请先登陆后再进行关注";
		}
	 
	 	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes=e.getMessage();
		}
		 if(temp){
			 //关注成功,添加平台消息
			 SystemMegs sm = new SystemMegs();
			 sm.setSmId(UUIDUtil.getUUID());
			 sm.setSmCreatetime(new Date());
			 sm.setSmIsdelete(false);
			 sm.setSmType(1);
			 sm.setSmTitle("平台消息");
			 sm.setSmContent(info.getLogName() + "关注了你,快去看看吧!");
			 MegDetails md = new MegDetails();
			 md.setMdId(UUIDUtil.getUUID());
			 md.setMdCreatetime(new Date());
			 md.setMdIsdelete(false);
			 md.setLogId(providerLogId);
			 md.setSmId(sm.getSmId());
			 md.setOperatorId(info.getLogId());
			 md.setOperatorType(info.getLogType());
			 md.setMdType(1);
			 systemMegsMapper.insert(sm);
			 megDetailsMapper.insert(md);
			 return  new JsonResult(true,"关注成功",null).toJSON();
		}else{
			if(mes!=""&mes!=null){
				return  new JsonResult(false,mes,null).toJSON();
			}else{
				return  new JsonResult(false,"关注失败",null).toJSON();
			}
		}
	 }
   	
   	@ResponseBody
	 @RequestMapping(value = "/focus/judgeFocus", produces = "text/html;charset=UTF-8")
	 public String judgeFocus(HttpSession session,String providerLogId){
		 if (isValidate){
	         if (FastValid.isEmp(providerLogId)){
	             return  new JsonResult("请刷新页面，判断是否登陆").toJSON();
	         }
	     }	
		 LogInfo info=retrievalCurrentUserInfo(session);
		 FocusUtop record=new FocusUtop();
		 record.setFutpUser(info.getLogId());
		 record.setFutpProvider(providerLogId);
		 Boolean temp = false;
		 String mes="";
		 temp = focusUtopService.queryByCon(record);
		 if(temp){
			 return  new JsonResult(true,"已关注",null).toJSON();
		}else{
			return  new JsonResult(false,"未关注",null).toJSON();
			}
	 }	 
}
