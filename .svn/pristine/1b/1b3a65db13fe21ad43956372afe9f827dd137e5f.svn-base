package com.jero.esc.service.bizinfo;


import org.apache.ibatis.session.RowBounds;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.po.bizinfo.FocusUtop;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;

public interface IFocusUtopService {
	
	Boolean add(FocusUtop record) throws Exception;
	
	//用户查找关注列表
	FastPage<FocusProvider> queryByUser(String User,RowBounds rowBounds)throws Exception;
	//服务商查看关注用户
	FastPage<FocusUser> queryByProvider(String Provider,RowBounds rowBounds)throws Exception;
	
	Boolean delete(FocusUtop record) throws Exception;
	//查询是否已关注
	Boolean queryByCon(FocusUtop record);

	/**
	 * 
	 *<pre>
	 *<b> 查询粉丝数量 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-16 上午11:37:27
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
	 *<b>Date:</b> 2017-11-16 下午3:35:32
	 *@param logId
	 *@return
	 *</pre>
	 */
	public int queryFocusCountFollow(String logId);
	
}
