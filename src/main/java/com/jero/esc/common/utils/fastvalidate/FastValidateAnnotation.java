package com.jero.esc.common.utils.fastvalidate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by blazh on 2016/12/6.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FastValidateAnnotation {



    String comment() default "";
    String name() default  "";
    String pattern() default "";
    String invalidMessage() default "";
    String emptyMessage() default "";
    FastValidateType validateType() default FastValidateType.NULL;

}





