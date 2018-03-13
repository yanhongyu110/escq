package com.jero.esc.service.impl.bizinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.mapper.bizinfo.RecommendPtopMapper;
import com.jero.esc.po.bizinfo.FocusUtop;
import com.jero.esc.po.bizinfo.RecommendPtop;
import com.jero.esc.service.bizinfo.IRecommendPtopService;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.RecommendProvider;
@Service
public class RecommendPtopService implements IRecommendPtopService {

	@Autowired
	private RecommendPtopMapper recommendPtopMapper;
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(RecommendPtop record)throws Exception {
		if(recommendPtopMapper.countByCon(record)>0){
				throw new Exception("已添加过推荐");
		}
		// TODO Auto-generated method stub
		return recommendPtopMapper.insert(record)>0;
	}

	@Override
	public FastPage<RecommendProvider> queryByPresenter(String rptpPresenter,RowBounds rowBounds)throws Exception {
		List<RecommendProvider> rps= recommendPtopMapper.selectByPresenter(rptpPresenter,rowBounds);
		RecommendPtop record=new RecommendPtop();
		record.setRptpPresenter(rptpPresenter);
		Integer totalSize = recommendPtopMapper.countByCon(record);
    	FastPage<RecommendProvider> psage = new FastPage<RecommendProvider>(rps, totalSize, (PageRowBounds)rowBounds);
        return psage;
	}

	@Override
	public List<RecommendProvider> queryByPresentee(String rptpPresentee)throws Exception {
		// TODO Auto-generated method stub
		return recommendPtopMapper.selectByPresentee(rptpPresentee);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(RecommendPtop record)throws Exception {
		if(recommendPtopMapper.countByCon(record)<=0){
			throw new Exception("暂未该推荐");
		}
		// TODO Auto-generated method stub
		return recommendPtopMapper.delete(record);
	}

}
