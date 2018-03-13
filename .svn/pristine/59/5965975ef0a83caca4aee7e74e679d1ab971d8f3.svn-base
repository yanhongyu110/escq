package com.jero.esc.controller.bizinfo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.bizinfo.CollectUtod;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.bizinfo.ICollectUtodService;
import com.jero.esc.vo.bizinfo.CollectDemand;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;

@Controller
@RequestMapping("/bizinfo")
public class CollectUtodController extends BaseController{
	@Autowired
	private ICollectUtodService collectUtodService;
	
	
	
	
	/**
	 * 查询我的关注
	 * @param session
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/collectUtod/myCollects")
    public ModelAndView myCollects(HttpSession session,Integer page,Integer pageSize) throws Exception{
    	if (FastValid.isEmp(page,pageSize)){
            page=1;
            pageSize=5;
        }
    	LogInfo info=retrievalCurrentUserInfo(session);
    	CollectUtod record=new CollectUtod();
    	record.setCutdUser(info.getLogId());
    	PageRowBounds pageRowBounds = getPageRowBounds(page,pageSize);
    	FastPage<CollectDemand> psage= collectUtodService.queryByUser(info.getLogId(),pageRowBounds);
    	
    	ModelAndView modelAndView = new ModelAndView();
    	if(psage.list!=null&&psage.list.size()>0){
    		modelAndView.setViewName("bizinfo/mycollect");
            modelAndView.addObject("infos",psage);	
    	}else {
    		 modelAndView.addObject("title", "我的收藏");
             modelAndView.addObject("content", "还没有添加收藏");
             modelAndView.setViewName("pubinfo/kanban");
             return modelAndView;
		}
        return  modelAndView;
    }

	
	
	 /**
	  *添加收藏
	 * @param session
	 * @param providerLogId
	 * @return
	 */
	@ResponseBody
	 @RequestMapping(value = "/collectUtod/addCollect", produces = "text/html;charset=UTF-8")
	 public String addCollect(HttpSession session,String demId){
	 if (isValidate){
         if (FastValid.isEmp(demId)){
             return  new JsonResult("参数错误").toJSON();
         }
     }	
	 	Boolean temp = false;
	 	String mes="";
	 try {
		 LogInfo info=retrievalCurrentUserInfo(session);
		 CollectUtod record=new CollectUtod();
		 record.setCutdUser(info.getLogId());
		 record.setCutdDemand(demId);
			temp = collectUtodService.add(record);
		
		}
	 	catch (NullPointerException ne) {
			// TODO Auto-generated catch block
			ne.printStackTrace();
			mes="请先登陆后再进行收藏";
		}
	 
	 	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes=e.getMessage();
		}
		 if(temp){
			 return  new JsonResult(true,"收藏成功",null).toJSON();
		}else{
			if(mes!=""&mes!=null){
				return  new JsonResult(false,mes,null).toJSON();
			}else{
				return  new JsonResult(false,"收藏失败",null).toJSON();
			}
		}
	 }
	 
	 /**
	  * 删除收藏
	 * @param session
	 * @param providerLogId
	 * @return
	 */
	@ResponseBody
	 @RequestMapping(value = "/collectUtod/deleteCollect", produces = "text/html;charset=UTF-8")
	 public String deleteCollect(HttpSession session,String demId ){
		 if (isValidate){
	         if (FastValid.isEmp(demId)){
	             return  new JsonResult("参数错误").toJSON();
	         }
	     }	
		 LogInfo info=retrievalCurrentUserInfo(session);
		 CollectUtod record=new CollectUtod();
		 record.setCutdUser(info.getLogId());
		 record.setCutdDemand(demId);
		 Boolean temp = false;
		 String mes="";
		try {
			temp = collectUtodService.delete(record);
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
	 @RequestMapping(value = "/collectUtod/judgeCollect", produces = "text/html;charset=UTF-8")
	 public String judgeFocus(HttpSession session,String demId){
		 if (isValidate){
	         if (FastValid.isEmp(demId)){
	             return  new JsonResult("请刷新页面，判断是否登陆").toJSON();
	         }
	     }	
		 LogInfo info=retrievalCurrentUserInfo(session);
		 CollectUtod record=new CollectUtod();
		 record.setCutdUser(info.getLogId());
		 record.setCutdDemand(demId);
		 Boolean temp = false;
		 String mes="";
		 temp = collectUtodService.queryByCon(record);
		 if(temp){
			 return  new JsonResult(true,"已收藏",null).toJSON();
		}else{
			return  new JsonResult(false,"未收藏",null).toJSON();
			}
	 }	 
	 
	
	 
	 
	 
}
