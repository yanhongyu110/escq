package com.jero.esc.service.impl.userinfo;


import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.po.userinfo.ServiceInfo;
import com.jero.esc.service.userinfo.IProviderDetailsService;

@Service
public class ProviderDetailsService implements IProviderDetailsService {
	
	@Autowired
	ProviderInfoMapper providerInfoMapper;

	public ProviderInfo queryProviderDetailsById(LogInfo logInfo,String com) {
	    return providerInfoMapper.selectProviderDetailsById(logInfo,com);
	}

	@Override
	public List<ServiceInfo> queryServiceInfoById(LogInfo logInfo) {
		return providerInfoMapper.selectServiceInfoById(logInfo);
	}

	@Override
	public List<ServiceInfo> queryServiceInfoByCon(LogInfo logInfo, RowBounds rowBounds) {
		// TODO Auto-generated method stub
		return providerInfoMapper.selectServiceInfoByCon( logInfo,  rowBounds);
	}

	@Override
	public int countServiceInfoByCon(LogInfo logInfo) {
		// TODO Auto-generated method stub
		return providerInfoMapper.countServiceInfoByCon( logInfo);
	}

}
