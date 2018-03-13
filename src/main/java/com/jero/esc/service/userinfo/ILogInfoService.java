package com.jero.esc.service.userinfo;

import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.po.userinfo.LogInfo;

/**
 * @copyright 上善云图信息技术有限公司
 * @author zqy
 * @version v1.0 （版本号）
 * @date 2016年12月8日
 * @description 账号信息
 */
@Transactional
public interface ILogInfoService {

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 查询手机是否注册
	 * @param logCell
	 * @return LogInfo
	 * @method selectLogInfoLogCell
	 */
	Integer selectLogInfoLogCell(String logCell);

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 查询昵称是否注册过
	 * @param logName
	 * @return Integer
	 * @method selectLogInfoLogName
	 */
	Integer selectLogInfoLogName(String logName);

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 用户注册和增加账户
	 * @param logInfo
	 * @return Integer
	 * @throws ExceptionWithMessage
	 * @method addLogInfo
	 */
	JsonResult addLogInfo(LogInfo logInfo, String isWeiXin) throws ExceptionWithMessage;

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 登录验证
	 * @param logInfo
	 * @return LogInfo
	 * @method queryLogInfoLogin
	 */
	LogInfo queryLogInfoLogin(LogInfo logInfo);
	
	/**
	 * @version v1.0 (版本号)
	 * @description 刷新session
	 * @param logInfo
	 * @return LogInfo
	 * @method refreshSession
	 */
	LogInfo refreshSession(LogInfo logInfo);

	Integer removeByPrimaryKey(String logId);

	Integer add(LogInfo record);

	Integer addSelective(LogInfo record);

	LogInfo queryByPrimaryKey(String logId);

	Integer modifyByPrimaryKeySelective(LogInfo record);

	Integer modifyByPrimaryKey(LogInfo record);

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月26日
	 * @description通过手机号码修改密码
	 * @param record
	 * @return Integer
	 * @method ILogInfoService
	 */
	Integer modifyPassByCell(LogInfo record);

	/**
	 * 
	 *<pre>
	 *<b> 添加推广关系 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-22 下午5:48:26
	 *@param logInfo
	 *@return
	 *</pre>
	 */
	public Integer addExtension(LogInfo logInfo);

}
