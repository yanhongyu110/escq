package com.jero.esc.controller.wap.goodsinfo;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.mapper.details.MegDetailsMapper;
import com.jero.esc.po.details.MegDetails;
import com.jero.esc.po.pubinfo.SwitchInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.demand.IDemandService;
import com.jero.esc.service.pubinfo.ISwitchInfoService;
import com.jero.esc.vo.demand.DemandVo;

@Controller
@RequestMapping("/wap/main")
public class WapMainIndexController  extends BaseController{
	@Autowired
	private MegDetailsMapper megDetailsMapper;
    @Autowired
    ISwitchInfoService  switchInfoService;
    @Autowired
    IDemandService demandService;

    @RequestMapping("/view")
    public ModelAndView main(HttpSession session, HttpServletRequest request){
    	clearModule(session);
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("/wap/goodsinfo/main");
//    	String ua = ((HttpServletRequest) request).getHeader("user-agent")  
//    	        .toLowerCase();  
//    	if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器  
    		LogInfo logInfo = this.retrievalCurrentUserInfo(session);
    		if(logInfo != null){
    			List<MegDetails> list = megDetailsMapper.selectListByLogId(logInfo.getLogId());
				modelAndView.addObject("logInfo", list.size());
    		}else{
    			modelAndView.addObject("logInfo", -1);
    		}
//    	}  
        // 简单获取轮播数据
        SwitchInfo  si  = new SwitchInfo();
        si.setSwitchPos(2);
        si.setCompany("00001");
        List<SwitchInfo> siList = switchInfoService.queryPicByPosition(si);
        if(siList!=null&&siList.size()>0){
        	modelAndView.addObject("banner1", siList.get(0));
        }
        List<DemandVo> demands=demandService.takeTopByCount1(3, null);
        modelAndView.addObject("demands", demands);
        return  modelAndView;
    }


    @RequestMapping("/view/banner1")
    @ResponseBody
    public SwitchInfo getBanner1Test(){

        SwitchInfo  si  = new SwitchInfo();
        si.setSwitchPos(0);
        si.setCompany("0");
        List<SwitchInfo> siList = switchInfoService.queryPicByPosition(si);
        SwitchInfo switchInfo = new SwitchInfo();
        if(siList!=null&&siList.size()>0){
        	switchInfo = siList.get(0);
        }
        return  switchInfo;
    }
    @RequestMapping(value = "/pictures")
    public ModelAndView pictures(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("wap/goodsinfo/pictures");
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "/loginByToken")
    public String loginByToken(HttpServletRequest request,String user,String token) {
    	HttpSession session=request.getSession();
    	if(session!=null){
    		LogInfo logInfo=(LogInfo) session.getAttribute("logInfo");
    		if(logInfo!=null){
    			if(logInfo.getLogCell().equals(user)&&session.getId().equals(token)){
    				
    				return new JsonResult(true).toJSON();
    			}
    		}
    	}
    	return new JsonResult(false).toJSON();
    }
}
