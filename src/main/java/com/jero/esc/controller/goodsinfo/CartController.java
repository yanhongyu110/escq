package com.jero.esc.controller.goodsinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.goodsinfo.ICartService;
import com.jero.esc.vo.goodsinfo.CartVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;


@Controller
@RequestMapping("/goodsinfo")
public class CartController extends BaseController {

    @Autowired
    ICartService cartService;


    @ResponseBody
    @RequestMapping(value = "/test", produces = "text/html;charset=UTF-8")
    public String test(HttpSession session, Integer page, Integer pageSize, String con) throws Exception {
        CartVo cart = new CartVo();
        if (con != null || page != null || pageSize != null) {
            Map<String, String> map = JSONObject.parseObject(con, Map.class);
            cart.setBox(map);
            cart.setLogId("111");
        }
        FastPage<CartVo> psage = cartService.queryCartByLogId(cart, getPageRowBounds(page, pageSize));
        return JSON.toJSONString(psage);

    }


    /**
     * 添加购物车
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cart/addCart", produces = "text/html;charset=UTF-8")
    public String addCart(HttpSession session, HttpServletResponse response, String serviceId, String logId, @RequestParam("scartSource") String scartSource, String attrs, @RequestParam("num") Integer num, String scartComment) throws ExceptionWithMessage {


        if (isValidate) {
            if (FastValid.isEmp(serviceId, num) || num <= 0) {
                return new JsonResult("参数错误").toJSON();
            }
        }
        LogInfo logInfo = retrievalCurrentUserInfo(session);

        Boolean res = false;
        String mess = "";

        try {
            res = cartService.addCartByLogId(serviceId, logInfo.getLogId(), scartSource, num, scartComment);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            mess = e.getMessage();
            e.printStackTrace();
        }
        if (res) {
            return new JsonResult(true,"添加成功",null).toJSON();
        } else {
            if (mess != "" & mess != null) {
                return new JsonResult(false,mess,null).toJSON();
            } else {
                return new JsonResult(false,"添加失败",null).toJSON();
            }
        }

    }

    /**
     * 查看是否加入购物车
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cart/isExitCart", produces = "text/html;charset=UTF-8")
    public String isExitCart(HttpSession session, HttpServletResponse response, String serviceId, String logId, @RequestParam("scartSource") String scartSource) throws ExceptionWithMessage {


        if (isValidate) {
            if (FastValid.isEmp(serviceId)) {
                return new JsonResult("参数错误").toJSON();
            }
        }
        LogInfo logInfo = retrievalCurrentUserInfo(session);

        Boolean res = false;
        if (logInfo==null){
            return new JsonResult(false).toJSON();
        }
        res = cartService.isExitCart(serviceId, logInfo.getLogId(), scartSource);
        if (res) {
            return new JsonResult(true).toJSON();
        } else {
            return new JsonResult(false).toJSON();
        }

    }

    /**
     * @param serviceId
     * @param logId
     * @param jso
     * @param response
     * @author sys
     */

    // @ResponseBody
    //@RequestMapping(value = "/cart/insertcart",produces = "application/json;charset=UTF-8")
    @RequestMapping("/cart/insertcart")
    public void insertCart(String sId, String lId, Integer sNum, String sSource, String ajso, HttpServletResponse response) {
        JsonResult jr = new JsonResult();
        if (sId != null || lId != null || ajso != null) {
            try {
                Boolean res = cartService.addCartByLogId(sId, lId, sSource, sNum, ajso);
                if (res) {
                    jr.setSuccess(true);
                } else {
                    jr.setSuccess(false);
                    jr.setErrorMsg("添加失败！");
                }
            } catch (Exception e) {
                jr.setSuccess(false);
                e.printStackTrace();
            }
        } else {
            jr.setSuccess(false);
            jr.setErrorMsg("数据为空！");
        }
        JsonUtil.printByJSON(response, jr);
    }


    /**
     * @param cartId
     * @param logid
     * @param response
     * @author sys
     */
    @RequestMapping("/cart/deletecart")
    public void deleteCart(String scartId, String logId, HttpServletResponse response) {
        JsonResult jr = new JsonResult();
        String resMsg = "";
        if (logId != null || scartId != null) {
            try {
                Boolean res = cartService.removeCartById(scartId, logId);
                if (res) {
                    jr.setSuccess(true);
                    resMsg = "删除成功！";
                } else {
                    jr.setSuccess(false);
                    resMsg = "删除失败！";
                }
            } catch (Exception e) {
                jr.setSuccess(false);
                resMsg = "删除失败！";
                e.printStackTrace();
            }
        } else {
            jr.setSuccess(false);
            resMsg = "删除失败！";
        }
        JsonUtil.printByJSON(response, resMsg);
    }


    /**
     * 显示购物车
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cart/viewCart")
    public ModelAndView viewCart(ServiceCart record, HttpSession session, Integer page, Integer pageSize) throws Exception {
        if (FastValid.isEmp(page)) {
            page = 1;
            pageSize = 10;
        }
        /*CartVo cart=new CartVo();
    	cart.setLogId("111");
    	cart.setSsId("1112");
    	PageRowBounds pageRowBounds = getPageRowBounds(page,pageSize);
    	if(con!=null || page!=null ||pageSize!=null){
	    	Map<String,String> map= JSONObject.parseObject(con, Map.class);
        	cart.setBox(map);
        	pageSize = 6;
    	}
    	FastPage<CartVo> psage= cartService.queryCartByLogId(cart,pageRowBounds);*/
        record.setScartIsdelete(false);
        record.setLogId(retrievalCurrentUserInfo(session).getLogId());
        PageRowBounds pageRowBounds = getPageRowBounds(page, pageSize);
        FastPage<ServiceCart> psage = cartService.queryCartByCon(record, pageRowBounds);

        ModelAndView modelAndView = new ModelAndView();
        if (psage.list != null && psage.list.size() > 0) {
            modelAndView.setViewName("goodsinfo/cart");
            modelAndView.addObject("infos", psage);
        } else {
            modelAndView.addObject("title", "我的心愿");
            modelAndView.addObject("content", "还没有添加心愿单");
            modelAndView.setViewName("pubinfo/kanban");
            return modelAndView;
        }


        //modelAndView.addObject("info", record);
        return modelAndView;
    }


//    /**
//     * 查询购物车
//     *
//     * @param session
//     * @param json
//     * @param require
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/cart/queryCart", produces = "text/plain;charset=UTF-8")
//    public String queryCart(HttpSession session, @RequestParam("") String json, @RequestParam("require") String require) {
//
//        JSONObject.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
//        ServiceCart serviceCart = JSONObject.parseObject(json, ServiceCart.class);
//
//        serviceCart.setLogId(retrievalCurrentUserInfo(session).getLogId());
//
//        // TODO: 2016/12/19
//
//        return "";
//    }


//    /**
//     * 删除购物车
//     *
//     * @param session
//     * @param id
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/cart/removeCart", produces = "text/plain;charset=UTF-8")
//    public String removeCart(HttpSession session, @RequestParam("id") String id) {
//
//        if (isValidate) {
//            if (FastValid.isEmp(id)) {
//                return new JsonResult("参数错误").toJSON();
//            }
//        }
//
//        String logId = retrievalCurrentUserInfo(session).getLogId();
//
//        return "";
//
//    }


}
