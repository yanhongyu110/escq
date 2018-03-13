package com.jero.esc.mapper.details;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.details.AccontPaymentDetails;

public interface AccontPaymentDetailsMapper {
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID查询全部收支明细信息
	  *@param logId
	  *@param rb
	  *@return List<AccontPaymentDetails>
	  *@method selectAccountIODetailsById
	 */
	List<AccontPaymentDetails> selectAccountIODetailsById(RowBounds rb,@Param("logId")String logId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID查询用户的账户的所有收支明细条数
	  *@param logId
	  *@return Integer
	  *@method selectAccountIODetailsCountById
	 */
	Integer selectAccountIODetailsCountById(@Param("logId")String logId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据年和ID查询收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<AccontPaymentDetails>
	  *@method selectAccountIOByIdYear
	 */
	List<AccontPaymentDetails> selectAccountIOByIdYear(RowBounds rb,@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和年查询账户收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method selectAccountIOCountByIdYear
	 */
	Integer selectAccountIOCountByIdYear(@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据月和ID查询收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<AccontPaymentDetails>
	  *@method selectAccountIOByIdMonth
	 */
	List<AccontPaymentDetails> selectAccountIOByIdMonth(RowBounds rb,@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和月查询账户收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method selectAccountIOCountByIdMonth
	 */
	Integer selectAccountIOCountByIdMonth(@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据日和ID查询收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<AccontPaymentDetails>
	  *@method selectAccountIOByIdDay
	 */
	List<AccontPaymentDetails> selectAccountIOByIdDay(RowBounds rb,@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和日查询账户收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method selectAccountIOCountByIdDay
	 */
	Integer selectAccountIOCountByIdDay(@Param("logId")String logId, @Param("startTime")String startTime, @Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 查询收入总和
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return int
	  *@method selectAccountInAmountById
	 */
	int selectAccountInAmountById(@Param("logId")String logId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 查询支出总和
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return int
	  *@method selectAccountOutAmountById
	 */
	int selectAccountOutAmountById(@Param("logId")String logId,@Param("startTime")String startTime,@Param("endTime")String endTime);
	
    int deleteByPrimaryKey(String apdId);

    int insert(AccontPaymentDetails record);

    int insertSelective(AccontPaymentDetails record);

    AccontPaymentDetails selectByPrimaryKey(String apdId);

    int updateByPrimaryKeySelective(AccontPaymentDetails record);

    int updateByPrimaryKey(AccontPaymentDetails record);
    /**
     * 
     *<pre>
     *<b> 提现 .</b>
     *<b>Description:</b> 
     *    
     *<b>Author:</b> yanhongyu
     *<b>Date:</b> 2017-12-13 下午3:47:47
     *@param logId
     *@param money
     *@return
     *</pre>
     */
	public Integer withDraw(Map<String, String> parameter);
}