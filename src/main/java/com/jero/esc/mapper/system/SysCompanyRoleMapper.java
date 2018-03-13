package com.jero.esc.mapper.system;

import com.jero.esc.po.system.SysCompanyRole;

public interface SysCompanyRoleMapper {
    int deleteByPrimaryKey(String companyRoleId);

    int insert(SysCompanyRole record);

    int insertSelective(SysCompanyRole record);

    SysCompanyRole selectByPrimaryKey(String companyRoleId);

    int updateByPrimaryKeySelective(SysCompanyRole record);

    int updateByPrimaryKey(SysCompanyRole record);
}