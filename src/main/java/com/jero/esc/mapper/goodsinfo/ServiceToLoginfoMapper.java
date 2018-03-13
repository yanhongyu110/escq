package com.jero.esc.mapper.goodsinfo;

import com.jero.esc.po.goodsinfo.ServiceToLoginfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiceToLoginfoMapper {
    int insert(ServiceToLoginfo serverToLoginfo);

    int deleteByLogIdAndServiceId(@Param("logId")String logId, @Param("serviceId")String serviceId);

    List<ServiceToLoginfo> select(ServiceToLoginfo serverToLoginfo);
}
