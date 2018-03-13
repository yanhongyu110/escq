package com.jero.esc.service.impl.goodsinfo;

import com.alibaba.fastjson.JSONArray;
import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.mapper.goodsinfo.ServiceCartMapper;
import com.jero.esc.po.details.PriceSet;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.po.goodsinfo.ServiceSnapshot;
import com.jero.esc.service.goodsinfo.ICartService;
import com.jero.esc.service.goodsinfo.IServiceService;
import com.jero.esc.service.goodsinfo.IServiceSnapshotService;
import com.jero.esc.vo.goodsinfo.CartVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by blazh on 2016/12/18.
 */

@Service
public class CartService implements ICartService {

	
	@Autowired
	ServiceCartMapper serviceCartMapper ;
	
	@Autowired
	IServiceSnapshotService serviceSnapshotService;
    @Autowired
    IServiceService serviceService;
	
    /**
     * 通过用户ID查询所有条件的购物车
     * @return
     * @throws Exception
     *
     */
    @Override
    public FastPage<CartVo> queryCartByLogId(CartVo cart,RowBounds rowBounds) throws Exception {
    	
    	List<CartVo> list = serviceCartMapper.seleteCartByRequire(cart, rowBounds);
    	Integer totalSize = serviceCartMapper.countByRequire(cart);
    	FastPage<CartVo> psage = new FastPage<CartVo>(list, totalSize, (PageRowBounds)rowBounds);
        return psage;
    }
    
    /**
     * 通过用户ID添加购物车
     * @return
     * @throws Exception
     */
	@Transactional(rollbackFor=Exception.class)
    @Override
    public Boolean addCartByLogId(String serviceId,String logId,String scartSource,Integer scartNum,String scartComment) throws Exception {		
		if(isExitCart(serviceId, logId, scartSource)){
			throw new Exception("已加入收藏");
		}
		ServiceCart servicecart = new ServiceCart();
		servicecart.setScartId(UUIDUtil.getUUID());
		servicecart.setServiceId(serviceId);

		ServiceSnapshot ssid = serviceSnapshotService.queryLateByServiceId(serviceId);
		List<PriceSet> priceSetList = JSONArray.parseArray( ssid.getSersPrice(), PriceSet.class);
		for (PriceSet priceSet : priceSetList) {
			if(priceSet.getPsetDiscountType().toString().equals(scartSource)){
				servicecart.setScartPrice(priceSet.getPsetPrice());
				servicecart.setScartPoint(priceSet.getPsetPoint());
			}
		}
		
		
		servicecart.setSsId(ssid.getSersId());
		servicecart.setLogId(logId);
		servicecart.setScartSource(scartSource);
		servicecart.setScartCreatetime(new Date());
		servicecart.setScartIsdelete(false);
		servicecart.setScartNum(scartNum);
		servicecart.setScartComment(scartComment);
		
        return serviceCartMapper.insertSelective(servicecart) > 0&serviceService.updateServiceCollectNum(serviceId,true);
    }
	
	
    @Override
	public Boolean isExitCart(String serviceId, String logId, String scartSource) {
    	ServiceCart record = new ServiceCart();
    	record.setServiceId(serviceId);
    	record.setLogId(logId);
		record.setScartIsdelete(false);
    	record.setScartSource(scartSource);
		return serviceCartMapper.countByCon(record) > 0;
	}
    
    
	/**
     * 通过ID伪删除购物车
     * @param cartId
     * @return
     */
	@Transactional(rollbackFor=Exception.class)
    @Override
    public Boolean removeCartById(String scartId,String logId) {
		
		if( logId==null && scartId==null){
			return false;
		}
		ServiceCart temp=serviceCartMapper.selectByPrimaryKey(scartId);
		ServiceCart servicecart = new ServiceCart();
		servicecart.setScartId(scartId);
		servicecart.setLogId(logId);
		servicecart.setScartIsdelete(true);
        return serviceCartMapper.updateByPrimaryKeySelective(servicecart)>0&serviceService.updateServiceCollectNum(temp.getServiceId(),false);
    }



    /**
     * 通过条件查询所有条件的购物车
     * @return
     * @throws Exception
     */
	@Override
	public FastPage<ServiceCart> queryCartByCon(ServiceCart record, RowBounds rowBounds) throws Exception {
		List<ServiceCart> list = serviceCartMapper.seleteCartByCon(record, rowBounds);
    	Integer totalSize = serviceCartMapper.countByCon(record);
    	FastPage<ServiceCart> psage = new FastPage<ServiceCart>(list, totalSize, (PageRowBounds)rowBounds);
        return psage;
	}

	
}
