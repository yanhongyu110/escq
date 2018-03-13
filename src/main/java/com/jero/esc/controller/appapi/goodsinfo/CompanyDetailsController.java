package com.jero.esc.controller.appapi.goodsinfo;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.po.pubinfo.CompanyDetails;
import com.jero.esc.service.goodsinfo.ICompanyDetailService;
import com.jero.esc.service.pubinfo.ICommonTypeService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller("appCompanyDetailsController")
@RequestMapping("/appapi/goodsinfo")
public class CompanyDetailsController extends AppBaseController{

	@Autowired
	private ICompanyDetailService companyDetailService;




	@ResponseBody
	@RequestMapping(value="/company/queryCompanyDetails",method = RequestMethod.POST)
	public AppJsonResult queryCompanyDetails(String companyProvince, String companyType, Integer page, Integer pageSize){
		if(page==null&pageSize==null){
			page = 1;
			pageSize=10;
   		}
		CompanyDetails company=new CompanyDetails();
		if(companyProvince!=null)company.setCompanyProvince(companyProvince);
		if(companyType!=null)company.setCompanyType(companyType);
		PageRowBounds rowBounds=getPageRowBounds(page, pageSize);
		FastPage<CompanyDetails> companydetails=null;
		try {
			companydetails=companyDetailService.queryCompanyByCon(company,(RowBounds)rowBounds);
		} catch (Exception e) {e.printStackTrace(); return  AppJsonResult.error("错误");}
		return  AppJsonResult.success(companydetails);
	}

}
