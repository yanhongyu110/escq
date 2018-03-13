package com.jero.esc.common.utils.baidumap;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.fastvalidate.FastValidate;
import com.jero.esc.common.utils.fastvalidate.ValidateResult;
import com.jero.esc.common.utils.http.FastHttp;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.LinkedHashMap;

/**
 * Created by blazh on 2016/12/15.
 */
public class BaiduCouldQuery {


    public  static  String nearBy="http://api.map.baidu.com/geosearch/v3/nearby";

    public  static  String head="http://api.map.baidu.com/geosearch";

    public  static  String local="http://api.map.baidu.com/geosearch/v3/local";


    @Test
    public  void ss() throws Exception {
        Poi poi = new Poi();
        poi.setAk(FastBaiduMap.AK);
        poi.setGeotable_id("160206");
        poi.setLocation("106.55916,29.561025");
        poi.setRadius(new Uint32(3000));
        poi.setQ("强");
        JSONObject local = nearBy(poi);
        System.out.println(local.toJSONString());
    }

    public static JSONObject nearBy(Poi poi) throws Exception {
        FastValidate<Poi> poiFastValidate = new FastValidate<Poi>(poi);
        poiFastValidate.setReqiureList("ak,geotable_id,location",true);
        ValidateResult validateResult = poiFastValidate.validateObject();
        if (!validateResult.validate){
            throw  new Exception();
        }
        JSONObject jsonObject = FastHttp.doGet(nearBy + "?" + FastBaiduMap.toQueryString(FastParser.beanToMap(poi,true, LinkedHashMap.class)));
        return  jsonObject;
    }



    public static JSONObject local(Poi poi) throws Exception {
        FastValidate<Poi> poiFastValidate = new FastValidate<Poi>(poi);
        poiFastValidate.setReqiureList("ak,geotable_id",true);
        ValidateResult validateResult = poiFastValidate.validateObject();
        if (!validateResult.validate){
            throw  new Exception();
        }
        JSONObject jsonObject = FastHttp.doGet(local + "?" + FastBaiduMap.toQueryString(FastParser.beanToMap(poi, true,LinkedHashMap.class)));
        return  jsonObject;
    }




}
