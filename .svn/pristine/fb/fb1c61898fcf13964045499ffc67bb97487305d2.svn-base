package com.jero.esc.common.shiro.realms;

import com.jero.esc.common.utils.MD5Util;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.AppException;
import com.jero.esc.mapper.shiro.ApptokenMapper;
import com.jero.esc.mapper.userinfo.LogInfoMapper;
import com.jero.esc.po.shiro.Apptoken;
import com.jero.esc.po.userinfo.LogInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SignRealm extends AuthorizingRealm {

    @Autowired
    ApptokenMapper apptokenMapper;

    @Autowired
    LogInfoMapper logInfoMapper;

    @Autowired
    TokenDao tokenDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        try {


            SignToken token = (SignToken) authenticationToken;

            if (token.getApptoken().getApptokenEndtime() != null) {
                return new SimpleAuthenticationInfo(token.getApptoken(), token.getApptoken().getApptokenToken(), getName());
            }


            List<LogInfo> logInfos = logInfoMapper.selectLogInfoLogCelll(token.getLogInfo().getLogName());
            if (logInfos == null || logInfos.size() <= 0) {
                AppException.build("用户不存在", null);
            }
            token.getApptoken().setApptokenLog(logInfos.get(0).getLogId());

            if (logInfos.get(0).getLogPass().equals(MD5Util.getMD5(token.getLogInfo().getLogPass()))) {
                tokenDao.create(token.getApptoken());
                return new SimpleAuthenticationInfo(token.getApptoken(), token.getApptoken().getApptokenToken(), getName());
            }else{
                AppException.build("密码错误", null);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            AppException.build("密码错误", null);
            return null;
        }
    }

}
