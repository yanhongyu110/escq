package com.jero.esc.service.details;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.details.OrderDoneDetails;
/**
 * 
 * @copyright 上善云图信息技术有限公司
 * @author  tjh
 * @version  v1.0
 * @date  2016年12月20日
 * @description 
 */
public interface IOrderDoneDetailsService {
	
	/**
	 * 
	 * @version  v1.0
	 * @date  2016年12月19日
	 * @description  批量插入数据
	 * @param records 集合
	 * @return   Integer
	 * @method insertBatch
	 */
	Integer addBatch(List<OrderDoneDetails> records);
	
	Integer addOrderDoneDetail(OrderDoneDetails records);
	
	/**
	 * 
	 * @version  v1.0
	 * @date  2016年12月19日
	 * @description 根据条件查询订单操作详细
	 * @param orderId 订单id
	 * @param bounds
	 * @return List<OrderDoneDetails>
	 * @method selectOrderDoneDetailsByCon
	 */
	List<OrderDoneDetails>  queryOrderDoneDetailsByCon(String orderId,RowBounds bounds);
	
	/**
	 * 
	 * @version  v1.0
	 * @date  2016年12月19日
	 * @description 根据orderid查询记录数
	 * @param orderId
	 * @return Integer
	 * @method selectOrderDoneDetailsByCount
	 */
	Integer queryOrderDoneDetailsByCount(String orderId);

}
