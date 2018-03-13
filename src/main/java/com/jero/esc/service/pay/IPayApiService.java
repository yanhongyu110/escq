package com.jero.esc.service.pay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.po.pay.PayApi;

public interface IPayApiService {
	
	public int addPay(PayApi record)throws Exception;
	
	public int modifyPay(PayApi record)throws Exception;
	
	public int delete(PayApi record)throws Exception;
	
	public int countByCon(PayApi record);
	
	public List<PayApi> queryByCon(PayApi record);
	
	public HashMap<String, JSONObject> queryObjByCon(PayApi record)throws Exception;
	
	public List<String> queryTypeByCon(PayApi record)throws Exception;

	public Map<String,String> getApiMap(String orderId,Integer type);


}
