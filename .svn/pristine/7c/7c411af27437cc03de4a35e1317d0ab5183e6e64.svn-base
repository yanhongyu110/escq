package com.jero.esc.service.impl.pay;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jero.esc.mapper.goodsinfo.ServiceSnapshotMapper;
import com.jero.esc.mapper.saleinfo.OrderInfoMapper;
import com.jero.esc.mapper.saleinfo.OrderServiceMapper;
import com.jero.esc.po.goodsinfo.ServiceSnapshot;
import com.jero.esc.po.saleinfo.OrderInfo;
import com.jero.esc.vo.saleinfo.OrderService;
import com.jero.esc.service.pay.IOrderPayService;
@Service
public class OrderPayService implements IOrderPayService {
	
	
	@Autowired
	private OrderServiceMapper orderServiceMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Autowired
	private ServiceSnapshotMapper serviceSnapshotMapper;
	
	

	/**
	*@description 
	*@param orderId
	*@return
	*@throws Exception
	*@method queryOrderServiceByOrderId
	 */
	

	@Override
	public List<OrderService> queryOrderServiceByOrderId(String orderId) throws Exception {
		return orderServiceMapper.selectListByOrderId(orderId);
	}

	@Override
	public Boolean modifyOrderInfo(OrderInfo orderInfo) throws Exception {
		// TODO Auto-generated method stub
		return orderInfoMapper.updateByPrimaryKeySelective(orderInfo)>0;
	}

	@Override
	public OrderInfo queryOrderInfoByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderInfoMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public HashMap<String, Object> queryOrdeAllByOrderId(String orderId) {
		// TODO Auto-generated method stub
		List<OrderService> orderService=orderServiceMapper.selectListByOrderId(orderId);
		OrderInfo orderInfo=orderInfoMapper.selectByPrimaryKey(orderId);
		//ServiceSnapshot serviceSnapshot=serviceSnapshotMapper.selectByPrimaryKey(orderService.get(0).getSersId());
		HashMap<String, Object> order=new HashMap<String, Object>();
		order.put("orderService", orderService);
		order.put("orderInfo", orderInfo);
		//order.put("serviceSnapshot", serviceSnapshot);
		return order;
	}

	@Override
	public OrderInfo selectOrderInfoByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		return orderInfoMapper.selectByOrderNo(orderNo);
	}

}
