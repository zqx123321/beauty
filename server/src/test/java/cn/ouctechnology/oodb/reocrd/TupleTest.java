package cn.ouctechnology.oodb.reocrd;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-04 21:15
 * @description: TODO
 **/
public class TupleTest {

    @Test
    public void get() {
        Tuple tuple = new Tuple();
        Tuple tuple1 = new Tuple();
        ArrayList<Object> objects = new ArrayList<>();
        tuple1.add("id", 1);
        tuple1.add("name", "dd");
        tuple.add("dept", tuple1);
        objects.add(1);
        objects.add(2);
        objects.add(tuple1);
        tuple.add("thing", objects);
        System.out.println(tuple.get("thing.2"));
        System.out.println(tuple.get("thing.2.name"));
        System.out.println(tuple);
    }
}