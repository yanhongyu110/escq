package com.jero.esc.service.userinfo;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.vo.userinfo.ProviderVo;



public interface IProviderInfoService {

	Boolean add(ProviderInfo record);

	ProviderInfo quertById(String Id);

	Boolean modify(ProviderInfo record);

	Boolean delete(String Id);

	ProviderInfo queryByLogId(String logId);

	Integer countByExample(ProviderInfo record);
	
	Integer countByLogId(String logId);
	
	HashMap<String,Object> queryRecommendProvider(String serviceTypetree,String module,Integer siPos);
	
	List<ProviderVo> selectProviderByOrder(RowBounds rb,String com);
	
	HashMap<String, Object> selectVideoByOrder(RowBounds rb,String order,String com);
	
	Integer selectProviderCountByOrder(String com);
	
	/**
	 * 
	  *@version v1.0
	  *@date 2016年12月29日
	  *@description 分类筛选
	  *@param province
	  *@param city
	  *@param area
	  *@return
	  *@return List<ProviderVo>
	  *@method selectProviderByCon
	 */
	List<ProviderVo> queryProviderByCon(RowBounds rb,String province, String city, String area,String order,String com);
	
	/**
	 * 
	  *@version v1.0
	  *@date 2016年12月29日
	  *@description 分类筛选服务桑条数
	  *@param province
	  *@param city
	  *@param area
	  *@return
	  *@return Integer
	  *@method selectProviderCountByCon
	 */
	Integer queryProviderCountByCon(String province, String city, String area,String com);
	
	/**
	  *@version v1.0
	  *@date 2017年1月10日
	  *@description 搜索服务商
	  *@param rb
	  *@param search
	  *@param order
	  *@return List<ProviderVo>
	  *@method queryProviderBySearch
	 */
	List<ProviderVo> queryProviderBySearch(RowBounds rb,String search,String order,String province,String city, String area,String module);

	/**
	  *@version v1.0
	  *@date 2017年1月10日
	  *@description 搜索服务商条数
	  *@param search
	  *@param order
	  *@return Integer
	  *@method queryProviderCountBySearch
	 */
	Integer queryProviderCountBySearch(String search,String order,String province,String city, String area,String com);
	
	List<ProviderVo> queryProviderRecommend(String com);
	
	HashMap<String,Object> querySchoolProvider(List<CommonType> commonTypes);
}
