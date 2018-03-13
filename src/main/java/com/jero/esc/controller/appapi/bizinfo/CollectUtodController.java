package com.jero.esc.controller.appapi.bizinfo;

import javax.servlet.http.HttpSession;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.bizinfo.CollectUtod;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.bizinfo.ICollectUtodService;
import com.jero.esc.vo.bizinfo.CollectDemand;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;

@Controller("ApiCollectUtodController")
@RequestMapping("/appapi/bizinfo")
public class CollectUtodController extends AppBaseController {


    @Autowired
    private ICollectUtodService collectUtodService;


    /**
     * 查询我的收藏
     *
     * @param page     分页页数
     * @param pageSize 每页条数
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/collectUtod/myCollects",method = RequestMethod.POST)
    public Object myCollects(Integer page, Integer pageSize) throws Exception {
        if (FastValid.isEmp(page, pageSize)) {
            page = 1;
            pageSize = 5;
        }
        LogInfo info = log();
        CollectUtod record = new CollectUtod();
        record.setCutdUser(info.getLogId());
        PageRowBounds pageRowBounds = getPageRowBounds(page, pageSize);
        FastPage<CollectDemand> psage = collectUtodService.queryByUser(info.getLogId(), pageRowBounds);
        return AppJsonResult.success(psage);
    }


    /**
     * 添加收藏
     *
     * @param demId 添加收藏的id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collectUtod/addCollect",method=RequestMethod.POST)
    public Object addCollect(String demId) {
        if (FastValid.isEmp(demId)) {
        	return AppJsonResult.formJsonResult(new JsonResult(true,"参数缺失",false));
        }
        Boolean temp = false;
        String mes = "";
        try {
            LogInfo info = log();
            CollectUtod record = new CollectUtod();
            record.setCutdUser(info.getLogId());
            record.setCutdDemand(demId);
            temp = collectUtodService.add(record);
        } catch (NullPointerException ne) {
            // TODO Auto-generated catch block
            ne.printStackTrace();
            mes = "请先登陆后再进行收藏";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            mes = e.getMessage();
        }
        if (temp) {
            return AppJsonResult.formJsonResult(new JsonResult(true, "收藏成功", null));
        } else {
            if (mes != "" & mes != null) {
                return AppJsonResult.formJsonResult(new JsonResult(false, mes, null));
            } else {
                return AppJsonResult.formJsonResult(new JsonResult(false, "收藏失败", null));
            }
        }
    }

    /**
     * 删除收藏
     *
     * @param demId 需要删除的收藏id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collectUtod/deleteCollect",method=RequestMethod.POST)
    public Object deleteCollect(String demId) {
        if (FastValid.isEmp(demId)) {
        	return AppJsonResult.formJsonResult(new JsonResult(true,"参数缺失",false));
        }
        LogInfo info = log();
        CollectUtod record = new CollectUtod();
        record.setCutdUser(info.getLogId());
        record.setCutdDemand(demId);
        Boolean temp = false;
        String mes = "";
        try {
            temp = collectUtodService.delete(record);
        } catch (Exception e) {
            e.printStackTrace();
            mes = e.getMessage();
        }
        if (temp) {
            return AppJsonResult.formJsonResult(new JsonResult("删除成功"));
        } else {
            if (mes != "" & mes != null) {
                return AppJsonResult.formJsonResult(new JsonResult(mes));
            } else {
                return AppJsonResult.formJsonResult(new JsonResult("删除失败"));
            }
        }
    }


    /**
     * 验证是否收藏
     * @param demId 验证是否收藏的id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/collectUtod/judgeCollect",method=RequestMethod.POST)
    public AppJsonResult judgeFocus(String demId) {
        if (FastValid.isEmp(demId)) {
        	return AppJsonResult.formJsonResult(new JsonResult(true,"参数缺失",false));
        }
        LogInfo info = log();
        CollectUtod record = new CollectUtod();
        record.setCutdUser(info.getLogId());
        record.setCutdDemand(demId);
        Boolean temp = false;
        String mes = "";
        temp = collectUtodService.queryByCon(record);
        if (temp) {
        	return AppJsonResult.formJsonResult(new JsonResult(true,"已收藏",true));
        } else {
        	return AppJsonResult.formJsonResult(new JsonResult(true,"参数缺失",false));
        }
    }


}
