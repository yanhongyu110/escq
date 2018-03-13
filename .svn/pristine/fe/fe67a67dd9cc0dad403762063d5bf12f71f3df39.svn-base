package com.jero.esc.controller.wap.goodsinfo;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.mapper.bizinfo.CompanyInfoMapper;
import com.jero.esc.mapper.details.MegDetailsMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.po.bizinfo.CompanyInfo;
import com.jero.esc.po.bizinfo.CompanyInfoExample;
import com.jero.esc.po.details.MegDetails;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.goodsinfo.IServiceService;
import com.jero.esc.service.userinfo.IProviderInfoService;
import com.jero.esc.vo.goodsinfo.ServiceInfoVo;
import com.jero.esc.vo.userinfo.ProviderVo;
@Controller
@RequestMapping(value="/wap/goodsinfo")
public class IndexController extends BaseController{

	
	@Autowired
	private MegDetailsMapper megDetailsMapper;
	
	@Autowired
	private IProviderInfoService providerInfoService;
	@Autowired
	private IServiceService serviceService;
	@Autowired
	private CommonTypeSaveMapper commonTypeSaveMapper;
	@Autowired
	private CommonTypeMapper commonTypeMapper;
	@Autowired
	private CompanyInfoMapper companyInfoMapper;
	
	//下载页
	@RequestMapping("/home/toDownload")
	public ModelAndView toDownload(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/wap/goodsinfo/downloading");
		return modelAndView;
		}
	
	/**
	 * 
	  *@version v1.0
	  *@date 2016年12月27日
	  *@description 首页显示
	  *@return
	  *@return ModelAndView
	  *@method homeShow
	 */
	@RequestMapping(value="/ServiceInfo/homeShow.html")
	public ModelAndView homeShow(HttpSession session){
		String serviceTypetree = null;
		HashMap<String,Object> map = providerInfoService.queryRecommendProvider(getModule(session), getModule(session),2);
		Object proList = map.get("proList");
		Object serList1 = map.get("serList1");
		Object serList2 = map.get("serList2");
		Object siList = map.get("siList");
		Object adList = map.get("adList");
		Object commonTypeList = map.get("commonTypeList");
		String jsonList1 = JSON.toJSONString(serList1);
		String jsonList2 = JSON.toJSONString(serList2);
		ModelAndView modelAndView = new ModelAndView();
		LogInfo logInfo = this.retrievalCurrentUserInfo(session);
		if(logInfo != null){
			List<MegDetails> list = megDetailsMapper.selectListByLogId(logInfo.getLogId());
			modelAndView.addObject("logInfo", list.size());
		}else{
			modelAndView.addObject("logInfo", -1);
		}
		
		
		modelAndView.addObject("proList", proList);
		modelAndView.addObject("jsonList1", jsonList1);
		modelAndView.addObject("jsonList2", jsonList2);
		modelAndView.addObject("siList", siList);
		modelAndView.addObject("adList", adList);
		modelAndView.addObject("commonTypeList", commonTypeList);
		modelAndView.setViewName("wap/goodsinfo/index");
		return modelAndView;
	}
	
	@RequestMapping(value="/ServiceInfo/homeShowByAjax.html")
	public void homeShowByAjax(HttpSession session,HttpServletResponse response,String serviceTypetree){
		HashMap<String,Object> map = providerInfoService.queryRecommendProvider(serviceTypetree, getModule(session),2);
		HashMap<String,Object> mapp = new HashMap<String, Object>();
		mapp.put("serList1", map.get("serList1"));
		mapp.put("serList2", map.get("serList2"));
		JsonUtil.printByJSON(response, mapp);
	}
	
	
	/**
	 * 
	  *@version v1.0
	  *@date 2016年12月29日
	  *@description 前台分类筛选
	  *@return
	  *@return ModelAndView
	  *@method classifyProvider
	 */
	@RequestMapping(value="/ProviderInfo/classifyProvider")
	public ModelAndView classifyProvider(Integer page,HttpSession session){
		if(page==null){
			page = 1;
		}
		Integer pageSize = 4;
		String province = "";
		String city = "";
		String area = "";
		String order = "PI_DEALNUM DESC";
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<ProviderVo> proList = providerInfoService.queryProviderByCon(rb, province, city, area,order, getModule(session));
		Integer count = providerInfoService.queryProviderCountByCon(province, city, area, getModule(session));
		String jsonList = JSON.toJSONString(proList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("jsonList", jsonList);
		modelAndView.addObject("count", count);
		modelAndView.addObject("flag", "b");
		modelAndView.setViewName("wap/goodsinfo/providerList");
		return modelAndView;
	}
	
	/**
	 * 
	  *@version v1.0
	  *@date 2016年12月30日
	  *@description 筛选
	  *@param response
	  *@param province
	  *@param city
	  *@param area
	  *@param page
	  *@param order
	  *@return void
	  *@method classifyProviderByAjax
	 */
	@RequestMapping(value="/ProviderInfo/classifyProviderByAjax")
	public void classifyProviderByAjax(HttpServletResponse response,String province,String city,String area,Integer page,String order,HttpSession session){
		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<ProviderVo> proList = providerInfoService.queryProviderByCon(rb, province, city, area,order, getModule(session));
		Integer count = providerInfoService.queryProviderCountByCon(province, city, area, getModule(session));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("proList", proList);
		map.put("count", count);
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, map);
	}
	
	/**
     *@version v1.0
     *@date 2017年1月9日
     *@description 查询服务列表
     *@param page
     *@param serviceInfoVo
     *@return ModelAndView
     *@method showServiceList
    */
	@RequestMapping(value="/ServiceInfo/showServiceList")
	public ModelAndView showServiceList(HttpSession session,Integer page,String serviceTypetree,String order){
   		if(page==null){
			page = 1;
   		}
   		String province = "";
		String city = "";
		String area = "";
   		Integer pageSize = 4;
		order = "SERVICE_SUCCESSNUM DESC";
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<ServiceInfoVo> serviceList = serviceService.queryServiceByType(rb, serviceTypetree,order,province,city,area);
		Integer count = serviceService.queryServiceCountByType(serviceTypetree,province,city,area, getModule(session));
		String jsonList = JSON.toJSONString(serviceList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("jsonList", jsonList);
		modelAndView.addObject("count", count);
		modelAndView.addObject("serviceTypetree", serviceTypetree);
		modelAndView.setViewName("wap/goodsinfo/serviceList");
		modelAndView.addObject("flag", "a");
		return modelAndView;
	}
   
	/**
	  *@version v1.0
	  *@date 2017年1月9日
	  *@description 服务列表分页
	  *@param response
	  *@param page
	  *@param order
	  *@param serviceInfoVo
	  *@return void
	  *@method showServiceListByAjax
	 */
   	@RequestMapping(value="/ServiceInfo/showServiceListByAjax")
	public void showServiceListByAjax(HttpSession session,HttpServletResponse response,Integer page,String order,String serviceTypetree,String province,String city,String area){
		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<ServiceInfoVo> serviceList = serviceService.queryServiceByType(rb, serviceTypetree,order,province,city,area);
		Integer count = serviceService.queryServiceCountByType(serviceTypetree,province,city,area, getModule(session));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("serviceList", serviceList);
		map.put("count", count);
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, map);
	}
   	
   	
   	@RequestMapping(value="/ServiceInfo/searchService")
   	public ModelAndView searchService(HttpSession session,Integer page,String flag,String search,String order){
   		if(page==null){
			page = 1;
   		}
   		String province = "";
		String city = "";
		String area = "";
   		ModelAndView modelAndView = new ModelAndView();
   		Integer pageSize = 4;
   		if("a".equals(flag)){
   			order = "SERVICE_SUCCESSNUM DESC";
   			RowBounds rb = this.getRowBounds(page, pageSize);
   			List<ServiceInfoVo> serviceList = serviceService.queryServiceByCon(rb, search, order,province,city,area, getModule(session),(String)session.getAttribute("point"));
   			Integer count = serviceService.queryServiceCountByCon(search, order,province,city,area, getModule(session));
   			String jsonList = JSON.toJSONString(serviceList);
   			modelAndView.addObject("jsonList", jsonList);
   			modelAndView.addObject("count", count);
   			modelAndView.setViewName("wap/goodsinfo/serviceList");
   		}else if("b".equals(flag)){
   			order = "PI_DEALNUM DESC";
   			RowBounds rb = this.getRowBounds(page, pageSize);
   			List<ProviderVo> proList = providerInfoService.queryProviderBySearch(rb, search, order,province,city,area, getModule(session));
   			Integer count = providerInfoService.queryProviderCountBySearch(search, order,province,city,area, getModule(session));
   			String jsonList = JSON.toJSONString(proList);
   			modelAndView.addObject("jsonList", jsonList);
   			modelAndView.addObject("count", count);
   			modelAndView.setViewName("wap/goodsinfo/providerList");
   		}
   		modelAndView.addObject("flag", flag);
   		modelAndView.addObject("search", search);
		return modelAndView;
   	}
   	
   	
   	@RequestMapping("/ServiceInfo/searchServiceByAjax")
	public void searchServiceByAjax(HttpSession session,HttpServletResponse response,Integer page,String order,String flag,String search,String province,String city,String area){
		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		HashMap<String, Object> map = new HashMap<String, Object>();
		if("a".equals(flag)){
			List<ServiceInfoVo> serviceList = serviceService.queryServiceByCon(rb, search, order,province,city,area, getModule(session),(String)session.getAttribute("point"));
			Integer count = serviceService.queryServiceCountByCon(search, order,province,city,area, getModule(session));
			map.put("serviceList", serviceList);
			map.put("count", count);
		}else if("b".equals(flag)){
			List<ProviderVo> proList = providerInfoService.queryProviderBySearch(rb, search, order,province,city,area, getModule(session));
   			Integer count = providerInfoService.queryProviderCountBySearch(search, order,province,city,area, getModule(session));
   			map.put("proList", proList);
			map.put("count", count);
		}
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, map);
	}
   	
   	@RequestMapping(value="/ServiceInfo/searchProvider")
   	public ModelAndView searchProvider(HttpSession session,Integer page,String search,String order){
   		if(page==null){
			page = 1;
   		}
   		String province = "";
		String city = "";
		String area = "";
   		String flag = "b";
   		ModelAndView modelAndView = new ModelAndView();
   		Integer pageSize = 4;
   		order = "PI_DEALNUM DESC";
   		RowBounds rb = this.getRowBounds(page, pageSize);
   		List<ProviderVo> proList = providerInfoService.queryProviderBySearch(rb, search, order,province,city,area, getModule(session));
   		Integer count = providerInfoService.queryProviderCountBySearch(search, order,province,city,area, getModule(session));
   		String jsonList = JSON.toJSONString(proList);
   		modelAndView.addObject("jsonList", jsonList);
   		modelAndView.addObject("count", count);
   		modelAndView.addObject("search", search);
   		modelAndView.addObject("flag", flag);
   		modelAndView.setViewName("wap/goodsinfo/providerList");
		return modelAndView;
   	}
   	
   	@RequestMapping(value="/home/serviceEnsure")
   	public ModelAndView serviceEnsure(Integer flag){
   		ModelAndView modelAndView=new ModelAndView();
   		if(flag==1){
   			modelAndView.setViewName("wap/goodsinfo/serviceEnsure");
   		}
   		if(flag==2){
   			modelAndView.setViewName("wap/goodsinfo/nearest");
   		}
   		if(flag==3){
   			modelAndView.setViewName("wap/goodsinfo/startWithZero");
   		}
   		if(flag==4){
   			modelAndView.setViewName("wap/goodsinfo/publishService");
   		}
   		if(flag==5){
   			modelAndView.setViewName("wap/goodsinfo/publishDemand");
   		}
   		return modelAndView;
   	}
   	@RequestMapping(value="/getAllType")
   	public ModelAndView getAllType(HttpSession session){
   		ModelAndView modelAndView=new ModelAndView();
   		String temp=commonTypeSaveMapper.selectByPrimaryKey("0").getSaveValue();
   		JSONObject jso = JSONObject.parseObject(temp);
		Object commonTypeList = new Object();
		if(jso!=null){
			commonTypeList =  jso.get("saveValue");
		}
   		modelAndView.addObject("saveValue", commonTypeList);
   		modelAndView.setViewName("wap/goodsinfo/allType");
   		return modelAndView;
   	}
   	//通过所在公司类型 筛选 公司
   	@RequestMapping(value="/getAllTypeByCom")
   	public ModelAndView getAllTypeByCom(HttpSession session,String com){
   		ModelAndView modelAndView=new ModelAndView();
   		CompanyInfoExample example=new CompanyInfoExample();
   		CompanyInfo company=companyInfoMapper.selectByPrimaryKey(com);
   		CommonType parent=commonTypeMapper.selectByPrimaryKey(company.getCompComments());
   		List<CommonType> childrens=commonTypeMapper.selectChainByFid(company.getCompComments());
   		JSONArray ja=new JSONArray();
   		for (CommonType commonType : childrens) {
   			JSONObject jo=new JSONObject();
			jo.put("id", commonType.getCtId());
			jo.put("text", commonType.getCtName());
			ja.add(jo);
		}
   		JSONObject temp= new JSONObject();
   		temp.put("id", parent.getCtId());
   		temp.put("text", parent.getCtName());
   		temp.put("children", ja);
   		JSONArray res=new JSONArray();
   		res.add(temp);
   		modelAndView.addObject("saveValue", res);
   		modelAndView.setViewName("wap/goodsinfo/allType");
   		return modelAndView;
   	}
}
