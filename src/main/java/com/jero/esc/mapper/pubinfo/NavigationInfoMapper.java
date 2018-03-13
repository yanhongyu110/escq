package com.jero.esc.mapper.pubinfo;

import com.jero.esc.po.pubinfo.NavigationInfo;

public interface NavigationInfoMapper {
    int deleteByPrimaryKey(String navId);

    int insert(NavigationInfo record);

    int insertSelective(NavigationInfo record);

    NavigationInfo selectByPrimaryKey(String navId);

    int updateByPrimaryKeySelective(NavigationInfo record);

    int updateByPrimaryKey(NavigationInfo record);
}