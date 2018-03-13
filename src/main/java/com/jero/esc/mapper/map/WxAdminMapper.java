package com.jero.esc.mapper.map;

import com.jero.esc.po.map.WxAdmin;
import com.jero.esc.po.map.WxAdminExample;
import com.jero.esc.po.userinfo.FenXiao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    int countByExample(@Param("example") WxAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String wxAdminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    int insert(WxAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    int insertSelective(WxAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    List<WxAdmin> selectByExample(@Param("example") WxAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    WxAdmin selectByPrimaryKey(String wxAdminId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WxAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_admin
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WxAdmin record);

	public void saveFenXiaoId(FenXiao fx);
	
	public void delOpenId();

	public void addOpenId(String openId);
}