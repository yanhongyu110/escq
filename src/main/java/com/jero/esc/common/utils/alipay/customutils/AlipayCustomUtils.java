package com.jero.esc.common.utils.alipay.customutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.jero.esc.common.utils.alipay.config.AlipayConfig;
import com.jero.esc.common.utils.alipay.util.AlipayNotify;
import com.jero.esc.common.utils.alipay.util.AlipaySubmit;

/**
 * 
 * @copyright 上善云图信息技术有限公司
 * @author  tjh
 * @version  v1.0
 * @date  2017年1月11日
 * @description AlipayCustomUtils 实现支付的方法封装
 */
public class AlipayCustomUtils {

	/**
	 * 
	 * @version  v1.0
	 * @date  2017年1月11日
	 * @description 开始支付，获取相关参数 并以String形式 页面提交数据代码包含html结构
	 * @param
	 * @method payStart
	 */
	public static void payStart(String out_trade_no,String subject,String total_fee,String body,HttpServletResponse response,String key){
//		String out_trade_no ="";  // 交易平台自动生成的 交易号
//		String subject ="";       // 标题
//		String total_fee ="";     // 费用
//		String body =""; 	      // 订单描述
		// 获取前台页面传来的必要参数 可以自定义添加
		/*try {
			out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			subject = new String(request.getParameter("WIDsubject"));
			total_fee = new String(request.getParameter("WIDtotal_fee").getBytes("ISO-8859-1"),"UTF-8");
			body = new String(request.getParameter("WIDbody"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", AlipayConfig.service);
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_id", AlipayConfig.seller_id);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", "");
		sParaTemp.put("notify_url", "http://laotanwoaini1314.tunnel.qydev.com/esc/pay/alipay/paynotify.html"); // 后台通知页面
		sParaTemp.put("return_url", "http://laotanwoaini1314.tunnel.qydev.com/esc/pay/alipay/payreturn.html"); // 支付成功用户要跳转的页面
		sParaTemp.put("anti_phishing_key", AlipayConfig.anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", AlipayConfig.exter_invoke_ip);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		//其他业务参数根据在线开发文档，添加参数.文档地址:https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.O9yorI&treeId=62&articleId=103740&docType=1
        //如sParaTemp.put("参数名","参数值");
		
		//建立请求
		String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"post","确认",key);
		try {
			PrintWriter out= response.getWriter();
			out.println("<HTML>");
	        out.println("  <HEAD><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><TITLE></TITLE></HEAD>");
	        out.println("  <BODY>");
	        out.print(sHtmlText);
	        out.println("  </BODY>");
	        out.println("</HTML>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @version  v1.0
	 * @date  2017年1月11日
	 * @description 支付成功返回的界面(View)
	 * @param
	 * @return ModelAndView
	 * @throws UnsupportedEncodingException 
	 * @method payreturn
	 */
	public static ModelAndView payreturn(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		
		//计算得出通知验证结果
		boolean verify_result = AlipayNotify.verify(params);
		ModelAndView mav = new ModelAndView();
		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码
			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
				
				mav.addObject("status", "支付成功");
				mav.setViewName("/saleinfo/paysucess");
				
			}
			//该页面可做页面美工编辑
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{
			//该页面可做页面美工编辑
			mav.addObject("status", "支付失败");
			mav.setViewName("/saleinfo/paysucess");
			return mav;
		}
		
		return mav;
	}
	
	
	/**
	 * 
	 * @version  v1.0
	 * @date  2017年1月11日
	 * @description  支付过程中的通知方法，主要接收阿里服务器传输过来的数据进行验证或者存储必要的数据
	 * @param request
	 * @return
	 * @method paynotify
	 */
	public static void paynotify(HttpServletRequest request,HttpServletResponse response){
		
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		String out_trade_no ="";
		//交易状态
		String trade_status ="";
		String subject ="";
		String total_fee ="";
		String body ="";
		try {
			out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"),"UTF-8");
			total_fee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");
			body = new String(request.getParameter("body").getBytes("ISO-8859-1"),"UTF-8");
			
			
			if(AlipayNotify.verify(params)){//验证成功
				//////////////////////////////////////////////////////////////////////////////////////////
				//请在这里加上商户的业务逻辑程序代码
				//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
				if(trade_status.equals("TRADE_FINISHED")){
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
						//如果有做过处理，不执行商户的业务程序
					System.out.println("..............................."+out_trade_no+"........TRADE_FINISHED............................");
					System.out.println("..............................."+trade_no+"....................................");
					System.out.println("..............................."+trade_status+"....................................");
					System.out.println("..............................."+subject+"....................................");
					System.out.println("..............................."+total_fee+"....................................");
					System.out.println("..............................."+body+"....................................");
					//注意：
					//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
				} else if (trade_status.equals("TRADE_SUCCESS")){
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
						//如果有做过处理，不执行商户的业务程序
					System.out.println("..............................."+out_trade_no+"........TRADE_SUCCESS............................");
					System.out.println("..............................."+trade_no+"....................................");
					System.out.println("..............................."+trade_status+"....................................");
					System.out.println("..............................."+subject+"....................................");
					System.out.println("..............................."+total_fee+"....................................");
					System.out.println("..............................."+body+"....................................");
					//注意：
					//付款完成后，支付宝系统发送该交易状态通知
				}

				//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
				response.getWriter().print("success");	//请不要修改或删除
				//////////////////////////////////////////////////////////////////////////////////////////
			}else{//验证失败
				response.getWriter().print("fail");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
