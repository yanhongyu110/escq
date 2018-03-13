package com.jero.esc.mapper.bizinfo;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.bizinfo.CollectUtod;
import com.jero.esc.vo.bizinfo.CollectDemand;

public interface CollectUtodMapper {

    int insert(CollectUtod record);

    int insertSelective(CollectUtod record);
    //查看我收藏的
    List<CollectDemand> selectByUser(String cutdUser,RowBounds rowBounds);
    
    Integer countByCon(CollectUtod record);
    
    int delete(CollectUtod record);
    
}