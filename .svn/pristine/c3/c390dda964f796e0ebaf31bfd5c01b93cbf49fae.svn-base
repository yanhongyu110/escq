package com.jero.esc.service.goodsinfo;

import com.jero.esc.po.goodsinfo.ServiceToLoginfo;

import java.util.List;

public interface IServiceToLoginfoService {
    /**
     * 点赞
     * @param serverToLoginfo
     * @return
     */
    Boolean insert(ServiceToLoginfo serverToLoginfo);

    /**
     * 取消点赞
     * @param logId
     * @param serviceId
     * @return
     */
    Boolean deleteByLogIdAndServiceId(String logId, String serviceId);

    /*
     * 判断是否点赞
     */
    Boolean select(ServiceToLoginfo serverToLoginfo);
}
