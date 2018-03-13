package top.blazh.showdoc;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Connector {

    /**
     * 域名
     */
    private  String domin;

    /**
     * api_key
     */
    private  String key;

    /**
     * api_token
     */
    private String token;



    private Connector(String domin,String key,String token){

        if (!domin.trim().matches("^.*www\\.showdoc\\.cc.*$")){
            Matcher matcher = Pattern.compile("(?:https?://)?(\\w+\\.\\w+\\.\\w+:?\\d*)/?.*").matcher(domin.trim());
            if (matcher.find()){
                this.domin="http://"+(matcher.group(1)+"/server/index.php?s=/api/item/updateByApi").replaceAll("//","/");
            }
        }else {
            this.domin="https://www.showdoc.cc/server/api/item/updateByApi";;
        }

        this.key=key.trim();
        this.token=token.trim();
    }

    public  static Connector build(String domin,String key,String token){
        return new Connector(domin,key,token);
    }







    public String getDomin() {
        return domin;
    }

    public void setDomin(String domin) {
        this.domin = domin;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



}
