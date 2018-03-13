package com.jero.esc.mapper.saleinfo;

import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.saleinfo.OrderInfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface OrderInfoMapper {


    @Select("SELECT\n" +
            "Sum((TIMESTAMPDIFF(MINUTE ,ORDER_CREATETIME,ORDER_CONFIRMTIME)))/COUNT(ORDER_ID)\n" +
            "FROM `order_info`\n" +
            "WHERE\n" +
            "order_info.ORDER_SELLER = #{vaalue}")
    Double getAvgTime(String ss);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String orderId);
    
    OrderInfo selectByOrderNo(String orderNo);

    int updateByPrimaryKeySelective(OrderInfo record);

    int countByExample(OrderInfo orderInfo);

    int updateByPrimaryKey(OrderInfo record);

    int countByRequire(ServiceInfo serviceInfo);

    List<OrderInfo> selectByRequire(ServiceInfo serviceInfo, RowBounds rowBounds);

    List<OrderInfo> test();

}