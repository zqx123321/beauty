package cn.ouctechnology.oodb.transcation;

import cn.ouctechnology.oodb.BaseTest;
import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.execute.OqlEngine;
import cn.ouctechnology.oodb.operator.SeqScan;
import org.junit.Test;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static cn.ouctechnology.oodb.constant.Constants.READ;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-11 10:15
 * @description: TODO
 **/
public class TransactionTest extends BaseTest {

    @Test
    public void testRead() throws InterruptedException {
        new Thread(() -> {
            Transaction.start();
            Block person = Buffer.getBlock("person", 0, READ);
            System.out.println(person);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            Transaction.start();
            Block person = Buffer.getBlock("person", 0, READ);
            System.out.println(person);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.currentThread().join();
    }

    @Test
    public void testWrite() throws InterruptedException {

        new Thread(() -> {
            Transaction.start();
            Block person = Buffer.getBlock("person", 0, READ);
            System.out.println(person);
            try {
                Thread.sleep(5000);
                Transaction.commit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            Transaction.start();
            Block person = Buffer.getBlock("person", 0, READ);
            System.out.println(person);
            try {
                Thread.sleep(2000);
                Transaction.commit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(10000);
    }

    @Test
    public void testSelect() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Transaction.start();
                SeqScan seqScan = new SeqScan("person", Thread.currentThread().getName());
                seqScan.open();
                while (seqScan.hasNext()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(seqScan.next());
                }
                seqScan.close();
                Transaction.commit();
            }).start();
        }

        Thread.sleep(5000);
    }

    @Test
    public void testInsert() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                Transaction.start();
//                try {
//                    Thread.sleep(finalI * 1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                String oql = "insert into person values(" + (10 + finalI) + ",'hhh" + (10 + finalI) + "')";
                System.out.println(OqlEngine.execute(oql));
                Transaction.commit();
            }).start();
        }

        Thread.sleep(5000);
        String oql = "select a from person a";
        System.out.println(OqlEngine.execute(oql));
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void testRollBack() {
        Transaction.start();
        try {
            System.out.println(OqlEngine.execute("select a from person a"));
            System.out.println(OqlEngine.execute("update person a set a.name='asdas' where a.id=1"));
            System.out.println(OqlEngine.execute("update person a set a.name='sdasd' where a.id=2"));
            System.out.println(OqlEngine.execute("insert into person values(43534,'534534')"));
            System.out.println(OqlEngine.execute("select count(a.id) from person a"));
            int i = 1 / 0;
            Transaction.commit();
        } catch (Exception e) {
            Transaction.rollback();
        }
        System.out.println(OqlEngine.execute("select count(a.id) from person a"));
    }

    @Test
    public void testLock() {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        System.out.println("hh");
        lock.readLock().lock();
        System.out.println("hh");
        lock.readLock().unlock();
        lock.writeLock().unlock();
    }
}