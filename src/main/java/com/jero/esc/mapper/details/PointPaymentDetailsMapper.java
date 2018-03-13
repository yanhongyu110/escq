package com.jero.esc.mapper.details;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.details.PointPaymentDetails;

public interface PointPaymentDetailsMapper {
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID查询全部积分收支明细信息
	  *@param logId
	  *@param rb
	  *@param startTime
	  *@param endTime
	  *@return List<PointPaymentDetails>
	  *@method selectPointIODetailsById
	 */
	List<PointPaymentDetails> selectPointIODetailsById(RowBounds rb,@Param("logId")String logId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID查询用户的账户的所有积分收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method selectPointIODetailsCountById
	 */
	Integer selectPointIODetailsCountById(@Param("logId")String logId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据年和ID查询积分收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<PointPaymentDetails>
	  *@method selectPointIOByIdYear
	 */
	List<PointPaymentDetails> selectPointIOByIdYear(RowBounds rb,@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和年查询账户积分收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method selectPointIOCountByIdYear
	 */
	Integer selectPointIOCountByIdYear(@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据月和ID查询积分收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<PointPaymentDetails>
	  *@method selectPointIOByIdMonth
	 */
	List<PointPaymentDetails> selectPointIOByIdMonth(RowBounds rb,@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和月查询账户积分收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method selectPointIOCountByIdMonth
	 */
	Integer selectPointIOCountByIdMonth(@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据日和ID查询积分收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<PointPaymentDetails>
	  *@method selectPointIOByIdDay
	 */
	List<PointPaymentDetails> selectPointIOByIdDay(RowBounds rb,@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和日查询账户积分收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method selectPointIOCountByIdDay
	 */
	Integer selectPointIOCountByIdDay(@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 查询积分收入总和
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return int
	  *@method selectPointInAmountById
	 */
	int selectPointInAmountById(@Param("logId")String logId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 查询积分支出总和
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return int
	  *@method selectPointOutAmountById
	 */
	int selectPointOutAmountById(@Param("logId")String logId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	
    int deleteByPrimaryKey(String ppdId);

    int insert(PointPaymentDetails record);

    int insertSelective(PointPaymentDetails record);

    PointPaymentDetails selectByPrimaryKey(String ppdId);

    int updateByPrimaryKeySelective(PointPaymentDetails record);

    int updateByPrimaryKey(PointPaymentDetails record);
}