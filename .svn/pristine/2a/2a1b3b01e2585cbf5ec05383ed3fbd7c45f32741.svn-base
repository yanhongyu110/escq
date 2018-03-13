package com.jero.esc.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jero.esc.mapper.pay.PayApiMapper;

public class PayContainer {
	
	private  static HashMap<String, List<JSONObject>> container=new HashMap<String, List<JSONObject>>();
	@Autowired
	private PayApiMapper payApiMapper;
	
	public  List<JSONObject> getInstance(String COMP_ID) throws Exception{
		if(COMP_ID==null){
			throw new Exception("请输入正确的公司id");
		}
		if(container.get(COMP_ID)==null){
			try{
				System.out.println("开始装入支付方式");
				List<JSONObject> lj=new ArrayList<JSONObject>();
				//todo  创建 支付jsonObject
				container.put(COMP_ID, lj);
			}catch (Exception e){
				  e.printStackTrace();  
			}
		}
			return container.get(COMP_ID);
	};
	

}
