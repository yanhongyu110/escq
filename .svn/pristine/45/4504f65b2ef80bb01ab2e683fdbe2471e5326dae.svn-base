package com.jero.esc.service.goodsinfo;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.po.userinfo.ProviderCollection;
import com.jero.esc.po.userinfo.ServiceCollection;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * Created by blazh on 2016/12/9.
 */
public interface ICollectionService {

    /**
     *
     * 添加一个服务收藏
     * @param serviceCollection
     * @return
     */
    Boolean addServiceCollection(ServiceCollection serviceCollection)throws  Exception;

    /**
     * 添加一个服务商收藏
     * @param providerCollection
     * @return
     */
    Boolean addProviderCollection(ProviderCollection providerCollection)throws Exception;


    /**
     * 是否添加服务
     * @param serviceCollection
     * @return
     * @throws Exception
     */
    Boolean hasAddServiceCollection(ServiceCollection serviceCollection)throws Exception;

    /**
     * 是否添加服务商
     * @param providerCollection
     * @return
     * @throws Exception
     */
    Boolean hasAddProviderCollection(ProviderCollection providerCollection)throws Exception;


    /**
     * 查询搜藏
     * @param class0
     * @param <T>
     * @return
     */
    <T> FastPage<T> queryCollection(T obj,Map<String,String> require, RowBounds  rowBounds)throws  Exception;


    /**
     * 删除服务商搜藏
     * @param providerCollection
     * @return
     * @throws Exception
     */
    Boolean removeProviderCollectionById(ProviderCollection providerCollection)throws  Exception;


    /**
     * 删除服务搜藏
     * @param serviceCollection
     * @return
     * @throws Exception
     */
    Boolean removeServiceCollectionById(ServiceCollection serviceCollection)throws  Exception;

}
