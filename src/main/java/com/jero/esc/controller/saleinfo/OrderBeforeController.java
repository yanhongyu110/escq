package com.jero.esc.controller.saleinfo;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.ConstUtil;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.utils.fastvalidate.FastValidate;
import com.jero.esc.common.utils.fastvalidate.ValidateResult;
import com.jero.esc.mapper.details.MegDetailsMapper;
import com.jero.esc.mapper.goodsinfo.ServiceInfoMapper;
import com.jero.esc.mapper.saleinfo.OrderInfoMapper;
import com.jero.esc.mapper.system.SystemMegsMapper;
import com.jero.esc.po.details.MegDetails;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.saleinfo.OrderInfo;
import com.jero.esc.po.system.SystemMegs;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.goodsinfo.IServiceService;
import com.jero.esc.service.saleinfo.IOrderBeforeService;
import com.jero.esc.service.saleinfo.IOrderInfoBuyerService;



@Controller
@RequestMapping("/saleinfo")
public class OrderBeforeController extends BaseController {
	@Autowired
	private SystemMegsMapper systemMegsMapper;
	@Autowired
	private MegDetailsMapper megDetailsMapper;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    IOrderBeforeService orderService;

    @Autowired
    OrderInfoMapper orderInfoMapper;
    
    @Autowired
    IOrderInfoBuyerService orderbuyservice;

    @Autowired
    ServiceInfoMapper serviceInfoMapper;

    /**
     * 转跳添加订单页面(购物车)
     *
     * @return
     */
    @RequestMapping("/order/viewAddOrder")
    public ModelAndView viewAddOrder(HttpSession session, @RequestParam("cartList")String cartList) throws Exception {
    	

        if (isValidate) {
            if (FastValid.isEmp(cartList))
                throw new ExceptionWithMessage("参数错误");
        }

        List<ServiceCart> serviceCarts = JSONArray.parseArray(cartList, ServiceCart.class);
        orderService.flashMaker(serviceCarts);

        for (ServiceCart serviceCart : serviceCarts) {
            if (retrievalCurrentUserInfo(session).getLogId().equals(serviceCart.getLogId())){
                throw  new Exception();
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", serviceCarts);
        modelAndView.setViewName("saleinfo/appointment");
        return modelAndView;
    }
    
    
    
    /**
     * 用户修改订单页面
     *
     * @return
     */
    @RequestMapping("/order/viewEditOrder")
    public ModelAndView viewEditOrder(HttpSession session, @RequestParam("orderNo")String orderNo) throws Exception {
    	
        if (isValidate) {
            if (FastValid.isEmp(orderNo))
                throw new ExceptionWithMessage("参数错误");
        }
        com.jero.esc.vo.saleinfo.OrderInfo orderInfo = orderbuyservice.selectById(orderNo);

        String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
        JSONArray parseArray = JSONArray.parseArray(orderInfo.getOrderRequest());//消息描述
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderState",orderState);
        modelAndView.addObject("parseArray",parseArray);
        modelAndView.addObject("obj",orderInfo);
        modelAndView.setViewName("saleinfo/appointmentedit");
        return modelAndView;
    }

    
    //endregion
    
    //region 添加订单
    /**
     * 添加订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/addOrder", produces = "text/html;charset=UTF-8")
    @NoRepeatRequest
    public String addOrder(HttpSession session, @RequestParam("cartList") String cartList, @RequestParam("orderJson") String orderJson) throws Exception {

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm";
        OrderInfo orderInfo = JSON.parseObject(orderJson, OrderInfo.class);
        List<ServiceCart> serviceCarts = JSON.parseArray(cartList, ServiceCart.class);


        if (HtmlFilter.filter(orderInfo)){
            return  new JsonResult("不能填写html").toJSON();
        }


        orderInfo.setOrderBuyer(retrievalCurrentUserInfo(session).getLogId());
        //得到卖家
        orderInfo.setOrderSeller(serviceInfoMapper.selectByPrimaryKey(serviceCarts.get(0).getServiceId()).getLogId());
        
        //问题描述JSON转换
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("type", 0);//标识是买家还是买家,0 买家,1 卖家
        map.put("sendId","aaaa");
        //map.put("sendId",retrievalCurrentUserInfo(session).getLogId());
        map.put("time", new Date());
        map.put("content", orderInfo.getOrderRequest());
        System.out.println(JSON.toJSONString(map));
        orderInfo.setOrderRequest("["+JSON.toJSONString(map)+"]");//封装成json数组
        
        try {
            orderService.addOrderFromCart(orderInfo, serviceCarts);
        } catch (ExceptionWithMessage exceptionWithMessage) {
        	exceptionWithMessage.printStackTrace();
            return exceptionWithMessage.jsonResult.toJSON();
        } catch (Exception e) {
        	e.printStackTrace();
            return new JsonResult("错误").toJSON();
        }

		try {
			LogInfo logInfo = retrievalCurrentUserInfo(session);
			ServiceInfo serviceInfo = serviceService.queryByPrimaryKey(serviceCarts.get(0).getServiceId());
			SystemMegs sm = new SystemMegs();
			sm.setSmId(UUIDUtil.getUUID());
			sm.setSmCreatetime(new Date());
			sm.setSmIsdelete(false);
			sm.setSmType(1);
			sm.setSmTitle("平台消息");
			sm.setSmContent(logInfo.getLogName() + "预约了服务\""+serviceInfo.getServiceTitle()+"\",快去看看吧!!");
			MegDetails md = new MegDetails();
			md.setMdId(UUIDUtil.getUUID());
			md.setMdCreatetime(new Date());
			md.setMdIsdelete(false);
			md.setLogId(serviceInfo.getLogId());
			md.setSmId(sm.getSmId());
			md.setOperatorId(logInfo.getLogId());
			md.setOperatorType(logInfo.getLogType());
			md.setMdType(4);
			systemMegsMapper.insert(sm);
			megDetailsMapper.insert(md);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return new JsonResult(true, "提交订单成功!", "/saleinfo/orderInfoBuyer/orderView.html").toJSON();

    }

    @ResponseBody
    @RequestMapping(value = "/order/cancelOrder", produces = "text/html;charset=UTF-8")
    @NoRepeatRequest
    public String cancelOrder(HttpSession session,String orderNo) {
    	Boolean flag = null;
        try {
        	flag = orderService.cancelOrder(orderNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(flag){
        	return new JsonResult(true, "取消成功", null).toJSON();
        }
        return new JsonResult(false, "取消失败", null).toJSON();
    }

    /**
     * 显示专家确认页面
     *
     * @param session
     * @return
     */
    @RequestMapping("/order/viewProviderConfirm")
    public ModelAndView viewProviderConfirm(HttpSession session,@RequestParam("orderNo")String orderNo) {
    	  ModelAndView modelAndView = new ModelAndView();
          // TODO: 2016/12/13    	  
          com.jero.esc.vo.saleinfo.OrderInfo orderInfo = orderbuyservice.selectById(orderNo);
          String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
          JSONArray parseArray = JSONArray.parseArray(orderInfo.getOrderRequest());//消息描述
          modelAndView.addObject("orderState",orderState);
          modelAndView.addObject("parseArray",parseArray);
          modelAndView.addObject("obj",orderInfo);
          modelAndView.setViewName("saleinfo/appointmentconfirm");
          return modelAndView;
    }

    /**
     * 用户修改订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/userModifyOrder",produces = "text/html;charset=UTF-8")
    @NoRepeatRequest
    public String userModifyOrder(HttpSession session, @RequestParam("order") String order) throws IllegalAccessException {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        OrderInfo orderInfo = JSONObject.parseObject(order, OrderInfo.class);
        if (HtmlFilter.filter(orderInfo)){
            return  new JsonResult("不能填写html").toJSON();
        }

        try {
            orderService.modifyByOrder(orderInfo);
        } catch (ExceptionWithMessage e) {
        	e.printStackTrace();
            return e.jsonResult.toJSON();
        } catch (Exception e) {
            return new JsonResult(false, "添加失败", null).toJSON();
        }
        // TODO: 2016/12/8
        return new JsonResult(true, "添加成功!", "/saleinfo/orderInfoBuyer/orderView.html").toJSON();
    }

    /**
     * 服务商修改订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/providerModifyOrder")
    @NoRepeatRequest
    public String providerModifyOrder(HttpSession session, @RequestParam("order") String order) throws IllegalAccessException {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        OrderInfo orderInfo = JSONObject.parseObject(order, OrderInfo.class);
        if (HtmlFilter.filter(orderInfo)){
            return  new JsonResult("不能填写html").toJSON();
        }

        try {
            orderService.modifyByOrder(orderInfo);
        } catch (ExceptionWithMessage e) {
            return e.jsonResult.toJSON();
        } catch (Exception e) {
            return new JsonResult(false, "添加失败", null).toJSON();
        }
        // TODO: 2016/12/8
        return "";
    }
    //endregion

    //region 查询订单
    /**
     * 查询订单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/queryOrder", produces = "text/html;charset=UTF-8")
    public String queryOrder(@RequestParam("order") String json, @RequestParam(value = "require", required = false) String require) throws IllegalAccessException {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        OrderInfo orderInfo = JSONObject.parseObject(json, OrderInfo.class);

        try {
            orderService.queryOrderByRequire(orderInfo, JSONObject.parseObject(require, Map.class));
        } catch (ExceptionWithMessage e) {
            return e.jsonResult.toJSON();
        } catch (Exception e) {
            return new JsonResult(false, "添加失败", null).toJSON();
        }

        // TODO: 2016/12/8
        return "{url:''}";
    }
    //endregion

    @Test
    @RequestMapping("/ss")
    public void ss() throws Exception {
        long time = new Date().getTime();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo("213123");
        orderInfo.setOrderSeller("sdasdas");
        orderInfo.setOrderBuyer("sadasd");
        orderInfo.setOrderRequest("sasaasas");
        FastValidate<OrderInfo> orderInfoFastValidate = new FastValidate<OrderInfo>(orderInfo);
        orderInfoFastValidate.setReqiureList("orderId", false);
        ValidateResult<OrderInfo> orderInfoValidateResult = orderInfoFastValidate.validateObject(true);
        System.out.println(new Date().getTime() - time);
        System.out.println(orderInfoValidateResult.validate);
        orderInfoValidateResult.printAllMeassage();

    }

    //region 服务商确认
    /**
     * 服务商确认
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/provideCheck", produces = "text/html;charset=UTF-8")
    @NoRepeatRequest
    public String provideCheck(@RequestParam("order") String json) throws IllegalAccessException {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        OrderInfo orderInfo = JSONObject.parseObject(json, OrderInfo.class);
        if (HtmlFilter.filter(orderInfo)){
            return  new JsonResult("不能填写html").toJSON();
        }
        try {
            orderService.providerCheck(orderInfo);
        } catch (ExceptionWithMessage e) {
            return e.jsonResult.toJSON();
        } catch (Exception e) {
            return new JsonResult(false, "添加失败", null).toJSON();
        }
        
        // TODO: 2016/12/8
        return new JsonResult(true, "添加成功!", "/saleinfo/orderInfoSeller/viewOrder.html").toJSON();
    }
    //endregion


}