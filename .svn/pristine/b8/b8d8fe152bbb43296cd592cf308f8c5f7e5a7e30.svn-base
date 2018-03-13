/**
 * @Title IServiceRemarkService.java
 * @Package: com.jero.esc.service.goodsinfo 
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0 
 * @date 2016年12月18日
 * @description
 */
package com.jero.esc.service.goodsinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.goodsinfo.ServiceRemark;

/**
 * @ClassName: IServiceRemarkService 
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0 
 * @date 2016年12月18日
 * @description
 */
public interface IServiceRemarkService {

	
	
	
	/**
	*@description 添加评论
	*@param serviceRemark
	*@return Boolean
	*@method addServiceRemark
	 */
	Boolean addServiceRemark(ServiceRemark serviceRemark)throws Exception;
	
	/**
	*@description 修改评论信息（例：添加回复等）
	*@param serviceRemark
	*@return Boolean
	*@method modifyServiceRemark
	 */
	Boolean modifyServiceRemark(ServiceRemark serviceRemark)throws Exception;
	
	/**
	*@description 通过logId查询账户的所有评价并分页
	*@param StringBuffer
	*@return List<ServiceRemark>
	*@method queryServiceRemark
	 */
	List<ServiceRemark> queryServiceRemarkByLogId(StringBuffer logid,RowBounds rowBounds)throws Exception;
	
	/**
	*@description 通过serviceId查询商品有关所有评论并分页
	*@param serviceId
	*@return List<ServiceRemark>
	*@method queryServiceRemarkByServiceId
	 */
	List<ServiceRemark>  queryServiceRemarkByServiceId(StringBuffer serviceId,RowBounds rowBounds)throws Exception;
	
	
}
