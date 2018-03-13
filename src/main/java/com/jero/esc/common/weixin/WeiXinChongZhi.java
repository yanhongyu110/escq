package com.jero.esc.common.weixin;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.input.SAXBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.InputSource;

import com.alibaba.druid.util.StringUtils;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.DateUtil;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.weixin.entity.Unifiedorder;


public class WeiXinChongZhi{

	/* 在WxPayConfig中修改配置 */

	/* 微信的扫码支付，需要在web端开启一个计时器，时刻访问后台数据库查看是否支付成功，不想支付宝有同不回调 */

	/**
	 * 生成统一下单，微信支付的第一步
	 * */
	public void wxSign(HttpServletResponse response, String openId, String attach, String body, String total_fee) {
		try {
			DecimalFormat    df   = new DecimalFormat("#.00");   
//			int total_fee = (int) (Double.parseDouble(df.format(request.getParameter("money"))) * 100);
//			int total_fee = (int)(Double.parseDouble(df.format(Double.parseDouble(request.getParameter("money")))) * 100);
//			String	openId = request.getParameter("openId");//openId
//			String attach = request.getParameter("userId");//用户id
//			String body = request.getParameter("body");//商品简单描述
			if (!"".equals(body) && body!=null) {
				body=new String(body.getBytes("iso8859-1"), "utf-8");
			}
//			String out_trade_no = DateUtil.getPayMentId();//订单号
			String appid = "wxd0c763640d4b8f08";
			String mch_id = "1486272382";
//			String tranPassWord = request.getParameter("tranPassWord");
//			 tranPassWord = MD5Util.string2MD5(tranPassWord);//交易密码
//             if (!tranPassWord.equals(u.getTranPassword())) {
//				toWrite(BaseBean.buildJson("交易密码错误", false));
//			}else {
				weixinSign( DateUtil.getPayMentId(), Integer.parseInt(total_fee), body,
						InetAddress.getLocalHost().getHostAddress(), attach, openId, response);
//			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 微信支付签名步骤，接口中已经做了返回消息的处理，可以更具具体情况修改返回
	 * 
	 * @param payType
	 *            支付类型，0公众号支付，在公众号的web界面调用微信的APP支付 1扫码支付，生成二维码扫码支付，多用于电脑端
	 * @param orderId
	 *            订单id，需要保证唯一性
	 * @param total_fee
	 *            支付金额，单位是分
	 * @param body
	 * @param spbill_create_ip
	 *            调用接口的客户端ip
	 * @param attach
	 *            携带的自定义参数，在异步回调接口中微信会返回
	 * @param openId
	 *            如果支付类型是公众号支付，需要传入openId
	 */
	public void weixinSign(String orderId, int total_fee,
			String body, String spbill_create_ip, String attach, String openId, HttpServletResponse response) {
		try {
			String out_trade_no = new Date().getTime()+"";
//			String out_trade_no = orderId;
			String appid = "wxd0c763640d4b8f08";
//			String appid = "wx3102242cc9acf3aa";
			
			attach = "1";
			String mch_id = "1494182642";
//			String mch_id = "1486272382";

			String nonce_str = new Date().getTime()+"";
//			String nonce_str = genNonceStr();
			System.out.println("随机字符串是：" + nonce_str);

			System.out.println("body=" + body);
			System.out.println("out_trade_no=" + out_trade_no);
			System.out.println("total_fee=" + total_fee);

			// String spbill_create_ip = request.getRemoteHost();
			System.out.println("设备号是：" + spbill_create_ip);

			String time_start = RandCharsUtils.timeStart();
			System.out.println("交易开始时间" + time_start);

			String time_expire = RandCharsUtils.timeExpire();
			System.out.println("交易结束时间" + time_expire);

			// 微信返回结果验证
			String notify_url = "http://www.jindaoj.com/weiXinChongZhi/WxPayCallback.htm";
			System.out.println("notify_url是：" + notify_url);

			String trade_type = "JSAPI";

			String timestamp = String
					.valueOf(System.currentTimeMillis() / 1000);

			// 参数：开始生成签名
			SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
			parameters.put("appid", appid);
			parameters.put("mch_id", mch_id);
			parameters.put("body", "asdfadfa");
			parameters.put("nonce_str", nonce_str);
			parameters.put("out_trade_no", out_trade_no);
			parameters.put("total_fee", total_fee);
			parameters.put("notify_url", notify_url);
			parameters.put("trade_type", trade_type);
			parameters.put("spbill_create_ip", spbill_create_ip);
			parameters.put("attach", attach);
			parameters.put("openid", openId);

			String sign = WeiXinSign.createSign("UTF-8", parameters);
			System.out.println("签名sign=====" + sign);

			Unifiedorder unifiedorder = new Unifiedorder();
			unifiedorder.setAppid(appid);
			unifiedorder.setMch_id(mch_id);
			unifiedorder.setNonce_str(nonce_str);
			unifiedorder.setSign(sign);
			unifiedorder.setBody(body);
			unifiedorder.setAttach(attach);
			unifiedorder.setOut_trade_no(out_trade_no);
			unifiedorder.setTotal_fee(total_fee);
			unifiedorder.setSpbill_create_ip(spbill_create_ip);
			unifiedorder.setNotify_url(notify_url);
			unifiedorder.setTrade_type(trade_type);
			unifiedorder.setOpenid(openId);

			// 构造xml参数
			String xmlInfo = HttpXmlUtils.xmlInfo(unifiedorder);
			System.out.println("myxml : " + xmlInfo);

			String wxUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";

			String method = "POST";

			String weixinPost = HttpXmlUtils.httpsRequest(wxUrl, method,
					xmlInfo).toString();

			System.out.println("weixinPost:" + weixinPost);
			
			StringReader read = new StringReader(weixinPost);
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
			
			System.out.println("访问地址" + wxUrl);
			System.out.println("请求参数   公众号:"+ appid);
			System.out.println("请求参数   商户号:"+ mch_id);
			if (list != null && list.size() > 0) {
				for (org.jdom.Element element : list) {
					System.out.println("key是：" + element.getName() + "，值是："
							+ element.getText());
					map.put(element.getName(), element.getText());
				}
			}

			SortedMap<Object, Object> parame = new TreeMap<Object, Object>();
			String timestamp_ = String
					.valueOf(System.currentTimeMillis() / 1000);

			String nonce_str_ = genNonceStr();
			System.out.println("随机字符串是：" + nonce_str_);

			parame.put("appId", String.valueOf(map.get("appid")));
			parame.put("timeStamp", timestamp_);
			parame.put("nonceStr", nonce_str_);
			parame.put("signType", "MD5");
			parame.put("package",
					"prepay_id=" + String.valueOf(map.get("prepay_id")));

			String sign2 = WeiXinSign.createSign("UTF-8", parame);

			Map rvmap = new TreeMap();
			rvmap.put("appid", String.valueOf(map.get("appid")));
			rvmap.put("prepayid", String.valueOf(map.get("prepay_id")));
			rvmap.put("nonce_str", nonce_str_);
			rvmap.put("timestamp", timestamp_);
			rvmap.put("sign", sign2);
			// JsonBuilder.getInstance().toWrite(request, response,
			// JsonBuilder.getInstance().returnSuccessJson(JsonBuilder.getInstance().toJson(rvmap)));
			// 调用微信APP支付
			
			JsonUtil.printByJSON(response, new JsonResult(true, "", rvmap));
			
			
//			return;
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException {
		WeiXinChongZhi wx = new WeiXinChongZhi();
		wx.	weixinSign( DateUtil.getPayMentId(), 1, "测试",
				InetAddress.getLocalHost().getHostAddress(), "", "o5tP4v2sRruivGVkBPjL5zvWQQnw", null);
	}

	/**
	 * 生成随机字符串
	 * 
	 * @return
	 */
	private String genNonceStr() {
		Random random = new Random();
		return MD5wx.getMessageDigest(String.valueOf(random.nextInt(10000))
				.getBytes());
	}

	/**
	 * 异步回调，在WxPayConfig中配置指向这里
	 * */
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
				if (!StringUtils.isEmpty(inputString.toString())) {
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
	
	public void  unifiedorder(){
		
	}
}
