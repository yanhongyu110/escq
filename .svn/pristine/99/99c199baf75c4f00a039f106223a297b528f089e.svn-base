package com.jero.esc.mapper.saleinfo;


import java.util.List;
import com.jero.esc.po.saleinfo.OrderService;



public interface OrderServiceMapper {
	/**
	 * 根据约见编号查询
	 * @param osId
	 * @return
	 */
	OrderService selectByOrderId(String osId);
	
	List<com.jero.esc.vo.saleinfo.OrderService> selectListByOrderId(String osId);
	
    int deleteByPrimaryKey(String osId);

    int insert(OrderService record);

    int insertSelective(OrderService record);

    OrderService selectByPrimaryKey(String osId);

    int updateByPrimaryKeySelective(OrderService record);

    int updateByPrimaryKey(OrderService record);

    OrderService selectByOrderServiceWithRemark(OrderService orderService);

    int countByExample(OrderService orderService);

}