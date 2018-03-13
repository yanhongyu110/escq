package com.jero.esc.mapper.userinfo;

import com.jero.esc.po.userinfo.ProviderRecommend;

public interface ProviderRecommendMapper {

	int deleteByPrimaryKey(String prId);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月15日
	 * @description添加服务商推荐信息
	 * @param record
	 * @return int
	 * @method ProviderRecommendMapper
	 */
	int insert(ProviderRecommend record);

	int insertSelective(ProviderRecommend record);

	ProviderRecommend selectByPrimaryKey(String prId);

	int updateByPrimaryKeySelective(ProviderRecommend record);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月20日
	 * @description修改审核状态
	 * @param record
	 * @return int
	 * @method updateStateBylogId
	 */
	int updateStateBylogId(ProviderRecommend record);

	int updateByPrimaryKey(ProviderRecommend record);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月4日
	 * @description 根据登录信息查询服务商推荐信息
	 * @param logId
	 * @return ProviderRecommend
	 * @method selectBylogId
	 */
	ProviderRecommend selectBylogId(String logId);
}