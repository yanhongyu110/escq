package com.jero.esc.controller.pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.jero.esc.common.utils.alipay.util.AlipayCore;
import com.jero.esc.common.utils.alipay.util.UtilDate;
import com.jero.esc.common.utils.wechat.utils.WxCommon;
import com.jero.esc.common.utils.wechat.utils.Configure;
import com.jero.esc.common.utils.wechat.utils.Util;
import com.jero.esc.mapper.saleinfo.OrderInfoMapper;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpPayService;
import me.chanjar.weixin.mp.bean.pay.request.WxPayUnifiedOrderRequest;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.codec.Charsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.DateUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.alipay.config.AlipayConfig;
import com.jero.esc.common.utils.alipay.util.AlipayNotify;
import com.jero.esc.common.utils.alipay.util.AlipaySubmit;
import com.jero.esc.common.utils.jdpay.config.JdpayConfig;
import com.jero.esc.common.utils.jdpay.util.JdpaySubmit;
import com.jero.esc.common.utils.qrcode.QRCodeUtil;
import com.jero.esc.common.utils.random.FastRandom;
import com.jero.esc.common.utils.wechat.business.OrderBusiness;
import com.jero.esc.common.utils.wechat.entity.order.OrderReq;
import com.jero.esc.po.details.OrderDoneDetails;
import com.jero.esc.po.pay.PayApi;
import com.jero.esc.po.pay.Payinfo;
import com.jero.esc.po.saleinfo.OrderInfo;
import com.jero.esc.vo.saleinfo.OrderService;
import beartool.MD5;
import com.jero.esc.service.details.IOrderDoneDetailsService;
import com.jero.esc.service.pay.IOrderPayService;
import com.jero.esc.service.pay.IPayApiService;
import com.jero.esc.service.saleinfo.IOrderInfoSellerService;
import com.jero.esc.service.details.IAccountPaymentDetailsService;
import com.jero.esc.po.details.AccontPaymentDetails;

@Controller
@RequestMapping("/pay")
public class OrderPay extends BaseController {

    @Autowired
    private IOrderPayService orderPayService;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private IOrderDoneDetailsService orderDoneDetailsService;

    @Autowired
    private IOrderInfoSellerService orderInfoSellerService;

    @Autowired
    private IAccountPaymentDetailsService accountPaymentDetailsService;

    @Autowired
    private IPayApiService payApiService;


    @Autowired
    private WxCommon wxCommon;


    @RequestMapping("/orderpay/code")
    public void code(HttpServletResponse response, String codeurl) throws Exception {
        ServletOutputStream temp = null;
        try {
            temp = response.getOutputStream();
            System.out.println(codeurl);
            QRCodeUtil.encode(codeurl, null, temp, false);
        } finally {
            temp.close();
        }
    }


    @RequestMapping("/viewGzPay")
    public ModelAndView viewGzPay(String orderId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderId", orderId);
        modelAndView.setViewName("wap/pay/pay");
        return modelAndView;
    }


    //微信公众号支付
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "/GzPay", produces = "text/html;charset=UTF-8")
    public String GzPay(HttpServletRequest request, HttpSession session, String orderId) throws Exception {

        try {
            HashMap<String, Object> orders = new HashMap<String, Object>();
            orders = orderPayService.queryOrdeAllByOrderId(orderId);
            OrderInfo orderInfo = new OrderInfo();
            List<OrderService> orderService = new ArrayList();
            //ServiceSnapshot serviceSnapshot=new ServiceSnapshot();

            orderInfo = (OrderInfo) orders.get("orderInfo");
            orderService = (List<OrderService>) orders.get("orderService");
            //serviceSnapshot=(ServiceSnapshot)orders.get("serviceSnapshot");

            if (orderInfo.getOrderState() != 2) {
                throw new Exception();
            }

            //将订单商品信息传入details
            String details = JSON.toJSONString(orderService);
            System.out.println(details);
            //微信商品价格以分为单位，将价格乘100转为Integer
            Float temp = orderInfo.getOrderPrice() * 100;
            int price = temp.intValue();


            //获取商品信息
            //ServiceInfo serviceInfo =(ServiceInfo) JSON.parseArray(serviceSnapshot.getSersInfo(),ServiceInfo.class);
            OrderReq orderReq = new OrderReq(null, null, null, "NATIVE", null, "近到家-服务购买", details, null, orderInfo.getOrderNo() + FastRandom.getRandom(6), price, null, orderInfo.getOrderId());
            String comment = JSON.toJSONString(orderReq);
            OrderInfo info = new OrderInfo();
            info.setOrderId(orderId);
            info.setOrderComment(comment);
            orderPayService.modifyOrderInfo(info);

            WxMpUser wxUser = (WxMpUser) (session.getAttribute("wxUser"));
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
//			orderRequest.setNotifyURL(orderReq.getNotify_url());
//			orderRequest.setMchId(orderReq.getMch_id());
            orderRequest.setBody(orderReq.getBody());
            orderRequest.setDetail(orderReq.getDetail());
            orderRequest.setOutTradeNo(orderInfo.getOrderId());
            orderRequest.setTotalFee(orderReq.getTotal_fee());
            orderRequest.setSpbillCreateIp(request.getRemoteAddr());
            orderRequest.setNonceStr(orderReq.getNonce_str());
            orderRequest.setTradeType("JSAPI");
//			orderRequest.setOpenid(wxUser.getOpenId());//TODO
            WxMpPayService wxMpPayService = wxCommon.getService(orderId).getPayService();
            String s = JSON.toJSONString(wxMpPayService.getPayInfo(orderRequest));
            System.out.println(s);
            return s;
        } catch (WxErrorException e) {
            e.printStackTrace();
            return "失败";
        }

    }


    /***************
     * 微信App支付开始
     **************/
    @ResponseBody
    @RequestMapping(value = "/wx/appPay", produces = "text/html;charset=UTF-8")
    @Transactional(rollbackFor = Exception.class)
    public String wxApppay(HttpServletRequest request, HttpSession session, String orderId) throws Exception {

//        orderId="6944beca3caf4badba528ba23539bd21";

//        if (test == null) test = false;

        OrderInfo orderInfo = null;
        String details = null;
        int price = 0;
        Map<String, String> apiMap = null;

//        if (test != null && !test) {
            HashMap<String, Object> orders = new HashMap<String, Object>();
            orders = orderPayService.queryOrdeAllByOrderId(orderId);
            orderInfo = new OrderInfo();
            List<OrderService> orderService = new ArrayList();
            //ServiceSnapshot serviceSnapshot=new ServiceSnapshot();

            orderInfo = (OrderInfo) orders.get("orderInfo");
            orderService = (List<OrderService>) orders.get("orderService");
            //serviceSnapshot=(ServiceSnapshot)orders.get("serviceSnapshot");
            if (orderInfo.getOrderState() != 2) {
                throw new Exception();
            }

            //将订单商品信息传入details
        /*String details=JSON.toJSONString(orderService);*/
            details = "商品详情";
            System.out.println(details);
            //微信商品价格以分为单位，将价格乘100转为Integer
            Float temp = orderInfo.getOrderPrice() * 100;
            price = temp.intValue();
            apiMap = payApiService.getApiMap(orderId, 2);
//        }


        //获取商品信息
        //ServiceInfo serviceInfo =(ServiceInfo) JSON.parseArray(serviceSnapshot.getSersInfo(),ServiceInfo.class);
        OrderReq orderReq = new OrderReq(
                apiMap.get("appId"),
                apiMap.get("partnerId"),
                apiMap.get("partnerKey"),
                "APP",
                Configure.getNotifyUrl(),
                "近到家-服务购买",
                details,
                null,
                orderInfo.getOrderNo()+FastRandom.getRandom(4),
                price,
                null,
                orderInfo.getOrderId()
        );
        orderReq.setTrade_type("APP");
        //orderReq.setSpbill_create_ip(request.getRemoteAddr());
        orderReq.setSpbill_create_ip("127.0.0.1");
		/*String comment=JSON.toJSONString(orderReq);
        OrderInfo info=new OrderInfo();
		info.setOrderId(orderId);
		info.setOrderComment(comment);
		orderPayService.modifyOrderInfo(info);*/
        OrderBusiness orderBusiness = new OrderBusiness();
        JSONObject jsonObject = new JSONObject();



        String res = "";
        try {
            Map<String,String> oo = orderBusiness.getResult(orderReq);
            if (!oo.get("return_code").equals("SUCCESS")){
                Exception exception = new Exception(oo.get("return_msg"));
                throw exception;
            }
            if (!oo.get("result_code").equals("SUCCESS")){
                Exception exception = new Exception(oo.get("err_code")+":"+oo.get("err_code_des"));
                throw exception;
            }
            String timestamp=System.currentTimeMillis()/1000+"";
            
            String noncestr=FastRandom.getRandom(32);
            SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
            parameters.put("appid", oo.get("appid"));
            parameters.put("partnerid", oo.get("mch_id"));
            parameters.put("noncestr", noncestr);
            parameters.put("timestamp", timestamp);
            parameters.put("prepayid", oo.get("prepay_id"));
            parameters.put("package", "Sign=WXPay");
            String sign = Util.createSign(parameters,apiMap.get("partnerKey"));
            
            
            jsonObject.put("appid", oo.get("appid"));
            jsonObject.put("partnerid", oo.get("mch_id"));
            jsonObject.put("nonce_str", noncestr);
            jsonObject.put("timestamp", timestamp);
            jsonObject.put("prepayid", oo.get("prepay_id"));
            jsonObject.put("package", "Sign=WXPay");
            jsonObject.put("sign", sign);
            jsonObject.put("success", true);
            jsonObject.put("result", jsonObject);
            jsonObject.put("msg", "成功");
        } catch (NullPointerException e) {
            jsonObject.put("success", false);
            jsonObject.put("msg", e.getMessage());
        } catch (IOException e) {
            jsonObject.put("success", false);
            jsonObject.put("msg", e.getMessage());
        } catch (Exception e) {
            jsonObject.put("success", false);
            jsonObject.put("msg", e.getMessage());
        } finally {
        	System.out.println(jsonObject);
            return jsonObject.toJSONString();
        }
    }


    /***************
     * 微信支付开始
     **************/
    @RequestMapping("/wxpay/paystart")
    @Transactional(rollbackFor = Exception.class)
    public ModelAndView wxpay(HttpServletRequest request, HttpSession session, String orderId) throws Exception {
        HashMap<String, Object> orders = new HashMap<String, Object>();
        orders = orderPayService.queryOrdeAllByOrderId(orderId);
        OrderInfo orderInfo = new OrderInfo();
        List<OrderService> orderService = new ArrayList();
        //ServiceSnapshot serviceSnapshot=new ServiceSnapshot();


        orderInfo = (OrderInfo) orders.get("orderInfo");
        orderService = (List<OrderService>) orders.get("orderService");
        //serviceSnapshot=(ServiceSnapshot)orders.get("serviceSnapshot");
        if (orderInfo.getOrderState() != 2) {
            throw new Exception();
        }


        //将订单商品信息传入details
        /*String details=JSON.toJSONString(orderService);*/
        String details = "商品详情";
        System.out.println(details);
        //微信商品价格以分为单位，将价格乘100转为Integer
        Float temp = orderInfo.getOrderPrice() * 100;
        int price = temp.intValue();

        //获取商品信息
        //ServiceInfo serviceInfo =(ServiceInfo) JSON.parseArray(serviceSnapshot.getSersInfo(),ServiceInfo.class);

        //获取商户基本配置信息


        Map<String, String> jot = payApiService.getApiMap(orderId, 2);
        OrderReq orderReq = null;
        orderReq = new OrderReq(jot.get("appId"), jot.get("partnerId"), jot.get("partnerKey"), "NATIVE", Configure.getNotifyUrl(), "近到家-服务购买", details, null, orderInfo.getOrderNo()+FastRandom.getRandom(4), price, null, orderInfo.getOrderId());


        String comment = JSON.toJSONString(orderReq);
        OrderInfo info = new OrderInfo();
        info.setOrderId(orderId);
        info.setOrderComment(comment);
        orderPayService.modifyOrderInfo(info);
        OrderBusiness orderBusiness = new OrderBusiness();
        String codeurl;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/pay/wxpay");
        try {
            codeurl = orderBusiness.getCodeUrl(orderReq);
            //QRCodeUtil.encode(codeurl, null, servletResponse.getOutputStream(), false);
            System.out.println(codeurl);
            modelAndView.addObject("codeurl", codeurl);
            modelAndView.addObject("price", orderInfo.getOrderPrice());
            modelAndView.addObject("orderId", orderId);
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
        } finally {
            return modelAndView;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/wxpay/payreturn", produces = "text/html;charset=UTF-8")
    public String wxreturn(String orderId) {

        com.jero.esc.vo.saleinfo.OrderInfo orderInfo = new com.jero.esc.vo.saleinfo.OrderInfo();
        orderInfo = orderInfoSellerService.selectOrderById(orderId);
        if (orderInfo != null && orderInfo.getOrderState() == 4) {
            return "{result:'1'}";
        } else {
            return "{result:'0'}";
        }

    }

    /**
     * @param session
     * @param request
     * @param response
     */
    @RequestMapping("/wxpay/paynotify")
    @Transactional(rollbackFor = Exception.class)
    public void wxnotify(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("notify");
            OrderInfo orderInfo = new OrderInfo();
            OrderBusiness orderBusiness = new OrderBusiness();
            Payinfo payinfo = new Payinfo();
            JsonResult state = orderBusiness.payNotify(request, response);
            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            packageParams = (SortedMap<Object, Object>) state.getObj();
            String out_trade_no = (String) packageParams.get("out_trade_no");
            String orderId = (String) packageParams.get("nonce_str");
            //String out_trade_no=temp.substring(0, 14);
            //查询订单信息
            orderInfo = orderInfoMapper.selectByPrimaryKey(orderId);

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
            payinfo.setOrderId(orderInfo.getOrderId());
            payinfo.setOut_trade_no(out_trade_no);
            payinfo.setSign((String) packageParams.get("sign"));
            payinfo.setTrade_type(2);
            payinfo.setTransaction_id((String) packageParams.get("transaction_id"));
            String comment = JSONObject.toJSONString(payinfo);


            orderDoneDetails.setOddComment(comment);
            orderDoneDetails.setOddCreatetime(new Date());
            orderDoneDetails.setOddInfo(4);// 表示  支付状态    4代表  待服务
            orderDoneDetails.setOddResult("支付成功");
            orderDoneDetails.setOrderId(orderInfo.getOrderId());
            orderDoneDetailsService.addOrderDoneDetail(orderDoneDetails);

            // 分别记录卖家或者买家的  相关支付信息
            //  买家    buyer
            AccontPaymentDetails buyerAccontPaymentDetails = new AccontPaymentDetails();
            buyerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
            buyerAccontPaymentDetails.setLogId(orderInfo.getOrderBuyer());
            buyerAccontPaymentDetails.setApdIotype(2);// 2表示支出  1表示收入
            buyerAccontPaymentDetails.setApdPaytype(2); // 1支付宝  ，2 微信 ， 3 银行卡
            buyerAccontPaymentDetails.setApdCreatetime(new Date());
            buyerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
            buyerAccontPaymentDetails.setApdAdminorderno(out_trade_no);
            try {
                accountPaymentDetailsService.addAccountIODetails(buyerAccontPaymentDetails);
            } catch (Exception e) {
                e.printStackTrace();
            }
			
			/*// 卖家  seller
			AccontPaymentDetails sellerAccontPaymentDetails = new AccontPaymentDetails();
			sellerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
			sellerAccontPaymentDetails.setLogId(orderInfo.getOrderSeller());
			sellerAccontPaymentDetails.setApdIotype(1);// 2表示支出  1表示收入
			sellerAccontPaymentDetails.setApdPaytype(2); // 1支付宝  ，2 微信 ， 3 银行卡
			sellerAccontPaymentDetails.setApdCreatetime(new Date());
			sellerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
			sellerAccontPaymentDetails.setApdAdminorderno(out_trade_no);
			try {accountPaymentDetailsService.addAccountIODetails(sellerAccontPaymentDetails);
			} catch (Exception e) {e.printStackTrace();}*/
            // 返回到    订单页面

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***************
     * 微信支付结束
     **************/
	/*//保存认证信息
	@ResponseBody
	@RequestMapping(value="/providerCheck/modifyCheckInfo",produces="text/html;charset=UTF-8")
	public String modifyCheckInfo(HttpSession session,HttpServletResponse response)throws Exception {
		return null;
	}*/


    //app支付宝支付接口 未测试
    @ResponseBody
    @RequestMapping(value = "/alipay/appPay", produces = "text/html;charset=UTF-8")
    public String payAppStart(HttpSession session, HttpServletResponse response, HttpServletRequest request, Boolean test) throws Exception {

        AlipayClient alipayClient = null;

        AlipayTradeAppPayRequest appPayRequest = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

        if (test == null) test = false;

        String subject = null;       // 标题
        String out_trade_no = null;  // 交易平台自动生成的 交易号
        String total_fee = null;     // 费用
        String body = null;          // 订单描述  买家 + 订单id
        Map<String, String> apiMap = null;
        if (test != null && !test) {
            String orderId = request.getParameter("orderId");
            apiMap = payApiService.getApiMap(orderId, 1);
            alipayClient = new DefaultAlipayClient(
                    "https://openapi.alipay.com/gateway.do",
                    apiMap.get("appId"),
                    apiMap.get("private_key"),
                    "json",
                    "UTF-8",
                    apiMap.get("public_key"),
                    "RSA2"
            );

            HashMap<String, Object> resMap = orderPayService.queryOrdeAllByOrderId(orderId);
            OrderInfo orderInfo = (OrderInfo) resMap.get("orderInfo");
            List<OrderService> orderServices = (List<OrderService>) resMap.get("orderService");
            subject = "服务购买";
            out_trade_no = orderInfo.getOrderNo();
            total_fee = orderInfo.getOrderPrice().toString();
            body = orderInfo.getOrderBuyer() + "," + orderId;
            if (orderInfo.getOrderState() != 2) {
                throw new Exception();
            }
        } else {
            alipayClient = new DefaultAlipayClient(
                    "https://openapi.alipay.com/gateway.do",
                    AlipayConfig.app_id,
                    AlipayConfig.private_key,
                    "json",
                    "UTF-8",
                    AlipayConfig.alipay_public_key,
                    "RSA2"
            );
        }



        model.setBody(test ? FastRandom.getRandom(10) : body);
        model.setSubject(test ? FastRandom.getRandom(5) : subject);
        model.setOutTradeNo(test ? FastRandom.getRandom(10) : out_trade_no);
        model.setTimeoutExpress("30m");
        model.setTotalAmount(test ? "0.01" : total_fee);
        model.setProductCode("QUICK_MSECURITY_PAY");

        //公共参数
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("app_id", test ? AlipayConfig.app_id : apiMap.get("appId"));
//        map.put("method", "alipay.trade.app.pay");
//        map.put("format", "json");
//        map.put("charset", "utf-8");
//        map.put("sign_type", "RSA2");
//        map.put("timestamp", dateFormatter);
//        map.put("version", "1.0");
//        map.put("notify_url", AlipayConfig.notify_url);
//        Map<String, String> m = new HashMap<String, String>();

//        m.put("body", test ? FastRandom.getRandom(10) : body);
//        m.put("subject", test ? FastRandom.getRandom(5) : subject);
//        m.put("out_trade_no", test ? FastRandom.getRandom(10) : out_trade_no);
//        m.put("timeout_express", "30m");
//        m.put("total_amount", test ? "1" : total_fee);
//        m.put("seller_id", test ? AlipayConfig.partner : apiMap.get("partnerId"));
//        m.put("product_code", "QUICK_MSECURITY_PAY");
        appPayRequest.setBizModel(model);
        appPayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //appPayRequest.setNotifyUrl("http://bblazh.tunnel.qydev.com/pay/alipay/payreturn.html");


//        JSONObject bizcontentJson = JSONObject.parseObject(JSONObject.toJSONString(m));
//
//        map.put("biz_content", bizcontentJson.toString());
//        //对未签名原始字符串进行签名
//        String rsaSign = AlipaySignature.rsaSign(AlipaySignature.getSignContent(map), test ? AlipayConfig.private_key : apiMap.get("privateKey"), "utf-8", "RSA2");
//
//        Map<String, String> map4 = new HashMap<String, String>();
//
//        map4.put("app_id", test ? AlipayConfig.app_id : apiMap.get("appId"));
//        map4.put("method", "alipay.trade.app.pay");
//        map4.put("format", "json");
//        map4.put("charset", "utf-8");
//        map4.put("sign_type", "RSA2");
//        map4.put("timestamp", dateFormatter);
//        map4.put("version", "1.0");
//        map4.put("notify_url", URLEncoder.encode(AlipayConfig.service, "UTF-8"));
//        //最后对请求字符串的所有一级value（biz_content作为一个value）进行encode，编码格式按请求串中的charset为准，没传charset按UTF-8处理
//        map4.put("biz_content", URLEncoder.encode(bizcontentJson.toString(), "UTF-8"));
//
//        Map par = AlipayCore.paraFilter(map4); //除去数组中的空值和签名参数
//        String json4 = AlipayCore.createLinkString(map4);   //拼接后的字符串
//        json4 = json4 + "&sign=" + URLEncoder.encode(rsaSign, "UTF-8");

        AlipayTradeAppPayResponse appResponse = alipayClient.sdkExecute(appPayRequest);
        String body1 = appResponse.getBody();
        return body1;
    }


    /***************
     * alipay支付开始
     **************/
    @RequestMapping("/alipay/paystart")
    public void payStart(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {

        String orderId = request.getParameter("orderId");
        HashMap<String, Object> resMap = orderPayService.queryOrdeAllByOrderId(orderId);

        OrderInfo orderInfo = (OrderInfo) resMap.get("orderInfo");
        List<OrderService> orderServices = (List<OrderService>) resMap.get("orderService");

        String subject = "服务购买";       // 标题

        String out_trade_no = request.getParameter("orderNo");  // 交易平台自动生成的 交易号
        String total_fee = orderInfo.getOrderPrice().toString();     // 费用
        String body = orderInfo.getOrderBuyer() + "," + orderId;          // 订单描述  买家 + 订单id

        if (orderInfo.getOrderState() != 2) {
            throw new Exception();
        }

        Map<String, String> apiMap = payApiService.getApiMap(orderId, 1);


        //获取商户基本配置信息
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", AlipayConfig.service);
        sParaTemp.put("partner", apiMap.get("partnerId"));
        sParaTemp.put("seller_id", apiMap.get("sellerId"));
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        sParaTemp.put("payment_type", AlipayConfig.payment_type);
        sParaTemp.put("notify_url", AlipayConfig.notify_url);
        sParaTemp.put("return_url", AlipayConfig.return_url);
        sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
        sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
        sParaTemp.put("out_trade_no", out_trade_no);
        sParaTemp.put("subject", subject);
        sParaTemp.put("total_fee", total_fee);
        sParaTemp.put("body", body);
        //}
        //其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
        //如sParaTemp.put("参数名","参数值");

        //建立请求
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "post", "确认", apiMap.get("key"));
        try {
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
            out.println("  <HEAD><meta http-equiv='Content-Type' content='text/html;charset=UTF-8'><TITLE></TITLE></HEAD>");
            out.println("  <BODY>");
            out.print(sHtmlText);
            out.println("  </BODY>");
            out.println("</HTML>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @RequestMapping("/alipay/payreturn")
    public ModelAndView payReturnForUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {  // 支付成功返回的界面

        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            if (!values[0].toString().equals("服务购买")){
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            }else {
                valueStr = values[0];
            }
            params.put(name, valueStr);
        }


        String out_trade_no = null;
        //支付宝交易号
        String trade_no = null;
        //交易状态
        String trade_status =null;
        String body =null;
        if (params.get("sign_type").equals("RSA2")){
            out_trade_no=params.get("out_trade_no");
            trade_no=params.get("trade_no");
            trade_status=params.get("trade_status");
            body=params.get("body");
        }else {
            //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
            //商户订单号
            out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
             trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //交易状态
             trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
            body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");
        }

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//

        // TODO
        OrderInfo orderInfo = new OrderInfo();
        Payinfo payinfo = new Payinfo();

        boolean verify_result=false;

        if (params.get("sign_type").equals("RSA2")){
            orderInfo = orderPayService.selectOrderInfoByOrderNo(out_trade_no); // 获取订单相关信息
            Map<String, String> apiMap = payApiService.getApiMap(orderInfo.getOrderId(), 1);
            //计算得出通知验证结果
            try {
                verify_result = AlipaySignature.rsaCheckV1(params, apiMap.get("public_key"), "UTF-8", "RSA2");
            } catch (AlipayApiException e) {
                verify_result=false;
            }
        }else {
            verify_result = AlipayNotify.verify(params);
        }




        ModelAndView mav = new ModelAndView();
        if (verify_result) {//验证成功
            //////////////////////////////////////////////////////////////////////////////////////////
            //请在这里加上商户的业务逻辑程序代码
            //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
            if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                orderInfo = orderPayService.selectOrderInfoByOrderNo(out_trade_no); // 获取订单相关信息
                Date newDate = new Date();

                //String[] strs = body.split(",");
                // 支付成功  修改当前订单的状态
                com.jero.esc.vo.saleinfo.OrderInfo orderInfoV = new com.jero.esc.vo.saleinfo.OrderInfo();
                orderInfoV.setOrderId(orderInfo.getOrderId());
                orderInfoV.setOrderState(4);  // 4 表示订单的 处于 待服务状态
                orderInfoSellerService.modifyOrderState(orderInfoV);
                // 记录当前支付 操作明细
                OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
                orderDoneDetails.setOddId(UUIDUtil.getUUID());
                orderDoneDetails.setLogId(orderInfo.getOrderBuyer());
                //将交易信息存为json数据存储
                payinfo.setLogId(orderInfo.getOrderBuyer());
                payinfo.setNonce_str("支付宝支付没有随机数");
                payinfo.setOrderId(orderInfo.getOrderId());
                payinfo.setOut_trade_no(out_trade_no);
                payinfo.setSign(params.get("sign"));
                payinfo.setTrade_type(2);
                payinfo.setTransaction_id(trade_no);
                String comment = JSONObject.toJSONString(payinfo);
                orderDoneDetails.setOddComment(comment);
                orderDoneDetails.setOddCreatetime(newDate);
                orderDoneDetails.setOddInfo(4);// 表示  支付状态    4代表  待服务
                orderDoneDetails.setOddResult("支付测试成功5");
                orderDoneDetails.setOrderId(orderInfo.getOrderId());
                orderDoneDetailsService.addOrderDoneDetail(orderDoneDetails);


                // 分别记录卖家或者买家的  相关支付信息
                //  买家    buyer
                AccontPaymentDetails buyerAccontPaymentDetails = new AccontPaymentDetails();
                buyerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
                buyerAccontPaymentDetails.setLogId(orderInfo.getOrderBuyer());
                buyerAccontPaymentDetails.setApdIotype(2);// 2表示支出  1表示收入
                buyerAccontPaymentDetails.setApdPaytype(1); // 1支付宝  ，2 微信 ， 3 银行卡
                buyerAccontPaymentDetails.setApdCreatetime(newDate);
                buyerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
                buyerAccontPaymentDetails.setApdAdminorderno(out_trade_no);
                try {
                    accountPaymentDetailsService.addAccountIODetails(buyerAccontPaymentDetails);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // 卖家  seller
						/*AccontPaymentDetails sellerAccontPaymentDetails = new AccontPaymentDetails();
						sellerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
						sellerAccontPaymentDetails.setLogId(orderInfo.getOrderSeller());
						sellerAccontPaymentDetails.setApdIotype(1);// 2表示支出  1表示收入
						sellerAccontPaymentDetails.setApdPaytype(1); // 1支付宝  ，2 微信 ， 3 银行卡
						sellerAccontPaymentDetails.setApdCreatetime(newDate);
						sellerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
						sellerAccontPaymentDetails.setApdAdminorderno(out_trade_no);
						try {accountPaymentDetailsService.addAccountIODetails(sellerAccontPaymentDetails);
						} catch (Exception e) {e.printStackTrace();}*/
                // 返回到    订单页面
                mav.addObject("status", "支付成功");
                mav.setViewName("/saleinfo/oderInfoBuyer");

            }
            //该页面可做页面美工编辑
            //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

            //////////////////////////////////////////////////////////////////////////////////////////
        } else {
            //该页面可做页面美工编辑
            mav.addObject("status", "支付失败");
            mav.setViewName("/saleinfo/oderInfoBuyer");
            return mav;
        }

        return mav;


    }


    @RequestMapping("/alipay/paynotify")
    public void payNotifyForUser(HttpServletRequest request, HttpServletResponse response) { //  只需要记录支付状态以及结果

        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        String out_trade_no = "";
        //交易状态
        String trade_status = "";
        String subject = "";
        String total_fee = "";
        String body = "";
        try {

            String trade_no = null;
            if (params.get("sign_type").equals("RSA2")) {
                out_trade_no = params.get("out_trade_no");
                trade_no = params.get("trade_no");
                trade_status = params.get("trade_status");
                subject = params.get("subject");
                total_fee = params.get("total_fee");
                body = params.get("body");
            } else {
                out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
                //支付宝交易号
                trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
                trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
                subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"), "UTF-8");
                total_fee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"), "UTF-8");
                body = new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");
            }
            // TODO
            OrderInfo orderInfo = new OrderInfo();
            Payinfo payinfo = new Payinfo();

            boolean verify_result=false;

            if (params.get("sign_type").equals("RSA2")){
                orderInfo = orderPayService.selectOrderInfoByOrderNo(out_trade_no); // 获取订单相关信息
                Map<String, String> apiMap = payApiService.getApiMap(orderInfo.getOrderId(), 1);
                //计算得出通知验证结果
                try {
                    verify_result = AlipaySignature.rsaCheckV1(params, apiMap.get("public_key"), "UTF-8", "RSA2");
                } catch (AlipayApiException e) {
                    verify_result=false;
                }
            }else {
                verify_result = AlipayNotify.verify(params);
            }


            if (verify_result) {//验证成功
                //////////////////////////////////////////////////////////////////////////////////////////
                //请在这里加上商户的业务逻辑程序代码
                //——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
                if (trade_status.equals("TRADE_FINISHED")) {
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                    //如果有做过处理，不执行商户的业务程序
							/*System.out.println("..............................."+out_trade_no+"........TRADE_FINISHED............................");
							System.out.println("..............................."+trade_no+"....................................");
							System.out.println("..............................."+trade_status+"....................................");
							System.out.println("..............................."+subject+"....................................");
							System.out.println("..............................."+total_fee+"....................................");
							System.out.println("..............................."+body+"....................................");*/
                    //注意：
                    //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                    orderInfo = orderPayService.selectOrderInfoByOrderNo(out_trade_no); // 获取订单相关信息
                    if (orderInfo.getOrderState() == 2) {
                        Date newDate = new Date();

                        //String[] strs = body.split(",");
                        // 支付成功  修改当前订单的状态
                        com.jero.esc.vo.saleinfo.OrderInfo orderInfoV = new com.jero.esc.vo.saleinfo.OrderInfo();
                        orderInfoV.setOrderId(orderInfo.getOrderId());
                        orderInfoV.setOrderState(4);  // 4 表示订单的 处于 待服务状态
                        orderInfoSellerService.modifyOrderState(orderInfoV);
                        // 记录当前支付 操作明细
                        OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
                        orderDoneDetails.setOddId(UUIDUtil.getUUID());
                        orderDoneDetails.setLogId(orderInfo.getOrderBuyer());
                        //将交易信息存为json数据存储
                        payinfo.setLogId(orderInfo.getOrderBuyer());
                        payinfo.setNonce_str("支付宝支付没有随机数");
                        payinfo.setOrderId(orderInfo.getOrderId());
                        payinfo.setOut_trade_no(out_trade_no);
                        payinfo.setSign(params.get("sign"));
                        payinfo.setTrade_type(2);
                        payinfo.setTransaction_id(trade_no);
                        String comment = JSONObject.toJSONString(payinfo);
                        orderDoneDetails.setOddComment(comment);
                        orderDoneDetails.setOddCreatetime(newDate);
                        orderDoneDetails.setOddInfo(4);// 表示  支付状态    4代表  待服务
                        orderDoneDetails.setOddResult("支付测试成功5");
                        orderDoneDetails.setOrderId(orderInfo.getOrderId());
                        orderDoneDetailsService.addOrderDoneDetail(orderDoneDetails);


                        // 分别记录卖家或者买家的  相关支付信息
                        //  买家    buyer
                        AccontPaymentDetails buyerAccontPaymentDetails = new AccontPaymentDetails();
                        buyerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
                        buyerAccontPaymentDetails.setLogId(orderInfo.getOrderBuyer());
                        buyerAccontPaymentDetails.setApdIotype(2);// 2表示支出  1表示收入
                        buyerAccontPaymentDetails.setApdPaytype(1); // 1支付宝  ，2 微信 ， 3 银行卡
                        buyerAccontPaymentDetails.setApdCreatetime(newDate);
                        buyerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
                        buyerAccontPaymentDetails.setApdAdminorderno(out_trade_no);
                        try {
                            accountPaymentDetailsService.addAccountIODetails(buyerAccontPaymentDetails);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else if (orderInfo.getOrderState() == 4) {
                        System.out.println("已支付");
                        response.getWriter().print("success");
                    }
                } else if (trade_status.equals("TRADE_SUCCESS")) {
                    //判断该笔订单是否在商户网站中已经做过处理
                    //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                    //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                    //如果有做过处理，不执行商户的业务程序
							/*System.out.println("..............................."+out_trade_no+"........TRADE_SUCCESS............................");
							System.out.println("..............................."+trade_no+"....................................");
							System.out.println("..............................."+trade_status+"....................................");
							System.out.println("..............................."+subject+"....................................");
							System.out.println("..............................."+total_fee+"....................................");
							System.out.println("..............................."+body+"....................................");*/
                    //注意：
                    //付款完成后，支付宝系统发送该交易状态通知

                    orderInfo = orderPayService.selectOrderInfoByOrderNo(out_trade_no); // 获取订单相关信息
                    Date newDate = new Date();

                    //String[] strs = body.split(",");
                    // 支付成功  修改当前订单的状态
                    com.jero.esc.vo.saleinfo.OrderInfo orderInfoV = new com.jero.esc.vo.saleinfo.OrderInfo();
                    orderInfoV.setOrderId(orderInfo.getOrderId());
                    orderInfoV.setOrderState(4);  // 4 表示订单的 处于 待服务状态
                    orderInfoSellerService.modifyOrderState(orderInfoV);
                    // 记录当前支付 操作明细
                    OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
                    orderDoneDetails.setOddId(UUIDUtil.getUUID());
                    orderDoneDetails.setLogId(orderInfo.getOrderBuyer());
                    //将交易信息存为json数据存储
                    payinfo.setLogId(orderInfo.getOrderBuyer());
                    payinfo.setNonce_str("支付宝支付没有随机数");
                    payinfo.setOrderId(orderInfo.getOrderId());
                    payinfo.setOut_trade_no(out_trade_no);
                    payinfo.setSign(params.get("sign"));
                    payinfo.setTrade_type(2);
                    payinfo.setTransaction_id(trade_no);
                    String comment = JSONObject.toJSONString(payinfo);
                    orderDoneDetails.setOddComment(comment);
                    orderDoneDetails.setOddCreatetime(newDate);
                    orderDoneDetails.setOddInfo(4);// 表示  支付状态    4代表  待服务
                    orderDoneDetails.setOddResult("支付测试成功5");
                    orderDoneDetails.setOrderId(orderInfo.getOrderId());
                    orderDoneDetailsService.addOrderDoneDetail(orderDoneDetails);


                    // 分别记录卖家或者买家的  相关支付信息
                    //  买家    buyer
                    AccontPaymentDetails buyerAccontPaymentDetails = new AccontPaymentDetails();
                    buyerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
                    buyerAccontPaymentDetails.setLogId(orderInfo.getOrderBuyer());
                    buyerAccontPaymentDetails.setApdIotype(2);// 2表示支出  1表示收入
                    buyerAccontPaymentDetails.setApdPaytype(1); // 1支付宝  ，2 微信 ， 3 银行卡
                    buyerAccontPaymentDetails.setApdCreatetime(newDate);
                    buyerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
                    buyerAccontPaymentDetails.setApdAdminorderno(out_trade_no);
                    try {
                        accountPaymentDetailsService.addAccountIODetails(buyerAccontPaymentDetails);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // 卖家  seller
						/*AccontPaymentDetails sellerAccontPaymentDetails = new AccontPaymentDetails();
						sellerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
						sellerAccontPaymentDetails.setLogId(orderInfo.getOrderSeller());
						sellerAccontPaymentDetails.setApdIotype(1);// 2表示支出  1表示收入
						sellerAccontPaymentDetails.setApdPaytype(1); // 1支付宝  ，2 微信 ， 3 银行卡
						sellerAccontPaymentDetails.setApdCreatetime(newDate);
						sellerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
						sellerAccontPaymentDetails.setApdAdminorderno(out_trade_no);
						try {accountPaymentDetailsService.addAccountIODetails(sellerAccontPaymentDetails);
						} catch (Exception e) {e.printStackTrace();}*/
                    // 返回到    订单页面

                    //——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
                    response.getWriter().print("success");    //请不要修改或删除
                    //////////////////////////////////////////////////////////////////////////////////////////

                }
            } else {//验证失败
                response.getWriter().print("fail");
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*************** alipay支付结束 **************/


    /***************
     * 京东支付开始
     *****************/
    @RequestMapping("/jdpay/paystart")
    public void jdPayStart(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception {
        String orderId = request.getParameter("orderId");
        String v_oid = request.getParameter("orderNo");
        String bank_no = request.getParameter("bankNo");

        // 处理基本信息
        Date currTime = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd-" + JdpayConfig.v_mid + "-hhmmss", Locale.US);
        v_oid = sf.format(currTime);

        // 根据 订单ID查询相关信息
        HashMap<String, Object> resMap = orderPayService.queryOrdeAllByOrderId(orderId);
        OrderInfo orderInfo = (OrderInfo) resMap.get("orderInfo");

        String v_amount = orderInfo.getOrderPrice().toString();     // 费用


        if (orderInfo.getOrderState() != 2) {
            throw new Exception();
        }

        //获取商户基本配置信息
        String companyId = getModule(session);
        PayApi payApi = new PayApi();
        payApi.setCompId(companyId);
        payApi.setPayType(2);
        List<PayApi> lpa = payApiService.queryByCon(payApi);
        OrderReq orderReq = null;
        Map<String, String> sParaTemp = new HashMap<String, String>();
        if (lpa.size() > 0) {
            JSONObject jot = lpa.get(0).getPayObj();
            //  根据查询到的信息拼接响应的 京东支付的 map集合
            sParaTemp.put("v_mid", jot.getString("v_mid")); //商户编号
            sParaTemp.put("v_oid", v_oid); // 订单号
            sParaTemp.put("v_amount", v_amount); // 订单金额
            sParaTemp.put("v_url", JdpayConfig.v_url); // 完成支付的 返回页面  returnURL
            sParaTemp.put("remark2", jot.getString("remark2")); // 完成支付的通知页面  notifyURL
            sParaTemp.put("v_moneytype", JdpayConfig.v_moneytype); // 支付币种
            sParaTemp.put("pmode_id", bank_no); // 网银在线定义的银行编码
            sParaTemp.put("remark1", orderInfo.getOrderBuyer() + "-" + orderId); // 备用传值参数
            // 拼接加密信息
            String text = v_amount + JdpayConfig.v_moneytype + jot.getString("v_mid") + JdpayConfig.v_url + jot.getString("key");
            String v_md5info = new MD5().getMD5ofStr(text);
            sParaTemp.put("v_md5info", v_md5info); // 执行验证的sign
        } else {
            //  根据查询到的信息拼接响应的 京东支付的 map集合
            sParaTemp.put("v_mid", JdpayConfig.v_mid); //商户编号
            sParaTemp.put("v_oid", v_oid); // 订单号
            sParaTemp.put("v_amount", v_amount); // 订单金额
            sParaTemp.put("v_url", JdpayConfig.v_url); // 完成支付的 返回页面  returnURL
            sParaTemp.put("remark2", JdpayConfig.remark2); // 完成支付的通知页面  notifyURL
            sParaTemp.put("v_moneytype", JdpayConfig.v_moneytype); // 支付币种
            sParaTemp.put("pmode_id", bank_no); // 网银在线定义的银行编码
            sParaTemp.put("remark1", orderInfo.getOrderBuyer() + "-" + orderId); // 备用传值参数
            // 拼接加密信息
            String text = v_amount + JdpayConfig.v_moneytype + v_oid + JdpayConfig.v_mid + JdpayConfig.v_url + JdpayConfig.key;
            String v_md5info = new MD5().getMD5ofStr(text);
            sParaTemp.put("v_md5info", v_md5info); // 执行验证的sign
        }


        //建立请求
        String sHtmlText = JdpaySubmit.buildRequest(sParaTemp, "post", "确认");
        try {
            PrintWriter out = response.getWriter();
            out.println("<HTML>");
            out.println("  <HEAD><meta http-equiv='Content-Type' content='text/html;charset=UTF-8'><TITLE></TITLE></HEAD>");
            out.println("  <BODY>");
            out.print(sHtmlText);
            out.println("  </BODY>");
            out.println("</HTML>");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @RequestMapping("/jdpay/payreturn")
    public ModelAndView jdPayReturn(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        // 获取jd传递过来的参数
        String v_oid = request.getParameter("v_oid");        // 订单号
        String v_pmode = request.getParameter("v_pmode");        // 支付方式中文说明，如"中行长城信用卡"
        String v_pstatus = request.getParameter("v_pstatus");    // 支付结果，20支付完成；30支付失败；
        String v_pstring = request.getParameter("v_pstring");    // 对支付结果的说明，成功时（v_pstatus=20）为"支付成功"，支付失败时（v_pstatus=30）为"支付失败"
        String v_amount = request.getParameter("v_amount");        // 订单实际支付金额
        String v_moneytype = request.getParameter("v_moneytype");    // 币种
        String v_md5str = request.getParameter("v_md5str");        // MD5校验码
        String remark1 = request.getParameter("remark1");        // 备注1
        String remark2 = request.getParameter("remark2");        // 备注2

        String text = v_oid + v_pstatus + v_amount + v_moneytype + JdpayConfig.key;
        String v_md5text = new MD5().getMD5ofStr(text).toUpperCase();

        Payinfo payinfo = new Payinfo();
        OrderInfo orderInfo = new OrderInfo();
        if (v_md5str.equals(v_md5text)) {
            if ("30".equals(v_pstatus)) {
                mav.addObject("status", "fail");
            } else if ("20".equals(v_pstatus)) {
                // 支付成功，商户 根据自己业务做相应逻辑处理
                // 此处加入商户系统的逻辑处理（例如判断金额，判断支付状态，更新订单状态等等）......
                System.out.println("此处加入商户系统的逻辑处理（例如判断金额，判断支付状态，更新订单状态等等）......支付成功");

                orderInfo = orderPayService.selectOrderInfoByOrderNo(v_oid); // 获取订单相关信息
                Date newDate = new Date();

                String[] strs = remark1.split("-");
                // 支付成功  修改当前订单的状态
                com.jero.esc.vo.saleinfo.OrderInfo orderInfoV = new com.jero.esc.vo.saleinfo.OrderInfo();
                orderInfoV.setOrderId(strs[1]);
                orderInfoV.setOrderState(4);
                orderInfoSellerService.modifyOrderState(orderInfoV);
                // 记录当前支付 操作明细
                OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
                orderDoneDetails.setOddId(UUIDUtil.getUUID());
                orderDoneDetails.setLogId(strs[0]);

                //将交易信息存为json数据存储
                payinfo.setLogId(orderInfo.getOrderBuyer());
                payinfo.setNonce_str("支付宝支付没有随机数");
                payinfo.setOrderId(orderInfo.getOrderId());
                payinfo.setOut_trade_no(v_oid);
                payinfo.setSign(v_md5str);
                payinfo.setTrade_type(2);
                payinfo.setTransaction_id(v_oid); // 京东支付  返回的交易号 跟平台订单号一致
                String comment = JSONObject.toJSONString(payinfo);
                orderDoneDetails.setOddComment(comment);
                orderDoneDetails.setOddCreatetime(new Date());
                orderDoneDetails.setOddInfo(4);// 表示  支付状态    4代表  待服务
                orderDoneDetails.setOddResult("支付测试成功jd");
                orderDoneDetails.setOrderId(strs[1]);
                orderDoneDetailsService.addOrderDoneDetail(orderDoneDetails);


                // 分别记录卖家或者买家的  相关支付信息
                //  买家    buyer
                AccontPaymentDetails buyerAccontPaymentDetails = new AccontPaymentDetails();
                buyerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
                buyerAccontPaymentDetails.setLogId(orderInfo.getOrderBuyer());
                buyerAccontPaymentDetails.setApdIotype(2);// 2表示支出  1表示收入
                buyerAccontPaymentDetails.setApdPaytype(3); // 1支付宝  ，2 微信 ， 3 银行卡
                buyerAccontPaymentDetails.setApdCreatetime(newDate);
                buyerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
                buyerAccontPaymentDetails.setApdAdminorderno(v_oid);
                try {
                    accountPaymentDetailsService.addAccountIODetails(buyerAccontPaymentDetails);
                } catch (Exception e) {
                    e.printStackTrace();
                }
				
			/*	// 卖家  seller
				AccontPaymentDetails sellerAccontPaymentDetails = new AccontPaymentDetails();
				sellerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
				sellerAccontPaymentDetails.setLogId(orderInfo.getOrderSeller());
				sellerAccontPaymentDetails.setApdIotype(1);// 2表示支出  1表示收入
				sellerAccontPaymentDetails.setApdPaytype(3); // 1支付宝  ，2 微信 ， 3 银行卡
				sellerAccontPaymentDetails.setApdCreatetime(newDate);
				sellerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
				sellerAccontPaymentDetails.setApdAdminorderno(v_oid);
				try {accountPaymentDetailsService.addAccountIODetails(sellerAccontPaymentDetails);
				} catch (Exception e) {e.printStackTrace();}*/

            }
        } else {
            mav.addObject("status", "sucess");
        }

        mav.setViewName("/saleinfo/oderInfoBuyer");

        return mav;

    }

    @RequestMapping("/jdpay/paynotify")
    public void jdPayNotify(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("......................................这里是jd的通知处理程序....................................");
        //获取参数
        String v_oid = request.getParameter("v_oid");        // 订单号
        String v_pmode = request.getParameter("v_pmode");        // 支付方式中文说明，如"中行长城信用卡"
        String v_pstatus = request.getParameter("v_pstatus");    // 支付结果，20支付完成；30支付失败；
        String v_pstring = request.getParameter("v_pstring");    // 对支付结果的说明，成功时（v_pstatus=20）为"支付成功"，支付失败时（v_pstatus=30）为"支付失败"
        String v_amount = request.getParameter("v_amount");        // 订单实际支付金额
        String v_moneytype = request.getParameter("v_moneytype");    // 币种
        String v_md5str = request.getParameter("v_md5str");        // MD5校验码
        String remark1 = request.getParameter("remark1");        // 备注1
        String remark2 = request.getParameter("remark2");        // 备注2


        String text = v_oid + v_pstatus + v_amount + v_moneytype + JdpayConfig.key; //拼凑加密串
        String v_md5text = new MD5().getMD5ofStr(text).toUpperCase();
        try {
            if (v_md5str.equals(v_md5text)) {
                response.getWriter().print("ok");
                // 告诉服务器验证通过,停止发送

                if ("20".equals(v_pstatus)) {
                    // 支付成功，商户 根据自己业务做相应逻辑处理
                    // 此处加入商户系统的逻辑处理（例如判断金额，判断支付状态(20成功,30失败)，更新订单状态等等）......
                    System.out.println(" 此处加入商户系统的逻辑处理（例如判断金额，判断支付状态(20成功,30失败)，更新订单状态等等）......");
                }

            } else {
                response.getWriter().print("error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*************** 京东支付结束 *****************/
}
