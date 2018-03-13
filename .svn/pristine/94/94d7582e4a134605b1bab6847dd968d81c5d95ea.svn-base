package com.jero.esc.controller.appapi.bizinfo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.bizinfo.RecommendPtop;
import com.jero.esc.service.bizinfo.IRecommendPtopService;

@Controller("apiRecommendPtopController")
@RequestMapping("/appapi/bizinfo")
public class RecommendPtopController extends AppBaseController{
	@Autowired
	private IRecommendPtopService recommendPtopService;
	
	
	
	
	/**
	 * 查询我的推荐
	 * @param page 分页页数
	 * @param pageSize 每页条数
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recommendptop/myRecommend",method = RequestMethod.POST)
    public Object myRecommend(Integer page,Integer pageSize) throws Exception{
    	if (FastValid.isEmp(page,pageSize)){
            page=1;
            pageSize=5;
        }
    	String logId=logId();
    	RecommendPtop record =new RecommendPtop();
    	record.setRptpPresenter(logId);
    	PageRowBounds pageRowBounds = getPageRowBounds(page,pageSize);
    	return  AppJsonResult.success(recommendPtopService.queryByPresenter(logId,pageRowBounds));
    }

	 
	 
	 
}
