package com.jero.esc.mapper.pubinfo;

import com.jero.esc.po.pubinfo.AllMeta;
import com.jero.esc.po.pubinfo.AllMetaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllMetaMapper {
    int countByExample(AllMetaExample example);

    int deleteByExample(AllMetaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AllMeta record);

    int insertSelective(AllMeta record);

    List<AllMeta> selectByExample(AllMetaExample example);

    AllMeta selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AllMeta record, @Param("example") AllMetaExample example);

    int updateByExample(@Param("record") AllMeta record, @Param("example") AllMetaExample example);

    int updateByPrimaryKeySelective(AllMeta record);

    int updateByPrimaryKey(AllMeta record);
}