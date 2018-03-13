package com.jero.esc.mapper.userinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.po.userinfo.ServiceInfo;
import com.jero.esc.vo.userinfo.ProviderVo;

public interface ProviderInfoMapper {
    int deleteByPrimaryKey(String piId);

    int insert(ProviderInfo record);

    int insertSelective(ProviderInfo record);

    ProviderInfo selectByPrimaryKey(String piId);

    int updateByPrimaryKeySelective(ProviderInfo record);

    int updateByPrimaryKey(ProviderInfo record);

    ProviderInfo selectByLogId(String logId);

    int countByExample(ProviderInfo record);

    int countByLogId(String logId);

	//得到服务商详情
	ProviderInfo selectProviderDetailsById(@Param("log") LogInfo logInfo,String run);

	//根据服务商得到服务
	List<ServiceInfo> selectServiceInfoById(LogInfo logInfo);
	
	int countServiceInfoByCon(LogInfo logInfo);

	//根据模块id得到推荐(似乎没有用？？？)
	List<ProviderVo> selectRecommendProvider(@Param("module")String module);

	//根据模块id得到推荐(好像前台实际用的是这个)
	List<ProviderVo> selectProviderByOrder(RowBounds rb,@Param("order")String order,@Param("module") String module);

	//根据模块得到数量
	Integer selectProviderCountByOrder(@Param("module")String module);


	//用用于服务商检索的
	List<ProviderVo> selectProviderByCon(RowBounds rb,@Param("province")String province,@Param("city")String city, @Param("area")String area,@Param("order")String order,@Param("module") String module);

	//用用于服务商检索的数量
	Integer selectProviderCountByCon(@Param("province")String province,@Param("city")String city, @Param("area")String area,@Param("module") String module);

	//用用于服务商检索的
	List<ProviderVo> selectProviderBySearch(RowBounds rb,@Param("search")String search,@Param("order")String order,@Param("module") String module);

	//用用于服务商检索的
	List<ProviderVo> selectProviderBySearch(RowBounds rb,@Param("search")String search,@Param("order")String order,@Param("province")String province,@Param("city")String city, @Param("area")String area,@Param("module")String module);

	//用用于服务商检索的
	Integer selectProviderCountBySearch(@Param("search")String search,@Param("order")String order,@Param("province")String province,@Param("city")String city, @Param("area")String area,@Param("module")String module);

	List<ServiceInfo> selectServiceInfoByCon(LogInfo logInfo, RowBounds rowBounds);
	
	List<ProviderVo> selectProviderByModule(@Param("module")String module,RowBounds rb);
	
	List<ProviderInfo> selectGoodProviders(RowBounds rb);
	
	Integer selectGoodProvidersCount();
}