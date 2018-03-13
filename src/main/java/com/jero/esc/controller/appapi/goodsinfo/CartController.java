package com.jero.esc.controller.appapi.goodsinfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
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
import org.springframework.web.bind.annotation.RequestMethod;
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


@Controller("apiCartController")
@RequestMapping("/appapi/goodsinfo")
public class CartController extends AppBaseController {

    @Autowired
    ICartService cartService;


    /**
     * 添加心愿单
     * @param serviceId 添加服务的id
     * @param scartSource
     * @param num 添加的数目
     * @param scartComment
     * @return
     * @throws ExceptionWithMessage
     */
    @ResponseBody
    @RequestMapping(value = "/cart/addCart",method=RequestMethod.POST)
    public AppJsonResult addCart(String serviceId) throws ExceptionWithMessage {
        if (FastValid.isEmp(serviceId)) {
            return AppJsonResult.formJsonResult(new JsonResult("参数错误"));
        }
        String scartSource="1";
        Integer num=1;
        String scartComment="";
        LogInfo logInfo = log();
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
            return AppJsonResult.formJsonResult(new JsonResult(true, "添加成功", null));
        } else {
            if (mess != "" & mess != null) {
                return AppJsonResult.formJsonResult(new JsonResult(false, mess, null));
            } else {
                return AppJsonResult.formJsonResult(new JsonResult(false, "添加失败", null));
            }
        }

    }



    /**
     * 查看是否加入购物车
     * @param serviceId 添加的服务id
     * @param scartSource
     * @return
     * @throws ExceptionWithMessage
     */
    @ResponseBody
    @RequestMapping(value = "/cart/isExitCart",method=RequestMethod.POST)
    public  AppJsonResult isExitCart(String serviceId) throws ExceptionWithMessage {
        if (FastValid.isEmp(serviceId)) {
        	 return AppJsonResult.formJsonResult(new JsonResult(true,"参数缺失",false));
        }
        String scartSource="1";
        LogInfo logInfo = log();
        Boolean res = false;
        if (logInfo==null){
            return AppJsonResult.formJsonResult( new JsonResult("未登录"));
        }
        res = cartService.isExitCart(serviceId, logInfo.getLogId(), scartSource);
        return res?AppJsonResult.formJsonResult(new JsonResult(true,"已点赞",true)):AppJsonResult.formJsonResult(new JsonResult(true,"暂未点赞",false));
    }















    /**
     * 添加心愿单
     * @param sId
     * @param lId
     * @param sNum
     * @param sSource
     * @Param ajso
     * @author sys
     */
    @ResponseBody
    @RequestMapping(value="/cart/insertcart",method = RequestMethod.POST)
    public Object insertCart(String sId, String lId, Integer sNum, String sSource, String ajso) {
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
        return AppJsonResult.formJsonResult(jr);
    }


    /**
     * @param scartId
     * @param logId
     * @author sys
     */
    @ResponseBody
    @RequestMapping(value="/cart/deletecart",method = RequestMethod.POST)
    public Object deleteCart(String scartId, String logId) {
        JsonResult jr = new JsonResult();
        String resMsg = "";
        if (logId != null || scartId != null) {
            try {
                Boolean res = cartService.removeCartById(scartId, logId);
                if (res) {
                    jr.setSuccess(true);
                    jr.setErrorMsg("删除成功！");
                } else {
                    jr.setSuccess(false);
                    jr.setErrorMsg("删除失败！");
                }
            } catch (Exception e) {
                jr.setSuccess(false);
                jr.setErrorMsg("删除失败！");
                e.printStackTrace();
            }
        } else {
            jr.setSuccess(false);
            jr.setErrorMsg("删除失败！");
        }
        return AppJsonResult.formJsonResult(jr);
    }


    /**
     * 显示购物车
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/cart/viewCart",method = RequestMethod.POST)
    public Object viewCart(ServiceCart record, Integer page, Integer pageSize) throws Exception {
        if (FastValid.isEmp(page)) {
            page = 1;
            pageSize = 10;
        }
        String logId = logId();
        record.setScartIsdelete(false);
        record.setLogId(logId);
        PageRowBounds pageRowBounds = getPageRowBounds(page, pageSize);
        FastPage<ServiceCart> psage = cartService.queryCartByCon(record, pageRowBounds);

        if (psage.list != null && psage.list.size() > 0) {
            return AppJsonResult.success(psage);
        } else {
            return AppJsonResult.error("暂无添加心愿");
        }
    }

}
