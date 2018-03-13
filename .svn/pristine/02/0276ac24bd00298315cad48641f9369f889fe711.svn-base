/**
 * 
 */
package com.jero.esc.service.impl.saleinfo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.mapper.saleinfo.OrderInfoMapper;
import com.jero.esc.mapper.saleinfo.OrderInfoSellerMapper;
import com.jero.esc.po.details.AccontPaymentDetails;
import com.jero.esc.po.details.OrderDoneDetails;
import com.jero.esc.po.pay.Payinfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.details.IAccountPaymentDetailsService;
import com.jero.esc.service.details.IOrderDoneDetailsService;
import com.jero.esc.service.saleinfo.IOrderInfoSellerService;
import com.jero.esc.service.userinfo.IAccountInfoService;
import com.jero.esc.vo.saleinfo.OrderInfo;
import com.jero.esc.vo.saleinfo.OrderService;

@Service
/**
 * Title:OrderInfoSellerService 
 * Description:定义查询卖家订单接口实现方法
 * Company:ssyt
 * @author ll
 * @date2016年12月24日
 */
public class OrderInfoSellerService implements IOrderInfoSellerService {
	@Autowired
	private OrderInfoSellerMapper orderInfoSellerMapper;
	
	@Autowired
	private IAccountInfoService iAccountInfoService;
	
	@Autowired
	private  OrderInfoMapper  orderInfoMapper;
	
	@Autowired
	private IOrderDoneDetailsService orderDoneDetailsService;
	
	@Autowired
	private IAccountPaymentDetailsService  accountPaymentDetailsService;
	
	public List<OrderInfo> queryAllOrderInfo(PageRowBounds pageRowBounds, OrderInfo orderInfo) {
		return orderInfoSellerMapper.selectAll(pageRowBounds, orderInfo);
	}
	

	/**
	 * 定义删除订单的方法
	 */
	@Transactional(rollbackFor=Exception.class)
	public JsonResult removeOrderById(OrderInfo order) {
		JsonResult jr = new JsonResult();
		try {
			Integer res = orderInfoSellerMapper.deleteOrderById(order.getOrderId());
			if(res > 0){
				jr.setSuccess(true);
				jr.setErrorMsg("删除成功");
				return jr;
			}
			jr.setSuccess(false);
			jr.setErrorMsg("删除失败");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jr;
	}

	public int queryOrderCount(OrderInfo orderInfo) {
		return orderInfoSellerMapper.queryOrderCount(orderInfo);
	}

	@Transactional(rollbackFor=Exception.class)
	public JsonResult modifyOrderState(OrderInfo order) {
		JsonResult jr = new JsonResult();
		try {
			Integer res = orderInfoSellerMapper.updateOrderState(order);
			if(res>0){
				jr.setSuccess(true);
				jr.setErrorMsg("操作成功");
				return jr;
			}
				jr.setSuccess(false);
				jr.setErrorMsg("操作失败");
				throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jr;
	}


	public OrderInfo selectOrderById(String orderId) {
		return orderInfoSellerMapper.selectOrderById(orderId);
	}

	public int queryCount(OrderInfo orderInfo) {
		return orderInfoSellerMapper.selectAll(orderInfo).size();
	}


	@Override
	@Transactional(rollbackFor=Exception.class)
	public Integer modifyRefundMsgByOrderNo(String json) throws Exception{  // 这里是 专家同意 退款以后 要做的修改订单表的状态修改 和 双方 平台余额的修改 
		JSONObject jsonObject = JSONObject.parseObject(json);
		boolean isAgree = (Boolean) jsonObject.get("isAgree");
		String content = (String) jsonObject.get("orderSellerrepaycontent");
		String orderNo = (String) jsonObject.get("orderNo");
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderSellerrepaycontent(content);
		orderInfo.setOrderNo(orderNo);
		//  下面是根据 订单号   orderNo 确保唯一 查询  订单信息
		com.jero.esc.po.saleinfo.OrderInfo currentOrderInfo = orderInfoMapper.selectByOrderNo(orderNo);
		if(isAgree){
			orderInfo.setOrderRefundstate(2);  // 表示同意  执行买卖家分别增减 平台余额    操作订单的
			orderInfo.setOrderState(5);  //退款成功后修改订单状态为待评价
			orderInfo.setOrderId(currentOrderInfo.getOrderId());
			iAccountInfoService.modifyAccBalanceByLogId(currentOrderInfo.getOrderBuyer(), 1, currentOrderInfo.getOrderPrice());// 买家  增加余额
			//iAccountInfoService.modifyAccBalanceByLogId(currentOrderInfo.getOrderSeller(), -1, currentOrderInfo.getOrderPrice());// 卖家  增加余额
			// 关于收支的 详细 记录  需要  记录 便于前台  查询自身的收支 记录
			if(currentOrderInfo.getOrderState()!=5){
			orderInfoSellerMapper.updateOrderState(orderInfo);
			recordsOrderDoneAndPaymentDetails(currentOrderInfo);
			}
		}else if (content != null && content != "") {
			orderInfo.setOrderRefundstate(3);  // 表示不同意  需要 买家 申请 平台处理 或者 自行商量
		}else {
			return 0;
		}
		
		
		return orderInfoSellerMapper.updateRefundMsgByOrderNo(orderInfo);
	}


	public LogInfo getLogInfo(String id) {
		List<LogInfo> logInfo = orderInfoSellerMapper.logInfo(id);
		return logInfo.size()>0?logInfo.get(0):null;
	}
	
	
	
	private void recordsOrderDoneAndPaymentDetails(com.jero.esc.po.saleinfo.OrderInfo  orderInfo){
		// 记录当前支付 操作明细
		Payinfo payinfo =new Payinfo();
		Date newDate = new Date();
		
		OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
		orderDoneDetails.setOddId(UUIDUtil.getUUID());
		orderDoneDetails.setLogId(orderInfo.getOrderBuyer());
			//将交易信息存为json数据存储
			payinfo.setLogId(orderInfo.getOrderBuyer());
			payinfo.setNonce_str("退款没有随机数");
			payinfo.setOrderId(orderInfo.getOrderId());
			payinfo.setOut_trade_no(orderInfo.getOrderNo());
			payinfo.setSign("退款属于平台内部，没有支付密钥，");
			payinfo.setTrade_type(4); // 贸易类型  1  支付宝 2 微信 3  银行卡 4 退款
			payinfo.setTransaction_id("退款操作暂时不产生新的 贸易id");
			String comment=JSONObject.toJSONString(payinfo);
		orderDoneDetails.setOddComment(comment);
		orderDoneDetails.setOddCreatetime(newDate);
		orderDoneDetails.setOddInfo(3);// 表示  支付状态    3代表  已经取消  表示订单已经申请退款了
		orderDoneDetails.setOddResult("退款成功");
		orderDoneDetails.setOrderId(orderInfo.getOrderId());
		orderDoneDetailsService.addOrderDoneDetail(orderDoneDetails);
		
		
		// 分别记录卖家或者买家的  相关支付信息
		//  买家    buyer
		AccontPaymentDetails buyerAccontPaymentDetails = new AccontPaymentDetails();
		buyerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
		buyerAccontPaymentDetails.setLogId(orderInfo.getOrderBuyer());
		buyerAccontPaymentDetails.setApdIotype(1);// 2表示支出  1表示收入
		buyerAccontPaymentDetails.setApdPaytype(4); // 1支付宝  ，2 微信 ， 3 银行卡 4  表示退款
		buyerAccontPaymentDetails.setApdCreatetime(newDate);
		buyerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
		buyerAccontPaymentDetails.setApdAdminorderno(orderInfo.getOrderNo());
		try {accountPaymentDetailsService.addAccountIODetails(buyerAccontPaymentDetails);} catch (Exception e) {e.printStackTrace();}
		
		// 卖家  seller
		/*AccontPaymentDetails sellerAccontPaymentDetails = new AccontPaymentDetails();
		sellerAccontPaymentDetails.setApdId(UUIDUtil.getUUID());
		sellerAccontPaymentDetails.setLogId(orderInfo.getOrderSeller());
		sellerAccontPaymentDetails.setApdIotype(2);// 2表示支出  1表示收入
		sellerAccontPaymentDetails.setApdPaytype(4); // 1支付宝  ，2 微信 ， 3 银行卡 4表示退款
		sellerAccontPaymentDetails.setApdCreatetime(newDate);
		sellerAccontPaymentDetails.setApdAmount(orderInfo.getOrderPrice());
		sellerAccontPaymentDetails.setApdAdminorderno(orderInfo.getOrderNo());
		try {accountPaymentDetailsService.addAccountIODetails(sellerAccontPaymentDetails);
		} catch (Exception e) {e.printStackTrace();}*/
	}

}
