package com.jero.esc.controller.company;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.mapper.bizinfo.CompanyInfoMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.bizinfo.CompanyInfo;
import com.jero.esc.po.bizinfo.CompanyInfoExample;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.service.pubinfo.ICommonTypeService;
import com.jero.esc.vo.userinfo.ProviderVo;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController{

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    @Autowired
    ICommonTypeService commonTypeService;
    
    @Autowired
    CommonTypeMapper commonTypeMapper;
    
    @Autowired
    ProviderInfoMapper providerInfoMapper;

    @RequestMapping("/companyIndex")
    public ModelAndView companyIndex(HttpSession session){
        session.setAttribute("company",null);
        List<CommonType> commonTypes = commonTypeMapper.selectChainByFid("0");
        List<CommonType> types1=commonTypes.subList(0, 9);
        System.out.println(commonTypes.size());
        List<CommonType> types2=commonTypes.subList(9, commonTypes.size());
        List<ProviderVo> providerVos = providerInfoMapper.selectProviderByOrder(RowBounds.DEFAULT,"PI_MEETNUM DESC",null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("providerVos", providerVos);
        modelAndView.addObject("types1", types1);
        modelAndView.addObject("types2", types2);
        modelAndView.setViewName("company/companySelect");
        return modelAndView;
    }



    //返回公司列表
    @ResponseBody
    @RequestMapping(value = "/companyListAjax",produces = "text/html;charset=UTF-8")
    public String companyListAjax(String province,Boolean to,String search,HttpSession session,String serviceTypetree){

//        Integer pageSize = 10;
//        RowBounds rb = this.getRowBounds(page, pageSize);
        HashMap<String, Object> map = new HashMap<String, Object>();

        if (to!=null){
            clearModule(session);
        }

        if(serviceTypetree!=null)serviceTypetree=serviceTypetree.replaceAll("[,]","");
//        PageHelper.startPage(page,pageSize);
        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.or()
                .andCompNameLike("%"+(search==null?"":search)+"%")
                .andCompProviceLike("%"+(province==null?"":province)+"%")
                .andCompCommentsLike("%"+((serviceTypetree==null||serviceTypetree.equals(""))?"":serviceTypetree))
                .andCompStateEqualTo(2);
        List<CompanyInfo> companyInfos = companyInfoMapper.selectByExample(companyInfoExample);
        int i = companyInfoMapper.countByExample(companyInfoExample);
        map.put("list", companyInfos);
//        map.put("count", i);
//        map.put("pageNo", page);

        return  JSON.toJSONString(map);
    }


    //返回公司列表
//    @CachePut(value = "comSearchChae",key = "'companyList:'+#companyName")
//    @Cacheable(value = "comSearchChae",key = "'companyList:'+#companyName")
//    @ResponseBody
    @RequestMapping(value = "/companyList")
    public ModelAndView companyList(Boolean to,String search,String province,HttpSession session,Integer page,String serviceTypetree,String order){

        if(page==null){
            page = 1;
        }
         province = "";
        String city = "";
        String area = "";
        ModelAndView modelAndView = new ModelAndView();
        Integer pageSize = 10;

        if (to!=null){
            clearModule(session);
        }

        String commonType = commonTypeService.queryServiceTypeSave("5", null).getSaveValue();
        JSONObject jso = JSONObject.parseObject(commonType);
        JSONArray commonTypeList = new JSONArray();
        if(jso!=null){
            commonTypeList =  jso.getJSONArray("saveValue");
        }


        if(serviceTypetree!=null)serviceTypetree=serviceTypetree.replaceAll("[,]","");
        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.or()
                .andCompNameLike("%"+(search==null?"":search)+"%")
                .andCompProviceLike("%"+(province==null?"":province)+"%")
                .andCompCommentsLike("%"+((serviceTypetree==null||serviceTypetree.equals(""))?"":serviceTypetree))
                .andCompStateEqualTo(2);
        PageHelper.startPage(1,10);
        List<CompanyInfo> companyInfos = companyInfoMapper.selectByExample(companyInfoExample);
        int i = companyInfoMapper.countByExample(companyInfoExample);
        modelAndView.addObject("jsonList", JSON.toJSONString(companyInfos));
        modelAndView.addObject("count", i);
        modelAndView.setViewName("/company/companySearch");

        modelAndView.addObject("serviceTypetree", serviceTypetree);
        modelAndView.addObject("flag", "d");
        modelAndView.addObject("search", search);
        modelAndView.addObject("commonTypeList", commonTypeList);
        return  modelAndView;
    }



    //转跳至对应的公司
    @RequestMapping("/gotoCompany")
    public void gotoCompany(HttpServletRequest request, HttpServletResponse response, HttpSession session, String companyId) throws IOException {
        System.out.println(companyId);
        CompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(companyId);
        session.setAttribute("company",companyInfo);
        response.sendRedirect(request.getContextPath()+"/goodsinfo/ServiceInfo/homeShow.html?comId="+companyId);
    }


}
