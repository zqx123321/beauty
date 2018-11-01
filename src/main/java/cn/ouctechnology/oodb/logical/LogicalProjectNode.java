package cn.ouctechnology.oodb.logical;


import java.util.HashSet;
import java.util.Set;

public class LogicalProjectNode {
    private Set<String> fieldList = new HashSet<>();

    public void addField(String field) {
        fieldList.add(field);
    }

    public Set<String> getFieldList() {
        return fieldList;
    }
}

