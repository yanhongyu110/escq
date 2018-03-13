package top.blazh.showdoc;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Ctl {

    private static Logger log= LoggerFactory.getLogger(Ctl.class);




    public static void main(String[] args) throws ClassNotFoundException {


        List<Class<?>> classes = ClassUtill.getClasses("com.jero.esc.controller.appapi");

        for (Class<?> aClass : classes) {
            System.out.println(aClass.getName());
            System.out.println(aClass.getName().replaceAll("\\.appapi", ""));
        }






        if (1==1){
            return;
        }


        Ctl build = Ctl.build(Connector.build("www.blazh.top:4999", "b06c4e1737af5a287e27afb986a79207567351799", "0697325e8328187e340262cadb4be9fa1475130910"));
        build.cd("第一级")
                .push(Page.build(
                        "你好哈哈哈哈哈啊",
                        99,
                        "#asdasdasdasdasdasdasd"
                ));



    }


    private Connector connector;

    private Cat cat=Cat.build();

    private Ctl(){}

    private Ctl(Connector connector){
        this.connector= connector;
    }


    public static Ctl build(Connector connector){
        return  new Ctl(connector);
    }

    public Ctl cd(String name, String nameSub){
        cat.setName(name);
        cat.setNameSub(nameSub);
        return this;
    }

    public Ctl cd(String name){
        cat.setName(name);
        cat.setNameSub(null);
        return this;
    }

    public Ctl back(){
        if (cat.getNameSub()!=null){
            cat.setNameSub(null);
        }else if (cat.getName()!=null){
            cat.setName(null);
        }
        return this;
    }

    public Ctl push(Page page){
        try {

            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("api_key", connector.getKey()));
            formparams.add(new BasicNameValuePair("api_token", connector.getToken()));
            formparams.add(new BasicNameValuePair("cat_name", cat.getName()));
            formparams.add( new BasicNameValuePair("cat_name_sub", cat.getNameSub()));
            formparams.add( new BasicNameValuePair("page_title", page.getTitle()));
            formparams.add( new BasicNameValuePair("page_content", page.getContent()));
            formparams.add( new BasicNameValuePair("s_number", page.getNumber()+""));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

            String s = Request.Post(connector.getDomin())
                    .body(entity).socketTimeout(500).connectTimeout(500)
                    .execute().returnContent().asString(Charset.forName("utf-8"));
            log.info(JSON.toJSONString(JSONObject.parseObject(s),true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }









}
