package cn.ouctechnology.oodb.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-10 15:15
 * @description: TODO
 **/
public class ThreadLocalTest {
    ThreadLocal<List<Integer>> threadLocal = new ThreadLocal<>();

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                List<Integer> list = threadLocal.get();
                if (list == null) list = new ArrayList<>();
                list.add(finalI);
                list.add(finalI);
            }).start();
        }

        Thread.sleep(1000);

    }
}
