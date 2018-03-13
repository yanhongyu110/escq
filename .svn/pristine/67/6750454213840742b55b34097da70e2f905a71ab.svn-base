package com.jero.esc.controller.wap.goodsinfo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.po.goodsinfo.ServiceRemark;
import com.jero.esc.po.saleinfo.OrderService;
import com.jero.esc.service.goodsinfo.IRemarkService;
import com.jero.esc.service.saleinfo.IOrderInfoBuyerService;
import com.jero.esc.vo.goodsinfo.RemarkCountVo;
import com.jero.esc.vo.saleinfo.OrderInfo;

/**
 * @copyright 
 * @author luoshunqiao
 * @version 
 * @date 2017年6月12日 
 * @description
 */
@Controller
@RequestMapping("/wap/goodsinfo")
public class WapServiceRemarkController extends BaseController {
	
	@Autowired
	private IRemarkService remarkService;
	
	@Autowired
	private IOrderInfoBuyerService orderInfoBuyerService;
	
	/**
	 * @description  跳转到订单评价页面
	 * @date 2017年6月12日  
	 * @Return ModelAndView
	 */
	@RequestMapping("/serviceRemake/remakeEstimate")
	public ModelAndView view(HttpSession session, @RequestParam("id")String id){
		ModelAndView model = new ModelAndView("/wap/goodsinfo/remark");
		/*orderNo="17051914460001";
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		//获取评价统计
		RemarkCountVo remarkCountVo = new RemarkCountVo();
		remarkCountVo.setServiceId(orderInfo.getOrderService().get(0).getServiceInfo().getServiceId());
		List<RemarkCountVo> list = null;
		try {
			list = remarkService.queryCountRemark(remarkCountVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("orderInfo", orderInfo);
		model.addObject("remarkCount", list.get(0));
		model.addObject("servicePic", orderInfo.getOrderService().get(0).getServiceInfo().getServicePic());*/
        OrderService orderServiceWithRemark=null;
        try {
            OrderService orderService = new OrderService();
            orderService.setOsId(id);
            orderService.setBox(retrievalCurrentUserInfo(session).getLogId());
            orderServiceWithRemark = remarkService.getOrderServiceWithRemark(orderService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addObject("log",retrievalCurrentUserInfo(session).getLogId());
        model.addObject("obj",orderServiceWithRemark);
		return model;
	}

	@ResponseBody
	@RequestMapping("/serviceRemake/addRemake")
	public JsonResult addOrderRemake(HttpSession session,ServiceRemark remark,@RequestParam("content")String content,@RequestParam("id")String id,@RequestParam(value = "star",required = false)Integer star,@RequestParam(value = "level",required = false)Integer level){
		JsonResult jr = new JsonResult();
		ServiceRemark serviceRemark = new ServiceRemark();
        serviceRemark.setBox(content);
        serviceRemark.setSrContent(content);
        serviceRemark.setLogId(retrievalCurrentUserInfo(session).getLogId());
        serviceRemark.setSrOrder(id);
        if (level != null){
			serviceRemark.setSrRemark((float)level);
		}
        serviceRemark.setSrLevel(level);
		try {
			if (remarkService.addRemark(serviceRemark)) {
				jr.setSuccess(true);
				jr.setErrorMsg("评价成功");
			}
		} catch (ExceptionWithMessage e) {
			jr = e.jsonResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jr;
	}
}
