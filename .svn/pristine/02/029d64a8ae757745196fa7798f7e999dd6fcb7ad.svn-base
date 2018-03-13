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
import com.jero.esc.po.details.PointPaymentDetails;
import com.jero.esc.service.details.IPointPaymentDetailsService;
import com.jero.esc.service.userinfo.IAccountInfoService;

@Controller("apiPointPaymentDetailsController")
@RequestMapping("/appapi/details")
public class PointPaymentDetailsController extends AppBaseController {

    @Autowired
    private IPointPaymentDetailsService pointPaymentDetailsService;
    @Autowired
    private IAccountInfoService accountInfoService;

    /**
     * 获取账户信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/PointPaymentDetails/getAccountInfo")
    public Object getAccountInfo() {
        String logId = logId();
        accountInfoService.queryBalanceById(logId);
        return AppJsonResult.success(accountInfoService.queryBalanceById(logId));
    }

    /**
     * 获取支付明细
     * @param page 分页页数
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/PointPaymentDetails/showIOPointDetails")
    public Object showIOPointDetails(Integer page, String startTime, String endTime) {
        if (page == null) {
            page = 1;
        }
        if ("".equals(startTime)) {
            startTime = null;
        } else if ("".equals(endTime)) {
            endTime = null;
        }
        Integer pageSize = 10;
        PageRowBounds rb = this.getPageRowBounds(page, pageSize);
        String logId = logId();
        HashMap<String, Object> map = pointPaymentDetailsService.queryPointIODetailsById(rb, logId, startTime, endTime);
        List<PointPaymentDetails> acDetailsList = (List<PointPaymentDetails>) map.get("apdList");
        Integer count = pointPaymentDetailsService.queryPointIODetailsCountById(logId, startTime, endTime);
        FastPage<PointPaymentDetails> fastPage = new FastPage<>(acDetailsList, count, page, pageSize);
        return AppJsonResult.success(fastPage);
    }


    /**
     *
     * @param page 分页页数
     * @param flag 标识
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/PointPaymentDetails/showPointIODetailsByAjax")
    public AppJsonResult showPointIODetailsByAjax(Integer page,String flag,String startTime,String endTime){
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
        FastPage<PointPaymentDetails> fastPage=null;
        if(flag.equals("a")){
            List<PointPaymentDetails> ppdList = pointPaymentDetailsService.queryPointIOByIdYear(rb, logId, startTime, endTime);
            Integer count = pointPaymentDetailsService.queryPointIOCountByIdYear(logId, startTime, endTime);
            fastPage=new FastPage<PointPaymentDetails>(ppdList,count,page,pageSize);
            map.put("pager",fastPage);
            map.put("flag", flag);
        }else if(flag.equals("b")){
            List<PointPaymentDetails> ppdList = pointPaymentDetailsService.queryPointIOByIdMonth(rb, logId, startTime, endTime);
            Integer count = pointPaymentDetailsService.queryPointIOCountByIdMonth(logId, startTime, endTime);
            fastPage=new FastPage<PointPaymentDetails>(ppdList,count,page,pageSize);
            map.put("pager",fastPage);
            map.put("flag", flag);
        }else if(flag.equals("c")){
            List<PointPaymentDetails> ppdList = pointPaymentDetailsService.queryPointIOByIdDay(rb, logId, startTime, endTime);
            Integer count = pointPaymentDetailsService.queryPointIOCountByIdDay(logId, startTime, endTime);
            fastPage=new FastPage<PointPaymentDetails>(ppdList,count,page,pageSize);
            map.put("pager",fastPage);
            map.put("flag", flag);
        }else if(flag.equals("d")){
            HashMap<String, Object> mmap = pointPaymentDetailsService.queryPointIODetailsById(rb, logId,startTime,endTime);
            List<PointPaymentDetails> ppdList = (List<PointPaymentDetails>) mmap.get("ppdList");
            Integer count = pointPaymentDetailsService.queryPointIODetailsCountById(logId,startTime,endTime);
            fastPage=new FastPage<PointPaymentDetails>(ppdList,count,page,pageSize);
            map.put("pager",fastPage);
            map.put("flag", flag);
        }
        return AppJsonResult.success(map);
    }







}
