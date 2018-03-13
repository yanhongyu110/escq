package com.jero.esc.service.goodsinfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.goodsinfo.ServiceStep;
import com.jero.esc.vo.goodsinfo.ServiceInfoVo;
import com.jero.esc.vo.userinfo.ServiceVo;

/**
 * Created by blazh on 2016/12/12.
 */
public interface IServiceService {

	/**
	 * 修改服务点赞人数
	 * @param serviceId
	 * @param flag true：点赞 false：取消点赞
	 * @return
	 */
	Boolean updateService(String serviceId, Boolean flag);
	/**
	 * 修改服务收藏人数
	 * @param serviceId
	 * @param flag true：收藏 false：取消收藏
	 * @return
	 */
	Boolean updateServiceCollectNum(String serviceId, Boolean flag);

	/**
	 * 添加服务
	 * 
	 * @return
	 * @throws Exception
	 */
	Boolean addService(ServiceInfo serviceInfo) throws Exception;

	/**
	 * 修改服务
	 * 
	 * @return
	 * @throws Exception
	 */
	Boolean modifyService(ServiceInfo serviceInfo) throws Exception;

	/**
	 * 删除服务
	 * 
	 * @return
	 * @throws Exception
	 */
	Boolean removeService(ServiceInfo serviceInfo) throws Exception;
	
	/**
	 * 查询服务
	 * 
	 * @param serviceInfo
	 * @param rowBounds
	 * @return FastPage
	 * @throws Exception
	 */
	FastPage<ServiceVo> queryServiceInfo(ServiceVo ServiceVo, RowBounds rowBounds) throws Exception;

	/**
	 * 根据要求查询
	 * 
	 * @param serviceInfo
	 * @param require
	 * @return
	 * @throws Exception
	 */
	FastPage queryServiceByReqiure(ServiceInfo serviceInfo, Map<String, String> require, RowBounds rowBounds)
			throws Exception;

	/**
	 * 根据id查询服务
	 * @param servicevo
	 * @return
	 * @throws Exception
	 */
	ServiceInfo queryByPrimaryKey(String serviceId) throws Exception;

	/**
	 * 查询服务详情及相关的所有信息
	 * 
	 * @param servicevo
	 * @return
	 * @throws Exception
	 */

	ServiceVo queryServiceVoDetailsById(String serviceId,Integer priceType,String com) throws Exception;

	List<ServiceStep> selectServiceSetById(String serviceId) throws Exception;

	/**
	 * 
	 * @version v1.0
	 * @date 2016年12月27日
	 * @description 首页查询服务
	 * @return
	 * @return List<ServiceInfo>
	 * @method selectHomeServiceInfo
	 */
	List<ServiceInfoVo> queryHomeServiceInfo(String serviceTypetree,String com);
	
	/**
	  *@version v1.0
	  *@date 2017年1月9日
	  *@description 通过服务类型查询服务
	  *@param serviceInfoVo
	  *@return List<ServiceInfoVo>
	  *@method queryServiceByType
	 */
	List<ServiceInfoVo> queryServiceByType(RowBounds rb,String serviceTypetree,String order,String province,String city,String area);
	
	/**
	  *@version v1.0
	  *@date 2017年1月9日
	  *@description 查询服务条数
	  *@param serviceInfoVo
	  *@return Integer
	  *@method queryServiceCountByType
	 */
	Integer queryServiceCountByType(String serviceTypetree,String province,String city,String area,String com);
	
	/**
	  *@version v1.0
	  *@date 2017年1月10日
	  *@description 条件搜索服务
	  *@param rb
	  *@param search
	  *@param order
	  *@return List<ServiceInfoVo>
	  *@method queryServiceByCon
	 */
	List<ServiceInfoVo> queryServiceByCon(RowBounds rb,String search,String order,String province,String city,String area,String type,String point);

	/**
	  *@version v1.0
	  *@date 2017年1月10日
	  *@description 条件搜索服务条数
	  *@param search
	  *@param order
	  *@return Integer
	  *@method selectServiceCountByCon
	 */
	Integer queryServiceCountByCon(String search,String order,String province,String city,String area,String type);

	List<ServiceVo> queryServiceByProvider(String order, RowBounds rb,String com);
    
    Integer queryServiceCountByProvider(String order,String com);
    
    List<ServiceInfoVo> queryGreatService(String order, RowBounds rb,String com);
    
    Integer queryGreatServiceCount(String order,String com);
    
    List<ServiceVo> queryServiceByModule(String serviceTypetree,RowBounds rb);

}
