package com.jero.esc.service.impl.saleinfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.controller.BaseController;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.utils.OrdersNum;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.utils.fastvalidate.FastValidate;
import com.jero.esc.common.utils.fastvalidate.ValidateResult;
import com.jero.esc.mapper.details.OrderDoneDetailsMapper;
import com.jero.esc.mapper.details.PriceSetMapper;
import com.jero.esc.mapper.goodsinfo.ServiceCartMapper;
import com.jero.esc.mapper.goodsinfo.ServiceInfoMapper;
import com.jero.esc.mapper.goodsinfo.ServiceStepMapper;
import com.jero.esc.mapper.saleinfo.OrderInfoBuyerMapper;
import com.jero.esc.mapper.saleinfo.OrderInfoMapper;
import com.jero.esc.mapper.saleinfo.OrderServiceMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.details.OrderDoneDetails;
import com.jero.esc.po.details.PriceSet;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.goodsinfo.ServiceSnapshot;
import com.jero.esc.po.goodsinfo.ServiceStep;
import com.jero.esc.po.saleinfo.OrderInfo;
import com.jero.esc.po.saleinfo.OrderService;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.service.goodsinfo.IServiceSnapshotService;
import com.jero.esc.service.saleinfo.IOrderBeforeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OrderBeforeService implements IOrderBeforeService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    ServiceInfoMapper serviceInfoMapper;

    @Autowired
    IServiceSnapshotService serviceSnapshotService;

    @Autowired
    OrderServiceMapper orderServiceMapper;

    @Autowired
    ServiceStepMapper serviceStepMapper;

    @Autowired
    ServiceCartMapper serviceCartMapper;

    @Autowired
    OrderDoneDetailsMapper orderDoneDetailsMapper;
    
    @Autowired
    PriceSetMapper priceSetMapper;

    @Autowired
    ProviderInfoMapper providerInfoMapper;
    
    @Autowired
	private OrderInfoBuyerMapper OrderInfoBuyerMapper;

    //region 得到价格列表确定并且提取出需要的价格
    private void priceSetter(OrderService orderService, ServiceSnapshot serviceSnapshot) throws Exception {

        if (FastValid.isEmp(orderService, serviceSnapshot, orderService.getOsSource())) {
            throw new ExceptionWithMessage("确定价格出错");
        }

        JSONArray.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        List<PriceSet> json = JSONArray.parseArray(serviceSnapshot.getSersPrice(),PriceSet.class);
        JSONArray.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        
        int ii = 0;
        for (PriceSet priceSet : json) {
        	//这里改成了String.valueOf(priceSet.getPsetDiscountType())
            if (String.valueOf(priceSet.getPsetDiscountType()).equals(orderService.getOsSource())) {
                orderService.setOsPrice(priceSet.getPsetPrice()*orderService.getOsGoodsNum());
                orderService.setOsPoint(priceSet.getPsetPoint()*orderService.getOsGoodsNum());
                break;
            }
            ii++;
        }
        if (ii >= json.size()) {
            throw new ExceptionWithMessage("没有找到价格", null);
        }
    }
    //endregion

    //region 根据订单商品计算总价
    private void setPricePointByOrderServices(OrderInfo orderInfo, List<OrderService> orderServices) {
        //orderInfo.setOrderPoint(0f);
        orderInfo.setOrderPrice(0f);
        for (OrderService orderService : orderServices) {
            orderInfo.setOrderPrice(orderInfo.getOrderPrice() + orderService.getOsPrice() * orderService.getOsGoodsNum());
            //orderInfo.setOrderPoint(orderInfo.getOrderPoint() + orderService.getOsPoint() * orderService.getOsGoodsNum());
        }
    }
    //endregion

    //region 取消订单

    /**
     * 取消订单
     *
     * @param orderInfo
     * @return
     * @throws Exception
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean cancelOrder(String orderNo) throws Exception {
    	Integer state = OrderInfoBuyerMapper.updateState(orderNo, 3);
    	if(state > 0){
    		return true;
    	}

        return false;
    }
    //endregion

    //region 刷新订单生成体

    /**
     * 刷新订单生成体
     *
     * @throws Exception
     */
    @Override
    public void flashMaker(List<ServiceCart> carts) throws Exception {
        //region 方法体
        for (int i = 0; i < carts.size(); i++) {
            ServiceInfo serviceInfo = serviceInfoMapper.selectByPrimaryKey(carts.get(i).getServiceId());
            //得到价格和积分并且填入
            PriceSet priceBySource = priceSetMapper.selectPriceSetBySource(carts.get(i).getServiceId(), Integer.parseInt(carts.get(i).getScartSource()));
            carts.get(i).setScartPrice(priceBySource.getPsetPrice());
            carts.get(i).setScartPoint(priceBySource.getPsetPoint());
            carts.get(i).setBox(serviceInfo);
        }
        //endregion
    }
    //endregion

    
    
 

    /**
     * 添加订单
     *
     * @param orderInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addOrder(OrderInfo orderInfo, OrderService orderService) throws Exception {

        //region 验证
        if (BaseController.isValidate) {

            //验证开始
            if (FastValid.isEmp(orderService.getOsAttrs(), orderService.getOsGoodsNum())) {
                throw new ExceptionWithMessage("验证失败", null);
            }

            FastValidate fastValidate = new FastValidate(orderInfo);
            fastValidate.setReqiureList("orderSeller,orderBuyer,orderMeettime,orderPerson,orderPersoncell,orderArea,orderAddr,orderIsbill", true);
            ValidateResult validateResult = fastValidate.validateObject();
            if (!validateResult.validate) {
                throw new ExceptionWithMessage("验证失败", validateResult.list);
            }

            //是否填写完了发票相关
            if (orderInfo.getOrderIsbill()) {
                fastValidate.setReqiureList("orderBilladdr,orderBillcontent", true);
                ValidateResult validateResult1 = fastValidate.validateObject();
                if (!validateResult1.validate) {
                    throw new ExceptionWithMessage("发票相关失败", validateResult1.list);
                }
            }

        }
        //endregion

        //region 重新获取
        //查询服务的快照
        ServiceSnapshot serviceSnapshot = serviceSnapshotService.queryLateByServiceId(orderService.getBox().toString());
        //endregion

        //region 属性相关
        //拿到前台传来的属性选择
        String serviceAttrinfo = orderService.getOsAttrs();
        Map<String, String> map = JSONObject.parseObject(serviceAttrinfo, Map.class);
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            // TODO: 2016/12/18 属性检测
        }
        //endregion

        //region 完善订单信息
        orderInfo.setOrderNo(UUIDUtil.getUUID());
        orderInfo.setOrderCreatetime(new Date());
        orderInfo.setOrderState(0);
        //endregion

        //region 订单商品并完成并添加
        orderService.setOsId(UUIDUtil.getUUID());
        orderService.setOrderId(orderInfo.getOrderId());
        orderService.setSersId(serviceSnapshot.getSersId());
        orderService.setSsId(serviceStepMapper.selectIdListByServiceId(orderService.getBox().toString()).get(0));// TODO: 2016/12/18
        //endregion

        //region 价格处理
        //得到价格列表确定并且提取出需要的价格
        priceSetter(orderService, serviceSnapshot);
        //添加订单的总价分
        orderInfo.setOrderPrice(orderService.getOsPrice());
        orderInfo.setOrderPoint(orderService.getOsPoint());
        //endregion

        //region 数据库处理
        int i = orderServiceMapper.insertSelective(orderService);
        int i1 = orderInfoMapper.insertSelective(orderInfo);
        //endregion

        return i > 0 && i1 > 0;
    }


    //region 从订单生成体添加
    /**
     * 从订单生成体添加
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addOrderFromCart(OrderInfo orderInfo, List<ServiceCart> list) throws Exception {

        //region 验证
        if (BaseController.isValidate) {

            //验证开始
            FastValidate fastValidate = new FastValidate(orderInfo);
            fastValidate.setReqiureList("orderSeller,orderBuyer,orderMeettime,orderPerson,orderPersoncell,orderArea,orderAddr,orderIsbill", true);
            ValidateResult validateResult = fastValidate.validateObject();
            if (!validateResult.validate) {
                throw new ExceptionWithMessage("验证失败", validateResult.list);
            }

            //是否填写完了发票相关
            if (orderInfo.getOrderIsbill()) {
                fastValidate.setReqiureList("orderBilladdr,orderBillcontent", true);
                ValidateResult validateResult1 = fastValidate.validateObject();
                if (!validateResult1.validate) {
                    throw new ExceptionWithMessage("发票相关失败", validateResult1.list);
                }
            }

        }
        //endregion

        //region 初始化一个订单并且完成一些参数
        orderInfo.setOrderId(UUIDUtil.getUUID());
        orderInfo.setOrderCreatetime(new Date());
        orderInfo.setOrderNo(OrdersNum.getOrderNo());
        orderInfo.setOrderState(0);
        //订单退款状态
        orderInfo.setOrderRefundstate(0);
        //这里给订单的价格和积分初始化,防止出错
        orderInfo.setOrderPrice(0F);
        orderInfo.setOrderPoint(0F);
        //endregion

        //region 循环创建订单商品并且添加
        for (ServiceCart _serviceCart : list) {
            //查询购物车
            ServiceInfo serviceCart = serviceInfoMapper.selectByPrimaryKey(_serviceCart.getServiceId());
            OrderService orderService = new OrderService();
            orderService.setOsId(UUIDUtil.getUUID());
            orderService.setOrderId(orderInfo.getOrderId());
            //通过ServiceId查询服务快照
            ServiceSnapshot serviceSnapshot = serviceSnapshotService.queryLateByServiceId(serviceCart.getServiceId());
            orderService.setSersId(serviceSnapshot.getSersId());
            orderService.setSsId(serviceSnapshot.getSersId());
            orderService.setOsSetps(serviceSnapshot.getSersPerprice());
             
            //这里将原来的Integer转换为Float
            orderService.setOsGoodsNum(Float.valueOf(_serviceCart.getScartNum()));
            orderService.setOsSource(_serviceCart.getScartSource());

            // TODO: 2016/12/21

            //得到价格列表确定并且提取出需要的价格
            priceSetter(orderService, serviceSnapshot);
            //统计入订单
            orderInfo.setOrderPrice(orderInfo.getOrderPrice() + orderService.getOsPrice());
            orderInfo.setOrderPoint(orderInfo.getOrderPoint() + orderService.getOsPoint());
            //新增订单商品
            System.err.println(orderService.getOsSource());
                    
            int i = orderServiceMapper.insertSelective(orderService);

            if (i <= 0) {
                throw new ExceptionWithMessage("添加失败", null);
            }

            //region 商品的参数添加等
            serviceCart.setServiceMeetnum(serviceCart.getServiceMeetnum()+1);
            serviceInfoMapper.updateByPrimaryKeySelective(serviceCart);
            //endregion

            //region 服务商的自动参数添加
            ProviderInfo providerInfo = providerInfoMapper.selectByLogId(serviceCart.getLogId());
            providerInfo.setPiMeetnum(providerInfo.getPiMeetnum()==null?0:providerInfo.getPiMeetnum()+1);
            providerInfoMapper.updateByPrimaryKeySelective(providerInfo);
            //endregion

        }
        //endregion

        //region 添加订单的操作明细
        OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
        orderDoneDetails.setLogId(orderInfo.getOrderBuyer());
        orderDoneDetails.setOddCreatetime(new Date());
        orderDoneDetails.setOddId(UUIDUtil.getUUID());
        orderDoneDetails.setOrderId(orderInfo.getOrderId());
        orderDoneDetails.setOddInfo(0);
        orderDoneDetailsMapper.insertSelective(orderDoneDetails);
        //endregion

        //添加约见信息
        return orderInfoMapper.insertSelective(orderInfo) > 0;
    }
    //endregion

    //region 根据条件查询

    /**
     * 根据条件查询
     *
     * @param orderInfo
     * @param require
     * @return
     */
    @Override
    public FastPage<OrderInfo> queryOrderByRequire(OrderInfo orderInfo, Map<String, String> require) throws Exception {
    	
        //region 验证
        if (BaseController.isValidate) {
            FastValidate fastValidate = new FastValidate(orderInfo);
            fastValidate.setReqiureList("", true);
            ValidateResult validateResult = fastValidate.validateObject();
            if (!validateResult.validate) {
                throw new ExceptionWithMessage("发票相关失败", validateResult.list);
            }
        }
        //endregion

        return null;
    }
    //endregion

    //region 服务商确认
    /**
     * 服务商确认
     *
     * @param orderInfo
     * @return
     */
    @Override
    public Boolean providerCheck(OrderInfo orderInfo) throws Exception {

        //region 验证
        if (BaseController.isValidate) {
            //验证开始
            FastValidate fastValidate = new FastValidate(orderInfo);
            fastValidate.setReqiureList("orderId,orderSeller,box", true);
            ValidateResult validateResult = fastValidate.validateObject(true);
            if (!validateResult.validate || orderInfo.getBox() == null || !(orderInfo.getBox() instanceof Boolean)) {
                throw new ExceptionWithMessage("内容不对", validateResult.list);
            }
            //验证是否拥有这条订单
            OrderInfo orderInfo1 = orderInfoMapper.selectByPrimaryKey(orderInfo.getOrderId());
            if (!orderInfo1.getOrderSeller().equals(orderInfo.getOrderSeller()) || orderInfo1.getOrderState() != 0) {
                throw new ExceptionWithMessage("非法操作");
            }
            //验证订单商品
            for (OrderService orderService : orderInfo.getOrderService()) {
                OrderService orderService1 = orderServiceMapper.selectByPrimaryKey(orderService.getOsId());
                if (orderInfo1 == null || !orderService1.getOrderId().equals(orderInfo.getOrderId()) || orderService.getOsPrice() == null /*|| orderService.getOsPoint() == null || orderService.getOsPoint() < 0*/ || orderService.getOsPrice() < 0 || orderService.getOsGoodsNum() == null || orderService.getOsGoodsNum() < 0) {
                    throw new ExceptionWithMessage("非法操作");
                }
            }
        }
        //endregion


        orderInfo.setOrderConfirmtime(new Date());
       

        //region 根据服务商的确认与否更改订单状态
        if ((Boolean) orderInfo.getBox()) {
            orderInfo.setOrderState(2);

            OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
            orderDoneDetails.setOddId(UUIDUtil.getUUID());
            orderDoneDetails.setLogId(orderInfo.getOrderSeller());
            orderDoneDetails.setOddCreatetime(new Date());
            orderDoneDetails.setOrderId(orderInfo.getOrderId());
            orderDoneDetails.setOddInfo(2);
            orderDoneDetailsMapper.insertSelective(orderDoneDetails);

        } else {
            orderInfo.setOrderState(1);
            
            //region 修改订单商品价格与阶段
            setPricePointByOrderServices(orderInfo, orderInfo.getOrderService());
            for (OrderService orderService : orderInfo.getOrderService()) {

                //参数阻拦
                orderService.setOsSource(null);
                orderService.setOrderId(null);
                orderService.setSsId(null);
                orderService.setOsAttrs(null);
                orderService.setOsComment(null);


                //如果有自定义阶段修改
                if (orderService.getOsSetps() != null) {
                    List<ServiceStep> jieDuan = orderService.getJieDuan();
                    float totalPrice=0f;
                    float totalPoint=0f;
                    int i=0;
                    for (ServiceStep serviceStep : jieDuan) {
                        if (FastValid.isEmp(serviceStep.getSsName(), serviceStep.getSsDescribe(), serviceStep.getSsPrice(), serviceStep.getSsSort())) {
                            throw new ExceptionWithMessage("自定义阶段有误");
                        }
                        totalPrice+=JSONObject.parseObject(serviceStep.getSsPrice()).getFloat("price");
                        totalPoint+=JSONObject.parseObject(serviceStep.getSsPrice()).getFloat("point");
                        i++;
                        if(serviceStep.getSsSort()!=i){
                            throw new ExceptionWithMessage("自定义阶段顺序有误");
                        }
                    }
                    if (totalPrice!=orderInfo.getOrderPrice()||totalPoint!=orderInfo.getOrderPoint()||i!=jieDuan.size()){
                        throw new ExceptionWithMessage("自定义阶段价格不同步");
                    }
                }


                if (orderServiceMapper.updateByPrimaryKeySelective(orderService) <= 0) {
                    throw new ExceptionWithMessage("订单商品更新错误");
                }
            }
            //endregion

            OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
            orderDoneDetails.setOddId(UUIDUtil.getUUID());
            orderDoneDetails.setLogId(orderInfo.getOrderSeller());
            orderDoneDetails.setOddCreatetime(new Date());
            orderDoneDetails.setOrderId(orderInfo.getOrderId());
            orderDoneDetails.setOddInfo(1);
            orderDoneDetailsMapper.insertSelective(orderDoneDetails);

        }
        //endregion

         orderInfoMapper.updateByPrimaryKeySelective(orderInfo) ;

        Double avgTime = orderInfoMapper.getAvgTime(orderInfo.getOrderSeller());
        Pattern compile = Pattern.compile("(\\d*?)[.]\\d*");
        Matcher matcher = compile.matcher(avgTime + "");
        while (matcher.find()){
            String group = matcher.group(1);
            ProviderInfo providerInfo = providerInfoMapper.selectByLogId(orderInfo.getOrderSeller());
            providerInfo.setPiResponsetime(Integer.parseInt(group));
            providerInfoMapper.updateByPrimaryKeySelective(providerInfo);
        }

        return  true;


    }
    //endregion

    //region 用户修改

    /**
     * 用户修改
     *
     * @param orderInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean userModify(OrderInfo orderInfo) throws Exception {

        //region 验证
        if (BaseController.isValidate) {

            //验证是否拥有这条订单
            OrderInfo orderInfo1 = orderInfoMapper.selectByPrimaryKey(orderInfo.getOrderId());
            if (!orderInfo1.getOrderBuyer().equals(orderInfo.getOrderBuyer()) || orderInfo1.getOrderState() != 1) {
                throw new ExceptionWithMessage("非法操作");
            }

            FastValidate fastValidate = new FastValidate(orderInfo);
            fastValidate.setReqiureList("orderSeller,orderBuyer,orderMeettime,orderPerson,orderPersoncell,orderArea,orderAddr,orderIsbill", true);
            ValidateResult validateResult = fastValidate.validateObject();
            if (!validateResult.validate) {
                throw new ExceptionWithMessage("验证失败", validateResult.list);
            }

            //是否填写完了发票相关
            if (orderInfo.getOrderIsbill()) {
                fastValidate.setReqiureList("orderBilladdr,orderBillcontent", true);
                ValidateResult validateResult1 = fastValidate.validateObject();
                if (!validateResult1.validate) {
                    throw new ExceptionWithMessage("发票相关失败", validateResult1.list);
                }
            }

        }
        //endregion

        //更改状态
        orderInfo.setOrderState(0);

        //region 添加订单的操作明细
        OrderDoneDetails orderDoneDetails = new OrderDoneDetails();
        orderDoneDetails.setOddId(UUIDUtil.getUUID());
        orderDoneDetails.setLogId(orderInfo.getOrderBuyer());
        orderDoneDetails.setOddCreatetime(new Date());
        orderDoneDetails.setOrderId(orderInfo.getOrderId());
        orderDoneDetails.setOddInfo(0);
        orderDoneDetailsMapper.insertSelective(orderDoneDetails);
        //endregion


        return orderInfoMapper.updateByPrimaryKeySelective(orderInfo) > 0;
    }
    //endregion

    //region 根据order修改

    /**
     * 根据order修改
     *
     * @param orderInfo
     * @return
     */
    @Override
    public Boolean modifyByOrder(OrderInfo orderInfo) throws Exception {

        //region 验证
        OrderInfo re = new OrderInfo();
        if (BaseController.isValidate) {
            FastValidate<OrderInfo> orderInfoFastValidate = new FastValidate<OrderInfo>(orderInfo);
            orderInfoFastValidate.setReqiureList("orderId", true);
            ValidateResult<OrderInfo> validateResult = orderInfoFastValidate.validateObject();
            if (!validateResult.validate) {
                throw new ExceptionWithMessage("验证失败", validateResult.list);
            }
            //是否填写完了发票相关
            if (orderInfo.getOrderIsbill() != null && orderInfo.getOrderIsbill()) {
                orderInfoFastValidate.setReqiureList("orderBilladdr,orderBillcontent", true);
                ValidateResult<OrderInfo> orderInfoValidateResult = orderInfoFastValidate.validateObject();
                if (!orderInfoValidateResult.validate) {
                    throw new ExceptionWithMessage("发票相关失败", orderInfoValidateResult.list);
                }
            }
            //拿到的只剩验证的
            re = validateResult.getModelValid();
            
        }
        //endregion

        return userModify(re);
    }
    //endregion

    //region 删除order

    /**
     * 删除order
     *
     * @param id
     * @return
     */
    @Override
    public Boolean removeById(String id) throws Exception {
        return null;
    }
    //endregion

}
