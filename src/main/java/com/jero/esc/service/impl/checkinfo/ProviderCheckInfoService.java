
package com.jero.esc.service.impl.checkinfo;
import com.jero.esc.mapper.checkinfo.ProviderCheckInfoMapper;
import com.jero.esc.po.checkinfo.ProviderCheckInfo;
import com.jero.esc.service.checkinfo.IProviderCheckInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderCheckInfoService implements IProviderCheckInfoService{


	@Autowired
	ProviderCheckInfoMapper pci;


	@Override
	public Boolean add(ProviderCheckInfo record) {
		// TODO Auto-generated method stub
		return pci.insertSelective(record)>0;
	}


	@Override
	public ProviderCheckInfo quertById(String Id) {
		// TODO Auto-generated method stub
		return pci.selectByPrimaryKey(Id.toString());
	}


	@Override
	public Boolean modify(ProviderCheckInfo record) {
		// TODO Auto-generated method stub
		return pci.updateByPrimaryKeySelective(record)>0;
	}



	public Boolean delete(String Id) {
		// TODO Auto-generated method stub
		ProviderCheckInfo temp=new ProviderCheckInfo();
		temp.setPciId(Id.toString());
		temp.setPciState(2);
		return pci.updateByPrimaryKeySelective(temp)>0;
	}

	@Override
	public ProviderCheckInfo queryByLogId(String logId) {
		return pci.selectByLogId(logId.toString());
	}

	@Override
	public int queryByExample(ProviderCheckInfo record) {
		return pci.countByExample(record);
	}

	@Override
	public int countByLogId(String logId) {
		return pci.countByLogId(logId);
	}

}
