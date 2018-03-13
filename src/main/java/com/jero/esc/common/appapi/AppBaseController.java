package com.jero.esc.common.appapi;

import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.shiro.realms.TokenDao;
import com.jero.esc.mapper.userinfo.LogInfoMapper;
import com.jero.esc.po.shiro.Apptoken;
import com.jero.esc.po.userinfo.LogInfo;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

//@Component
public class AppBaseController {

    @Autowired
    protected LogInfoMapper logInfoMapper;

    @Autowired
    protected  TokenDao tokenDao;

    //得到logid
    public  String logId(){
        Apptoken app= (Apptoken)SecurityUtils.getSubject().getPrincipal();
        return app.getApptokenLog();
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
    //读数据库
    //得到log
    public  LogInfo log(){
        LogInfo logInfo = logInfoMapper.selectByPrimaryKey(logId());
        return  logInfo;
    }

    public void setAttr(String key,Object value){
        Apptoken app= (Apptoken)SecurityUtils.getSubject().getPrincipal();
        Apptoken take = tokenDao.take(app.getApptokenId());
        Map<String, Object> map = take.getMap();
        map.put(key, value);
    }

    public  Object getAttr(String key){
        Apptoken app= (Apptoken)SecurityUtils.getSubject().getPrincipal();
        Apptoken take = tokenDao.take(app.getApptokenId());
        return  take.getMap().get(key);
    }


//    //读数据库
//    //得到商家id
//    public  String comId(){
//        return log().getCompany();
//    }










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


}
