package com.jero.esc.controller.wx;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.utils.wechat.utils.WxCommon;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by blazh on 2017/2/8.
 */
@Controller
@RequestMapping("/message")
public class Message extends BaseController{

    @Autowired
    WxCommon wxCommon;


    //消息路由
    WxMpMessageRouter wxMpMessageRouter;

    //初始化
    public void _init() {
//        wxMpMessageRouter = new WxMpMessageRouter(wxCommon.getService());

        wxMpMessageRouter
                .rule()
                .async(false)
                .event(WxConsts.EVT_SUBSCRIBE)
                .handler(new WxMpMessageHandler() {
                    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                        WxMpXmlOutMessage ss = WxMpXmlOutMessage.TEXT()
                                .content("欢迎来到上善云图\r\n点击公司动态获取更多")
                                .fromUser(wxMpXmlMessage.getToUser())
                                .toUser(wxMpXmlMessage.getFromUser())
                                .build();
                        return ss;
                    }
                })
                .end()

                .rule()
                .async(false)
                .event(WxConsts.EVT_CLICK)
                .eventKey("c1")
                .handler(new WxMpMessageHandler() {
                    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                        WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
                        item.setDescription("description");
                        item.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1486637701151&di=15e5eb277724bfe0d92a11735e906dc7&imgtype=0&src=http%3A%2F%2Fimg3.a0bi.com%2Fupload%2Fttq%2F20141213%2F1418458627448.jpg");
                        item.setTitle("皮卡丘");
                        item.setUrl("http://www.baidu.com");
                        return WxMpXmlOutTextMessage.NEWS().addArticle(item).fromUser(wxMpXmlMessage.getToUser()).toUser(wxMpXmlMessage.getFromUser()).build();
                    }
                })
                .end()

//                .rule()
//                .async(false)
//                .content("皮卡丘")
//                .handler(new WxMpMessageHandler() {
//                    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
//                        WxMpXmlOutNewsMessage.Item item = new WxMpXmlOutNewsMessage.Item();
//                        item.setDescription("description");
//                        item.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1486637701151&di=15e5eb277724bfe0d92a11735e906dc7&imgtype=0&src=http%3A%2F%2Fimg3.a0bi.com%2Fupload%2Fttq%2F20141213%2F1418458627448.jpg");
//                        item.setTitle("皮卡丘");
//                        item.setUrl("http://www.baidu.com");
//                        WxMpXmlOutNewsMessage ss = WxMpXmlOutMessage.NEWS()
//                                .addArticle(item)
//                                .addArticle(item)
//                                .addArticle(item)
//                                .addArticle(item)
//                                .addArticle(item)
//                                .addArticle(item)
//                                .fromUser(wxMpXmlMessage.getToUser())
//                                .toUser(wxMpXmlMessage.getFromUser())
//                                .build();
//                        return ss;
//                    }
//                })
//                .end()
//
//                .rule()
//                .async(false)
//                .msgType(WxConsts.XML_MSG_TEXT)
//                .content("你好")
//                .handler(new WxMpMessageHandler() {
//                    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
//                        WxMpXmlOutTextMessage ss = WxMpXmlOutMessage.TEXT()
//                                .content("http://www.baidu.com")
//                                .fromUser(wxMpXmlMessage.getToUser())
//                                .toUser(wxMpXmlMessage.getFromUser())
//                                .build();
//                        return ss;
//                    }
//                })
//                .end()
                .rule()
                .async(false)
                .handler(new WxMpMessageHandler() {
                    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                        return WxMpXmlOutTextMessage.TEXT().content("回复\"皮卡丘\"就给你看皮卡丘").fromUser(wxMpXmlMessage.getToUser()).toUser(wxMpXmlMessage.getFromUser()).build();
                    }
                })
                .end();
    }








    @ResponseBody
    @RequestMapping(value = "/messageAccepter", produces = "text/html;charset=UTF-8")
    public String check(HttpSession session, HttpServletRequest request, String signature, String timestamp, String nonce, String echostr, String encrypt_type) throws IOException {
        if (!wxCommon.getService(getModule(session)).checkSignature(timestamp, nonce, signature)) {
            return null;
        }

        if (StringUtils.isNotBlank(echostr)) {
            return echostr;
        }

        String encryptType = StringUtils.isBlank(encrypt_type) ?
                "raw" :
                encrypt_type;

        WxMpXmlMessage inMessage = null;
        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
        } else if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            String msgSignature = request.getParameter("msg_signature");
            inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), wxCommon.getService(getModule(session)).getWxMpConfigStorage(), timestamp, nonce, msgSignature);
        } else {
            return "不可识别的加密类型";
        }

//        WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
//        return outMessage.toXml();
        return  null;

    }



}
