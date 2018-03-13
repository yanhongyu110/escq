package com.jero.esc.service.goodsinfo;

import com.jero.esc.po.goodsinfo.ServiceSnapshot;

/**
 * Created by blazh on 2016/12/12.
 */
public interface IServiceSnapshotService {


    /**
     * 添加快照
     * @return
     * @throws Exception
     */
    Boolean addSnapshot(ServiceSnapshot serviceSnapshot)throws  Exception;


    /**
     * 查询快照s
     * @param serviceSnapshot
     * @return
     * @throws Exception
     */
    ServiceSnapshot querySnapshot(ServiceSnapshot serviceSnapshot)throws  Exception;


    /**
     * 查询最近的快照
     * @param serviceId
     * @return
     * @throws Exception
     */
    public ServiceSnapshot queryLateByServiceId(String serviceId) throws Exception;

}
