package com.jero.esc.service.saleinfo;

import java.util.List;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.po.userinfo.AccountInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.vo.saleinfo.OrderInfo;

/**
 * @copyright 
 * @author zengd
 * @version 
 * @date 2016年12月23日下午2:09:39 
 * @description
 */
public interface IOrderInfoBuyerService {
	Boolean selectPass(String logId);
	/**
	 * 查询订单
	 * @param PageRowBounds
	 * @param OrderInfo
	 * @return List<OrderService>
	 */
	List<OrderInfo> selectAll(PageRowBounds pageRowBounds,OrderInfo OrderInfo);
	/**
	 * @description  查询订单总数 
	 * @date 2016年12月26日上午9:54:50 
	 * @Return Integer
	 */
	Integer totalNum(OrderInfo orderInfo);
	
	/**
	 * @description  根据登录Id查询用户的账户信息
	 * @date 2016年12月26日上午10:56:13 
	 * @Parm logId
	 * @Return AccountInfo
	 */
	AccountInfo selectBalanceById(String logId);
	
	/**
	 * @throws ExceptionWithMessage 
	 * @description  付款
	 * @date 2016年12月26日上午11:14:35 
	 * @Parm accountInfo
	 * @Return Boolean
	 */
	JsonResult validate(AccountInfo accountInfo,String paypass,String orderNo,Integer flag,String serviceTitle) throws ExceptionWithMessage;
	/**
	 * @throws ExceptionWithMessage 
	 * @description 按订单编号删除订单
	 * @date 2016年12月27日下午1:34:03 
	 * @Parm orderNo
	 * @Return JsonResult
	 */
	JsonResult delete(String orderNo) throws ExceptionWithMessage;
	
	/**
	 * @description  根据订单Id查询订单
	 * @date 2017年1月3日上午9:57:36 
	 * @param id
	 * @Return OrderService
	 */
	OrderInfo selectById(String id);
	/**
	 * @description  根据登录ID查询用户基本信息
	 * @date 2017年1月9日下午4:21:11 
	 * @param id
	 * @Return LogInfo
	 */
	LogInfo getLogInfo(String id);
	
	/**
	 * @description  根据订单编号修改退款信息
	 * @date 2017年1月11日13:32:45
	 * @param orderInfo
	 * @Return Integer
	 */
	Integer modifyRefundMsgByOrderNo(OrderInfo orderInfo);
	
	/**
	 * 根据订单编号修改退款状态
	 * @param orderInfo
	 * @return
	 * @throws ExceptionWithMessage 
	 */
	JsonResult updateRefundStatusByOrderNo(String orderId) throws ExceptionWithMessage;
	
}
