package com.jero.esc.mapper.system;

import com.jero.esc.po.system.SysRoleToAuthorityKey;

public interface SysRoleToAuthorityMapper {
    int deleteByPrimaryKey(SysRoleToAuthorityKey key);

    int insert(SysRoleToAuthorityKey record);

    int insertSelective(SysRoleToAuthorityKey record);
}