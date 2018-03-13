package com.jero.esc.common.utils.wechat.utils;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.po.pay.PayApi;
import com.jero.esc.service.pay.IPayApiService;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class WxCommon {

    @Autowired
    IPayApiService payApiService;



    private  static ConcurrentMap<String,WxMpService> map=new ConcurrentHashMap<String,WxMpService>();


    public WxMpService  getService(String orderId){


        try {


            Map<String, String> apiMap = payApiService.getApiMap(orderId, 2);


//            if (map.containsKey(com)){
//                return  map.get(com);
//            }else {
                WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();



                wxMpInMemoryConfigStorage.setAppId(apiMap.get("appId")); // 设置微信公众号的appid
                wxMpInMemoryConfigStorage.setSecret(apiMap.get("appSecret")); // 设置微信公众号的app corpSecret
                wxMpInMemoryConfigStorage.setToken(apiMap.get("token")); // 设置微信公众号的token
                wxMpInMemoryConfigStorage.setAesKey(apiMap.get("aesKey")); // 设置微信公众号的EncodingAESKey
                wxMpInMemoryConfigStorage.setPartnerId(apiMap.get("partnerId"));
                wxMpInMemoryConfigStorage.setPartnerKey(apiMap.get("partnerKey"));
                wxMpInMemoryConfigStorage.setNotifyURL(Configure.getNotifyUrl());


//                PayApi payApi = new PayApi();
//                payApi.setCompId(com);
//                payApi.setPayType(2);
//                JSONObject jsonObject = payApiService.queryObjByCon(payApi).get("2");
//                wxMpInMemoryConfigStorage.setAppId(jsonObject.getString("app_id"));
//                wxMpInMemoryConfigStorage.setSecret(jsonObject.getString("secret"));
//                wxMpInMemoryConfigStorage.setNotifyURL(jsonObject.getString("notify_URL"));
//                wxMpInMemoryConfigStorage.setAccessToken(jsonObject.getString("token"));
//                wxMpInMemoryConfigStorage.setAesKey(jsonObject.getString("aes_key"));
//                wxMpInMemoryConfigStorage.setPartnerId(jsonObject.getString("partner_id"));
//                wxMpInMemoryConfigStorage.setPartnerKey(jsonObject.getString("partner_key"));



                WxMpServiceImpl wxMpService = new WxMpServiceImpl();
                wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
//                map.put(com,wxMpService);
                return wxMpService;

//            }
        } catch (Exception e) {
            return getService(orderId);
        }



    }


//    static public WxMpInMemoryConfigStorage config;
////    static public WxMpService wxMpService;
//    static {
//        WxCommon.config = new WxMpInMemoryConfigStorage();
//        WxCommon.config.setAppId(Configure.getAppID()); // 设置微信公众号的appid
//        WxCommon.config.setSecret(Configure.getAppSecret()); // 设置微信公众号的app corpSecret
//        WxCommon.config.setToken("MYTlu7m"); // 设置微信公众号的token
//        WxCommon.config.setAesKey("8dtKXp0syAjd0fQ8Nt1q1h5GvK0NrYdyRyev4F9BcKw"); // 设置微信公众号的EncodingAESKey
//        WxCommon.config.setPartnerId(Configure.getMchID());
//        WxCommon.config.setPartnerKey(Configure.getKey());
////        Common.wxMpService = new WxMpServiceImpl();
////        Common.wxMpService.setWxMpConfigStorage(Common.config);
//    }
//
//




}
