package com.jero.esc.service.impl.userinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.mapper.system.SystemMegsMapper;
import com.jero.esc.mapper.userinfo.UserInfoMapper;
import com.jero.esc.po.system.SystemMegs;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.UserInfo;
import com.jero.esc.service.userinfo.IUserInfoService;
import com.jero.esc.vo.userinfo.SystemMesVo;
import com.jero.esc.vo.userinfo.UserInfoVo;

/**
 * @copyright 上善云图信息技术有限公司
 * @author zqy
 * @version v1.0 （版本号）
 * @date 2016年12月8日
 * @description 个人用户信息
 */
@Service
public class UserInfoService implements IUserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private SystemMegsMapper systemMegsMapper;

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 增加账户信息
	 * @param record
	 * @return Integer
	 * @method addSelective
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer addSelective(UserInfo record) {
		return userInfoMapper.insertSelective(record);
	}

	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月9日
	 * @description 查询个人信息
	 * @param logId
	 * @return UserInfoVo
	 * @method showUserinfoByCon
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public UserInfoVo showUserinfoByCon(String logId) {
		return userInfoMapper.selectUserinfoByLogId(logId);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月12日
	 * @description 修改用户基本信息
	 * @param infoVo
	 * @return int
	 * @method modifyUserinfo
	 */
	@Transactional(rollbackFor = Exception.class)
	public int modifyUserinfo(UserInfoVo userInfoVo) {
		return userInfoMapper.updateUserinfoById(userInfoVo);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月14日
	 * @description 重置密码
	 * @param logInfo
	 * @return Integer
	 * @method modifyPassByPrimaryKey
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer modifyPassByPrimaryKey(LogInfo logInfo) {
		return userInfoMapper.updatePassByPrimaryKey(logInfo);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月27日
	 * @description 查询所有个人的系统消息
	 * @return List<SystemMegs>
	 * @method queryAllSystemMes
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<SystemMesVo> queryAllSystemMes(SystemMesVo sysMes, RowBounds rb) {
		return systemMegsMapper.selectAllMes(sysMes, rb);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月27日
	 * @description 通过id删除系统消息
	 * @return List<SystemMegs>
	 * @method removeMesByPrimaryKey
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer removeMesByPrimaryKey(String smId) {
		return systemMegsMapper.deleteMesByPrimaryKey(smId);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月10日
	 * @description 通过登录信息查看消息总条数
	 * @param sysMes
	 * @return int
	 * @method selectMesCountBylogId
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int selectMesCountBylogId(SystemMesVo sysMes) {
		return systemMegsMapper.selectMesCountBylogId(sysMes);
	}

}
