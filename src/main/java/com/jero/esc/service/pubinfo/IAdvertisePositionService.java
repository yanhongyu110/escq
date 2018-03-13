package com.jero.esc.service.pubinfo;

import java.util.List;

import com.jero.esc.po.pubinfo.AdvertisePosition;

public interface IAdvertisePositionService {

	List<AdvertisePosition> queryAdByPosition(AdvertisePosition advertisePosition);
}
