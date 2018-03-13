package com.jero.esc.mapper.goodsinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.po.goodsinfo.ServiceRemark;
import com.jero.esc.vo.goodsinfo.RemarkCountVo;
import com.jero.esc.vo.goodsinfo.ServiceRemarkVo;
public interface ServiceRemarkMapper {
    int deleteByPrimaryKey(String srId);

    int insert(ServiceRemark record);

    int insertSelective(ServiceRemark record);

    ServiceRemark selectByPrimaryKey(String srId);

    int updateByPrimaryKeySelective(ServiceRemark record);

    int updateByPrimaryKey(ServiceRemark record);

    public List<ServiceRemarkVo> selectServiceRemarkByServiceId(ServiceRemarkVo serviceRemarkVo,RowBounds rowBounds);
    
  	public Integer selectCountServiceRemarkByServiceId(ServiceRemarkVo serviceRemarkVo);
  	
  	public Integer CountServiceRemarkByServiceId(String  serviceId);
  	
  	public List<RemarkCountVo> selectCountRemark(RemarkCountVo remarkCountVo);
  	
  	public Integer selectCountServiceRemarkByTime(@Param("logId")String logId,@Param("srLevel")Integer srLevel,@Param("createtime")Integer createtime);
  	
  	public Integer selectServiceRemarkByLogId(@Param("logId")String logId,@Param("srLevel")Integer srLevel,@Param("createtime")Integer createtime);
  	
  	public List<ServiceRemarkVo> queryServiceRemarkByLogIdSrLevel(ServiceRemarkVo serviceRemarkVo,RowBounds rowBounds);
    
  	public Integer queryCountServiceRemarkByLogIdSrLevel(ServiceRemarkVo serviceRemarkVo);
  	
  	public List<RemarkCountVo> selectCountRemarkLogId(RemarkCountVo remarkCountVo);
  	
  	public List<ServiceRemarkVo> selectServiceRemarkByLogIdServiceId(ServiceRemarkVo serviceRemarkVo,RowBounds rowBounds);
    
  	public Integer selectCountServiceRemarkByLogIdServiceId(ServiceRemarkVo serviceRemarkVo);
  	
  	public List<RemarkCountVo> selectCountRemarkByLogIdServiceId(RemarkCountVo remarkCountVo);

  	/**
  	 * 
  	 *<pre>
  	 *<b> 查询服务评论总条数 .</b>
  	 *<b>Description:</b> 
  	 *    
  	 *<b>Author:</b> yanhongyu
  	 *<b>Date:</b> 2017-11-17 上午10:51:34
  	 *@param serviceId
  	 *@return
  	 *</pre>
  	 */
	public Integer queryCountServiceRemarkByServiceId(String serviceId);
}