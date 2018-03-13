package com.jero.esc.controller.goodsinfo;

import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.po.goodsinfo.ServiceRemark;
import com.jero.esc.po.saleinfo.OrderService;
import com.jero.esc.service.goodsinfo.IRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by blazh on 2016/12/29.
 */
@Controller
@RequestMapping("/goodsinfo")
public class RemarkController extends BaseController{

    @Autowired
    private IRemarkService remarkService;


    /**
     * 是否可以评论
     * @param httpSession
     * @param id
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/remark/canRemark",produces="text/html;charset=UTF-8")
    public  String canRemark(HttpSession httpSession,@RequestParam("id")String id,Integer type){
        
        return  null;
    }


    /**
     * 显示订单与评价
     * @param session
     * @param id
     * @return
     */
    @RequestMapping("/remark/viewRemark")
    public ModelAndView viewRemark(HttpSession session, @RequestParam("id")String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsinfo/remark");
        OrderService orderServiceWithRemark=null;
        try {
            OrderService orderService = new OrderService();
            orderService.setOsId(id);
            orderService.setBox(retrievalCurrentUserInfo(session).getLogId());
            orderServiceWithRemark = remarkService.getOrderServiceWithRemark(orderService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("log",retrievalCurrentUserInfo(session).getLogId());
        modelAndView.addObject("obj",orderServiceWithRemark);
        return  modelAndView;
    }


    /**
     * @param session
     * @param content
     * @param id
     * @param star
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/remark/add",produces="text/html;charset=UTF-8")
    @NoRepeatRequest
    public String add(HttpSession session,@RequestParam("content")String content,@RequestParam("id")String id,@RequestParam(value = "star",required = false)Integer star,@RequestParam(value = "level",required = false)Integer level){



        ServiceRemark serviceRemark = new ServiceRemark();
        serviceRemark.setBox(content);
        serviceRemark.setLogId(retrievalCurrentUserInfo(session).getLogId());
        serviceRemark.setSrOrder(id);
        serviceRemark.setSrRemark((float)level);
        serviceRemark.setSrLevel(level);

        if (HtmlFilter.filter(serviceRemark)){
            return  new JsonResult("不能使用html").toJSON();
        }

        try {
            remarkService.addRemark(serviceRemark);
        }catch (Exception e) {
        	e.printStackTrace();
            return ExceptionWithMessage.toJson(e);
        }
        return new JsonResult(true).toJSON();
    }

}