package com.jero.esc.mapper.system;

import com.jero.esc.po.system.SysAdminRole;

public interface SysAdminRoleMapper {
    int deleteByPrimaryKey(String adminRoleId);

    int insert(SysAdminRole record);

    int insertSelective(SysAdminRole record);

    SysAdminRole selectByPrimaryKey(String adminRoleId);

    int updateByPrimaryKeySelective(SysAdminRole record);

    int updateByPrimaryKey(SysAdminRole record);
}