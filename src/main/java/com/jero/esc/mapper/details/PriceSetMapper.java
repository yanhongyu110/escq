package com.jero.esc.mapper.details;

import com.jero.esc.po.details.PriceSet;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PriceSetMapper {
    int deleteByPrimaryKey(String psetId);

    int insert(PriceSet record);

    int insertSelective(PriceSet record);

    PriceSet selectByPrimaryKey(String psetId);

    int updateByPrimaryKeySelective(PriceSet record);

    int updateByPrimaryKey(PriceSet record);

    int insertListSelective(List<PriceSet> record);

    int deleteByServiceId(String serviceId);

    int countByServiceId(String serviceId);
    
    PriceSet selectPriceSetBySource(@Param("serviceId")String serviceId,@Param("psetDiscountType")Integer psetDiscountType);

	List<PriceSet> selectPriceSetByPrice(String servicePrice);

}