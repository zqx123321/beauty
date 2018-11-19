package cn.ouctechnology.oodb.beauty.cache;

import org.junit.Before;
import org.junit.Test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-19 17:09
 * @description: TODO
 **/
public class CacheTest {

    private Cache<String, Object> cache;

    @Before
    public void init() {
        cache = new FIFOCache<>(3, 0);
    }

    @Test
    public void getDefaultExpire() {
    }

    @Test
    public void put() {
        cache.put("1", 2);
        cache.put("2", 2);
        cache.put("3", 2);
        cache.get("1");
        cache.put("4", 2);
        System.out.println(cache.get("4"));
        System.out.println(cache.get("1"));
    }
}