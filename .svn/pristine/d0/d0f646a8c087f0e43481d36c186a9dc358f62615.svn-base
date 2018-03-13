package com.jero.esc.mapper.pubinfo;

import com.jero.esc.po.pubinfo.CompanyDetails;
import com.jero.esc.po.pubinfo.CompanyDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CompanyDetailsMapper {
	
	int countCompanyByCon(CompanyDetails record);
	
	List<CompanyDetails> selectCompanyByCon(CompanyDetails record,RowBounds rowBounds);
	
    int countByExample(CompanyDetailsExample example);

    int deleteByExample(CompanyDetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(CompanyDetails record);

    int insertSelective(CompanyDetails record);

    List<CompanyDetails> selectByExampleWithBLOBs(CompanyDetailsExample example);

    List<CompanyDetails> selectByExample(CompanyDetailsExample example);

    CompanyDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CompanyDetails record, @Param("example") CompanyDetailsExample example);

    int updateByExampleWithBLOBs(@Param("record") CompanyDetails record, @Param("example") CompanyDetailsExample example);

    int updateByExample(@Param("record") CompanyDetails record, @Param("example") CompanyDetailsExample example);

    int updateByPrimaryKeySelective(CompanyDetails record);

    int updateByPrimaryKeyWithBLOBs(CompanyDetails record);

    int updateByPrimaryKey(CompanyDetails record);
}