package com.jero.esc.mapper.userinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jero.esc.po.userinfo.FenXiao;
import com.jero.esc.po.userinfo.LogInfo;

public interface LogInfoMapper {
	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 查询手机是否注册
	 * @param logCell
	 * @return LogInfo
	 * @method selectLogInfoLogCell
	 */
	Integer selectLogInfoLogCell(@Param("logCell") String logCell);




	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 查询手机是否注册
	 * @param logCell
	 * @return LogInfo
	 * @method selectLogInfoLogCell
	 */
	List<LogInfo> selectLogInfoLogCelll(@Param("logCell")String logCell);


	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 查询昵称是否注册过
	 * @param logName
	 * @return Integer
	 * @method selectLogInfoLogName
	 */
	Integer selectLogInfoLogName(@Param("logName") String logName);


	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 登录验证
	 * @param logInfo
	 * @return LogInfo
	 * @method selectLogInfoLogin
	 */
	LogInfo selectLogInfoLogin(@Param("log") LogInfo logInfo);
	
	
	/**
	 * @version v1.0 (版本号)
	 * @description 通过logId获取session信息
	 * @param logInfo
	 * @return LogInfo
	 * @method selectLogInfoLogin
	 */
	LogInfo selectLogInfoByLogId(LogInfo logInfo);
	
	
    Integer deleteByPrimaryKey(String logId);

    Integer insert(LogInfo record);
    /**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 用户注册
	 * @param record
	 * @return Integer
	 * @method insertSelective
	 */
    Integer insertSelective(LogInfo record);
   

    LogInfo selectByPrimaryKey(String logId);

    Integer updateByPrimaryKeySelective(LogInfo record);

    Integer updateByPrimaryKey(LogInfo record);
    
    /**
     * @version v1.0 (版本号)
     * @date 2016年12月26日
     * @description 
     * @param record
     * @return Integer
     * @method updatePassByCell
     */
    Integer updatePassByCell(@Param("log") LogInfo record);



    /**
     * 
     *<pre>
     *<b> 添加推广关系 .</b>
     *<b>Description:</b> 
     *    
     *<b>Author:</b> yanhongyu
     *<b>Date:</b> 2017-11-22 下午5:49:29
     *@param logInfo
     *@return
     *</pre>
     */
	public Integer addExtension(LogInfo logInfo);



	/**
	 * 
	 *<pre>
	 *<b> 查询推广关系 .</b>
	 *<b>Description:</b> 
	 *    根据注册者的openId
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-11 上午10:14:49
	 *@param logInfo
	 *@return
	 *</pre>
	 */
	public FenXiao selectFenXiao(LogInfo logInfo);


	/**
	 * 
	 *<pre>
	 *<b> 删除推广关系 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-11 上午10:36:36
	 *@param fenXiao
	 *</pre>
	 */
	public void deleteFenXiao(FenXiao fenXiao);




	public Integer selectExtensionByCount(LogInfo logInfo);


	List<LogInfo> selectLog(String openid);




	int updateByLogInfo(LogInfo logInfo);


	List<LogInfo> selectLogInfoLogCellByLog(String logCell);
    
}