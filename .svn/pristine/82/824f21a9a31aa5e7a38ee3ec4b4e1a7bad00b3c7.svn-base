package com.jero.esc.controller.wx;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.utils.wechat.utils.WxCommon;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by blazh on 2017/2/9.
 */
@Controller
@RequestMapping("/js")
public class Js  extends BaseController{

    @Autowired
    private  WxCommon wxCommon;

    /**
     * 得到
     * @param url
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/JsApi",produces = "text/html;charset=UTF-8")
    public String JsApi(String url, HttpSession session){
        try {
            return JSON.toJSONString(wxCommon.getService(getModule(session)).createJsapiSignature(url));
        } catch (WxErrorException e) {
            e.printStackTrace();
            return null;
        }
    }

}
