package com.jero.esc.mapper.details;

import java.util.List;

import com.jero.esc.po.details.MegDetails;

public interface MegDetailsMapper {
    int deleteByPrimaryKey(String mdId);

    int insert(MegDetails record);

    int insertSelective(MegDetails record);

    MegDetails selectByPrimaryKey(String mdId);

    int updateByPrimaryKeySelective(MegDetails record);

    int updateByPrimaryKey(MegDetails record);

	void updateMegIsSee(String logId);

	List<MegDetails> selectListByLogId(String logId);
}