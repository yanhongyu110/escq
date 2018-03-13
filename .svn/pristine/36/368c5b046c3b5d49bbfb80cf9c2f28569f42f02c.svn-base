package com.jero.esc.common.utils;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.jero.esc.common.shiro.realms.TokenDao;
import com.jero.esc.po.shiro.Apptoken;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.apache.shiro.SecurityUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import com.jero.esc.common.utils.http.FastHttp;
import com.jero.esc.common.utils.random.FastRandom;

/**
 * @copyright 上善云图信息技术有限公司
 * @author zqy
 * @version v1.0 （版本号）
 * @date 2016年12月8日
 * @description 短信验证码的获取
 */
public class CheckCode {


	
	public static void main(String[] args) {
		HttpSession session = null;
		try {
			CheckCode.getCheckCode(session, "18983402082", "您正在进行平台注册");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public  static  String getAppCheckCode(TokenDao tokenDao,String logCell,String requestParam) throws Exception {
		String[] checkCodes = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String checkCode = "";
		String strCode = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			String str = checkCodes[random.nextInt(checkCodes.length)];
			checkCode += str;
		}
		String Param = "action=send&userid=1049&account=cqjlkj&password=123456&mobile="+logCell+""
				+ "&content="+requestParam+"验证码为："+ checkCode +"【重庆捷路科技】"+"&sendTime=&extno=";
		//String sr=CheckCode.sendPost("http://106.3.37.99:7799/sms.aspx", Param);
		String sr=FastRandom.getRandom(1000);
		try(StringReader read = new StringReader(sr)){
			InputSource source = new InputSource(read);
			SAXBuilder saxbBuilder = new SAXBuilder();
				Document doc = saxbBuilder.build(source);
				Element root = doc.getRootElement();
				List<?> node = root.getChildren();
				for (int i = 0; i < node.size(); i++) {
					Element element=(Element)node.get(i);
					if(element.getName().toString().equals("returnstatus")){
						strCode = element.getValue();
					}
				}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(checkCode);

		tokenDao.putByCell(logCell,checkCode);

		return checkCode;
	}


	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月13日
	 * @description 获取短信验证码
	 * @param session
	 * @param logCell
	 * @param requestParam
	 * @throws Exception
	 * @return String
	 * @method getCheckCode
	 */
	public static String getCheckCode(HttpSession session,String logCell,String requestParam) throws Exception {
		String[] checkCodes = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String checkCode = "";
		String strCode = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			String str = checkCodes[random.nextInt(checkCodes.length)];
			checkCode += str;
		}
		String Param = "action=send&userid=1049&account=cqjlkj&password=123456&mobile="+logCell+""
				+ "&content="+requestParam+"验证码为："+ checkCode +"【重庆捷路科技】"+"&sendTime=&extno=";
		String sr=CheckCode.sendPost("http://106.3.37.99:7799/sms.aspx", Param);
		StringReader read = new StringReader(sr);  
        InputSource source = new InputSource(read);  
        SAXBuilder saxbBuilder = new SAXBuilder();  
        try {  
            Document doc = saxbBuilder.build(source);  
            Element root = doc.getRootElement();  
            List<?> node = root.getChildren();  
            for (int i = 0; i < node.size(); i++) {
            	Element element=(Element)node.get(i);
            	if(element.getName().toString().equals("returnstatus")){
            		strCode = element.getValue();
            	}
            }
        } catch (JDOMException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.out.println(checkCode);
		session.setAttribute("checkCode",checkCode);
		session.setAttribute("logCell",logCell);
		return strCode;
	}
	/**
	 * @version v1.0 (版本号)
	 * @date 2016年12月8日
	 * @description 发送短信验证码
	 * @param url
	 * @param param
	 * @return String
	 * @method sendPost
	 */
    public static String sendPost(String url, String param) throws Exception{
        String[] ss= param.split("&");        
        List<NameValuePair> formparams=new ArrayList<NameValuePair>(  );
        //Map<Object,Object> map=new HashMap<Object, Object>();
        for(int i=0;i<ss.length;i++){
        	String[] sss= ss[i].split("=");
        	if(sss.length>1){
        		formparams.add(new BasicNameValuePair(sss[0], sss[1]));
        		//map.put(sss[0], sss[1]);	
        	}       
        }
       
        
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Charset.forName("UTF-8"));
        entity.setChunked(true);
        String htmlStr="";
        try{
        htmlStr = Request.Post(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36 OPR/44.0.2510.1159")
                .useExpectContinue()
                .connectTimeout(50000)//超时，不然会线程阻塞
                .socketTimeout(50000)//超时，不然会线程阻塞
                .body(entity)
                .execute().returnContent().asString(Charset.forName("UTF-8"));//将响应转化为UTF-8编码的字符串
        }catch(Exception e){
        	  return null;
        }
        
        return htmlStr;
    }
}
