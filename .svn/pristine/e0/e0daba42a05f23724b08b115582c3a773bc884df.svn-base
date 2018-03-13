package com.jero.esc.controller.wap.map;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.utils.baidumap.BaiduCouldQuery;
import com.jero.esc.common.utils.baidumap.FastBaiduMap;
import com.jero.esc.common.utils.baidumap.Poi;
import com.jero.esc.common.utils.baidumap.Uint32;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by blazh on 2016/12/23.
 */
@Controller()
@RequestMapping("/wap/map")
public class WapMapController extends BaseController{


    @ResponseBody
    @RequestMapping(value = "/position",produces = "text/html;charset=UTF-8")
    public  String position(HttpSession session, String position,String point){
        if (StringUtils.isBlank(position)&&StringUtils.isBlank(point)){
            return  getPosition(session);
        }else {
        	session.setAttribute("point", point);
            setPosition(session,position);
            return "true";
        }
    }



    /**
     * 进入搜索
     * @return
     */
    @RequestMapping("/search")
    public ModelAndView search(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("wap/map/search");
        return  modelAndView;
    }

    /**
     * 范围搜索
     * @param location
     * @param radius
     * @param q
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/nearby",produces = "text/html;charset=UTF-8")
    public  String nearby(String location,Integer radius,String q,Integer page_index,Integer page_size,String type) throws Exception {
        try {
            Poi poi = new Poi();
            poi.setAk(FastBaiduMap.AK);
            poi.setGeotable_id("160206");
            poi.setLocation(location);
            poi.setQ(q);
            poi.setTags(type);
            poi.setRadius(new Uint32(radius));
            poi.setPage_index(page_index==null?new Uint32(0):new Uint32(page_index));
            poi.setPage_size(page_size==null?new Uint32(10):new Uint32(page_size));
            JSONObject local = BaiduCouldQuery.nearBy(poi);
            return "mapCallBack("+local.toJSONString()+")";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }


    /**
     * 区域搜索
     * @param region
     * @param q
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/location",produces = "text/html;charset=UTF-8")
    public  String location(String region,String q,Integer page_index,Integer page_size,String type) throws Exception {
        try {
            Poi poi = new Poi();
            poi.setAk(FastBaiduMap.AK);
            poi.setGeotable_id("160206");
            poi.setQ(q);
            poi.setTags(type);
            poi.setRegion(region);
            poi.setPage_index(page_index==null?new Uint32(0):new Uint32(page_index));
            poi.setPage_size(page_size==null?new Uint32(10):new Uint32(page_size));
            JSONObject local = BaiduCouldQuery.local(poi);
            return "mapCallBack("+ local.toJSONString()+")";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

}
