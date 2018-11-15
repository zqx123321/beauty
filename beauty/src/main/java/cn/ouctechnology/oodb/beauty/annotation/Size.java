package cn.ouctechnology.oodb.beauty.annotation;

import java.lang.annotation.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 16:00
 * @description: TODO
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Size {
    int value();
}
