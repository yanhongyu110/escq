package com.jero.esc.service.impl.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.mapper.userinfo.ArrangementInfoMapper;
import com.jero.esc.po.userinfo.ArrangementInfo;
import com.jero.esc.service.userinfo.IArrangementInfoService;

@Service
public class ArrangementInfoService implements IArrangementInfoService {
	@Autowired
	ArrangementInfoMapper arrangementInfoMapper;

	public List<ArrangementInfo> queryArrangeAll(ArrangementInfo arrange) {
		return arrangementInfoMapper.selectArrangeAll(arrange);
	}

	public List<ArrangementInfo> queryArrangeByDate(ArrangementInfo arrange) {
		return arrangementInfoMapper.selectArrangeByDate(arrange);
	}

	public ArrangementInfo queryArrangeById(ArrangementInfo arrange) {
		return arrangementInfoMapper.selectArrangeById(arrange);
	}

	@Transactional
	public Integer removeArrangeById(ArrangementInfo arrange) {
		return arrangementInfoMapper.deleteArrangeById(arrange);
	}

	@Transactional
	public Integer addArrange(ArrangementInfo arrange) {
		return arrangementInfoMapper.insertArrange(arrange);
	}

	@Transactional
	public Integer modifyArrange(ArrangementInfo arrange) {
		return arrangementInfoMapper.updateArrangeById(arrange);
	}
	
	
	
	

}
