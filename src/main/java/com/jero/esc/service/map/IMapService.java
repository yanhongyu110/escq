package com.jero.esc.service.map;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.baidumap.Poi;

public interface IMapService {

    /**
     * 通过服务商远程添加点
     * @return
     * @throws Exception
     */
    Boolean addPoiByProvider(String id,String com)throws  Exception;


    /**
     * 通过服务商远程添加点
     * @return
     * @throws Exception
     */
    Boolean delPoiByProvider(String id)throws  Exception;


    /**
     * 通过服务商更新信息
     * @return
     * @throws Exception
     */
    public Boolean updatePoiByProvider(String logId) throws Exception;

    /**
     * 添加一个
     * @param poi
     * @return
     * @throws Exception
     */
    String addPoi(Poi poi)throws  Exception;

    /**
     * 查询一个地图
     * @param id
     * @return
     * @throws Exception
     */
     JSONObject queryPoi(String id)throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    Boolean delPoi(String id)throws Exception;

    /**
     * 更新一个点
     * @return
     * @throws Exception
     */
    Boolean updatePoi(Poi poi)throws  Exception;

}
