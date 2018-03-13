package com.jero.esc.controller.appapi.goodsinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.jero.esc.mapper.goodsinfo.ServiceInfoMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.app.AppPoint;
import com.jero.esc.po.goodsinfo.ServiceToLoginfo;
import com.jero.esc.service.goodsinfo.IServiceToLoginfoService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.utils.fastvalidate.FastValidate;
import com.jero.esc.common.utils.fastvalidate.ValidateResult;
import com.jero.esc.po.checkinfo.ProviderCheckInfo;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.goodsinfo.ServiceStep;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.service.checkinfo.IProviderCheckInfoService;
import com.jero.esc.service.goodsinfo.IRemarkService;
import com.jero.esc.service.goodsinfo.IServiceService;
import com.jero.esc.service.userinfo.IProviderInfoService;
import com.jero.esc.vo.goodsinfo.RemarkCountVo;
import com.jero.esc.vo.goodsinfo.ServiceInfoVo;
import com.jero.esc.vo.goodsinfo.ServiceRemarkVo;
import com.jero.esc.vo.userinfo.ProviderVo;
import com.jero.esc.vo.userinfo.ServiceVo;

@Controller("apiServiceController")
@RequestMapping("/appapi/goodsinfo")
public class ServiceController extends AppBaseController {

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IRemarkService remarkService;

    @Autowired
    private IProviderInfoService providerInfoService;

    @Autowired
    private IProviderCheckInfoService providerCheckInfoService;
    @Autowired
    private IServiceToLoginfoService serviceToLoginfoService;

    @Autowired
    private ServiceInfoMapper serviceMapper;
    @Autowired
    private ProviderInfoMapper providerMapper;



    @ResponseBody
    @RequestMapping(value = "/service/queryServiceProviderByAjax",method = RequestMethod.POST)
    public AppJsonResult queryServiceProviderByAjax(Integer flag, Integer page,String point) {
        if (page == null) {page = 1;}
        AppPoint appPoint=JSONObject.parseObject(point,AppPoint.class);
        FastPage fastPage=null;
        RowBounds rb = this.getRowBounds(page, 10);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if(flag==1){
            String lat = "29.608069";
            String lng = "106.374488";
            if(appPoint!=null){
                    lat = appPoint.getLat();
                    lng =appPoint.getLng();
            }
            Integer count = serviceMapper.selectNewServiceCount();
            List<ServiceInfoVo> list = serviceMapper.selectNewService(rb, lng, lat);
            fastPage=new FastPage(list,count,page,10);
        }else if(flag==2){
            Integer count = providerMapper.selectGoodProvidersCount();
            List<ProviderInfo> list = providerMapper.selectGoodProviders(rb);
            fastPage=new FastPage(list,count,page,10);
        }
        return AppJsonResult.success(fastPage);
    }

    /**
     * 判断是否点赞服务
     *
     * @param serviceId 处理的服务id
     * @param logId 登录用户Id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/service/isDianzan",method=RequestMethod.POST)
    public AppJsonResult isDianzan(String serviceId) {
    	if (FastValid.isEmp(serviceId)){
            return AppJsonResult.formJsonResult(new JsonResult(true,"参数缺失",false));
        }
    	String logId=logId();
        Boolean aBoolean = null;
        ServiceToLoginfo serviceToLoginfo = new ServiceToLoginfo();
		serviceToLoginfo.setServiceId(serviceId);
		serviceToLoginfo.setLogId(logId);
		aBoolean = serviceToLoginfoService.select(serviceToLoginfo);
		return aBoolean?AppJsonResult.formJsonResult(new JsonResult(true,"已点赞",true)):AppJsonResult.formJsonResult(new JsonResult(true,"暂未点赞",false));
    }


    /**
     * 点赞
     *
     * @param serviceId 处理的服务id
     * @param aBoolean  true：取消点赞  false：点赞
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/service/dianzan",method=RequestMethod.POST)
    public AppJsonResult dianzan(String serviceId, Boolean aBoolean) {
        JsonResult result = new JsonResult();
        Boolean aBoolean1 = null;
        Boolean aBoolean2 = null;
        LogInfo logInfo = log();
        ServiceToLoginfo serviceToLoginfo = new ServiceToLoginfo();
        serviceToLoginfo.setServiceId(serviceId);
        serviceToLoginfo.setLogId(logInfo.getLogId());
        if (aBoolean) {
            aBoolean1 = serviceToLoginfoService.deleteByLogIdAndServiceId(logInfo.getLogId(), serviceId);
            aBoolean2 = serviceService.updateService(serviceId, false);
            if (aBoolean1 && aBoolean2) {
                result.setSuccess(true);
                result.setErrorMsg("取消点赞成功");
            } else {
                result.setSuccess(false);
                result.setErrorMsg("取消点赞失败");
            }
        } else {
            aBoolean1 = serviceToLoginfoService.insert(serviceToLoginfo);
            aBoolean2 = serviceService.updateService(serviceId, true);
            if (aBoolean1 && aBoolean2) {
                result.setSuccess(true);
                result.setErrorMsg("点赞成功");
            } else {
                result.setSuccess(false);
                result.setErrorMsg("点赞失败");
            }
        }
        return AppJsonResult.formJsonResult(result);
    }


    /**
     * 打开添加服务页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/service/queryIsProvider",method = RequestMethod.POST)
    public Object queryProviderState() {
        String logId = logId();
        ProviderCheckInfo providerCheckInfo = providerCheckInfoService.queryByLogId(logId);
        if (providerCheckInfo == null || providerCheckInfo.getPciState() != 2) {
            return AppJsonResult.success();
        }
        return AppJsonResult.error("暂未认证为服务商，不能添加服务");
    }


    /**
     * 添加服务
     *
     * @param service 添加的服务json
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/service/addService",method = RequestMethod.POST)
    @NoRepeatRequest
    public AppJsonResult addService(String service) throws Exception {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        ServiceInfo serviceInfo = JSONObject.parseObject(service, ServiceInfo.class);
        String serviceContent = serviceInfo.getServiceContent();
        serviceInfo.setServiceContent(null);
        if (HtmlFilter.filter(serviceInfo)) {
            return AppJsonResult.formJsonResult(new JsonResult("不能使用html标签"));
        }
        serviceInfo.setServiceContent(serviceContent);
        //验证
        FastValidate<ServiceInfo> serviceInfoFastValidate = new FastValidate<ServiceInfo>(serviceInfo);
        //serviceBiref,
        serviceInfoFastValidate.setReqiureList("servicePic,serviceType,serviceTitle,serviceContent,serviceMeettime,serviceAttrinfo,serviceSteps,priceSets", true);
        ValidateResult validateResult = serviceInfoFastValidate.validateObject(true);
        if (!validateResult.validate) {
            validateResult.printAllMeassage();
            return AppJsonResult.formJsonResult(new JsonResult(false, "错误", validateResult.list));
        }
        serviceInfo.setLogId(logId());

        if (serviceInfo.getServiceTitle().length() > 0 && serviceInfo.getServiceTitle() != null) {
            Pattern p = Pattern.compile("^[\u4e00-\u9fa5a-zA-Z0-9]{5,}$");
            Matcher m = p.matcher(serviceInfo.getServiceTitle());
            if (false == m.matches()) {
                return AppJsonResult.formJsonResult(new JsonResult(false, "服务名不对", null));
            }
        } else {
            return AppJsonResult.formJsonResult(new JsonResult(false, "服务名不能为空", null));
        }
        if (serviceInfo.getServiceKeywords() != null && serviceInfo.getServiceKeywords().length() > 0) {
            String biref = serviceInfo.getServiceKeywords();
            biref = biref.substring(2, biref.length() - 2);
            String[] birefs = biref.split("[,|，]");
            if (birefs.length > 5) {
                return AppJsonResult.formJsonResult(new JsonResult(false, "关键词不能超过5", null));
            }
            for (int i = 0; i < birefs.length; i++) {
                if (birefs[i] != null && !"".equals(birefs[i])) {
                    if (!birefs[i].matches("^([\\u4e00-\\u9fa5]|\\w)+$")) {
                        return AppJsonResult.formJsonResult(new JsonResult(false, "关键词不对", null));
                    }
                }
            }
        }
       /*if(serviceInfo.getServiceBiref().length()>200 || serviceInfo.getServiceBiref().length()<1){
           return  new JsonResult(false,"简介不对",null).toJSON();
       }*/
        if (serviceInfo.getPriceSets() != null) {
            for (int i = 0; i < serviceInfo.getPriceSets().size(); i++) {
                String price = serviceInfo.getPriceSets().get(i).getPsetPrice().toString();
                Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
                Matcher m = p.matcher(price);
                if (false == m.matches()) {
                    return AppJsonResult.formJsonResult(new JsonResult(false, "价格不对", null));
                }
            }
        } else {
            return AppJsonResult.formJsonResult(new JsonResult(false, "价格不能为空", null));
        }
        if (serviceInfo.getPriceSets() != null) {
            for (int i = 0; i < serviceInfo.getPriceSets().size(); i++) {
                String point = serviceInfo.getPriceSets().get(i).getPsetPoint().toString();
                Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
                Matcher m = p.matcher(point);
                if (false == m.matches()) {
                    return AppJsonResult.formJsonResult(new JsonResult(false, "积分不对", null));
                }
            }
        } else {
            return AppJsonResult.formJsonResult(new JsonResult(false, "积分不能为空", null));
        }

        try {
            serviceService.addService(serviceInfo);
        } catch (ExceptionWithMessage e) {
            return AppJsonResult.formJsonResult(e.jsonResult);
        } catch (Exception e) {
            return AppJsonResult.formJsonResult(new JsonResult(false, "添加失败,请刷新重新填写", null));
        }
        return AppJsonResult.formJsonResult(new JsonResult(true, null, "/goodsinfo/service/viewProviderService.html"));
    }


    /**
     * 显示服务查询页面
     *
     * @param serviceVo 服务的json
     * @param page      分页页数
     * @param pageSize  分页大小
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/getServiceList",method = RequestMethod.POST)
    public Object getServiceList(ServiceVo serviceVo, Integer page, Integer pageSize) throws Exception {
        if (FastValid.isEmp(page)) {
            page = 1;
            pageSize = 10;
        }
        if (serviceVo.getStart() != null && serviceVo.getStart().trim().equals("")) {
            serviceVo.setStart(null);
        }
        if (serviceVo.getEnd() != null && serviceVo.getEnd().trim().equals("")) {
            serviceVo.setEnd(null);
        }
        if (serviceVo.getServiceType() != null && serviceVo.getServiceType().trim().equals("")) {
            serviceVo.setServiceType(null);
        }
        String logId = logId();
        serviceVo.setServiceIsdelete(false);
        PageRowBounds pageRowBounds = getPageRowBounds(page, pageSize);
        serviceVo.setLogId(logId);
        FastPage<ServiceVo> infos = serviceService.queryServiceInfo(serviceVo, pageRowBounds);
        return AppJsonResult.success(infos);
    }

    /**
     * 根据服务ID获取服务
     *
     * @param serviceId 服务id
     * @param module    模块
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/getServiceById",method = RequestMethod.POST)
    public AppJsonResult getServiceById(String serviceId, String module) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        List<ServiceStep> steps = serviceService.selectServiceSetById(serviceId);
        for (ServiceStep step : steps) {
            String[] s = step.getSsPrice().substring(2, step.getSsPrice().length() - 2).split(",");
            for (String ss : s) {
                String[] sv = ss.split(":");
                map.put(sv[0].substring(1, sv[0].length() - 1), sv[1].substring(1, sv[1].length() - 1));
            }
        }
        ServiceVo serviceVo = serviceService.queryServiceVoDetailsById(serviceId, Integer.valueOf(map.get("psetDiscountType")), module);
        serviceVo.getLogId();
        return AppJsonResult.success(serviceVo);
    }

    /**
     * 修改服务
     *
     * @param service 服务json
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/service/updateService",method = RequestMethod.POST)
    @NoRepeatRequest
    public AppJsonResult updateService(String service) throws Exception {
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        ServiceInfo serviceInfo = null;
        try {
            serviceInfo = JSONObject.parseObject(service, ServiceInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return AppJsonResult.formJsonResult(new JsonResult(false, "修改失败", null));
        }
        FastValidate<ServiceInfo> serviceInfoFastValidate = new FastValidate<ServiceInfo>(serviceInfo);
        serviceInfoFastValidate.setReqiureList("serviceId,servicePic,serviceType,serviceTitle,serviceContent,serviceMeettime,serviceAttrinfo,serviceSteps,priceSets", true);
        ValidateResult validateResult = serviceInfoFastValidate.validateObject(true);
        if (!validateResult.validate) {
            validateResult.printAllMeassage();
            return AppJsonResult.formJsonResult(new JsonResult(false, "错误", validateResult.list));
        }
        serviceInfo.setLogId(logId());

        if (serviceInfo.getServiceTitle().length() > 0 && serviceInfo.getServiceTitle() != null) {
            Pattern p = Pattern.compile("^[\u4e00-\u9fa5a-zA-Z0-9]{5,}$");
            Matcher m = p.matcher(serviceInfo.getServiceTitle());
            if (false == m.matches()) {
                return AppJsonResult.formJsonResult(new JsonResult(false, "服务名不对", null));
            }
        } else {
            return AppJsonResult.formJsonResult(new JsonResult(false, "服务名不能为空", null));
        }
        if (serviceInfo.getServiceKeywords() != null && serviceInfo.getServiceKeywords().length() > 0) {
            String biref = serviceInfo.getServiceKeywords();
            biref = biref.substring(2, biref.length() - 2);
            String[] birefs = biref.split("[,|，]");
            if (birefs.length > 5) {
                return AppJsonResult.formJsonResult(new JsonResult(false, "关键词不能超过5", null));
            }
            for (int i = 0; i < birefs.length; i++) {
                if (birefs[i] != null && !"".equals(birefs[i])) {
                    if (!birefs[i].matches("^([\\u4e00-\\u9fa5]|\\w)+$")) {
                        return AppJsonResult.formJsonResult(new JsonResult(false, "关键词不对", null));
                    }
                }
            }
            if (serviceInfo.getPriceSets() != null) {
                for (int i = 0; i < serviceInfo.getPriceSets().size(); i++) {
                    String price = serviceInfo.getPriceSets().get(i).getPsetPrice().toString();
                    Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
                    Matcher m = p.matcher(price);
                    if (false == m.matches()) {
                        return AppJsonResult.formJsonResult(new JsonResult(false, "价格不对", null));
                    }
                }
            } else {
                return AppJsonResult.formJsonResult(new JsonResult(false, "价格不能为空", null));
            }
            if (serviceInfo.getPriceSets() != null) {
                for (int i = 0; i < serviceInfo.getPriceSets().size(); i++) {
                    String point = serviceInfo.getPriceSets().get(i).getPsetPoint().toString();
                    Pattern p = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
                    Matcher m = p.matcher(point);
                    if (false == m.matches()) {
                        return AppJsonResult.formJsonResult(new JsonResult(false, "积分不对", null));
                    }
                }
            } else {
                return AppJsonResult.formJsonResult(new JsonResult(false, "积分不能为空", null));
            }
            try {
                serviceService.modifyService(serviceInfo);
            } catch (ExceptionWithMessage e) {
                e.printStackTrace();
                return AppJsonResult.formJsonResult(e.jsonResult);
            } catch (Exception e) {
                e.printStackTrace();
                return AppJsonResult.formJsonResult(new JsonResult(false, "修改失败", null));
            }
        }
            return AppJsonResult.formJsonResult(new JsonResult(true, null, ""));

    }

    /**
     * 删除服务
     *
     * @param serviceId 需要删除的服务的id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/service/deleteService",method = RequestMethod.POST)
    @NoRepeatRequest
    public Object deleteService(@RequestParam("serviceId") String serviceId) throws Exception {
        JsonResult jr = new JsonResult();
        String logId = logId();
        ServiceInfo serviceInfo = new ServiceInfo();
        if (logId != null || serviceId != null) {
            serviceInfo.setServiceId(serviceId);
            serviceInfo.setLogId(logId);
            try {
                Boolean res = serviceService.removeService(serviceInfo);
                if (res) {
                    jr.setSuccess(true);
                    jr.setErrorMsg("删除成功！");
                } else {
                    jr.setSuccess(false);
                    jr.setErrorMsg("删除失败！");
                }
            } catch (Exception e) {
                jr.setSuccess(false);
                jr.setErrorMsg("删除失败！");
                e.printStackTrace();
            }
        } else {
            jr.setSuccess(false);
            jr.setErrorMsg("删除失败！");
        }
        return AppJsonResult.formJsonResult(jr);
    }

    /**
     * 查询服务
     *
     * @param service  服务的json数据
     * @param require  排序要求
     * @param page     分页页数
     * @param pageSize 分页大小
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/service/queryProviderService",method = RequestMethod.POST)
    public Object queryProviderService(String service, String require, Integer page, Integer pageSize) throws Exception {
        if (FastValid.isEmp(page)) {
            page = 1;
            pageSize = 10;
        }
        String logId = logId();
        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        ServiceInfo serviceInfo = JSONObject.parseObject(service, ServiceInfo.class);
        serviceInfo.setLogId(logId);
        Map map = JSONObject.parseObject(require, Map.class);
        RowBounds rowBounds = getRowBounds(page, pageSize);
        try {
            serviceService.queryServiceByReqiure(serviceInfo, map, rowBounds);
        } catch (ExceptionWithMessage e) {
            return AppJsonResult.formJsonResult(e.jsonResult);
        } catch (Exception e) {
            return AppJsonResult.formJsonResult(new JsonResult(false, null, null));
        }

        return AppJsonResult.formJsonResult(new JsonResult(true, null, null));
    }

    /**
     * 查询服务详情 跳转至服务详情页面
     *
     * @param serviceId 服务详情的id
     * @param priceType 价格类型
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryServiceVo",method=RequestMethod.POST)
    public Object queryServiceVo(String serviceId, Integer priceType) throws Exception {
        ServiceVo serviceVo = serviceService.queryServiceVoDetailsById(serviceId, priceType, null);
        return AppJsonResult.success(serviceVo);
    }

    /**
     * 查询推荐商品列表
     * @param serviceId 主商品id
     * @param priceType 价格类型
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryServiceVoTree",method=RequestMethod.POST)
    public Object queryServiceVoTree(String serviceId, Integer priceType) throws Exception {
        PageRowBounds rb = getPageRowBounds(1, 6);
        ServiceVo serviceVo = serviceService.queryServiceVoDetailsById(serviceId, priceType, null);
        List<ServiceInfoVo> serviceVoTree = serviceService.queryServiceByType(rb, serviceVo.getTypeTree(), "SERVICE_MEETNUM", "", "", "");
        return AppJsonResult.success(serviceVoTree);
    }

    /**
     * 查询服务商推荐
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryProviderVoTree",method = RequestMethod.POST)
    public Object queryProviderVoTree() throws Exception {
        List<ProviderVo> providerVoTree = providerInfoService.queryProviderRecommend(null);
        return AppJsonResult.success(providerVoTree);
    }

    /**
     * 查询价格设置
     * @param serviceId 服务的id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryServiceStep",method = RequestMethod.POST)
    public Object queryServiceStep(String serviceId) throws Exception {
        List<ServiceStep> serviceSteplist = serviceService.selectServiceSetById(serviceId);
        return AppJsonResult.success(serviceSteplist);
    }


    /**
     * 查询服务评价
     * @param page 分页页数
     * @param pageSize 分页大小
     * @param srLevel 分页等级
     * @param serviceId 服务id
     */
    @ResponseBody
    @RequestMapping(value="/service/queryServiceRemark",method = RequestMethod.POST)
    public Object queryServiceRemark(Integer page, Integer pageSize, String srLevel, String serviceId) throws Exception {
    	if (FastValid.isEmp(page,pageSize)) {
            page = 1;
            pageSize = 10;
        }
        ServiceRemarkVo serviceRemarkVo = new ServiceRemarkVo();
        int[] lev = null;
        if (srLevel != null && srLevel.trim().length() > 0) {
            String[] str = srLevel.split(",");
            lev = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                lev[i] = Integer.parseInt(str[i]);
            }
        }
        serviceRemarkVo.setSrLevel(lev);
        serviceRemarkVo.setServiceId(serviceId);
        PageRowBounds rowBounds = getPageRowBounds(page, pageSize);
        List<ServiceRemarkVo> list = remarkService.queryServiceRemarkByServiceId(serviceRemarkVo, rowBounds);
        Integer totalSize = remarkService.queryCountServiceRemarkByServiceId(serviceRemarkVo);
        FastPage<ServiceRemarkVo> fastPage = new FastPage<ServiceRemarkVo>(list, totalSize, rowBounds);
        return AppJsonResult.success(fastPage);
    }


    /**
     * 根据serviceId和srLevel查询好中差评的数量
     * @param serviceId 服务的id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryCountRemark",method = RequestMethod.POST)
    public Object queryCountRemark(String serviceId) throws Exception {
        RemarkCountVo remarkCountVo = new RemarkCountVo();
        remarkCountVo.setServiceId(serviceId);
        List<RemarkCountVo> list = remarkService.queryCountRemark(remarkCountVo);
        return AppJsonResult.success(list);
    }

    /**
     * 我的评价ModelAndView
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryAllCountServiceRemarkByTime",method = RequestMethod.POST)
    public Object queryAllCountServiceRemarkByTime() throws Exception {
        String logId = logId();
        Integer[] serviceRemarkcount = remarkService.queryAllCountServiceRemarkByTime(logId);
        return AppJsonResult.success(serviceRemarkcount);
    }


    /**
     * 对我的评价ModelAndView
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryServiceRemarkByLogId",method = RequestMethod.POST)
    public Object queryServiceRemarkByLogId() throws Exception {
        String logId = logId();
        Integer[] providerRemarkcount = remarkService.queryServiceRemarkByLogId(logId);
        return AppJsonResult.success(providerRemarkcount);
    }


    /**
     * 根据logId和srLevel查询服务评价
     * @param logId 登陆id
     * @param srLevel 等级
     * @param page 分页页数
     * @param pageSize 分页大小
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryServiceRemarkByLogIdSrLevel",method = RequestMethod.POST)
    public Object queryServiceRemarkByLogIdSrLevel(String logId, String srLevel, Integer page, Integer pageSize) throws Exception {
        ServiceRemarkVo serviceRemarkVo = new ServiceRemarkVo();
        serviceRemarkVo.setLogId(logId);
        int[] lev = null;
        if (srLevel != null && srLevel.trim().length() > 0) {
            String[] str = srLevel.split(",");
            lev = new int[str.length];
            for (int i = 0; i < str.length; i++) {

                lev[i] = Integer.parseInt(str[i]);
            }
        }
        serviceRemarkVo.setSrLevel(lev);

        PageRowBounds rowBounds = getPageRowBounds(page, pageSize);

        List<ServiceRemarkVo> list = remarkService.queryServiceRemarkByLogIdSrLevel(serviceRemarkVo, rowBounds);

        Integer totalSize = remarkService.queryCountServiceRemarkByLogIdSrLevel(serviceRemarkVo);

        FastPage<ServiceRemarkVo> fastPage = new FastPage<ServiceRemarkVo>(list, totalSize, rowBounds);
        return AppJsonResult.success(fastPage);
    }


    /**
     * 根据logId和srLevel查询好中差评分类的数量
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryCountRemarkByLogIdSrLevel",method = RequestMethod.POST)
    public Object queryCountRemarkByLogIdSrLevel() throws Exception {
        String logId = logId();
        RemarkCountVo remarkCountVo = new RemarkCountVo();
        remarkCountVo.setLogId(logId);
        List<RemarkCountVo> list = remarkService.queryCountRemarkLogId(remarkCountVo);
        return AppJsonResult.success(list);
    }


    /**
     * 根据服务商的logId查询服务评价的ModelAndView
     * @param logId llogid
     * @param srLevel 等级
     * @param page 分页页数
     * @param pageSize 分页大小
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryServiceRemarkByLogIdServiceId",method = RequestMethod.POST)
    public Object queryServiceRemarkByLogIdServiceId(String logId, String srLevel, Integer page, Integer pageSize) throws Exception {
        ServiceRemarkVo serviceRemarkVo = new ServiceRemarkVo();
        int[] lev = null;
        if (srLevel != null && srLevel.trim().length() > 0) {
            String[] str = srLevel.split(",");
            lev = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                lev[i] = Integer.parseInt(str[i]);
            }
        }
        serviceRemarkVo.setLogId(logId);
        serviceRemarkVo.setSrLevel(lev);
        PageRowBounds rowBounds = getPageRowBounds(page, pageSize);
        List<ServiceRemarkVo> list = remarkService.queryServiceRemarkByLogIdServiceId(serviceRemarkVo, rowBounds);
        Integer totalSize = remarkService.queryCountServiceRemarkByLogIdServiceId(serviceRemarkVo);
        FastPage<ServiceRemarkVo> record = new FastPage<ServiceRemarkVo>(list, totalSize, rowBounds);
        return AppJsonResult.success(record);
    }

    /**
     * 根据服务商的logId查询服务评价的好中差评分类的数量
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="/service/queryCountRemarkByLogIdServiceId",method = RequestMethod.POST)
    public Object queryCountRemarkByLogIdServiceId() throws Exception {
        String logId = logId();
        RemarkCountVo remarkCountVo = new RemarkCountVo();
        remarkCountVo.setLogId(logId);
        List<RemarkCountVo> list = remarkService.queryCountRemarkLogIdServiceId(remarkCountVo);
        return AppJsonResult.success(list);
    }
}