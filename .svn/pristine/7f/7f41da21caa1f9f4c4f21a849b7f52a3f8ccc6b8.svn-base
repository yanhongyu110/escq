package com.jero.esc.service.userinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.po.userinfo.ServiceInfo;

/**
 * @copyright 上善云图信息技术有限公司
 * @author 杜骏程
 * @version v1.0  （版本号）
 * @date 2016年12月18日
 * @description 
 */
public interface IProviderDetailsService {
	
	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月18日
	 * @description 查询服务商详情
	 * @param logInfo
	 * @return ProviderInfo
	 * @method queryProviderDetailsById
	 */
	ProviderInfo queryProviderDetailsById(LogInfo logInfo,String com);
	
	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月21日
	 * @description 查询服务信息列表
	 * @param logInfo
	 * @return ProviderInfo
	 * @method queryProviderDetailsById
	 */
	List<ServiceInfo> queryServiceInfoById(LogInfo logInfo);
	
	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月21日
	 * @description 查询服务信息列表(分页)
	 * @param logInfo
	 * @return ProviderInfo
	 * @method queryProviderDetailsById
	 */
	List<ServiceInfo> queryServiceInfoByCon(LogInfo logInfo,RowBounds rowBounds);
	
	
	int countServiceInfoByCon(LogInfo logInfo);

}
