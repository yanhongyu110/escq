/**
 * @Title IProviderRecommendService.java
 * @Package: com.jero.esc.service.userinfo 
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0 
 * @date 2016年12月8日
 * @description
 */
package com.jero.esc.service.userinfo;

import com.jero.esc.po.userinfo.ProviderRecommend;

/**
 * @ClassName: IProviderRecommendService
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0
 * @date 2016年12月8日
 * @description
 */
public interface IProviderRecommendService {
	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月15日
	 * @description 添加服务商推荐信息
	 * @param record
	 * @return Integer
	 * @method IProviderRecommendService
	 */
	public Integer addProviderRecommend(ProviderRecommend record);

	public ProviderRecommend quertById(StringBuffer Id);

	public Integer modify(ProviderRecommend record);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月20日
	 * @description 修改审核状态
	 * @param record
	 * @return Integer
	 * @method modifyStatebyLogId
	 */
	public Integer modifyStatebyLogId(ProviderRecommend record);

	public Integer delete(StringBuffer Id);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月4日
	 * @description 根据登录信息查询推荐信息
	 * @param logId
	 * @return ProviderRecommend
	 * @method queryByLogId
	 */
	public ProviderRecommend queryByLogId(String logId);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月20日
	 * @description 删除推荐
	 * @param logId
	 * @return Integer
	 * @method remove
	 */
	Integer removeProviderRecommend(String logId);

}
