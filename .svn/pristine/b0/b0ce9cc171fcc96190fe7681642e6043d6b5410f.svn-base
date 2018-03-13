package com.jero.esc.service.checkinfo;

import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.po.userinfo.LogInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by blazh on 2016/12/8.
 */
public interface IPersonCheckNameService {

    /**
     * 添加一个实名认证
     */
    Boolean  addPersonCheckName(PersonCheckname PersonCheckname)throws  Exception;

    /**
     * 再次添加实名认证
     * @return
     */
    Boolean modifyCheckName(PersonCheckname logInfo)throws Exception;


    /**
     * 是否通过验证
     * @return
     */
    Boolean isChecked(String logId)throws Exception;


    /**
     * 根据logid找到
     * @return
     */
    PersonCheckname queryPersonCheckNameByUser(PersonCheckname logInfo);

    /**
     * 通过用户输入的身份证查找是否存在相同的身份证
     * @param pcnIdnumber
     * @return
     */
	Integer queryPcnIdnumberIsEquals(String pcnIdnumber);

}
