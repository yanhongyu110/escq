package com.jero.esc.mapper.details;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.details.OrderDoneDetails;

public interface OrderDoneDetailsMapper {
	/**
	 * 
	 * @version  v1.0
	 * @date  2016年12月19日
	 * @description  批量插入数据
	 * @param records 集合
	 * @return   Integer
	 * @method insertBatch
	 */
	Integer insertBatch(List<OrderDoneDetails> records);
	
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
	List<OrderDoneDetails>  selectOrderDoneDetailsByCon(String orderId,RowBounds bounds);
	
	/**
	 * 
	 * @version  v1.0
	 * @date  2016年12月19日
	 * @description 根据orderid查询记录数
	 * @param orderId
	 * @return Integer
	 * @method selectOrderDoneDetailsByCount
	 */
	Integer selectOrderDoneDetailsByCount(String orderId);
	
    int deleteByPrimaryKey(String oddId);

    int insert(OrderDoneDetails record);

    int insertSelective(OrderDoneDetails record);

    OrderDoneDetails selectByPrimaryKey(String oddId);

    int updateByPrimaryKeySelective(OrderDoneDetails record);

    int updateByPrimaryKey(OrderDoneDetails record);
}