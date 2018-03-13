package com.jero.esc.mapper.details;

import com.jero.esc.po.details.ErrorLoginfoHome;

public interface ErrorLoginfoHomeMapper {
    int deleteByPrimaryKey(String elhId);

    int insert(ErrorLoginfoHome record);

    int insertSelective(ErrorLoginfoHome record);

    ErrorLoginfoHome selectByPrimaryKey(String elhId);

    int updateByPrimaryKeySelective(ErrorLoginfoHome record);

    int updateByPrimaryKey(ErrorLoginfoHome record);
}