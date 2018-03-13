package com.jero.esc.mapper.pubinfo;

import com.jero.esc.po.pubinfo.CommonInfo;

public interface CommonInfoMapper {
    int deleteByPrimaryKey(String ciId);

    int insert(CommonInfo record);

    int insertSelective(CommonInfo record);

    CommonInfo selectByPrimaryKey(String ciId);

    int updateByPrimaryKeySelective(CommonInfo record);

    int updateByPrimaryKey(CommonInfo record);
}