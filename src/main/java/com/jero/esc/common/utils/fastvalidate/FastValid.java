package com.jero.esc.common.utils.fastvalidate;

/**
 * Created by blazh on 2016/12/8.
 */
public class FastValid {

    //是否为空
   public   static boolean isEmp(Object... objects){
        boolean isOk=false;
        for (Object object : objects) {
            if (object==null||object.toString().isEmpty()){
                isOk=true;
                break;
            }
        }
        return  isOk;
    }

    //是否为对应的类型
    public  static boolean matches(Object obj,FastValidateType fastValidateType){
        if (isEmp(obj)){
            return false;
        }else{
            return FastValidate.validateByPatten(obj,fastValidateType);
        }
    }


}
