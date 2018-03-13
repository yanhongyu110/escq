package com.jero.esc.common.utils;

import java.util.HashMap;
import java.util.Map;


public interface ConstUtil {

	public static String USER_MAP="USER_MAP_IN_SESSIOIN";
	/**
	 * 数据信息：账号状态
	 * 相关表：登陆账号信息表(LOG_INFO)
	 * 作者：zqy
	 */
	public Map<Integer,String> LOG_STATE_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(1,"正常");
			put(0,"冻结");
		}
	};
	
	/**
	 * 数据信息：账号类型
	 * 相关表：登陆账号信息表(LOG_TYPE)
	 * 作者：zqy
	 */
	public Map<Integer,String> LOG_TYPE_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(1,"普通用户");
			put(2,"服务商");
		}
	};
	
	/**
	 * 数据信息：服务状态
	 * 相关表：服务信息表(SERVICE_INFO)
	 * 作者：zqy
	 */
	public Map<Integer,String> SERVICE_STATE_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(1,"未审核");
			put(2,"已审核");
			put(3,"未通过");
			put(4,"冻结");
		}
	};
	/**
	 * 数据信息：服务评价
	 * 相关表：服务信息表(SERVICE_REMAK)
	 * 作者：fxy
	 */
	public Map<Integer,String> SERVICE_REMARK_STATE_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(0,"好评");
			put(1,"中评");
			put(2,"差评");
		}
	};
	/**
	 * 数据信息：服务商认证状态
	 * 相关表：服务商认证信息表(PROVIDER_CHECK_INFO)
	 * 作者： zengd
	 */
	public Map<Integer,String> PROVIDER_STATE_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(1,"未审核");
			put(2,"审核通过");
			put(3,"审核未通过");
		}
	};
	
	
	/**
	 * 数据信息：订单状态
	 * 相关表：订单表(ORDER_INFO)
	 * 作者： tjh
	 */
	public Map<Integer,String> ORDER_STATE_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			
			put(0,"待服务商确认");
			put(1,"服务商否定");
			put(2,"待支付");
			put(3,"已取消");
			put(4,"待完成");
			put(5,"待评价");
			put(6,"已完成");
			put(7,"申请退款");
		}
	};
	
	/**
	 * 数据信息：订单退款状态
	 * 相关表：订单表(ORDER_INFO)
	 * 作者： zqy
	 */
	public Map<Integer,String> ORDER_REFUNDSTATE=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(0,"默认值");
			put(1,"已申请退款");
			put(2,"专家同意");
			put(3,"专家不同意");
			put(4,"完成（平台同意）");
			put(5,"完成（平台不同意）");
			put(6,"专家不同意,已申请平台介入");
		}
	};
	
	
	/**
	 * 数据信息：广告位置
	 * 相关表：广告表(ADVERTISE_POSITION)
	 * 作者： xfj
	 */
	public Map<Integer,String> AP_POSITION_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(1,"首页");
		}
	};
	/**
	 * 数据信息：支付类型
	 * 相关表：订单操作详情表(order_done_details)
	 * 作者：fxy
	 */
	public Map<Integer,String> TRADE_TYPE_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(1,"支付宝");
			put(2,"微信");
			put(3,"银行卡");
			put(4,"退款");
			put(5,"平台支付");
		}
	};
	/**
	 * 数据信息：收支类型
	 * 相关表：账号收支明细表(ACCONT_PAYMENT_DETAILS) 积分收支明细表(POINT_PAYMENT_DETAILS)
	 * 作者：xfj
	 */
	public Map<Integer,String> IO_TYPE_MAP=new HashMap<Integer,String>(){
		private static final long serialVersionUID = 1L;
		{
			put(1,"收入");
			put(2,"支出");
		}
	};
	
	/**
	 * 数据信息：发布需求状态
	 * 相关表：demand
	 * 作者：zengd
	 */
	public Map<Integer, String> DEMAND_STATE = new HashMap<Integer, String>(){
		private static final long serialVersionUID = 1L;
		{
			put(1,"审核中");
			put(2,"通过");
			put(3,"未通过");
		}
	};
}
