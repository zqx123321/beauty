package cn.ouctechnology.oodb.beautiful.session;

import cn.ouctechnology.oodb.beautiful.criteria.Criteria;
import cn.ouctechnology.oodb.beautiful.criteria.Criterion;
import cn.ouctechnology.oodb.exception.DbException;
import cn.ouctechnology.oodb.util.SerializationUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.beautiful.session.BeanUtil.getColumnList;
import static cn.ouctechnology.oodb.beautiful.session.BeanUtil.getValueList;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 12:51
 * @description: TODO
 **/
public class Session {
    private Logger logger = LoggerFactory.getLogger(Session.class);

    private SocketChannel socketChannel;

    private ByteBuffer writeBuffer;

    private ByteBuffer readBuffer;

    public Session(String domain, int port) {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(domain, port));
            writeBuffer = ByteBuffer.allocate(1024 * 1024);
            readBuffer = ByteBuffer.allocate(1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DbException(e);
        }
    }

    public Query createQuery(String oql) {
        return new Query(oql, this);
    }

    void sendMessage(String msg) {
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

    Object getResponse() {
        readBuffer.clear();
        try {
            int bytesRead = socketChannel.read(readBuffer);
            if (bytesRead > 0) {
                readBuffer.flip();
                byte[] bytes = new byte[readBuffer.limit()];
                while (readBuffer.hasRemaining()) {
                    readBuffer.get(bytes);
                }
                Object deserialize = SerializationUtil.deserialize(bytes);
                if (deserialize.toString().contains("error")) {
                    throw new DbException(deserialize.toString());
                }
                return deserialize;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new DbException(e);
        }
    }

    public void close() {
        sendMessage("quit");
        IOUtils.closeQuietly(socketChannel.socket());
        IOUtils.closeQuietly(socketChannel);

    }

    public int save(Object object) {
        Class<?> clz = object.getClass();
        String tableName = StringUtils.uncapitalize(clz.getSimpleName());
        StringBuilder oql = new StringBuilder("insert into " + tableName + " (");
        List<String> columnList = getColumnList(object, "");
        List<Object> valueList = getValueList(object);
        String separator = "";
        for (String column : columnList) {
            oql.append(separator).append(column);
            separator = ",";
        }
        oql.append(")values(");

        separator = "";
        for (Object value : valueList) {
            if (value == null) value = "";
            oql.append(separator).append(value);
            separator = ",";
        }
        oql.append(")");
        logger.info("save:{}", oql.toString());
        return new Query(oql.toString(), this).update();
    }

    public int update(Object object, Criterion criterion) {
        Class<?> clz = object.getClass();
        String tableName = StringUtils.uncapitalize(clz.getSimpleName());
        StringBuilder oql = new StringBuilder("update " +
                tableName +
                " " +
                tableName
                + " set ");
        List<String> columnList = getColumnList(object, "");
        List<Object> valueList = getValueList(object);
        if (columnList.size() != valueList.size()) throw new DbException("the column size id not equal to value size");
        String separator = "";
        for (int i = 0; i < columnList.size(); i++) {
            String column = columnList.get(i);
            Object value = valueList.get(i);
            if (value == null) value = "";
            oql.append(separator).append(tableName).append(".").append(column).append("=").append(value);
            separator = ",";
        }
        if (criterion != null) {
            oql.append(" where ").append(criterion.toOqlString(tableName));
        }
        logger.info("update:{}", oql.toString());
        return new Query(oql.toString(), this).update();
    }

    public int delete(Class<cn.ouctechnology.oodb.test.User> clz, Criterion criterion) {
        String tableName = StringUtils.uncapitalize(clz.getSimpleName());
        String oql = "delete from " + tableName + " " + tableName;
        if (criterion != null) {
            oql += " where " + criterion.toOqlString(tableName);
        }
        logger.info("delete:{}", oql);
        return new Query(oql, this).update();
    }

    public Criteria createCriteria(Class<cn.ouctechnology.oodb.test.User> clz, String alias) {
        return new Criteria(clz, alias, this);
    }

    public Criteria createCriteria(Class<cn.ouctechnology.oodb.test.User> clz) {
        return new Criteria(clz, this);
    }

    public void beginTransaction() {
        sendMessage("begin transaction");
        String response = (String) getResponse();
        if (!response.contains("started")) {
            throw new DbException("begin transaction fail:" + response);
        }
    }

    public void commit() {
        sendMessage("commit");
        String response = (String) getResponse();
        if (!response.contains("successfully")) {
            throw new DbException(response);
        }
    }

    public void rollBack() {
        sendMessage("roll back");
        String response = (String) getResponse();
        if (!response.contains("successfully")) {
            throw new DbException(response);
        }
    }

    public <T> List<T> queryByExample(T example) {
        String tableName = StringUtils.uncapitalize(example.getClass().getSimpleName());
        List<String> columnList = getColumnList(example, "");
        List<Object> valueList = getValueList(example);
        StringBuilder sb = new StringBuilder();
        sb.append("select ").append(tableName).append(" from ").append(tableName).append(" ").append(tableName);
        sb.append(" where ");
        String separator = "";
        for (int i = 0; i < columnList.size(); i++) {
            String column = columnList.get(i);
            Object value = valueList.get(i);
            if (value == null) continue;
            sb.append(separator).append(tableName).append(".").append(column).append("=").append(value);
            separator = " and ";
        }
        String oql = sb.toString();
        logger.info("qbe:{}", oql);
        return new Query(oql, this).<T>list((Class<T>) example.getClass());
    }

    public <T> List<T> query(Predicate<T> predicate) {
        Class<T> genericClass = predicate.getGenericClass();
        String tableName = StringUtils.uncapitalize(genericClass.getSimpleName());
        String oql = "select " + tableName + " from " + tableName + " " + tableName;
        logger.info("nq:{}", oql);
        Query query = new Query(oql, this);
        List<T> resList = query.list(genericClass);
        return resList.stream().filter(predicate::match).collect(Collectors.toList());
    }

    public <T> T getBeautiful(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, new BeautifulHandler(this));
    }
}
