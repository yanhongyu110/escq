package com.jero.esc.mapper.saleinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.po.userinfo.AccountInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.vo.saleinfo.OrderInfo;

/**
 * @copyright 
 * @author zengd
 * @version 
 * @date 2016年12月23日下午1:29:12 
 * @description
 */
public interface OrderInfoBuyerMapper {
	String selectPass(String logId);
	/**
	 * 查询订单
	 * @return
	 */
	List<OrderInfo> selectAll(PageRowBounds pageRowBounds,OrderInfo OrderInfo);
	
	/**
	 * @description  查询订单总数 
	 * @date 2016年12月26日上午9:54:50 
	 * @Return Integer
	 */
	Integer totalNum(OrderInfo OrderInfo);
	/**
	 * @description  验证支付密码
	 * @date 2016年12月26日上午10:46:22 
	 * @Parm accountInfo
	 * @Return Integer
	 */
	Integer validate(AccountInfo accountInfo);
	/**
	 * @description 按订单编号删除订单 
	 * @date 2016年12月27日下午1:31:17 
	 * @Parm orderNo
	 * @Return Integer
	 */
	Integer delete(String orderNo);
	/**
	 * @description  付款(修改买家余额)
	 * @date 2016年12月29日上午10:49:39 
	 * @Parm orderNo
	 * @Return Integer
	 */
	Integer update(AccountInfo accountInfo);
	/**
	 * @description  根据登录ID查询用户的账户信息
	 * @date 2016年12月29日上午10:53:53 
	 * @Parm logId
	 * @Return List<AccountInfo>
	 */
	List<AccountInfo> selectBalanceById(String logId);
	/**
	 * @description  根据订单Id查询订单
	 * @date 2017年1月3日上午9:57:36 
	 * @param id
	 * @Return OrderService
	 */
	List<OrderInfo> selectById(String id);
	/**
	 * @description 根据订单Id修改订单状态 
	 * @date 2017年1月3日下午5:46:06 
	 * @param orderNo
	 * @Return Integer
	 */
	Integer updateState(@Param("orderNo")String orderNo,@Param("flag")Integer flag);
	/**
	 * @description  根据卖家ID查询卖家用户基本信息
	 * @date 2017年1月9日下午4:28:03 
	 * @param id
	 * @Return List<LogInfo>
	 */
	List<LogInfo> logInfo(String id);

	
	/**
	 * @description  根据订单编号修改退款信息
	 * @date 2017年1月11日13:35:34
	 * @param orderInfo
	 * @Return Integer
	 */
	Integer updateRefundMsgByOrderNo(OrderInfo orderInfo);

	/**
	 * 根据订单编号修改退款状态
	 * @param orderInfo
	 * @return
	 */
	Integer updateRefundStatusByOrderNo(String orderId);
	
	Integer updateServiceinfoById(@Param("id")String id,@Param("i")Integer i);

	Integer updateprioviderinfoById(@Param("id")String id,@Param("i")Integer i);
	
}
