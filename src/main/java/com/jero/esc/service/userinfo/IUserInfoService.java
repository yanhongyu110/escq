package com.jero.esc.service.userinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.UserInfo;
import com.jero.esc.vo.userinfo.SystemMesVo;
import com.jero.esc.vo.userinfo.UserInfoVo;

/**
 * @copyright 上善云图信息技术有限公司
 * @author zqy
 * @version v1.0 （版本号）
 * @date 2016年12月8日
 * @description 个人用户信息
 */
public interface IUserInfoService {

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 增加账户信息
	 * @param record
	 * @return Integer
	 * @method addSelective
	 */
	Integer addSelective(UserInfo record);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月9日
	 * @description 查看用户基本信息
	 * @param logId
	 * @return UserInfoVo
	 * @method IUserInfoService
	 */
	UserInfoVo showUserinfoByCon(String logId);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月12日
	 * @description 修改用户基本信息
	 * @param infoVo
	 * @return int
	 * @method IUserInfoService
	 */
	int modifyUserinfo(UserInfoVo userInfoVo);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月14日
	 * @description 重置密码
	 * @param logInfo
	 * @return Integer
	 * @method ILogInfoService
	 */
	Integer modifyPassByPrimaryKey(LogInfo logInfo);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月27日
	 * @description 查询所有个人的系统消息
	 * @return List<SystemMegs>
	 * @method queryAllSystemMes
	 */
	List<SystemMesVo> queryAllSystemMes(SystemMesVo sysMes, RowBounds rb);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月28日
	 * @description 通过id删除系统消息
	 * @param smId
	 * @return Integer
	 * @method removeMesByPrimaryKey
	 */
	Integer removeMesByPrimaryKey(String smId);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月10日
	 * @description 通过登录信息查看消息总条数
	 * @param sysMes
	 * @return int
	 * @method selectMesCountBylogId
	 */
	int selectMesCountBylogId(SystemMesVo sysMes);
}
