package com.jero.esc.controller.appapi.demand;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;
import com.jero.esc.vo.demand.DemandVo;
import org.apache.http.protocol.HTTP;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.demand.IDemandService;
import com.jero.esc.vo.demand.Demand;
@Controller("apiDemandController")
@RequestMapping("/appapi/demand")
public class DemandController extends AppBaseController {
	
	@Autowired
	private IDemandService demandService;

	@Autowired
	private CommonTypeService commonTypeService;

	@Autowired
	private CommonTypeSaveMapper commonTypeSaveMapper;


	/**
	 * 服务列表分页
	 * @param page 分页页数
	 * @param type 类型
	 * @param search 搜索字段
	 */
	@ResponseBody
	@RequestMapping(value="/showListAjax",method = RequestMethod.POST)
	public AppJsonResult showServiceListByAjax(Integer page,String type,String search) throws Exception {
		Integer pageSize = 10;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<DemandVo> serviceList = demandService.takeList1(search,type!=null?type:"0",null,rb);
		Integer count = demandService.takeListCount(search,type, null);
		return AppJsonResult.success(new FastPage<DemandVo>(serviceList,count,new PageRowBounds(page,pageSize)));
	}



	/**
	 * 首页的需求展示
	 * @param module 模块id
	 * @return
	 */
	@ResponseBody
	@Cacheable(value = "homeChae",key = "'apidemandHome:'+#module")
	@CachePut(value = "homeChae",key = "'apidemandHome:'+#module")
	@RequestMapping(value = "/home",method = RequestMethod.POST)
	public String  home(@RequestParam("module")String module){
//		List<Demand> demands = demandService.takeTopByCount(10, getModule(session));
		List<DemandVo> demands = demandService.takeTopByCount1(10, module);
		return AppJsonResult.success(demands).Json();
	}




	/**
	 * 跳转添加需求页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/gotodemand",method = RequestMethod.POST)
	public Object gotodemand(){
		String logId=logId();
		if(logId == null){
			return AppJsonResult.formJsonResult(new JsonResult(false, "请先登陆在操作!", null));
		}
		return AppJsonResult.formJsonResult(new JsonResult(true, null, null));
	}


	/**
	 * 添加需求
	 * @param demand 需求的json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addDemand",method = RequestMethod.POST)
	public Object addDemand(String demand){
		Demand demand2 = JSONObject.parseObject(demand, Demand.class);
		String logId=logId();
		JsonResult jr = demandService.addDemand(demand2,logId);
		return AppJsonResult.formJsonResult(jr);
	}
	
	/**
	 * 首页跳转需求列表页面左侧目录
	 * @param demType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/gotodemandList",method = RequestMethod.POST)
	public Object gotodemandList(String demType,String module){
		String commonType =commonTypeService.queryServiceTypeSave("1",module).getSaveValue();
		JSONObject jso = JSONObject.parseObject(commonType);
		Object commonTypeList = new Object();
		if(jso!=null){
			commonTypeList =  jso.get("saveValue");
			return AppJsonResult.success(commonTypeList);
		}
		return AppJsonResult.error("获取目录列表失败");
	}
	
	/**
	 * 查询需求列表
	 * @param page 分页页数
	 * @param demand
	 */
	@ResponseBody
	@RequestMapping(value="/demandList",method = RequestMethod.POST)
	public Object demandList(Integer page, Demand demand,String module){
		if(page == null){
			page = 1;
		}
		PageRowBounds pageRowBounds=getPageRowBounds(page, 10);
		List<Demand> list = demandService.selectAll1(getRowBounds(page, 10), demand);
		int i = demandService.count1(demand);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("total", i);
		map.put("page", page);
		FastPage<Demand> fd = null;
		try {
			fd = new FastPage<>(list, i, pageRowBounds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fd==null){
			return AppJsonResult.error("获取信息失败");
		}else{
			return AppJsonResult.success(fd);
		}
	}
	
	/**
	 * 跳转个人中心需求列表页
	 * @param demand
	 * @param page 分页页数
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/gotodemandAmind",method = RequestMethod.POST)
	public Object gotodemandAmind(Demand demand, Integer page){
		if(page == null){
			page = 1;
		}
		PageRowBounds pageRowBounds=getPageRowBounds(page, 10);
		List<DemandVo> list = demandService.selectAll(pageRowBounds, demand);
		int i = demandService.count(demand);
		FastPage<DemandVo> fd=null;
		try {
			fd = new FastPage<>(list, i, pageRowBounds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fd==null){
			return AppJsonResult.error("获取信息失败");
		}else{
			return AppJsonResult.success(fd);
		}
	}
	
	/**
	 * 获取根据ID详细需求信息
	 * @param id 需求的id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findDemandById",method=RequestMethod.POST)
	public Object findDemandById(String id){
		Demand demand = demandService.selectById(id);
		return demand!=null?AppJsonResult.success(demand):AppJsonResult.error("暂未该需求");
	}
	
	@ResponseBody
	@RequestMapping(value="/findDemandOthers",method=RequestMethod.POST)
	public Object findDemandOthers(String id){
		Demand demand = new Demand();
		demand.setDemId(id);
		List<Demand> others=demandService.selectOthers(demand);
		return others.size()>0?AppJsonResult.success(others):AppJsonResult.error("暂相关需求");
	}
	
	
	/**
	 * 修改需求
	 * @param demand 修改需求的json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateById",method = RequestMethod.POST)
	public Object updateById(@RequestParam("demand")String demand){
		Demand demand2 = JSONObject.parseObject(demand, Demand.class);
		JsonResult jr = demandService.updateById(demand2);
		return AppJsonResult.formJsonResult(jr);
	}


	/**
	 * 删除需求
	 * @param demand 删除需求的id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteById",method = RequestMethod.POST)
	public Object deleteById(Demand demand){
		demand.setDemIsdelete(true);
		JsonResult jr = demandService.updateById(demand);
		return AppJsonResult.formJsonResult(jr);
	}
}
