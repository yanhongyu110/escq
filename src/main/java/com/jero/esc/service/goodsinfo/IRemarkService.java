package com.jero.esc.service.goodsinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.goodsinfo.ServiceRemark;
import com.jero.esc.po.saleinfo.OrderService;
import com.jero.esc.vo.goodsinfo.RemarkCountVo;
import com.jero.esc.vo.goodsinfo.ServiceRemarkVo;

/**
 * Created by blazh on 2016/12/29.
 */
public interface IRemarkService {



    /**
     * 根据订单商品id得到商品与评价
     * @param orderService
     * @return
     */
    OrderService getOrderServiceWithRemark(OrderService orderService) throws  Exception;

    /**
     * 评价
     * @param serviceRemark
     * @return
     * @throws Exception
     */
    Boolean addRemark(ServiceRemark serviceRemark)throws  Exception;

    /**
     * 修改评价
     * @param serviceRemark
     * @return
     * @throws Exception
     */
    Boolean modifyRemark(ServiceRemark serviceRemark)throws  Exception;

    /**
     * 根据订单商品id查询评价
     * @param serviceRemarkVo
     * @param rowBounds
     * @return List<ServiceRemarkVo>
     * @throws Exception
     */
    public List<ServiceRemarkVo> queryServiceRemarkByServiceId(ServiceRemarkVo serviceRemarkVo,RowBounds rowBounds)throws Exception;
    
    /**
	 * @description 根据订单商品id查询所有评论数量
	 * @param serviceRemark
	 * @return Integer
	 * @throws Exception
	 */
	public Integer queryCountServiceRemarkByServiceId(ServiceRemarkVo serviceRemarkVo)throws Exception;
	
	/**
	 * @description 根据服务id查询不同评分的评论数量
	 * @param serviceRemarkCountVo
	 * @return List<Integer>
	 * @throws Exception
	 */
	public List<RemarkCountVo> queryCountRemark(RemarkCountVo remarkCountVo)throws Exception;
	
	/**
	 * @description 根据时间或好评等级查询评论数量
	 * @param logId
	 * @param srLevel
	 * @param createtime
	 * @return Integer
	 * @throws Exception
	 */
	public Integer[] queryAllCountServiceRemarkByTime(String logId);
	
	public Integer[] queryCountServiceRemarkByTime(String logId, Integer srLevel, Integer createtime);
	/**
	 * @description 服务商查看别人对自己的评价
	 * @param logId
	 * @return  List<ServiceRemark>
	 * @throws Exception
	 */
	public Integer[] queryServiceRemarkByLogId(@Param("logId")String logId);
	/**
	 * @description 服务商查看别人对自己的评价
	 * @param logId
	 * @return  List<ServiceRemark>
	 * @throws Exception
	 */

	/**
     * 根据log_id和评分查询评价
     * @param serviceRemarkVo
     * @param rowBounds
     * @return List<ServiceRemarkVo>
     * @throws Exception
     */
    public List<ServiceRemarkVo> queryServiceRemarkByLogIdSrLevel(ServiceRemarkVo serviceRemarkVo,RowBounds rowBounds)throws Exception;
    
    /**
	 * @description 根据log_id和评分查询所有评论数量
	 * @param serviceRemark
	 * @return Integer
	 * @throws Exception
	 */
	public Integer queryCountServiceRemarkByLogIdSrLevel(ServiceRemarkVo serviceRemarkVo)throws Exception;
	
	/**
	 * @description 根据logid查询不同评分的评论数量
	 * @param serviceRemarkCountVo
	 * @return List<Integer>
	 * @throws Exception
	 */
	public List<RemarkCountVo> queryCountRemarkLogId(RemarkCountVo remarkCountVo)throws Exception;
	
	/**
     * description 服务商查看别人对自己的评价
     * @param ServiceMyRemarkVo
     * @param rowBounds
     * @return List<ServiceMyRemarkVo>
     * @throws Exception
     */
    public List<ServiceRemarkVo> queryServiceRemarkByLogIdServiceId(ServiceRemarkVo serviceRemarkVo,RowBounds rowBounds)throws Exception;
    
    /**
	 * @description 服务商查看别人对自己的评价
	 * @param ServiceMyRemarkVo
	 * @return Integer
	 * @throws Exception
	 */
	public Integer queryCountServiceRemarkByLogIdServiceId(ServiceRemarkVo serviceRemarkVo)throws Exception;
	
	/**
	 * @description 根据logId和serviceId查询不同评分的评论数量
	 * @param serviceRemarkCountVo
	 * @return List<Integer>
	 * @throws Exception
	 */
	public List<RemarkCountVo> queryCountRemarkLogIdServiceId(RemarkCountVo remarkCountVo)throws Exception;

	/**
	 * 
	 *<pre>
	 *<b> 查询服务评论的总条数 .</b>
	 *<b>Description:</b> 
	 *    根据服务id
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-17 上午10:50:32
	 *@param serviceId
	 *@return
	 *</pre>
	 */
	public Integer queryCountServiceRemarkByServiceId(String serviceId);
}
