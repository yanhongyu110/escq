package com.jero.esc.service.impl.pubinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.po.pubinfo.CommonTypeSave;
import com.jero.esc.service.pubinfo.ICommonTypeService;

/**
 * @copyright 上善云图信息技术有限公司
 * @author zqy
 * @version v1.0  （版本号）
 * @date 2017年1月5日
 * @description 
 */
@Service
public class CommonTypeService implements ICommonTypeService{

	@Autowired
	private CommonTypeSaveMapper commonTypeSaveMapper;


//	@Cacheable(value = "homeChae",key = "'queryServiceTypeSave:'+#saveType+':'+#com")
//	@CachePut(value = "homeChae",key = "'queryServiceTypeSave:'+#saveType+':'+#com")
	@Override
	public CommonTypeSave queryServiceTypeSave(String saveType,String com) {
		return commonTypeSaveMapper.queryServiceTypeSave(saveType,com);
	}

}
