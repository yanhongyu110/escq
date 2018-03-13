package com.jero.esc.controller.bizinfo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.bizinfo.FocusUtop;
import com.jero.esc.po.bizinfo.RecommendPtop;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.bizinfo.IFocusUtopService;
import com.jero.esc.service.bizinfo.IRecommendPtopService;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;
import com.jero.esc.vo.bizinfo.RecommendProvider;

@Controller
@RequestMapping("/bizinfo")
public class RecommendPtopController extends BaseController{
	@Autowired
	private IRecommendPtopService recommendPtopService;
	
	
	
	
	/**
	 * 查询我的关注
	 * @param session
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recommendptop/myRecommend")
    public ModelAndView myRecommend(HttpSession session,Integer page,Integer pageSize) throws Exception{
    	if (FastValid.isEmp(page,pageSize)){
            page=1;
            pageSize=5;
        }
    	LogInfo info=retrievalCurrentUserInfo(session);
    	RecommendPtop record =new RecommendPtop();
    	record.setRptpPresenter(info.getLogId());
    	PageRowBounds pageRowBounds = getPageRowBounds(page,pageSize);
    	FastPage<RecommendProvider> psage= recommendPtopService.queryByPresenter(info.getLogId(),pageRowBounds);
    	
    	ModelAndView modelAndView = new ModelAndView();
    	
    		modelAndView.setViewName("bizinfo/myrecommend");
            modelAndView.addObject("infos",psage);	
        return  modelAndView;
    }

	 
	 
	 
}
