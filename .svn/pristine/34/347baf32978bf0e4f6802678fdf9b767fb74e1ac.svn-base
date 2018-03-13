package com.jero.esc.mapper.checkinfo;

import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.po.userinfo.LogInfo;

import java.util.List;

public interface PersonChecknameMapper {
    int deleteByPrimaryKey(String pcnId);

    int insert(PersonCheckname record);

    int insertSelective(PersonCheckname record);

    PersonCheckname selectByPrimaryKey(String pcnId);

    int updateByPrimaryKeySelective(PersonCheckname record);

    int updateByPrimaryKey(PersonCheckname record);

    List<PersonCheckname> selectByExample(PersonCheckname logInfo);


    int countByExample(PersonCheckname logInfo);

	Integer selectPcnIdnumberIsEquals(String pcnIdnumber);
	
	//通过logID修改实名信息
	Integer updateByLogIdSelective(PersonCheckname record);

}