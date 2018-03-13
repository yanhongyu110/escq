package com.jero.esc.service.impl.bizinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.mapper.bizinfo.FocusUtopMapper;
import com.jero.esc.po.bizinfo.FocusUtop;
import com.jero.esc.service.bizinfo.IFocusUtopService;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;
@Service
public class FocusUtopService implements IFocusUtopService {
	
	@Autowired
	private FocusUtopMapper focusUtopMapper; 
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean add(FocusUtop record) throws Exception {
		// TODO Auto-generated method stub
		if(focusUtopMapper.countByCon(record)>0){
			throw new Exception("已加入关注");
		}
		return focusUtopMapper.insert(record)>0;
	}

	@Override
	public FastPage<FocusProvider> queryByUser(String User,RowBounds rowBounds) throws Exception {
		List<FocusProvider> fps= focusUtopMapper.selectByUser(User,rowBounds);
		FocusUtop record=new FocusUtop();
		record.setFutpUser(User);
		Integer totalSize = focusUtopMapper.countByCon(record);
    	FastPage<FocusProvider> psage = new FastPage<FocusProvider>(fps, totalSize, (PageRowBounds)rowBounds);
        return psage;
	}

	@Override
	public FastPage<FocusUser> queryByProvider(String Provider,RowBounds rowBounds)throws Exception {
		List<FocusUser> fus= focusUtopMapper.selectByProvider(Provider,rowBounds);
		FocusUtop record=new FocusUtop();
		record.setFutpProvider(Provider);
		Integer totalSize = focusUtopMapper.countByCon(record);
    	FastPage<FocusUser> psage = new FastPage<FocusUser>(fus, totalSize, (PageRowBounds)rowBounds);
        return psage;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean delete(FocusUtop record) throws Exception {
		if(!(focusUtopMapper.countByCon(record)>0)){
			throw new Exception("没有该关注，请刷新页面");
		}
		// TODO Auto-generated method stub
		return focusUtopMapper.delete(record)>0;
	}

	@Override
	public Boolean queryByCon(FocusUtop record){
		// TODO Auto-generated method stub
		if(focusUtopMapper.countByCon(record)>0){
			return true;
		}else{
		return false;}
	}

	@Override
	public int queryFocusCount(String logId) {
		return focusUtopMapper.queryFocusCount(logId);
	}

	@Override
	public int queryFocusCountFollow(String logId) {
		return focusUtopMapper.queryFocusCountFollow(logId);
	}

}
