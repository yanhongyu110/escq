package com.jero.esc.controller.appapi.saleinfo;

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
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.service.saleinfo.IOrderInfoBuyerService;
import com.jero.esc.service.saleinfo.IOrderInfoSellerService;
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
import java.util.Map;

@Controller("appOrderInfoSellerController")
@RequestMapping(value = "/appapi/saleinfo")
public class OrderInfoSellerController extends AppBaseController {
	
	@Autowired
	private IOrderInfoSellerService orderInfoSellerService;
	
	@Autowired
	private IOrderInfoBuyerService orderInfoBuyerService;

	/**
	 * 查询订单
	 * @param pageSize 分页大小
	 * @param page 分页页数
	 * @param orderInfo 订单信息json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoSeller/queryOrder",method = RequestMethod.POST)
	public AppJsonResult queryOrder(Integer pageSize, Integer page, OrderInfo orderInfo) throws Exception{
		orderInfo.setOrderSeller(logId());
		List<OrderInfo> orderList = orderInfoSellerService.queryAllOrderInfo(getPageRowBounds(page, pageSize), orderInfo);
		Integer total = orderInfoSellerService.queryCount(orderInfo);
		return  AppJsonResult.success(new FastPage(orderList,total,page,pageSize));
	}


	/**
	 * 去除订单
	 * @param order 订单json
	 * @return
	 */
	@ResponseBody
	@NoRepeatRequest
	@RequestMapping(value = "/orderInfoSeller/removeOrder",method = RequestMethod.POST)
	public  AppJsonResult removeOrder(OrderInfo order) throws Exception{
		if(order == null)return  AppJsonResult.error("参数非法");
		if(order.getOrderId() == null)return  AppJsonResult.error("订单编号不能为空");
		return AppJsonResult.formJsonResult( orderInfoSellerService.removeOrderById(order));
	}


	/**
	 * 变更订单状态
	 * @param order 订单json
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@NoRepeatRequest
	@RequestMapping(value = "/orderInfoSeller/modifyOrderState",method = RequestMethod.POST)
	public AppJsonResult modifyOrderState(OrderInfo order) throws Exception{
		if(order == null)return  AppJsonResult.error("参数非法");
		if(order.getOrderId() == null)return  AppJsonResult.error("订单编号不能为空");
		return AppJsonResult.formJsonResult( orderInfoSellerService.modifyOrderState(order));
	}

	/**
	 * 订单详情
	 * @param orderId 订单id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoSeller/orderViewDetail",method = RequestMethod.POST)
	public AppJsonResult orderViewDetail(String orderId) throws Exception{
		OrderInfo order = orderInfoSellerService.selectOrderById(orderId);
		return  AppJsonResult.success(order);
	}

	/**
	 * 得到状态字符
	 * @param orderState 状态类型
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/orderInfoSeller/getStateStr",method = RequestMethod.POST)
	public AppJsonResult getStateStr(Integer orderState) throws Exception{
		Map<Integer,String> map = ConstUtil.ORDER_STATE_MAP;
		String stateStr = map.get(orderState);
		return  AppJsonResult.success(stateStr);
	}

	/**
	 * 跳转到卖家确认退款页面
	 * @param orderNo 订单编号
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/orderInfoSeller/viewExpertConfirm",method = RequestMethod.POST)
	public AppJsonResult viewExpertConfirm(String orderNo) throws Exception{
		OrderInfo orderInfo = orderInfoBuyerService.selectById(orderNo);
		String orderState = ConstUtil.ORDER_STATE_MAP.get(orderInfo.getOrderState());
		HashMap hashMap = new HashMap();
		hashMap.put("orderState",orderState);
		hashMap.put("orderInfo",orderInfo);
		return AppJsonResult.success(hashMap);
	}

	/**
	 * 专家退款确认
	 * @param json  订单json
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@NoRepeatRequest
	@RequestMapping(value = "/orderInfoSeller/refundConfirm",method = RequestMethod.POST)
	public AppJsonResult refundConfirm(String json) throws Exception{
		if (FastValid.isEmp(json)) return  AppJsonResult.error("参数错误");
		return  AppJsonResult.success(orderInfoSellerService.modifyRefundMsgByOrderNo(json)>0);
	}
}
