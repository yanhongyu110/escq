package com.jero.esc.controller.userinfo;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.po.userinfo.ServiceInfo;
import com.jero.esc.service.bizinfo.IRecommendPtopService;
import com.jero.esc.service.userinfo.IProviderDetailsService;
import com.jero.esc.vo.bizinfo.RecommendProvider;

@Controller
@RequestMapping(value="/userinfo")
public class ProviderDetailsController extends BaseController {
	
	@Autowired
	IProviderDetailsService providerDetailsService;
	@Autowired
	IRecommendPtopService recommendPtopService;


//	@Cacheable(value = "comSearchChae",key = "'providerdetails'+#logId")
//	@CachePut(value = "comSearchChae",key = "'providerdetails'+#logId")
	@RequestMapping("/providerdetails/preproviderdetails")
	public ModelAndView preProvider(HttpSession session,@RequestParam("logId") String logId){
		LogInfo logInfo = new LogInfo();
		logInfo.setLogId(logId);
		ProviderInfo info = providerDetailsService.queryProviderDetailsById(logInfo,null);


//		setCompanyId(session,info.getTypeTree().contains(",")?info.getTypeTree().substring(0,info.getTypeTree().indexOf(",")):info.getTypeTree());



		RowBounds rowBounds = getRowBounds(1, 6);
		List<ServiceInfo> list = providerDetailsService.queryServiceInfoByCon(logInfo, rowBounds);
		info.setServiceInfos(list);
		//推荐专家显示
		PageRowBounds pageRowBounds = getPageRowBounds(1,4);
		FastPage<RecommendProvider> recommendProviders=null;
		try {
			 recommendProviders=recommendPtopService.queryByPresenter(logInfo.getLogId(), pageRowBounds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/userinfo/providerdetails");
		System.out.println(JSONObject.toJSONString(info.getServiceInfos()));
		modelAndView.addObject("providers",recommendProviders);
		modelAndView.addObject("info", info);
		return modelAndView;
	}
	
	@RequestMapping("/providerdetails/ajaxpaging")
	public void AjaxPaging(HttpSession session,HttpServletResponse response ,@RequestParam("logId") String logId,Integer page){
		if (FastValid.isEmp(page)){
            page=2;
        }
		RowBounds rowBounds = getRowBounds(page, 6);
		LogInfo logInfo = new LogInfo();
		logInfo.setLogId(logId);
		List<ServiceInfo> list = providerDetailsService.queryServiceInfoByCon(logInfo, rowBounds);
		JsonUtil.printByJSON(response, list);
	}

}
