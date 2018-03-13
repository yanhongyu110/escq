package com.jero.esc.controller.wap.checkinfo;

import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.service.checkinfo.IPersonCheckNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/wap/checkinfo")
public class WapPersonCheckNameController extends BaseController {

    @Autowired
    IPersonCheckNameService personCheckNameService;

    /**
     * 显示添加个人认证
     * @return
     */
    @RequestMapping(value = "/perosonCheckName/viewAddPersonCheck")
    public ModelAndView viewAddPersonCheck(HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // TODO: 2016/12/8
        super.refresh(session);
        PersonCheckname personCheckname = new PersonCheckname();
        if(retrievalCurrentUserInfo(session)==null){
        	modelAndView.setViewName("wap/userinfo/login");
        	return modelAndView;
        }
        personCheckname.setLogId(retrievalCurrentUserInfo(session).getLogId());
        PersonCheckname personCheckname1 = personCheckNameService.queryPersonCheckNameByUser(personCheckname);
        if(personCheckname1==null) {
            modelAndView.addObject("content", null);
            modelAndView.setViewName("/wap/checkinfo/personcheck");
            return  modelAndView;
        }else  if (personCheckname1.getPcnState()==1){
            modelAndView.addObject("title", "审核结果");
            modelAndView.addObject("content", "正在审核。请等待！");
            modelAndView.addObject("url", "/wap/checkinfo/perosonCheckName/viewAddPersonCheck.html");
            modelAndView.setViewName("/wap/checkinfo/personcheck");
            return modelAndView;
        }else  if (personCheckname1.getPcnState()==2){
            modelAndView.addObject("title", "审核结果");
            modelAndView.addObject("content", "已通过！");
            modelAndView.addObject("url", "/wap/checkinfo/perosonCheckName/viewAddPersonCheck.html");
            modelAndView.setViewName("/wap/checkinfo/personcheck");
            return modelAndView;
        }else {
            modelAndView.addObject("content", "审核未通过");
            modelAndView.addObject("personCheckname1", personCheckname1);
            modelAndView.setViewName("/wap/checkinfo/personcheck");
            return  modelAndView;
        }
    }
    
    /**
     * 显示个人认证
     * @return
     */
    @RequestMapping(value = "/perosonCheckName/viewPersonCheck")
    public ModelAndView viewPersonCheck(){
        ModelAndView modelAndView = new ModelAndView();

        // TODO: 2016/12/8
        PersonCheckname personCheckname = new PersonCheckname();
        personCheckname.setLogId("");
        PersonCheckname personCheckname1 = personCheckNameService.queryPersonCheckNameByUser(personCheckname);

        modelAndView.addObject("obj1",personCheckname1);
        modelAndView.setViewName("/wap/checkinfo/perosonCheckName/viewAddPersonCheck.html");
        return  modelAndView;
    }

    /**
     * 添加个人认证
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/perosonCheckName/addPersonCheck", produces = "text/html;charset=UTF-8")
    public String addPersonCheck(HttpSession session,PersonCheckname personCheckname){


        if (HtmlFilter.filter(personCheckname)){
            return  new JsonResult("不能填写html").toJSON();
        }

        if (BaseController.isValidate){
           /* if(FastValid.isEmp(personCheckname.getPcnFrontid(), personCheckname.getPcnReverseid(), personCheckname.getPcnRelname())){
                return new JsonResult(false,"内容为空",null).toJSON();
            }*/
            if (!FastValid.matches(personCheckname.getPcnRelname(), FastValidateType.CHINESE_NAME)){
                return new JsonResult(false,"姓名不是中文",null).toJSON();
            }
            if (!FastValid.matches(personCheckname.getPcnIdnumber(),FastValidateType.PASSID)){
                return new JsonResult(false,"身份证不对",null).toJSON();
            }
        }

        try {
        	personCheckname.setLogId(this.retrievalCurrentUserInfo(session).getLogId());
            personCheckNameService.addPersonCheckName(personCheckname);
        } catch (ExceptionWithMessage e) {
            return  e.jsonResult.toJSON();
        }catch (Exception e){
            return new JsonResult(false,"添加失败",null).toJSON();
        }
        return new JsonResult(true,"添加成功","/wap/checkinfo/perosonCheckName/viewAddPersonCheck.html").toJSON();
        
    }

    /**
     * 再次添加个人认证
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/perosonCheckName/reAddPersonCheck", produces = "text/html;charset=UTF-8")
    public String reAddPersonCheck(HttpSession session,PersonCheckname personCheckname){
        if (HtmlFilter.filter(personCheckname)){
            return  new JsonResult("不能填写html").toJSON();
        }
        if (BaseController.isValidate){
            /*if(FastValid.isEmp(personCheckname.getPcnFrontid(), personCheckname.getPcnReverseid(), personCheckname.getPcnRelname())){
                return new JsonResult(false,"内容为空",null).toJSON();
            }*/
            if (!FastValid.matches(personCheckname.getPcnRelname(), FastValidateType.CHINESE_NAME)){
                return new JsonResult(false,"姓名不是中文",null).toJSON();
            }
            if (!FastValid.matches(personCheckname.getPcnIdnumber(),FastValidateType.PASSID)){
                return new JsonResult(false,"身份证不对",null).toJSON();
            }
        }

        
        try {
        	personCheckname.setLogId(this.retrievalCurrentUserInfo(session).getLogId());
            personCheckNameService.modifyCheckName(personCheckname);
        } catch (ExceptionWithMessage e) {
            return  e.jsonResult.toJSON();
        }catch (Exception e){
            return new JsonResult(false,"添加失败",null).toJSON();
        }

        // TODO: 2016/12/8
        return new JsonResult(true,"添加成功","/wap/checkinfo/perosonCheckName/viewAddPersonCheck.html").toJSON();

    }

    /**
     * 根据用户输入的身份证去查找是否存在
     * @param response
     * @param pcnIdnumber
     */
    @RequestMapping(value = "/perosonCheckName/queryPcnIdnumberIsEquals")
    public void queryPcnIdnumberIsEquals(HttpServletResponse response,String pcnIdnumber){
    	
    	Integer res = personCheckNameService.queryPcnIdnumberIsEquals(pcnIdnumber);
    	boolean isEquals = false;
    	if(res>0){
    		isEquals = true;
    	}
    	JsonUtil.printByJSON(response, isEquals);
    }

}
