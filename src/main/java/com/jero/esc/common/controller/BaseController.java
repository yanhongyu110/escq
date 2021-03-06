package com.jero.esc.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.mapper.bizinfo.CompanyInfoMapper;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.userinfo.ILogInfoService;

@Component
public class BaseController {
	
	@Autowired
	private ILogInfoService logInfoService;

	@Autowired
	CompanyInfoMapper companyInfoMapper;
	
	public static boolean isValidate=true;


	public  String getPosition(HttpSession session){
		return  (String) session.getAttribute("position");
	}

	public  void setPosition(HttpSession session,String position){
		String[] split = position.split("-");
		session.setAttribute("province",split[0]);
		session.setAttribute("city",split[1]);
		if (split.length>2) session.setAttribute("area",split[2]);
		session.setAttribute("position",position);
	}


	public  void setModule(HttpSession session,String module){
		session.setAttribute("module",module);
	}

	public String  getModule(HttpSession session){
		return (String) session.getAttribute("module");
	}

	public  void clearModule(HttpSession session){
		session.setAttribute("module",null);
	}

//	public  void clearCompany(HttpSession session){
//		session.setAttribute("company",null);
//	}


//	public  void setCompanyId(HttpSession session,String comid){
//		CompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(comid);
//		session.setAttribute("company",companyInfo);
//	}

//	public  String getModule(session){
//		return getCompany(session).getCompId();
////		return "111";
//	}

//	public  CompanyInfo getCompany(HttpSession session){
//		return  (CompanyInfo)session.getAttribute("company");
////		return  companyInfoMapper.selectByPrimaryKey("111");
//	}
	
	public void refresh(HttpSession session){
		LogInfo logInfo = this.retrievalCurrentUserInfo(session);
		LogInfo newloginfo=logInfoService.refreshSession(logInfo);
		session.setAttribute("logInfo", newloginfo);
	}


	public void   validaLog(HttpSession session)throws   Exception{
		retrievalCurrentUserInfo(session).getLogId();
	}
	
	
	
	
	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 获取登录用户信息
	 * @param session
	 * @return User
	 * @method retrievalCurrentUserInfo
	 */
	public LogInfo retrievalCurrentUserInfo(HttpSession session) {
		if(session.getAttribute("logInfo") != null){
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			LogInfo logInfo = (LogInfo) session.getAttribute("logInfo");
			System.out.println("logId : "+logInfo.getLogId());
			System.out.println("logCell : "+logInfo.getLogCell());
			System.out.println("logname : "+logInfo.getLogName());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			return (LogInfo) session.getAttribute("logInfo");
		} 
		return null;
		/*SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		if (securityContext != null) {
			Authentication auth = securityContext.getAuthentication();
			if (auth != null) {
				Object principal = auth.getPrincipal();
				if (principal != null && principal instanceof MyUserDetail) {
					MyUserDetail myUserDetail = (MyUserDetail) principal;
					return myUserDetail.getUser();
				}
			}
		}
		return null;*/
	}


	/**
	 * 是否是服务商
	 * @param session
	 * @return
     */
	public boolean isProvider(HttpSession session){
		LogInfo logInfo = this.retrievalCurrentUserInfo(session);
		return logInfo!=null&&logInfo.getLogType()==2;
	}

	/**
	 * 是否是服务商
	 * @param session
	 * @return
	 */
	public boolean isLogin(HttpSession session){
		return session.getAttribute("logInfo")!=null;
	}

	public String getRequestIP(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

	public RowBounds getRowBounds(Integer page, Integer rows) {
		if (page == null || rows == null) {
			return new RowBounds(0, 15);
		}
		if (page < 1)
			page = 1;
		if (rows < 1)
			rows = 15;
		return new RowBounds((page - 1) * rows,rows);
	}
	
	public PageRowBounds getPageRowBounds(Integer page, Integer rows) {
		if (page == null || rows == null) {
			return new PageRowBounds(0,15);
		}
		if (page < 1)
			page = 1;
		if (rows < 1)
			rows = 15;
		return new PageRowBounds((page - 1) * rows,rows);
	}

	public void printDataGridJsonData(HttpServletResponse response, int total, List<?> list) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", list);
		JsonUtil.printByJSON(response, resultMap);
	}
}
