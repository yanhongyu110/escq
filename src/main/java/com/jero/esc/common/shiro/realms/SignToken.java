package com.jero.esc.common.shiro.realms;

import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.po.shiro.Apptoken;
import com.jero.esc.po.userinfo.LogInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

public class SignToken extends UsernamePasswordToken {


    private LogInfo logInfo;

     private  Apptoken apptoken = new Apptoken();

    public Apptoken getApptoken() {
        return apptoken;
    }

    public void setApptoken(Apptoken apptoken) {
        this.apptoken = apptoken;
    }

    public SignToken(LogInfo logInfo){
        if (logInfo==null) return;
        this.logInfo=logInfo;
        apptoken.setApptokenToken(UUIDUtil.getUUID());
        apptoken.setApptokenLog(logInfo.getLogId());
        apptoken.setApptokenId(UUIDUtil.getUUID());
    }

    public LogInfo getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(LogInfo logInfo) {
        this.logInfo = logInfo;
    }

    @Override
    public Object getPrincipal() {
        return apptoken.getApptokenId();
    }

    @Override
    public Object getCredentials() {
        return apptoken.getApptokenToken();
    }
}
