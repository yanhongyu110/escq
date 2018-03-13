package com.jero.esc.service.userinfo;

import java.util.List;

import com.jero.esc.po.userinfo.ArrangementInfo;

public interface IArrangementInfoService {
	
	List<ArrangementInfo> queryArrangeAll(ArrangementInfo arrange);
	
	List<ArrangementInfo> queryArrangeByDate(ArrangementInfo arrange);
	
	ArrangementInfo queryArrangeById(ArrangementInfo arrange);
	
	Integer removeArrangeById(ArrangementInfo arrange);
	
	Integer addArrange(ArrangementInfo arrange);
	
	Integer modifyArrange(ArrangementInfo arrange);
}
