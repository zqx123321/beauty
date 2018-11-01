package cn.ouctechnology.oodb.logical;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 16:14
 * @description: TODO
 **/
public class LogicalOrderNode {
    private String field;

    private boolean asc;

    public LogicalOrderNode(String field, boolean asc) {
        this.field = field;
        this.asc = asc;
    }

    public String getField() {
        return field;
    }

    public boolean isAsc() {
        return asc;
    }
}
