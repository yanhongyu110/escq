package com.jero.esc.service.impl.details;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jero.esc.common.utils.UUIDUtil;
import com.jero.esc.common.utils.exception.ExceptionWithMessage;
import com.jero.esc.mapper.details.PointPaymentDetailsMapper;
import com.jero.esc.po.details.PointPaymentDetails;
import com.jero.esc.po.userinfo.AccountInfo;
import com.jero.esc.service.details.IPointPaymentDetailsService;
import com.jero.esc.service.userinfo.IAccountInfoService;

@Service
public class PointPaymentDetailsService implements IPointPaymentDetailsService{
	
	@Autowired
	private PointPaymentDetailsMapper pointPaymentDetailsMapper;
	@Autowired
	private IAccountInfoService accountInfoService;

	@Override
	public Integer queryPointAmountById(String logId,String startTime,String endTime) {
		Integer comein = pointPaymentDetailsMapper.selectPointInAmountById(logId,startTime,endTime);
		Integer comeout = pointPaymentDetailsMapper.selectPointInAmountById(logId,startTime,endTime);
		return comein - comeout;
	}

	@Override
	public List<PointPaymentDetails> queryPointIOByIdYear(RowBounds rb,String logId, String startTime, String endTime) {
		return pointPaymentDetailsMapper.selectPointIOByIdYear(rb,logId, startTime, endTime);
	}

	@Override
	public List<PointPaymentDetails> queryPointIOByIdMonth(RowBounds rb,String logId, String startTime, String endTime) {
		return pointPaymentDetailsMapper.selectPointIOByIdMonth(rb,logId, startTime, endTime);
	}

	@Override
	public List<PointPaymentDetails> queryPointIOByIdDay(RowBounds rb,String logId, String startTime, String endTime) {
		return pointPaymentDetailsMapper.selectPointIOByIdDay(rb,logId, startTime, endTime);
	}

	@Override
	public HashMap<String, Object> queryPointIODetailsById(RowBounds rb,String logId,String startTime,String endTime) {
		List<AccountInfo> accList = accountInfoService.queryBalanceById(logId);
		List<PointPaymentDetails> ppdList =  pointPaymentDetailsMapper.selectPointIODetailsById(rb, logId, startTime, endTime);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("accList", accList);
		map.put("ppdList", ppdList);
		return map;
	}

	@Override
	public Integer queryPointIODetailsCountById(String logId,String startTime,String endTime) {
		return pointPaymentDetailsMapper.selectPointIODetailsCountById(logId,startTime,endTime);
	}

	@Override
	public Integer queryPointIOCountByIdYear(String logId, String startTime, String endTime) {
		return pointPaymentDetailsMapper.selectPointIOCountByIdYear(logId, startTime, endTime);
	}

	@Override
	public Integer queryPointIOCountByIdMonth(String logId, String startTime, String endTime) {
		return pointPaymentDetailsMapper.selectPointIOCountByIdMonth(logId, startTime, endTime);
	}

	@Override
	public Integer queryPointIOCountByIdDay(String logId, String startTime, String endTime) {
		return pointPaymentDetailsMapper.selectPointIOCountByIdDay(logId, startTime, endTime);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer addPointIODetails(PointPaymentDetails pointPaymentDetails) throws Exception {
		pointPaymentDetails.setPpdCreatetime(new Date());
		pointPaymentDetails.setPpdId(UUIDUtil.getUUID());
		Integer res = pointPaymentDetailsMapper.insertSelective(pointPaymentDetails);
		if(res>0){
			return res;
		}
		throw new ExceptionWithMessage("添加失败",null);
	}

}
