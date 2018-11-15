package cn.ouctechnology.oodb.transcation;

import org.junit.Test;

import java.lang.management.LockInfo;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-15 09:33
 * @description: TODO
 **/
public class ThreadTest {

    @Test
    public void testThread() throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Lock lock3 = new ReentrantLock();
        new Thread(() -> {
            lock1.lock();
            lock3.lock();
            System.out.println("111");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock2.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("111");
            lock2.unlock();
            lock3.unlock();
            lock1.unlock();
        }).start();

        new Thread(() -> {
            lock2.lock();
            System.out.println("222");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock1.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("222");
            lock1.unlock();
            lock2.unlock();
        }).start();
        Thread.sleep(2000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);
        for (ThreadInfo threadInfo : threadInfos) {
            String threadName = threadInfo.getThreadName();
            if (!"Thread-1".equals(threadName) && !"Thread-0".equals(threadName)) continue;
            System.out.println(threadInfo.getLockInfo());
            System.out.println();
            LockInfo[] lockedSynchronizers = threadInfo.getLockedSynchronizers();
            for (LockInfo lockedSynchronizer : lockedSynchronizers) {
                System.out.println(lockedSynchronizer);
            }
        }
        //Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void test2() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        System.out.println(threadMXBean.getThreadInfo(Thread.currentThread().getId()));
    }


}
