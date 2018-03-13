package com.jero.esc.service.pubinfo;

import com.jero.esc.po.pubinfo.CommonTypeSave;

/**
 * @copyright 上善云图信息技术有限公司
 * @author zqy
 * @version v1.0  （版本号）
 * @date 2017年1月5日
 * @description 
 */
public interface ICommonTypeService {


	CommonTypeSave queryServiceTypeSave(String saveType,String com);
}
