package com.jero.esc.mapper.goodsinfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.vo.goodsinfo.ServiceInfoVo;
import com.jero.esc.vo.userinfo.ServiceVo;

public interface ServiceInfoMapper {

    List<Map> selectTest();

	ServiceInfo selectByLogId(@Param("id")String id,@Param("serviceTitle")String serviceTitle);
	
    int deleteByPrimaryKey(String serviceId);

    int insert(ServiceInfo record);

    int insertSelective(ServiceInfo record);

    ServiceInfo selectByPrimaryKey(String serviceId);

    int updateByPrimaryKeySelective(ServiceInfo record);

    int updateByPrimaryKey(ServiceInfo record);
    
    int countByExample(@Param("ser") ServiceInfo serviceInfo);
    
    List<ServiceVo> selectServiceInfo(ServiceVo ServiceVo, RowBounds rowBounds);
    
    int countServiceInfo(ServiceVo ServiceVo);
    
    int countByRequire(ServiceInfo serviceInfo);

    List<ServiceInfo> selectByRequire(ServiceInfo serviceInfo, RowBounds rowBounds);
    
    ServiceVo selectServiceDetailsById(@Param("serviceId")String serviceId,@Param("priceType")Integer priceType,@Param("com")String com);

    ServiceVo selectServiceSourceById(@Param("serviceId")String serviceId,@Param("priceType")Integer priceType);

    List<ServiceInfoVo> selectHomeServiceInfo(@Param("serviceTypetree")String serviceTypetree,@Param("module")String module);
    
    List<ServiceInfoVo> selectServiceByType(RowBounds rb,@Param("serviceTypetree")String serviceTypetree,@Param("order")String order,@Param("province")String province,@Param("city")String city,@Param("area")String area);
    
    Integer selectServiceCountByType(@Param("serviceTypetree")String serviceTypetree,@Param("province")String province,@Param("city")String city,@Param("area")String area,@Param("com")String com);
    
    List<ServiceInfoVo> selectServiceByCon(RowBounds rb,@Param("search")String search,@Param("order")String order,@Param("province")String province,@Param("city")String city,@Param("area")String area,@Param("type")String type,@Param("lat")String lat,@Param("lng")String lng);
    
    Integer selectServiceCountByCon(@Param("search")String search,@Param("order")String order,@Param("province")String province,@Param("city")String city,@Param("area")String area,@Param("type")String type);

    List<ServiceVo> selectServiceByProvider(@Param("order")String order, RowBounds rb,@Param("com")String com);
    
    Integer selectServiceCountByProvider(@Param("order")String order,@Param("com")String com);
    
    List<ServiceInfoVo> selectGreatService(@Param("order")String order, RowBounds rb,@Param("com")String com);
    
    Integer selectGreatServiceCount(@Param("order")String order,@Param("com")String com);
    
    List<ServiceVo> selectServiceByModule(@Param("serviceTypetree")String serviceTypetree,RowBounds rb);
    
    List<ServiceVo> selectIndexService(@Param("lng")String lng,@Param("lat")String lat);
    
    List<ServiceInfoVo> selectNewService(RowBounds rb,@Param("lng")String lng,@Param("lat")String lat);
    
    Integer selectNewServiceCount();

	public List<String> queryAuthentication();

}