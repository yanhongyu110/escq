package com.jero.esc.common.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;

import com.jero.esc.common.utils.random.FastRandom;

/**
 * @ClassName: CakeEmilController
 * @Description: <Email的控制>
 * @author: blazh
 * @date: 2016年7月14日上午10:54:49
 * @version:
 */
public class FastEmil {
	
	public static String EMAIL_HOST="smtp.163.com";
	public static String EMAIL_ADMIN="blazh@163.com";
	public static String EMAIL_PASS="blazh784512";
	public  static String EMAIL_SESSION_MAP_NAME="emailList";
	
	/**
	 *  发送邮件
	 */
	public static void SendEamil(HttpSession ss, String target, String title, String msg) throws Exception {
		// 随机数
		String checkCode = FastRandom.getRandom(5);				
		Mail mail = new Mail();
		mail.setHost(EMAIL_HOST); // 设置邮件服务器,如果不用163的,自己找找看相关的
		mail.setSender(EMAIL_ADMIN);
		mail.setReceiver(target); // 接收人
		mail.setUsername(EMAIL_ADMIN); // 登录账号,一般都是和邮箱名一样吧
		mail.setPassword(EMAIL_PASS); // 发件人邮箱的登录密码
		mail.setSubject(title);
		mail.setMessage("您的验证码是:" + msg==null?checkCode:msg);
		boolean send = new MailUtil().send(mail);
		if (!send){
			throw  new Exception();
		}

        if (ss.getAttribute(EMAIL_SESSION_MAP_NAME)!=null&&ss.getAttribute(EMAIL_SESSION_MAP_NAME) instanceof Map){
            ((Map) ss.getAttribute(EMAIL_SESSION_MAP_NAME)).put(target,checkCode);
        }else {
            Map<String, String> stringStringHashMap = new HashMap<String, String>();
            stringStringHashMap.put(target,checkCode);
            ss.setAttribute(EMAIL_SESSION_MAP_NAME,stringStringHashMap);
        }
		ss.setAttribute("Email", checkCode);

	}
}



/**
 * Mail属性实体
 * 
 * @author shadow
 * 
 */
@SuppressWarnings("serial")
class Mail implements Serializable {

	public static final String ENCODEING = "UTF-8";

	private String host; // 服务器地址

	private String sender; // 发件人的邮箱

	private String receiver; // 收件人的邮箱

	private String name; // 发件人昵称

	private String username; // 账号

	private String password; // 密码

	private String subject; // 主题

	private String message; // 信息(支持HTML)

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

/**
 * 邮件发送工具实现类
 * 
 * @author shadow
 * @create 2013/07/12
 */
class MailUtil {

	protected final Logger logger = Logger.getLogger(getClass());

	public boolean send(Mail mail) {
		// 发送email
		HtmlEmail email = new HtmlEmail();
		try {
			// 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
			email.setHostName(mail.getHost());
			// 字符编码集的设置
			email.setCharset(Mail.ENCODEING);
			// 收件人的邮箱
			email.addTo(mail.getReceiver());
			// 发送人的邮箱
			email.setFrom(mail.getSender(), mail.getName());
			// 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
			email.setAuthentication(mail.getUsername(), mail.getPassword());
			// 要发送的邮件主题
			email.setSubject(mail.getSubject());
			// 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
			email.setMsg(mail.getMessage());

			// 发送
			email.send();
			if (logger.isDebugEnabled()) {
				logger.debug(mail.getSender() + " 发送邮件到 " + mail.getReceiver());
			}
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			logger.info(mail.getSender() + " 发送邮件到 " + mail.getReceiver() + " 失败");
			return false;
		}
	}

}
