package com.jero.esc.controller.wap.demand;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.demand.IDemandService;
import com.jero.esc.vo.demand.Demand;
import com.jero.esc.vo.demand.DemandVo;

@Controller
@RequestMapping("/wap/demand")
public class WapDemandController extends BaseController {
	
	@Autowired
	private IDemandService demandService;
	
	/**
	 * 跳转添加需求页面
	 * @return
	 */
	@RequestMapping("/gotoAddDemand")
	public ModelAndView gotoAddDemand(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("flag", 1);
		mv.setViewName("wap/demand/addDemand");
		return mv;
	}
	
	/**
	 * 添加需求
	 * @param session
	 * @param demand
	 * @return
	 */
	@RequestMapping(value = "/addDemand",produces = "text/html;charset=UTF-8")
	public void addDemand(HttpSession session, @RequestParam("demand")String demand, HttpServletResponse response){
		Demand demand2 = JSONObject.parseObject(demand, Demand.class);
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		JsonResult jr = demandService.addDemand(demand2, logInfo.getLogId());
		JsonUtil.printByJSON(response, jr);
	}
	
	/**
	 * 跳转个人中心需求列表页
	 * @param demand
	 * @param page
	 * @return
	 */
	@RequestMapping("/gotoDemandListAdmin")
	public ModelAndView gotoDemandListAdmin(){
		return new ModelAndView("wap/demand/demandList");
	}
	
	/**
	 * 查询需求
	 * @param session
	 * @param demand
	 * @param page
	 * @param response
	 */
	@RequestMapping("/queryDemandAmind")
	public void gotodemandAmind(HttpSession session,Demand demand, Integer page, HttpServletResponse response){
		HashMap<String,Object> map = new HashMap<String, Object>();
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		demand.setDemLogid(logInfo.getLogId());
		List<DemandVo> list = demandService.selectAll(getRowBounds(1, page), demand);
		int i = demandService.count(demand);
		map.put("list", list);
		map.put("taotalPage", i);
		map.put("demand", demand);
		map.put("page", page);
		JsonUtil.printByJSON(response, map);
	}
	
	/**
	 * 
	 *<pre>
	 *<b> 跳转个人主页 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-15 下午3:40:31
	 *@return
	 *</pre>
	 */
	@RequestMapping(value="/demandListforhomepage")
	public ModelAndView queryDemandListForHomePage(){
		return new ModelAndView("wap/userinfo/demandListforhomepage");
	}
	
	/**
	 * 删除需求
	 * @param demand
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteById")
	public String deleteById(Demand demand){
		demand.setDemIsdelete(true);
		JsonResult jr = demandService.updateById(demand);
		return jr.toJSON();
	}
	
	/**
	 * 跳转修改需求页
	 * @param id
	 * @return
	 */
	@RequestMapping("/gotoUpdateDemand")
	public ModelAndView gotoUpdateDemand(HttpSession session,String id){
		ModelAndView mv = new ModelAndView();
		Demand demand = demandService.selectById(id);
		mv.addObject("demand", demand);
		mv.addObject("flag", 2);
		mv.setViewName("wap/demand/addDemand");
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
	
	/**
	 * 需求详情
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryById")
	public ModelAndView queryById(HttpSession session,@RequestParam("id")String id){
		Demand demand=new Demand();
		demand.setDemId(id);
		DemandVo temp = demandService.selectDemandVoById(id);
		List<Demand> others=demandService.selectOthers(demand);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("wap/demand/demandDetails");
		modelAndView.addObject("demand", temp);
		modelAndView.addObject("others", others);

		//setModule(session,temp.getDemTypetree().contains(",")?temp.getDemTypetree().substring(0,temp.getDemTypetree().indexOf(",")):temp.getDemTypetree());

		return modelAndView;
	}
	
}
