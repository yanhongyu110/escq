package com.jero.esc.service.checkinfo;

import com.jero.esc.po.checkinfo.ProviderCheckInfo;


public interface IProviderCheckInfoService {

	Boolean add(ProviderCheckInfo record);

	ProviderCheckInfo quertById(String Id);

	Boolean modify(ProviderCheckInfo record);

	Boolean delete(String Id);

	ProviderCheckInfo queryByLogId(String logId);

	int queryByExample(ProviderCheckInfo record);

	int countByLogId(String logId);
}
