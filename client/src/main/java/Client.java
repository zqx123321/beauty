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
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Socket客户端，创建一个守护线程负责接收服务端回传的消息
 * 主线程向服务端发送消息
 * 使用生产者-消费者模式，即一个请求发送后必须等待服务器传回响应后再发送下一个请求
 **/
public class Client {
    //默认IP和端口
    private static String server = "localhost";
    private static int port = 9999;
    private Logger logger = LoggerFactory.getLogger(Client.class);
    private SocketChannel socketChannel;
    private ByteBuffer readBuffer;
    private ByteBuffer writeBuffer;
    //打印锁，用于锁定终端
    private Lock printLock;
    private Condition printCondition;
    private boolean isPrinting;
    private boolean connected = false;

    public Client(String host, Integer tcpPort) throws IOException {

        socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(host, tcpPort));
        readBuffer = ByteBuffer.allocate(1024 * 1024);
        writeBuffer = ByteBuffer.allocate(1024 * 1024);
        printLock = new ReentrantLock();
        printCondition = printLock.newCondition();
        isPrinting = false;
        //启动监听线程
        Thread received = new Thread(new ClientListener());
        //设置为守护线程
        received.setDaemon(true);
        received.start();
        //测试是否连接正常
        sendMessage("ping");
        synchronized (Client.class) {
            try {
                Client.class.wait(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (connected)
            logger.info("客户端创建成功：{}", socketChannel);
        else {
            logger.error("与服务器连接失败：{}", socketChannel);
            throw new IOException("与服务器连接时发生错误");
        }
    }

    public static void main(String[] args) {
        try {
            init();
            Client client = new Client(server, port);
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取配置信息
     */
    private static void init() {
        File file = new File("beauty.xml");
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
            if (beauty == null) throw new RuntimeException("the xml error");
            Element portElement = beauty.element("port");
            if (portElement != null) {
                port = Integer.parseInt(portElement.getText());
            }

            Element serverElement = beauty.element("server");
            if (serverElement != null) {
                server = serverElement.getText();
            }

            IOUtils.closeQuietly(inputStream);
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        writeBuffer.clear();
        writeBuffer.put(msg.getBytes());

        //切换buffer为读模式
        writeBuffer.flip();
        try {
            while (writeBuffer.hasRemaining()) {
                socketChannel.write(writeBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        while (sc.hasNext()) {
            //锁定终端
            printLock.lock();
            while (isPrinting) {
                try {
                    printCondition.await();
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
            isPrinting = true;
            String msg = sc.nextLine();
            if (msg.contains("quit")) {
                isPrinting = false;
                printCondition.signal();
                printLock.unlock();
                return;
            }
            isPrinting = false;
            printCondition.signal();
            printLock.unlock();
            //发送消息
            sendMessage(msg);
        }
    }

    /**
     * 监听线程，用于监听服务器传回的消息，如果没有消息传回，此线程会阻塞
     */
    class ClientListener implements Runnable {

        @Override
        public void run() {
            while (true) {
                Object res = null;
                readBuffer.clear();
                try {
                    int bytesRead = socketChannel.read(readBuffer);
                    if (bytesRead > 0) {
                        readBuffer.flip();
                        byte[] bytes = new byte[readBuffer.limit()];
                        while (readBuffer.hasRemaining()) {
                            readBuffer.get(bytes);
                        }
                        //反序列化
                        res = SerializationUtil.deserialize(bytes);
                    }
                    //检查客户端发送ping之后服务器是否回应pong
                    if (!connected && res instanceof String && res.equals("pong")) {
                        connected = true;
                        synchronized (Client.class) {
                            Client.class.notify();
                        }
                        continue;
                    }
                } catch (IOException e) {
                    logger.error("从服务端获取消息出错：{}", e.getMessage());
                    break;
                }
                //锁定终端
                printLock.lock();
                while (isPrinting) {
                    try {
                        printCondition.await();
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage());
                    }
                }
                isPrinting = true;
                //打印嵌套表格
                if (res instanceof List) {
                    List<Map<String, Object>> resMap = (List<Map<String, Object>>) res;
                    if (resMap.size() > 0) {
                        System.out.println(new PrintTable(resMap));
                    } else System.out.println("there is not data in the table");
                } else System.out.println(res);
                System.out.print(">");
                isPrinting = false;
                printCondition.signal();
                printLock.unlock();
            }
        }
    }
}
