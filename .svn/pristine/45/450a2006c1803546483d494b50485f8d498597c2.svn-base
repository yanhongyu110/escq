package com.jero.esc.service.saleinfo;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.saleinfo.OrderInfo;
import com.jero.esc.po.saleinfo.OrderService;

import java.util.List;
import java.util.Map;

/**
 * Created by blazh on 2016/12/8.
 */
public interface IOrderBeforeService {


	 /**
     * 取消订单
     * @param orderInfo
     * @return
     * @throws Exception
     */
    Boolean cancelOrder(String orderNo)throws  Exception;
    
    /**
     * 刷新订单生成体
     * @throws Exception
     */
    void  flashMaker(List<ServiceCart> carts)throws  Exception;

    /**
     * 添加订单(单个)
     * @param orderInfo
     * @return
     */
    Boolean addOrder( OrderInfo orderInfo, OrderService orderService)throws Exception;

    /**
     * 从购物车添加
     * @param list
     * @return
     */
    Boolean addOrderFromCart(OrderInfo orderInfo,List<ServiceCart> list)throws Exception;
    
    /**
     * 根据条件查询
     * @param orderInfo
     * @param require
     * @return
     */
    FastPage<OrderInfo> queryOrderByRequire(OrderInfo orderInfo, Map<String,String> require)throws Exception;


    /**
     * 服务商确认
     * @param orderInfo
     * @return
     */
    Boolean providerCheck(OrderInfo orderInfo)throws Exception;



    /**
     * 用户修改
     * @param orderInfo
     * @return
     */
    Boolean userModify(OrderInfo orderInfo)throws Exception;


    /**
     * 根据order修改
     * @param orderInfo
     * @return
     */
    Boolean modifyByOrder(OrderInfo orderInfo)throws Exception;


    /**
     * 删除order修改
     * @param id
     * @return
     */
    Boolean removeById(String id)throws Exception;




}
