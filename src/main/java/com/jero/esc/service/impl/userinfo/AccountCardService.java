package com.jero.esc.service.impl.userinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.mapper.userinfo.AccountCardMapper;
import com.jero.esc.po.userinfo.AccountCard;
import com.jero.esc.service.userinfo.IAccountCardService;

@Service
public class AccountCardService implements IAccountCardService{
	@Autowired
	private AccountCardMapper accountCardMapper;
	
	@Override
	public List<AccountCard> queryAllCard(String logId) {
		return accountCardMapper.selectAllCard(logId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Integer addCard(AccountCard record) {
		return accountCardMapper.insertSelective(record);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Integer removeCard(AccountCard record) {
		return accountCardMapper.updateByPrimaryKey(record);
	}

}
