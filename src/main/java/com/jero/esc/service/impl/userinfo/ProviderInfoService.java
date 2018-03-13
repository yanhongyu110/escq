package com.jero.esc.service.impl.userinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jero.esc.common.utils.ArrayUtils;
import com.jero.esc.mapper.map.PointMapper;
import com.jero.esc.mapper.pubinfo.CommonTypeSaveMapper;
import com.jero.esc.mapper.userinfo.ProviderInfoMapper;
import com.jero.esc.po.map.Point;
import com.jero.esc.po.pubinfo.AdvertisePosition;
import com.jero.esc.po.pubinfo.CommonType;
import com.jero.esc.po.pubinfo.SwitchInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.service.goodsinfo.IServiceService;
import com.jero.esc.service.impl.pubinfo.CommonTypeService;
import com.jero.esc.service.pubinfo.IAdvertisePositionService;
import com.jero.esc.service.pubinfo.ISwitchInfoService;
import com.jero.esc.service.userinfo.IProviderInfoService;
import com.jero.esc.vo.goodsinfo.ServiceInfoVo;
import com.jero.esc.vo.userinfo.ProviderVo;
import com.jero.esc.vo.userinfo.ServiceVo;

@Service
public class ProviderInfoService implements IProviderInfoService{

	@Autowired
	private ProviderInfoMapper pim;
	@Autowired
	private PointMapper pointMapper;
	@Autowired
	private IServiceService serviceService;
	@Autowired
	private ISwitchInfoService switchInfoService;
	@Autowired
	private IAdvertisePositionService advertisePositionService;
	@Autowired
	private CommonTypeService commonTypeService;
	@Autowired
	private CommonTypeSaveMapper commonTypeSaveMapper;


	@Override
	public Boolean add(ProviderInfo record){
		// TODO Auto-generated method stub
		return (pim.insertSelective(record)>0);
	}


	@Override
	public ProviderInfo quertById(String Id) {
		// TODO Auto-generated method stub
		return pim.selectByPrimaryKey(Id.toString());
	}


	@Override
	public Boolean modify(ProviderInfo record) {
		// TODO Auto-generated method stub
		return (pim.updateByPrimaryKeySelective(record)>0);
	}
	
	@Override
	public Boolean delete(String Id) {
		// TODO Auto-generated method stub
		ProviderInfo temp=new ProviderInfo();
		temp.setPiId(Id.toString());
		temp.setPiIsdelete(false);
		return (pim.updateByPrimaryKeySelective(temp)>0);
	}
	@Override
	public ProviderInfo queryByLogId(String logId) {
		ProviderInfo pInfo=pim.selectByLogId(logId);
		 Point point=pointMapper.selectByLogId(logId);
	        if(pInfo!=null){
	        pInfo.setPoint(point);}
		return pInfo;
	}

	@Override
	public Integer countByExample(ProviderInfo record) {
		return pim.countByExample(record);
	}
	
	@Override
	public Integer countByLogId(String logId) {
		return pim.countByLogId(logId);
	}

	@Override
	public HashMap<String,Object> queryRecommendProvider(String serviceTypetree,String module,Integer siPos) {
		SwitchInfo switchInfo = new SwitchInfo();
		String commonType =commonTypeSaveMapper.selectByPrimaryKey(module).getSaveValue();
		JSONObject jso = JSONObject.parseObject(commonType);
		Object commonTypeList = new Object();
		if(jso!=null){
			commonTypeList =  jso.get("saveValue");
		}
		AdvertisePosition advertisePosition = new AdvertisePosition();
		advertisePosition.setApPosition("1");
		switchInfo.setSwitchPos(siPos);
		switchInfo.setCompany(module);
		List<SwitchInfo> siList = switchInfoService.queryPicByPosition(switchInfo);
		List<AdvertisePosition> adList = advertisePositionService.queryAdByPosition(advertisePosition);
		if(adList!=null&&adList.size()>0){
			JSONArray ja = JSONArray.parseArray(adList.get(0).getApImage());
			if(ja!=null){
				JSONObject jsono = JSONObject.parseObject(ja.getString(0));
				adList.get(0).setApCommnet(jsono.getString("url"));
			}
		}
		List<ServiceInfoVo> serList = serviceService.queryHomeServiceInfo(serviceTypetree,module);
		List<ServiceInfoVo> serList1 = new ArrayList<ServiceInfoVo>();
		List<ServiceInfoVo> serList2 = new ArrayList<ServiceInfoVo>();
		for (int i = 0; i < serList.size(); i++) {
			if(i<4){
				serList1.add(serList.get(i));
			}else{
				serList2.add(serList.get(i));
			}
		}
		RowBounds rowBounds=new RowBounds(0, 8);
		//查找模块 按约见次数排名的服务商   优先获取推荐的服务商（因项目暂时不用推荐功能 ，所以暂时先注释掉）
		//获取推荐服务商
		/*List<ProviderVo> proList1 =  pim.selectRecommendProvider(module);*/
		//按约见次数排名服务商
		List<ProviderVo> proList2 =  pim.selectProviderByOrder(rowBounds,"PI_MEETNUM DESC",module);
		List<ProviderVo> proList = new ArrayList<ProviderVo>();
		/*if(proList1.size()>0){
			for (int j = 0; j < proList1.size(); j++) {
				proList.add(proList1.get(j));
			}
		}else if(proList2.size()<8){*/
			for (int k = 0; k < proList2.size(); k++) {
				proList.add(proList2.get(k));
			}
		/*}else{
			for (int k = 0; k < 8; k++) {
				proList.add(proList2.get(k));
			}
		}*/
		JSONArray jsonarray = new JSONArray();
		if(siList!=null&&siList.size()>0){
			jsonarray = JSONArray.parseArray(siList.get(0).getSwitchImg());
		}
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("serList1", serList1);
		map.put("serList2", serList2);
		map.put("proList", proList);
		map.put("siList", jsonarray);
		map.put("adList", adList);
		map.put("commonTypeList", commonTypeList);
		return map;
	}


	@Override
	public List<ProviderVo> selectProviderByOrder(RowBounds rb,String com) {
		return pim.selectProviderByOrder(rb,"PI_MEETNUM DESC",com);
	}
	
	@Override
	public HashMap<String, Object> selectVideoByOrder(RowBounds rb,String order,String com) {
		List<ProviderVo> videoList = pim.selectProviderByOrder(rb,order,com);
		List<ProviderVo> videoList1 = new ArrayList<ProviderVo>();
		List<ProviderVo> videoList2 = new ArrayList<ProviderVo>();
		List<ProviderVo> videoList3 = new ArrayList<ProviderVo>();
		List<ProviderVo> videoList4 = new ArrayList<ProviderVo>();
		for (int i = 0; i < videoList.size(); i++) {
			if(i<=3){
				videoList1.add(videoList.get(i));
			}else if(i>=4&&i<=7){
				videoList2.add(videoList.get(i));
			}else if(i>=8&&i<=11){
				videoList3.add(videoList.get(i));
			}else if(i>=12&&i<=15){
				videoList4.add(videoList.get(i));
			}
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("videoList1", videoList1);
		map.put("videoList2", videoList2);
		map.put("videoList3", videoList3);
		map.put("videoList4", videoList4);
		return map;
	}
	
	@Override
	public Integer selectProviderCountByOrder(String com) {
		return pim.selectProviderCountByOrder(com);
	}

	@Override
	public List<ProviderVo> queryProviderByCon(RowBounds rb,String province, String city, String area,String order,String com) {
		List<ProviderVo> proList = pim.selectProviderByCon(rb, province, city, area,order,com);
		for (ProviderVo providerVo : proList) {
			JSONObject jsonObject = JSON.parseObject(providerVo.getPiRemark());
			if(jsonObject!=null){
				providerVo.setPiRek(Float.parseFloat(jsonObject.get("total").toString())/Float.parseFloat(jsonObject.get("count").toString()));
			}
		}
		return proList;
	}


	@Override
	public Integer queryProviderCountByCon(String province, String city, String area,String com) {
		return pim.selectProviderCountByCon(province, city, area,com);
	}


	@Override
	public List<ProviderVo> queryProviderBySearch(RowBounds rb, String search, String order,String province,String city, String area,String module) {
		return pim.selectProviderBySearch(rb, search, order, province, city ,area,module);
	}


	@Override
	public Integer queryProviderCountBySearch(String search, String order,String province,String city, String area,String com) {
		return pim.selectProviderCountBySearch(search, order, province, city ,area,com);
	}
	
	public List<ProviderVo> queryProviderRecommend(String com){
		return pim.selectRecommendProvider(com);
	}


	@Override
	public HashMap<String, Object> querySchoolProvider(List<CommonType> commonTypes) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		if(commonTypes!=null && commonTypes.size()>0){
			if(commonTypes.get(0)!=null){
				List<ServiceVo> serList1 = serviceService.queryServiceByModule(commonTypes.get(0).getCtId(), new RowBounds(0,3));
				map.put("serList1", serList1);
			}
			if(commonTypes.get(1)!=null){
				List<ServiceVo> serList2 = serviceService.queryServiceByModule(commonTypes.get(1).getCtId(), new RowBounds(0,4));
				map.put("serList2", serList2);
			}
			if(commonTypes.get(2)!=null){
				List<ServiceVo> serList3 = serviceService.queryServiceByModule(commonTypes.get(2).getCtId(), new RowBounds(0,30));
				List<List<ServiceVo>> lists = ArrayUtils.averageAssign(serList3, 3);
				map.put("serList3", lists);
			}
			if(commonTypes.get(3)!=null){
				List<ServiceVo> serList4 = serviceService.queryServiceByModule(commonTypes.get(3).getCtId(), new RowBounds(0,6));
				map.put("serList4", serList4);
			}
			if(commonTypes.get(4)!=null){
				List<ServiceVo> serList5 = serviceService.queryServiceByModule(commonTypes.get(4).getCtId(), new RowBounds(0,4));
				map.put("serList5", serList5);
			}
		}
		return map;
	}
}
