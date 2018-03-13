package com.jero.esc.mapper.demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.jero.esc.vo.demand.Demand;
import com.jero.esc.vo.demand.DemandVo;

public interface DemandMapper {




	List<Demand> selectList(@Param("search") String search,@Param("typeTree")String typeTree,@Param("order")String order,RowBounds rowBounds);
	//带有userphoto的集合
	List<DemandVo> selectList1(@Param("search") String search,@Param("typeTree")String typeTree,@Param("order")String order,RowBounds rowBounds);
	
	int selectListCount(@Param("search")String search,@Param("typeTree")String typeTree,@Param("com")String com);


	List<Demand> selectTop(@Param("top")Integer top,@Param("module")String module);
	
	List<DemandVo> selectTop1(@Param("top")Integer top,@Param("module")String module);
	
	List<Demand> selectOthers(@Param("dem")Demand demand);

	int insert(Demand demand);
	
	List<Demand> selectAll(RowBounds rowBounds, @Param("dem")Demand demand);
	
	List<DemandVo> selectAll2(RowBounds rowBounds, @Param("dem")Demand demand);
	
	List<Demand> selectAll1(RowBounds rowBounds, @Param("dem")Demand demand);
	
	int count(@Param("dem")Demand demand);
	
	int count1(@Param("dem")Demand demand);
	
	DemandVo selectDemandVoById(@Param("demId")String demId);
	
	Demand selectById(@Param("demId")String demId);
	
	int updateById(Demand demand);
	/**
	 * 
	 *<pre>
	 *<b> 分页查询需求 .</b>
	 *<b>Description:</b> 
	 *    根据用户id
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017年11月16日 上午9:49:01
	 *@param rowBounds
	 *@param logId
	 *@return
	 *</pre>
	 */
	public List<Demand> selectDemandByLogId(RowBounds rowBounds, String logId);
}
