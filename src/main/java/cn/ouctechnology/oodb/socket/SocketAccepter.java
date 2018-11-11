package cn.ouctechnology.oodb.socket;

import cn.ouctechnology.oodb.exception.DbException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Socket接受器，不断accept新的请求，并把它放入阻塞队列
 * 新开线程只是接受请求而不处理请求
 */
public class SocketAccepter implements Runnable {

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
                SocketChannel socketChannel = serverSocket.accept();
                System.out.println("Socket accepted: " + socketChannel);
                //todo check if the queue can even accept more sockets.
                new Thread(new SocketProcessor(socketChannel)).start();

            } catch (IOException e) {
                e.printStackTrace();
                throw new DbException(e);
            }
        }
    }
}
