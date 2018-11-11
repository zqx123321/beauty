package cn.ouctechnology.oodb.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Socket客户端，创建一个守护线程负责接收服务端回传的消息
 * 主线程向服务端发送消息
 **/
public class Client {
    private Logger logger = LoggerFactory.getLogger(Client.class);

    private SocketChannel socketChannel;
    private ByteBuffer readBuffer;
    private ByteBuffer writeBuffer;
    //打印锁，用于锁定终端
    private Lock printLock;
    private Condition printCondition;
    private boolean isPrinting;

    class ClientListener implements Runnable {

        @Override
        public void run() {
            while (true) {
                String res = "";
                readBuffer.clear();
                try {
                    int bytesRead = socketChannel.read(readBuffer);
                    if (bytesRead > 0) {
                        readBuffer.flip();
                        byte[] bytes = new byte[readBuffer.limit()];
                        while (readBuffer.hasRemaining()) {
                            readBuffer.get(bytes);
                        }
                        res = new String(bytes, StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    logger.error("从服务端获取消息出错：{}", e.getMessage());
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
                System.out.println(res);
                System.out.print(">");
                isPrinting = false;
                printCondition.signal();
                printLock.unlock();
            }
        }
    }

    public Client(String host, Integer tcpPort) {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(host, tcpPort));
            logger.info("客户端创建成功：{}", socketChannel);
        } catch (Exception e) {
            logger.error("客户端创建出错：{}", e.getMessage());
        }
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
            sendMessage(msg);
        }
    }

    public static void main(String[] args) {
        Client client = new Client("www.ouctechnology.cn", 9999);
        client.start();
    }
}
