package com.jero.esc.controller.wap.checkinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
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




/**
 * @ClassName: ProviderCheckManageController 
 * @copyright 上善云图信息技术有限公司
 * @author 付逍遥
 * @version v1.0 
 * @date 2016年12月9日
 * @description
 */
@Controller
@RequestMapping("wap/checkinfo")
public class WapProviderCheckManageController extends BaseController{
	
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
			//,providerInfo.getPiComment(),providerCheckInfo.getPciIntroduce(),,providerInfo.getPiUrls(),,providerInfo.getPiVideo(),providerInfo.getPiComment(),providerInfo.getPiBrief(),
			//providerCheckInfo.getPciOthers(),providerCheckInfo.getPciEaducate(),providerCheckInfo.getPciCredentials(),providerCheckInfo.getPciImage()
			if(FastValid.isEmp(providerInfo.getPiAddr(),providerInfo.getPiArea(),providerInfo.getLogId(), providerInfo.getPiCell(),
					providerInfo.getPiCompany(),providerInfo.getPiEmail(),providerInfo.getPiPhoto(),providerInfo.getPiPosition(),providerInfo.getPiKeywords(),
					providerInfo.getPiRealname(),providerInfo.getPiWorkyear(),
					providerCheckInfo.getLogId())){
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
	//返回认证结果页面
	@RequestMapping("/providerCheck/checkInfoResult")
	public ModelAndView checkInfoResult(HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/pubinfo/kanban");
		String title="服务商认证结果";
		String content="您提交申请之后，系统将在3个工作日内做出反馈!";
		modelAndView.addObject("title",title);
		modelAndView.addObject("content",content);
		return modelAndView;
	}
	//
	@RequestMapping("/providerCheck/showAddCheckPage")
	public ModelAndView showAddCheckPage(HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/wap/checkinfo/providerCheckAdd");
		return modelAndView;
	}

	//查询获取认证资料
	@RequestMapping("/providerCheck/getCheck")
	public ModelAndView getCheck(HttpSession session) throws Exception{
		validaLog(session);
		ModelAndView modelAndView=new ModelAndView();
		LogInfo logInfo=super.retrievalCurrentUserInfo(session);
		ProviderCheckInfo providerCheckInfo=checkInfoService.queryByLogId(logInfo.getLogId());
		modelAndView.addObject("providerCheckInfo", providerCheckInfo);
		modelAndView.setViewName("/wap/checkinfo/providerCheckinfo");
		return modelAndView;
	}
	//查询获取基本信息
	@RequestMapping("/providerCheck/getBasic")
	public ModelAndView getBasic(HttpSession session) throws Exception{
		validaLog(session);
		ModelAndView modelAndView=new ModelAndView();
		LogInfo logInfo=super.retrievalCurrentUserInfo(session);
		ProviderInfo providerInfo=providerInfoService.queryByLogId(logInfo.getLogId());
		modelAndView.addObject("providerInfo", providerInfo);
		modelAndView.setViewName("/wap/checkinfo/providerinfo");
		return modelAndView;
	}
	//修改基本信息
	@ResponseBody
	@RequestMapping(value="/providerCheck/modifyBasic",produces="text/html;charset=UTF-8")
	public String modifyBasic(HttpSession session,HttpServletResponse response,ProviderInfo providerInfo,ProviderCheckInfo providerCheckInfo)throws Exception {

		LogInfo logInfo = super.retrievalCurrentUserInfo(session);
		providerInfo.setLogId(logInfo.getLogId());//log004
		providerCheckInfo.setLogId(logInfo.getLogId());
		if(HtmlFilter.filter(providerInfo)||HtmlFilter.filter(providerCheckInfo)){
			return new JsonResult("不能输入HTML标签").toJSON();
		} 
		
				Boolean temp = providerInfoService.modify(providerInfo);
				if(temp){
					return new JsonResult(true, "修改基本信息成功!", "/wap/checkinfo/providerCheck/getBasic.html").toJSON();
				}else{
					return new JsonResult(false,"修改基本信息失败",null).toJSON();
				}
	}
	//查询获取认证信息
	@RequestMapping("/providerCheck/getCheckInfo")
	public ModelAndView getCheckInfo(HttpSession session) throws Exception{
		validaLog(session);
		ModelAndView modelAndView=new ModelAndView();
		LogInfo logInfo=super.retrievalCurrentUserInfo(session);
		Boolean checkres=personCheckNameService.isChecked(logInfo.getLogId());
		if(checkres){
			//String logId="log004";// add i  update aaaa
			JsonResult jr1=providerCheckManageService.queryProviderInfoByLogId(logInfo.getLogId());
			JsonResult jr2=providerCheckManageService.queryProviderCheckInfoByLogId(logInfo.getLogId());
			if(jr1.isSuccess()&jr2.isSuccess()){
				ProviderInfo providerInfo=(ProviderInfo) jr1.getObj();
				ProviderCheckInfo providerCheckInfo=(ProviderCheckInfo) jr2.getObj();
				if(providerCheckInfo.getPciState()==3){
					modelAndView.setViewName("/wap/checkinfo/providerCheckUpdate");
					
					modelAndView.addObject("providerInfo",providerInfo);
					modelAndView.addObject("providerCheckInfo", providerCheckInfo);
					String res="认证审核未通过，请修改后重新提交";
					modelAndView.addObject("res",res);
				}
				if(providerCheckInfo.getPciState()==1){
					modelAndView.setViewName("/wap/pubinfo/kanban");
					String title="服务商认证结果";
					String url="/wap/checkinfo/providerCheck/getCheckInfo.html";
					String content="认证已提交，正在审核中！";
					String contentTwo = "请耐心等待，我们将在12小时内审核...";
					modelAndView.addObject("title",title);
					modelAndView.addObject("content",content);
					modelAndView.addObject("contentTwo",contentTwo);
					modelAndView.addObject("url",url);
					
				}
				if(providerCheckInfo.getPciState()==2){
					//刷新session
					refresh(session);
					
					modelAndView.setViewName("/wap/checkinfo/providerinfo");
					modelAndView.addObject("providerInfo",providerInfo);
					String res="认证已通过，可以进行添加服务";
					modelAndView.addObject("res",res);
				}
				
				
			}else{
			//获取use表中真实姓名
			//取消实名认证，若需加上实名认证  需解开注释 以获取用户信息
			//实现方式：注册时直接添加实名信息 身份证号 真实姓名在服务商认证时添加
			/*UserInfoVo userInfoVo=userInfoService.showUserinfoByCon(logInfo.getLogId());
			modelAndView.addObject("userInfoVo",userInfoVo);*/
			modelAndView.setViewName("/wap/checkinfo/providerCheckAdd");
			}
		}else{
			modelAndView.setViewName("/wap/pubinfo/kanban");
			String content="请先进行实名认证";
			String url="/wap/checkinfo/perosonCheckName/viewAddPersonCheck.html";
			String title="实名认证";
			modelAndView.addObject("title",title);
			modelAndView.addObject("url",url);
			modelAndView.addObject("content",content);
			
		}
		return modelAndView;
		
		
	}
	//添加认证信息
	@ResponseBody
	@RequestMapping(value="/providerCheck/addCheckInfo",produces="text/html;charset=UTF-8")
	public String  addCheckInfo(HttpSession session, ProviderInfo providerInfo, ProviderCheckInfo providerCheckInfo, HttpServletResponse response)throws Exception{
		LogInfo logInfo=super.retrievalCurrentUserInfo(session);
		providerInfo.setLogId(logInfo.getLogId());//log004
		providerCheckInfo.setLogId(logInfo.getLogId());
		Boolean temp=false;
		if(HtmlFilter.filter(providerInfo)||HtmlFilter.filter(providerCheckInfo)){
			return new JsonResult("不能输入HTML标签").toJSON();
		} 
		Map<String, Object> map=this.validatePro(providerInfo,providerCheckInfo);
		if(map.get("jres")!=null){
			JsonResult jr= (JsonResult) map.get("jres");
			return jr.toJSON();
		}else{
			try{
			providerInfo= (ProviderInfo) map.get("providerInfo");
			providerCheckInfo= (ProviderCheckInfo) map.get("providerCheckInfo");
			providerInfo.setPiId(UUIDUtil.getUUID());
			providerCheckInfo.setPciId(UUIDUtil.getUUID());
			providerCheckInfo.setPciState(1);
			if(providerInfo.getPiUrls()==null){
				providerInfo.setPiUrls("[]");
			}
			JSONObject jo=new JSONObject();
			jo.put("count", 1);
			jo.put("total", 10.0);
			providerInfo.setPiRemark(jo.toJSONString());
			providerInfo.setPiMark(10.0f);
			providerInfo.setPiIsdelete(false);
			providerInfo.setPiDealnum(0);
			providerInfo.setPiMeetnum(0);
			providerInfo.setPiResponsetime(0);
			temp=providerCheckManageService.addCheck(providerInfo, providerCheckInfo);
			}catch(Exception e){
				return new JsonResult(false,e.getMessage(),null).toJSON();
			}
			if(temp){
				return new JsonResult(true, "添加认证信息成功!", "/wap/checkinfo/providerCheck/getCheckInfo.html").toJSON();
			}else{
				return new JsonResult(false,"添加认证信息失败",null).toJSON();
			}

		}
	}
	//保存认证信息
	@ResponseBody
	@RequestMapping(value="/providerCheck/modifyCheckInfo",produces="text/html;charset=UTF-8")
	public String modifyCheckInfo(HttpSession session,HttpServletResponse response,ProviderInfo providerInfo,ProviderCheckInfo providerCheckInfo)throws Exception {

		LogInfo logInfo = super.retrievalCurrentUserInfo(session);
		providerInfo.setLogId(logInfo.getLogId());//log004
		providerCheckInfo.setLogId(logInfo.getLogId());
		if(HtmlFilter.filter(providerInfo)||HtmlFilter.filter(providerCheckInfo)){
			return new JsonResult("不能输入HTML标签").toJSON();
		} 
		Map<String, Object> map = this.validatePro(providerInfo, providerCheckInfo);
		if(map.get("jres")!=null){
			JsonResult jr= (JsonResult) map.get("jres");
			return jr.toJSON();
		}else{
			providerInfo= (ProviderInfo) map.get("providerInfo");
			providerCheckInfo= (ProviderCheckInfo) map.get("providerCheckInfo");
			
			/*if(logInfo.getLogType()==1){*/
				providerCheckInfo.setPciState(1);
				Boolean temp = providerCheckManageService.modifyCheck(providerInfo, providerCheckInfo);
				if(temp){
					return new JsonResult(true, "修改认证信息成功!", "/wap/checkinfo/providerCheck/getCheckInfo.html").toJSON();
				}else{
					return new JsonResult(false,"修改认证信息失败",null).toJSON();
				}
				/*}else{
				Boolean temp = providerCheckManageService.modifyCheck(providerInfo, providerCheckInfo);
				if(temp){
					return "{url:'/checkinfo/providerCheck/getCheckInfo.html'}";
				}else{
					return "保存认证信息失败！";
				}
			}*/
		}
	}
}
