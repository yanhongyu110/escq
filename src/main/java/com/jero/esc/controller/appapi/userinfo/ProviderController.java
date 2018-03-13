package com.jero.esc.controller.appapi.userinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.mapper.goodsinfo.ServiceInfoMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.app.AppPoint;
import com.jero.esc.vo.userinfo.ProviderVo;
import com.jero.esc.vo.userinfo.ServiceVo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by blazh on 2017/9/14.
 */
@Controller("apiProviderController")
@RequestMapping("/appapi/provider")
public class ProviderController extends AppBaseController{


    @Autowired
    private ProviderInfoMapper providerInfoMapper;
    @Autowired
    private ServiceInfoMapper serviceInfoMapper;


    /**
     * 推荐服务商
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/recommend",produces = "text/html;charset=UTF-8")
    public AppJsonResult recommend(){
        List<ProviderVo> providerVos = providerInfoMapper.selectProviderByOrder(RowBounds.DEFAULT,"PI_MEETNUM DESC",null);
        return AppJsonResult.success(JSON.toJSONString(providerVos));
    }


    /**
     * 推荐服务商
     * @return
     */
    @Cacheable(value = "homeChae", key = "'appproviderindexService:'+#point")
    @CachePut(value = "homeChae", key = "'appproviderindexService:'+#point")
    @ResponseBody
    @RequestMapping(value = "/indexService")
    public  AppJsonResult indexService(String point){
        AppPoint appPoint= JSONObject.parseObject(point,AppPoint.class);
        List<ServiceVo> serList = serviceInfoMapper.selectIndexService(appPoint.getLng()+"",appPoint.getLat()+"");
        return AppJsonResult.success(serList);
    }



}
