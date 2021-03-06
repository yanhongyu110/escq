package com.jero.esc.controller.goodsinfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.utils.fastvalidate.FastValidate;
import com.jero.esc.common.utils.fastvalidate.ValidateResult;
import com.jero.esc.mapper.bizinfo.CompanyInfoMapper;
import com.jero.esc.mapper.details.MegDetailsMapper;
import com.jero.esc.mapper.system.SystemMegsMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.bizinfo.CompanyInfo;
import com.jero.esc.po.checkinfo.ProviderCheckInfo;
import com.jero.esc.po.details.MegDetails;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.goodsinfo.ServiceStep;
import com.jero.esc.po.goodsinfo.ServiceToLoginfo;
import com.jero.esc.po.system.SystemMegs;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.service.checkinfo.IProviderCheckInfoService;
import com.jero.esc.service.goodsinfo.IRemarkService;
import com.jero.esc.service.goodsinfo.IServiceService;
import com.jero.esc.service.goodsinfo.IServiceToLoginfoService;
import com.jero.esc.service.userinfo.IProviderInfoService;
import com.jero.esc.vo.goodsinfo.RemarkCountVo;
import com.jero.esc.vo.goodsinfo.ServiceInfoVo;
import com.jero.esc.vo.goodsinfo.ServiceRemarkVo;
import com.jero.esc.vo.userinfo.ProviderVo;
import com.jero.esc.vo.userinfo.ServiceVo;

@Controller
@RequestMapping("/goodsinfo")
public class ServiceController  extends BaseController{
	@Autowired
	private SystemMegsMapper systemMegsMapper;
	@Autowired
	private MegDetailsMapper megDetailsMapper;
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IRemarkService remarkService;
    
    @Autowired
    private IProviderInfoService providerInfoService;

	@Autowired
	private IProviderCheckInfoService providerCheckInfoService;

	@Autowired
	private ProviderInfoMapper providerInfoMapper;
	@Autowired
	private CompanyInfoMapper companyInfoMapper;
	@Autowired
	private IServiceToLoginfoService serviceToLoginfoService;

	/**
	 * @param session
	 * @param serviceId
	 * @param aBoolean true：取消点赞  false：点赞
	 * @return
	 */
	@RequestMapping("/service/dianzan")
	public void dianzan(HttpSession session, String serviceId, Boolean aBoolean, HttpServletResponse response){
		JsonResult result = new JsonResult();
		Boolean aBoolean1 = null;
		Boolean aBoolean2 = null;
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		ServiceToLoginfo serviceToLoginfo = new ServiceToLoginfo();
		serviceToLoginfo.setServiceId(serviceId);
		serviceToLoginfo.setLogId(logInfo.getLogId());
		ServiceInfo serviceInfo = new ServiceInfo();
		if(aBoolean){
			aBoolean1 = serviceToLoginfoService.deleteByLogIdAndServiceId(logInfo.getLogId(), serviceId);
			aBoolean2 = serviceService.updateService(serviceId, false);
			if(aBoolean1 && aBoolean2){
				result.setSuccess(true);
				result.setErrorMsg("取消点赞成功");
				try {
					serviceInfo = serviceService.queryByPrimaryKey(serviceId);
					SystemMegs sm = new SystemMegs();
					sm.setSmId(UUIDUtil.getUUID());
					sm.setSmCreatetime(new Date());
					sm.setSmIsdelete(false);
					sm.setSmType(1);
					sm.setSmTitle("平台消息");
					sm.setSmContent(logInfo.getLogName() + "取消了对你的服务\""+serviceInfo.getServiceTitle()+"\"的点赞,快去看看吧!!");
					MegDetails md = new MegDetails();
					md.setMdId(UUIDUtil.getUUID());
					md.setMdCreatetime(new Date());
					md.setMdIsdelete(false);
					md.setLogId(serviceInfo.getLogId());
					md.setSmId(sm.getSmId());
					md.setOperatorId(serviceId);
					md.setOperatorType(logInfo.getLogType());
					md.setMdType(2);
					systemMegsMapper.insert(sm);
					megDetailsMapper.insert(md);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				result.setSuccess(false);
				result.setErrorMsg("取消点赞失败");
			}
		} else {
			aBoolean1 = serviceToLoginfoService.insert(serviceToLoginfo);
			aBoolean2 = serviceService.updateService(serviceId, true);
			if(aBoolean1 && aBoolean2){
				result.setSuccess(true);
				result.setErrorMsg("点赞成功");
				
				
				try {
					serviceInfo = serviceService.queryByPrimaryKey(serviceId);
					SystemMegs sm = new SystemMegs();
					sm.setSmId(UUIDUtil.getUUID());
					sm.setSmCreatetime(new Date());
					sm.setSmIsdelete(false);
					sm.setSmType(1);
					sm.setSmTitle("平台消息");
					sm.setSmContent(logInfo.getLogName() + "赞了你的服务\""+serviceInfo.getServiceTitle()+"\",快去看看吧!!");
					MegDetails md = new MegDetails();
					md.setMdId(UUIDUtil.getUUID());
					md.setMdCreatetime(new Date());
					md.setMdIsdelete(false);
					md.setLogId(serviceInfo.getLogId());
					md.setSmId(sm.getSmId());
					md.setOperatorId(serviceId);
					md.setOperatorType(logInfo.getLogType());
					md.setMdType(2);
					systemMegsMapper.insert(sm);
					megDetailsMapper.insert(md);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				result.setSuccess(false);
				result.setErrorMsg("点赞失败");
			}
		}
		JsonUtil.printByJSON(response, result);
	}

    /**
     * 打开添加服务页面
     * @return
     */
    @RequestMapping("/service/viewAddService")
    public ModelAndView viewAddService(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        // TODO: 2016/12/12

		ProviderCheckInfo providerCheckInfo = providerCheckInfoService.queryByLogId(retrievalCurrentUserInfo(session).getLogId());
		if (providerCheckInfo==null||providerCheckInfo.getPciState()!=2){
			modelAndView.addObject("title", "添加服务");
			modelAndView.addObject("content", "请进行服务商认证");
			modelAndView.addObject("url", "checkinfo/providerCheck/getCheckInfo.html");
			modelAndView.addObject("name", "点击进行服务商认证");
			modelAndView.setViewName("pubinfo/kanban");
			return modelAndView;
		}

		ProviderInfo providerInfo = providerInfoMapper.selectByLogId(retrievalCurrentUserInfo(session).getLogId());
		CompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(providerInfo.getPiCom());

		modelAndView.addObject("includes",companyInfo.getCompComments());

		modelAndView.setViewName("goodsinfo/addservice");
        return  modelAndView;
    }


    /**
     * 添加服务
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/service/addService",produces = "text/html;charset=UTF-8")
    @NoRepeatRequest
    public  String  addService(HttpSession session, @RequestParam("service")String service) throws Exception {
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        ServiceInfo serviceInfo = JSONObject.parseObject(service, ServiceInfo.class);
		String serviceContent = serviceInfo.getServiceContent();
		serviceInfo.setServiceContent(null);
		if (HtmlFilter.filter(serviceInfo)){
			return  new JsonResult("不能使用html标签").toJSON();
		}


		serviceInfo.setServiceContent(serviceContent);
        //验证
        if (isValidate){
            FastValidate<ServiceInfo> serviceInfoFastValidate = new FastValidate<ServiceInfo>(serviceInfo);
            //serviceBiref,
            serviceInfoFastValidate.setReqiureList("servicePic,serviceType,serviceTitle,serviceContent,serviceMeettime,serviceAttrinfo,serviceSteps,priceSets",true);
            ValidateResult validateResult = serviceInfoFastValidate.validateObject(true);
            if (!validateResult.validate){
                validateResult.printAllMeassage();
                return new JsonResult(false,"错误",validateResult.list).toJSON();
            }
            //TODO  
            serviceInfo.setLogId(retrievalCurrentUserInfo(session).getLogId());
	             
//	        serviceInfo.setLogId("21313");
//	        for (PriceSet it : serviceInfo.getPriceSets()) {
//	        	for (int i = 0; i < serviceInfo.getPriceSets().size(); i++) {
//					it.setLogId("" +serviceInfo.getPriceSets().get(i)+i);
//				}
//	        }
		}
        
        if(serviceInfo.getServiceTitle().length()>0 && serviceInfo.getServiceTitle() != null){
		 	Pattern p = Pattern.compile("^[\u4e00-\u9fa5a-zA-Z0-9]{5,}$");
			Matcher m = p.matcher(serviceInfo.getServiceTitle());
			if (false == m.matches()) {
				return  new JsonResult(false,"服务名不对",null).toJSON();
			}
        }else{
        	return  new JsonResult(false,"服务名不能为空",null).toJSON();
        }
       if(serviceInfo.getServiceKeywords()!=null && serviceInfo.getServiceKeywords().length()>0){
    	   String biref = serviceInfo.getServiceKeywords();
		   biref=biref.substring(2,biref.length()-2);
    	   String[] birefs = biref.split("[,|，]");
    	   if(birefs.length > 5){
    		   return  new JsonResult(false,"关键词不能超过5",null).toJSON();
    	   }
    	   for(int i=0;i<birefs.length;i++){
    		   if(birefs[i]!=null && !"".equals(birefs[i])){
    			   if (!birefs[i].matches("^([\\u4e00-\\u9fa5]|\\w)+$")) {
    				   return  new JsonResult(false,"关键词不对",null).toJSON();
    			   }
    		   }
    	   }
       }
       /*if(serviceInfo.getServiceBiref().length()>200 || serviceInfo.getServiceBiref().length()<1){
    	   return  new JsonResult(false,"简介不对",null).toJSON();
       }*/
        if(serviceInfo.getPriceSets() != null){
        	for(int i=0;i<serviceInfo.getPriceSets().size();i++){
        		String price = serviceInfo.getPriceSets().get(i).getPsetPrice().toString();
    		 	Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
    			Matcher m = p.matcher(price);
    			if (false == m.matches()) {
    				return  new JsonResult(false,"价格不对",null).toJSON();
    			}
        	}
        }else{
        	return  new JsonResult(false,"价格不能为空",null).toJSON();
        }
        if(serviceInfo.getPriceSets() != null){
        	for(int i=0;i<serviceInfo.getPriceSets().size();i++){
        		String point = serviceInfo.getPriceSets().get(i).getPsetPoint().toString();
    		 	Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
    			Matcher m = p.matcher(point);
    			if (false == m.matches()) {
    				return  new JsonResult(false,"积分不对",null).toJSON();
    			}
        	}
        }else{
        	return  new JsonResult(false,"积分不能为空",null).toJSON();
        }
        
        
        try {
            serviceService.addService(serviceInfo);
        }catch (ExceptionWithMessage e){
            return  e.jsonResult.toJSON();
        } catch (Exception e) {
        	return  new JsonResult(false,"添加失败,请刷新重新填写",null).toJSON();
        }
        return  new JsonResult(true,null,"/goodsinfo/service/viewProviderService.html").toJSON();
    }


    /**
     * 显示服务查询页面
     * @return
     * @throws Exception 
     */
	@RequestMapping("/service/viewProviderService")
    public  ModelAndView viewProviderService(ServiceVo serviceVo,HttpServletResponse response,HttpSession session,Integer page,Integer pageSize) throws Exception{
		if(retrievalCurrentUserInfo(session)==null){
    		throw new Exception();
    	}
    	if (FastValid.isEmp(page)){
            page=1;
            pageSize=10;
        }

		if (serviceVo.getStart()!=null&&serviceVo.getStart().trim().equals("")){
			serviceVo.setStart(null);
		}
		if (serviceVo.getEnd()!=null&&serviceVo.getEnd().trim().equals("")){
			serviceVo.setEnd(null);
		}
		if (serviceVo.getServiceType()!=null&&serviceVo.getServiceType().trim().equals("")){
			serviceVo.setServiceType(null);
		}

    	serviceVo.setServiceIsdelete(false);
    	PageRowBounds pageRowBounds = getPageRowBounds(page,pageSize);
		serviceVo.setLogId(retrievalCurrentUserInfo(session).getLogId());
    	FastPage<ServiceVo> infos = serviceService.queryServiceInfo(serviceVo, pageRowBounds);
        ModelAndView modelAndView = new ModelAndView();
//        if(infos.list!=null&&infos.list.size()>0){
	        modelAndView.setViewName("/goodsinfo/serviceAdmin");
	        modelAndView.addObject("infos", infos);
	        modelAndView.addObject("info", serviceVo);
//        }else {
//	   		modelAndView.addObject("title", "咨询主题");
//	        modelAndView.addObject("content", "还没有添加主题");
//	        modelAndView.setViewName("pubinfo/kanban");
//	        return modelAndView;
//        }
        return  modelAndView;
    }
	
	 /**
     * 打开编辑服务页面
     * @return
	 * @throws Exception 
     */
	@RequestMapping("/service/viewModifyService")
    public  ModelAndView viewUpdateService(String serviceId,HttpSession session) throws Exception{
		Map<String,String> map = new HashMap<String, String>();
		List<ServiceStep> steps = serviceService.selectServiceSetById(serviceId);
		for(ServiceStep step : steps){
			String[] s = step.getSsPrice().substring(2, step.getSsPrice().length()-2).split(",");
			for(String ss : s){
				String[] sv = ss.split(":");
				map.put(sv[0].substring(1, sv[0].length()-1), sv[1].substring(1, sv[1].length()-1));
				
			}
		}
		ServiceVo serviceVo = serviceService.queryServiceVoDetailsById(serviceId,Integer.valueOf(map.get("psetDiscountType")),null);
		serviceVo.getLogId();
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsinfo/updateService");
        modelAndView.addObject("info", serviceVo);
        return  modelAndView;
    }
	 
	/**
     * 修改服务
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/service/updateService",produces = "text/html;charset=UTF-8")
    @NoRepeatRequest
    public  String  updateService(HttpSession session, @RequestParam("service")String service) throws Exception {
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        ServiceInfo serviceInfo = null;
        try {
        	serviceInfo = JSONObject.parseObject(service, ServiceInfo.class);
        }catch (Exception e) {        	
        	e.printStackTrace();
            return  new JsonResult(false,"修改失败",null).toJSON();
        }
        if (isValidate){
            FastValidate<ServiceInfo> serviceInfoFastValidate = new FastValidate<ServiceInfo>(serviceInfo);
            //serviceBiref,
            serviceInfoFastValidate.setReqiureList("serviceId,servicePic,serviceType,serviceTitle,serviceContent,serviceMeettime,serviceAttrinfo,serviceSteps,priceSets",true);
            ValidateResult validateResult = serviceInfoFastValidate.validateObject(true);
            if (!validateResult.validate){
                validateResult.printAllMeassage();
                return new JsonResult(false,"错误",validateResult.list).toJSON();
            }
            //TODO  
            serviceInfo.setLogId(retrievalCurrentUserInfo(session).getLogId());
	        
		}
        if(serviceInfo.getServiceTitle().length()>0 && serviceInfo.getServiceTitle() != null){
		 	Pattern p = Pattern.compile("^[\u4e00-\u9fa5a-zA-Z0-9]{5,}$");
			Matcher m = p.matcher(serviceInfo.getServiceTitle());
			if (false == m.matches()) {
				return  new JsonResult(false,"服务名不对",null).toJSON();
			}
        }else{
        	return  new JsonResult(false,"服务名不能为空",null).toJSON();
        }
       if(serviceInfo.getServiceKeywords()!=null && serviceInfo.getServiceKeywords().length()>0){
    	   String biref = serviceInfo.getServiceKeywords();

		   biref=biref.substring(2,biref.length()-2);
    	   String[] birefs = biref.split("[,|，]");
    	   if(birefs.length > 5){
    		   return  new JsonResult(false,"关键词不能超过5",null).toJSON();
    	   }
			for(int i=0;i<birefs.length;i++){
				if(birefs[i]!=null && !"".equals(birefs[i])){
					if (!birefs[i].matches("^([\\u4e00-\\u9fa5]|\\w)+$")) {
						return  new JsonResult(false,"关键词不对",null).toJSON();
					}
				}
        	}
       }
       /*if(serviceInfo.getServiceBiref().length()>200 || serviceInfo.getServiceBiref().length()<1){
    	   return  new JsonResult(false,"简介不对",null).toJSON();
       }*/
        if(serviceInfo.getPriceSets() != null){
        	for(int i=0;i<serviceInfo.getPriceSets().size();i++){
        		String price = serviceInfo.getPriceSets().get(i).getPsetPrice().toString();
    		 	Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
    			Matcher m = p.matcher(price);
    			if (false == m.matches()) {
    				return  new JsonResult(false,"价格不对",null).toJSON();
    			}
        	}
        }else{
        	return  new JsonResult(false,"价格不能为空",null).toJSON();
        }
        if(serviceInfo.getPriceSets() != null){
        	for(int i=0;i<serviceInfo.getPriceSets().size();i++){
        		String point = serviceInfo.getPriceSets().get(i).getPsetPoint().toString();
    		 	Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
    			Matcher m = p.matcher(point);
    			if (false == m.matches()) {
    				return  new JsonResult(false,"积分不对",null).toJSON();
    			}
        	}
        }else{
        	return  new JsonResult(false,"积分不能为空",null).toJSON();
        }
        
        
        
        try {
            serviceService.modifyService(serviceInfo);
        }catch (ExceptionWithMessage e){
        	e.printStackTrace();
            return  e.jsonResult.toJSON();
        } catch (Exception e) {        	
        	e.printStackTrace();
            return  new JsonResult(false,"修改失败",null).toJSON();
        }
        return  new JsonResult(true,null,"").toJSON();
    }
	
    /**
     * 删除服务
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/service/deleteService",produces = "text/html;charset=UTF-8")
    @NoRepeatRequest
    public  void  deleteService(HttpServletResponse response,HttpSession session, @RequestParam("serviceId")String serviceId) throws Exception {
    	JsonResult jr = new JsonResult();
    	String resMsg = "";
    	ServiceInfo serviceInfo = new ServiceInfo();
    	if(retrievalCurrentUserInfo(session).getLogId()!=null||serviceId!=null){
    		serviceInfo.setServiceId(serviceId);
    		serviceInfo.setLogId(retrievalCurrentUserInfo(session).getLogId());
    		try {
    			Boolean res = serviceService.removeService(serviceInfo);
    			if(res){
    				jr.setSuccess(true);
    				resMsg = "删除成功！";
    			}else{
    				jr.setSuccess(false);
    				resMsg = "删除失败！";
    			}
    		} catch (Exception e) {
    			jr.setSuccess(false);
    			resMsg = "删除失败！";
    			e.printStackTrace();
    		}
    	}else{
    		jr.setSuccess(false);
    		resMsg = "删除失败！";
    	}
    	JsonUtil.printByJSON(response, resMsg);
    }
	
    /**
     * 查询服务
     * @param session
     * @param service
     * @param require
     * @param page
     * @param pageSize
     * @return
     * @throws Exception 
     */
    @ResponseBody
    @RequestMapping(value = "/service/queryProviderService",produces = "text/plain;charset=UTF-8")
    public  String queryProviderService(HttpSession session,@RequestParam("service")String service,@RequestParam("require")String require,Integer page,Integer pageSize) throws Exception{
    	if(retrievalCurrentUserInfo(session)==null){
    		throw new Exception();
    	}
        if (FastValid.isEmp(page)){
            page=1;
            pageSize=10;
        }
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        ServiceInfo serviceInfo = JSONObject.parseObject(service, ServiceInfo.class);
        serviceInfo.setLogId(retrievalCurrentUserInfo(session).getLogId());
        Map map = JSONObject.parseObject(require, Map.class);
        RowBounds rowBounds = getRowBounds(page, pageSize);
        try {
            serviceService.queryServiceByReqiure(serviceInfo,map,rowBounds);
        }catch (ExceptionWithMessage e){
            return  e.jsonResult.toJSON();
        } catch (Exception e) {
            return  new JsonResult(false,null,null).toJSON();
        }

        return  new JsonResult(true,null,null).toJSON();
    }

    /**
    *@description 查询服务详情 跳转至服务详情页面
    *@param session
    *@param serviceId
    *@throws Exception
    *@return ModelAndView
    *@method queryServiceDetails
     */
//	@Cacheable(value = "comSearchChae",key = "'queryServiceDetails:'+#serviceId+':'+#priceType")
//	@CachePut(value = "comSearchChae",key = "'queryServiceDetails:'+#serviceId+':'+#priceType")
    @ResponseBody
    @RequestMapping("/service/queryServiceDetails")
    public ModelAndView queryServiceDetails(HttpSession session, @RequestParam("serviceId") String serviceId,@RequestParam("priceType") Integer priceType) throws Exception {
    	PageRowBounds rb = getPageRowBounds(1, 6);
		ServiceVo serviceVo = serviceService.queryServiceVoDetailsById(serviceId,priceType,null);
		serviceVo.getLogId();

		setModule(session,serviceVo.getTypeTree().contains(",")?serviceVo.getTypeTree().substring(0,serviceVo.getTypeTree().indexOf(",")):serviceVo.getTypeTree());

		// 判断是否点赞 aBoolean：true 是  false 否
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		Boolean aBoolean = false;
		if(logInfo != null){
			ServiceToLoginfo serviceToLoginfo = new ServiceToLoginfo();
			serviceToLoginfo.setServiceId(serviceId);
			serviceToLoginfo.setLogId(logInfo.getLogId());
			aBoolean = serviceToLoginfoService.select(serviceToLoginfo);
		}

		List<ServiceInfoVo> serviceVoTree=serviceService.queryServiceByType(rb, serviceVo.getTypeTree(), "SERVICE_MEETNUM","","","");
		List<ProviderVo> providerVoTree =providerInfoService.queryProviderRecommend(getModule(session));
		List<ServiceStep> serviceSteplist = serviceService.selectServiceSetById(serviceId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/goodsinfo/servicedetails");
		Integer totalSize = remarkService.queryCountServiceRemarkByServiceId(serviceId);
		modelAndView.addObject("totalSize", totalSize);
		modelAndView.addObject("serviceVo", serviceVo);
		modelAndView.addObject("serviceVoTree", serviceVoTree);
		modelAndView.addObject("providerVoTree", providerVoTree);
		modelAndView.addObject("serviceSteplist", serviceSteplist);
		modelAndView.addObject("aBoolean", aBoolean);
		return modelAndView;
	}
    
    
    
    /**
     * 
     *@copyright 上善云图信息技术有限公司
     *@author ljh
     *@date 2017-02-13
     *@description 根据serviceId和srLevel查询服务评价
     */
    @ResponseBody
	@RequestMapping("/service/queryServiceRemark")
	public void queryServiceRemark(HttpSession session,HttpServletResponse response,@RequestParam("page")Integer page,@RequestParam("rows")Integer rows, @RequestParam("srLevel")String srLevel,@RequestParam("serviceId")String serviceId) throws Exception {
    	
    	
    	ServiceRemarkVo serviceRemarkVo=new ServiceRemarkVo();
    	
    	int[] lev = null;
		if (srLevel != null && srLevel.trim().length() > 0) {
			String[] str = srLevel.split(",");
			lev = new int[str.length];
			for (int i = 0; i < str.length; i++) {

				lev[i] = Integer.parseInt(str[i]);
			}
		}
		serviceRemarkVo.setSrLevel(lev);
		serviceRemarkVo.setServiceId(serviceId);
		
    	PageRowBounds rowBounds = getPageRowBounds(page, rows);
		
		List<ServiceRemarkVo> list = remarkService.queryServiceRemarkByServiceId(serviceRemarkVo, rowBounds);
		
		Integer totalSize = remarkService.queryCountServiceRemarkByServiceId(serviceRemarkVo);
		
		FastPage<ServiceRemarkVo> record = new FastPage<ServiceRemarkVo>(list, totalSize, rowBounds);
		
		
		JsonUtil.printByJSON(response, record);
	}
    
    /**
     * 
     *@copyright 上善云图信息技术有限公司
     *@author ljh
     *@date 2017-02-13
     *@description 根据serviceId和srLevel查询好中差评的数量
     */
    @ResponseBody
	@RequestMapping("/service/queryCountRemark")
	public void queryCountRemark(HttpSession session, HttpServletResponse response, String serviceId, Integer page,
			Integer rows) throws Exception {

		RemarkCountVo remarkCountVo = new RemarkCountVo();

		remarkCountVo.setServiceId(serviceId);

		List<RemarkCountVo> list = remarkService.queryCountRemark(remarkCountVo);

		JsonUtil.printByJSON(response, list);
	}

    
    /**
     * 
     *@copyright 上善云图信息技术有限公司
     *@author ljh
     * @throws Exception 
     *@date 2017-02-13
     *@description 我的评价ModelAndView
     */
	@RequestMapping("/service/queryAllCountServiceRemarkByTime")
	public ModelAndView queryAllCountServiceRemarkByTime(HttpSession session) throws Exception {
		validaLog(session);
		LogInfo logInfo=retrievalCurrentUserInfo(session);
		ModelAndView modelAndView = new ModelAndView();
		
		Integer[] serviceRemarkcount = remarkService.queryAllCountServiceRemarkByTime(logInfo.getLogId());
		modelAndView.setViewName("/goodsinfo/myremark");
		modelAndView.addObject("serviceRemarkcount", serviceRemarkcount);
		modelAndView.addObject("logId", logInfo.getLogId());
		return modelAndView;
	}

	/**
     * 
     *@copyright 上善云图信息技术有限公司
     *@author ljh
	 * @throws Exception 
     *@date 2017-02-13
     *@description 对我的评价ModelAndView
     */
	@RequestMapping("/service/queryServiceRemarkByLogId")
	public ModelAndView queryServiceRemarkByLogId(HttpSession session) throws Exception {
		validaLog(session);
		LogInfo logInfo=retrievalCurrentUserInfo(session);
		Integer[] providerRemarkcount = remarkService.queryServiceRemarkByLogId(logInfo.getLogId());
		ProviderInfo providerInfo=providerInfoService.queryByLogId(logInfo.getLogId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/goodsinfo/animaremarkslist");
		modelAndView.addObject("providerInfo",providerInfo);
		modelAndView.addObject("providerRemarkcount", providerRemarkcount);
		modelAndView.addObject("logId", logInfo.getLogId());
		return modelAndView;
	}

	
	/**
     * 
     *@copyright 上善云图信息技术有限公司
     *@author ljh
     *@date 2017-02-13
     *@description 根据logId和srLevel查询服务评价
     */
	@ResponseBody
	@RequestMapping("/service/queryServiceRemarkByLogIdSrLevel")
	public void queryServiceRemarkByLogIdSrLevel(HttpSession session,HttpServletResponse response,String logId,String srLevel,Integer page,Integer rows) throws Exception {
    	ServiceRemarkVo serviceRemarkVo = new ServiceRemarkVo();
    	serviceRemarkVo.setLogId(logId);
    	int[] lev = null;
		if (srLevel != null && srLevel.trim().length() > 0) {
			String[] str = srLevel.split(",");
			lev = new int[str.length];
			for (int i = 0; i < str.length; i++) {

				lev[i] = Integer.parseInt(str[i]);
			}
		}
		serviceRemarkVo.setSrLevel(lev);
    	
    	PageRowBounds rowBounds = getPageRowBounds(page, rows);
		
		List<ServiceRemarkVo> list = remarkService.queryServiceRemarkByLogIdSrLevel(serviceRemarkVo, rowBounds);
		
		Integer totalSize = remarkService.queryCountServiceRemarkByLogIdSrLevel(serviceRemarkVo);
		
		FastPage<ServiceRemarkVo> record = new FastPage<ServiceRemarkVo>(list, totalSize, rowBounds);
		JsonUtil.printByJSON(response, record);
	}
	
	/**
     * 
     *@copyright 上善云图信息技术有限公司
     *@author ljh
     *@date 2017-02-13
     *@description 根据logId和srLevel查询好中差评分类的数量
     */
	@ResponseBody
	@RequestMapping("/service/queryCountRemarkLogIdSrLevel")
	public void queryCountRemarkLogIdSrLevel(HttpSession session, HttpServletResponse response, String logId, Integer page,
			Integer rows) throws Exception {

		RemarkCountVo remarkCountVo = new RemarkCountVo();

		remarkCountVo.setLogId(logId);

		List<RemarkCountVo> list = remarkService.queryCountRemarkLogId(remarkCountVo);

		JsonUtil.printByJSON(response, list);
	}
	
	
	/**
     * 
     *@copyright 上善云图信息技术有限公司
     *@author ljh
     *@date 2017-02-13
     *@description 根据服务商的logId查询服务评价的ModelAndView
     */
	@ResponseBody
	@RequestMapping("/service/queryServiceRemarkByLogIdServiceId")
	public void queryServiceRemarkByLogIdServiceId(HttpSession session, HttpServletResponse response,String logId, String srLevel, Integer page,
			Integer rows) throws Exception {
		ServiceRemarkVo serviceRemarkVo = new ServiceRemarkVo();

		int[] lev = null;
		if (srLevel != null && srLevel.trim().length() > 0) {
			String[] str = srLevel.split(",");
			lev = new int[str.length];
			for (int i = 0; i < str.length; i++) {

				lev[i] = Integer.parseInt(str[i]);
			}
		}
		serviceRemarkVo.setLogId(logId);
		serviceRemarkVo.setSrLevel(lev);

		PageRowBounds rowBounds = getPageRowBounds(page, rows);

		List<ServiceRemarkVo> list = remarkService.queryServiceRemarkByLogIdServiceId(serviceRemarkVo, rowBounds);

		Integer totalSize = remarkService.queryCountServiceRemarkByLogIdServiceId(serviceRemarkVo);

		FastPage<ServiceRemarkVo> record = new FastPage<ServiceRemarkVo>(list, totalSize, rowBounds);
		
		JsonUtil.printByJSON(response, record);
	}
	
	/**
     * 
     *@copyright 上善云图信息技术有限公司
     *@author ljh
     *@date 2017-02-13
     *@description 根据服务商的logId查询服务评价的好中差评分类的数量
     */
	@ResponseBody
	@RequestMapping("/service/queryCountRemarkLogIdServiceId")
	public void queryCountRemarkLogIdServiceId(HttpSession session, HttpServletResponse response,String logId, Integer page,Integer rows) throws Exception {

		RemarkCountVo remarkCountVo = new RemarkCountVo();

		remarkCountVo.setLogId(logId);

		List<RemarkCountVo> list = remarkService.queryCountRemarkLogIdServiceId(remarkCountVo);
		
		JsonUtil.printByJSON(response, list);
	}
}