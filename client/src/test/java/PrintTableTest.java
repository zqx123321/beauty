import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-18 17:32
 * @description: TODO
 **/
public class PrintTableTest {

    @Test
    public void testToString() {
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> aData = new HashMap<>();
            aData.put("name", "tom" + i);
            aData.put("id", i);

            Map<String, Object> sunData = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                sb.append("A");
            }
            sunData.put("name", sb.toString());
            sunData.put("id", i + 9);
            sunData.put("age", i + 9.1);


            List<Map<String, Object>> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Map<String, Object> subData = new HashMap<>();
                subData.put("name", "张三" + i + j);
                subData.put("id", i + j + 9);
                list.add(subData);
            }
            aData.put("list", list);


            aData.put("dept", sunData);
            data.add(aData);
        }
        PrintTable printTable = new PrintTable(data);

        System.out.println(printTable);

    }
}