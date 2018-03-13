package top.blazh.showdoc;


import net.sf.ehcache.Cache;

public class Cat {

    /**
     * 一级目录
     */
    private String name;

    /**
     * 二级目录
     */
    private String nameSub;

    private Cat(String name,String nameSub){this.name=name;this.nameSub=nameSub;}

    public static Cat build(String name,String nameSub){return new Cat(name,nameSub);}

    public static Cat build(String name){return build(name,null);}
    public static Cat build(){return build(null,null);}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }


}
