package com.jero.esc.common.shiro.realms;

import com.jero.esc.mapper.shiro.ApptokenMapper;
import com.jero.esc.po.shiro.Apptoken;
import com.jero.esc.po.shiro.ApptokenExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

public class TokenDao {

    @Autowired
    CacheManager sss;

    @Autowired
    ApptokenMapper apptokenMapper;

    private  boolean useCache=true;


    public boolean isUseCache() {
        return useCache;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }

    private String cacheName="";

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    private Cache getCache() {
        Cache cache = sss.getCache(cacheName);
        return cache;
    }
    //检查token的时间
    private boolean  timeCheck(Apptoken apptoken){
        if(apptoken==null)return true;
        if (apptoken.getApptokenEndtime().getTime()<new Date().getTime()){
            apptokenMapper.deleteByPrimaryKey(apptoken.getApptokenId());
            return true;
        }
        return false;
    }








    //创建一个token
    public void create(Apptoken apptoken) {
        Apptoken take = null;

        try {
            List<Apptoken> apptokens = takeByLog(apptoken.getApptokenLog());
            for (Apptoken apptoken1 : apptokens) {
                delete(apptoken1.getApptokenId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //设置时间
        apptoken.setApptokenStarttime(new Date());
        apptoken.setApptokenEndtime(new Date(new Date().getTime()+1000*60*60*24*7));
        apptokenMapper.insertSelective(apptoken);

        if (useCache){
            Cache cache = getCache();
            cache.put(apptoken.getApptokenId(),apptoken);
        }
    }


    public List<Apptoken> takeByLog(String log){
        ApptokenExample apptokenExample = new ApptokenExample();
        apptokenExample.or().andApptokenLogEqualTo(log);
        List<Apptoken> apptokens = apptokenMapper.selectByExample(apptokenExample);
        return apptokens;
    }


    //通过tokenId得到
    public Apptoken take(String id) {
        Apptoken o =null;
        if (useCache){
            try {
                Cache cache = getCache();
                Cache.ValueWrapper valueWrapper = cache.get(id);
                o =valueWrapper==null?null:(Apptoken)valueWrapper.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (o==null){
            Apptoken apptoken = apptokenMapper.selectByPrimaryKey(id);
            if (timeCheck(apptoken))apptoken=null;
            else o=apptoken;
        }
        return o;
    }


    public void delete(String id) {
        if (useCache){
            try {
                Cache cache = getCache();
                cache.evict(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        apptokenMapper.deleteByPrimaryKey(id);
    }

    public  void  deleteByLog(String log){
        ApptokenExample apptokenExample = new ApptokenExample();
        apptokenExample.or().andApptokenLogEqualTo(log);
        apptokenMapper.deleteByExample(apptokenExample);
    }


    public String takeByCell(String cell){
        Cache cache = getCache();
        Cache.ValueWrapper valueWrapper = cache.get("cell:"+cell);
        if (valueWrapper!=null){
            String val= (String)valueWrapper.get();
            cache.evict("cell:"+cell);
            return val;
        }
        return null;
    }


    public  void putByCell(String cell,String value){
        Cache cache = getCache();
        cache.put("cell:"+cell,value);
    }



}
