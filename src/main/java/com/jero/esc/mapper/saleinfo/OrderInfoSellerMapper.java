package com.jero.esc.mapper.saleinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.vo.saleinfo.OrderInfo;
import com.jero.esc.vo.saleinfo.OrderService;
/**
 * 
 * Title:OrderInfoSellerMapper 
 * Description:
 * Company:ssyt
 * @author ll
 * @date2016年12月24日
 */
 
public interface OrderInfoSellerMapper {
	/**
	 * 
	 * @param rowBounds
	 * @param orderInfo
	 * @return
	 */
	List<OrderInfo> selectAll(PageRowBounds pageRowBounds,OrderInfo orderInfo);
	/**
	 * 查询收到的预约数量
	 * @param orderId
	 * @return
	 */
	int queryOrderCount(OrderInfo orderInfo);
	/**
	 * 查询符合查询条件的总记录数量
	 * @param orderId
	 * @return
	 */
	List<OrderInfo> selectAll(OrderInfo orderInfo);
	/**
	 * 删除可删订单
	 * @param orderId
	 * @return
	 */
	int deleteOrderById(String orderId);
	/**
	 * 修改订单状态
	 * @param orderId
	 * @return
	 */
	int updateOrderState(OrderInfo order);
	/**
	 * 根据订单编号查询详细信息
	 * @param orderId
	 * @return
	 */
	OrderInfo selectOrderById(String orderId);
	
	/**
	 * @description 通过订单编号修改退款信息 
	 * @date 2017年1月11日14:48:46
	 * @param orderInfo
	 * @return
	 */
	Integer updateRefundMsgByOrderNo(OrderInfo orderInfo);
	
	List<LogInfo> logInfo(String id);
}