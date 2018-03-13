package com.jero.esc.controller.appapi.userinfo;

import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.po.userinfo.ArrangementInfo;
import com.jero.esc.service.userinfo.IArrangementInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller("appArrangementController")
@RequestMapping(value = "/appapi/userinfo")
public class ArrangementController extends AppBaseController {

    @Autowired
    IArrangementInfoService arrangementInfoService;

    /**
     * 根据日期查询
     */
    @Cacheable(value = "homeChae",key = "'selectArrangeByDate:'+#arrange.arrSeverid+':'+#arrange.arrCurday")
    @CachePut(value = "homeChae",key = "'selectArrangeByDate:'+#arrange.arrSeverid+':'+#arrange.arrCurday")
    @ResponseBody
    @RequestMapping(value = "/arrangement/selectarrangebydate")
    public AppJsonResult selectArrangeByDate(ArrangementInfo arrange) {
        try {
            List<ArrangementInfo> arranges = arrangementInfoService.queryArrangeByDate(arrange);
            if (arranges.size() < 1) {
                return AppJsonResult.error("没有预约");
            } else {
                return AppJsonResult.success(arranges);
            }
        } catch (Exception e) {
            return AppJsonResult.error("查询出错!");
        }
    }


    /**
     * 根据ID查询档期
     */
    @RequestMapping(value = "/arrangement/selectarrangebyid")
    public AppJsonResult selectArrangeById(ArrangementInfo arrange) {
        try {
            ArrangementInfo info = arrangementInfoService.queryArrangeById(arrange);
            return AppJsonResult.success(info);
        } catch (Exception e) {
            return AppJsonResult.error("查询出错!");
        }
    }


    /**
     * 根据ID删除档期
     */
    @NoRepeatRequest
    @ResponseBody
    @RequestMapping(value = "/arrangement/removearrangebyid")
    public AppJsonResult removeArrangeById(ArrangementInfo arrange) {
        try {
            Integer res = arrangementInfoService.removeArrangeById(arrange);
            if (res > 0) {
                return AppJsonResult.success();
            } else {
                return AppJsonResult.error("删除失败!");
            }
        } catch (Exception e) {
            return AppJsonResult.error("删除出错!");
        }
    }

    /**
     * 添加档期
     */
    @RequestMapping(value = "/arrangement/addarrange", method = RequestMethod.POST)
    @NoRepeatRequest
    public AppJsonResult addArrange(ArrangementInfo arrange) {
        arrange.setArrId(UUIDUtil.getUUID());
        try {
            if (arrange.getArrSeverid() == null || arrange.getArrStarttime() == "" ||
                    arrange.getArrEndtime() == null || arrange.getArrEndtime() == "" ||
                    arrange.getArrContent() == null || arrange.getArrContent() == "") {
                return  AppJsonResult.error("含有空值，添加失败!");
            } else if (arrange.getArrContent().length() > 45) {
                return  AppJsonResult.error("备注信息超过45个字符!");
            } else if (arrange.getArrStarttime().compareTo(arrange.getArrEndtime()) > 0) {
                return  AppJsonResult.error("请选择正确的时间!");
            } else {
                Integer res = arrangementInfoService.addArrange(arrange);
                if (res > 0) {
                    return  AppJsonResult.success();
                } else {
                    return  AppJsonResult.error("添加失败!");
                }
            }
        } catch (Exception e) {
            return  AppJsonResult.error("添加失败!");
        }
    }

    /**
     * 修改档期
     */
    @NoRepeatRequest
    @ResponseBody
    @RequestMapping(value = "/arrangement/updatearrange",method = RequestMethod.POST)
    public AppJsonResult  updateArrange(ArrangementInfo arrange) {
        try {
            if (arrange.getArrStarttime() == null || arrange.getArrStarttime() == "" ||
                    arrange.getArrEndtime() == null || arrange.getArrEndtime() == "" ||
                    arrange.getArrContent() == null || arrange.getArrContent() == "") {
                return  AppJsonResult.error("含有空值，添加失败!");
            } else {
                Integer res = arrangementInfoService.modifyArrange(arrange);
                if (res > 0) {
                    return  AppJsonResult.success();
                } else {
                    return  AppJsonResult.error("修改失败!");
                }
            }
        } catch (Exception e) {
            return  AppJsonResult.error("修改出错!");
        }
    }


    /**
     * 获取session
     */
    @ResponseBody
    @RequestMapping(value = "/arrangement/getlogid",method = RequestMethod.GET)
    public AppJsonResult getLogId() {
        try {
            return AppJsonResult.success(log());
        } catch (Exception e) {
            return  AppJsonResult.error("获取session失败!");
        }
    }


}
