package cn.ouctechnology.oodb.beautiful.annotation;

import java.lang.annotation.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 22:45
 * @description: TODO
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Param {
    String value();
}
