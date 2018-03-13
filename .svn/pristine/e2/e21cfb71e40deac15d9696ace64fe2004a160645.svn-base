package com.jero.esc.controller.appapi.bizinfo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.mapper.bizinfo.FocusUtopMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.bizinfo.FocusUtop;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.bizinfo.IFocusUtopService;
import com.jero.esc.vo.bizinfo.FocusProvider;
import com.jero.esc.vo.bizinfo.FocusUser;

import java.util.HashMap;
import java.util.List;

@Controller("apiFocusUtopController")
@RequestMapping("/appapi/bizinfo")
public class FocusUtopController extends AppBaseController{

	@Autowired
	private IFocusUtopService focusUtopService;
    @Autowired
    private FocusUtopMapper focusUtopMapper;




//    @ResponseBody
//    @RequestMapping(value="/focus/showFocusListByAjax")
//    public Object showFocusListByAjax(HttpSession session, HttpServletResponse response, Integer page){
//        Integer pageSize = 4;
//        RowBounds rb = this.getRowBounds(page, pageSize);
//        List<FocusProvider> focusList = focusUtopMapper.selectByUser(logId(), rb);
//        FocusUtop fu = new FocusUtop();
//        fu.setFutpUser(logId());
//        Integer count = focusUtopMapper.countByCon(fu);
//        return AppJsonResult.success(new FastPage<FocusProvider>(focusList,count,page,pageSize));
//    }







    /**
	 * 查询我的关注
	 * @param page 分页页数
	 * @param pageSize 每页条数
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/focusutop/myFocus",method = RequestMethod.POST)
    public Object myFocus(Integer page,Integer pageSize) throws Exception{
    	if (FastValid.isEmp(page,pageSize)){
            page=1;
            pageSize=5;
        }
    	String logId=logId();
    	FocusUtop record=new FocusUtop();
    	record.setFutpUser(logId);
    	PageRowBounds pageRowBounds = getPageRowBounds(page,pageSize);
    	return AppJsonResult.success(focusUtopService.queryByUser(logId,pageRowBounds));
    }

	/**
	 * 查询关注我的用户
	 * @param page 分页页数
	 * @param pageSize 每页条数
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/focusutop/focuUsers",method = RequestMethod.POST)
    public Object focuUsers(Integer page,Integer pageSize) throws Exception{
        if(page==null){
            page = 1;
        }
        pageSize = 4;
        RowBounds rb = this.getRowBounds(page, pageSize);
        List<FocusUser> focusList = focusUtopMapper.selectByProvider(logId(), rb);
        FocusUtop fu = new FocusUtop();
        fu.setFutpProvider(logId());
        Integer count = focusUtopMapper.countByCon(fu);
    	
    	return AppJsonResult.success(new FastPage<FocusUser>(focusList,count,new PageRowBounds(page,pageSize)));
    }
	
	
	
	 /**
	  *添加关注
	 * @param providerLogId 添加关注的服务商
	 * @return
	 */
	@ResponseBody
	 @RequestMapping(value = "/focusutop/addFocus",method = RequestMethod.POST)
	 public Object addFocus(String providerLogId){
         if (FastValid.isEmp(providerLogId)){
             return  new JsonResult("参数错误").toJSON();
         }
	 	Boolean temp = false;
	 	String mes="";
	 try {
		 String logId=logId();
		 FocusUtop record=new FocusUtop();
		 record.setFutpUser(logId);
		 record.setFutpProvider(providerLogId);
			temp = focusUtopService.add(record);
		
		}
	 	catch (NullPointerException ne) {
			// TODO Auto-generated catch block
			ne.printStackTrace();
			mes="请先登陆后再进行关注";
		}
	 
	 	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes=e.getMessage();
		}
		 if(temp){
			 return  AppJsonResult.formJsonResult(new JsonResult(true,"关注成功",null));
		}else{
			if(mes!=""&mes!=null){
				return  AppJsonResult.formJsonResult(new JsonResult(false,mes,null));
			}else{
				return  AppJsonResult.formJsonResult(new JsonResult(false,"关注失败",null));
			}
		}
	 }
	 
	 /**
	  * 删除关注
	 * @param providerLogId 需要删除的服务商的id
	 * @return
	 */
	 @ResponseBody
	 @RequestMapping(value = "/focusutop/deleteFocus",method = RequestMethod.POST)
	 public Object deleteFocus(String providerLogId ){
	         if (FastValid.isEmp(providerLogId)){
	             return  new JsonResult("参数错误").toJSON();
	         }
		 String logId=logId();
		 FocusUtop record=new FocusUtop();
		 record.setFutpUser(logId);
		 record.setFutpProvider(providerLogId);
		 Boolean temp = false;
		 String mes="";
		try {
			temp = focusUtopService.delete(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mes=e.getMessage();
		}
		 if(temp){
			 return  AppJsonResult.formJsonResult(new JsonResult("删除成功"));
		}else{
			if(mes!=""&mes!=null){
				return  AppJsonResult.formJsonResult(new JsonResult(mes));
			}else{
				return  AppJsonResult.formJsonResult(new JsonResult("删除失败"));
			}
		}
	 }


    /**
     * 是否关注
     * @param providerLogId 需要是否被关注的服务商
     * @return
     */
	@ResponseBody
	 @RequestMapping(value = "/focusutop/judgeFocus",method = RequestMethod.POST)
	 public Object judgeFocus(String providerLogId){
	         if (FastValid.isEmp(providerLogId)){
	             return AppJsonResult.formJsonResult(new JsonResult(true,"参数缺失",false));
	         }
		 String logId=logId();
		 FocusUtop record=new FocusUtop();
		 record.setFutpUser(logId);
		 record.setFutpProvider(providerLogId);
		 Boolean temp = false;
		 temp = focusUtopService.queryByCon(record);
		 return temp?AppJsonResult.formJsonResult(new JsonResult(true,"已点赞",true)):AppJsonResult.formJsonResult(new JsonResult(true,"暂未点赞",false));
	 }	 
	 
	
	 
	 
	 
}
