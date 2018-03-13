package com.jero.esc.mapper.system;

import com.jero.esc.po.system.SysPlatformPara;

public interface SysPlatformParaMapper {
    int deleteByPrimaryKey(String sysParaId);

    int insert(SysPlatformPara record);

    int insertSelective(SysPlatformPara record);

    SysPlatformPara selectByPrimaryKey(String sysParaId);

    int updateByPrimaryKeySelective(SysPlatformPara record);

    int updateByPrimaryKey(SysPlatformPara record);
}