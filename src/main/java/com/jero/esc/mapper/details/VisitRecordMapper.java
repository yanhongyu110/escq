package com.jero.esc.mapper.details;

import com.jero.esc.po.details.VisitRecord;

public interface VisitRecordMapper {
    int deleteByPrimaryKey(String vrId);

    int insert(VisitRecord record);

    int insertSelective(VisitRecord record);

    VisitRecord selectByPrimaryKey(String vrId);

    int updateByPrimaryKeySelective(VisitRecord record);

    int updateByPrimaryKey(VisitRecord record);
}