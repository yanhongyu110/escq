package com.jero.esc.common.utils.wechat.utils;

public class Configure {
//这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改

	private static String key = "jindaojia20171129D123C654DDE6AC1";

	//微信分配的公众号ID（开通公众号之后可以获取到）
	private static String appID = "wx3102242cc9acf3aa";

	//对应的凭证						 ABCDEFGHIJKLMNOPQRSTUVWXYZ123456
	private static String appSecret="708f8857366d4148f65a1a9ef309bc11";

	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
	private static String mchID = "1486272382";

	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private static boolean useThreadToDoReport = true;

	//机器IP
	private static String ip = "127.0.0.1";

	//回调地址
	private static String notifyUrl="http://www.jindaoj.com/pay/wxpay/paynotify.html";
	
	//订单保存时间
	private static long time_out=1000*60*20;
	
	//支付结果通知
	public static Integer RESULT = 0;
	
	//编码方式	
	public static String inputCharset="UTF-8";
	
		
		//沙箱测试 中间添加sandboxnew
		//以下是几个API的路径：
		// 统一下单
		public static final String UNIFIEDORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		// 查询订单
		public static final String QUERYORDER = "https://api.mch.weixin.qq.com/sandboxnew/pay/orderquery";
		//关闭订单
		public static final String CLOSEORDER="https://api.mch.weixin.qq.com/sandboxnew/pay/closeorder";
		//申请退款
		public static final String REFUND="https://api.mch.weixin.qq.com/secapi/pay/refund";
		//查询退款
		public static final String REFUNDQUERY="https://api.mch.weixin.qq.com/sandboxnew/pay/refundquery";
		//下载对账单
		public static final String DOWNLOADBILL="https://api.mch.weixin.qq.com/sandboxnew/pay/downloadbill";
	
		
		
		
		public static String getInputCharset() {
			return inputCharset;
		}

		public static void setInputCharset(String inputCharset) {
			Configure.inputCharset = inputCharset;
		}

		public static long getTime_out() {
			return time_out;
		}

		public static void setTime_out(long time_out) {
			Configure.time_out = time_out;
		}

	public static String getNotifyUrl() {
		return notifyUrl;
	}

	public static void setNotifyUrl(String notifyUrl) {
		Configure.notifyUrl = notifyUrl;
	}

	public static String getAppSecret() {
		return appSecret;
	}

	public static void setAppSecret(String appSecret) {
		Configure.appSecret = appSecret;
	}
	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		Configure.ip = ip;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Configure.key = key;
	}

	public static String getAppID() {
		return appID;
	}

	public static void setAppID(String appID) {
		Configure.appID = appID;
	}

	public static String getMchID() {
		return mchID;
	}

	public static void setMchID(String mchID) {
		Configure.mchID = mchID;
	}

	public static boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
		Configure.useThreadToDoReport = useThreadToDoReport;
	}

	

}
