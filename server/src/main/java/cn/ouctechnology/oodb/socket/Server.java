package cn.ouctechnology.oodb.socket;

import cn.ouctechnology.oodb.buffer.Buffer;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.constant.Constants;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.execute.SyncExplain;
import cn.ouctechnology.oodb.transcation.DeadlockDetector;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    /**
     * 当前连接数
     */
    public static int socketCount = 0;

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
        readConfig();
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

    /**
     * 读取配置文件
     */
    private static void readConfig() {
        File file = new File("config.xml");
        if (!file.exists()) return;
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        try {
            FileInputStream inputStream = new FileInputStream(file);
            Document document = reader.read(inputStream);
            //获取根节点元素对象
            Element node = document.getRootElement();
            Element beauty = node.element("beauty");
            if (beauty == null) throw new DbException("the xml error");
            Element portElement = beauty.element("port");
            if (portElement != null) {
                Constants.SERVER_PORT = Integer.parseInt(portElement.getText());
            }

            Element pathElement = beauty.element("path");
            if (pathElement != null) {
                Constants.DB_PATH = pathElement.getText();
            }

            Element socketCountElement = beauty.element("socketCount");
            if (socketCountElement != null) {
                Constants.MAX_SOCKET_COUNT = Integer.parseInt(socketCountElement.getText());
            }

            Element blockSizeElement = beauty.element("blockSize");
            if (blockSizeElement != null) {
                Constants.BLOCK_SIZE = Integer.parseInt(blockSizeElement.getText());
            }

            Element blockCountElement = beauty.element("blockCount");
            if (blockCountElement != null) {
                Constants.MAX_NUM_OF_BLOCKS = Integer.parseInt(blockCountElement.getText());
            }

            Element indexNodeElement = beauty.element("indexNode");
            if (indexNodeElement != null) {
                Constants.MAX_NUM_OF_NODE = Integer.parseInt(indexNodeElement.getText());
            }

            IOUtils.closeQuietly(inputStream);
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
