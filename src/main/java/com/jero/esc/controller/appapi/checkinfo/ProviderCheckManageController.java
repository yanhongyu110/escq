package com.jero.esc.controller.appapi.checkinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;
import com.jero.esc.po.checkinfo.ProviderCheckInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.service.checkinfo.IPersonCheckNameService;
import com.jero.esc.service.checkinfo.IProviderCheckInfoService;
import com.jero.esc.service.checkinfo.IProviderCheckManageService;
import com.jero.esc.service.details.IPointPaymentDetailsService;
import com.jero.esc.service.impl.checkinfo.ProviderCheckInfoService;
import com.jero.esc.service.userinfo.IProviderInfoService;
import com.jero.esc.service.userinfo.IUserInfoService;
import com.jero.esc.vo.userinfo.UserInfoVo;
@Controller("apiProviderCheckManageController")
@RequestMapping("/appapi/checkinfo")
public class ProviderCheckManageController extends AppBaseController{
	
	@Autowired
	private IProviderCheckManageService providerCheckManageService;	
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private IPersonCheckNameService personCheckNameService;
	@Autowired
	private IProviderCheckInfoService checkInfoService;
	@Autowired
	private IProviderInfoService providerInfoService;


	public Map<String, Object> validatePro(ProviderInfo providerInfo,ProviderCheckInfo providerCheckInfo){
		Map<String, Object> map=new HashMap();
		if (BaseController.isValidate){
			//,providerInfo.getPiComment(),providerCheckInfo.getPciIntroduce(),,providerInfo.getPiUrls()
			//providerCheckInfo.getPciOthers(),providerCheckInfo.getPciEaducate(),providerCheckInfo.getPciCredentials(),
			if(FastValid.isEmp(providerInfo.getPiAddr(),providerInfo.getPiArea(),providerInfo.getPiBrief(),providerInfo.getLogId(), providerInfo.getPiCell(),
					providerInfo.getPiCompany(),providerInfo.getPiEmail(),providerInfo.getPiPhoto(),providerInfo.getPiPosition(),providerInfo.getPiKeywords(),
					providerInfo.getPiRealname(),providerInfo.getPiWorkyear(),providerInfo.getPiVideo(),providerInfo.getPiComment(),
					providerCheckInfo.getLogId(),providerCheckInfo.getPciImage())){
				 map.put("jres",new JsonResult(false,"请填写完整后完成认证",null));
				return map;
			}
			if (!FastValid.matches(providerInfo.getPiRealname(), FastValidateType.CHINESE_NAME)){
				map.put("jres",new JsonResult(false,"姓名不是中文",null));
				return map;
			}
			if (!FastValid.matches(providerInfo.getPiEmail(),FastValidateType.EMAIL)){
				map.put("jres",new JsonResult(false,"邮箱格式不对",null));
				return map;
			}
			if (!FastValid.matches(providerInfo.getPiCell(),FastValidateType.CELL)){
				map.put("jres",new JsonResult(false,"请输入正确的电话",null));
				return map;
			}
			if (!FastValid.matches(providerInfo.getPiKeywords(), FastValidateType.KEYWORDS)){
				map.put("jres",new JsonResult(false,"请输入5个以内的关键字",null));
				return map;
			}
			
			
			map.put("providerInfo",providerInfo);
			map.put("providerCheckInfo",providerCheckInfo);
			return map;
		}
		return null;
	}


	/**
	 * 查询获取认证资料
	 */
	@ResponseBody
	@RequestMapping(value="/providerCheck/getCheck",method = RequestMethod.POST)
	public Object getCheck() throws Exception{
		String logId=logId();
		ProviderCheckInfo providerCheckInfo=checkInfoService.queryByLogId(logId);
		return AppJsonResult.success(providerCheckInfo);
	}

	/**
	 * 查询获取基本信息
	 */
	@ResponseBody
	@RequestMapping(value="/providerCheck/getBasic",method = RequestMethod.POST)
	public Object getBasic() throws Exception{
		String logId=logId();
		ProviderInfo providerInfo=providerInfoService.queryByLogId(logId);
		return AppJsonResult.success(providerInfo);
	}


	/**
	 * 修改基本信息
	 * @param providerInfo
	 * @param providerCheckInfo
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/providerCheck/modifyBasic",method = RequestMethod.POST)
	public Object modifyBasic(ProviderInfo providerInfo,ProviderCheckInfo providerCheckInfo)throws Exception {
		String logId=logId();
		providerInfo.setLogId(logId);//log004
		providerCheckInfo.setLogId(logId);
		if(HtmlFilter.filter(providerInfo)||HtmlFilter.filter(providerCheckInfo)){
			return AppJsonResult.formJsonResult(new JsonResult("不能输入HTML标签"));
		} 
				Boolean temp = providerInfoService.modify(providerInfo);
				if(temp){
					return AppJsonResult.formJsonResult(new JsonResult(true, "修改基本信息成功!",null));
				}else{
					return AppJsonResult.formJsonResult(new JsonResult(false,"修改基本信息失败",null));
				}
	}

	/**
	 * 查询获取认证信息
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/providerCheck/getCheckInfo",method = RequestMethod.POST)
	public Object getCheckInfo() throws Exception{
		String logId=logId();
		Boolean checkres=personCheckNameService.isChecked(logId);
		if(checkres){
			//String logId="log004";// add i  update aaaa
			JsonResult jr1=providerCheckManageService.queryProviderInfoByLogId(logId);
			JsonResult jr2=providerCheckManageService.queryProviderCheckInfoByLogId(logId);
			if(jr1.isSuccess()&jr2.isSuccess()){
				ProviderInfo providerInfo=(ProviderInfo) jr1.getObj();
				ProviderCheckInfo providerCheckInfo=(ProviderCheckInfo) jr2.getObj();
				HashMap<String, Object> somap=new HashMap<>();
				if(providerCheckInfo.getPciState()==3){
					somap.put("providerInfo", providerInfo);
					somap.put("providerCheckInfo", providerCheckInfo);
					return AppJsonResult.error("您的服务商认证审核未通过，请修改后重新提交", somap);
				}
				if(providerCheckInfo.getPciState()==1){
					return AppJsonResult.error("您的服务商认证已提交，正在审核过程中，请耐心等待");
				}
				if(providerCheckInfo.getPciState()==2){
					return AppJsonResult.error("您的服务商认证已通过，认证资料不可更改，基本信息可以修改，可以进行添加服务");
				}
			}else{
				return AppJsonResult.error("您还未进行服务商认证，请先添加认证信息");
			}
		}else{
			return AppJsonResult.error("您还未通过实名认证，请先通过实名认证后申请服务商认证");
			
		}
		return AppJsonResult.error("获取认证信息失败");
	}


	/**
	 * 添加认证信息
	 * @param providerInfo
	 * @param providerCheckInfo
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/providerCheck/addCheckInfo",method = RequestMethod.POST)
	public Object  addCheckInfo(ProviderInfo providerInfo, ProviderCheckInfo providerCheckInfo)throws Exception{
		String logId=logId();
		providerInfo.setLogId(logId);
		providerCheckInfo.setLogId(logId);
		Boolean temp=false;
		if(HtmlFilter.filter(providerInfo)||HtmlFilter.filter(providerCheckInfo)){
			return AppJsonResult.formJsonResult(new JsonResult("不能输入HTML标签"));
		} 
		Map<String, Object> map=this.validatePro(providerInfo,providerCheckInfo);
		if(map.get("jres")!=null){
			JsonResult jr= (JsonResult) map.get("jres");
			return AppJsonResult.formJsonResult(jr);
		}else{
			try{
			providerInfo= (ProviderInfo) map.get("providerInfo");
			providerCheckInfo= (ProviderCheckInfo) map.get("providerCheckInfo");
			providerInfo.setPiId(UUIDUtil.getUUID());
			providerCheckInfo.setPciId(UUIDUtil.getUUID());
			providerCheckInfo.setPciState(1);
			JSONObject jo=new JSONObject();
			jo.put("count", 0);
			jo.put("total", 0);
			providerInfo.setPiRemark(jo.toJSONString());
			providerInfo.setPiMark(0f);
			providerInfo.setPiIsdelete(false);
			providerInfo.setPiDealnum(0);
			providerInfo.setPiMeetnum(0);
			providerInfo.setPiResponsetime(0);
			temp=providerCheckManageService.addCheck(providerInfo, providerCheckInfo);
			}catch(Exception e){
				return AppJsonResult.formJsonResult(new JsonResult(false,e.getMessage(),null));
			}
			if(temp){
				return AppJsonResult.formJsonResult(new JsonResult(true, "添加认证信息成功!",null));
			}else{
				return AppJsonResult.formJsonResult(new JsonResult(false,"添加认证信息失败",null));
			}

		}
	}


	/**
	 * 保存认证信息
	 * @param providerInfo
	 * @param providerCheckInfo
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/providerCheck/modifyCheckInfo",method = RequestMethod.POST)
	public Object modifyCheckInfo(ProviderInfo providerInfo,ProviderCheckInfo providerCheckInfo)throws Exception {
		String logId=logId();
		providerInfo.setLogId(logId);
		providerCheckInfo.setLogId(logId);
		if(HtmlFilter.filter(providerInfo)||HtmlFilter.filter(providerCheckInfo)){
			return AppJsonResult.formJsonResult(new JsonResult("不能输入HTML标签"));
		} 
		Map<String, Object> map = this.validatePro(providerInfo, providerCheckInfo);
		if(map.get("jres")!=null){
			JsonResult jr= (JsonResult) map.get("jres");
			return AppJsonResult.formJsonResult(jr);
		}else{
			providerInfo= (ProviderInfo) map.get("providerInfo");
			providerCheckInfo= (ProviderCheckInfo) map.get("providerCheckInfo");
			
				providerCheckInfo.setPciState(1);
				Boolean temp = providerCheckManageService.modifyCheck(providerInfo, providerCheckInfo);
				if(temp){
					return AppJsonResult.formJsonResult(new JsonResult(true, "修改认证信息成功!",null));
				}else{
					return AppJsonResult.formJsonResult(new JsonResult(false,"修改认证信息失败",null));
				}
		}
	}
}
