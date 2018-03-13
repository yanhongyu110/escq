package com.jero.esc.service.pay;

import java.util.HashMap;
import java.util.List;

import com.jero.esc.po.goodsinfo.ServiceStep;
import com.jero.esc.po.saleinfo.OrderInfo;
import com.jero.esc.vo.saleinfo.OrderService;

public interface IOrderPayService {

	/**
	 * 获取订单服务表
	 * @param orderId
	 * @return List<OrderService>
	 * @throws Exception
	 */
	List<OrderService> queryOrderServiceByOrderId(String orderId) throws Exception;
	
	/**
	 * 修改订单信息  comment字段
	 * @param orderInfo
	 * @return Boolean
	 * @throws Exception
	 */
	Boolean modifyOrderInfo(OrderInfo orderInfo)throws Exception;
	
	
	/**
	 * 查询订单信息
	 * @param orderId
	 * @return OrderInfo
	 */
	OrderInfo queryOrderInfoByOrderId(String orderId);
	
	/**
	 * 查询订单信息
	 * @param orderId
	 * @return HashMap<String, Object>
	 */
	HashMap<String, Object> queryOrdeAllByOrderId(String orderId);
	
	/**
	 * 根据订单NO查询详细信息
	 * @param orderNo
	 * @return OrderInfo
	 */
	OrderInfo selectOrderInfoByOrderNo(String orderNo);
}
