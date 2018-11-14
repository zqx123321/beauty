package cn.ouctechnology.oodb.beauty.annotation;

import java.lang.annotation.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 10:31
 * @description: TODO
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Insert{
    String value();
}
