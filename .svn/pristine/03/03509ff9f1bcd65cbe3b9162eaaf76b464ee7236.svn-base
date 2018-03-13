package com.jero.esc.controller.appapi.goodsinfo;


import com.alibaba.fastjson.JSON;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.po.pubinfo.CommonType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("apiSearchController")
@RequestMapping("/appapi/goodsinfo/search")
public class SearchController  extends AppBaseController{


    @Autowired
    private CommonTypeMapper commonTypeMapper;



    //根据类型id，获得其类型树（不包括自己）
    @ResponseBody
    @RequestMapping(value="/types",method = RequestMethod.POST)
    public  Object types(String fid){
        List<CommonType> commonTypes = commonTypeMapper.selectChainByFid(StringUtils.isBlank(fid) ? "0":fid);
        return AppJsonResult.success(commonTypes);
    }


}

