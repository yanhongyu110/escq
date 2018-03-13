package com.jero.esc.service.details;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.details.PointPaymentDetails;

public interface IPointPaymentDetailsService {
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID查询用户的账户的所有积分收支明细
	  *@param logId
	  *@param rb
	  *@param startTime
	  *@param endTime
	  *@return List<PointPaymentDetails>
	  *@method queryPointIODetailsById
	 */
	HashMap<String, Object> queryPointIODetailsById(RowBounds rb,String logId,String startTime,String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID查询用户的账户的所有积分收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method queryPointIODetailsCountById
	 */
	Integer queryPointIODetailsCountById(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和年查询账户收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<PointPaymentDetails>
	  *@method queryPointIOByIdYear
	 */
	List<PointPaymentDetails> queryPointIOByIdYear(RowBounds rb,String logId,String startTime,String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和年查询账户积分收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method queryPointIOCountByIdYear
	 */
	Integer queryPointIOCountByIdYear(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和月查询账户积分收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<PointPaymentDetails>
	  *@method queryPointIOByIdMonth
	 */
	List<PointPaymentDetails> queryPointIOByIdMonth(RowBounds rb,String logId,String startTime,String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和月查询账户积分收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method queryPointIOCountByIdMonth
	 */
	Integer queryPointIOCountByIdMonth(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和日查询账户积分收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<PointPaymentDetails>
	  *@method queryPointIOByIdDay
	 */
	List<PointPaymentDetails> queryPointIOByIdDay(RowBounds rb,String logId,String startTime,String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和日查询账户积分收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method queryPointIOCountByIdDay
	 */
	Integer queryPointIOCountByIdDay(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 查询积分收支总和
	  *@param logId
	  *@return Integer
	  *@method queryPointAmountById
	 */
	Integer queryPointAmountById(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2017年2月16日
	  *@description 用户模块:添加积分收支明细
	  *@param pointPaymentDetails
	  *@return
	  *@return Integer
	  *@method addPointIODetails
	 */
	Integer addPointIODetails(PointPaymentDetails pointPaymentDetails) throws Exception;
}
