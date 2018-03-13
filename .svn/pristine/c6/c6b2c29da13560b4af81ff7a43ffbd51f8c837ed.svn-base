package com.jero.esc.service.impl.goodsinfo;

import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.common.utils.fastvalidate.FastValidateType;
import com.jero.esc.mapper.goodsinfo.ServiceSnapshotMapper;
import com.jero.esc.po.goodsinfo.ServiceSnapshot;
import com.jero.esc.service.goodsinfo.IServiceSnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by blazh on 2016/12/12.
 */
@Service
public class ServiceSnapshotService  implements IServiceSnapshotService{

    @Autowired
    private ServiceSnapshotMapper serviceSnapshotMapper;

    /**
     * 添加快照
     *
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addSnapshot(ServiceSnapshot serviceSnapshot) throws Exception {
        if (FastValid.isEmp(serviceSnapshot.getSersPerprice(),serviceSnapshot.getSersPrice(),serviceSnapshot.getSersInfo())||!FastValid.matches(serviceSnapshot.getSersInfo(), FastValidateType.JSON)){
            throw  new ExceptionWithMessage("参数错误",null);
        }
        serviceSnapshot.setSersId(UUIDUtil.getUUID());
        serviceSnapshot.setSersCreatetime(new Date());
        serviceSnapshotMapper.insertSelective(serviceSnapshot);
        return true;
    }

    /**
     * 查询快照
     *
     * @param serviceSnapshot
     * @return
     * @throws Exception
     */
    @Override
    public ServiceSnapshot querySnapshot(ServiceSnapshot serviceSnapshot) throws Exception {
        return null;
    }

    /**
     * 查询最近的快照
     *
     * @param serviceId
     * @return
     * @throws Exception
     */
    @Override
    public ServiceSnapshot queryLateByServiceId(String serviceId) throws Exception {
        return serviceSnapshotMapper.selectLateByServiceId(serviceId);
    }


}
