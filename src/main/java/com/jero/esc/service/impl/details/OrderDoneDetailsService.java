package com.jero.esc.service.impl.details;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.mapper.details.OrderDoneDetailsMapper;
import com.jero.esc.po.details.OrderDoneDetails;
import com.jero.esc.service.details.IOrderDoneDetailsService;
@Service
public class OrderDoneDetailsService implements IOrderDoneDetailsService {

	@Autowired
	private OrderDoneDetailsMapper orderDoneDetailsMapper;
	
	
	@Transactional(rollbackFor=Exception.class)
	public Integer addBatch(List<OrderDoneDetails> records) {
		return orderDoneDetailsMapper.insertBatch(records);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Integer addOrderDoneDetail(OrderDoneDetails records) {
		return orderDoneDetailsMapper.insert(records);
	}

	public List<OrderDoneDetails> queryOrderDoneDetailsByCon(String orderId, RowBounds bounds) {
		return orderDoneDetailsMapper.selectOrderDoneDetailsByCon(orderId, bounds);
	}

	public Integer queryOrderDoneDetailsByCount(String orderId) {
		return orderDoneDetailsMapper.selectOrderDoneDetailsByCount(orderId);
	}

}
