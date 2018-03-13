package com.jero.esc.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jero.esc.common.aop.AppAspect;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.po.FastPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

	private static Logger log = LoggerFactory.getLogger(JsonUtil.class);

	public static void printByJSON(HttpServletResponse response, final Object obj) {
		String jsonStr = "";
		if (obj != null && !"".equals(obj)) {
			jsonStr = JSON.toJSONString(obj,true);

			new Thread(){
                @Override
                public void run() {
                    if (obj instanceof String){
                        log.error(obj.toString());
                    }else if (obj instanceof FastPage){
                        log.error(
                                AppAspect.tableFormatter(
                                        JSON.parseObject(JSON.toJSONString(
                                                ((FastPage) obj).getList().get(0)
                                        )),1
                                )
                        );
                        log.error(JSON.toJSONString(obj,true));
                    }else if ((obj instanceof Map&&((Map)obj).containsKey("list"))){
                        log.error(AppAspect.tableFormatter(
                                JSON.parseObject(JSON.toJSONString(
                                ((List)((Map) obj).get("list")).get(0)
                        )),1));

//                        FastPage fastPage = new FastPage((List) ((Map) obj).get("list"), (Integer) ((Map) obj).get("count"), 1, 10);
//                        log.error(JSON.toJSONString(AppJsonResult.success(fastPage),true));
                        log.error(JSON.toJSONString(obj, SerializerFeature.PrettyFormat,SerializerFeature.DisableCheckSpecialChar));
                    } else {
                        log.error(
                                AppAspect.tableFormatter(JSON.parseObject(JSON.toJSONString(obj)),1)
                        );
                    }
                }
            }.start();



		}
		jsonStr = stringToJson(jsonStr);
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.print(jsonStr);
			out.flush();
			log.debug("返回结果:" + jsonStr);
		} catch (IOException e) {
			log.error("responce 输出json异常!" + e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	public static String stringToJson(String s) {    
        StringBuffer sb = new StringBuffer ();     
        for (int i=0; i<s.length(); i++) {     
      
            char c = s.charAt(i);     
            switch (c) {     
//            case '\"':     
//               sb.append("\\\"");     
//                break;     
//            case '\\':   //如果不处理单引号，可以释放此段代码，若结合下面的方法处理单引号就必须注释掉该段代码
//                sb.append("\\\\");     
//               break;     
//            case '/':     
//                sb.append("\\/");     
//                break;     
            case '\b':      //退格
                sb.append("\\b");     
                break;     
            case '\f':      //走纸换页
                sb.append("\\f");     
                break;     
//            case '\n':
//                sb.append("\\n"); //换行
//                break;
//            case '\r':      //回车
//                sb.append("\\r");
//                break;
//            case '\t':      //横向跳格
//                sb.append("\\t");
//                break;
            default:     
                sb.append(c);    
            }}
        return sb.toString();     
     }
}
