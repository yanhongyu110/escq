package com.jero.esc.service.impl.checkinfo;

import com.jero.esc.common.po.JsonResult;
import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.baidumap.Poi;
import com.jero.esc.common.utils.fastvalidate.FastValid;
import com.jero.esc.mapper.checkinfo.PersonChecknameMapper;
import com.jero.esc.mapper.map.PointMapper;
import com.jero.esc.mapper.userinfo.UserInfoMapper;
import com.jero.esc.po.checkinfo.PersonCheckname;
import com.jero.esc.po.checkinfo.ProviderCheckInfo;
import com.jero.esc.po.map.Point;
import com.jero.esc.po.userinfo.LogInfo;
import com.jero.esc.po.userinfo.ProviderInfo;
import com.jero.esc.po.userinfo.UserInfo;
import com.jero.esc.service.checkinfo.IProviderCheckInfoService;
import com.jero.esc.service.checkinfo.IProviderCheckManageService;
import com.jero.esc.service.map.IMapService;
import com.jero.esc.service.userinfo.IProviderInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fxy on 2016/12/8.
 */
@Service
public class ProviderCheckManageService implements IProviderCheckManageService{


    @Autowired
    private IProviderInfoService providerInfoService;
    @Autowired
    private IProviderCheckInfoService providerCheckInfoService;
    @Autowired
    private IMapService mapService;
    @Autowired
    private PointMapper pointMapper;
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private PersonChecknameMapper personChecknameMapper;
    

    @Override
    @Transactional(rollbackFor=Exception.class)
    public Boolean addCheck(ProviderInfo providerInfo, ProviderCheckInfo providerCheckInfo) {

        //添加远程point
        //验证
        if(FastValid.isEmp(providerInfo.getPoint(),providerInfo.getPoint().getPointLat(),providerInfo.getPoint().getPointLng())){
            throw new   RuntimeException("sas");
        }
        Point point = providerInfo.getPoint();
        point.setPointId(UUIDUtil.getUUID());
        point.setPointProvider(providerInfo.getLogId());
        int i = pointMapper.insertSelective(point);
        Boolean add = providerInfoService.add(providerInfo);
        Boolean add1 = providerCheckInfoService.add(providerCheckInfo);
    	//取消实名认证  添加至服务商认证中  
  		//添加认证信息时，将实名放入实名认证信息表（person_checkname）、用户信息表（user_info）
  		UserInfo userInfo=new UserInfo();
  		userInfo.setLogId(providerInfo.getLogId());
  		userInfo.setUserRealname(providerInfo.getPiRealname());
  		Integer res1=userInfoMapper.updateByLogIdSelective(userInfo);
  		PersonCheckname personCheckname=new PersonCheckname();
  		personCheckname.setLogId(providerInfo.getLogId());
  		personCheckname.setPcnRelname(providerInfo.getPiRealname());
  		Integer res2=personChecknameMapper.updateByLogIdSelective(personCheckname);
        if (!add||!add1||i<=0||res1<=0||res2<=0){
            throw  new RuntimeException();
        }
        return  !(!add||!add1||i<=0);
    }
    @Override
    @Transactional(rollbackFor=Exception.class)
    public Boolean modifyCheck(ProviderInfo providerInfo, ProviderCheckInfo providerCheckInfo) throws Exception {
    	ProviderCheckInfo checkInfo=providerCheckInfoService.queryByLogId(providerCheckInfo.getLogId());
    	//取消实名认证  添加至服务商认证中  
  		//修改认证信息时，将实名信息修改  实名认证表（person_checkname）、用户信息表（user_info）
  		UserInfo userInfo=new UserInfo();
  		userInfo.setLogId(providerInfo.getLogId());
  		userInfo.setUserRealname(providerInfo.getPiRealname());
  		Integer res1=userInfoMapper.updateByLogIdSelective(userInfo);
  		PersonCheckname personCheckname=new PersonCheckname();
  		personCheckname.setLogId(providerInfo.getLogId());
  		personCheckname.setPcnRelname(providerInfo.getPiRealname());
  		Integer res2=personChecknameMapper.updateByLogIdSelective(personCheckname);
    	Boolean temp=false;
    	if(checkInfo.getPciState()==2){
    		temp=providerInfoService.modify(providerInfo)&providerCheckInfoService.modify(providerCheckInfo)&&mapService.updatePoiByProvider(providerInfo.getLogId());
    	}else{
    		temp=providerInfoService.modify(providerInfo)&providerCheckInfoService.modify(providerCheckInfo);
    	}
        return  temp;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public JsonResult queryProviderInfoByLogId(String logId) {
    	ProviderInfo pInfo=new ProviderInfo();
        pInfo=providerInfoService.queryByLogId(logId);
        Point point=pointMapper.selectByLogId(logId);
        if(pInfo!=null){
        pInfo.setPoint(point);}
        JsonResult jResult=new JsonResult();
        if(pInfo==null){
        	jResult.setSuccess(false);
        	jResult.setErrorCode("请输入基本信息");
        	jResult.setObj(null);
        }else{
        	jResult.setSuccess(true);
        	jResult.setErrorCode("请修改基本信息");
        	jResult.setObj(pInfo);
        }
        return jResult;
    }


    @Override
    @Transactional(rollbackFor=Exception.class)
    public JsonResult queryProviderCheckInfoByLogId(String logId) {
        ProviderCheckInfo pInfo=new ProviderCheckInfo();
        pInfo=providerCheckInfoService.queryByLogId(logId);
        JsonResult jResult=new JsonResult();
        if(pInfo==null){
        	jResult.setSuccess(false);
        	jResult.setErrorCode("请输入认证信息");
        	jResult.setObj(null);
        }else{
        	jResult.setSuccess(true);
        	jResult.setErrorCode("请修改认证信息");
        	jResult.setObj(pInfo);
        }
        return jResult;
    }



}