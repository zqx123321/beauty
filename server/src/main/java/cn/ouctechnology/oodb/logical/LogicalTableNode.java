package cn.ouctechnology.oodb.logical;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 10:18
 * @description: TODO
 **/
public class LogicalTableNode {
    private Map<String, String> tables;


    public LogicalTableNode() {
        tables = new HashMap<>();
    }

    public void addTable(String tableAlias, String tableName) {
        tables.put(tableAlias, tableName);
    }

    public String get(String tableAlias) {
        return tables.get(tableAlias);
    }

    public Map<String, String> getTables() {
        return tables;
    }
}
