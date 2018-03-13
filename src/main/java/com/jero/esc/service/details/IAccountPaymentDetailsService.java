package com.jero.esc.service.details;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.po.details.AccontPaymentDetails;
import com.jero.esc.po.userinfo.LogInfo;

@Transactional
public interface IAccountPaymentDetailsService {
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID查询用户的账户的所有收支明细
	  *@param logId
	  *@param rb
	  *@return List<AccontPaymentDetails>
	  *@method queryAccountIODetailsById
	 */
	HashMap<String, Object> queryAccountIODetailsById(RowBounds rb,String logId,String startTime,String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID查询用户的账户的所有收支明细条数
	  *@param logId
	  *@return Integer
	  *@method queryAccountIODetailsCountById
	 */
	Integer queryAccountIODetailsCountById(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和年查询账户收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<AccontPaymentDetails>
	  *@method queryAccountIOByIdYear
	 */
	List<AccontPaymentDetails> queryAccountIOByIdYear(RowBounds rb,String logId,String startTime,String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和年查询账户收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method queryAccountIOCountByIdYear
	 */
	Integer queryAccountIOCountByIdYear(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和月查询账户收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<AccontPaymentDetails>
	  *@method queryAccountIOByIdMonth
	 */
	List<AccontPaymentDetails> queryAccountIOByIdMonth(RowBounds rb,String logId,String startTime,String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和月查询账户收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method queryAccountIOCountByIdMonth
	 */
	Integer queryAccountIOCountByIdMonth(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和日查询账户收支明细
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@param rb
	  *@return List<AccontPaymentDetails>
	  *@method queryAccountIOByIdDay
	 */
	List<AccontPaymentDetails> queryAccountIOByIdDay(RowBounds rb,String logId,String startTime,String endTime);
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 根据ID和日查询账户收支明细条数
	  *@param logId
	  *@param startTime
	  *@param endTime
	  *@return Integer
	  *@method queryAccountIOCountByIdDay
	 */
	Integer queryAccountIOCountByIdDay(String logId,String startTime,String endTime);
	
	/**
	  *@version v1.0
	  *@date 2016年12月12日
	  *@description 查询收支总和
	  *@param logId
	  *@return Integer
	  *@method queryAccountAmountById
	 */
	Integer queryAccountAmountById(String logId,String startTime,String endTime);
	
	/**
	 * 
	  *@version v1.0
	  *@date 2017年2月16日
	  *@description 用户模块:添加账号交易明细
	  *@param accontPaymentDetails
	  *@return
	  *@return Integer
	  *@method addAccountIODetails
	 */
	Integer addAccountIODetails(AccontPaymentDetails accontPaymentDetails) throws Exception;
	/**
	 * 
	 *<pre>
	 *<b> 提现 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-13 下午3:42:46
	 *@param logInfo
	 *@param money
	 *@return
	 *</pre>
	 */
	public JsonResult withDraw(LogInfo logInfo, String money);
}
