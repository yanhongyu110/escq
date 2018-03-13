package com.jero.esc.mapper.system;

import com.jero.esc.po.system.SysAuthority;

public interface SysAuthorityMapper {
    int deleteByPrimaryKey(Integer authorityId);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    SysAuthority selectByPrimaryKey(Integer authorityId);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
}