package com.jero.esc.service.impl.goodsinfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.mapper.goodsinfo.ServiceInfoMapper;
import com.jero.esc.mapper.userinfo.ProviderCollectionMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.mapper.userinfo.ServiceCollectionMapper;
import com.jero.esc.po.goodsinfo.ServiceInfo;
import com.jero.esc.po.userinfo.ProviderCollection;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.po.userinfo.ServiceCollection;
import com.jero.esc.service.goodsinfo.ICollectionService;

/**
 * Created by blazh on 2016/12/9.
 */
@Service
public class CollectionService implements ICollectionService {


    @Autowired
    ServiceCollectionMapper serviceCollectionMapper;

    @Autowired
    ProviderCollectionMapper providerCollectionMapper;

    @Autowired
    ServiceInfoMapper serviceInfoMapper;

    @Autowired
    ProviderInfoMapper providerInfoMapper;

    /**
     * 添加一个服务收藏
     *
     * @param serviceCollection
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addServiceCollection(ServiceCollection serviceCollection)throws  Exception {

        //验证合法性
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.setServiceId(serviceCollection.getServiceId());
        if (FastValid.isEmp(serviceCollection.getLogId(),serviceCollection.getServiceId())||serviceInfoMapper.countByExample(serviceInfo)<=0||this.hasAddServiceCollection(serviceCollection)){
            throw  new ExceptionWithMessage("添加参数不合法",null);
        }

        //补充数据
        serviceCollection.setScolId(UUIDUtil.getUUID());
        serviceCollection.setScolIsdelete(false);
        serviceCollection.setScolCreatetime(new Date());

        return serviceCollectionMapper.insertSelective(serviceCollection)>0;
    }

    /**
     * 添加一个服务商收藏
     *
     * @param providerCollection
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addProviderCollection(ProviderCollection providerCollection) throws  Exception{

        //验证合法性
        ProviderInfo providerInfo = new ProviderInfo();
        providerInfo.setLogId(providerCollection.getPcPid());
        if (FastValid.isEmp(providerCollection.getLogId(),providerCollection.getPcPid())||providerInfoMapper.countByExample(providerInfo)<=0||this.hasAddProviderCollection(providerCollection)){
            throw  new ExceptionWithMessage("添加参数不合法",null);
        }

        //补充数据
        providerCollection.setPcId(UUIDUtil.getUUID());
        providerCollection.setPcIsdelete(false);
        providerCollection.setPcCreatetime(new Date());

        return providerCollectionMapper.insertSelective(providerCollection)>0;
    }

    /**
     * 是否添加服务
     * @param serviceCollection
     * @return
     * @throws Exception
     */
    @Override
    public Boolean hasAddServiceCollection(ServiceCollection serviceCollection) throws Exception {
        int i = serviceCollectionMapper.countByExample(serviceCollection);
        return  i>0;
    }

    /**
     * 是否添加服务商
     * @param providerCollection
     * @return
     * @throws Exception
     */
    @Override
    public Boolean hasAddProviderCollection(ProviderCollection providerCollection) throws Exception {
        int i = providerCollectionMapper.countByExample(providerCollection);
        return  i>0;
    }

    /**
     * @param require
     * @param rowBounds
     */
    @Override
    public <T> FastPage<T> queryCollection(T obj,Map<String, String> require, RowBounds rowBounds) throws Exception {
        FastPage<T> fastPage=null;
        HashMap<String, String> map = new HashMap<String, String>();
        String title=require.get("title");
        String name=require.get("name");
        if (!FastValid.isEmp(title)){
            map.put("titile",title);
        }
        if (!FastValid.isEmp(name)){
            map.put("name",name);
        }
        if (obj instanceof  ServiceCollection){
            ServiceCollection ss= (ServiceCollection) obj;
            ss.setBox(map);
            List serviceCollections = serviceCollectionMapper.selectByRequire(ss, rowBounds);
            fastPage=new FastPage<T>(serviceCollections,serviceCollectionMapper.countByRequire(ss), (PageRowBounds) rowBounds);
        }else if (obj instanceof  ProviderCollection){
            ProviderCollection ss= (ProviderCollection) obj;
            ss.setBox(map);
            List providerCollections = providerCollectionMapper.selectByRequire(ss, rowBounds);
            fastPage=new FastPage<T>(providerCollections,providerCollectionMapper.countByRequire(ss), (PageRowBounds) rowBounds);
        }
        return fastPage;
    }

    /**
     * 删除服务商搜藏
     *
     * @param providerCollection
     * @return
     * @throws Exception
     */
    @Override
    public Boolean removeProviderCollectionById(ProviderCollection providerCollection) throws Exception {

        //验证合法性
        ProviderInfo providerInfo = new ProviderInfo();
        providerInfo.setLogId(providerCollection.getPcPid());
        if (FastValid.isEmp(providerCollection.getPcId(),providerCollection.getLogId(),providerCollection.getPcPid())||providerInfoMapper.countByExample(providerInfo)<=0||!this.hasAddProviderCollection(providerCollection)){
            throw  new ExceptionWithMessage("添加参数不合法",null);
        }

        ProviderCollection providerCollection1 = providerCollectionMapper.selectByPrimaryKey(providerCollection.getPcId());
        providerCollection1.setPcIsdelete(true);
        return  providerCollectionMapper.updateByPrimaryKeySelective(providerCollection1)==1;
    }

    /**
     * 删除服务搜藏
     *
     * @param serviceCollection
     * @return
     * @throws Exception
     */
    @Override
    public Boolean removeServiceCollectionById(ServiceCollection serviceCollection) throws Exception {

        //验证合法性
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.setServiceId(serviceCollection.getServiceId());
        if (FastValid.isEmp(serviceCollection.getScolId(),serviceCollection.getLogId(),serviceCollection.getServiceId())||serviceInfoMapper.countByExample(serviceInfo)<=0||!this.hasAddServiceCollection(serviceCollection)){
            throw  new ExceptionWithMessage("添加参数不合法",null);
        }

        ServiceCollection serviceCollection1 = serviceCollectionMapper.selectByPrimaryKey(serviceCollection.getScolId());
        return serviceCollectionMapper.updateByPrimaryKeySelective(serviceCollection1)==1;
    }


}
