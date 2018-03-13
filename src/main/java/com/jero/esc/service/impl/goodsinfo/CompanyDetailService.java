package com.jero.esc.service.impl.goodsinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.jero.esc.common.po.FastPage;
import com.jero.esc.common.po.PageRowBounds;
import com.jero.esc.mapper.pubinfo.CompanyDetailsMapper;
import com.jero.esc.service.goodsinfo.ICompanyDetailService;
import com.jero.esc.po.pubinfo.CompanyDetails;
@Service
public class CompanyDetailService implements ICompanyDetailService{
	
	@Autowired
	private CompanyDetailsMapper companyDetailsMapper;

	@Override
	public FastPage<CompanyDetails> queryCompanyByCon(
			CompanyDetails record, RowBounds rowBounds) throws Exception {
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CompanyDetailsMapper companyDetailsMapper = (CompanyDetailsMapper) ac.getBean("companyDetailsMapper");*/
		List<CompanyDetails> list = companyDetailsMapper.selectCompanyByCon(record, rowBounds);
    	Integer totalSize = companyDetailsMapper.countCompanyByCon(record);
    	FastPage<CompanyDetails> psage = new FastPage<CompanyDetails>(list, totalSize, (PageRowBounds)rowBounds);
        return psage;
	}

}
