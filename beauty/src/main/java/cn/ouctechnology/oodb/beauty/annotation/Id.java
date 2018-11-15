package cn.ouctechnology.oodb.beauty.annotation;

import java.lang.annotation.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 23:04
 * @description: TODO
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Id {
    Policy value();


    enum Policy {
        ASSIGN, AUTO_INCREMENT, UUID;
    }
}
