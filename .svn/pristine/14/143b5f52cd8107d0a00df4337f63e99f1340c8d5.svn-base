package com.jero.esc.controller.appapi.userinfo;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.po.userinfo.ProviderRecommend;
import com.jero.esc.service.userinfo.IProviderRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller("appProviderRecommendController")
@RequestMapping(value = "/appapi/userinfo")
public class ProviderRecommendController extends AppBaseController {

	@Autowired
	private IProviderRecommendService providerRecommendService;


	/**
	 * 查询自己的推荐信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/providerRecommend/jumpProviderRecommend",method = RequestMethod.GET)
	public AppJsonResult providerRecommend() {
		ProviderRecommend pr = providerRecommendService.queryByLogId(logId());
		return  AppJsonResult.success(pr);
	}

	/**
	 * 添加推荐信息
	 * @param record 推荐信息json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/providerRecommend/addProviderRecommend",method = RequestMethod.POST)
	public AppJsonResult addProviderRecommend(ProviderRecommend record){
		if(HtmlFilter.filter(record)) return  AppJsonResult.error("输入内容不能为HTML代码！！！");
		if (record == null) return  AppJsonResult.error("信息为空");
		if (record.getPrDetails().length() > 200) return  AppJsonResult.error("个人说明需要在200字以内");
		record.setLogId(logId());
		record.setPrSort(99);
		if (providerRecommendService.addProviderRecommend(record)> 0) return  AppJsonResult.success("申请提交成功！");
		else return  AppJsonResult.error("失败");
	}


	/**
	 *修改推荐信息
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/providerRecommend/modifyStateByLogId",method = RequestMethod.POST)
	public AppJsonResult modifyStateByLogId(ProviderRecommend record)  {
		if(HtmlFilter.filter(record))return  AppJsonResult.error("输入内容不能为HTML代码！！！");
		if (providerRecommendService.removeProviderRecommend(logId())<= 0) {
			return  AppJsonResult.error("修改失败");
		}
		return  AppJsonResult.success("成功");
	}

}