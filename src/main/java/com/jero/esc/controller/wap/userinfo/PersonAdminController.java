package com.jero.esc.controller.wap.userinfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/wap/userinfo")
public class PersonAdminController {

	@RequestMapping("/showWithDraw")
	public ModelAndView showWithDraw(){
		return new ModelAndView("wap/userinfo/withDraw");
	}
	@RequestMapping("/showAccount")
	public ModelAndView showAccount(){
		return new ModelAndView("wap/userinfo/account");
	}
	
	@RequestMapping("/showOrder")
	public ModelAndView showOrder(){
		return new ModelAndView("wap/userinfo/myorder");
	}
	
	@RequestMapping("/showExpert")
	public ModelAndView showExpert(){
		return new ModelAndView("wap/userinfo/myexpert");
	}
	
	@RequestMapping("/showTheMeg")
	public ModelAndView showTheMeg(){
		return new ModelAndView("wap/userinfo/meg");
	}
	
	@RequestMapping("/showFcous")
	public ModelAndView showFcous(){
		return new ModelAndView("wap/userinfo/thefocus");
	}
	
	@RequestMapping("/showBasicset")
	public ModelAndView showBasicset(){
		return new ModelAndView("wap/userinfo/basicset");
	}
	
	@RequestMapping("/showMyDemand")
	public ModelAndView showMyDemand(){
		return new ModelAndView("wap/userinfo/mydemand");
	}
}
