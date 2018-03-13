package com.jero.esc.common.utils.baidumap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.TestBase;
import com.jero.esc.common.utils.fastvalidate.FastValidate;
import com.jero.esc.common.utils.fastvalidate.ValidateResult;
import com.jero.esc.common.utils.http.FastHttp;
import com.jero.esc.mapper.map.PointMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.map.Point;
import com.jero.esc.po.map.PointExample;
import com.jero.esc.po.system.SysOperationLog;
import com.jero.esc.po.userinfo.ProviderInfo;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;


@Component
public class BaiduCouldSave  {

    public static String[] createStr = {"http://api.map.baidu.com/geodata/v3/poi/create", "post"};

    public static String[] queryStr = {"http://api.map.baidu.com/geodata/v3/poi/detail", "get"};

    public static String[] updateStr = {"http://api.map.baidu.com/geodata/v3/poi/update", "post"};

    public static String[] deleteStr = {"http://api.map.baidu.com/geodata/v3/poi/delete", "post"};

    public static String head = "http://api.map.baidu.com/geodata";

    public static String[] list = {"http://api.map.baidu.com/geodata/v3/poi/list", "get"};


    @Autowired
    ProviderInfoMapper providerInfoMapper;

    @Autowired
    PointMapper pointMapper;


    public void sync() throws Exception {
        List<Poi> allPoi = getAllPoi();
        removeRepeatPoi(allPoi);
        removeNotUse(allPoi);
        updateAllPoi(allPoi);
        insertLost(allPoi);
    }

    public List<Poi> getAllPoi() throws IOException {
        Poi poi = new Poi();
        poi.setAk(FastBaiduMap.AK);
        poi.setGeotable_id("160206");
        System.out.println(JSONObject.toJSONString(poi));
        Map map = JSONObject.parseObject(JSONObject.toJSONString(poi), Map.class);
        List<Poi> pois1 = new ArrayList<Poi>();

        int page = 0;
        while (true) {
            map.put("page_size", 200);
            map.put("page_index", page);
            JSONObject jsonObject = FastHttp.doGet(list[0], map);
            if (jsonObject.get("pois") == null) {
                break;
            }
            try {
                pois1.addAll(JSONArray.parseArray(jsonObject.get("pois").toString(), Poi.class));
            } catch (Exception e) {
                System.out.println(jsonObject.get("pois").toString());
                e.printStackTrace();
            }
            page++;
        }
        return pois1;
    }


    /**
     * 添加丢失得点
     */
    @Test
    public void insertLost(List<Poi> in) throws Exception {
        int ii = 0;
        List<Poi> allPoi = (in!=null)?in:getAllPoi();
        PointExample pointExample = new PointExample();
        List<Point> points = pointMapper.selectByExample(pointExample);
        for (Point point : points) {
            for (int i = 0; i < allPoi.size(); i++) {
                if (point.getPointProvider().equals(allPoi.get(i).getProvider())) {
                    continue;
                }
            }
            ProviderInfo providerInfo = providerInfoMapper.selectByLogId(point.getPointProvider());
            Poi poi = new Poi();
            poi.setLatitude(Double.parseDouble(point.getPointLat() + ""));
            poi.setAddr(providerInfo.getPiAddr());
            poi.setBrief(providerInfo.getPiBrief());
            poi.setProvider(point.getPointProvider());
            poi.setTags(providerInfo.getPiKeywords());
            poi.setTitle(providerInfo.getPiRealname());
            poi.setLongitude(Double.parseDouble(point.getPointLng() + ""));
            poi.setCoord_type(new Uint32(3));
            poi.setAk(FastBaiduMap.AK);
            poi.setGeotable_id("160206");
            poi.setCom(providerInfo.getPiCom());
            poi.setImg(providerInfo.getPiPhoto());
            poi.setAddress(providerInfo.getPiAddr());
            JSONObject jsonObject = create(poi);
            point.setPointLbsId(jsonObject.getString("id"));
            pointMapper.updateByPrimaryKeySelective(point);
            ii++;

        }
        System.out.println(ii);
    }


    /**
     * 更新所有POI
     */
    @Test
    public void updateAllPoi(List<Poi> in) throws Exception {
        List<Poi> allPoi = (in!=null)?in:getAllPoi();
        int i = 0;
        for (Poi poi : allPoi) {
            ProviderInfo providerInfo = providerInfoMapper.selectByLogId(poi.getProvider());
            if (providerInfo != null) {
                PointExample pointExample = new PointExample();
                pointExample.or().andPointProviderEqualTo(poi.getProvider());
                Point points = pointMapper.selectByExample(pointExample).get(0);
                poi.setProvider(points.getPointProvider());
                poi.setLatitude(Double.parseDouble(points.getPointLat().toString()));
                poi.setLongitude(Double.parseDouble(points.getPointLng().toString()));
                poi.setBrief(providerInfo.getPiBrief());
                poi.setImg(providerInfo.getPiPhoto());
                poi.setTitle(providerInfo.getPiRealname());
                poi.setId(Long.parseLong(points.getPointLbsId()));
                poi.setTags(providerInfo.getPiKeywords().trim().replaceAll("[,]", " "));
                poi.setAddress(providerInfo.getPiAddr());
                poi.setAk(FastBaiduMap.AK);
                poi.setCoord_type(new Uint32(3));
                poi.setGeotable_id("160206");
                update(poi);
                i++;
            }
        }
        System.out.println(i);
    }


    /**
     * 清除重复数据
     *
     * @throws Exception
     */
    @Test
    public void removeRepeatPoi(List<Poi> in) throws Exception {
        List<Poi> allPoi = (in!=null)?in:getAllPoi();
        ArrayList<Poi> lists = new ArrayList<Poi>();
        int x = 0;
        for (int i = 0; i < allPoi.size(); i++) {
            for (int j = i + 1; j < allPoi.size(); j++) {
                Poi poi = allPoi.get(i);
                Poi poi1 = allPoi.get(j);
                if (poi.getProvider().equals(poi1.getProvider())) {
                    poi.setAk(FastBaiduMap.AK);
                    poi.setGeotable_id("160206");
                    deleteById(poi);
                    lists.add(poi);
                    x++;
                    continue;
                }
            }
        }
        in.removeAll(lists);
        System.out.println("移除了" + x);
    }


    /**
     * 清除失效的数据
     */
    @Test
    public void removeNotUse(List<Poi> in) throws Exception {
        List<Poi> allPoi = (in!=null)?in:getAllPoi();
        ArrayList<Poi> lists = new ArrayList<Poi>();
        int i = 0;
        for (Poi p : allPoi) {
            ProviderInfo providerInfo = providerInfoMapper.selectByLogId(p.getProvider());
            p.setAk(FastBaiduMap.AK);
            p.setGeotable_id("160206");
            if (providerInfo == null) {
                deleteById(p);
                lists.add(p);
                i++;
            }
        }
        in.removeAll(lists);
        System.out.println(i);
    }


    @Test
    public void qq() throws Exception {
        Poi poi = new Poi();
        poi.setId((long) 1891286744);
        poi.setAk(FastBaiduMap.AK);
        poi.setGeotable_id("160206");
        poi.setAddr("sasasas");
        poi.setBrief("sasasasas");
        BaiduCouldSave baiduCouldSave = new BaiduCouldSave();
        JSONObject jsonObject = baiduCouldSave.deleteById(poi);
        System.out.println(jsonObject.toJSONString());
    }


    @Test
    public void ss() throws Exception {
        Poi poi = new Poi();
        poi.setLatitude(29.559763);
        poi.setAddr("sasasas");
        poi.setBrief("sasasasas");
        poi.setLongitude(106.554277);
        poi.setCoord_type(new Uint32(3));
        poi.setAk(FastBaiduMap.AK);
        poi.setGeotable_id("160206");
//        poi.setSn(FastBaiduMap.getSn(head,createStr, poi));
        BaiduCouldSave baiduCouldSave = new BaiduCouldSave();
        JSONObject jsonObject = baiduCouldSave.create(poi);
        System.out.println(jsonObject.toJSONString());
    }


    @Test
    public void ff() throws Exception {
        Poi poi = new Poi();
        poi.setAk(FastBaiduMap.AK);
        poi.setGeotable_id("160206");
        poi.setId(Long.parseLong("1918061884"));
        BaiduCouldSave baiduCouldSave = new BaiduCouldSave();
        JSONObject jsonObject = baiduCouldSave.queryById(poi);
        System.out.println(jsonObject.toJSONString());
    }


    public JSONObject queryById(Poi poi) throws Exception {
        FastValidate<Poi> poiFastValidate = new FastValidate<Poi>(poi);
        poiFastValidate.setReqiureList("ld,geotable_id,ak", true);
        ValidateResult<Poi> validateResult = poiFastValidate.validateObject();
        if (!validateResult.validate) {
            throw new Exception();
        }
        return doGet(poi, queryStr[0]);
    }


    public JSONObject create(Poi poi) throws Exception {
        FastValidate<Poi> poiFastValidate = new FastValidate<Poi>(poi);
        poiFastValidate.setReqiureList("latitude,longitude,coord_type,geotable_id,ak", true);
        ValidateResult validateResult = poiFastValidate.validateObject();
        if (!validateResult.validate) {
            throw new Exception();
        }
        return doPost(poi, createStr[0]);
    }


    public JSONObject update(Poi poi) throws Exception {
        FastValidate<Poi> poiFastValidate = new FastValidate<Poi>(poi);
        poiFastValidate.setReqiureList("coord_type,geotable_id,ak,id", true);
        ValidateResult validateResult = poiFastValidate.validateObject();
        if (!validateResult.validate) {
            throw new Exception();
        }
        return doPost(poi, updateStr[0]);
    }


    public JSONObject deleteById(Poi poi) throws Exception {
        FastValidate<Poi> poiFastValidate = new FastValidate<Poi>(poi);
        poiFastValidate.setReqiureList("id,geotable_id,ak", true);
        ValidateResult validateResult = poiFastValidate.validateObject();
        if (!validateResult.validate) {
            throw new Exception();
        }
        return doPost(poi, deleteStr[0]);
    }


    public JSONObject doPost(Poi poi, String url) throws Exception {
        HttpClient aDefault = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).setConnectionRequestTimeout(10000).build());
        Map<String, Object> stringObjectMap = FastParser.beanToMap(poi, true, TreeMap.class);
        String sn = (String) stringObjectMap.remove("sn");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Map.Entry<String, Object> en : stringObjectMap.entrySet()) {
            nvps.add(new BasicNameValuePair(en.getKey(), en.getValue().toString()));
        }
        nvps.add(new BasicNameValuePair("sn", sn));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        HttpResponse execute = aDefault.execute(httpPost);
        String s = EntityUtils.toString(execute.getEntity(), "UTF-8");
        JSONObject map = JSONObject.parseObject(s);
        if (!map.get("status").toString().equals("0")) {
            return null;
        } else {
            return map;
        }
    }


    public JSONObject doGet(Poi poi, String url) throws Exception {
        Map<String, Object> stringObjectMap = FastParser.beanToMap(poi, true, LinkedHashMap.class);
        Object sn = stringObjectMap.remove("sn");
        HttpClient aDefault = HttpClients.createDefault();
        HttpGet httpPost = new HttpGet(url + "?" + FastBaiduMap.toQueryString(stringObjectMap) + ((sn != null) ? "&" + sn : ""));
        httpPost.setConfig(RequestConfig.custom().setConnectTimeout(10000).setSocketTimeout(10000).setConnectionRequestTimeout(10000).build());
        HttpResponse execute = aDefault.execute(httpPost);
        String s = EntityUtils.toString(execute.getEntity(), "UTF-8");
        JSONObject map = JSONObject.parseObject(s);
        if (map.get("status").toString().equals("0")) {
            return map;
        } else {
            return null;
        }
    }


}
