package com.jero.esc.service.impl.goodsinfo;

import com.jero.esc.common.utils.MD5Util;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.mapper.goodsinfo.ServiceToLoginfoMapper;
import com.jero.esc.po.goodsinfo.ServiceToLoginfo;
import com.jero.esc.service.goodsinfo.IServiceToLoginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceToLogService implements IServiceToLoginfoService{
    @Autowired
    private ServiceToLoginfoMapper serviceToLoginfoMapper;

    @Override
    @Transactional
    public Boolean insert(ServiceToLoginfo serverToLoginfo) {
        serverToLoginfo.setId(UUIDUtil.getUUID());
        int i = serviceToLoginfoMapper.insert(serverToLoginfo);
        return i > 0 ? true : false;
    }

    @Override
    @Transactional
    public Boolean deleteByLogIdAndServiceId(String logId, String serviceId) {
        int i = serviceToLoginfoMapper.deleteByLogIdAndServiceId(logId, serviceId);
        return i > 0 ? true : false;
    }

    @Override
    public Boolean select(ServiceToLoginfo serverToLoginfo) {
        List<ServiceToLoginfo> select = serviceToLoginfoMapper.select(serverToLoginfo);
        return (select != null && select.size() > 0) ? true : false;
    }
}
