package com.jero.esc.controller.wap.bizinfo;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.mapper.bizinfo.CollectUtodMapper;
import com.jero.esc.po.bizinfo.CollectUtod;
import com.jero.esc.po.bizinfo.FocusUtop;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.bizinfo.ICollectUtodService;
import com.jero.esc.vo.bizinfo.CollectDemand;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;

@Controller
@RequestMapping("/wap/bizinfo")
public class WapCollectUtodController extends BaseController{
	@Autowired
	private ICollectUtodService collectUtodService;
	@Autowired
	private CollectUtodMapper collectUtodMapper;
	
	
	
	
	/**
	 * 查询我的关注
	 * @param session
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/collectUtod/myCollects")
    public ModelAndView myCollects(HttpSession session,Integer page) throws Exception{
		if(page==null){
			page = 1;
   		}
   		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<CollectDemand> demandList = collectUtodMapper.selectByUser(retrievalCurrentUserInfo(session).getLogId(), rb);
		CollectUtod cu = new CollectUtod();
		cu.setCutdUser(retrievalCurrentUserInfo(session).getLogId());
		Integer count = collectUtodMapper.countByCon(cu);
		String jsonList = JSON.toJSONString(demandList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("jsonList", jsonList);
		modelAndView.addObject("count", count);
		modelAndView.addObject("f", 1);
		modelAndView.setViewName("wap/bizinfo/mycollect");
		return modelAndView;
    }
	
	
	@RequestMapping(value="/collectUtod/showCollectListByAjax")
	public void showCollectListByAjax(HttpSession session,HttpServletResponse response,Integer page,ServiceCart sc){
		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<CollectDemand> demandList = collectUtodMapper.selectByUser(retrievalCurrentUserInfo(session).getLogId(), rb);
		CollectUtod cu = new CollectUtod();
		cu.setCutdUser(retrievalCurrentUserInfo(session).getLogId());
		Integer count = collectUtodMapper.countByCon(cu);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", demandList);
		map.put("count", count);
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, map);
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
	 public String deleteCollect(HttpSession session,String id ){
		 if (isValidate){
	         if (FastValid.isEmp(id)){
	             return  new JsonResult("参数错误").toJSON();
	         }
	     }	
		 LogInfo info=retrievalCurrentUserInfo(session);
		 CollectUtod record=new CollectUtod();
		 record.setCutdUser(info.getLogId());
		 record.setCutdDemand(id);
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
