package com.jero.esc.controller.wap.saleinfo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.ConstUtil;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.saleinfo.IOrderInfoBuyerService;
import com.jero.esc.service.saleinfo.IOrderInfoSellerService;
import com.jero.esc.vo.saleinfo.OrderInfo;
import com.jero.esc.vo.saleinfo.OrderService;

@Controller
@RequestMapping(value = "/wap/saleinfo")
public class WapOrderInfoSellerController extends BaseController {
	
	@Autowired
	private IOrderInfoSellerService orderInfoSellerService;
	
	@Autowired
	private IOrderInfoBuyerService orderInfoBuyerService;
	
	@RequestMapping(value="/orderInfoSeller/viewOrder")
	public ModelAndView viewOrder(HttpSession session,OrderInfo orderInfo) throws Exception{
		ModelAndView mv = new ModelAndView();
		orderInfo.setOrderSeller(retrievalCurrentUserInfo(session).getLogId());
		validaLog(session);
		mv.addObject("f", 2);
		mv.setViewName("wap/saleinfo/my_date");
		return mv;
	}
	
	@RequestMapping(value = "/orderInfoSeller/queryOrder")
	public void queryOrder(HttpServletResponse response,HttpSession session,Integer rows,Integer page,OrderInfo orderInfo) throws Exception{
		orderInfo.setOrderSeller(retrievalCurrentUserInfo(session).getLogId());
		Integer total = orderInfoSellerService.queryCount(orderInfo);
		List<OrderInfo> orderList = orderInfoSellerService.queryAllOrderInfo(getPageRowBounds(page, 10), orderInfo);
		validaLog(session);
		printDataGridJsonData(response, total, orderList);
	}
	
	@RequestMapping(value = "/orderInfoSeller/removeOrder")
	@NoRepeatRequest
	public void removeOrder(HttpServletResponse response,OrderInfo order,HttpSession session) throws Exception{
		JsonResult jr = new JsonResult();
		if(order == null){
			jr.setErrorMsg("参数非法");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if(order.getOrderId() == null){
			jr.setErrorMsg("订单编号不能为空");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		validaLog(session);
		jr = orderInfoSellerService.removeOrderById(order);
		JsonUtil.printByJSON(response, jr);
	}
	
	@RequestMapping(value = "/orderInfoSeller/modifyOrderState")
	@NoRepeatRequest
	public void modifyOrderState(HttpServletResponse response,OrderInfo order,HttpSession session) throws Exception{
		JsonResult jr = new JsonResult();
		if(order == null){
			jr.setErrorMsg("参数非法");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		if(order.getOrderId() == null){
			jr.setErrorMsg("订单编号不能为空");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		validaLog(session);
		jr = orderInfoSellerService.modifyOrderState(order);
		JsonUtil.printByJSON(response, jr);
	}
	@RequestMapping(value = "/orderInfoSeller/orderViewDetail")
	public ModelAndView orderViewDetail(HttpServletResponse response,String orderId,HttpSession session) throws Exception{
		OrderInfo order = orderInfoSellerService.selectOrderById(orderId);
		String orderBuyer = order.getOrderBuyer();
		LogInfo logInfo1 = orderInfoSellerService.getLogInfo(orderBuyer);
		validaLog(session);
		ModelAndView mv = new ModelAndView();
		mv.addObject("orderDetail",order);
		mv.addObject("logInfo1",logInfo1);
		mv.setViewName("/wap/saleinfo/orderSellerDetail");
		return mv;
	}
	
	@RequestMapping(value = "/orderInfoSeller/getStateStr")
	public void getStateStr(HttpServletResponse response,Integer orderState,HttpSession session) throws Exception{
			Map<Integer,String> map = ConstUtil.ORDER_STATE_MAP;
			validaLog(session);
			String stateStr = map.get(orderState);
			JsonUtil.printByJSON(response, stateStr);
	}
	
	/**
	 * @description 跳转到卖家确认退款页面
	 * @date 2017年1月10日16:56:33
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/orderInfoSeller/viewExpertConfirm")
	public ModelAndView viewExpertConfirm(@RequestParam(value="orderNo")String orderNo,HttpSession session) throws Exception{
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
		validaLog(session);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orderState",orderState);
		modelAndView.addObject("orderInfo",orderInfo);
		modelAndView.setViewName("/wap/saleinfo/expertconfirm");
		return modelAndView;
	}
	
	/**
	 * @description 专家退款确认
	 * @date 2017年1月11日14:12:10
	 * @param json
	 * @return String
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/orderInfoSeller/refundConfirm")
	@NoRepeatRequest
	public String refundConfirm(String json,HttpSession session) throws Exception{
		if (isValidate) {
            if (FastValid.isEmp(json))
                throw new ExceptionWithMessage("参数错误");
        }
		validaLog(session);
		Integer res = orderInfoSellerService.modifyRefundMsgByOrderNo(json);
		String url = "";
		if(res>0){
			url = "{\"url\":\"/wap/saleinfo/orderInfoSeller/viewOrder.html\"}";
		}
		refresh(session);
		return url;
	}
}
