package com.jero.esc.service.bizinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.po.bizinfo.RecommendPtop;
import com.jero.esc.vo.bizinfo.RecommendProvider;

public interface IRecommendPtopService {
	
	Boolean add(RecommendPtop record)throws Exception;
	
	/**
	 *查找推荐的人
	 * @param rptpPresenter
	 * @return
	 */
	FastPage<RecommendProvider> queryByPresenter(String rptpPresenter,RowBounds rowBounds)throws Exception;
	/**
	 * 查找推荐自己的人
	 * @param rptpPresentee
	 * @return
	 */
	List<RecommendProvider> queryByPresentee(String rptpPresentee)throws Exception;
	
	int delete(RecommendPtop record)throws Exception;
	

}
