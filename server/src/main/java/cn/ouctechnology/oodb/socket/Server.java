package cn.ouctechnology.oodb.socket;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.execute.SyncExplain;
import cn.ouctechnology.oodb.transcation.DeadlockDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 服务器类，启三个线程
 * SocketAccepter负责监听端口，接受客户端的连接请求，放入阻塞队列
 * SocketTaker负责从阻塞队列摘取客户端的连接，然后接受消息，交给SocketProcessor处理
 * SocketProcessor线程池，负责处理消息，得到返回结果，作为生产者放入Map
 * SocketPusher作为消费者，负责从Map去取数据，然后发送给客户端
 */
public class Server {
    private static Logger logger = LoggerFactory.getLogger(Server.class);
    private int tcpPort;

    public Server(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public void start() {

        SocketAccepter socketAccepter = new SocketAccepter(tcpPort);
        //开启多个线程
        Thread accepterThread = new Thread(socketAccepter);

        accepterThread.start();
        logger.info("server started successfully,port:{}", tcpPort);
    }

    public static void main(String[] args) throws IOException {
        Buffer.init();
        Catalog.initialCatalog();
        Server server = new Server(9999);
        server.start();
        new Timer("sync-timer ").schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info(SyncExplain.sync());
            }
        }, 0, 3000);
//        检测死锁定时任务，每分钟执行一次
        DeadlockDetector deadlockDetector = new DeadlockDetector();
        new Timer("sync-timer ").schedule(new TimerTask() {
            @Override
            public void run() {
                deadlockDetector.run();
            }
        }, 0, 30000);
    }
}
