package com.jero.esc.service.impl.pubinfo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jero.esc.mapper.pubinfo.SwitchInfoMapper;
import com.jero.esc.po.pubinfo.SwitchInfo;
import com.jero.esc.service.pubinfo.ISwitchInfoService;
@Service
public class SwitchInfoService implements ISwitchInfoService{

	@Autowired
	private SwitchInfoMapper switchInfoMapper; 
	
	@Override
	public List<SwitchInfo> queryPicByPosition(SwitchInfo switchInfo) {
		return switchInfoMapper.selectPicByPosition(switchInfo);
	}

}
