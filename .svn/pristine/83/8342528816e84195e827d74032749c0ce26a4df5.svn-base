package com.jero.esc.mapper.goodsinfo;

import com.jero.esc.po.goodsinfo.ServiceStep;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ServiceStepMapper {
    int deleteByPrimaryKey(String ssId);

    int insert(ServiceStep record);

    int insertSelective(ServiceStep record);

    ServiceStep selectByPrimaryKey(String ssId);

    int updateByPrimaryKeySelective(ServiceStep record);

    int updateByPrimaryKey(ServiceStep record);
    
    List<ServiceStep> selectServiceSetById(String serviceId);

    List<String> selectIdListByServiceId(String serviceId);

    int deleteByServiceId(String ssId);

    int countByServiceId(String ssId);

}