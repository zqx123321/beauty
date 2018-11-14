package cn.ouctechnology.oodb.operator;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.dbenum.Type;
import cn.ouctechnology.oodb.operator.aggregator.Aggregator;
import cn.ouctechnology.oodb.reocrd.Tuple;
import org.junit.Test;

import static cn.ouctechnology.oodb.constant.Constants.NO_GROUPING;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-30 16:19
 * @description: TODO
 **/
public class AggregateTest extends BaseTest {

    @Test
    public void fetchNext() {
        DbIterator test = new SeqScan("test", "a");
        Type type = Catalog.getAttribute("test", "name").getType();
        Aggregate id = new Aggregate(test, "a.name", type, NO_GROUPING, Aggregator.Op.COUNT);

        id.open();
        while (id.hasNext()) {
            Tuple next = id.next();
            System.out.println(next);
        }
        id.close();
    }
}