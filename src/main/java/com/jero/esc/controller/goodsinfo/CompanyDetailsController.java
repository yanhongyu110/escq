package com.jero.esc.controller.goodsinfo;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.alipay.util.httpClient.HttpResponse;
import com.jero.esc.po.pubinfo.CompanyDetails;
import com.jero.esc.service.goodsinfo.ICompanyDetailService;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;
import com.jero.esc.service.pubinfo.ICommonTypeService;

@Controller
@RequestMapping("/wap/goodsinfo")
public class CompanyDetailsController extends BaseController{
	
	
	@Autowired
	private ICommonTypeService commonTypeService;
	@Autowired
	private ICompanyDetailService companyDetailService;
	
	@RequestMapping(value="/company/showRecommend")
	public ModelAndView showRecommend(){
		
		/*commonTypeService.queryServiceTypeSave(saveType, com);*/
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/wap/goodsinfo/recommend");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping(value="/company/queryCompanyDetails")
	public void queryCompanyDetails(HttpServletResponse response,String companyProvince,String companyType,Integer page,Integer pageSize){
		if(page==null&pageSize==null){
			page = 1;
			pageSize=10;
   		}
		CompanyDetails company=new CompanyDetails();
		if(companyProvince!=null){
			company.setCompanyProvince(companyProvince);
		}
		if(companyType!=null){
			company.setCompanyType(companyType);
		}
		PageRowBounds rowBounds=getPageRowBounds(page, pageSize);
		FastPage<CompanyDetails> companydetails=null;
		try {
			companydetails=companyDetailService.queryCompanyByCon(company,(RowBounds)rowBounds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonUtil.printByJSON(response,companydetails);
	}

}
