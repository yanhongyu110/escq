package com.jero.esc.controller.pubinfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.StringUtil;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.pubinfo.CommonTypeImg;
import com.jero.esc.po.pubinfo.CommonTypeSave;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;

@Controller
@RequestMapping("/pubinfo")
public class CommonTypeController extends BaseController{

    @Autowired
    private CommonTypeMapper commonTypeMapper;

    @Autowired
    private CommonTypeService commonTypeService;
    @Autowired
    private CommonTypeSaveMapper commonTypeSaveMapper;

    @ResponseBody
    @Cacheable(value = "homeChae",key = "'getTree:'+#id+':'+#includes")
    @CachePut(value = "homeChae",key = "'getTree:'+#id+':'+#includes")
    @RequestMapping(value = "/getTree",produces = "text/html;charset=UTF-8")
    public String  getTree(String id,String includes){
        List<CommonType> commonTypes = commonTypeMapper.selectChainByFid(StringUtils.isBlank(id)?"0":id);



        List<CommonType> re = new ArrayList<>();

        if (!StringUtils.isBlank(includes)){
            String[] split = includes.split(",");
            for (String s : split) {
                for (int i = 0; i < commonTypes.size(); i++) {
                    if (commonTypes.get(i).getCtId().equals(s)){
                        re.add(commonTypes.get(i));
                        break;
                    }
                }
            }
        }else {
            re=commonTypes;
        }


        return JsonUtil.stringToJson(JSON.toJSONString(re));
    }

//    @Cacheable(value = "homeChae",key = "'commonType:'+#session.getAttribute('company').compId")
//    @CachePut(value = "homeChae",key = "'commonType:'+#session.getAttribute('company').compId")
    @ResponseBody
    @RequestMapping(value="/commonType/getCommonType",produces = "text/html;charset=UTF-8")
    public String getCommonType(HttpServletResponse response, HttpSession session){
    	CommonTypeSave commonType;
        if(StringUtils.isBlank(getModule(session))){
            commonType = commonTypeSaveMapper.selectByPrimaryKey("0");
        }else{
            commonType = commonTypeSaveMapper.selectByPrimaryKey(getModule(session));
        }
        return commonType.getSaveValue();
    }
    
    @RequestMapping(value="/commonType/updateViewType.html")
    public void updateViewType(String viewType,HttpServletResponse response,HttpSession session){
    	JsonResult jr = new JsonResult();
    	try {
			jr.setSuccess(true);
			jr.setErrorMsg("保存成功");
		} catch (Exception e) {
			jr.setSuccess(false);
			jr.setErrorMsg("保存异常");
			e.printStackTrace();
		}
    	JsonUtil.printByJSON(response, jr);
    }
    
    /**
     * 
     *<pre>
     *<b> 获取选择类型的图片 .</b>
     *<b>Description:</b> 
     *    根据id
     *<b>Author:</b> yanhongyu
     *<b>Date:</b> 2017-11-2 下午4:43:29
     *@param id
     *</pre>
     */
    @RequestMapping(value="/commonType/findCommonTypeImgById")
    public void findCommonTypeImgById(String id,HttpServletResponse response){
    	JsonResult temp = null;
    	if(StringUtil.isNotEmpty(id)){
    		CommonTypeImg commonTypeImg = this.commonTypeMapper.findCommonTypeImgById(id);
    		if(commonTypeImg != null){
    			temp = new JsonResult(true, "", commonTypeImg);
    		}else{
    			temp = new JsonResult(false, "暂无图片", null);
    		}
    	}else{
    		temp = new JsonResult(false, "参数为空", null);
    	}
    	JsonUtil.printByJSON(response, temp);
    }
}
