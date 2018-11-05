package cn.ouctechnology.oodb.btree;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-05 16:48
 * @description: TODO
 **/
public class BTreeTest {

    class BTreeKey implements Comparable<BTreeKey> {
        private Map<String, Comparable> values = new LinkedHashMap<>();


        @Override
        public int compareTo(BTreeKey o) {
            for (Map.Entry<String, Comparable> stringObjectEntry : values.entrySet()) {
                String key = stringObjectEntry.getKey();
                Comparable value = stringObjectEntry.getValue();
                Comparable otherValue = o.values.get(key);
                int res = value.compareTo(otherValue);
                if (res != 0) return res;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "BTreeKey{" +
                    "values=" + values +
                    '}';
        }
    }

    @Test
    public void insert() {
        BTree<BTreeKey, Integer> bTree = new BTree<>();
        bTree.insert(new BTreeKey(), 1);
    }
}