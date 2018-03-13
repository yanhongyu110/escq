package com.jero.esc.controller.appapi.saleinfo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.ConstUtil;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.mapper.goodsinfo.ServiceInfoMapper;
import com.jero.esc.mapper.saleinfo.OrderInfoMapper;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.saleinfo.OrderInfo;
import com.jero.esc.service.saleinfo.IOrderBeforeService;
import com.jero.esc.service.saleinfo.IOrderInfoBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("appOrderBeforeController")
@RequestMapping("/appapi/saleinfo")
public class OrderBeforeController extends AppBaseController {

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
     * @param cartList 创建订单的字符串
     */
    @ResponseBody
    @RequestMapping(value = "/order/viewAddOrder",method = RequestMethod.POST)
    public AppJsonResult viewAddOrder(String cartList) throws Exception {
        if (FastValid.isEmp(cartList))return  AppJsonResult.error("参数错误");
        List<ServiceCart> serviceCarts = JSONArray.parseArray(cartList, ServiceCart.class);
        orderService.flashMaker(serviceCarts);
        for (ServiceCart serviceCart : serviceCarts) {
            if (logId().equals(serviceCart.getLogId())) {
                return  AppJsonResult.error("失败");
            }
        }
        return  AppJsonResult.success(serviceCarts);
    }


    /**
     * 用户修改订单页面
     * @param orderNo  修改订单的json字符
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/order/viewEditOrder",method = RequestMethod.POST)
    public AppJsonResult viewEditOrder(String orderNo) throws Exception {
        if (FastValid.isEmp(orderNo)) return  AppJsonResult.error("参数错误");
        com.jero.esc.vo.saleinfo.OrderInfo orderInfo = orderbuyservice.selectById(orderNo);
        String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
        JSONArray parseArray = JSONArray.parseArray(orderInfo.getOrderRequest());//消息描述
        HashMap hashMap = new HashMap();
        hashMap.put("orderState", orderState);
        hashMap.put("parseArray", parseArray);
        hashMap.put("orderInfo", orderInfo);
        return  AppJsonResult.success(hashMap);
    }


    /**
     *  取消订单
     * @param orderNo 取消订单的订单号
     * @return
     */
    @NoRepeatRequest
    @ResponseBody
    @RequestMapping(value = "/order/cancelOrder",method = RequestMethod.POST)
    public  AppJsonResult cancelOrder(String orderNo) {
        Boolean flag = null;
        try {
            flag = orderService.cancelOrder(orderNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag) {
            return AppJsonResult.formJsonResult(new JsonResult(true, "取消成功", null));
        }
        return AppJsonResult.formJsonResult( new JsonResult(false, "取消失败", null));
    }


    /**
     * 添加订单
     * @param cartList
     *
     */
    @NoRepeatRequest
    @ResponseBody
    @RequestMapping(value = "/order/addOrder",method = RequestMethod.POST)
    public AppJsonResult addOrder( String cartList, String orderJson) throws Exception {

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm";
        OrderInfo orderInfo = JSON.parseObject(orderJson, OrderInfo.class);
        List<ServiceCart> serviceCarts = JSON.parseArray(cartList, ServiceCart.class);


        if (HtmlFilter.filter(orderInfo)) return  AppJsonResult.error("不能填写html");

        orderInfo.setOrderBuyer(logId());
        //得到卖家
        orderInfo.setOrderSeller(serviceInfoMapper.selectByPrimaryKey(serviceCarts.get(0).getServiceId()).getLogId());

        //问题描述JSON转换
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", 0);//标识是买家还是买家,0 买家,1 卖家
        map.put("sendId", "aaaa");
        //map.put("sendId",retrievalCurrentUserInfo(session).getLogId());
        map.put("time", new Date());
        map.put("content", orderInfo.getOrderRequest());
        System.out.println(JSON.toJSONString(map));
        orderInfo.setOrderRequest("[" + JSON.toJSONString(map) + "]");//封装成json数组

        try {
            orderService.addOrderFromCart(orderInfo, serviceCarts);
        } catch (ExceptionWithMessage exceptionWithMessage) {
            exceptionWithMessage.printStackTrace();
            return  AppJsonResult.formJsonResult(exceptionWithMessage.jsonResult);
        } catch (Exception e) {
            e.printStackTrace();
            return AppJsonResult.formJsonResult(new JsonResult("错误"));
        }
        return  AppJsonResult.success("成功");
    }

    /**
     * 显示专家确认页面
     * @param orderNo 订单号
     */
    @ResponseBody
    @RequestMapping(value = "/order/viewProviderConfirm",method = RequestMethod.POST)
    public AppJsonResult viewProviderConfirm(String orderNo) {

        com.jero.esc.vo.saleinfo.OrderInfo orderInfo = orderbuyservice.selectById(orderNo);
        String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
        JSONArray parseArray = JSONArray.parseArray(orderInfo.getOrderRequest());//消息描述
        HashMap hashMap = new HashMap();

        hashMap.put("orderState", orderState);
        hashMap.put("parseArray", parseArray);
        hashMap.put("orderInfo", orderInfo);
        return  AppJsonResult.success(hashMap);
    }


    /**
     * 用户修改订单
     * @param order  订单信息order
     */
    @NoRepeatRequest
    @ResponseBody
    @RequestMapping(value = "/order/userModifyOrder", method = RequestMethod.POST)
    public AppJsonResult userModifyOrder(String order) throws IllegalAccessException {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        OrderInfo orderInfo = JSONObject.parseObject(order, OrderInfo.class);
        if (HtmlFilter.filter(orderInfo)) return AppJsonResult.formJsonResult( new JsonResult("不能填写html"));


        try {
            orderService.modifyByOrder(orderInfo);
        } catch (ExceptionWithMessage e) {
            e.printStackTrace();
            return AppJsonResult.formJsonResult( e.jsonResult);
        } catch (Exception e) {
            return AppJsonResult.formJsonResult( new JsonResult(false, "添加失败", null));
        }
        return  AppJsonResult.success("成功");
    }

    /**
     * 服务商修改订单
     * @param order 订单json
     */
    @NoRepeatRequest
    @ResponseBody
    @RequestMapping(value = "/order/providerModifyOrder",method = RequestMethod.POST)
    public AppJsonResult providerModifyOrder(String order) throws IllegalAccessException {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        OrderInfo orderInfo = JSONObject.parseObject(order, OrderInfo.class);
        if (HtmlFilter.filter(orderInfo)) return AppJsonResult.formJsonResult( new JsonResult("不能填写html"));
        try {
            orderService.modifyByOrder(orderInfo);
        } catch (ExceptionWithMessage e) {
            return AppJsonResult.formJsonResult( e.jsonResult);
        } catch (Exception e) {
            return AppJsonResult.formJsonResult( new JsonResult(false, "添加失败", null));
        }
        return  AppJsonResult.success();
    }

    /**
     * 查询订单
     * @param json 订单json
     * @param require 要切
     */
    @ResponseBody
    @RequestMapping(value = "/order/queryOrder", method = RequestMethod.POST)
    public AppJsonResult queryOrder(String json,String require) throws IllegalAccessException {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        OrderInfo orderInfo = JSONObject.parseObject(json, OrderInfo.class);
        try {
            orderService.queryOrderByRequire(orderInfo, JSONObject.parseObject(require, Map.class));
        } catch (ExceptionWithMessage e) {
            return AppJsonResult.formJsonResult( e.jsonResult);
        } catch (Exception e) {
            return AppJsonResult.formJsonResult( new JsonResult(false, "添加失败", null));
        }
        return  AppJsonResult.success();
    }



    /**
     * 服务商确认
     * @param json 订单信息
     * @return
     */
    @NoRepeatRequest
    @ResponseBody
    @RequestMapping(value = "/order/provideCheck", method = RequestMethod.POST)
    public AppJsonResult provideCheck(String json) throws IllegalAccessException {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        OrderInfo orderInfo = JSONObject.parseObject(json, OrderInfo.class);
        if (HtmlFilter.filter(orderInfo)) return AppJsonResult.formJsonResult( new JsonResult("不能填写html"));
        try {
            orderService.providerCheck(orderInfo);
        } catch (ExceptionWithMessage e) {
            return AppJsonResult.formJsonResult( e.jsonResult);
        } catch (Exception e) {
            return AppJsonResult.formJsonResult( new JsonResult(false, "添加失败", null));
        }
        return  AppJsonResult.success();
    }


}