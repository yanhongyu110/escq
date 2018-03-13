package com.jero.esc.mapper.bizinfo;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.bizinfo.RecommendPtop;
import com.jero.esc.vo.bizinfo.RecommendProvider;

public interface RecommendPtopMapper {

    int insert(RecommendPtop record);

    int insertSelective(RecommendPtop record);
    //查看我推荐的服务商
    List<RecommendProvider> selectByPresenter(String rptpPresenter,RowBounds rowBounds);
    //查看推荐我的服务商
    List<RecommendProvider> selectByPresentee(String rptpPresentee);
    
    int countByCon(RecommendPtop record);
    
    int delete(RecommendPtop record);
    
}