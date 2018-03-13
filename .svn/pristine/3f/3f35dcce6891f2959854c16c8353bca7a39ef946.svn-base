package com.jero.esc.mapper.userinfo;

import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.UserInfo;
import com.jero.esc.vo.userinfo.UserInfoVo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserInfo record);

    /**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 增加账户信息
	 * @param record
	 * @return Integer
	 * @method insertSelective
	 */
    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    /**
     * 
     * @version v1.0 (版本号)
     * @date 2016年12月9日
     * @description 通过登录信息查询个人资料
     * @param logId
     * @return UserInfoVo
     * @method UserInfoMapper
     */
    UserInfoVo selectUserinfoByLogId(String logId);
    /**
     * 
     * @version v1.0 (版本号)
     * @date 2016年12月12日
     * @description 修改个人信息
     * @param infoVo
     * @return int
     * @method UserInfoMapper
     */
    int  updateUserinfoById(UserInfoVo userInfoVo);
    /**
     * 
     * @version v1.0 (版本号)
     * @date 2016年12月14日
     * @description 重置密码
     * @param logId
     * @return Integer
     * @method LogInfoMapper
     */
    Integer updatePassByPrimaryKey(LogInfo logInfo);
    
    //通过logId修改信息
    int updateByLogIdSelective(UserInfo record);
}