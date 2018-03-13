package com.jero.esc.mapper.pay;


import java.util.List;

import com.jero.esc.po.pay.PayApi;
import org.springframework.data.repository.query.Param;

public interface PayApiMapper {

    int insertSelective(PayApi record);
    //通过条件查询支付方式
    List<PayApi> selectByCon(PayApi record);
    
    Integer countByCon(PayApi record);
    
    int delete(PayApi record);
    
    int updateSelective(PayApi record);

    PayApi selectByOrderAndType(@Param("tt") String tt, @Param("type")Integer type);
    
}