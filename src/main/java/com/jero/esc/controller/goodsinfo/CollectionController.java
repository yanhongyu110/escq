package com.jero.esc.controller.goodsinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderCollection;
import com.jero.esc.po.userinfo.ServiceCollection;
import com.jero.esc.service.goodsinfo.ICollectionService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by blazh on 2016/12/9.
 */
@Controller
@RequestMapping("/goodsinfo")
public class CollectionController extends BaseController {

    @Autowired
    ICollectionService collectionService;

    /**
     * 添加商品搜藏
     * @param session
     * @param serviceId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/addServiceCollection",produces = "text/html;charset=UTF-8")
    public  String addServiceCollection(HttpSession session, @RequestParam("serviceId")String serviceId){

        if (FastValid.isEmp(serviceId)){
            return  new JsonResult(false,"非法参数",null).toJSON();
        }

        ServiceCollection serviceCollection = new ServiceCollection();
        LogInfo logInfo = super.retrievalCurrentUserInfo(session);
        serviceCollection.setLogId(logInfo.getLogId());

        try {
            collectionService.addServiceCollection(serviceCollection);
        }catch (ExceptionWithMessage e){
            return  e.jsonResult.toJSON();
        } catch (Exception e) {
            return  new JsonResult(false,"添加失败",null).toJSON();
        }

        return new JsonResult(true,"添加成功",null).toJSON();

    }


    /**
     * 添加服务商搜藏
     * @param session
     * @param serviceId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/addProviderCollection",produces = "text/html;charset=UTF-8")
    public  String addProviderCollection(HttpSession session, @RequestParam("ProviderId")String serviceId){

        if (FastValid.isEmp(serviceId)){
            return  new JsonResult(false,"非法参数",null).toJSON();
        }

        ProviderCollection providerCollection = new ProviderCollection();
        LogInfo logInfo = super.retrievalCurrentUserInfo(session);
        providerCollection.setLogId(logInfo.getLogId());

        try {
            collectionService.addProviderCollection(providerCollection);
        }catch (ExceptionWithMessage e){
            return  e.jsonResult.toJSON();
        } catch (Exception e) {
            return  new JsonResult(false,"添加失败",null).toJSON();
        }

        return new JsonResult(true,"添加成功",null).toJSON();

    }


    /**
     * 显示服务收藏页面
     * @return
     */
    @RequestMapping("/collection/viewSCollection")
    public ModelAndView viewSCollection(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsinfo/collectionProduct");
        return  modelAndView;
    }

    /**
     * 得到服务
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/queryS",produces = "text/html;charset=UTF-8")
    public  String queryS(HttpSession session,Integer page,Integer pageSize) throws Exception {
        String logId = retrievalCurrentUserInfo(session).getLogId();
        PageRowBounds pageRowBounds = getPageRowBounds(page, pageSize);
        ServiceCollection ss= new ServiceCollection();
        ss.setLogId(logId);
        FastPage<ServiceCollection> classFastPage = collectionService.queryCollection(ss,new HashMap<String, String>(),pageRowBounds);
        return JSON.toJSONString(classFastPage);
    }


    /**
     * 得到服务商
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/queryP",produces = "text/html;charset=UTF-8")
    public  String queryP(HttpSession session,Integer page,Integer pageSize) throws Exception {
        String logId = retrievalCurrentUserInfo(session).getLogId();
        PageRowBounds pageRowBounds = getPageRowBounds(page, pageSize);
        ProviderCollection ss= new ProviderCollection();
        ss.setLogId(logId);
        FastPage<ProviderCollection> classFastPage = collectionService.queryCollection(ss,new HashMap<String, String>(),pageRowBounds);
        return JSON.toJSONString(classFastPage);
    }

    /**
     * 显示服务商收藏页面
     * @return
     */
    @RequestMapping("/collection/viewPCollection")
    public ModelAndView viewPCollection(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goodsinfo/collectionProvider");
        return  modelAndView;
    }

    /**
     * 显示搜藏
     * @param session
     * @param page
     * @param pageSize
     * @param type
     * @param require
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/queryCollection",produces = "text/plain;cahrset=UTF-8")
    public  String queryCollection(HttpSession session,@RequestParam("page")Integer page,@RequestParam("pageSize")Integer pageSize,@RequestParam("type")Integer type,@RequestParam("require")String require){

        if (FastValid.isEmp(page,pageSize,type)){
            page=1;
            pageSize=10;
            type=0;
        }

        Map map = JSONObject.parseObject(require, Map.class);

        RowBounds rowBounds = super.getRowBounds(page, pageSize);

        FastPage fastPage=null;

        try {
            if (type==0){
                ServiceCollection serviceCollection = new ServiceCollection();
                serviceCollection.setLogId(retrievalCurrentUserInfo(session).getLogId());
                fastPage=collectionService.queryCollection(serviceCollection,map,rowBounds);
            }else {
                ProviderCollection providerCollection = new ProviderCollection();
                providerCollection .setLogId(retrievalCurrentUserInfo(session).getLogId());
                fastPage=collectionService.queryCollection(providerCollection,map,rowBounds);
            }
        }catch (Exception e){
            return  new JsonResult(false,"查询储蓄哦",null).toJSON();
        }

        return  new JsonResult(true,"成功",fastPage).toJSON();
    }


    /**
     * 移除收藏
     * @param session
     * @param id
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collection/removeCollection",produces = "text/html;cahrset=UTF-8")
    public  String removeCollection(HttpSession session,@RequestParam("id")String id,@RequestParam("type")Integer type){

        if (FastValid.isEmp(id,type)){
            return  new JsonResult(false,"非法参数",null).toJSON();
        }

        try {
            if (type==0){
                ServiceCollection serviceCollection = new ServiceCollection();
                serviceCollection.setLogId(retrievalCurrentUserInfo(session).getLogId());
                collectionService.removeServiceCollectionById(serviceCollection);
            }else  if (type==1){
                ProviderCollection providerCollection = new ProviderCollection();
                providerCollection.setLogId(retrievalCurrentUserInfo(session).getLogId());
                collectionService.removeProviderCollectionById(providerCollection);
            }else {
                throw  new Exception();
            }
        }catch (Exception e){
            return  new JsonResult(false,"数据错误",null).toJSON();
        }

        return new JsonResult(true,null,null).toJSON();
    }









}
