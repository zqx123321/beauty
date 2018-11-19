package cn.ouctechnology.oodb.beauty.annotation;

import java.lang.annotation.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-19 21:22
 * @description: TODO
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NoCached {
}
