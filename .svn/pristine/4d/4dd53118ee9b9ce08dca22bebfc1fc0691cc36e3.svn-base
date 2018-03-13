package com.jero.esc.service.saleinfo;

import java.util.List;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.vo.saleinfo.OrderInfo;
import com.jero.esc.vo.saleinfo.OrderService;


/**
 * 
 * Title:IOrderInfoSellerService 
 * Description:定义卖家Service层接口
 * Company:ssyt
 * @author ll
 * @date2016年12月24日
 */
public interface IOrderInfoSellerService {
		
	List<OrderInfo> queryAllOrderInfo(PageRowBounds pageRowBounds,OrderInfo orderInfo);
	/**
	 * 查询符合条件预约数量
	 * @param orderId
	 * @return
	 */
	int queryCount(OrderInfo orderInfo);
	/**
	 * 查询收到的预约数量
	 * @param orderId
	 * @return
	 */
	int queryOrderCount(OrderInfo orderInfo);
	/**
	 * 删除可删订单
	 * @param orderId
	 * @return
	 */
	JsonResult removeOrderById(OrderInfo order);
	/**
	 * 修改订单状态
	 * @param orderId
	 * @return
	 */
	JsonResult modifyOrderState(OrderInfo order);
	
	OrderInfo selectOrderById(String orderId);
	
	/**
	 * @description 通过订单编号修改退款信息 
	 * @date 2017年1月11日14:48:46
	 * @param json
	 * @return
	 */
	Integer modifyRefundMsgByOrderNo(String json)throws Exception;
	
	LogInfo getLogInfo(String id);
	
}	
