package com.jero.esc.controller.appapi.company;

import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.mapper.bizinfo.CompanyInfoMapper;
import com.jero.esc.po.bizinfo.CompanyInfo;
import com.jero.esc.po.bizinfo.CompanyInfoExample;
import com.jero.esc.service.pubinfo.ICommonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller("apiCompanyController")
@RequestMapping("/appapi/company")
public class CompanyController {

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    @Autowired
    ICommonTypeService commonTypeService;

    /**
     * 返回公司列表
     * @param companyName 公司的名字
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/companyList",method = RequestMethod.POST)
    public Object companyList(String companyName){
        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.or().andCompNameLike("%"+(companyName==null?"":companyName)+"%");
        List<CompanyInfo> companyInfos = companyInfoMapper.selectByExample(companyInfoExample);
        return AppJsonResult.success(companyInfos);
    }


}
