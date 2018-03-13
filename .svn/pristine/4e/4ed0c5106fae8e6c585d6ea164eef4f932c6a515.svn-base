package com.jero.esc.common.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.reflect.generics.tree.Tree;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/***
 * 这是一个切面
 */
//@Aspect
//@Component
public class AppAspect {

    Logger log = Logger.getLogger(AppAspect.class);

    @Autowired
    HttpServletRequest httpServletRequest;


//    @Pointcut("execution(* com.jero.esc.controller..*.*(..))")
//    @Pointcut("@annotation( com.jero.esc.common.aop.AppPointcut)")
    public void pointCut() {
    }

    //执行前后
//    @Around("pointCut()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around增强：执行方法之前，模拟开始事物");
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "增加的前缀" + args[0];
        }
        Object rvt = joinPoint.proceed();
        System.out.println("Around增强：执行方法之后，模拟结束事物");
        if (rvt != null && rvt instanceof Integer) {
            rvt = (Integer) rvt * (Integer) rvt;
        }
        return rvt;
    }


    //前置通知（Before advice）：在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行。ApplicationContext中在<aop:aspect>里面使用<aop:before>元素进行声明。例如，TestAspect中的doBefore方法。
//    @Before("pointCut()")
    public void Before(JoinPoint joinPoint) {
        log.info("=====SysLogAspect前置通知开始=====");
    }

    //后置通知（After advice）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。ApplicationContext中在<aop:aspect>里面使用<aop:after>元素进行声明。例如，ServiceAspect中的returnAfter方法，所以Teser中调用UserService.delete抛出异常时，returnAfter方法仍然执行。
//    @After("pointCut()")
    public void After(JoinPoint joinPoint) {
        log.info("=====SysLogAspect后置通知开始=====");
    }

    //返回后通知（After return advice）：在某连接点正常完成后执行的通知，不包括抛出异常的情况。ApplicationContext中在<aop:aspect>里面使用<after-returning>元素进行声明。
    @AfterReturning(pointcut = "pointCut()", returning = "rev")
    public void AfterReturning(JoinPoint joinPoint, final Object rev) {

        final Map parameterMap = httpServletRequest.getParameterMap();
        final String url=httpServletRequest.getRequestURL().toString();
        final String me=httpServletRequest.getMethod();


        new Thread() {
            @Override
            public void run() {
                Object rr = rev;
                String s = JSON.toJSONString(rr,new SerializerFeature[]{SerializerFeature.PrettyFormat,SerializerFeature.DisableCheckSpecialChar});
                Object can = null;
                if (rr instanceof JsonResult) {
                    can = ((JsonResult) rr).getObj();
                    rr = AppJsonResult.formJsonResult((JsonResult) rr);
                    Object obj = ((JsonResult) rr).getObj();
                    if (obj!=null&&obj instanceof FastPage){
                        can=((FastPage) obj).getList().get(0);
                    }
                } else if (rr instanceof AppJsonResult) {
                    can = ((AppJsonResult) rr).getResult();
                    if (can!=null&&can instanceof FastPage){
                        can=((FastPage) can).getList().get(0);
                    }
                    if (can instanceof List){
                        can=((List)can).get(0);
                    }
                } else if (rr instanceof ModelAndView) {
                    return;
                } else if (rr instanceof String) {
                    String _re = (String) rr;
                    try {
                        JSONObject jsonObject = JSONObject.parseObject(_re);
                        if (jsonObject.containsKey("success") && jsonObject.containsKey("errorCode")) {
                            rr = AppJsonResult.formJsonResult(JSONObject.parseObject(_re, JsonResult.class));
                            can = jsonObject.getJSONObject("obj");
                        }
                        if (jsonObject.containsKey("count") && jsonObject.containsKey("list")) {
                            rr = jsonObject;
                            can = jsonObject.getJSONArray("list").get(0);
                        }
                    } catch (Exception e) {
                    }
                    if (can == null) {
                        try {
                            JSONArray objects = JSONArray.parseArray(_re);
                            rr = AppJsonResult.success(objects);
                            can = rr;
                        } catch (Exception e) {
                        }
                    }

                    if (can==null){
                        try {
                            AppJsonResult appJsonResult = JSONObject.parseObject(_re, AppJsonResult.class);
                            rr=appJsonResult;
                            can=appJsonResult.getResult();
                            if (can!=null&&can instanceof FastPage){
                                can=(FastPage)((FastPage) can).getList().get(0);
                            }
                            if (can !=null && can instanceof List){
                                can=((List)can).get(0);
                            }
                        }catch (Exception e){}
                    }

                    if (can == null) {
                        can = AppJsonResult.success(_re);
                    }
                }else if (rr == null){
                    rr=AppJsonResult.success();
                    can=rr;
                }else if ((rr instanceof Map&&((Map)rr).containsKey("list"))){
                    can=((List)((Map) rr).get("list")).get(0);
                }
                log.error(String.format(
                        "\r\n" +
                                "#################################################################################\n" +
                                "**简要描述：** \n" +
                                "\n" +
                                "- " + "登陆\n" +
                                "\r\n" +
                                "**请求URL：**" + "\r\n\n" +
                                "- `" + url+ "`\r\n\r\n" +
                                "**请求方式：**" + "\r\n\r\n" +
                                me + "\r\n\r\n" +
                                "**参数：** " + "\r\n\r\n" +
                                "%s"
                                + "\r\n\r\n" +
                                " **返回示例**" + "\r\n\r\n" +
                                "```" + "\r\n" +
                                "%s" + "\r\n" +
                                "```" + "\r\n\r\n" +
                                " **返回参数说明** " + "\r\n\r\n" +
                                "%s" + "\r\n\r\n" +
                                "#################################################################################"
                        , parameterMap.size() >= 1 ? tableFormatter(JSONObject.parseObject(JSON.toJSONString(parameterMap)),0) : "- 无"
                        , JSON.toJSONString(rr, SerializerFeature.PrettyFormat,SerializerFeature.DisableCheckSpecialChar)
                        , tableFormatter(JSONObject.parseObject(JSON.toJSONString(can,new SerializerFeature[]{SerializerFeature.PrettyFormat,SerializerFeature.DisableCheckSpecialChar})),1)
                ));

            }
        }.start();


        log.info("=====SysLogAspect后置通知开始=====");
    }

    //抛出异常后通知（After throwing advice）：在方法抛出异常退出时执行的通知。ApplicationContext中在<aop:aspect>里面使用<aop:after-throwing>元素进行声明。例如，ServiceAspect中的returnThrow方法。
//    @AfterThrowing(value="pointCut()",throwing="e")
    public void AfterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("=====SysLogAspect异常通知开始=====");
    }


    public static String tableFormatter(JSONObject map, int i) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("|参数名|必选|类型|说明|\n").append("|:----    |:---|:----- |-----   |");
        String row = i==0?"\n| %s | 是 | %s | %s |":"\n| %s | %s | %s |";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Integer) {
                stringBuffer.append(String.format(row, entry.getKey(), "int", entry.getKey()));
            } else {
                stringBuffer.append(String.format(row, entry.getKey(), "string", entry.getKey()));
            }
        }
        return stringBuffer.toString();
    }


}
