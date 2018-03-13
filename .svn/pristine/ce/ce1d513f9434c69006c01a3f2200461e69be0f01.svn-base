package com.jero.esc.controller.saleinfo;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.ConstUtil;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.userinfo.AccountInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.saleinfo.IOrderInfoBuyerService;
import com.jero.esc.vo.saleinfo.OrderInfo;

@Controller
@RequestMapping("/saleinfo")
public class OrderInfoBuyerController extends BaseController {
	
	@Autowired
	private IOrderInfoBuyerService orderInfoBuyerService;
	/**
	 * @throws Exception 
	 * @description  跳转到订单查询页面
	 * @date 2016年12月26日下午7:36:09 
	 * @Return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/orderView")
	public ModelAndView orderView(HttpSession session) throws Exception{
		validaLog(session);
		return new ModelAndView("/saleinfo/oderInfoBuyer");
	}
	
	/**
	 * 查询订单
	 * @param orderService
	 * @param page
	 * @param rows
	 * @throws Exception 
	 */
	@RequestMapping("/orderInfoBuyer/getAllOrder")
	public void getAllOrder(HttpServletResponse response,HttpSession session,OrderInfo orderInfo,Integer page, Integer rows) throws Exception{
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		orderInfo.setOrderBuyer(logInfo.getLogId());
		validaLog(session);
		refresh(session);
		rows = 5;
		Integer totalNum = orderInfoBuyerService.totalNum(orderInfo);
		int no = (int) Math.ceil((double)totalNum/rows);
		if(page>no){
			page = page - 1;
		}
		List<OrderInfo> orderList = orderInfoBuyerService.selectAll(getPageRowBounds(page,rows), orderInfo);
		printDataGridJsonData(response,totalNum,orderList);
		
	}
	/**
	 * @throws Exception 
	 * @description 跳转支付页面
	 * @date 2016年12月26日上午11:07:21 
	 * @Parm session
	 * @Return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/getAccount")
	public ModelAndView getAccount(HttpSession session,@RequestParam(value="orderId",required=false)String id) throws Exception{
		ModelAndView mv = new ModelAndView();
		String logId = retrievalCurrentUserInfo(session).getLogId();
		validaLog(session);
		AccountInfo selectBalanceById = orderInfoBuyerService.selectBalanceById(logId);
		OrderInfo orderInfo = orderInfoBuyerService.selectById(id);
		mv.addObject("selectBalanceById", selectBalanceById);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("/saleinfo/mony_tg");
		return mv;
	}
	
	@RequestMapping("/orderInfoBuyer/shez")
	public void shez(HttpSession session,HttpServletResponse response) throws Exception{
		JsonResult jr = new JsonResult();
		String logId = retrievalCurrentUserInfo(session).getLogId();
		Boolean pass = orderInfoBuyerService.selectPass(logId);
		validaLog(session);
		if(!pass){
			jr.setSuccess(false);
			jr.setErrorMsg("请设置支付密码");
			JsonUtil.printByJSON(response, jr);
			return;
		} else {
			jr.setSuccess(true);
			JsonUtil.printByJSON(response, jr);
		}
	}
	
	/**
	 * @throws Exception 
	 * @description 付款
	 * @date 2016年12月26日上午11:30:13 
	 * @Parm accountInfo
	 * @Parm response
	 * @Return void
	 */
	@RequestMapping("/orderInfoBuyer/validate")
	@NoRepeatRequest
	public void validate(@RequestParam(value="flag",required=false)Integer flag,
			@RequestParam(value="orderPrice",required=false)String orderPrice,
			@RequestParam(value="orderNo",required=false)String orderNo, 
			@RequestParam(value="serviceTitle",required=false)String serviceTitle,
			AccountInfo accountInfo,HttpServletResponse response,HttpSession session) throws Exception{
		JsonResult jr = new JsonResult();
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		accountInfo.setLogId(logInfo.getLogId());
		String accPaypass = accountInfo.getAccPaypass();
		if(accPaypass == null && "".equals(accPaypass)){
			jr.setSuccess(false);
			jr.setErrorMsg("支付密码不能为空");
			JsonUtil.printByJSON(response, jr);
			return;
		}
		validaLog(session);
		try {
			jr = orderInfoBuyerService.validate(accountInfo, orderPrice, orderNo,flag,serviceTitle);
		} catch (ExceptionWithMessage e) {
			e.printStackTrace();
			jr =e.jsonResult;
		}
		refresh(session);
		JsonUtil.printByJSON(response, jr);
	}
	
	/**
	 * @throws Exception 
	 * @description 根据订单编号删除订单
	 * @date 2016年12月27日下午1:46:14 
	 * @Parm orderInfo
	 * @Parm response
	 * @Return void
	 */
	@RequestMapping("/orderInfoBuyer/del")
	@NoRepeatRequest
	public void del(OrderInfo orderInfo,HttpServletResponse response,HttpSession session) throws Exception{
		JsonResult jr = new JsonResult();
		String orderNo = orderInfo.getOrderNo();
		validaLog(session);
		try {
			jr = orderInfoBuyerService.delete(orderNo);
		} catch (ExceptionWithMessage e) {
			e.printStackTrace();
			jr =e.jsonResult;
		}
		JsonUtil.printByJSON(response, jr);
	}
	
	/**
	 * @description  订单详情
	 * @date 2017年1月9日上午9:48:18 
	 * @param orderId
	 * @throws Exception 
	 * @Return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/details")
	public ModelAndView details(HttpSession session,@RequestParam(value="orderId",required=false)String orderId) throws Exception{
		ModelAndView mv = new ModelAndView();
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderId);
		String orderSeller = orderInfo.getOrderSeller();
		LogInfo logInfo1 = orderInfoBuyerService.getLogInfo(orderSeller);
		validaLog(session);
		mv.addObject("logInfo1", logInfo1);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("/saleinfo/dd_xq");
		return mv;
	}
	
	/**
	 * @throws Exception 
	 * @description  跳转到确认支付页面
	 * @date 2017年1月10日下午4:35:17 
	 * @Return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/ConfirmPayment")
	public ModelAndView ConfirmPayment(HttpSession session,@RequestParam(value="orderNo",required=false)String orderNo) throws Exception{
		ModelAndView mv = new ModelAndView();
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		validaLog(session);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("/saleinfo/zf_wc");
		return mv;
	}

	
	/**
	 * @description 跳转到买家申请退款页面
	 * @date 2017年1月10日16:56:33
	 * @param orderNo 订单编号
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/orderInfoBuyer/viewApplyRefund")
	public ModelAndView viewApplyRefund(HttpSession session,@RequestParam(value="orderNo")String orderNo) throws Exception{
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
		validaLog(session);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orderState",orderState);
		modelAndView.addObject("obj",orderInfo);
		modelAndView.setViewName("/saleinfo/applyrefund");
		return modelAndView;
	}
	
	/**
	 * @description 买家申请退款
	 * @date 2017年1月10日21:05:19
	 * @param orderNo 订单编号
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/orderInfoBuyer/buyerApplyRefund")
	public String buyerApplyRefund(HttpSession session,@RequestParam(value="orderJson")String orderJson) throws Exception{
		if (isValidate) {
            if (FastValid.isEmp(orderJson))
                throw new ExceptionWithMessage("参数错误");
        }
		validaLog(session);
		OrderInfo orderInfo = JSON.parseObject(orderJson, OrderInfo.class);
		Integer res = orderInfoBuyerService.modifyRefundMsgByOrderNo(orderInfo);
		String url = "";
		if(res>0){
			url = "{\"url\":\"/saleinfo/orderInfoBuyer/orderView.html\"}";
		}else{
			
		}
		System.out.println(url);
		return url;
	}
	
	@ResponseBody
	@RequestMapping("/orderInfoBuyer/queryState")
	public String queryState(String id,HttpSession session) throws Exception{
		OrderInfo orderInfo = orderInfoBuyerService.selectById(id);
		validaLog(session);
		String reMsg = "";
		if(orderInfo.getOrderRefundstate()>0){
			reMsg="ok";
		}else{
			reMsg="no";
		}
		return reMsg;
		
	}
	
	/**
	 * @description 跳转到退款详情页面
	 * @date 2017年1月10日16:56:33
	 * @param orderNo 订单编号
	 * @return ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("/orderInfoBuyer/viewRefunddetails")
	public ModelAndView viewRefunddetails(HttpSession session,@RequestParam(value="orderNo")String orderNo) throws Exception{
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
		validaLog(session);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orderState",orderState);
		modelAndView.addObject("obj",orderInfo);
		modelAndView.setViewName("/saleinfo/refunddetails");
		return modelAndView;
	}

	@RequestMapping("/orderInfoBuyer/updateRefundStatusByOrderNo")
	public void updateRefundStatusByOrderNo(HttpServletResponse response,String orderId){
		JsonResult jr = new JsonResult();
		try {
			jr = orderInfoBuyerService.updateRefundStatusByOrderNo(orderId);
		} catch (ExceptionWithMessage e) {
			e.printStackTrace();
			jr = e.jsonResult;
		}
		JsonUtil.printByJSON(response, jr);
	}
	
}
