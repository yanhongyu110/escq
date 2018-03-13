package com.jero.esc.controller.appapi.checkinfo;

import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.HtmlFilter;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.service.checkinfo.IPersonCheckNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller("apiPersonCheckNameController")
@RequestMapping("/appapi/checkinfo")
public class PersonCheckNameController extends AppBaseController {

    @Autowired
    IPersonCheckNameService personCheckNameService;

    /**
     * 显示添加个人认证
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/perosonCheckName/viewAddPersonCheck",method = RequestMethod.POST)
    public Object viewAddPersonCheck() throws Exception {
        String logId=logId();
        PersonCheckname personCheckname = new PersonCheckname();
        personCheckname.setLogId(logId);
        PersonCheckname personCheckname1 = personCheckNameService.queryPersonCheckNameByUser(personCheckname);
        if(personCheckname1==null) {
            return  AppJsonResult.error("未进行实名认证");
        }else  if (personCheckname1.getPcnState()==1){
            return  AppJsonResult.error("正在审核。请等待！");
        }else  if (personCheckname1.getPcnState()==2){
            return AppJsonResult.success("审核已通过");
        }else {
        	return  AppJsonResult.error("审核未通过");
        }
    }
    
    /**
     * 显示个人认证
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/perosonCheckName/viewPersonCheck",method = RequestMethod.POST)
    public Object viewPersonCheck(){
        PersonCheckname personCheckname = new PersonCheckname();
        personCheckname.setLogId("");
        PersonCheckname personCheckname1 = personCheckNameService.queryPersonCheckNameByUser(personCheckname);
        return  AppJsonResult.success(personCheckname1);
    }

    /**
     * 添加个人认证
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/perosonCheckName/addPersonCheck",method = RequestMethod.POST)
    public Object addPersonCheck(PersonCheckname personCheckname){
        if (HtmlFilter.filter(personCheckname)){
            return  AppJsonResult.formJsonResult(new JsonResult("不能填写html"));
        }
            if(FastValid.isEmp(personCheckname.getPcnFrontid(), personCheckname.getPcnReverseid(), personCheckname.getPcnRelname())){
                return AppJsonResult.formJsonResult(new JsonResult(false,"内容为空",null));
            }
            if (!FastValid.matches(personCheckname.getPcnRelname(), FastValidateType.CHINESE_NAME)){
                return AppJsonResult.formJsonResult(new JsonResult(false,"姓名不是中文",null));
            }
            if (!FastValid.matches(personCheckname.getPcnIdnumber(),FastValidateType.PASSID)){
                return AppJsonResult.formJsonResult(new JsonResult(false,"身份证不对",null));
            }
            String logId=logId();
        try {
        	personCheckname.setLogId(logId);
            personCheckNameService.addPersonCheckName(personCheckname);
        } catch (ExceptionWithMessage e) {
            return  AppJsonResult.formJsonResult(e.jsonResult);
        }catch (Exception e){
            return AppJsonResult.formJsonResult(new JsonResult(false,"添加失败",null));
        }
        return AppJsonResult.formJsonResult(new JsonResult(true,"添加成功",null));
        
    }

    /**
     * 再次添加个人认证
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/perosonCheckName/reAddPersonCheck",method = RequestMethod.POST)
    public Object reAddPersonCheck(PersonCheckname personCheckname){
        if (HtmlFilter.filter(personCheckname)){
            return  AppJsonResult.formJsonResult(new JsonResult("不能填写html"));
        }
        if(FastValid.isEmp(personCheckname.getPcnFrontid(), personCheckname.getPcnReverseid(), personCheckname.getPcnRelname())){
            return AppJsonResult.formJsonResult(new JsonResult(false,"内容为空",null));
        }
        if (!FastValid.matches(personCheckname.getPcnRelname(), FastValidateType.CHINESE_NAME)){
            return AppJsonResult.formJsonResult(new JsonResult(false,"姓名不是中文",null));
        }
        if (!FastValid.matches(personCheckname.getPcnIdnumber(),FastValidateType.PASSID)){
            return AppJsonResult.formJsonResult(new JsonResult(false,"身份证不对",null));
        }
        String logId=logId();

        
        try {
        	personCheckname.setLogId(logId);
            personCheckNameService.modifyCheckName(personCheckname);
        } catch (ExceptionWithMessage e) {
            return  AppJsonResult.formJsonResult(e.jsonResult);
        }catch (Exception e){
            return AppJsonResult.formJsonResult(new JsonResult(false,"添加失败",null));
        }
        return AppJsonResult.formJsonResult(new JsonResult(true,"添加成功",null));

    }

    /**
     * 根据用户输入的身份证去查找是否存在
     * @param pcnIdnumber 验证的身份证信息
     */
    @ResponseBody
    @RequestMapping(value = "/perosonCheckName/queryPcnIdnumberIsEquals",method = RequestMethod.POST)
    public Object queryPcnIdnumberIsEquals(String pcnIdnumber){
    	
    	boolean isEquals = personCheckNameService.queryPcnIdnumberIsEquals(pcnIdnumber)>0;
    	if(isEquals){
    		return AppJsonResult.success("该身份证已认证");
    	}else{
    		return AppJsonResult.error("该身份证未认证");
    	}
    }

}
