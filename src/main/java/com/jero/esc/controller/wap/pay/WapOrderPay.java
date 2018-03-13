package com.jero.esc.controller.wap.pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.alipay.config.AlipayConfig;
import com.jero.esc.common.utils.alipay.customutils.AlipayCustomUtils;
import com.jero.esc.common.utils.alipay.util.AlipayNotify;
import com.jero.esc.common.utils.alipay.util.AlipaySubmit;
import com.jero.esc.common.utils.jdpay.config.JdpayConfig;
import com.jero.esc.common.utils.jdpay.util.JdpaySubmit;
import com.jero.esc.common.utils.qrcode.QRCodeUtil;
import com.jero.esc.common.utils.jdpay.config.JdpayConfig;
import com.jero.esc.common.utils.jdpay.util.JdpaySubmit;
import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.business.OrderBusiness;
import com.jero.esc.common.utils.wechat.entity.order.OrderReq;
import com.jero.esc.po.details.OrderDoneDetails;
import com.jero.esc.po.pay.Payinfo;
import com.jero.esc.po.saleinfo.OrderInfo;
import com.jero.esc.vo.saleinfo.OrderService;
import beartool.MD5;
import com.jero.esc.service.details.IOrderDoneDetailsService;
import com.jero.esc.service.pay.IOrderPayService;
import com.jero.esc.service.saleinfo.IOrderInfoSellerService;

@Controller
@RequestMapping("/wap/pay")
public class WapOrderPay extends BaseController{
	
	
	@Autowired
	private IOrderPayService orderPayService;
	
	@Autowired
	private IOrderDoneDetailsService orderDoneDetailsService;
	
	@Autowired
	private IOrderInfoSellerService orderInfoSellerService;
	
	
	@RequestMapping("/orderpay/code")
	public void code(HttpServletResponse response,String codeurl) throws Exception{
		ServletOutputStream temp=null;
		try{
			temp=response.getOutputStream();
		QRCodeUtil.encode(codeurl, null,temp, false);
		}
		finally{
			temp.close();
		}
	}
	
	/*************** 微信支付开始 **************/
	@RequestMapping("/wxpay/paystart")
	public ModelAndView wxpay(String orderId) throws Exception{
		HashMap<String, Object> orders=new HashMap<String, Object>();
		orders=orderPayService.queryOrdeAllByOrderId(orderId);
		OrderInfo orderInfo=new OrderInfo();
		List<OrderService> orderService=new ArrayList();
		//ServiceSnapshot serviceSnapshot=new ServiceSnapshot();
		if(orders!=null){
			orderInfo=(OrderInfo)orders.get("orderInfo");
			orderService=(List<OrderService>)orders.get("orderService");
			//serviceSnapshot=(ServiceSnapshot)orders.get("serviceSnapshot");
		
		}else{
			orderInfo=null;
			orderService=null;
			//serviceSnapshot=null;
		}
		//将订单商品信息传入details
		String details=JSON.toJSONString(orderService);
		System.out.println(details);
		//微信商品价格以分为单位，将价格乘100转为Integer
		Float temp=orderInfo.getOrderPrice()*100;
		int price =temp.intValue();
		
		//获取商品信息
		//ServiceInfo serviceInfo =(ServiceInfo) JSON.parseArray(serviceSnapshot.getSersInfo(),ServiceInfo.class);
		OrderReq orderReq=null;
		String comment=JSON.toJSONString(orderReq);
		OrderInfo info=new OrderInfo();
		info.setOrderId(orderId);
		info.setOrderComment(comment);
		orderPayService.modifyOrderInfo(info);
		OrderBusiness orderBusiness=new OrderBusiness();
		String codeurl;
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/wap/pay/wxpay");
		try {
			codeurl = orderBusiness.getCodeUrl(orderReq);
			//QRCodeUtil.encode(codeurl, null, servletResponse.getOutputStream(), false);
			System.out.println(codeurl);
			modelAndView.addObject("codeurl",codeurl);
			modelAndView.addObject("price",orderInfo.getOrderPrice());
			modelAndView.addObject("orderId",orderId);
			return modelAndView;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Null");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO");
			e.printStackTrace();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return modelAndView;
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="/wxpay/payreturn",produces="text/html;charset=UTF-8")
	public String wxreturn(String orderId){
	
		com.jero.esc.vo.saleinfo.OrderInfo orderInfo=new com.jero.esc.vo.saleinfo.OrderInfo();
		orderInfo=orderInfoSellerService.selectOrderById(orderId);
		if(orderInfo!=null&&orderInfo.getOrderState()==4)
		{
			return "{result:'1'}";
		}else{
			return "{result:'0'}";
		}
		
	}
	
	/**
	 * @param session
	 * @param request
	 * @param response
	 */
	@RequestMapping("/wxpay/paynotify")
	public void wxnotify(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		System.out.println("notify");
		OrderInfo orderInfo=new OrderInfo();
		OrderBusiness orderBusiness=new OrderBusiness();
		Payinfo payinfo =new Payinfo();
		try {
			JsonResult state=orderBusiness.payNotify(request, response);
			SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>(); 
			packageParams=(SortedMap<Object, Object>) state.getObj();
			String temp=(String) packageParams.get("out_trade_no");
			String out_trade_no=temp.substring(0, 14);
			//查询订单信息
			orderInfo=orderPayService.selectOrderInfoByOrderNo(out_trade_no);
			
			com.jero.esc.vo.saleinfo.OrderInfo orderInfoV = new com.jero.esc.vo.saleinfo.OrderInfo();
			orderInfoV.setOrderId(orderInfo.getOrderId());
			orderInfoV.setOrderState(4);
			orderInfoSellerService.modifyOrderState(orderInfoV);
			// 记录当前支付 操作明细
			OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
			orderDoneDetails.setOddId(UUIDUtil.getUUID());
			orderDoneDetails.setLogId(orderInfo.getOrderBuyer());
			//将交易信息存为json数据存储
			payinfo.setLogId(orderInfo.getOrderBuyer());
			payinfo.setNonce_str((String) packageParams.get("nonce_str"));
			payinfo.setOrderId(orderInfo.getOrderBuyer());
			payinfo.setOut_trade_no(out_trade_no);
			payinfo.setSign((String) packageParams.get("sign"));
			payinfo.setTrade_type(2);
			payinfo.setTransaction_id((String) packageParams.get("transaction_id"));
			String comment=JSONObject.toJSONString(payinfo);
			
			
			orderDoneDetails.setOddComment(comment);
			orderDoneDetails.setOddCreatetime(new Date());
			orderDoneDetails.setOddInfo(4);// 表示  支付状态    4代表  待服务 
			orderDoneDetails.setOddResult("支付成功");
			orderDoneDetails.setOrderId(orderInfo.getOrderId());
			orderDoneDetailsService.addOrderDoneDetail(orderDoneDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*************** 微信支付结束 **************/
	/*//保存认证信息
	@ResponseBody
	@RequestMapping(value="/providerCheck/modifyCheckInfo",produces="text/html;charset=UTF-8")
	public String modifyCheckInfo(HttpSession session,HttpServletResponse response)throws Exception {
		return null;
	}*/
}
