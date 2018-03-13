package com.jero.esc.controller.appapi.pubinfo;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.pubinfo.CommonTypeExample;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller("appCommonTypeController")
@RequestMapping("/appapi/pubinfo")
public class CommonTypeController extends AppBaseController{

    @Autowired
    private CommonTypeMapper commonTypeMapper;
    @Autowired
    private CommonTypeService commonTypeService;
    @Autowired
    private CommonTypeSaveMapper commonTypeSaveMapper;


    /**
     * @param id
     * @return
     */
    @ResponseBody
    @Cacheable(value = "homeChae",key = "'appgetTree:'+#id")
    @CachePut(value = "homeChae",key = "'appgetTree:'+#id")
    @RequestMapping(value = "/getTree",method = RequestMethod.POST)
    public AppJsonResult   getTree(String id){
        List<CommonType> commonTypes = commonTypeMapper.selectChainByFid(StringUtils.isBlank(id)?"0":id);
//        List<CommonType> re = new ArrayList<>();
//        if (!StringUtils.isBlank(includes)){
//            String[] split = includes.split(",");
//            for (String s : split) {
//                for (int i = 0; i < commonTypes.size(); i++) {
//                    if (commonTypes.get(i).getCtId().equals(s)){
//                        re.add(commonTypes.get(i));
//                        break;
//                    }
//                }
//            }
//        }else {
//            re=commonTypes;
//        }
        return AppJsonResult.success(commonTypes);
    }

    @ResponseBody
    @Cacheable(value = "homeChae",key = "'appcommonType:'+#comId")
    @CachePut(value = "homeChae",key = "'appcommonType:'+#comId")
    @RequestMapping(value="/commonType/getCommonType",method = RequestMethod.POST)
    public AppJsonResult getCommonType(String comId){
    	String commonType =commonTypeService.queryServiceTypeSave("1",comId).getSaveValue();
        return AppJsonResult.success(commonType);
    }

    @ResponseBody
    @RequestMapping(value="/commonType/updateViewType",method = RequestMethod.POST)
    public AppJsonResult updateViewType(String viewType,String comId){
    	try {
            return  AppJsonResult.success();
		} catch (Exception e) {
            return  AppJsonResult.error("保存异常");
		}
    }
    
}
