package com.jero.esc.controller.wap.pubinfo;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.StringUtil;
import com.jero.esc.mapper.pubinfo.CommonTypeMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.pubinfo.CommonTypeExample;
import com.jero.esc.po.pubinfo.CommonTypeImg;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;

/**
 * Created by blazh on 2017/1/5.
 */
@Controller
@RequestMapping("/wap/pubinfo")
public class WapCommonTypeController extends BaseController {

    @Autowired
    private CommonTypeMapper commonTypeSaveMapper;
    
    @Autowired
    private CommonTypeSaveMapper commonTypeMapper;

    @Autowired
    private CommonTypeService commonTypeService;

    @ResponseBody
    @RequestMapping(value = "/getTree",produces = "text/html;charset=UTF-8")
    public String  getTree(@RequestParam("type")String type){
        CommonTypeExample commonTypeSaveExample = new CommonTypeExample();
        commonTypeSaveExample.or().andCtTypeEqualTo(Integer.parseInt(type));
        List<CommonType> commonTypes = commonTypeSaveMapper.selectByExample(commonTypeSaveExample);
        return JSON.toJSONString(commonTypes);
    }

    @RequestMapping(value="/commonType/getCommonType.html")
    public void getCommonType(HttpServletResponse response, HttpSession session){
    	String commonType;
    	if(StringUtils.isBlank(getModule(session))){
    		commonType = commonTypeMapper.selectByPrimaryKey("0").getSaveValue();
    	}else{
    		commonType = commonTypeMapper.selectByPrimaryKey(getModule(session)).getSaveValue();
    	}
    	/*Map<String, Object> typeMap = new HashMap<String, Object>();
    	typeMap.put("typeMap", commonType);*/
    	JsonUtil.printByJSON(response, commonType);
    	
    	
    	
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
    		CommonTypeImg commonTypeImg = this.commonTypeSaveMapper.findCommonTypeImgById(id);
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
