/**
 * @Title IProviderCheckManageService.java
 * @Package: com.jero.esc.service.userinfo
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0
 * @date 2016年12月8日
 * @description
 */
package com.jero.esc.service.checkinfo;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.po.checkinfo.ProviderCheckInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;

/**
 * @ClassName: IProviderCheckManageService
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0
 * @date 2016年12月8日
 * @description
 */
public interface IProviderCheckManageService {
	//添加服务商基本+认证信息
    public Boolean addCheck(ProviderInfo providerInfo, ProviderCheckInfo providerCheckInfo);
    //修改服务商基本+认证信息
    public Boolean modifyCheck(ProviderInfo providerInfo, ProviderCheckInfo providerCheckInfo) throws Exception;
    //通过账号id查询服务商基本信息
    public JsonResult queryProviderInfoByLogId(String logId);
    //通过账号id查询服务商认证信息
    public JsonResult queryProviderCheckInfoByLogId(String logId);
}
