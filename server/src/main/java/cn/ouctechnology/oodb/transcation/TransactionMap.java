package cn.ouctechnology.oodb.transcation;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.catalog.Table;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-11 10:20
 * @description: TODO
 **/
public class TransactionMap {

    //线程map
    private static final Map<Thread, List<Block>> THREAD_MAP = new ConcurrentHashMap<>();

    private static final Map<Thread, List<Table>> TABLE_MAP = new ConcurrentHashMap<>();

    public static Map<Thread, List<Block>> getThreadMap() {
        return THREAD_MAP;
    }

    public static Map<Thread, List<Table>> getTableMap() {
        return TABLE_MAP;
    }
}
