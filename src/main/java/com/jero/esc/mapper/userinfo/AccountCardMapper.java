package com.jero.esc.mapper.userinfo;

import java.util.List;

import com.jero.esc.po.userinfo.AccountCard;

public interface AccountCardMapper {
	List<AccountCard> selectAllCard(String logId);
	
    int deleteByPrimaryKey(String acId);

    int insert(AccountCard record);

    int insertSelective(AccountCard record);

    AccountCard selectByPrimaryKey(String acId);

    int updateByPrimaryKeySelective(AccountCard record);

    int updateByPrimaryKey(AccountCard record);
}