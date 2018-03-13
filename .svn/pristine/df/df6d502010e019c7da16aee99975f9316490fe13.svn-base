package com.jero.esc.mapper.bizinfo;


import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.bizinfo.FocusUtop;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;

public interface FocusUtopMapper {

    int insert(FocusUtop record);

    int insertSelective(FocusUtop record);
    //查看我关注的
    List<FocusProvider> selectByUser(String futpUser,RowBounds rowBounds);
    //查看关注我的
    List<FocusUser> selectByProvider(String futpProvider,RowBounds rowBounds);
    
    Integer countByCon(FocusUtop record);
    
    int delete(FocusUtop record);

    /**
     * 
     *<pre>
     *<b> 查询粉丝数量.</b>
     *<b>Description:</b> 
     *    根据用户id
     *<b>Author:</b> yanhongyu
     *<b>Date:</b> 2017-11-16 上午11:38:24
     *@param logId
     *@return
     *</pre>
     */
	public int queryFocusCount(String logId);

	/**
	 * 
	 *<pre>
	 *<b> 查询关注数量 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-16 下午3:36:29
	 *@param logId
	 *@return
	 *</pre>
	 */
	public int queryFocusCountFollow(String logId);
    
}