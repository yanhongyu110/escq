package com.jero.esc.mapper.pubinfo;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.pubinfo.CommonTypeExample;
import com.jero.esc.po.pubinfo.CommonTypeImg;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommonTypeMapper {

    List<CommonType>  selectChainByFid(String chiain);

    int countByExample(CommonTypeExample example);

    int deleteByExample(CommonTypeExample example);

    int deleteByPrimaryKey(String ctId);

    int insert(CommonType record);

    int insertSelective(CommonType record);

    List<CommonType> selectByExample(CommonTypeExample example);

    CommonType selectByPrimaryKey(String ctId);

    int updateByExampleSelective(@Param("record") CommonType record, @Param("example") CommonTypeExample example);

    int updateByExample(@Param("record") CommonType record, @Param("example") CommonTypeExample example);

    int updateByPrimaryKeySelective(CommonType record);

    int updateByPrimaryKey(CommonType record);

    /**
     * 
     *<pre>
     *<b> 根据类型id获取图片 .</b>
     *<b>Description:</b> 
     *    
     *<b>Author:</b> yanhongyu
     *<b>Date:</b> 2017-11-2 下午4:48:09
     *@param id
     *@return
     *</pre>
     */
	public CommonTypeImg findCommonTypeImgById(String id);
}