package com.jero.esc.mapper.details;

import com.jero.esc.po.details.BrowsHistory;

public interface BrowsHistoryMapper {
    int deleteByPrimaryKey(String bhId);

    int insert(BrowsHistory record);

    int insertSelective(BrowsHistory record);

    BrowsHistory selectByPrimaryKey(String bhId);

    int updateByPrimaryKeySelective(BrowsHistory record);

    int updateByPrimaryKey(BrowsHistory record);
}