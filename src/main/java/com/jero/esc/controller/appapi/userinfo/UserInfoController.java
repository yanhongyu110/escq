package com.jero.esc.controller.appapi.userinfo;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.shiro.realms.TokenDao;
import com.jero.esc.common.utils.CheckCode;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.MD5Util;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.userinfo.IUserInfoService;
import com.jero.esc.vo.userinfo.SystemMesVo;
import com.jero.esc.vo.userinfo.UserInfoVo;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller("appUserInfoController")
@RequestMapping(value = "/appapi/userinfo")
public class UserInfoController extends AppBaseController {
    private Logger log = Logger.getLogger(getClass());

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private TokenDao tokeDao;


    /**
     * 修改用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/modifyUserinfo", method = RequestMethod.POST)
    public AppJsonResult modifyUserinfo(UserInfoVo user) {
        if (HtmlFilter.filter(user)) return AppJsonResult.error("输入内容不能为HTML代码！！！");
        if (user == null) return AppJsonResult.error("输入信息为空");
        user.setLogId(logId());
        if (userInfoService.modifyUserinfo(user) <= 0) return AppJsonResult.error("修改信息失败");
        return AppJsonResult.success();
    }

    /**
     * 重置用户登陆密码
     * @param checkCode 验证码
     * @param logPass 密码
     */
    @ResponseBody
    @RequestMapping(value = "/modifyPassByPrimaryKey")
    public AppJsonResult modifyPassByPrimaryKey(String checkCode, String logPass) {
        if (checkCode == null || checkCode.isEmpty()) return AppJsonResult.error("手机验证码不能为空");
        if (logPass == null || logPass.isEmpty()) return AppJsonResult.error("密码不能为空");
//        if (newPass.length() < 6 || newPass.length() > 20) return AppJsonResult.error("密码必须在6至20位之间");
        if (getAttr("checkCode") == null) return AppJsonResult.error("您未获取手机验证码");
        if (!checkCode.equals(getAttr("checkCode").toString())) return AppJsonResult.error("手机验证码错误");
        LogInfo logInfo = log();
        try {
            logInfo.setLogPass(MD5Util.getMD5(logPass));
        } catch (Exception e) {
            return AppJsonResult.error("修改密码加密错误！");
        }
        userInfoService.modifyPassByPrimaryKey(logInfo);
        return AppJsonResult.success();
    }


    /**
     * 获取短信验证码
     */
    @ResponseBody
    @RequestMapping(value = "/sendMesToUser",method = RequestMethod.POST)
    public AppJsonResult sendMesToUser(String logCell) {
        if (logCell == null || logCell.isEmpty()) return AppJsonResult.error("手机号不能为空");
        Pattern p = Pattern.compile("^((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8}$");
        Matcher m = p.matcher(logCell);
        if (false == m.matches()) return  AppJsonResult.error("手机号格式不正确");
        try {
            String param = "您正在进行近到家互联网专家平台密码修改";
            String appCheckCode = CheckCode.getAppCheckCode(tokeDao, logCell, param);
            return  AppJsonResult.success(appCheckCode);
        } catch (Exception e) {
            return  AppJsonResult.error("获取验证码异常,请联系网站客服");
        }
    }

    /**
     * 查看所有系统消息
     * @param smType 消息类型
     * @param page 分页页数
     * @param pageSize 分页大小
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllSystemMes",method = RequestMethod.POST)
    public AppJsonResult queryAllSystemMes(int smType, Integer page, Integer pageSize) {
        if (FastValid.isEmp(page, pageSize)) {
            page = 1;
            pageSize = 10;
        }
        RowBounds rw = this.getRowBounds(page, pageSize);
        String logId = logId();
        SystemMesVo mesVo = new SystemMesVo();
        mesVo.setSmType(smType);
        mesVo.setLogId(logId);
        Integer count = userInfoService.selectMesCountBylogId(mesVo);
        List<SystemMesVo> list = userInfoService.queryAllSystemMes(mesVo, rw);
        return  AppJsonResult.success(new FastPage(list,count,page,pageSize));
    }


    /**
     * 查询消息页面
     * @param smType 消息类型
     * @param page 分页页数
     * @param pageSize 分页大小
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllSystemMesByAjax",method = RequestMethod.POST)
    public AppJsonResult queryAllSystemMesByAjax(int smType, Integer page,Integer pageSize) {
        if (FastValid.isEmp(page,page)) {
            page = 1;
            pageSize=10;
        }
        RowBounds rw = this.getRowBounds(page, pageSize);
        String logId = logId();
        HashMap<String, Object> map = new HashMap<String, Object>();
        SystemMesVo mesVo = new SystemMesVo();
        mesVo.setSmType(smType);
        mesVo.setLogId(logId);
        Integer count = userInfoService.selectMesCountBylogId(mesVo);
        List<SystemMesVo> list = userInfoService.queryAllSystemMes(mesVo, rw);
        return  AppJsonResult.success(new FastPage(list,count,page,pageSize));
    }

    /**
     * 删除系统消息
     * @param smId 消息
     */
    @ResponseBody
    @RequestMapping(value = "/removeMesByPrimaryKey",method = RequestMethod.POST)
    public AppJsonResult removeMesByPrimaryKey(String smId) {
        if (userInfoService.removeMesByPrimaryKey(smId)> 0) return AppJsonResult.success("删除成功");
        else  return AppJsonResult.error("删除失败");
    }

}