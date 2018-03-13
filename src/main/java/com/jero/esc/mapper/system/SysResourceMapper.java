package com.jero.esc.mapper.system;

import com.jero.esc.po.system.SysResource;

public interface SysResourceMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Integer resourceId);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);
}