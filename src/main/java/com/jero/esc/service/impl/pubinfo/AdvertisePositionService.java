package com.jero.esc.service.impl.pubinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jero.esc.mapper.pubinfo.AdvertisePositionMapper;
import com.jero.esc.po.pubinfo.AdvertisePosition;
import com.jero.esc.service.pubinfo.IAdvertisePositionService;
@Service
public class AdvertisePositionService implements IAdvertisePositionService{

	@Autowired
	private AdvertisePositionMapper advertisePositionMapper;
	
	@Override
	public List<AdvertisePosition> queryAdByPosition(AdvertisePosition advertisePosition) {
		return advertisePositionMapper.selectAdByPosition(advertisePosition);
	}

}
