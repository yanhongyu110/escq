package com.jero.esc.controller.appapi.goodsinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jero.esc.po.app.AppPoint;
import com.jero.esc.po.map.Point;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.pubinfo.AdvertisePosition;
import com.jero.esc.po.pubinfo.SwitchInfo;
import com.jero.esc.service.goodsinfo.IServiceService;
import com.jero.esc.service.pubinfo.IAdvertisePositionService;
import com.jero.esc.service.pubinfo.ISwitchInfoService;
import com.jero.esc.service.userinfo.IProviderInfoService;
import com.jero.esc.vo.goodsinfo.ServiceInfoVo;
import com.jero.esc.vo.userinfo.ProviderVo;
import com.jero.esc.vo.userinfo.ServiceVo;
@Controller("apiHomeController")
@RequestMapping("/appapi/goodsinfo")
public class HomeController extends AppBaseController{
	
	@Autowired
	private ProviderInfoMapper pim;
	@Autowired
	private IProviderInfoService providerInfoService;
	@Autowired
	private IServiceService serviceService;
	@Autowired
	private IAdvertisePositionService advertisePositionService;
	@Autowired
	private ISwitchInfoService switchInfoService;
	@Autowired
	private CommonTypeService commonTypeService;
	@Autowired
	private ProviderInfoMapper providerInfoMapper;



	@ResponseBody
	@RequestMapping(value = "/ServiceInfo/searchServiceByAjax",method = RequestMethod.POST)
	public AppJsonResult searchServiceByAjax(String type, Integer page, String order, String flag, String search, String province, String city, String area,String point) {
		if (search==null) search="";
		AppPoint appPoint=JSONObject.parseObject(point,AppPoint.class);
		point=appPoint.getLat()+","+appPoint.getLng();
		FastPage fastPage=null;
		Integer pageSize = 10;
		switch (Integer.parseInt(order)){
			case 0:
				order=flag.equals("a")?"SERVICE_SUCCESSNUM DESC":"PI_DEALNUM DESC";
				break;
			case 1:
				order=flag.equals("a")?"SERVICE_MEETNUM DESC":"PI_MEETNUM DESC";
				break;
			case 2:
				order=flag.equals("a")?"SERVICE_MARK DESC":"PI_MARK DESC";
				break;
			case 3:
				order=flag.equals("a")?"PSET_PRICE DESC":"PSET_PRICE DESC";
				break;
			default:
				break;
		}
		RowBounds rb = this.getRowBounds(page, pageSize);
		if (StringUtils.isBlank(province))province=null;
		if (StringUtils.isBlank(city))province=null;
		if(StringUtils.isBlank(area))area=null;
		if ("a".equals(flag)) {
			Integer count = serviceService.queryServiceCountByCon(search, order, province, city, area, StringUtils.isBlank(type)?null:type);
			List<ServiceInfoVo> serviceList = serviceService.queryServiceByCon(rb, search, order, province, city, area, StringUtils.isBlank(type)?null:type,point);
			if (count<=0){
				count=serviceService.queryServiceCountByCon(search, order, null, null, null, StringUtils.isBlank(type)?null:type);
				serviceList= serviceService.queryServiceByCon(rb, search, order, null, null, null, StringUtils.isBlank(type)?null:type,point);
			}
			fastPage=new FastPage(serviceList,count,page,pageSize);
		} else if ("b".equals(flag)) {
			Integer count = providerInfoService.queryProviderCountBySearch(search, order, province, city, area, StringUtils.isBlank(type)?null:type);
			List<ProviderVo> proList = providerInfoService.queryProviderBySearch(rb, search, order, province, city, area, StringUtils.isBlank(type)?null:type);
			if (count<=0){
				count=providerInfoService.queryProviderCountBySearch(search, order, null, null, null, StringUtils.isBlank(type)?null:type);
				proList=providerInfoService.queryProviderBySearch(rb, search, order, null, null, null, StringUtils.isBlank(type)?null:type);
			}
			fastPage=new FastPage(proList,count,page,pageSize);
		}
		return AppJsonResult.success(fastPage);
	}











	/**
	 * 得到首页的类型列表
	 * @param module 模块的id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/ServiceInfo/getComtypeList",method = RequestMethod.POST)
	public Object getHomeComtypeList(String module) throws Exception {
		 String commonType = commonTypeService.queryServiceTypeSave("1",module).getSaveValue();
			JSONObject jso = JSONObject.parseObject(commonType);
			Object commonTypeList = new Object();
			if(jso!=null){
				commonTypeList =  jso.get("saveValue");
			}
			return AppJsonResult.success(commonTypeList);
	 }


	/**
	 * 得到首页广告
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/ServiceInfo/getHomeAdvertise",method = RequestMethod.POST)
	public Object getHomeAdvertise() throws Exception {
		AdvertisePosition advertisePosition = new AdvertisePosition();
		advertisePosition.setApPosition("1");
		List<AdvertisePosition> adList = advertisePositionService.queryAdByPosition(advertisePosition);
		if(adList!=null&&adList.size()>0){
			JSONArray ja = JSONArray.parseArray(adList.get(0).getApImage());
			if(ja!=null){
				JSONObject jsono = JSONObject.parseObject(ja.getString(0));
				adList.get(0).setApCommnet(jsono.getString("url"));
			}
		}
		return AppJsonResult.success(adList);
	 }


	/**
	 * 得到首页服务
	 * @param serviceTypetree
	 * @param module
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/ServiceInfo/getHomeService",method = RequestMethod.POST)
	public Object getHomeService(String module) throws Exception {
		String serviceTypetree=null;
		List<ServiceInfoVo> serList = serviceService.queryHomeServiceInfo(serviceTypetree,module);
		List<ServiceInfoVo> serList1 = new ArrayList<ServiceInfoVo>();
		List<ServiceInfoVo> serList2 = new ArrayList<ServiceInfoVo>();
		for (int i = 0; i < serList.size(); i++) {
			if(i<4){
				serList1.add(serList.get(i));
			}else{
				serList2.add(serList.get(i));
			}
		}
		HashMap<String,Object> map=new HashMap<>();
		map.put("serList1", serList1);
		map.put("serList2", serList2);
		return AppJsonResult.success(map);
	 }


	@ResponseBody
	@RequestMapping(value="/ServiceInfo/getHomeProvider",method = RequestMethod.POST)
	public Object getHomeProvider(String module) throws Exception {
		List<ProviderVo> proList1 =  pim.selectRecommendProvider(module);
		List<ProviderVo> proList2 =  pim.selectProviderByOrder(RowBounds.DEFAULT,"PI_MEETNUM DESC",module);
		List<ProviderVo> proList = new ArrayList<ProviderVo>();
		if(proList1.size()>0){
			for (int j = 0; j < proList1.size(); j++) {
				proList.add(proList1.get(j));
			}
		}else if(proList2.size()<8){
			for (int k = 0; k < proList2.size(); k++) {
				proList.add(proList2.get(k));
			}
		}else{
			for (int k = 0; k < 8; k++) {
				proList.add(proList2.get(k));
			}
		}
		return AppJsonResult.success(proList);
	 }


	@ResponseBody
	@RequestMapping(value="/ServiceInfo/getHomeSwichInfo",method = RequestMethod.POST)
	public Object getHomeSwichInfo(String module) throws Exception {
		SwitchInfo switchInfo=new SwitchInfo();
		switchInfo.setSwitchPos(2);
		if(module==null||module==""||module=="0"){
			switchInfo.setCompany("00001");	
		}
			switchInfo.setCompany(module);
			List<SwitchInfo> siList = switchInfoService.queryPicByPosition(switchInfo);
			if(siList!=null&&siList.size()>0){
				return AppJsonResult.success(siList.get(0));
			}else{
				return AppJsonResult.error("获取轮播失败，请输入正确的模块ID");
			}

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
	@ResponseBody
	@RequestMapping(value="/ProviderInfo/classifyProvider",method = RequestMethod.POST)
	public Object  classifyProvider(Integer page,Integer pageSize,String province,String city,String area,String order,String module){
		if(page==null){
			page = 1;
		}
		if(null==pageSize){
			pageSize=10;
		}
		if(null==province){
			province="";
		}
		if(null==city){
			city="";
		}
		if(null==area){
			area="";
		}
		if(null==order){
			order= "PI_DEALNUM DESC";
		}
		PageRowBounds rb = this.getPageRowBounds(page, pageSize);
		List<ProviderVo> proList = providerInfoService.queryProviderByCon(rb, province, city, area,order,module);
		Integer count = providerInfoService.queryProviderCountByCon(province, city, area, module);
		FastPage<ProviderVo> fastPage=null;
		try {
			fastPage = new FastPage<>(proList, count,rb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AppJsonResult.success(fastPage);
	}
	
	
	/**
     *@version v1.0
     *@date 2017年1月9日
     *@description 查询服务列表
     *@param page
     *@return ModelAndView
     *@method showServiceList
    */
	@ResponseBody
	@RequestMapping(value="/ServiceInfo/showServiceList",method = RequestMethod.POST)
	public Object showServiceList(String flag,String serviceTypetree,Integer page,Integer pageSize,String province,String city,String area,String module){
		if(page==null){
			page = 1;
		}
		if(null==pageSize){
			pageSize=10;
		}
		if(null==province){
			province="";
		}
		if(null==city){
			city="";
		}
		if(null==area){
			area="";
		}
		String order="";
		if(null==flag){
			order= "SERVICE_SUCCESSNUM DESC";
		}
		if("a".equals(flag)){
   			order = "SERVICE_SUCCESSNUM DESC";
   		}
		if("b".equals(flag)){
   			order = "PI_DEALNUM DESC";
   			}
		PageRowBounds rb = this.getPageRowBounds(page, pageSize);
		List<ServiceInfoVo> serviceList = serviceService.queryServiceByType(rb, serviceTypetree,order, province,city, area);
		Integer count = serviceService.queryServiceCountByType(serviceTypetree, province,city, area,module);
		FastPage<ServiceInfoVo> fastPage=null;
		try {
			fastPage = new FastPage<>(serviceList, count,rb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AppJsonResult.success(fastPage);
	}
   	
   	@ResponseBody
   	@RequestMapping(value="/ServiceInfo/showVideoList",method = RequestMethod.POST)
   	public Object showVideoList(Integer page,String order,String module){
   		if(page==null){
			page = 1;
   		}
   		if(null==order){
   			order = "PI_DEALNUM DESC";
   		}
   		PageRowBounds rb = this.getPageRowBounds(page, 16);
   		List<ProviderVo> videoList = providerInfoService.selectProviderByOrder(rb,module);
   		Integer count=providerInfoService.selectProviderCountByOrder(module);
   		FastPage<ProviderVo> fastPage=null;
		try {
			fastPage = new FastPage<>(videoList, count,rb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return AppJsonResult.success(fastPage);
   	}
	@ResponseBody
    @RequestMapping(value = "/recommend",method = RequestMethod.POST)
    public  AppJsonResult recommend(){
        List<ProviderVo> providerVos = providerInfoMapper.selectProviderByOrder(RowBounds.DEFAULT,"PI_MEETNUM DESC",null);
        if(providerVos!=null&&providerVos.size()>0){
			return AppJsonResult.success(providerVos);
		}else{
			return AppJsonResult.error("暂无达人推荐");
		}
    }
		
	
}
