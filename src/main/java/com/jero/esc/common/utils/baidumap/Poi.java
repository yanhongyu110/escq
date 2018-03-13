package com.jero.esc.common.utils.baidumap;

import org.apache.commons.codec.language.bm.Lang;

public class Poi{

    private Long id;//主键 添加自动生成
    private String ids;//多个主键   查询     ,隔开
    private String title;
    private  String address;
    private  String tags;
    private  Double latitude;
    private Double longitude;
    private Uint32 coord_type;
    private String geotable_id;
    private  String ak;
    private String sn;
    private String location;
    private Uint32 radius;//	检索半径;
    private  String sortby;//”分隔的多个检索条件。格式为sortby={key1}:value1|{key2:val2|key3:val3}。 最多支持16个字段排序 {keyname}:1 升序 {keyname}:-1 降序 以下keyname为系统预定义的： distance 距离排序 weight 权重排序
    private  String filter;//竖线分隔的多个key-value对key为筛选字段的名称(存储服务中定义) 支持连续区间或者离散区间的筛选： a:连续区间 key:value1,value2 b:离散区间 key:[value1,value2,value3,...]
    private Uint32 page_index;//当前页标，从0开始
    private  Uint32 page_size;//当前页面最大结果数
    private  String q;//检索关键字	string(45)	任意汉字或数字，英文字母，可以为空字符
    private  String region;//区域


    //自定义的列
    private String addr;
    private String img;
    private String brief;
    private  String provider;
    private  String com;


    //region Description

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Uint32 getRadius() {
        return radius;
    }

    public void setRadius(Uint32 radius) {
        this.radius = radius;
    }

    public String getSortby() {
        return sortby;
    }

    public void setSortby(String sortby) {
        this.sortby = sortby;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Uint32 getPage_index() {
        return page_index;
    }

    public void setPage_index(Uint32 page_index) {
        this.page_index = page_index;
    }

    public Uint32 getPage_size() {
        return page_size;
    }

    public void setPage_size(Uint32 page_size) {
        this.page_size = page_size;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }





    public    Poi(){}

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Uint32 getCoord_type() {
        return coord_type;
    }

    public void setCoord_type(Uint32 coord_type) {
        this.coord_type = coord_type;
    }

    public String getGeotable_id() {
        return geotable_id;
    }

    public void setGeotable_id(String geotable_id) {
        this.geotable_id = geotable_id;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
    //endregion+


}