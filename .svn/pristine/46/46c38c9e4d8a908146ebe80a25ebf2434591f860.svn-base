package com.jero.esc.controller.wap.saleinfo;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.ConstUtil;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.weixin.pay.WxPayConstants;
import com.jero.esc.common.weixin.pay.WxPayUtil;
import com.jero.esc.mapper.saleinfo.OrderInfoBuyerMapper;
import com.jero.esc.po.details.AccontPaymentDetails;
import com.jero.esc.po.details.OrderDoneDetails;
import com.jero.esc.po.pay.Payinfo;
import com.jero.esc.po.userinfo.AccountInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.details.IAccountPaymentDetailsService;
import com.jero.esc.service.details.IOrderDoneDetailsService;
import com.jero.esc.service.saleinfo.IOrderInfoBuyerService;
import com.jero.esc.vo.saleinfo.OrderInfo;

/**
 * @copyright 
 * @author zengd
 * @version 
 * @date 2016年12月22日下午7:25:20 
 * @description
 */
@Controller
@RequestMapping("/wap/saleinfo")
public class WapOrderInfoBuyerController extends BaseController {
    @Autowired
    private IAccountPaymentDetailsService accountPaymentDetailsService;
    @Autowired
    private IOrderDoneDetailsService orderDoneDetailsService;
//    @Autowired
//    private IOrderInfoSellerService orderInfoSellerService;
	@Autowired
	private IOrderInfoBuyerService orderInfoBuyerService;
	
	@Autowired
	private OrderInfoBuyerMapper orderInfoBuyerMapper;
	/**
	 * @description  跳转到订单查询页面
	 * @date 2016年12月26日下午7:36:09 
	 * @Return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/orderView")
	public ModelAndView orderView(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("f", 1);
		mv.setViewName("wap/saleinfo/my_date");
		return mv;
	}
	
	/**
	 * 查询订单
	 * @param orderService
	 * @param page
	 * @param rows
	 */
	@RequestMapping("/orderInfoBuyer/getAllOrder")
	public void getAllOrder(HttpServletResponse response,HttpSession session,OrderInfo orderInfo,Integer page, Integer rows){
		LogInfo logInfo = retrievalCurrentUserInfo(session);
		orderInfo.setOrderBuyer(logInfo.getLogId());
		rows = 10;
		Integer totalNum = orderInfoBuyerService.totalNum(orderInfo);
		int no = (int) Math.ceil((double)totalNum/rows);
		if(page>no){
			page = no;
		}
		List<OrderInfo> orderList = orderInfoBuyerService.selectAll(getPageRowBounds(page,rows), orderInfo);
		printDataGridJsonData(response, totalNum, orderList);
		
	}
	/**
	 * @description 跳转支付页面
	 * @date 2016年12月26日上午11:07:21 
	 * @Parm session
	 * @Return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/getAccount")
	public ModelAndView getAccount(HttpSession session,@RequestParam(value="orderId",required=false)String id){
		ModelAndView mv = new ModelAndView();
		String logId = retrievalCurrentUserInfo(session).getLogId();
		AccountInfo selectBalanceById = orderInfoBuyerService.selectBalanceById(logId);
		OrderInfo orderInfo = orderInfoBuyerService.selectById(id);
		mv.addObject("selectBalanceById", selectBalanceById);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("/wap/saleinfo/mony_tg");
		return mv;
	}
	/**
	 * @description 付款
	 * @date 2016年12月26日上午11:30:13 
	 * @Parm accountInfo
	 * @Parm response
	 * @Return void
	 */
	@RequestMapping("/orderInfoBuyer/validate")
	public void validate(@RequestParam(value="flag",required=false)Integer flag,
			@RequestParam(value="orderPrice",required=false)String orderPrice,
			@RequestParam(value="orderNo",required=false)String orderNo, 
			@RequestParam(value="serviceTitle",required=false)String serviceTitle, 
			AccountInfo accountInfo,HttpServletResponse response,HttpSession session){
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
		try {
			jr = orderInfoBuyerService.validate(accountInfo, orderPrice, orderNo,flag,serviceTitle);
		} catch (ExceptionWithMessage e) {
			e.printStackTrace();
			jr =e.jsonResult;
		}
		JsonUtil.printByJSON(response, jr);
	}
	
	/**
	 * @description 根据订单编号删除订单
	 * @date 2016年12月27日下午1:46:14 
	 * @Parm orderInfo
	 * @Parm response
	 * @Return void
	 */
	@RequestMapping("/orderInfoBuyer/del")
	public void del(OrderInfo orderInfo,HttpServletResponse response){
		JsonResult jr = new JsonResult();
		String orderNo = orderInfo.getOrderNo();
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
	 * @Return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/details")
	public ModelAndView details(HttpSession session,@RequestParam(value="orderId",required=false)String orderId){
		ModelAndView mv = new ModelAndView();
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderId);
		/*String orderSeller = orderInfo.getOrderSeller();*/
		/*LogInfo logInfo = orderInfoBuyerService.getLogInfo(orderSeller);*/
		/*mv.addObject("logInfo", logInfo);*/
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("/wap/saleinfo/dd_xq");
		return mv;
	}
	
	/**
	 * @description  跳转到确认支付页面
	 * @date 2017年1月10日下午4:35:17 
	 * @Return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/ConfirmPayment")
	public ModelAndView ConfirmPayment(HttpSession session,@RequestParam(value="orderNo",required=false)String orderNo,
									   @RequestParam(value="flag",required=false)String flag){
		ModelAndView mv = new ModelAndView();
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		mv.addObject("orderInfo", orderInfo);
		mv.addObject("flag", flag);
		mv.setViewName("wap/saleinfo/zf_wc");
		return mv;
	}

	
	/**
	 * @description 跳转到买家申请退款页面
	 * @date 2017年1月10日16:56:33
	 * @param orderNo 订单编号
	 * @return ModelAndView
	 */
	@RequestMapping("/orderInfoBuyer/viewApplyRefund")
	public ModelAndView viewApplyRefund(HttpSession session,@RequestParam(value="orderNo")String orderNo){
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orderState",orderState);
		modelAndView.addObject("orderInfo",orderInfo);
		modelAndView.setViewName("/wap/saleinfo/applyrefund");
		return modelAndView;
	}
	
	/**
	 * @description 买家申请退款
	 * @date 2017年1月10日21:05:19
	 * @param orderNo 订单编号
	 * @throws ExceptionWithMessage 
	 */
	@ResponseBody
	@RequestMapping("/orderInfoBuyer/buyerApplyRefund")
	public String buyerApplyRefund(HttpSession session,@RequestParam(value="orderJson")String orderJson) throws ExceptionWithMessage{
		if (isValidate) {
            if (FastValid.isEmp(orderJson))
                throw new ExceptionWithMessage("参数错误");
        }
		OrderInfo orderInfo = JSON.parseObject(orderJson, OrderInfo.class);
		Integer res = orderInfoBuyerService.modifyRefundMsgByOrderNo(orderInfo);
		String url = "";
		if(res>0){
			url = "{\"url\":\"/wap/saleinfo/orderInfoBuyer/orderView.html\"}";
		}else{
			
		}
		System.out.println(url);
		return url;
	}
	
	@ResponseBody
	@RequestMapping("/orderInfoBuyer/queryState")
	public String queryState(String id){
		OrderInfo orderInfo = orderInfoBuyerService.selectById(id);
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
	 */
	@RequestMapping("/orderInfoBuyer/viewRefunddetails")
	public ModelAndView viewRefunddetails(HttpSession session,@RequestParam(value="orderNo")String orderNo){
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orderState",orderState);
		modelAndView.addObject("orderInfo",orderInfo);
		modelAndView.setViewName("/wap/saleinfo/refunddetails");
		return modelAndView;
	}
	
	@RequestMapping(value="/wxPay")
	public void wxPay(HttpSession session, HttpServletRequest request, HttpServletResponse response, String orderId, String body
			, String money, String openId, String orderNo){
		String prePayInfoXml;
		try {
			LogInfo logInfo = retrievalCurrentUserInfo(session);
			if(logInfo!= null){
				session.setAttribute("logId", logInfo.getOpenId());
				session.setAttribute("orderId", orderNo);
				System.out.println("1<<<<<<<<<<<<<<<"+orderNo);
				//o5tP4v2sRruivGVkBPjL5zvWQQnwutf-8   new String(body.toString().getBytes(), "UTF-8")
				prePayInfoXml = WxPayUtil.unifiedOrder(new String(body.getBytes("iso8859-1"), "utf-8"), orderNo, Integer.valueOf(money+"00"), WxPayUtil.getIpAddr(request), logInfo.getOpenId(),logInfo.getLogId());
				//生成包含prepay_id的map，map传入前端
				Map<String, Object> map = WxPayUtil.getPayMap(prePayInfoXml);
				//将订单号放入map，用以支付后处理
				map.put("orderNo",WxPayUtil.getNonceStr());
				JsonUtil.printByJSON(response, new JsonResult(true, "", map));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/notify")
	public void notify(HttpSession session, HttpServletRequest request, HttpServletResponse response){
	       String inputLine;  
	        String notifyXml = "";
	        String resXml = "";
//	        String logId = (String) session.getAttribute("logId");
//	        String orderId = (String) session.getAttribute("orderId");
//	        System.out.println("3<<<<<<<<<<<<<<<"+logId);
//	        System.out.println("3<<<<<<<<<<<<<<<"+orderId);
	        try {  
	            while ((inputLine = request.getReader().readLine()) != null){  
	                notifyXml += inputLine;  
	            }  
	            request.getReader().close();  
	        } catch (Exception e) {  
//	            logger.debug("xml获取失败：" + e);
	            e.printStackTrace();
	        }
	        System.out.println("接收到的xml：" + notifyXml);
//	        logger.debug("收到微信异步回调：");  
//	        logger.debug(notifyXml);  
//	        if(ToolString.isEmpty(notifyXml)){  
////	            logger.debug("xml为空：");  
//	        }
	        String appid = WxPayUtil.getXmlPara(notifyXml,"appid");;  
	        String bank_type = WxPayUtil.getXmlPara(notifyXml,"bank_type");  
	        String cash_fee = WxPayUtil.getXmlPara(notifyXml,"cash_fee");
	        String fee_type = WxPayUtil.getXmlPara(notifyXml,"fee_type");  
	        String is_subscribe = WxPayUtil.getXmlPara(notifyXml,"is_subscribe");  
	        String mch_id = WxPayUtil.getXmlPara(notifyXml,"mch_id");  
	        String nonce_str = WxPayUtil.getXmlPara(notifyXml,"nonce_str");  
	        String openid = WxPayUtil.getXmlPara(notifyXml,"openid");  
	        String out_trade_no = WxPayUtil.getXmlPara(notifyXml,"out_trade_no");
	        String result_code = WxPayUtil.getXmlPara(notifyXml,"result_code");
	        String return_code = WxPayUtil.getXmlPara(notifyXml,"return_code");
	        String sign = WxPayUtil.getXmlPara(notifyXml,"sign");
	        String time_end = WxPayUtil.getXmlPara(notifyXml,"time_end");
	        String total_fee = WxPayUtil.getXmlPara(notifyXml,"total_fee");
	        String trade_type = WxPayUtil.getXmlPara(notifyXml,"trade_type");
	        String transaction_id = WxPayUtil.getXmlPara(notifyXml,"transaction_id");

	        //根据返回xml计算本地签名
	        String localSign =
	                "appid=" + appid +
	                "&bank_type=" + bank_type +
	                "&cash_fee=" + cash_fee +
	                "&fee_type=" + fee_type +
	                "&is_subscribe=" + is_subscribe +
	                "&mch_id=" + mch_id +
	                "&nonce_str=" + nonce_str +
	                "&openid=" + openid +
	                "&out_trade_no=" + out_trade_no +
	                "&result_code=" + result_code +
	                "&return_code=" + return_code +
	                "&time_end=" + time_end +
	                "&total_fee=" + total_fee +
	                "&trade_type=" + trade_type +
	                "&transaction_id=" + transaction_id +
	                "&key=" + WxPayConstants.KEY;//注意这里的参数要根据ASCII码 排序
	        localSign = WxPayUtil.MD5Encode(localSign, "UTF-8").toUpperCase();//将数据MD5加密

	        System.out.println("本地签名是：" + localSign);
//	        logger.debug("本地签名是：" + localSign);  
//	        logger.debug("微信支付签名是：" + sign);

	        //本地计算签名与微信返回签名不同||返回结果为不成功
	        if(!sign.equals(localSign) || !"SUCCESS".equals(result_code) || !"SUCCESS".equals(return_code)){
	            System.out.println("验证签名失败或返回错误结果码"); 
//	            logger.error("验证签名失败或返回错误结果码");
	            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[FAIL]]></return_msg>" + "</xml> ";
	        }else{
//	        	//支付成功进行逻辑处理
//	            com.jero.esc.vo.saleinfo.OrderInfo orderInfoV = new com.jero.esc.vo.saleinfo.OrderInfo();
//	            orderInfoV.setOrderId(out_trade_no);
//	            orderInfoV.setOrderState(4);
//	            orderInfoSellerService.modifyOrderState(orderInfoV);
	            orderInfoBuyerMapper.updateState(out_trade_no,1);
	            // 记录当前支付 操作明细
	            OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
	            orderDoneDetails.setOddId(UUIDUtil.getUUID());
	            orderDoneDetails.setLogId(nonce_str);
	            //将交易信息存为json数据存储
	            Payinfo payinfo = new Payinfo();
	            payinfo.setLogId(nonce_str);
	            payinfo.setNonce_str(nonce_str);
	            payinfo.setOrderId(out_trade_no);
	            payinfo.setOut_trade_no(out_trade_no);
	            payinfo.setSign(sign);
	            payinfo.setTrade_type(2);
	            payinfo.setTransaction_id(transaction_id);
	            String comment = JSONObject.toJSONString(payinfo);


	            orderDoneDetails.setOddComment(comment);
	            orderDoneDetails.setOddCreatetime(new Date());
	            orderDoneDetails.setOddInfo(4);// 表示  支付状态    4代表  待服务
	            orderDoneDetails.setOddResult("支付成功");
	            orderDoneDetails.setOrderId(out_trade_no);
	            orderDoneDetailsService.addOrderDoneDetail(orderDoneDetails);

	            // 分别记录卖家或者买家的  相关支付信息
	            //  买家    buyer
	            AccontPaymentDetails buyerAccontPaymentDetails = new AccontPaymentDetails();
	            buyerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
	            buyerAccontPaymentDetails.setLogId(nonce_str);
	            buyerAccontPaymentDetails.setApdIotype(2);// 2表示支出  1表示收入
	            buyerAccontPaymentDetails.setApdPaytype(2); // 1支付宝  ，2 微信 ， 3 银行卡
	            buyerAccontPaymentDetails.setApdCreatetime(new Date());
	            buyerAccontPaymentDetails.setApdAmount(Float.valueOf(total_fee)/100);
	            buyerAccontPaymentDetails.setApdAdminorderno(out_trade_no);
	            try {
	                accountPaymentDetailsService.addAccountIODetails(buyerAccontPaymentDetails);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	    		
	    		
	             System.out.println("支付成功");
//	             logger.debug("公众号支付成功，out_trade_no(订单号)为：" + out_trade_no);
	             resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
	        }
		
		
//	    System.out.print("微信支付回调获取数据开始");  
//	    String resXml = WxPayUtil.getNotifyResult(request,orderId);
	    //向微信输出处理结果，如果成功（SUCCESS），微信就不会继续调用了，否则微信会连续调用8次
	    try {
			response.getWriter().write(resXml);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
