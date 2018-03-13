package com.jero.esc.controller.demand;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.HtmlUtil;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.demand.IDemandService;
import com.jero.esc.vo.demand.Demand;
import com.jero.esc.vo.demand.DemandVo;

@Controller
@RequestMapping("/demand")
public class DemandController extends BaseController {
	
	@Autowired
	private IDemandService demandService;

	@Autowired
	private CommonTypeService commonTypeService;

	@Autowired
	private CommonTypeSaveMapper commonTypeSaveMapper;


	/**
	 *@description 查询服务列表
	 */

//	@Cacheable(value = "comSearchChae",key = "'showdemandList:'+#session.getAttribute('company').compId+':'+#serviceTypetree+':'+#flag")
//	@CachePut(value = "comSearchChae",key = "'showdemandList:'+#session.getAttribute('company').compId+':'+#serviceTypetree+':'+#flag")
//	@RequestMapping(value="/showList")
//	public ModelAndView showServiceList(Boolean to,String flag,String search,HttpSession session,Integer page,String serviceTypetree,String order){
//		if(page==null){
//			page = 1;
//		}
//		if (StringUtils.isBlank(serviceTypetree)){
//			serviceTypetree=null;
//		}
//
//		if (to!=null){
//			clearModule(session);
//		}
//
//		Integer pageSize = 10;
//		order = "DEM_CREATETIME DESC";
//		RowBounds rb = this.getRowBounds(page, pageSize);
//		String commonType = getModule(session)==null
//				?commonTypeSaveMapper.selectByPrimaryKey("0").getSaveValue()
//				:commonTypeSaveMapper.selectByPrimaryKey(getModule(session)).getSaveValue();
//		JSONObject jso = JSONObject.parseObject(commonType);
//		JSONArray commonTypeList = new JSONArray();
//		if(jso!=null){
//			commonTypeList =  jso.getJSONArray("saveValue");
//		}
//		List<Demand> serviceList = demandService.takeList(search,serviceTypetree!=null?serviceTypetree:getModule(session),order,rb);
//		Integer count = demandService.takeListCount(search,serviceTypetree, getCompany(session)!=null?getModule(session):null);
//		String jsonList = JSON.toJSONString(serviceList);
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("flag", flag);
//		modelAndView.addObject("jsonList", jsonList);
//		modelAndView.addObject("count", count);
//		modelAndView.addObject("serviceTypetree", serviceTypetree);
//		modelAndView.addObject("commonTypeList", commonTypeList);
//		modelAndView.setViewName("goodsinfo/demandList");
//		return modelAndView;
//	}


	/**
	 *@description 服务列表分页
	 */
	@RequestMapping(value="/showListAjax")
	public void showServiceListByAjax(Boolean to,HttpSession session,HttpServletResponse response,Integer page,String order,String type,String search){


		if (to!=null){
			clearModule(session);
		}

		Integer pageSize = 10;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<DemandVo> serviceList = demandService.takeList1(search,type!=null?type:getModule(session),order,rb);
		Integer count = demandService.takeListCount(search,type, getModule(session)!=null?getModule(session):null);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", serviceList);
		map.put("count", count);
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, JSONObject.parseObject(HtmlUtil.delHTML(JSONObject.toJSONString(map))));
	}





	//首页的需求展示
	@ResponseBody
	@Cacheable(value = "homeChae",key = "'demandHome:'+#session.getAttribute('module')")
	@CachePut(value = "homeChae",key = "'demandHome:'+#session.getAttribute('module')")
	@RequestMapping(value = "/home",produces = "text/html;charset=UTF-8")
	public String  home(HttpSession session){
//		List<Demand> demands = demandService.takeTopByCount(10, getModule(session));
		List<DemandVo> demands = demandService.takeTopByCount1(10, getModule(session));
		return AppJsonResult.success(demands).Json();
	}

	
	/**
	 * 跳转添加需求页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/gotodemand")
	public String gotodemand(HttpSession session){
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		if(logInfo == null){
			return new JsonResult(false, "请先登陆在操作!", null).toJSON();
		}
		return new JsonResult(true, null, null).toJSON();
	}
	
	@RequestMapping("/sa")
	public ModelAndView sa(){
		return new ModelAndView("demand/adddemand");
	}
	
	/**
	 * 添加需求
	 * @param session
	 * @param demand
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addDemand",produces = "text/html;charset=UTF-8")
	public String addDemand(HttpSession session, @RequestParam("demand")String demand){
		Demand demand2 = JSONObject.parseObject(demand, Demand.class);
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		JsonResult jr = demandService.addDemand(demand2, logInfo.getLogId());
		return jr.toJSON();
	}
	
	/**
	 * 跳转需求列表页
	 * @param demType
	 * @return
	 */
	@RequestMapping("/gotodemandList")
	public ModelAndView gotodemandList(HttpSession session,String demType){
		ModelAndView mv = new ModelAndView();
		String com=this.getModule(session);
		String commonType = commonTypeService.queryServiceTypeSave("1",getModule(session)).getSaveValue();
		JSONObject jso = JSONObject.parseObject(commonType);
		Object commonTypeList = new Object();
		if(jso!=null){
			commonTypeList =  jso.get("saveValue");
		}
		mv.addObject("commonTypeList", commonTypeList);
		mv.addObject("demType", demType);
		mv.setViewName("demand/demandList");
		return mv;
	}
	
	/**
	 * 查询需求列表
	 * @param response
	 * @param page
	 * @param demand
	 */
	@RequestMapping("/demandList")
	public void demandList(HttpSession session,HttpServletResponse response, Integer page, Demand demand){
		if(page == null){
			page = 1;
		}
		List<Demand> list = demandService.selectAll1(getRowBounds(page, 10), demand);
		int i = demandService.count1(demand);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("total", i);
		map.put("page", page);
		JsonUtil.printByJSON(response, map);
	}
	
	/**
	 * 跳转个人中心需求列表页
	 * @param demand
	 * @param page
	 * @return
	 */
	@RequestMapping("/gotodemandAmind")
	public ModelAndView gotodemandAmind(HttpSession session,Demand demand, Integer page){
		ModelAndView mv = new ModelAndView();
		if(page == null){
			page = 1;
		}
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		demand.setDemLogid(logInfo.getLogId());
		List<DemandVo> list = demandService.selectAll(getRowBounds(page, 10), demand);
		int i = demandService.count(demand);
		mv.addObject("list", list);
		mv.addObject("total", i);
		mv.addObject("demand", demand);
		mv.addObject("page", page);
		mv.setViewName("demand/demandAdmin");
		return mv;
	}
	
	/**
	 * 跳转修改需求页
	 * @param id
	 * @return
	 */
	@RequestMapping("/gotoUpdateDemand")
	public ModelAndView gotoUpdateDemand(HttpSession session,String id){
		ModelAndView mv = new ModelAndView();
//		String com=getModule(session);
		Demand demand = demandService.selectById(id);
		mv.addObject("demand", demand);
		mv.setViewName("demand/updateDemand");
		return mv;
	}
	
	/**
	 * 修改需求
	 * @param demand
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateById")
	public String updateById(@RequestParam("demand")String demand){
		Demand demand2 = JSONObject.parseObject(demand, Demand.class);
		JsonResult jr = demandService.updateById(demand2);
		return jr.toJSON();
	}
	
	@ResponseBody
	@RequestMapping("/deleteById")
	public String deleteById(Demand demand){
		demand.setDemIsdelete(true);
		JsonResult jr = demandService.updateById(demand);
		return jr.toJSON();
	}


	//需求详情
	@Cacheable(value = "comSearchChae",key = "'demandqueryById:'+#id")
	@CachePut(value = "comSearchChae",key = "'demandqueryById:'+#id")
	@RequestMapping("/queryById")
	public ModelAndView queryById(HttpSession session,@RequestParam("id")String id){
		LogInfo loginfo=retrievalCurrentUserInfo(session);
		Demand demand=new Demand();
		demand.setDemId(id);
		DemandVo temp = demandService.selectDemandVoById(id);
		List<Demand> others=demandService.selectOthers(demand);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("demand/demanddetails");
		modelAndView.addObject("demand", temp);
		modelAndView.addObject("others", others);

		//setModule(session,temp.getDemTypetree().contains(",")?temp.getDemTypetree().substring(0,temp.getDemTypetree().indexOf(",")):temp.getDemTypetree());

		return modelAndView;
	}
	
}
