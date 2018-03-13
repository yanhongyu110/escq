package com.jero.esc.service.impl.pay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jero.esc.common.EncryptPropertyPlaceholderConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.mapper.pay.PayApiMapper;
import com.jero.esc.po.pay.PayApi;
import com.jero.esc.service.pay.IPayApiService;
@Service
public class PayApiService implements IPayApiService {
	
	@Autowired
	private PayApiMapper payApiMapper;

	@Override
	public int addPay(PayApi record) throws Exception{
		// TODO Auto-generated method stub
		if(payApiMapper.countByCon(record)>0){
			throw new Exception("已存在相同数据，请不要重复插入");
		}
		return payApiMapper.insertSelective(record);
	}

	@Override
	public int modifyPay(PayApi record) throws Exception{
		// TODO Auto-generated method stub
		PayApi temp=new PayApi();
		temp.setPayType(record.getPayType());
		temp.setCompId(record.getCompId());
		if(!(payApiMapper.countByCon(temp)>0)){
			throw new Exception("无相关数据，请先进行添加");
		}
		return payApiMapper.updateSelective(record);
	}

	@Override
	public int delete(PayApi record) throws Exception{
		if(!(payApiMapper.countByCon(record)>0)){
			throw new Exception("无相关数据，不能删除");
		}
		return payApiMapper.delete(record);
	}

	@Override
	public int countByCon(PayApi record) {
		// TODO Auto-generated method stub
		return payApiMapper.countByCon(record);
	}

	
	public HashMap<String, JSONObject> queryObjByCon(PayApi record)throws Exception{
		// TODO Auto-generated method stub
		List<PayApi> lpa=payApiMapper.selectByCon(record);
		if(lpa.isEmpty()){
			throw new Exception("暂未添加数据");
		}
		HashMap<String,JSONObject> hij=new HashMap<String, JSONObject>();
		for (PayApi payapi : lpa) {
			hij.put(""+payapi.getPayType(), payapi.getPayObj());
		}
		return hij;
			
	}

	public List<String> queryTypeByCon(PayApi record)throws Exception{
		List<PayApi> lpa=payApiMapper.selectByCon(record);
		List<String> temp=new ArrayList<String>();
		if(lpa.isEmpty()){
			throw new Exception("暂未添加数据");
		}
		for (PayApi payapi : lpa) {
			temp.add(""+payapi.getPayType());
		}
		return temp;
	}


	@Override
	public Map<String, String> getApiMap(String orderId, Integer type) {
		PayApi payApi = payApiMapper.selectByOrderAndType(orderId, type);
		Map map = JSONObject.parseObject(EncryptPropertyPlaceholderConfigurer.AESDecode( payApi.getPayJson()), Map.class);
		return map;
	}


	@Override
	public List<PayApi> queryByCon(PayApi record) {
		// TODO Auto-generated method stub
		return payApiMapper.selectByCon(record);
	}
}
