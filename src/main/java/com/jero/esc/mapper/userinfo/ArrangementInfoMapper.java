package com.jero.esc.mapper.userinfo;

import java.util.List;

import com.jero.esc.po.userinfo.ArrangementInfo;

public interface ArrangementInfoMapper {
	
	List<ArrangementInfo> selectArrangeAll(ArrangementInfo arrange);
	
	List<ArrangementInfo> selectArrangeByDate(ArrangementInfo arrange);
	
	ArrangementInfo selectArrangeById(ArrangementInfo arrange);
	
	Integer deleteArrangeById(ArrangementInfo arrange);
	
	Integer insertArrange(ArrangementInfo arrange);
	
	Integer updateArrangeById(ArrangementInfo arrange);
	
}
