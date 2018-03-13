package com.jero.esc.service.goodsinfo;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.vo.goodsinfo.CartVo;

import org.apache.ibatis.session.RowBounds;

/**
 * Created by blazh on 2016/12/18.
 */
public interface ICartService {


    /**
     *  通过用户ID查询所有条件的购物车
     * @param map 
     * @return
     * @throws Exception
     */
	FastPage<CartVo> queryCartByLogId(CartVo cart, RowBounds rowBounds)throws  Exception;

    
    /**
     *  通过用户ID添加购物车
     * @param serviceCart
     * @return
     * @throws Exception
     */
    Boolean addCartByLogId(String serviceId,String logId,String scartSource,Integer scartNum,String json)throws  Exception;

    /**
     * 通过ID伪删除购物车
     * @param cartId
     * @return
     */
    Boolean removeCartById(String cartId,String logid);
    
    /**
     *  通过条件查询所有条件的购物车
     * @param map 
     * @return
     * @throws Exception
     */
    FastPage<ServiceCart> queryCartByCon(ServiceCart record, RowBounds rowBounds)throws  Exception;
    
    /**
     * 判断是否在购物车中
     * @return
     */
    Boolean isExitCart(String serviceId,String logId,String scartSource);


}
