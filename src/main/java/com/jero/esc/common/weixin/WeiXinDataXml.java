package com.jero.esc.common.weixin;

import com.jero.esc.common.weixin.entity.RedPacketEntity;
import com.jero.esc.common.weixin.entity.TransfersEntity;

public class WeiXinDataXml {

	/**
	 * 
	 *<pre>
	 *<b> 封装红包实体类 .</b>
	 *<b>Description:</b> 
	 *    
	 *<b>Author:</b> yanhongyu
	 *<b>Date:</b> 2017-12-13 下午12:10:56
	 *@param redPacket
	 *@param sign
	 *@return
	 *</pre>
	 */
	public static String getRedPacketXml(RedPacketEntity redPacket , String sign){
		String data = "<xml><nonce_str>";
		data += redPacket.getNonce_str() + "</nonce_str><mch_billno>"; // APPID
		data += redPacket.getMch_billno() + "</mch_billno><mch_id>"; // 商户ID
		data += redPacket.getMch_id() + "</mch_id><wxappid>"; // 随机字符串
		data += redPacket.getWxappid() + "</wxappid><send_name>"; // 订单号
		data += redPacket.getSend_name() + "</send_name><re_openid>"; // 是否强制实名验证
		data += redPacket.getRe_openid() + "</re_openid><total_amount>"; // 是否强制实名验证
		data += redPacket.getTotal_amount() + "</total_amount><total_num>"; // 是否强制实名验证
		data += redPacket.getTotal_num() + "</total_num><wishing>"; // 是否强制实名验证
		data += redPacket.getWishing() + "</wishing><client_ip>"; // 是否强制实名验证
		data += redPacket.getClient_ip() + "</client_ip><act_name>"; // 是否强制实名验证
		data += redPacket.getAct_name() + "</act_name><remark>"; // 是否强制实名验证
		data += redPacket.getRemark() + "</remark><sign>"; // 是否强制实名验证
		data += sign + "</sign></xml>";// 签名
		return data;
	}
	
	public static String getTransfersXml(TransfersEntity ransfers,String sign){
		String data = "<xml><mch_appid>";
		data += ransfers.getMch_appid() +"</mch_appid><mchid>"; // APPID
		data += ransfers.getMchid() + "</mchid><nonce_str>"; // 商户ID
		data += ransfers.getNonce_str() + "</nonce_str><partner_trade_no>"; // 随机字符串
		data += ransfers.getPartner_trade_no() + "</partner_trade_no><openid>"; // 订单号
		data += ransfers.getOpenid() + "</openid><check_name>NO_CHECK</check_name><amount>"; // 是否强制实名验证
		data += 100 + "</amount><desc>"; // 企业付款金额，单位为分
		data += ransfers.getDesc() + "</desc><spbill_create_ip>"; // 企业付款操作说明信息。必填。
		data += ransfers.getSpbill_create_ip() + "</spbill_create_ip><sign>";// 调用接口的机器Ip地址
		data += sign + "</sign></xml>";// 签名
		return data;
	}
}
