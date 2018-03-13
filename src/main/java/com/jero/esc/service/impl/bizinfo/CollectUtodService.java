package com.jero.esc.service.impl.bizinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.mapper.bizinfo.CollectUtodMapper;
import com.jero.esc.po.bizinfo.CollectUtod;
import com.jero.esc.service.bizinfo.ICollectUtodService;
import com.jero.esc.vo.bizinfo.CollectDemand;
@Service
public class CollectUtodService implements ICollectUtodService {
	
	@Autowired
	private CollectUtodMapper collectUtodMapper; 
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(CollectUtod record) throws Exception {
		// TODO Auto-generated method stub
		if(collectUtodMapper.countByCon(record)>0){
			throw new Exception("已加入收藏");
		}
		return collectUtodMapper.insert(record)>0;
	}

	@Override
	public FastPage<CollectDemand> queryByUser(String User,RowBounds rowBounds) throws Exception {
		List<CollectDemand> lfp= collectUtodMapper.selectByUser(User,rowBounds);
		CollectUtod record=new CollectUtod();
		record.setCutdUser(User);
		Integer totalSize = collectUtodMapper.countByCon(record);
    	FastPage<CollectDemand> psage = new FastPage<CollectDemand>(lfp, totalSize, (PageRowBounds)rowBounds);
        return psage;
	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean delete(CollectUtod record) throws Exception {
		if(!(collectUtodMapper.countByCon(record)>0)){
			throw new Exception("没有该收藏，请刷新页面");
		}
		// TODO Auto-generated method stub
		return collectUtodMapper.delete(record)>0;
	}

	@Override
	public Boolean queryByCon(CollectUtod record){
		// TODO Auto-generated method stub
		if(collectUtodMapper.countByCon(record)>0){
			return true;
		}else{
		return false;}
	}

}
