package com.jero.esc.controller.appapi.userinfo;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("appProviderDetailsController")
@RequestMapping(value="/appapi/userinfo")
public class ProviderDetailsController extends AppBaseController {

	
	@Autowired
	IProviderDetailsService providerDetailsService;
	@Autowired
	IRecommendPtopService recommendPtopService;



	/**
	 * 获取推荐
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/providerdetails/tui")
	public  AppJsonResult tui(){
		try {
			//推荐专家显示
			PageRowBounds pageRowBounds = getPageRowBounds(1,4);
			FastPage<RecommendProvider> recommendProviders=null;
			recommendProviders=recommendPtopService.queryByPresenter(logId(), pageRowBounds);
			return  AppJsonResult.success(recommendProviders);
		} catch (Exception e) {
			e.printStackTrace();
			return  AppJsonResult.error("失败");
		}
	}


	/**
	 * 显示服务商详情
	 * @param logId 服务商id
	 * @return
	 */
	@Cacheable(value = "comSearchChae",key = "'appproviderdetails'+#logId")
	@CachePut(value = "comSearchChae",key = "'appproviderdetails'+#logId")
	@ResponseBody
	@RequestMapping(value="/providerdetails/preproviderdetails",method = RequestMethod.POST)
	public AppJsonResult preProvider(String logId){
		LogInfo logInfo = new LogInfo();
		logInfo.setLogId(logId);
		ProviderInfo info = providerDetailsService.queryProviderDetailsById(logInfo,null);
		int count = providerDetailsService.countServiceInfoByCon(logInfo);
		info.setPiCount(count);
		return AppJsonResult.success(info);
	}

	/**
	 * 查询服务商详情列表
	 * @param logId 服务商id
	 * @param page 分页页数
	 * @param pageSize 分页大小
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/providerdetails/ajaxpaging",method = RequestMethod.POST)
	public  AppJsonResult AjaxPaging( String logId,Integer page,Integer pageSize){
		if (FastValid.isEmp(page,pageSize)){
            page=1;
			pageSize=6;
		}
		RowBounds rowBounds = getRowBounds(page, pageSize);
		LogInfo logInfo = new LogInfo();
		logInfo.setLogId(logId);
		List<ServiceInfo> list = providerDetailsService.queryServiceInfoByCon(logInfo, rowBounds);
		return  AppJsonResult.success(list);
	}


}
