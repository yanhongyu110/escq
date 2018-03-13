package com.jero.esc.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.system.SystemMegs;
import com.jero.esc.vo.userinfo.SystemMesVo;

public interface SystemMegsMapper {

	int deleteByPrimaryKey(String smId);

	int insert(SystemMegs record);

	int insertSelective(SystemMegs record);

	SystemMegs selectByPrimaryKey(String smId);

	int updateByPrimaryKeySelective(SystemMegs record);

	int updateByPrimaryKey(SystemMegs record);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月27日
	 * @description 查询所有系统消息
	 * @return List<SystemMegs>
	 * @method selectAllMes
	 */
	List<SystemMesVo> selectAllMes(@Param("sysMes") SystemMesVo sysMes, RowBounds rb);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2016年12月28日
	 * @description 通过主键删除信息
	 * @param smId
	 * @return int
	 * @method deleteMesByPrimaryKey
	 */
	int deleteMesByPrimaryKey(String smId);

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月10日
	 * @description通过登录信息查看消息总条数
	 * @param sysMes
	 * @return int
	 * @method selectMesCountBylogId
	 */
	int selectMesCountBylogId(SystemMesVo sysMes);
}