package com.jero.esc.service.impl.checkinfo;

import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.mapper.checkinfo.PersonChecknameMapper;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.service.checkinfo.IPersonCheckNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by blazh on 2016/12/8.
 */
@Service
public class PersonCheckNameService implements IPersonCheckNameService {

    @Autowired
    PersonChecknameMapper personChecknameMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addPersonCheckName(PersonCheckname personCheckname) throws Exception {
        int i = personChecknameMapper.countByExample(personCheckname);
        if (i>0){
            throw new ExceptionWithMessage("不能重复认证",null);
        }
        personCheckname.setPcnCreatetime(new Date());
        personCheckname.setPcnId(UUIDUtil.getUUID());
        personCheckname.setPcnState(1);
        return    personChecknameMapper.insertSelective(personCheckname)>0;
    }

    /**
     * 再次添加实名认证
     * @param personCheckname
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean modifyCheckName(PersonCheckname personCheckname)throws Exception {
        PersonCheckname personCheckname1 = this.queryPersonCheckNameByUser(personCheckname);
        if (personCheckname1==null||personCheckname1.getPcnState()!=3){
            throw new ExceptionWithMessage("没有权限再次添加",null);
        }
        if (!personCheckname1.getLogId().equals(personCheckname.getLogId())){
            throw new ExceptionWithMessage("不合法的数据",null);
        }

        personCheckname.setPcnCreatetime(new Date());
        personCheckname.setPcnId(personCheckname1.getPcnId());
        personCheckname.setPcnState(1);

        return personChecknameMapper.updateByPrimaryKeySelective(personCheckname)>0;

    }

    /**
     * 是否通过验证
     * @param logId
     * @return
     */
    @Override
    public Boolean isChecked(String logId) throws Exception {
        PersonCheckname personCheckname = new PersonCheckname();
        personCheckname.setLogId(logId);
        PersonCheckname personCheckname1 = queryPersonCheckNameByUser(personCheckname);
        try{
        	return personCheckname1.getPcnState()==2;
        }catch(Exception e){
        	return false;
        }
        
    }


    @Override
    public PersonCheckname queryPersonCheckNameByUser(PersonCheckname logInfo) {
    	PersonCheckname p= new PersonCheckname();
    	p.setLogId(logInfo.getLogId());
        List<PersonCheckname> personChecknames = personChecknameMapper.selectByExample(p);
        if (personChecknames != null && personChecknames.size() == 1) {
            return personChecknames.get(0);
        } else {
            return null;
        }
    }

	@Override
	public Integer queryPcnIdnumberIsEquals(String pcnIdnumber) {
		return personChecknameMapper.selectPcnIdnumberIsEquals(pcnIdnumber);
	}


}
