package cn.ouctechnology.oodb.socket;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-20 10:11
 * @description: TODO
 **/
public class ServerTest {

    @Test
    public void start() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
    }
}