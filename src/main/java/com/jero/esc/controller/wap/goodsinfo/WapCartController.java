package com.jero.esc.controller.wap.goodsinfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.mapper.details.MegDetailsMapper;
import com.jero.esc.mapper.goodsinfo.ServiceCartMapper;
import com.jero.esc.mapper.system.SystemMegsMapper;
import com.jero.esc.po.details.MegDetails;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.system.SystemMegs;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.goodsinfo.ICartService;
import com.jero.esc.service.impl.goodsinfo.ServiceService;

@Controller
@RequestMapping("/wap/goodsinfo")
public class WapCartController extends BaseController{
	@Autowired
	private SystemMegsMapper systemMegsMapper;
	@Autowired
	private MegDetailsMapper megDetailsMapper;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private ServiceCartMapper serviceCartMapper;
	@Autowired
	private ICartService cartService;

	@RequestMapping(value="/cart/showCartList")
	public ModelAndView showCartList(HttpSession session,Integer page){
   		if(page==null){
			page = 1;
   		}
   		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		ServiceCart sc = new ServiceCart();
		sc.setLogId(retrievalCurrentUserInfo(session).getLogId());
		List<ServiceCart> cartList = serviceCartMapper.seleteCartByCon(sc, rb);
		Integer count = serviceCartMapper.countByCon(sc);
		String jsonList = JSON.toJSONString(cartList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("jsonList", jsonList);
		modelAndView.addObject("count", count);
		modelAndView.addObject("f", 0);
		modelAndView.setViewName("wap/bizinfo/mycollect");
		return modelAndView;
	}

   	@RequestMapping(value="/cart/showCartListByAjax")
	public void showCartListByAjax(HttpSession session,HttpServletResponse response,Integer page,ServiceCart sc){
		Integer pageSize = 4;
		RowBounds rb = this.getRowBounds(page, pageSize);
		List<ServiceCart> cartList = serviceCartMapper.seleteCartByCon(sc, rb);
		Integer count = serviceCartMapper.countByCon(sc);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", cartList);
		map.put("count", count);
		map.put("pageNo", page);
		JsonUtil.printByJSON(response, map);
	}

   	@RequestMapping("/cart/deletecart")
    public void deleteCart(String id, String logId, HttpServletResponse response) {
        JsonResult jr = new JsonResult();
        String resMsg = "";
        if (logId != null || id != null) {
            try {
                Boolean res = cartService.removeCartById(id, logId);
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

   	@ResponseBody
    @RequestMapping(value = "/cart/addCart", produces = "text/html;charset=UTF-8")
    public String addCart(HttpSession session, HttpServletResponse response, String serviceId, String logId, @RequestParam("scartSource") String scartSource, String attrs, @RequestParam("num") Integer num, String scartComment){


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
        	ServiceInfo serviceInfo;
			try {
				serviceInfo = serviceService.queryByPrimaryKey(serviceId);
				SystemMegs sm = new SystemMegs();
				sm.setSmId(UUIDUtil.getUUID());
				sm.setSmCreatetime(new Date());
				sm.setSmIsdelete(false);
				sm.setSmType(1);
				sm.setSmTitle("平台消息");
				sm.setSmContent(logInfo.getLogName() + "收藏了你的服务\""+serviceInfo.getServiceTitle()+"\",快去看看吧!!");
				MegDetails md = new MegDetails();
				md.setMdId(UUIDUtil.getUUID());
				md.setMdCreatetime(new Date());
				md.setMdIsdelete(false);
				md.setLogId(serviceInfo.getLogId());
				md.setSmId(sm.getSmId());
				md.setOperatorId(logInfo.getLogId());
				md.setOperatorType(logInfo.getLogType());
				md.setMdType(3);
				systemMegsMapper.insert(sm);
				megDetailsMapper.insert(md);
			} catch (Exception e) {
				e.printStackTrace();
			}
            return new JsonResult(true,"添加成功",null).toJSON();
        } else {
            if (mess != "" & mess != null) {
                return new JsonResult(false,mess,null).toJSON();
            } else {
                return new JsonResult(false,"添加失败",null).toJSON();
            }
        }

    }
}
