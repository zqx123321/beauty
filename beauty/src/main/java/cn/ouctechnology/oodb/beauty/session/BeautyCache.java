package cn.ouctechnology.oodb.beauty.session;

import cn.ouctechnology.oodb.beauty.cache.Cache;
import cn.ouctechnology.oodb.beauty.cache.LFUCache;
import cn.ouctechnology.oodb.beauty.cache.LRUCache;
import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import org.springframework.beans.factory.InitializingBean;

import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-19 20:26
 * @description: TODO
 **/
public class BeautyCache implements Cache<String, Map<String, Object>>, InitializingBean {
    private int cacheSize = 10;
    private String policy = "lru";
    private Cache<String, Map<String, Object>> cache;

    /**
     * 提供无spring环境下的配置方式
     */
    public BeautyCache(int cacheSize, String policy) {
        this.cacheSize = cacheSize;
        this.policy = policy;
        this.cache = getCache(policy, cacheSize);
    }

    public BeautyCache() {
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }


    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public long getDefaultExpire() {
        return cache.getDefaultExpire();
    }

    @Override
    public void put(String key, Map<String, Object> value) {
        cache.put(key, value);
    }

    @Override
    public void put(String key, Map<String, Object> value, long expire) {
        cache.put(key, value, expire);
    }

    @Override
    public Map<String, Object> get(String key) {
        return cache.get(key);
    }

    @Override
    public int eliminate() {
        return cache.eliminate();
    }

    @Override
    public boolean isFull() {
        return cache.isFull();
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public int getCacheSize() {
        return cache.getCacheSize();
    }

    @Override
    public boolean isEmpty() {
        return cache.isEmpty();
    }

    private static Cache<String, Map<String, Object>> getCache(String policy, int size) {
        switch (policy) {
            case "lru":
                return new LRUCache<>(size, 0);
            case "fifo":
                return new LFUCache<>(size, 0);
            case "lfu":
                return new LFUCache<>(size, 0);
            default:
                throw new BeautifulException("the cache policy is not supported");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        cache = getCache(policy, cacheSize);
    }
}
