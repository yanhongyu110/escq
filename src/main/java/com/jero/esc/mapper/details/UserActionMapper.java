package com.jero.esc.mapper.details;

import com.jero.esc.po.details.UserAction;

public interface UserActionMapper {
    int deleteByPrimaryKey(String uaId);

    int insert(UserAction record);

    int insertSelective(UserAction record);

    UserAction selectByPrimaryKey(String uaId);

    int updateByPrimaryKeySelective(UserAction record);

    int updateByPrimaryKey(UserAction record);
}