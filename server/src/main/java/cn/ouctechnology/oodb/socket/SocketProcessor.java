package cn.ouctechnology.oodb.socket;

import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.execute.OqlEngine;
import cn.ouctechnology.oodb.reocrd.Tuple;
import cn.ouctechnology.oodb.util.SerializationUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: parser
 * @author: ZQX
 * @create: 2018-11-11 15:34
 * @description: TODO
 **/
public class SocketProcessor implements Runnable {
    private Logger logger = LoggerFactory.getLogger(SocketProcessor.class);
    private SocketChannel socketChannel;
    private ByteBuffer readByteBuffer;
    private ByteBuffer writeByteBuffer;
    private boolean isQuit;


    public SocketProcessor(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
        this.readByteBuffer = ByteBuffer.allocate(1024 * 1024);
        this.writeByteBuffer = ByteBuffer.allocate(1024 * 1024);
        this.isQuit = false;
        try {
            this.socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DbException(e);
        }
    }

    @Override
    public void run() {
        while (!isQuit) {
            String message = read();
            Object response = process(message);
            send(response);
        }
    }

    private String read() {
        readByteBuffer.clear();
        //从channel中读取数据
        try {
            int bytesRead = socketChannel.read(readByteBuffer);
            if (bytesRead > 0) {
                while (bytesRead > 0) {
                    bytesRead = socketChannel.read(readByteBuffer);
                }
                readByteBuffer.flip();
                byte[] bytes = new byte[readByteBuffer.limit()];
                while (readByteBuffer.hasRemaining()) {
                    readByteBuffer.get(bytes);
                }
                return new String(bytes, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
            IOUtils.closeQuietly(socketChannel.socket());
            IOUtils.closeQuietly(socketChannel);
            isQuit = true;
            synchronized (Server.class) {
                Server.socketCount--;
                logger.info("a client disconnect.....");
                Server.class.notify();
            }
        }
        return null;
    }

    private Object process(String message) {
        if (message == null) return null;
        if (message.equals("ping")) return "pong";
        if (message.contains("quit")) {
            isQuit = true;
            synchronized (Server.class) {
                Server.socketCount--;
                logger.info("a client disconnect.....");
                Server.class.notify();
            }
            return null;
        }
        Object response;
        try {
            response = OqlEngine.execute(message);
            if (response instanceof List) {
                List<Tuple> resList = (List<Tuple>) response;
                response = resList.stream().map(Tuple::getValues).collect(Collectors.toList());
            }
        } catch (Exception e) {
            response = "error:" + e.getMessage();
            e.printStackTrace();
        }
        return response;
    }

    private void send(Object response) {
        if (response == null) return;

        writeByteBuffer.clear();
        writeByteBuffer.put(SerializationUtil.serialize(response));
        writeByteBuffer.flip();

        while (writeByteBuffer.hasRemaining()) {
            try {
                socketChannel.write(writeByteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
                isQuit = true;
                synchronized (Server.class) {
                    Server.socketCount--;
                    logger.info("a client disconnect.....");
                    Server.class.notify();
                }
            }
        }
    }
}
