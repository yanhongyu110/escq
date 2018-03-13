package com.jero.esc.common.utils.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public static String partner = "2088801710174719";

	//支付宝的密钥
	public  static  String private_key="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCMkqPSoTGyZCdhtt9C9maRLFpTqnnfh5m8BJNdV5sqM2y39+vGa8DdGvtyUdIwtbEQs5o8mLrsy1wLsEkIK/u8/Pn62hv+WYQCux+8sYNhjv7JgVpJ66m/5s2NTk0BjSuHVKqODsd+7BJEDBfkjCFejWCY6wzGr/PYRVKFzJTKNd2xXfKu40athN5ddnmmFYp+ie2iFsWDniIQarTskbPLUj0MD+jP+3411bt1M3YxWSJ7EpcB2gPde/eCcoqiiD06mDoMPlVRA9tZ9V+botFyMEcdqZysDulgRutt+5KVVdE3M8wzWQ/MT7CI0K6N3BdV5bzxPFgT27VLXAg3BrtDAgMBAAECggEAbk0h/sQ9Gp07yZCU3xY4pPEIb131A1CDcOSmPTfgqNxxEmmWt7sVOmlRpAJPy6jFpzVGcQXmpqdrMkDBDYh1n3VhMVSzYoEa9Imf/Y/MZ2Csy7CUCCzCpbGU2Kv4AJ+k6CunKJCwOQdDzeEvXkYWaPrGMTc+byjhTXIXrqU4mvE2sMRtG9hYlJ4cgzfTNtcB3ZJYXHaNYNHDh3QRAsLJTUZaZDD+FdDfzAO0K/QDcqV6BNEicOer4qG08UJQhTaf0UeqAHr6GbU2ER7XFcl01Y/77Xi0BZ1SrdtPQkztHAx/Ux5N/vwn5LQxK+fx7sGngr3frD9ehakV/OQUmqg0AQKBgQDyaG9cA5qCGBFDQ2kSD6N8dWj2m3PAb0xD8igDNtAsZ8j7P9gXRJXA/upEbnOxTnli44+7A6BuGjkhzL6JhT9oxbH8OKzdBa2/BuYDDtrRbCSUKgeucaMMJRzW0JUXrx524k0iV3u7zUuM3QuVAb24L+O5udVZa9wd5IEkIWG9swKBgQCUdHIu9iEouItqgfnbpYdHSEV+1nP5+Jr3UmT7Wok8HilRhCgJREYW6uowiVY72jorY4XZl+bsNodghxIkwsPJbOWgtozgiOkRnp/3xIjc+1kxSqspqBhEuPGznHam+0arQm8FeLo/SFCnu5M/qsRBLXfigkeO9bNOkg5CPSrkMQKBgD+iUrlg6MqF7uItbAOlv1EIsUkrfbNihC7B/ub5GKTPid8K33scMgO751uXcx90bkEbY7vAM/kzQRQyX0JSjFbArvx7FEXhG78t3GupFqArN179uY59nkOt6mgp0TmqauDif0Uomf6u4cpUrJmtH1SenbU/p1YWDm56cbw+Vx4pAoGAB7C8lYg0kYp11m+jROifSGcLCpYLbgCd7n/7MTYwc8fQNiPVex1pUBidRyRmLjWQ29yM+4et88CjZLG6k+LvB4k3oAq045DUGhCQkuJAgMoYhcAre730e+LkynwpfV74+zg2zh7B7zNM0lOaPisXfZTgaAB9un8p6cERMgc/KJECgYBgauwQbDCvxWBeeo/3I6rqU76AZkFpvagM++YmaqhpuPIqR9oy/ufG7ei++ZluDBFlpiijlxGUtKrmN52KThobz2F/BwpCEXA3CHH2pZp2DsgyXkHtPOm5y00b2uJF9Fsvbq0bxVWoWg3oVA+wSorK6cmPeaS6GLYhgE/Q9MiUPA==";

	//支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6BAZnHx5NGNBbls7OxeTW9FBjgxoo3VQCfP6aAkTTl0HAI42QQLLMKrOsGYuLIkDN80m4aKgzk0K6bRsJnIAjBF2rn1XHJo1s9WvLevqxmTKNQmErcStNv4Brqea5mGPeCLy54ciR1Ph2HjDYb2Lopmee+1SiuzbjE6fyFeS83WlJRqxH/TGj8vptyxqY72b4PEXl525qLlYiwZoC3trO5KSsDI7LyK+gHv4kX2JcXNB/sisejIb7zq+GTpBdOHJcM930kiJOkO9PP1T0X5KB2wkIyWLbHYWeUvO5/cT3aJV4V6HuJ7X6wJQJAZO+Wo7TsmeevCPRfr6ImK0uo0TZQIDAQAB";

	//支付宝的appid
//	public  static  String app_id="2017010604886437";
	public  static  String app_id="2017052307318922";
	
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = partner;

	// MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    public static String key = "z66rpvny5llc6qj8kjn2f2k6gppagx2x";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.jindaoj.com/pay/alipay/paynotify.html";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String return_url = "http://www.chinamotuo.com/userinfo/account/chargeConfirm.html";
	public static String return_url = "http://www.jindaoj.com/pay/alipay/payreturn.html";
	// 签名方式
	public static String sign_type = "MD5";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		
	// 支付类型 ，无需修改
	public static String payment_type = "1";
		
	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
//↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";
	
	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";
		
//↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
}

