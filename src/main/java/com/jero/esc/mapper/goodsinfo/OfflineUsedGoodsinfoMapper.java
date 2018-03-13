package com.jero.esc.mapper.goodsinfo;

import com.jero.esc.po.goodsinfo.OfflineUsedGoodsinfo;

public interface OfflineUsedGoodsinfoMapper {
    int deleteByPrimaryKey(String ougId);

    int insert(OfflineUsedGoodsinfo record);

    int insertSelective(OfflineUsedGoodsinfo record);

    OfflineUsedGoodsinfo selectByPrimaryKey(String ougId);

    int updateByPrimaryKeySelective(OfflineUsedGoodsinfo record);

    int updateByPrimaryKey(OfflineUsedGoodsinfo record);
}