package com.jero.esc.service.impl.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jero.esc.mapper.userinfo.ThirdPartyLoginMapper;
import com.jero.esc.service.userinfo.ThirdPartyLoginService;
import com.jero.esc.vo.userinfo.ThirdPartyLogin;
@Service
public class ThirdPartyLoginServiceImpl implements ThirdPartyLoginService{

	@Autowired
	private ThirdPartyLoginMapper thirdPartyLoginMapper;
	
	
	@Override
	public void addthirdPartyLogin(ThirdPartyLogin login) {
		thirdPartyLoginMapper.addthirdPartyLogin(login);
	}


	@Override
	public ThirdPartyLogin selectLog(String openid) {
		return thirdPartyLoginMapper.selectLog(openid);
	}


	@Override
	public ThirdPartyLogin selectLogById(String logId) {
		return thirdPartyLoginMapper.selectLogById(logId);
	}


	@Override
	public ThirdPartyLogin selectQQLog(String openid) {
		return thirdPartyLoginMapper.selectQQLog(openid);
	}
}
