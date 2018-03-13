package com.jero.esc.service.bizinfo;


import org.apache.ibatis.session.RowBounds;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.po.bizinfo.CollectUtod;
import com.jero.esc.vo.bizinfo.CollectDemand;

public interface ICollectUtodService {
	
	Boolean add(CollectUtod record) throws Exception;
	
	//用户查找关注列表
	FastPage<CollectDemand> queryByUser(String User,RowBounds rowBounds)throws Exception;
	
	Boolean delete(CollectUtod record) throws Exception;
	//查询是否已关注
	Boolean queryByCon(CollectUtod record);
	
}
