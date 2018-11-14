package cn.ouctechnology.oodb.beauty.session;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 17:05
 * @description: TODO
 **/
@SuppressWarnings("all")
public class Tuple {
    transient private String tableAlias;
    transient private boolean flag = false;
    private Map<String, Object> values = new HashMap<>();


    public Object get(String name) {
        if (!flag) process();
        return values.get(name);
    }

    private void process() {
        Map<String, Object> newValues = new HashMap<>();
        values.forEach((k, v) -> {
            newValues.put(k.substring(k.indexOf(".") + 1), v);
        });
        values = newValues;
    }

    @Override
    public String toString() {
        return values.toString();
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }
}
