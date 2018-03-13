package com.jero.esc.common.utils.fastvalidate;

import java.util.regex.Pattern;

/**
 * Created by blazh on 2016/12/7.
 */
public enum  FastValidateType {

	NULL(""),
    NOT_EMPTY("^\\S$"),
	EMAIL("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"),
    CELL("^((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8}$"),
    PASSID("^\\d{15}|\\d{18}$"),
    IP("^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$"),
    CHINESE("^[\\u4e00-\\u9fa5]*$"),
    QQ("^[1-9][0-9]{4,}$"),
    JSON(""),
    NUM("^\\d*$"),
    CHINESE_NAME("^[\\u4E00-\\u9FA5]{2,5}(?:·[\\u4E00-\\u9FA5]{2,5})*$"),
    MONEY("^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$"),
    KEYWORDS("^(((\\w||[\\u4e00-\\u9fa5])+[,])||(\\w||[\\u4e00-\\u9fa5])+){0,5}$"),
    URL("^((https||http||ftp||rtsp||mms)?:\\/\\/)[^\\s]+");








    String reg;

    FastValidateType(String s){
        this.reg=s;
    }

    public String getReg() {
        return reg;
    }


    //    Pattern EMAIL = Pattern.compile("");
//    Pattern CELL = Pattern.compile("");
//    Pattern NUM = Pattern.compile("");
//    Pattern WORD = Pattern.compile("");

}
