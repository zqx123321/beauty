package cn.ouctechnology.oodb.logical;

import cn.ouctechnology.oodb.operator.DbIterator;
import cn.ouctechnology.oodb.operator.Join;
import cn.ouctechnology.oodb.util.where.WhereNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-01 11:55
 * @description: TODO
 **/
public class IteratorMap {
    private static final String splitCharacter = "+";
    private Map<String, DbIterator> iteratorMap = new HashMap<>();

    public DbIterator singleGet(String alias) {
        return iteratorMap.get(alias);
    }


    public void joinTable(WhereNode whereNode, String... alias) {
        boolean isAllNotNone = true;
        for (String alia : alias) {
            if (iteratorMap.get(alia) == null) {
                isAllNotNone = false;
                break;
            }
        }
        if (isAllNotNone) {
            DbIterator dbIterator1 = iteratorMap.get(alias[0]);
            for (int i = 1; i < alias.length; i++) {
                DbIterator dbIterator2 = iteratorMap.get(alias[i]);
                dbIterator1 = new Join(dbIterator1, dbIterator2, null);
            }
            Join join = (Join) dbIterator1;
            join.setWhereTree(whereNode);
            return;
        }
    }

    private DbIterator getContainsAll(String... alias) {
        for (String key : iteratorMap.keySet()) {
            String[] split = key.split("[" + splitCharacter + "]");
            List<String> stringList = Arrays.asList(split);
            if (split.length == 0) continue;
            boolean flag = true;
            for (String s : alias) {
                if (!stringList.contains(s)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return iteratorMap.get(key);
        }
        return null;

    }

}
