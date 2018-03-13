package com.jero.esc.common.utils.jdpay.config;

/**
 * 
 * @copyright 上善云图信息技术有限公司
 * @author  tjh
 * @version  v1.0
 * @date  2017年2月7日
 * @description 京东第三方支付的 主要配置信息
 * 
 * 用来存储 必要且重要的信息
 */
public class JdpayConfig {
	
	// 1001是网银在线的测试商户号，商户要替换为自己的商户号。
	public static String v_mid = "1001";
	// 参照"网银在线支付B2C系统商户接口文档v4.1.doc"中2.4.1进行设置。
	public static String key ="test"; 
	
	//商户自定义返回接收支付结果的页面。对应Receive.jsp示例
	public static String v_url="http://blazh.tunnel.qydev.com/esc/pay/jdpay/payreturn.html"; 
	
	//服务器异步通知的接收地址。对应AutoReceive.jsp示例。必须要有[url:=]格式
	//参照"网银在线支付B2C系统商户接口文档v4.1.doc"中2.3.3.2
	public static String remark2 = "[url:=http://laotanwoaini1314.tunnel.qydev.com/esc/pay/jdpay/paynotify.html]"; 
	  																			    
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 支付的币种  暂时支持  人民币
	public static String v_moneytype = "CNY";
}
