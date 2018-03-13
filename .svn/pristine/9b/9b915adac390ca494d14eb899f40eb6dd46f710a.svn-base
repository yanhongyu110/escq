package com.jero.esc.controller.appapi.details;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.po.details.AccontPaymentDetails;
import com.jero.esc.service.details.IAccountPaymentDetailsService;
import com.jero.esc.service.userinfo.IAccountInfoService;
@Controller("apiAccountPaymentDetailsController")
@RequestMapping(value="/appapi/details")
public class AccountPaymentDetailsController extends AppBaseController{
	@Autowired
	private IAccountPaymentDetailsService accountPaymentDetailsService;
	@Autowired
	private IAccountInfoService accountInfoService;

    /**
     * 获取账户信息
     * @return
     */
	@ResponseBody
	@RequestMapping(value="/AccountPaymentDetails/getAccountInfo")
	public Object getAccountInfo(){
		String logId=logId();
		accountInfoService.queryBalanceById(logId);
		return AppJsonResult.success(accountInfoService.queryBalanceById(logId).get(0));
	}


    /**
     *  获取支付明细
     * @param page 分页页数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
	@ResponseBody
	@RequestMapping(value="/AccountPaymentDetails/getIODetails")
	public Object getIODetails(Integer page,String startTime,String endTime){
		if(page==null){
			page = 1;
		}
		if("".equals(startTime)){
	    	startTime = null;
	    }else if("".equals(endTime)){
	    	endTime = null;
	    }
		Integer pageSize = 10;
		PageRowBounds rb = this.getPageRowBounds(page, pageSize);
		String logId = logId();
		HashMap<String, Object> map = accountPaymentDetailsService.queryAccountIODetailsById(rb, logId,startTime,endTime);
		List<AccontPaymentDetails> acDetailsList = (List<AccontPaymentDetails>) map.get("apdList");
		Object accList = map.get("accList");
		Integer count = accountPaymentDetailsService.queryAccountIODetailsCountById(logId,startTime,endTime);
		FastPage<AccontPaymentDetails> fastPage=new FastPage<>(acDetailsList, count,page,pageSize);
		return AppJsonResult.success(fastPage); 
	}


    /**
     * 查看账户信息列表
     * @param page
     * @param flag
     * @param startTime
     * @param endTime
     * @return
     */
	@ResponseBody
    @RequestMapping(value="/AccountPaymentDetails/showIODetailsByAjax")
    public AppJsonResult showIODetailsByAjax(Integer page,String flag,String startTime,String endTime){
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
        String logId = logId();
        HashMap<String, Object> map = new HashMap<String, Object>();
        FastPage<AccontPaymentDetails> fastPage=null;
        if(flag.equals("a")){
            List<AccontPaymentDetails> acDetailsList = accountPaymentDetailsService.queryAccountIOByIdYear(rb, logId, startTime, endTime);
            Integer count = accountPaymentDetailsService.queryAccountIOCountByIdYear(logId, startTime, endTime);
            fastPage=new FastPage<AccontPaymentDetails>(acDetailsList,count,page,pageSize);
            map.put("pager",fastPage);
            map.put("flag", flag);
        }else if(flag.equals("b")){
            List<AccontPaymentDetails> acDetailsList = accountPaymentDetailsService.queryAccountIOByIdMonth(rb, logId, startTime, endTime);
            Integer count = accountPaymentDetailsService.queryAccountIOCountByIdMonth(logId, startTime, endTime);
            map.put("pager",fastPage);
            map.put("flag", flag);
        }else if(flag.equals("c")){
            List<AccontPaymentDetails> acDetailsList = accountPaymentDetailsService.queryAccountIOByIdDay(rb, logId, startTime, endTime);
            Integer count = accountPaymentDetailsService.queryAccountIOCountByIdDay(logId, startTime, endTime);
            map.put("pager",fastPage);
            map.put("flag", flag);
        }else if(flag.equals("d")){
            HashMap<String, Object> mmap = accountPaymentDetailsService.queryAccountIODetailsById(rb, logId,startTime,endTime);
            Object acDetailsList = mmap.get("apdList");
            Integer count = accountPaymentDetailsService.queryAccountIODetailsCountById(logId,startTime,endTime);
            map.put("pager",fastPage);
            map.put("flag", flag);
        }
        return AppJsonResult.success(map);
    }




//	@ResponseBody
//	@RequestMapping(value="/AccountPaymentDetails/getIODetailsByYear")
//	public Object getIODetailsByYear(Integer page,String flag,String startTime,String endTime){
//		if(page==null){
//	    	page=1;
//	    }
//	    if("".equals(startTime)){
//	    	startTime = null;
//	    }else if("".equals(endTime)){
//	    	endTime = null;
//	    }
//	    Integer pageSize = 10;
//		PageRowBounds rb = this.getPageRowBounds(page, pageSize);
//		String logId = logId();
//		List<AccontPaymentDetails> acDetailsList = accountPaymentDetailsService.queryAccountIOByIdYear(rb, logId, startTime, endTime);
//		Integer count = accountPaymentDetailsService.queryAccountIOCountByIdYear(logId, startTime, endTime);
//		FastPage<AccontPaymentDetails> fastPage = null;
//		try {
//			fastPage = new FastPage<>(acDetailsList, count, rb);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			return AppJsonResult.success(fastPage);
//	}
//	@ResponseBody
//	@RequestMapping(value="/AccountPaymentDetails/getIODetailsByMonth")
//	public Object getIODetailsByMonth(Integer page,String flag,String startTime,String endTime){
//		if(page==null){
//	    	page=1;
//	    }
//	    if("".equals(startTime)){
//	    	startTime = null;
//	    }else if("".equals(endTime)){
//	    	endTime = null;
//	    }
//	    Integer pageSize = 10;
//		PageRowBounds rb = this.getPageRowBounds(page, pageSize);
//		String logId = logId();
//		List<AccontPaymentDetails> acDetailsList = accountPaymentDetailsService.queryAccountIOByIdMonth(rb, logId, startTime, endTime);
//		Integer count = accountPaymentDetailsService.queryAccountIOCountByIdMonth(logId, startTime, endTime);
//		FastPage<AccontPaymentDetails> fastPage = null;
//		try {
//			fastPage = new FastPage<>(acDetailsList, count, rb);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			return AppJsonResult.success(fastPage);
//	}
//	@ResponseBody
//	@RequestMapping(value="/AccountPaymentDetails/getIODetailsByDay")
//	public Object getIODetailsByDay(Integer page,String flag,String startTime,String endTime){
//		if(page==null){
//	    	page=1;
//	    }
//	    if("".equals(startTime)){
//	    	startTime = null;
//	    }else if("".equals(endTime)){
//	    	endTime = null;
//	    }
//	    Integer pageSize = 10;
//		PageRowBounds rb = this.getPageRowBounds(page, pageSize);
//		String logId = logId();
//		List<AccontPaymentDetails> acDetailsList = accountPaymentDetailsService.queryAccountIOByIdDay(rb, logId, startTime, endTime);
//		Integer count = accountPaymentDetailsService.queryAccountIOCountByIdDay(logId, startTime, endTime);
//		FastPage<AccontPaymentDetails> fastPage = null;
//		try {
//			fastPage = new FastPage<>(acDetailsList, count, rb);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			return AppJsonResult.success(fastPage);
//	}
	
}
