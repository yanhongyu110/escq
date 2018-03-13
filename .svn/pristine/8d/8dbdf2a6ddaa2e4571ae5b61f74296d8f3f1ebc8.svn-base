package com.jero.esc.controller.wx;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.wechat.utils.WxCommon;
import com.jero.esc.mapper.map.WxAdminMapper;
import com.jero.esc.mapper.userinfo.LogInfoMapper;
import com.jero.esc.mapper.userinfo.UserInfoMapper;
import com.jero.esc.po.map.WxAdmin;
import com.jero.esc.po.map.WxAdminExample;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.userinfo.ILogInfoService;

@Controller
@RequestMapping("/oauth2")
public class OAuth2 extends BaseController{

    @Autowired
    private WxAdminMapper wxAdminMapper;

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Autowired
    private ILogInfoService logInfoService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private  WxCommon wxCommon;


    /**
     * 首先构造网页授权url，然后构成超链接让用户点击
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/url",produces = "text/html;charset=UTF-8")
    public  String url(HttpSession session){
        String s = wxCommon.getService(getModule(session)).oauth2buildAuthorizationUrl("http://bblazh.tunnel.qydev.com/esc/oauth2/oauth2Return.html", WxConsts.OAUTH2_SCOPE_USER_INFO, "asas");
        return  s;
    }

    /**
     * pc网页的微信授权登录
     * @param httpSession
     * @param code
     * @param state
     * @return
     * @throws ExceptionWithMessage
     */
    public  String pcOauth2Return(HttpSession session, String code, String state) throws ExceptionWithMessage {
        WxMpService service = wxCommon.getService(getModule(session));
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        WxMpUser wxMpUser = null;
        try {
            wxMpOAuth2AccessToken = service.oauth2getAccessToken(code);
            wxMpUser = service.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WxAdminExample wxAdminExample = new WxAdminExample();
        wxAdminExample.or().andWxAdminOpenidEqualTo(wxMpUser.getOpenId());
        List<WxAdmin> i = wxAdminMapper.selectByExample(wxAdminExample);
        if (i==null||i.size()<=0){
            //第一次登录
            WxAdmin wxAdmin = new WxAdmin();
            wxAdmin.setWxAdminId(UUIDUtil.getUUID());
            wxAdmin.setWxAdminCreatetim(new Date());
            wxAdmin.setWxAdminUpdatetime(new Date());
            wxAdmin.setWxAdminOpenid(wxMpUser.getOpenId());
            wxAdmin.setWxAdminToken(JSON.toJSONString(wxMpOAuth2AccessToken));
            wxAdmin.setWxAdminRToken(wxMpOAuth2AccessToken.getRefreshToken());
            wxAdmin.setWxAdminTimeout(wxMpOAuth2AccessToken.getExpiresIn());
            LogInfo logInfo = new LogInfo();
            logInfo.setLogId(UUIDUtil.getUUID());
//            logInfo.setLogCell(httpSession.getAttribute("logCell").toString());
            logInfo.setLogCreatetime(new Date());
            logInfo.setLogIsdelete(false);
            logInfo.setLogState(1);
            logInfo.setLogType(1);
            logInfo.setCompany(state);//这里设置公司id
            logInfo.setLogName(wxMpUser.getNickname());
            logInfo.setUserPhoto(wxMpUser.getHeadImgUrl());
//            logInfo.setLogRegip(getRequestIP(request));
            logInfo.setLogIslog(true);
//            logInfo.setLogPass(MD5Util.getMD5(logInfo.getLogPass()));
            try {
                logInfoService.addLogInfo(logInfo,null);
                wxAdmin.setWxAdminLog(logInfo.getLogId());
                wxAdminMapper.insert(wxAdmin);
            } catch (ExceptionWithMessage exceptionWithMessage) {
                exceptionWithMessage.printStackTrace();
            }
            session.setAttribute("logInfo",logInfo);
//            httpSession.setAttribute("wxUser",wxMpUser);
        }else {
            WxAdmin wxAdmin = i.get(0);
            LogInfo logInfo = logInfoMapper.selectByPrimaryKey(wxAdmin.getWxAdminLog());
//            logInfo.setLogName(wxMpUser.getNickname());
//            logInfoMapper.updateByPrimaryKeySelective(logInfo);
//            UserInfo userInfo = new UserInfo();
//            UserInfoVo userInfoVo = userInfoMapper.selectUserinfoByLogId(logInfo.getLogId());
//            userInfo.setUserPhoto(wxMpUser.getHeadImgUrl());
//            userInfo.setUserId(userInfoVo.getUserId());
//            userInfoMapper.updateByPrimaryKeySelective(userInfo);
            session.setAttribute("logInfo",logInfo);
//            httpSession.setAttribute("wxUser",wxMpUser);
        }
        return  null;
    }




    /**
     * 根据返回code获取用户信息及
     * @param httpSession
     * @param code
     * @param state
     * @return
     * @throws WxErrorException
     */
    @RequestMapping("/oauth2Return")
    public ModelAndView oauth2Return(HttpSession session, String code, String state)  {

        WxMpService service = wxCommon.getService(getModule(session));

        System.out.println(state);
        ModelAndView modelAndView = new ModelAndView();
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        WxMpUser wxMpUser = null;
        try {
            wxMpOAuth2AccessToken = service.oauth2getAccessToken(code);
            wxMpUser = service.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //添加相关

        //判断是否有过天添加
        WxAdminExample wxAdminExample = new WxAdminExample();
        wxAdminExample.or().andWxAdminOpenidEqualTo(wxMpUser.getOpenId());
        List<WxAdmin> i = wxAdminMapper.selectByExample(wxAdminExample);
        if (i==null||i.size()<=0){
            session.setAttribute("token_",wxMpOAuth2AccessToken);
            session.setAttribute("user_",wxMpUser);
            session.setAttribute("jihema",state);
            modelAndView.setViewName("wap/userinfo/register");
            return  modelAndView;
//            //第一次登录
//            WxAdmin wxAdmin = new WxAdmin();
//            wxAdmin.setWxAdminId(UUIDUtil.getUUID());
//            wxAdmin.setWxAdminCreatetim(new Date());
//            wxAdmin.setWxAdminUpdatetime(new Date());
//            wxAdmin.setWxAdminOpenid(wxMpUser.getOpenId());
//            wxAdmin.setWxAdminToken(JSON.toJSONString(wxMpOAuth2AccessToken));
//            wxAdmin.setWxAdminRToken(wxMpOAuth2AccessToken.getRefreshToken());
//            wxAdmin.setWxAdminTimeout(wxMpOAuth2AccessToken.getExpiresIn());
//            LogInfo logInfo = new LogInfo();
//            logInfo.setLogId(UUIDUtil.getUUID());
////            logInfo.setLogCell(httpSession.getAttribute("logCell").toString());
//            logInfo.setLogCreatetime(new Date());
//            logInfo.setLogIsdelete(false);
//            logInfo.setLogState(1);
//            logInfo.setLogType(1);
//            logInfo.setLogName(wxMpUser.getNickname());
//            logInfo.setUserPhoto(wxMpUser.getHeadImgUrl());
////            logInfo.setLogRegip(getRequestIP(request));
//            logInfo.setLogIslog(true);
////            logInfo.setLogPass(MD5Util.getMD5(logInfo.getLogPass()));
//            try {
//                logInfoService.addLogInfo(logInfo);
//                wxAdmin.setWxAdminLog(logInfo.getLogId());
//                wxAdminMapper.insert(wxAdmin);
//            } catch (ExceptionWithMessage exceptionWithMessage) {
//                exceptionWithMessage.printStackTrace();
//            }
//            httpSession.setAttribute("logInfo",logInfo);
//            httpSession.setAttribute("wxUser",wxMpUser);


        }else {
            //不是第一次登录
            WxAdmin wxAdmin = i.get(0);
            LogInfo logInfo = logInfoMapper.selectByPrimaryKey(wxAdmin.getWxAdminLog());
//            logInfo.setLogName(wxMpUser.getNickname());
//            logInfoMapper.updateByPrimaryKeySelective(logInfo);
//            UserInfo userInfo = new UserInfo();
//            UserInfoVo userInfoVo = userInfoMapper.selectUserinfoByLogId(logInfo.getLogId());
//            userInfo.setUserPhoto(wxMpUser.getHeadImgUrl());
//            userInfo.setUserId(userInfoVo.getUserId());
//            userInfoMapper.updateByPrimaryKeySelective(userInfo);
            session.setAttribute("logInfo",logInfo);
            session.setAttribute("wxUser",wxMpUser);
        }
        modelAndView.setViewName("redirect:/wap/goodsinfo/ServiceInfo/homeShow.html");
        return  modelAndView;
    }


}
