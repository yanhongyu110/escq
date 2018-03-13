package com.jero.esc.common;

import com.jero.esc.mapper.bizinfo.CompanyInfoMapper;
import com.jero.esc.po.bizinfo.CompanyInfo;
import com.jero.esc.po.bizinfo.CompanyInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CompanyLoader {

    CompanyInfoMapper companyInfoMapper;

    //  初始化
    @Autowired
    public CompanyLoader(CompanyInfoMapper companyInfoMapper) {
        this.companyInfoMapper=companyInfoMapper;
        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.or().andCompIsdeleteEqualTo(false);
        List<CompanyInfo> companyInfos = companyInfoMapper.selectByExample(companyInfoExample);
        for (CompanyInfo companyInfo : companyInfos) {
            map.put(companyInfo.getCompId(),companyInfo);
            translae.put(companyInfo.getCompSite(),companyInfo.getCompId());
        }
    }

    private  static ConcurrentHashMap<String,CompanyInfo> map=new ConcurrentHashMap<String, CompanyInfo>();
    private  static ConcurrentHashMap<String,String> translae=new ConcurrentHashMap<String, String>();



    public  CompanyInfo takeCompany(String id){
//        while (true) {
//            synchronized (map){
//                if (map.containsKey(id)){
//                    return map.get(id);
//                }else {
                    CompanyInfo companyInfo = companyInfoMapper.selectByPrimaryKey(id);
//                    map.put(id,companyInfo);
                    return  companyInfo;
//                }
//            }
//        }
    }

    public CompanyInfo  takeCompanyBySite(String url){
        try {
            if (!translae.containsKey(url)){
                while (true) {
                    synchronized (map){
                        if (translae.containsKey(url)) break;
                        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
                        companyInfoExample.or().andCompSiteEqualTo(url.trim());
                        CompanyInfo companyInfo = companyInfoMapper.selectByExample(companyInfoExample).get(0);
                        map.put(companyInfo.getCompId(),companyInfo);
                        translae.put(companyInfo.getCompSite(),companyInfo.getCompId());
                        break;
                    }
                }
            }
            return map.get(translae.get(url));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

//    public  void putCompany(CompanyInfo company){
//        if (company!=null&&!StringUtils.isBlank(company.getCompSite())){
//            map.put(company.getCompSite(),company);
//        }
//    }




}
