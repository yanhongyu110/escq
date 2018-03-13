package com.jero.esc.mapper.bizinfo;

import com.jero.esc.po.bizinfo.BusinessTeam;

public interface BusinessTeamMapper {
    int deleteByPrimaryKey(String btId);

    int insert(BusinessTeam record);

    int insertSelective(BusinessTeam record);

    BusinessTeam selectByPrimaryKey(String btId);

    int updateByPrimaryKeySelective(BusinessTeam record);

    int updateByPrimaryKey(BusinessTeam record);
}