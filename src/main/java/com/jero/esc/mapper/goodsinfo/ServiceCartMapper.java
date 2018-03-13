package com.jero.esc.mapper.goodsinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.po.goodsinfo.ServiceCart;
import com.jero.esc.vo.goodsinfo.CartVo;

public interface ServiceCartMapper {
    int deleteByPrimaryKey(String scartId);

    int insert(ServiceCart record);

    int insertSelective(ServiceCart record);

    ServiceCart selectByPrimaryKey(String scartId);

    int updateByPrimaryKeySelective(ServiceCart record);

    int updateByPrimaryKey(ServiceCart record);
    
    List<ServiceCart> seleteCartByLogId();
    
    //todo:
    List<ServiceCart> seleteCartByCon(ServiceCart record,RowBounds rowBounds);
    Integer countByCon(ServiceCart record);
    
    //每页的内容
    List<CartVo> seleteCartByRequire(CartVo record,RowBounds rowBounds);
    
    //总页数
    int countByRequire(CartVo record);
    

}