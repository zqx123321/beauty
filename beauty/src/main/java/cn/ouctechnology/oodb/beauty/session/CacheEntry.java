package cn.ouctechnology.oodb.beauty.session;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-19 19:24
 * @description: TODO
 **/
public class CacheEntry {
    String oql;

    Object value;

    public CacheEntry(String oql, Object value) {
        this.oql = oql;
        this.value = value;
    }
}
