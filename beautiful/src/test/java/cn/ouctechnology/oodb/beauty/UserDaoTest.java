package cn.ouctechnology.oodb.beauty;

import cn.ouctechnology.oodb.beauty.annotation.Beauty;
import cn.ouctechnology.oodb.beauty.annotation.Insert;
import cn.ouctechnology.oodb.beauty.test.User;
import cn.ouctechnology.oodb.beauty.test.UserDao;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 11:08
 * @description: TODO
 **/
public class UserDaoTest {

    @Test
    public void testInset() throws NoSuchMethodException {
        Class<UserDao> c = UserDao.class;
        if (c.isAnnotationPresent(Beauty.class)) {
            System.out.println("hello world");
        }
        //获取需要处理的方法Method实例
        Method method = c.getMethod("insert", User.class);
        //判断该方法是否包含MyAnnotation注解
        if (method.isAnnotationPresent(Insert.class)) {
            //获取该方法的MyAnnotation注解实例
            Insert annotation = method.getAnnotation(Insert.class);
        }

    }
}