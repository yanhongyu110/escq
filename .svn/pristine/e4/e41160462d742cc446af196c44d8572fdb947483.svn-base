package com.jero.esc.service.impl.map;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.baidumap.BaiduCouldSave;
import com.jero.esc.common.utils.baidumap.FastBaiduMap;
import com.jero.esc.common.utils.baidumap.Poi;
import com.jero.esc.common.utils.baidumap.Uint32;
import com.jero.esc.mapper.map.PointMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.map.Point;
import com.jero.esc.po.map.PointExample;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.service.map.IMapService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MapService implements IMapService {


    @Autowired
    private ProviderInfoMapper providerCheckInfoMapper;
    @Autowired
    private PointMapper pointMapper;

    @Test
    public void test() throws Exception {
        Poi poi = new Poi();
        poi.setLongitude(106.33d);
        poi.setLatitude(29.35d);
        addPoi(poi);
    }







    /**
     * 通过服务商远程添加点
     * @return
     * @throws Exception
     */
    @Override
    public Boolean addPoiByProvider(String id,String com) throws Exception {
        PointExample pointExample = new PointExample();
        pointExample.or().andPointProviderEqualTo(id);
        Point points = pointMapper.selectByExample(pointExample).get(0);
        Poi poi = new Poi();
        ProviderInfo ree=providerCheckInfoMapper.selectByLogId(id);
        poi.setProvider(points.getPointProvider());
        poi.setLatitude(Double.parseDouble(points.getPointLat().toString()));
        poi.setLongitude(Double.parseDouble(points.getPointLng().toString()));
        poi.setBrief(ree.getPiBrief());
        poi.setImg(ree.getPiPhoto());
        poi.setTitle(ree.getPiRealname());
        poi.setTags(ree.getPiKeywords().trim().replaceAll("[,]"," "));
        poi.setAddress(ree.getPiAddr());
        poi.setCom(com);
        String s = addPoi(poi);
        points.setPointLbsId(s);
        return pointMapper.updateByPrimaryKeySelective(points)>0;
    }


    /**
     * 更新点
     * @return
     * @throws Exception
     */
    public Boolean updatePoiByProvider(String logId) throws Exception {
        PointExample pointExample = new PointExample();
        pointExample.or().andPointProviderEqualTo(logId);
        Point points = pointMapper.selectByExample(pointExample).get(0);
        Poi poi = new Poi();
        ProviderInfo ree=providerCheckInfoMapper.selectByLogId(logId);
        poi.setProvider(points.getPointProvider());
        poi.setLatitude(Double.parseDouble(points.getPointLat().toString()));
        poi.setLongitude(Double.parseDouble(points.getPointLng().toString()));
        poi.setBrief(ree.getPiBrief());
        poi.setImg(ree.getPiPhoto());
        poi.setTitle(ree.getPiRealname());
        poi.setId(Long.parseLong(points.getPointLbsId()));
        poi.setTags(ree.getPiKeywords().trim().replaceAll("[,]"," "));
        poi.setAddress(ree.getPiAddr());
        Boolean s = updatePoi(poi);
        return pointMapper.updateByPrimaryKeySelective(points)>0;
    }

    /**
     * 删除一个点
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Boolean delPoiByProvider(String id) throws Exception {
        PointExample pointExample = new PointExample();
        pointExample.or().andPointProviderEqualTo(id);
        Point points = pointMapper.selectByExample(pointExample).get(0);
        String pointLbsId = points.getPointLbsId();
        return delPoi(pointLbsId);
    }

    /**
     * 添加一个
     *
     * @param poi
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addPoi(Poi poi) throws Exception {
        Point point =null;
        poi.setCoord_type(new Uint32(3));
        poi.setAk(FastBaiduMap.AK);
        poi.setGeotable_id("160206");
        BaiduCouldSave baiduCouldSave = new BaiduCouldSave();
        JSONObject jsonObject = baiduCouldSave.create(poi);
        Integer state = jsonObject.getInteger("state");
        if (state==0){
            return jsonObject.getString("id");
        }else {
            return null;
        }
    }

    /**
     * 查询一个地图
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject queryPoi(String id) throws Exception {
        Poi poi = new Poi();
        poi.setId(Long.parseLong(id));
        poi.setAk(FastBaiduMap.AK);
        poi.setGeotable_id("160206");
        BaiduCouldSave baiduCouldSave = new BaiduCouldSave();
        JSONObject jsonObject = baiduCouldSave.queryById(poi);
        if (jsonObject.getInteger("status")==0){
            return  jsonObject.getJSONObject("poi");
        }
        throw  new  Exception("查询错误");
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Boolean delPoi(String id) throws Exception {
        Poi poi = new Poi();
        poi.setId(Long.parseLong(id));
        poi.setAk(FastBaiduMap.AK);
        poi.setGeotable_id("160206");
        BaiduCouldSave baiduCouldSave = new BaiduCouldSave();
        JSONObject jsonObject = baiduCouldSave.deleteById(poi);
        return jsonObject.getInteger("state")==0;
    }

    /**
     * 更新一个点
     *
     * @param poi
     * @return
     * @throws Exception
     */
    @Override
    public Boolean updatePoi(Poi poi) throws Exception {
        try {
            poi.setAk(FastBaiduMap.AK);
            poi.setGeotable_id("160206");
            poi.setCoord_type(new Uint32(3));
            BaiduCouldSave baiduCouldSave = new BaiduCouldSave();
            JSONObject update = baiduCouldSave.update(poi);
            if (update.getInteger("status")==0){
                return  true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return  false;
        }
    }


}
