package com.jero.esc.controller.bizinfo;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.fastvalidate.FastValid;
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
@RequestMapping("/bizinfo")
public class FocusUtopController extends BaseController{
	@Autowired
	private IFocusUtopService focusUtopService;
	@Autowired
	private SystemMegsMapper systemMegsMapper;
	@Autowired
	private MegDetailsMapper megDetailsMapper;
	
	
	
	/**
	 * 查询我的关注
	 * @param session
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/focusutop/myFocus")
    public ModelAndView myFocus(HttpSession session,Integer page,Integer pageSize) throws Exception{
    	if (FastValid.isEmp(page,pageSize)){
            page=1;
            pageSize=5;
        }
    	LogInfo info=retrievalCurrentUserInfo(session);
    	FocusUtop record=new FocusUtop();
    	record.setFutpUser(info.getLogId());
    	PageRowBounds pageRowBounds = getPageRowBounds(page,pageSize);
    	FastPage<FocusProvider> psage= focusUtopService.queryByUser(info.getLogId(),pageRowBounds);
    	
    	ModelAndView modelAndView = new ModelAndView();
    	if(psage.list!=null&&psage.list.size()>0){
    		modelAndView.setViewName("bizinfo/myfocus");
            modelAndView.addObject("infos",psage);	
    	}else {
    		 modelAndView.addObject("title", "我的关注");
             modelAndView.addObject("content", "还没有添加关注");
             modelAndView.setViewName("pubinfo/kanban");
             return modelAndView;
		}
        return  modelAndView;
    }

	/**
	 * 查询关注我的用户
	 * @param session
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/focusutop/focuUsers")
    public ModelAndView focuUsers(HttpSession session,Integer page,Integer pageSize) throws Exception{
    	if (FastValid.isEmp(page)){
            page=1;
            pageSize=10;
        }
    	LogInfo info=retrievalCurrentUserInfo(session);
    	FocusUtop record=new FocusUtop();
    	record.setFutpProvider(info.getLogId());
    	PageRowBounds pageRowBounds = getPageRowBounds(page,pageSize);
    	FastPage<FocusUser> psage= focusUtopService.queryByProvider(info.getLogId(),pageRowBounds);
    	
    	ModelAndView modelAndView = new ModelAndView();
    	if(psage.list!=null&&psage.list.size()>0){
    		modelAndView.setViewName("bizinfo/focuUsers");
            modelAndView.addObject("infos",psage);	
    	}else {
    		 modelAndView.addObject("title", "关注我的用户");
             modelAndView.addObject("content", "暂时还没有人关注你哦");
             modelAndView.setViewName("pubinfo/kanban");
             return modelAndView;
		}
        return  modelAndView;
    }
	
	
	
	 /**
	  *添加关注
	 * @param session
	 * @param providerLogId
	 * @return
	 */
	@ResponseBody
	 @RequestMapping(value = "/focusutop/addFocus", produces = "text/html;charset=UTF-8")
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
	 
	 /**
	  * 删除关注
	 * @param session
	 * @param providerLogId
	 * @return
	 */
	@ResponseBody
	 @RequestMapping(value = "/focusutop/deleteFocus", produces = "text/html;charset=UTF-8")
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
	 @RequestMapping(value = "/focusutop/judgeFocus")
	 public String judgeFocus(HttpSession session,String providerLogId){
		 if (isValidate){
	         if (FastValid.isEmp(providerLogId)){
	             return  new JsonResult("请刷新页面，判断是否登陆").toJSON();
	         }
	     }	
		 LogInfo info=retrievalCurrentUserInfo(session);
		 FocusUtop record=new FocusUtop();
		 if(info!=null){
			 record.setFutpUser(info.getLogId());
			 record.setFutpProvider(providerLogId);
		 }else{
			 return  new JsonResult(false,"未关注",null).toJSON();
		 }
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
