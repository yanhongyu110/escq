package com.jero.esc.controller.appapi.saleinfo;

import com.alibaba.fastjson.JSON;
import com.jero.esc.common.annotation.NoRepeatRequest;
import com.jero.esc.common.appapi.AppBaseController;
import com.jero.esc.common.appapi.AppJsonResult;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.ConstUtil;
import com.jero.esc.common.utils.JsonUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.po.userinfo.AccountInfo;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.saleinfo.IOrderInfoBuyerService;
import com.jero.esc.vo.saleinfo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller("appOrderInfoBuyerController")
@RequestMapping("/appapi/saleinfo")
public class OrderInfoBuyerController extends AppBaseController{
	
	@Autowired
	private IOrderInfoBuyerService orderInfoBuyerService;


	/**
	 * 查询订单
	 * @param orderInfo 订单信息
	 * @param page 分页页数
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoBuyer/getAllOrder",method = RequestMethod.POST)
	public AppJsonResult getAllOrder(OrderInfo orderInfo, Integer page,Integer pageSize) throws Exception{
		LogInfo logInfo = log();
		orderInfo.setOrderBuyer(logInfo.getLogId());
		pageSize= 5;
		Integer totalNum = orderInfoBuyerService.totalNum(orderInfo);
		int no = (int) Math.ceil((double)totalNum/pageSize);
		if(page>no){
			page = page - 1;
		}
		List<OrderInfo> orderList = orderInfoBuyerService.selectAll(getPageRowBounds(page,pageSize), orderInfo);
		return AppJsonResult.success(new FastPage(orderList,totalNum,page,pageSize));
	}


	/**
	 *  跳转支付页面
	 *  @param id  支付的id
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoBuyer/getAccount",method =RequestMethod.POST )
	public AppJsonResult getAccount(String id) throws Exception{
		String logId = logId();
		AccountInfo selectBalanceById = orderInfoBuyerService.selectBalanceById(logId);
		OrderInfo orderInfo = orderInfoBuyerService.selectById(id);
		HashMap hashMap = new HashMap();
		hashMap.put("balance", selectBalanceById);
		hashMap.put("orderInfo", orderInfo);
		return  AppJsonResult.success(hashMap);
	}


	/**
	 * 是否设置支付密码
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoBuyer/shez",method = RequestMethod.POST)
	public AppJsonResult shez() throws Exception{
		String logId = logId();
		Boolean pass = orderInfoBuyerService.selectPass(logId);
		if(!pass){
			return AppJsonResult.error("请设置支付密码");
		} else {
			return  AppJsonResult.success();
		}
	}

	/**
	 *  付款
	 * @param flag
	 * @param orderPrice
	 * @param orderNo
	 * @param serviceTitle
	 * @param accountInfo
	 * @return
	 * @throws Exception
	 */
	@NoRepeatRequest
	@RequestMapping(value = "/orderInfoBuyer/validate",method = RequestMethod.POST)
	public AppJsonResult validate(Integer flag, String orderPrice, String orderNo, String serviceTitle, AccountInfo accountInfo) throws Exception{
		accountInfo.setLogId(logId());
		String accPaypass = accountInfo.getAccPaypass();
		if(accPaypass == null && "".equals(accPaypass))return  AppJsonResult.error("支付密码不能为空");
		try {
			return AppJsonResult.formJsonResult(  orderInfoBuyerService.validate(accountInfo, orderPrice, orderNo,flag,serviceTitle));
		} catch (ExceptionWithMessage e) {
			return  AppJsonResult.formJsonResult(e.jsonResult);
		}
	}


	/**
	 * 根据订单编号删除订单
	 * @param orderInfo 订单的json信息
	 * @return
	 * @throws Exception
	 */
	@NoRepeatRequest
	@RequestMapping(value = "/orderInfoBuyer/del",method = RequestMethod.POST)
	public AppJsonResult del(OrderInfo orderInfo) throws Exception{
		String orderNo = orderInfo.getOrderNo();
		try {
			return AppJsonResult.formJsonResult(orderInfoBuyerService.delete(orderNo));
		} catch (ExceptionWithMessage e) {
			return AppJsonResult.formJsonResult( e.jsonResult);
		}
	}

	/**
	 * 订单详情
	 * @param orderId 订单的id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoBuyer/details",method = RequestMethod.POST)
	public AppJsonResult details(String orderId) throws Exception{
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderId);
		String orderSeller = orderInfo.getOrderSeller();
		return  AppJsonResult.success(orderInfo);
	}


	/**
	 * 跳转到确认支付页面
	 * @param orderNo 订单编号
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoBuyer/ConfirmPayment",method = RequestMethod.POST)
	public AppJsonResult ConfirmPayment(String orderNo) throws Exception{
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		return AppJsonResult.success(orderInfo);
	}


	/**
	 * 买家申请退款
	 * @param orderJson 订单的json
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoBuyer/buyerApplyRefund",method = RequestMethod.POST)
	public AppJsonResult buyerApplyRefund(String orderJson) throws Exception{
		if (FastValid.isEmp(orderJson)) return  AppJsonResult.success("参数错误");
		OrderInfo orderInfo = JSON.parseObject(orderJson, OrderInfo.class);
		if(orderInfoBuyerService.modifyRefundMsgByOrderNo(orderInfo)>0) return  AppJsonResult.success();
		else return  AppJsonResult.error("退款失败");
	}

	/**
	 * 查看订单信息
	 * @param id 订单的id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoBuyer/queryState",method = RequestMethod.POST)
	public AppJsonResult queryState(String id) throws Exception{
		OrderInfo orderInfo = orderInfoBuyerService.selectById(id);
		return  AppJsonResult.success(orderInfo.getOrderRefundstate()>0);
	}


	/**
	 * 更新订单的的信息给
	 * @param orderId  订单的id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoBuyer/updateRefundStatusByOrderNo",method = RequestMethod.POST)
	public AppJsonResult updateRefundStatusByOrderNo(String orderId){
		try {
			 return AppJsonResult.formJsonResult( orderInfoBuyerService.updateRefundStatusByOrderNo(orderId));
		} catch (ExceptionWithMessage e) {
			return AppJsonResult.formJsonResult( e.jsonResult);
		}
	}
	
}
