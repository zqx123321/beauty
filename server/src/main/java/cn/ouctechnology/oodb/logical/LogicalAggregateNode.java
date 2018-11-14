package cn.ouctechnology.oodb.logical;

import cn.ouctechnology.oodb.operator.aggregator.Aggregator;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 10:39
 * @description: TODO
 **/
public class LogicalAggregateNode{

    private Aggregator.Op op;

    private String aField;

    private String groupField;

    public LogicalAggregateNode() {
    }

    public void setOp(Aggregator.Op op) {
        this.op = op;
    }

    public void setAField(String aField) {
        this.aField = aField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public Aggregator.Op getOp() {
        return op;
    }

    public String getAField() {
        return aField;
    }

    public String getGroupField() {
        return groupField;
    }
}
