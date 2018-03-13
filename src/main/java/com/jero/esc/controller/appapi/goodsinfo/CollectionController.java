package com.jero.esc.controller.appapi.goodsinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderCollection;
import com.jero.esc.po.userinfo.ServiceCollection;
import com.jero.esc.service.goodsinfo.ICollectionService;

/**
 * Created by blazh on 2016/12/9.
 */
@Controller("apiCollectionController")
@RequestMapping("/appapi/goodsinfo")
public class CollectionController extends AppBaseController {

    @Autowired
    ICollectionService collectionService;

    /**
     * 添加商品收藏
     * @param serviceId 添加收藏的服务id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/addServiceCollection",method = RequestMethod.POST)
    public  Object addServiceCollection(String serviceId){
        if (FastValid.isEmp(serviceId)){
            return  AppJsonResult.formJsonResult(new JsonResult(false,"非法参数",null));
        }
        String logId=logId();
        ServiceCollection serviceCollection = new ServiceCollection();
        serviceCollection.setLogId(logId);
        try {
            collectionService.addServiceCollection(serviceCollection);
        }catch (ExceptionWithMessage e){
            return  AppJsonResult.formJsonResult(e.jsonResult);
        } catch (Exception e) {
            return  AppJsonResult.formJsonResult(new JsonResult(false,"添加失败",null));
        }
        return new JsonResult(true,"添加成功",null).toJSON();
    }


    /**
     * 添加服务商搜藏
     * @param providerId 添加服务商搜藏的id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/addProviderCollection",method = RequestMethod.POST)
    public  Object addProviderCollection(String providerId){
        if (FastValid.isEmp(providerId)){
            return  new JsonResult(false,"非法参数",null).toJSON();
        }
        String logId=logId();
        ProviderCollection providerCollection = new ProviderCollection();
        providerCollection.setLogId(logId);
        try {
            collectionService.addProviderCollection(providerCollection);
        }catch (ExceptionWithMessage e){
            return  AppJsonResult.formJsonResult(e.jsonResult);
        } catch (Exception e) {
            return  AppJsonResult.formJsonResult(new JsonResult(false,"添加失败",null));
        }
        return AppJsonResult.formJsonResult(new JsonResult(true,"添加成功",null));
    }


    /**
     * 得到服务
     * @param page 分页信息
     * @param pageSize 分页大小
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/collection/queryS",method = RequestMethod.POST)
    public  Object queryS(Integer page,Integer pageSize) throws Exception {
        String logId = logId();
        PageRowBounds pageRowBounds = getPageRowBounds(page, pageSize);
        ServiceCollection ss= new ServiceCollection();
        ss.setLogId(logId);
        FastPage<ServiceCollection> classFastPage = collectionService.queryCollection(ss,new HashMap<String, String>(),pageRowBounds);
        return AppJsonResult.success(classFastPage);
    }


    /**
     *  得到服务商
     * @param page 分页页数
     * @param pageSize 分页大小
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/collection/queryP",method = RequestMethod.POST)
    public  Object queryP(Integer page,Integer pageSize) throws Exception {
    	String logId = logId();
        PageRowBounds pageRowBounds = getPageRowBounds(page, pageSize);
        ProviderCollection ss= new ProviderCollection();
        ss.setLogId(logId);
        FastPage<ProviderCollection> classFastPage = collectionService.queryCollection(ss,new HashMap<String, String>(),pageRowBounds);
        return AppJsonResult.success(classFastPage);
    }

    /**
     * 显示搜藏
     * @param page 分页页数
     * @param pageSize 分页大小
     * @param type 类型
     * @param require 要求
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/queryCollection",method = RequestMethod.POST)
    public  Object queryCollection(Integer page,Integer pageSize,Integer type,String require){
        if (FastValid.isEmp(page,pageSize,type)){
            page=1;
            pageSize=10;
            type=0;
        }
        String logId=logId();
        Map map = JSONObject.parseObject(require, Map.class);
        RowBounds rowBounds = super.getRowBounds(page, pageSize);
        FastPage fastPage=null;
        try {
            if (type==0){
                ServiceCollection serviceCollection = new ServiceCollection();
                serviceCollection.setLogId(logId);
                fastPage=collectionService.queryCollection(serviceCollection,map,rowBounds);
            }else {
                ProviderCollection providerCollection = new ProviderCollection();
                providerCollection .setLogId(logId);
                fastPage=collectionService.queryCollection(providerCollection,map,rowBounds);
            }
        }catch (Exception e){
            return  AppJsonResult.formJsonResult(new JsonResult(false,"查询储蓄哦",null));
        }

        return  AppJsonResult.formJsonResult(new JsonResult(true,"成功",fastPage));
    }


    /**
     * 移除收藏
     * @param id 要移除的id
     * @param type 要移除的类型
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/removeCollection",method = RequestMethod.POST)
    public  Object removeCollection(String id,Integer type){
        if (FastValid.isEmp(id,type)){
            return  AppJsonResult.formJsonResult(new JsonResult(false,"非法参数",null));
        }
        String logId=logId();
        try {
            if (type==0){
                ServiceCollection serviceCollection = new ServiceCollection();
                serviceCollection.setLogId(logId);
                collectionService.removeServiceCollectionById(serviceCollection);
            }else  if (type==1){
                ProviderCollection providerCollection = new ProviderCollection();
                providerCollection.setLogId(logId);
                collectionService.removeProviderCollectionById(providerCollection);
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            return  AppJsonResult.formJsonResult(new JsonResult(false,"数据错误",null));
        }
        return AppJsonResult.formJsonResult(new JsonResult(true,null,null));
    }

}
