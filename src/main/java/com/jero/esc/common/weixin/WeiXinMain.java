package com.jero.esc.common.weixin;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.InputSource;

import com.jero.esc.common.utils.StringUtil;
import com.jero.esc.common.weixin.entity.PaymentEntity;
import com.jero.esc.common.weixin.entity.RedPacketEntity;
import com.jero.esc.common.weixin.entity.TransfersEntity;
import com.jero.esc.common.weixin.result.PaymentResult;
import com.jero.esc.common.weixin.result.RedPacketResult;
import com.jero.esc.common.weixin.result.TransfersResult;

@Controller
@RequestMapping(value="/weixin")
public class WeiXinMain {
	
	/** 微信公众平台发送红包url */
	private static final String SEND_REDPACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	/** 微信公众平台企业支付url */
	private static final String TRANSFERS_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	/** 微信公众平台充值 */
	private static final String PAYMENT_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	public static void main(String[] args) throws JDOMException {
		String openId = "o5tP4v65-yGzrvwVMw2plDLr8FS8";
//		TransfersResult result = sendTransfersXml(openId,"100");
		RedPacketResult result = sendRedPacketXml(openId);
//		PaymentResult result = sendPaymentXml(openId, "1", "充值", DateUtil.getPayMentId());
		System.out.println(result.getReturn_code());
//		WeixinDraw weixin = new WeixinDraw();
//		Map<String, String> map = weixin.transfer(openId, 100, "近到家公众平台体现", DateUtil.getPayMentId());
//		System.out.println(map);
	}
	/**
	 * 
	 *<pre>
	 *<b> 发送现金红包.</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-11 下午6:14:08
	 *@param openId
	 *</pre>
	 */
	public static RedPacketResult sendRedPacketXml(String openId){
		RedPacketResult result = new RedPacketResult();
		try {
			RedPacketEntity redPacket = new RedPacketEntity();
			//设置openId
			redPacket.setRe_openid(openId);
			//生成签名
			String sign = WeiXinSign.redPacketGetSign(redPacket);
			redPacket.setSign(sign);
			//组装xml
	        XMLUtil xmlUtil= new XMLUtil();
	        xmlUtil.xstream().alias("xml", redPacket.getClass());
	        String data = xmlUtil.xstream().toXML(redPacket);
			//发送请求
			String jsonStr = WeiXinSendRequest.sendRequest(data, redPacket.getMch_id(), SEND_REDPACK_URL);
			//获取返回状态
			result = WeiXinReultReturn.returnRedPacketResult(jsonStr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 *<pre>
	 *<b> 企业支付 .</b>
	 *<b>Description:</b> 
	 *    提现
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-13 上午10:43:34
	 *@param openId 微信openId
	 *@param amount 金额
	 *@return
	 *</pre>
	 */
	public static TransfersResult sendTransfersXml(String openId, String amount){
		TransfersResult result = new TransfersResult();
		try {
			TransfersEntity transfers = new TransfersEntity();
			transfers.setOpenid(openId);
			transfers.setAmount(amount);
			String sign = WeiXinSign.transfersGetSign(transfers);
			transfers.setSign(sign);
	        XMLUtil xmlUtil= new XMLUtil();
	        xmlUtil.xstream().alias("xml", transfers.getClass());
	        String data = xmlUtil.xstream().toXML(transfers);
//			String data = WeiXinDataXml.getTransfersXml(transfers, sign);
			System.out.println(data);
			//发送请求 获取结果
			String jsonStr = WeiXinSendRequest.sendRequest(data, transfers.getMchid(), TRANSFERS_URL);
			//把json字符串转化为实体类
			result = WeiXinReultReturn.returnTransfersReult(jsonStr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 *<pre>
	 *<b> 用户充值 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-18 上午11:43:55
	 *@param openId 用户openid
	 *@param total_fee 充值金额
	 *@param body 支付详情 描述
	 *@return
	 *</pre>
	 */
	public static PaymentResult sendPaymentXml(String openId, String total_fee, String body, String out_trade_no){
		PaymentResult result = new PaymentResult();
		try {
			//配置参数
			PaymentEntity payment = new PaymentEntity();
			payment.setOpenid(openId);
			payment.setTotal_fee(total_fee);
			payment.setBody(body);
			payment.setOut_trade_no(out_trade_no);
			
			//生成签名
			String sign = WeiXinSign.paymentGetSing(payment);
			payment.setSign(sign);
			
			//封装请求xml
	        XMLUtil xmlUtil= new XMLUtil();
	        xmlUtil.xstream().alias("xml", payment.getClass());
	        String data = xmlUtil.xstream().toXML(payment);
			System.out.println(data);
			//发送请求 获取结果
			String jsonStr = WeiXinSendRequest.sendRequestNoMchId(data, PAYMENT_URL);
			result = WeiXinReultReturn.returnPaymentResult(jsonStr);
			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	/**
	 * 异步回调，在WxPayConfig中配置指向这里
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@RequestMapping(value="/wxPayCallback")
	public void WxPayCallback(HttpServletRequest request, HttpServletResponse response) {
		try {
			DecimalFormat    df   = new DecimalFormat("#.00");   
			BufferedReader reader = request.getReader();
			String line = "";
			StringBuffer inputString = new StringBuffer();
			try {
				PrintWriter writer = response.getWriter();
				while ((line = reader.readLine()) != null) {
					inputString.append(line);
				}
				if (reader != null) {
					reader.close();
				}
				System.out.println("----[微信回调]接收到的报文---"
						+ inputString.toString());
				if (StringUtil.isNotEmpty(inputString.toString())) {
					StringReader read = new StringReader(inputString.toString());
					// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
					InputSource source = new InputSource(read);
					// 创建一个新的SAXBuilder
					SAXBuilder sb = new SAXBuilder();
					// 通过输入源构造一个Document
					org.jdom.Document doc;
					doc = (org.jdom.Document) sb.build(source);

					org.jdom.Element root = doc.getRootElement();// 指向根节点
					List<org.jdom.Element> list = root.getChildren();
					Map map = new TreeMap();
					if (list != null && list.size() > 0) {
						for (org.jdom.Element element : list) {
							System.out.println("key是：" + element.getName()
									+ "，值是：" + element.getText());
							map.put(element.getName(), element.getText());
						}
					}

					String attach = String.valueOf(map.get("attach"));
					String return_code = String.valueOf(map.get("return_code"));
					String appid = String.valueOf(map.get("appid"));
					String bank_type = String.valueOf(map.get("bank_type"));
					String cash_fee = String.valueOf(map.get("cash_fee"));
					String fee_type = String.valueOf(map.get("fee_type"));
					String is_subscribe = String.valueOf(map
							.get("is_subscribe"));
					String mch_id = String.valueOf(map.get("mch_id"));
					String nonce_str = String.valueOf(map.get("nonce_str"));
					String openid = String.valueOf(map.get("openid"));
					String out_trade_no = String.valueOf(map
							.get("out_trade_no"));
					String result_code = String.valueOf(map.get("result_code"));
					String time_end = String.valueOf(map.get("time_end"));
					String transaction_id = String.valueOf(map
							.get("transaction_id"));
					String total_fee = String.valueOf(map.get("total_fee"));
					String trade_type = String.valueOf(map.get("trade_type"));
					String sign1 = String.valueOf(map.get("sign"));
					String return_msg = String.valueOf(map.get("return_msg"));

					if ("SUCCESS".equalsIgnoreCase(return_code)) {
						SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
						parameters.put("appid", appid);
						parameters.put("attach", attach);
						parameters.put("bank_type", bank_type);
						parameters.put("cash_fee", cash_fee);
						parameters.put("fee_type", fee_type);
						parameters.put("is_subscribe", is_subscribe);
						parameters.put("mch_id", mch_id);
						parameters.put("nonce_str", nonce_str);
						parameters.put("openid", openid);
						parameters.put("out_trade_no", out_trade_no);
						parameters.put("result_code", result_code);
						parameters.put("return_code", return_code);
						parameters.put("time_end", time_end);
						parameters.put("total_fee", total_fee);
						parameters.put("trade_type", trade_type);
						parameters.put("transaction_id", transaction_id);
                        System.out.println("sign1:"+sign1);
                        System.out.println("分隔符：==============================");
						// 反校验签名
						String sign = WeiXinSign.createSign("UTF-8",
								parameters);
                        System.out.println("sign:"+sign);
                        double money = Double.parseDouble(total_fee);
						if (sign.equals(sign1)) {// 两次签名相同，校验成功
							    response.getWriter().write(
									WxCommonUtil.setXML("SUCCESS", "OK"));
						} else {// 验证失败
							response.getWriter().write(
									WxCommonUtil.setXML("FAIL", "Pay Failure"));
						}
			          } 
					}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
