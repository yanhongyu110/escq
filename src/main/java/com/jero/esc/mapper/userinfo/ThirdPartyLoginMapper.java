package com.jero.esc.mapper.userinfo;

import com.jero.esc.vo.userinfo.ThirdPartyLogin;

public interface ThirdPartyLoginMapper {

	public void addthirdPartyLogin(ThirdPartyLogin login);

	public ThirdPartyLogin selectLog(String openid);

	public ThirdPartyLogin selectLogById(String logId);

	public ThirdPartyLogin selectQQLog(String openid);

}
