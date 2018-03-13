package com.jero.esc.controller.goodsinfo;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.jero.esc.mapper.pubinfo.AllMetaMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.po.pubinfo.AllMeta;
import com.jero.esc.po.pubinfo.AllMetaExample;
import com.jero.esc.po.pubinfo.AllMetaExample.Criteria;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.pubinfo.SwitchInfo;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;
import com.jero.esc.service.pubinfo.ISwitchInfoService;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.utils.HtmlUtil;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.service.goodsinfo.IServiceService;
import com.jero.esc.service.userinfo.IProviderInfoService;
import com.jero.esc.vo.goodsinfo.ServiceInfoVo;
import com.jero.esc.vo.userinfo.ProviderVo;
import com.jero.esc.vo.userinfo.ServiceVo;

@Controller
@RequestMapping(value = "/goodsinfo")
public class HomeController extends BaseController {

    @Autowired
    private IProviderInfoService providerInfoService;
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private CommonTypeService commonTypeService;
    @Autowired
    private CommonTypeMapper commonTypeMapper;

    @Autowired
    private CommonTypeSaveMapper commonTypeSaveMapper;
    @Autowired
    private ISwitchInfoService switchInfoService;
    @Autowired
    private AllMetaMapper allMetaMapper;

    /**
     * @return ModelAndView
     * @version v1.0
     * @date 2016年12月27日
     * @description 首页显示
     * @method homeShow
     */
    @Cacheable(value = "homeChae", key = "'home:'+#session.getAttribute('module')")
    @CachePut(value = "homeChae", key = "'home:'+#session.getAttribute('module')")
    @RequestMapping(value = "/ServiceInfo/homeShow")
    public ModelAndView homeShow(HttpSession session,String module) throws Exception {
    	
    	ModelAndView modelAndView = new ModelAndView();
    	AllMetaExample example=new AllMetaExample();
    	Criteria criteria=example.createCriteria();
    	criteria.andTypeEqualTo(module);
    	List<AllMeta> la=allMetaMapper.selectByExample(example);
        try {
	        String serviceTypetree = null;
	        RowBounds rb = this.getRowBounds(1, 4);
	        //视频模块为选填   所以暂时隐藏
	        /*List<ProviderVo> videoList = providerInfoService.selectProviderByOrder(rb, getModule(session));*/
	        HashMap<String, Object> map = providerInfoService.queryRecommendProvider(serviceTypetree, getModule(session),1);
	        Object proList = map.get("proList");
	        Object serList1 = map.get("serList1");
	        Object serList2 = map.get("serList2");
	        Object siList = map.get("siList");
	        Object adList = map.get("adList");
	        Object commonTypeList = map.get("commonTypeList");
	        String jsonList1 = JSON.toJSONString(serList1);
	        String jsonList2 = JSON.toJSONString(serList2);
	        /*modelAndView.addObject("videoList", videoList);*/
	        modelAndView.addObject("proList", proList);
	        modelAndView.addObject("jsonList1", jsonList1);
	        modelAndView.addObject("jsonList2", jsonList2);
	        modelAndView.addObject("siList", siList);
	        modelAndView.addObject("stId", "001");
	        modelAndView.addObject("adList", adList);
	        modelAndView.addObject("isSilde", "aa");
	        modelAndView.addObject("commonTypeList", commonTypeList);
            modelAndView.setViewName("goodsinfo/home");
            modelAndView.addObject("metas", la.get(0));
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("home");
        }
    }

    @RequestMapping(value = "/ServiceInfo/homeShowByAjax.html")
    public void homeShowByAjax(HttpServletResponse response, String serviceTypetree, HttpSession session) {
        HashMap<String, Object> map = providerInfoService.queryRecommendProvider(serviceTypetree, getModule(session),1);
        HashMap<String, Object> mapp = new HashMap<String, Object>();
        mapp.put("serList1", map.get("serList1"));
        mapp.put("serList2", map.get("serList2"));
        JsonUtil.printByJSON(response, mapp);
    }


    //	@Cacheable(value = "comSearchChae",key = "'searchServiceByAjax:'+#session.getAttribute('company').compId+':'+#search+':'+#province+':'+#page+':'+#city+#area")
//	@CachePut(value = "comSearchChae",key = "'searchServiceByAjax:'+#session.getAttribute('company').compId+':'+#search+':'+#flag")
    @ResponseBody
    @RequestMapping(value = "/ServiceInfo/searchServiceByAjax", produces = "text/html;charset=UTF-8")
    public String searchServiceByAjax(String type, HttpSession session, HttpServletResponse response, Integer page, String order, String flag, String search, String province, String city, String area) {
        Integer pageSize = 10;
        if(page==null||page==0){
        	page=1;
        }
        RowBounds rb = this.getRowBounds(page, pageSize);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(province))province=null;
        if (StringUtils.isBlank(city))province=null;
        if(StringUtils.isBlank(area))area=null;

        if ("a".equals(flag)) {

            Integer count = serviceService.queryServiceCountByCon(search, order, province, city, area, StringUtils.isBlank(type)?null:type);
            List<ServiceInfoVo> serviceList = serviceService.queryServiceByCon(rb, search, order, province, city, area, StringUtils.isBlank(type)?null:type,(String)session.getAttribute("point"));
            if (count<=0){
                count=serviceService.queryServiceCountByCon(search, order, null, null, null, StringUtils.isBlank(type)?null:type);
                serviceList= serviceService.queryServiceByCon(rb, search, order, null, null, null, StringUtils.isBlank(type)?null:type,(String)session.getAttribute("point"));
            }
            map.put("list", serviceList);
            map.put("count", count);
        } else if ("b".equals(flag)) {
            Integer count = providerInfoService.queryProviderCountBySearch(search, order, province, city, area, StringUtils.isBlank(type)?null:type);
            List<ProviderVo> proList = providerInfoService.queryProviderBySearch(rb, search, order, province, city, area, StringUtils.isBlank(type)?null:type);
            if (count<=0){
                count=providerInfoService.queryProviderCountBySearch(search, order, null, null, null, StringUtils.isBlank(type)?null:type);
                proList=providerInfoService.queryProviderBySearch(rb, search, order, null, null, null, StringUtils.isBlank(type)?null:type);
            }
            map.put("list", proList);
            map.put("count", count);
        }
        map.put("pageNo", page);
        return HtmlUtil.delHTML(JSON.toJSONString(map));
    }

    @RequestMapping(value = "/ServiceInfo/searchProvider")
    public ModelAndView searchProvider(HttpSession session, Integer page, String search, String order) {
        if (page == null) {
            page = 1;
        }
        String province = "";
        String city = "";
        String area = "";
        String flag = "b";
        ModelAndView modelAndView = new ModelAndView();
        Integer pageSize = 10;
        order = "PI_DEALNUM DESC";
        RowBounds rb = this.getRowBounds(page, pageSize);
        String commonType = getModule(session) == null
                ? commonTypeSaveMapper.selectByPrimaryKey("0").getSaveValue()
                : commonTypeSaveMapper.selectByPrimaryKey(getModule(session)).getSaveValue();
        JSONObject jso = JSONObject.parseObject(commonType);
        JSONArray commonTypeList = new JSONArray();
        if (jso != null) {
            commonTypeList = jso.getJSONArray("saveValue");
        }
        List<ProviderVo> proList = providerInfoService.queryProviderBySearch(rb, search, order, province, city, area, getModule(session));
        Integer count = providerInfoService.queryProviderCountBySearch(search, order, province, city, area, getModule(session));
        String jsonList = JSON.toJSONString(proList);
        modelAndView.addObject("jsonList", jsonList);
        modelAndView.addObject("count", count);
        modelAndView.addObject("search", search);
        modelAndView.addObject("flag", flag);
        modelAndView.addObject("commonTypeList", commonTypeList);
        modelAndView.setViewName("goodsinfo/providerList");
        return modelAndView;
    }


    @RequestMapping(value = "/ServiceInfo/showVideoList")
    public ModelAndView showVideoList(HttpSession session, Integer page, String order) {
        if (page == null) {
            page = 1;
        }
        order = "PI_DEALNUM DESC";
        String com = getModule(session);
        ModelAndView mv = new ModelAndView();
        RowBounds rb = this.getRowBounds(page, 16);
        HashMap<String, Object> videoMap = providerInfoService.selectVideoByOrder(rb, order, getModule(session));
        Object videoList1 = videoMap.get("videoList1");
        Object videoList2 = videoMap.get("videoList2");
        Object videoList3 = videoMap.get("videoList3");
        Object videoList4 = videoMap.get("videoList4");
        Integer count = providerInfoService.selectProviderCountByOrder(getModule(session));
        String jsonList1 = JSON.toJSONString(videoList1);
        String jsonList2 = JSON.toJSONString(videoList2);
        String jsonList3 = JSON.toJSONString(videoList3);
        String jsonList4 = JSON.toJSONString(videoList4);
        mv.addObject("jsonList1", jsonList1);
        mv.addObject("jsonList2", jsonList2);
        mv.addObject("jsonList3", jsonList3);
        mv.addObject("jsonList4", jsonList4);
        mv.addObject("isSilde", "aa");
        mv.addObject("count", count);
        mv.addObject("stId", "002");
        mv.setViewName("goodsinfo/videoList");
        return mv;
    }

    @RequestMapping(value = "/ServiceInfo/showVideoListByAjax")
    public void showVideoListByAjax(HttpSession session, HttpServletResponse response, Integer page, String order) {
        Integer pageSize = 16;
        RowBounds rb = this.getRowBounds(page, pageSize);
        String com = getModule(session);
        HashMap<String, Object> videoMap = providerInfoService.selectVideoByOrder(rb, order, getModule(session));
        Object videoList1 = videoMap.get("videoList1");
        Object videoList2 = videoMap.get("videoList2");
        Object videoList3 = videoMap.get("videoList3");
        Object videoList4 = videoMap.get("videoList4");
        Integer count = providerInfoService.selectProviderCountByOrder(getModule(session));
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("videoList1", videoList1);
        map.put("videoList2", videoList2);
        map.put("videoList3", videoList3);
        map.put("videoList4", videoList4);
        map.put("count", count);
        map.put("pageNo", page);
        JsonUtil.printByJSON(response, map);
    }


    @RequestMapping(value = "/ServiceInfo/showMorePage")
    public ModelAndView showMorePage(String stId, String order, Integer page, HttpSession session) {
        if (page == null) {
            page = 1;
        }
        String com = getModule(session);
        ModelAndView mv = new ModelAndView();
        if ("003".equals(stId)) {
            order = "PI_DEALNUM DESC";
            RowBounds rb = this.getRowBounds(page, 16);
            List<ServiceVo> showList = serviceService.queryServiceByProvider(order, rb, getModule(session));
            Integer count = serviceService.queryServiceCountByProvider(order, getModule(session));
            String jsonList = JSON.toJSONString(showList);
            mv.addObject("jsonList", jsonList);
            mv.addObject("count", count);
            mv.setViewName("goodsinfo/greatProvider");
        } else if ("004".equals(stId)) {
            order = "SERVICE_SUCCESSNUM DESC";
            RowBounds rb = this.getRowBounds(page, 16);
            List<ServiceInfoVo> showList = serviceService.queryGreatService(order, rb, getModule(session));
            Integer count = serviceService.queryGreatServiceCount(order, getModule(session));
            String jsonList = JSON.toJSONString(showList);
            mv.addObject("jsonList", jsonList);
            mv.addObject("count", count);
            mv.setViewName("goodsinfo/greatService");
        } else if ("005".equals(stId)) {
            mv.setViewName("goodsinfo/operationGuide");
        } else if ("006".equals(stId)) {
            mv.setViewName("goodsinfo/serviceEnsure");
        }
        mv.addObject("isSilde","aa");
        mv.addObject("stId", stId);
        return mv;
    }

    @RequestMapping(value = "/ServiceInfo/showMorePageByAjax")
    public void showMorePageByAjax(HttpSession session, HttpServletResponse response, Integer page, String order, String stId) {
        Integer pageSize = 16;
        RowBounds rb = this.getRowBounds(page, pageSize);
        HashMap<String, Object> map = new HashMap<String, Object>();
        String com = getModule(session);
        if ("003".equals(stId)) {
            List<ServiceVo> showList = serviceService.queryServiceByProvider(order, rb, getModule(session));
            Integer count = serviceService.queryServiceCountByProvider(order, getModule(session));
            map.put("showList", showList);
            map.put("count", count);
        } else if ("004".equals(stId)) {
            List<ServiceInfoVo> showList = serviceService.queryGreatService(order, rb, getModule(session));
            Integer count = serviceService.queryGreatServiceCount(order, getModule(session));
            map.put("showList", showList);
            map.put("count", count);
        } else if ("005".equals(stId)) {

        } else if ("006".equals(stId)) {

        }
        map.put("pageNo", page);
        JsonUtil.printByJSON(response, map);
    }

    @RequestMapping(value = "/home/direct")
    public ModelAndView direct(String stId) {
        ModelAndView mv = new ModelAndView();
        if ("311".equals(stId)) {
            mv.setViewName("goodsinfo/directEnterCondition");
        } else if ("312".equals(stId)) {
            mv.setViewName("goodsinfo/directEnterProcess");
        } else if ("321".equals(stId)) {
            mv.setViewName("goodsinfo/directPublishService");
        } else if ("322".equals(stId)) {
            mv.setViewName("goodsinfo/directPendProcess");
        } else if ("323".equals(stId)) {
            mv.setViewName("goodsinfo/directPublishRuler");
        } else if ("331".equals(stId)) {
            mv.setViewName("goodsinfo/directAppoint");
        } else if ("332".equals(stId)) {
            mv.setViewName("goodsinfo/directPay");
        } else if ("341".equals(stId)) {
            mv.setViewName("goodsinfo/directManage");
        } else if ("342".equals(stId)) {
            mv.setViewName("goodsinfo/directWithdraw");
        } else if ("351".equals(stId)) {
            mv.setViewName("goodsinfo/directEdit");
        } else if ("352".equals(stId)) {
            mv.setViewName("goodsinfo/directPayPass");
        }
        mv.addObject("stId", stId);
        return mv;
    }

    @RequestMapping(value = "/home/ensure")
    public ModelAndView ensure() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("goodsinfo/ensure");
        return mv;
    }

    @RequestMapping(value = "/home/nearest")
    public ModelAndView nearest() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("goodsinfo/nearest");
        return mv;
    }

    @RequestMapping(value = "/home/publishNeed")
    public ModelAndView publishNeed() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("goodsinfo/publishNeed");
        return mv;
    }

    @RequestMapping(value = "/home/publishService")
    public ModelAndView publishService() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("goodsinfo/publishService");
        return mv;
    }

    @RequestMapping(value = "/home/agreement")
    public ModelAndView agreement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pubinfo/agreement");
        return mv;
    }


    @Cacheable(value = "homeChae", key = "'schoolModular:'")
    @CachePut(value = "homeChae", key = "'schoolModular:'")
    @RequestMapping(value = "/home/schoolModular")
    public ModelAndView schoolModular(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        SwitchInfo switchInfo = new SwitchInfo();
        switchInfo.setSwitchPos(1);
		switchInfo.setCompany(this.getModule(session));
		List<SwitchInfo> siList = switchInfoService.queryPicByPosition(switchInfo);
		JSONArray jsonarray = new JSONArray();
		if(siList!=null&&siList.size()>0){
			jsonarray = JSONArray.parseArray(siList.get(0).getSwitchImg());
		}
		List<CommonType> commonTypes = commonTypeMapper.selectChainByFid(this.getModule(session));
		HashMap<String, Object> map = providerInfoService.querySchoolProvider(commonTypes);
        mv.setViewName("goodsinfo/schoolModular");
        mv.addObject("siList", jsonarray);
        mv.addObject("map", map);
        return mv;
    }
    @RequestMapping(value = "/home/pictures")
    public ModelAndView pictures(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("goodsinfo/pictures");
        return mv;
    }

}
