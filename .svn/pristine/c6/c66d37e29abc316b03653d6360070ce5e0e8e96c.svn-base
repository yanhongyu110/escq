package com.jero.esc.mapper.userinfo;

import com.jero.esc.po.userinfo.ProviderCollection;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.po.userinfo.ServiceCollection;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ProviderCollectionMapper {
    int deleteByPrimaryKey(String pcId);

    int insert(ProviderCollection record);

    int insertSelective(ProviderCollection record);

    ProviderCollection selectByPrimaryKey(String pcId);

    int updateByPrimaryKeySelective(ProviderCollection record);

    int updateByPrimaryKey(ProviderCollection record);

    int countByExample(ProviderCollection providerInfo);


    List<ProviderCollection> selectByRequire(ProviderCollection providerCollection, RowBounds rowBounds);

    int countByRequire(ProviderCollection providerCollection);

}