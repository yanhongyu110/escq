package com.jero.esc.mapper.pubinfo;

import java.util.List;

import com.jero.esc.po.pubinfo.AdvertisePosition;

public interface AdvertisePositionMapper {
	List<AdvertisePosition> selectAdByPosition(AdvertisePosition advertisePosition);
	
    int deleteByPrimaryKey(String apId);

    int insert(AdvertisePosition record);

    int insertSelective(AdvertisePosition record);

    AdvertisePosition selectByPrimaryKey(String apId);

    int updateByPrimaryKeySelective(AdvertisePosition record);

    int updateByPrimaryKey(AdvertisePosition record);
}