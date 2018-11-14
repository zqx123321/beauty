package cn.ouctechnology.oodb.beautiful;

import cn.ouctechnology.oodb.beautiful.annotation.Beautiful;
import cn.ouctechnology.oodb.beautiful.annotation.Insert;
import org.junit.Test;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 20:34
 * @description: TODO
 **/
public class PackageScanTest {

    @Test
    public void testScan() {
        Reflections reflections = new Reflections("cn.ouctechnology.oodb.test");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Beautiful.class);
    }
}
