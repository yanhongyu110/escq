package com.jero.esc.mapper.checkinfo;

import com.jero.esc.po.checkinfo.ProviderCheckInfo;

public interface ProviderCheckInfoMapper {

    int deleteByPrimaryKey(String pciId);

    int insert(ProviderCheckInfo record);

    int insertSelective(ProviderCheckInfo record);

    ProviderCheckInfo selectByPrimaryKey(String pciId);

    int updateByPrimaryKeySelective(ProviderCheckInfo record);

    int updateByPrimaryKey(ProviderCheckInfo record);

    ProviderCheckInfo selectByLogId(String logId);
    
    int countByLogId(String logId);

    int countByExample(ProviderCheckInfo record);
}