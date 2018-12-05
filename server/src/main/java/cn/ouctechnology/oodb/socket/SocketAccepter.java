package cn.ouctechnology.oodb.socket;

import cn.ouctechnology.oodb.constant.Constants;
import cn.ouctechnology.oodb.exception.DbException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Socket接受器，不断accept新的请求，并把它放入阻塞队列
 * 新开线程只是接受请求而不处理请求
 */
public class SocketAccepter implements Runnable {

    private Logger logger = LoggerFactory.getLogger(SocketAccepter.class);

    private int tcpPort;

    public SocketAccepter(int tcpPort) {
        this.tcpPort = tcpPort;
    }


    public void run() {
        //服务器channel打开，绑定端口
        ServerSocketChannel serverSocket;
        try {
            serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(tcpPort));
        } catch (IOException e) {
            e.printStackTrace();
            throw new DbException(e);
        }


        while (true) {
            //没有设置configureBlocking(false),此处的accept会阻塞
            try {
                //accept是监听客户端请求
                synchronized (Server.class) {
                    //检测连接数是否已达上限
                    if (Server.socketCount >= Constants.MAX_SOCKET_COUNT) {
                        logger.error("the socket count has reached to the max");
                        Server.class.wait();
                    }
                }
                SocketChannel socketChannel = serverSocket.accept();
                logger.info("Socket accepted: {}, socket count: {}", socketChannel, ++Server.socketCount);
                //todo check if the queue can even accept more sockets.
                //启动新线程处理请求
                new Thread(new SocketProcessor(socketChannel)).start();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                throw new DbException(e);
            }
        }
    }
}
