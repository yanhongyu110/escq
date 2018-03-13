package com.jero.esc.controller.appapi.goodsinfo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.po.goodsinfo.ServiceRemark;
import com.jero.esc.po.saleinfo.OrderService;
import com.jero.esc.service.goodsinfo.IRemarkService;

/**
 * Created by blazh on 2016/12/29.
 */
@Controller("apiRemarkController")
@RequestMapping("/appapi/goodsinfo")
public class RemarkController extends AppBaseController{

    @Autowired
    private IRemarkService remarkService;

    /**
     * 显示订单与评价
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/remark/viewRemark",method = RequestMethod.POST)
    public Object viewRemark(String id) throws Exception {
        OrderService orderServiceWithRemark=null;
        String logId=logId();
        try {
            OrderService orderService = new OrderService();
            orderService.setOsId(id);
            orderService.setBox(logId);
            orderServiceWithRemark = remarkService.getOrderServiceWithRemark(orderService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  AppJsonResult.success(orderServiceWithRemark);
    }


    /**
     *
     * 添加评价
     * @param content 评价内容
     * @param id 评价的orderid
     * @param star 评价的星星数
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/remark/addRemark",method = RequestMethod.POST)
    @NoRepeatRequest
    public Object addRemark(String content,String id,Integer star,Integer level){
        ServiceRemark serviceRemark = new ServiceRemark();
        String logId=logId();
        serviceRemark.setBox(content);
        serviceRemark.setLogId(logId);
        serviceRemark.setSrOrder(id);
        serviceRemark.setSrRemark(star!=null?(float)star:null);
        serviceRemark.setSrLevel(level);

        if (HtmlFilter.filter(serviceRemark)){
            return  AppJsonResult.formJsonResult(new JsonResult("不能使用html"));
        }

        try {
            remarkService.addRemark(serviceRemark);
        }catch (Exception e) {
        	e.printStackTrace();
            return AppJsonResult.error(e.getMessage());
        }
        return AppJsonResult.formJsonResult(new JsonResult(true));
    }

}