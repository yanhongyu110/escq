package com.jero.esc.service.demand;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.vo.demand.Demand;
import com.jero.esc.vo.demand.DemandVo;

public interface IDemandService {



	List<Demand> takeList(String search,String typeTree,String order,RowBounds rowBounds);
	
	List<DemandVo> takeList1(String search,String typeTree,String order,RowBounds rowBounds);

	int takeListCount(String search,String typeTree,String com);


	//获取指定的需求
	List<Demand> takeTopByCount(Integer top,String module);
	//获取带用户头像的vo对象集合
	List<DemandVo> takeTopByCount1(Integer top,String module);

	JsonResult addDemand(Demand demand, String id);
	
	List<DemandVo> selectAll(RowBounds rowBounds, Demand demand);
	
	List<Demand> selectOthers(Demand demand);
	
	int count(Demand demand);
	
	List<Demand> selectAll1(RowBounds rowBounds, Demand demand);
	
	int count1(Demand demand);
	
	DemandVo selectDemandVoById(String id);
	
	Demand selectById(String id);
	
	JsonResult updateById(Demand demand);

	/**
	 * 
	 *<pre>
	 *<b> 查询需求列表 .</b>
	 *<b>Description:</b> 
	 *    根据logId
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-11-15 下午5:53:11
	 *@param rowBounds 分页
	 *@param logId 用户Id
	 *@return 需求集合
	 *</pre>
	 */
	public List<Demand> selectDemandByLogId(RowBounds rowBounds, String logId);
}
