package com.jero.esc.mapper.userinfo;

import com.jero.esc.po.userinfo.ServiceCollection;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface ServiceCollectionMapper {
    int deleteByPrimaryKey(String scolId);

    int insert(ServiceCollection record);

    int insertSelective(ServiceCollection record);

    ServiceCollection selectByPrimaryKey(String scolId);

    int updateByPrimaryKeySelective(ServiceCollection record);

    int updateByPrimaryKey(ServiceCollection record);

    List<ServiceCollection> selectByExample(ServiceCollection record);

    int countByExample(ServiceCollection record);

    List<ServiceCollection> selectByRequire(ServiceCollection serviceCollection,RowBounds rowBounds);

    int countByRequire(ServiceCollection serviceCollection);

}