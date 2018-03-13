package com.jero.esc.mapper.system;

import com.jero.esc.po.system.SysUserToRoleKey;

public interface SysUserToRoleMapper {
    int deleteByPrimaryKey(SysUserToRoleKey key);

    int insert(SysUserToRoleKey record);

    int insertSelective(SysUserToRoleKey record);
}