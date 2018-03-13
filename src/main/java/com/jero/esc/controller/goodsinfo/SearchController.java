package com.jero.esc.controller.goodsinfo;


import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.po.pubinfo.CommonType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController  extends BaseController{


    @Autowired
    private CommonTypeMapper commonTypeMapper;


    //进入搜索页面
    @RequestMapping("/view")
    public ModelAndView view(HttpSession session, Boolean to, String flag, String type, String province, String search){

        if (to!=null) clearModule(session);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/search");
        modelAndView.addObject("flag",flag==null?"a":flag);
        modelAndView.addObject("type",type);
        modelAndView.addObject("province",province);
        modelAndView.addObject("search",search);
        modelAndView.addObject("to",(to==null||to==false)?null:to);
        return modelAndView;
    }

    //根据类型id，获得其类型树（不包括自己）
    @ResponseBody
    @RequestMapping("/types")
    public  String types(String fid){
        List<CommonType> commonTypes = commonTypeMapper.selectChainByFid(StringUtils.isBlank(fid) ? "0":fid);
        return JSON.toJSONString(commonTypes);
    }


}

