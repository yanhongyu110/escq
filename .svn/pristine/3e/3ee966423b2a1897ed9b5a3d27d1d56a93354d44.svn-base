package com.jero.esc.controller.details;

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
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.po.details.PointPaymentDetails;
import com.jero.esc.service.details.IPointPaymentDetailsService;

@Controller
@RequestMapping(value="/details")
public class PointPaymentDetailsController extends BaseController{
	
	@Autowired
	private IPointPaymentDetailsService pointPaymentDetailsService;
	
	@RequestMapping(value="/PointPaymentDetails/showPointIODetails")
	public ModelAndView showPointIODetails(HttpSession session,Integer page,String startTime,String endTime){
		if(page==null){
			page = 1;
		}
		Integer pageSize = 10;
		RowBounds rb = this.getRowBounds(page, pageSize);
		String logId = this.retrievalCurrentUserInfo(session).getLogId();
		HashMap<String, Object> map = pointPaymentDetailsService.queryPointIODetailsById(rb, logId, startTime, endTime);
		Object ppdList = map.get("ppdList");
		Object accList = map.get("accList");
		Integer count = pointPaymentDetailsService.queryPointIODetailsCountById(logId, startTime, endTime);
		String jsonList = JSON.toJSONString(ppdList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("details/pointPaymentDetails");
		modelAndView.addObject("jsonList", jsonList);
		modelAndView.addObject("accList", accList);
		modelAndView.addObject("count", count);
		return modelAndView; 
	}
	
	@RequestMapping(value="/PointPaymentDetails/showPointIODetailsByAjax")
	public void showPointIODetailsByAjax(HttpSession session,HttpServletResponse response, Integer page,String flag,String startTime,String endTime){
	    if(page==null){
	    	page=1;
	    }
	    if("".equals(startTime)){
	    	startTime = null;
	    }else if("".equals(endTime)){
	    	endTime = null;
	    }
		Integer pageSize = 10;
		RowBounds rb = this.getRowBounds(page, pageSize);
		String logId = this.retrievalCurrentUserInfo(session).getLogId();
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(flag.equals("a")){
			List<PointPaymentDetails> ppdList = pointPaymentDetailsService.queryPointIOByIdYear(rb, logId, startTime, endTime);
			Integer count = pointPaymentDetailsService.queryPointIOCountByIdYear(logId, startTime, endTime);
			map.put("ppdList", ppdList);
			map.put("count", count);
			map.put("pageNo", page);
			map.put("flag", flag);
		}else if(flag.equals("b")){
			List<PointPaymentDetails> ppdList = pointPaymentDetailsService.queryPointIOByIdMonth(rb, logId, startTime, endTime);
			Integer count = pointPaymentDetailsService.queryPointIOCountByIdMonth(logId, startTime, endTime);
			map.put("ppdList", ppdList);
			map.put("count", count);
			map.put("pageNo", page);
			map.put("flag", flag);
		}else if(flag.equals("c")){
			List<PointPaymentDetails> ppdList = pointPaymentDetailsService.queryPointIOByIdDay(rb, logId, startTime, endTime);
			Integer count = pointPaymentDetailsService.queryPointIOCountByIdDay(logId, startTime, endTime);
			map.put("ppdList", ppdList);
			map.put("count", count);
			map.put("pageNo", page);
			map.put("flag", flag);
		}else if(flag.equals("d")){
			HashMap<String, Object> mmap = pointPaymentDetailsService.queryPointIODetailsById(rb, logId,startTime,endTime);
			Object ppdList = mmap.get("ppdList");
			Integer count = pointPaymentDetailsService.queryPointIODetailsCountById(logId,startTime,endTime);
			map.put("ppdList", ppdList);
			map.put("count", count);
			map.put("pageNo", page);
			map.put("flag", flag);
		}
		JsonUtil.printByJSON(response, map);
	}
}
