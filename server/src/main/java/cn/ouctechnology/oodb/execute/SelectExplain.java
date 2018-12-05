package cn.ouctechnology.oodb.execute;

import cn.ouctechnology.oodb.logical.LogicalPlan;
import cn.ouctechnology.oodb.operator.DbIterator;
import cn.ouctechnology.oodb.reocrd.Tuple;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

import static cn.ouctechnology.oodb.parser.OQLParser.SelectStatContext;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-17 09:30
 * @description: TODO
 **/
@Builder
public class SelectExplain {

    private DbIterator dbIterator;

    /**
     * 静态工厂方法，返回处理该条select的explain
     *
     * @param tree
     */
    public static SelectExplain getSelectExplain(SelectStatContext tree) {
        LogicalPlan logicalPlan = LogicalPlan.getLogicalPlan(tree);
        logicalPlan.check();
        DbIterator dbIterator = logicalPlan.toPhysicalPlan();
        return SelectExplain.builder().dbIterator(dbIterator).build();
    }

    public Object doSelect() {
        if (dbIterator == null) return null;
        dbIterator.open();
        List<Tuple> tupleList = new ArrayList<>();
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            tupleList.add(next);
        }
        dbIterator.close();
        return tupleList;
    }
}
