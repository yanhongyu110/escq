/**
 * @Title ProviderRecommendService.java
 * @Package: com.jero.esc.service.impl.userinfo 
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0 
 * @date 2016年12月8日
 * @description
 */
package com.jero.esc.service.impl.userinfo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.common.utils.DateUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.mapper.userinfo.ProviderRecommendMapper;
import com.jero.esc.po.userinfo.ProviderRecommend;
import com.jero.esc.service.userinfo.IProviderRecommendService;

/**
 * @ClassName: ProviderRecommendService
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0
 * @date 2016年12月8日
 * @description
 */
@Service
public class ProviderRecommendService implements IProviderRecommendService {

	@Autowired
	private ProviderRecommendMapper prm;

	/**
	 * @version v1.0
	 * @date 2016年12月8日
	 * @description
	 * @param record
	 * @return服务商推荐添加
	 * @method add
	 */
	@Transactional(rollbackFor = Exception.class)
	public Integer addProviderRecommend(ProviderRecommend record) {
		record.setPrId(UUIDUtil.getUUID());
		record.setPrCreatetime(new Date());
		record.setPrState(0);
		record.setPrSort(0);
		return prm.insertSelective(record);
	}

	/**
	 * @version v1.0
	 * @date 2016年12月8日
	 * @description
	 * @param Id
	 * @return
	 * @method quertById
	 */
	@Override
	public ProviderRecommend quertById(StringBuffer Id) {
		// TODO Auto-generated method stub
		return prm.selectByPrimaryKey(Id.toString());
	}

	/**
	 * @version v1.0
	 * @date 2016年12月8日
	 * @description
	 * @param record
	 * @return
	 * @method modify
	 */
	@Override
	public Integer modify(ProviderRecommend record) {
		// TODO Auto-generated method stub
		return prm.updateByPrimaryKeySelective(record);
	}

	/**
	 * @version v1.0
	 * @date 2016年12月8日
	 * @description
	 * @param Id
	 * @return
	 * @method delete
	 */
	@Override
	public Integer delete(StringBuffer Id) {
		// TODO Auto-generated method stub
		ProviderRecommend temp = new ProviderRecommend();
		temp.setPrId(Id.toString());
		temp.setPrState(2);
		return prm.updateByPrimaryKeySelective(temp);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月4日
	 * @description 根据登录信息查询推荐信息
	 * @param logId
	 * @return ProviderRecommend
	 * @method queryByLogId
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ProviderRecommend queryByLogId(String logId) {
		return prm.selectBylogId(logId);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月20日
	 * @description 修改审核状态
	 * @param record
	 * @return Integer
	 * @method modifyStatebyLogId
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Integer modifyStatebyLogId(ProviderRecommend record) {
		record.setPrState(0);
		return prm.updateStateBylogId(record);
	}

	/**
	 * 
	 * @version v1.0 (版本号)
	 * @date 2017年1月20日
	 * @description 删除推荐
	 * @param logId
	 * @return Integer
	 * @method remove
	 */
	@Override
	public Integer removeProviderRecommend(String logId) {
		// TODO Auto-generated method stub
		return prm.deleteByPrimaryKey(logId);
	}

}
