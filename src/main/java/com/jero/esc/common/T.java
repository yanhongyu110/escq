package com.jero.esc.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jero.app.sign.Signature;
import com.jero.esc.common.utils.MD5Util;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.*;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T  {

    @Test
    public void  sss(){
        try {
            request(
                    "http://www.baidu.com",
                    new HashMap<String, Object>(){},
                    "get"
            ).getString("result");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, Object> para = new HashMap<String, Object>() {{
            put("name", "test");
            put("age", 11);
        }};
        Map<String, String> alfterSignature = Signature.signature("token", "secret", para);
        System.out.println(JSON.toJSONString(alfterSignature,true));
    }
    @Test
public  void tt()throws Exception{
        for (int j = 0; j <1 ; j++) {


        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    try {
                        logTest();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        }

        Thread.sleep(1000*30);

}

    @Test
    public void  logTest() throws Exception {

        //https://fxyrookie.tunnel.qydev.com/escq
        String path="https://fxyrookie.tunnel.qydev.com/escq";
        long time = new Date().getTime();
        //根据手机获得激活码
        final String checkcode = request(
                path+"/appapi/userinfo/sendMesToUser",
                new HashMap<String, Object>(){{
                    put("logCell","13330280232");
                }},
                "post"
        ).getString("result");

        System.out.println(new Date().getTime() - time);
        time=new Date().getTime();


        //登陆
        JSONObject logResult = request(
                path+"/appapi/userinfo/login",
                new HashMap<String, Object>(){{
                    put("admin","13330280232");
                    put("pass", MD5Util.getMD5("12345678"));
                    put("checkCode", checkcode);
                }},
                "post"
        ).getJSONObject("result");
        String token=logResult.getString("token");
        String secret=logResult.getString("secret");//获取secret在app端保存

        System.out.println(logResult);


        System.out.println(new Date().getTime() - time);
        time=new Date().getTime();



        //获取用户信息  isDianzan dianzan
        JSONObject jsonObject = request(
                path+"/appapi/goodsinfo/service/isDianzan",
                new HashMap<String, Object>(){{
                    put("serviceId","6565cf80936446dc92f552ef9561406e");
                   //put("aBoolean",true);
                }},//通过签名api加工参数
                "post"
        );


        System.out.println(jsonObject);
       // System.out.println(new Date().getTime() - time);

    }


    @Test
    public  void ttt1(){
        int i = tt11(
                new String[]{"abs", "sadsa", "asdsadsad", "dewe","edsdsd"}
        );
        System.out.println(i);
    }

    public  int tt11(String[] ss){
        for (int j = 1; j < ss.length; j++) {
            if (ss[j-1].charAt(ss[j-1].length() - 1) != ss[j].charAt(0)){
                return -1;
            }
        }
        return 1;
    }






    @Test
    public  void test() throws Exception {

        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("module","");

        treeMap.put("logCell","13452760513");

        String check = check("18883179781");

        //登陆
        JSONObject login = login("18883179781", "11111111",check);
        System.out.println(JSON.toJSONString(login));

//        treeMap.put("appid",login.getJSONObject("result").getString("appid"));
//
//        JSONObject jsonObject = request(
//                login,
//                "http://127.0.0.1:8080/appapi/userinfo/logout",
//                treeMap,
//                "get"
//        );

//        System.out.println(jsonObject);
//

        TreeMap<String, Object> stringObjectTreeMap = new TreeMap<>();
        stringObjectTreeMap.put("id","");

        JSONObject jsonObj1ect = request(
                "http://127.0.0.1:8080/appapi/pubinfo/getTree",
                stringObjectTreeMap,
                "post"
        );


        System.out.println(jsonObj1ect.toJSONString());
    }




    public JSONObject request(String url,Map treeMap,String method) throws Exception {

        List<org.apache.http.NameValuePair> nvps = new ArrayList<org.apache.http.NameValuePair>();

        for (Map.Entry<String, Object> stringStringEntry : ((Map<String,Object>)treeMap).entrySet()) {
            nvps.add(new BasicNameValuePair(stringStringEntry.getKey(),stringStringEntry.getValue().toString()));
        }




        String s1 = null;

        try {
            if (method.equals("get")){
                s1=Request.Get(url+"?"+URLEncodedUtils.format(nvps,Charsets.UTF_8)).execute().returnContent().asString(Charsets.UTF_8);
            }
            else{
                s1 =Request.Post(url).body(
                        new UrlEncodedFormEntity(nvps, HTTP.UTF_8)
                ).execute().returnContent().asString(Charsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return  JSON.parseObject(s1);
    }

    public  JSONObject login(String admin,String pass,String check) throws Exception {
        String s = Request.Post("http://localhost:8080/appapi/userinfo/login")
                .bodyForm(
                        new BasicNameValuePair("admin",admin),
                        new BasicNameValuePair("pass", MD5Util.getMD5(pass)),
                        new BasicNameValuePair("checkCode", check)
                )
                .execute().returnContent().asString(Charsets.UTF_8);
        JSONObject jsonObject = JSONObject.parseObject(s);
        return  jsonObject;
    }




    public String check(String cell) throws Exception {

        TreeMap<String, Object> stringStringTreeMap = new TreeMap<>();
        stringStringTreeMap.put("logCell",cell);

        String string = request(
                "http://127.0.0.1:8080/appapi/userinfo/sendMesToUser",
                stringStringTreeMap,
                "get"
        ).getString("result");


        return string;
    }











    /**
     * 下划线转驼峰法
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line,boolean smallCamel){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
    /**
     * 驼峰法转下划线
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern= Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
    }

    public static Connection getConnection(String name){
//        String url="jdbc:mysql://127.0.0.1:3306/"+name+"?useUnicode=true&amp;characterEncoding=UTF-8";

        String url="jdbc:mysql://127.0.0.1:3306/"+name+"?useUnicode=true&amp;characterEncoding=UTF-8&allowMultiQueries=true";
        String driverClassName="om.mysql.jdbc.Driver";
        String username="root";
//        String pass="root";
        String pass="root";
        Connection conn = null;
        DbUtils.loadDriver(driverClassName);
        try {
            conn = DriverManager.getConnection(url,username,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }



    public void   changCase(Document doc){

        try {
            Field tagName = Tag.class.getDeclaredField("tagName"); // Get the field which contains the tagname
            tagName.setAccessible(true); // Set accessible to allow changes

            for( Element element : doc.select("*") ) // Iterate over all tags
            {
                Tag tag = element.tag(); // Get the tag of the element
                String value = tagName.get(tag).toString(); // Get the value (= name) of the tag

                if( !value.startsWith("#") ) // You can ignore all tags starting with a '#'
                {
                    tagName.set(tag, value.toUpperCase()); // Set the tagname to the uppercase
                }
            }

            tagName.setAccessible(false); // Revert to false
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Test
    public  void 转移数据() throws SQLException {
        Connection connection = getConnection("escq");
        Connection connectionEscq = getConnection("escs");
        QueryRunner queryRunner = new QueryRunner();


        String formName="service_snapshot ".trim();
        String field="SERS_INFO ".trim();

        String querySql=String.format("SELECT * FROM `%s`",formName);
        String  updateSql="update %s set %s =? where %s=?";

        List query1 = (List) queryRunner.query(connection, "select COLUMN_NAME from information_schema.COLUMNS where table_name = '"+formName+"';", new ColumnListHandler());


        List<Map<String, Object>> query = queryRunner.query(connection,querySql , new MapListHandler());

        for (Map map : query) {
            String s = map.get(field).toString();
            s=s.replaceAll("/esc","");
            queryRunner.update(connection, String.format(updateSql, formName, field,query1.get(0)), s,map.get(query1.get(0)));
        }
    }



    public  void chang(String base,String tableName) throws IOException {
        List<String> hasChangeBean=new ArrayList<String>();

        String property =path+"com/jero/esc/mapper/"+base;
        File file1 = new File(property);
        Parser parser = Parser.xmlParser();
//        parser.settings(ParseSettings.preserveCase);
        Document parse =parser.parseInput(FileUtils.readFileToString(file1, "utf-8"), "");


//        Document parse =Jsoup.parse(FileUtils.readFileToString(file1, "utf-8"), "");

        System.out.println(parse.html());

        Elements select = parse.select("resultMap");
        for (int i = 0; i < select.size(); i++) {
            Element element = select.get(i);
            String html = element.html();
            Elements result = element.select("result");
            result.get(result.size()-1).after(String.format("<result column=\"%s\" jdbcType=\"%s\" property=\"%s\" />",dataFeild,jdbcType,javaFeild));

            String type = element.attr("type");
            String beanPath=path+type.replaceAll("[.]","/")+".java";
            if (!hasChangeBean.contains(beanPath)&&beanPath.toLowerCase().contains(tableName.toLowerCase())){
                File file = new File(beanPath);
                String s = FileUtils.readFileToString(file, "utf-8");
                String format = String.format("    private  " + javaType + " "+javaFeild+";\n" +
                        "    public "+javaType+" " + getFiled + "() {\n" +
                        "        return "+javaFeild+";\n" +
                        "    }\n" +
                        "    public void " + setFiled + "(" + javaType + " "+javaFeild+") {\n" +
                        "        this."+javaFeild+" = "+javaFeild+";\n" +
                        "    }");
                String substring = s.substring(0, s.lastIndexOf("}") )+format+"\r\n}";
                FileUtils.writeByteArrayToFile(file,substring.getBytes("utf-8"));
                hasChangeBean.add(beanPath);
            }
        }

        //
        Elements select1 = parse.select("sql[id=Base_Column_List]");
        for (int i = 0; i < select1.size(); i++) {
            Element element = select1.get(i);
            element.html(element.html()+","+dataFeild);
        }

        //
        Element element = parse.select("insert[id=insert]").get(0);
        String html = element.html();
        String d=html.substring(0,html.indexOf(")"))+","+dataFeild+html.substring(html.indexOf(")"),html.length());
        d=d.substring(0,d.lastIndexOf(")"))+",#{"+javaFeild+"})";
        element.html(d);


        //
        element = parse.select("insert[id=insertSelective]").get(0);
        element.select("trim").get(0).append("      <if test=\""+javaFeild+" != null\">\n" +
                "        "+dataFeild+",\n" +
                "      </if>");
        element.select("trim").get(1).append("     <if test=\""+javaFeild+" != null\">\n" +
                "        #{"+javaFeild+"},\n" +
                "      </if>");



        //
        element = parse.select("update[id=updateByPrimaryKey]").get(0);
        html=element.html();
        d=html.substring(0,html.indexOf("where"))+",\t\t"+dataFeild+" = #{"+javaFeild+"}     "+html.substring(html.indexOf("where"),html.length());
        element.html(d);



        element = parse.select("update[id=updateByPrimaryKeySelective]").get(0);
        element.select("set").get(0).append("      <if test=\""+javaFeild+" != null\">\n" +
                "        "+dataFeild+" = #{"+javaFeild+"},\n" +
                "      </if>");


        String html1 = parse.html();
//        html1="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n"+html1;
        FileUtils.writeByteArrayToFile(file1,html1.getBytes("utf-8"));


    }


    String dataFeild="COMPANY";
    String javaFeild=underline2Camel(dataFeild,true);
    String jdbcType="VARCHAR";
    String javaType="String";
    String getFiled="get"+String.valueOf(javaFeild.charAt(0)).toUpperCase()+javaFeild.substring(1,javaFeild.length());
    String setFiled="set"+String.valueOf(javaFeild.charAt(0)).toUpperCase()+javaFeild.substring(1,javaFeild.length());
    String path=System.getProperty("user.dir").replaceAll("\\\\","/")+"/src/main/java/";


    @Test
    public  void  表列表增加() throws SQLException, IOException {
        Connection connection = getConnection("escs");
        QueryRunner queryRunner = new QueryRunner();



        String updateSql="alter table `%s` add "+dataFeild+" VARCHAR(50) ";

        String list="admin_info\n" +
                "common_type\n" +
                "common_type_save\n" +
                "log_info\n" +
                "order_info\n" +
                "switch_info\n" +
                "system_megs";

        String[] split = list.split("\n");


//        File[] files = new File(path + "com/jero/esc/mapper").listFiles();
//        for (File file : files) {
//            String name = file.getName();
//            for (File file1 : file.listFiles()) {
//                String name1 = file1.getName();
//                if (name1.endsWith(".xml")){
//                    String mapper = name1.substring(0, name1.indexOf("Mapper"));
//                    for (String s : split) {
//                        if (mapper.toLowerCase().equals(s.trim().replaceAll("_","").toLowerCase())){
//                            chang(name+"/"+name1,mapper);
//                        }
//                    }
//                }
//            }
//        }
//


        for (String ss : split) {

            if (ss.trim()==null||ss.trim().equals(""))
                continue;
            try {
                if(queryRunner.update(connection, String.format(updateSql, ss))<1){
                    throw  new RuntimeException("添加出错");
                }
            }catch (RuntimeException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }






    @Test
    public  void 批量删除() throws SQLException {
        Connection connection = getConnection("escq");
        List<String> list =  Arrays.asList(new String[]{"admin_info","common_type","common_type_save"});
        String formName="escq";
        QueryRunner queryRunner = new QueryRunner();

        String delStr="DELETE FROM %s";

        List<String> query1 = (List) queryRunner.query(connection, "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '"+formName+"';", new ColumnListHandler());

        for (String s : query1) {
            if (!s.startsWith("sys_")&&!list.contains(s)){
                int update = queryRunner.update(connection, String.format(delStr, s));
            }
        }





    }






}
