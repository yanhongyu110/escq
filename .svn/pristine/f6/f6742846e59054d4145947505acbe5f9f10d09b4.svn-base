package com.jero.esc.common.utils.wechat.utils;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

import java.util.HashMap;

public class WxServiceBuilder {

    private  static HashMap<String ,WxMpService> cache=new HashMap<String, WxMpService>();

    static  public WxMpService build(String comId){
        if (cache.containsKey(comId)){
            return cache.get(comId);
        }else {
            WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
            WxMpServiceImpl wxMpService = new WxMpServiceImpl();
            wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
            cache.put(comId,wxMpService);
            return wxMpService;
        }
    }

}
