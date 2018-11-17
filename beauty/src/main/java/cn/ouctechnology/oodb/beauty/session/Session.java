package cn.ouctechnology.oodb.beauty.session;

import cn.ouctechnology.oodb.beauty.annotation.Id;
import cn.ouctechnology.oodb.beauty.annotation.Length;
import cn.ouctechnology.oodb.beauty.annotation.Size;
import cn.ouctechnology.oodb.beauty.criteria.Criteria;
import cn.ouctechnology.oodb.beauty.criteria.Criterion;
import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import cn.ouctechnology.oodb.beauty.util.SerializationUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.beauty.util.BeanUtil.getColumnList;
import static cn.ouctechnology.oodb.beauty.util.BeanUtil.getValueList;

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
            throw new BeautifulException(e);
        }
    }

    public Query createQuery(String oql) {
        logger.info("create query:{}", oql);
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
                    throw new BeautifulException(deserialize.toString());
                }
                return deserialize;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
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
        for (int i = 0; i < columnList.size(); i++) {
            Object value = valueList.get(i);
            if (value == null) continue;
            String column = columnList.get(i);
            oql.append(separator).append(column);
            separator = ",";
        }

        oql.append(")values(");

        separator = "";
        for (Object value : valueList) {
            if (value == null) continue;
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
        if (columnList.size() != valueList.size())
            throw new BeautifulException("the column size id not equal to value size");
        String separator = "";
        for (int i = 0; i < columnList.size(); i++) {
            Object value = valueList.get(i);
            if (value == null) continue;
            String column = columnList.get(i);
            oql.append(separator).append(tableName).append(".").append(column).append("=").append(value);
            separator = ",";
        }
        if (criterion != null) {
            oql.append(" where ").append(criterion.toOqlString(tableName));
        }
        logger.info("update:{}", oql.toString());
        return new Query(oql.toString(), this).update();
    }

    public int delete(Class clz, Criterion criterion) {
        String tableName = StringUtils.uncapitalize(clz.getSimpleName());
        String oql = "delete from " + tableName + " " + tableName;
        if (criterion != null) {
            oql += " where " + criterion.toOqlString(tableName);
        }
        logger.info("delete:{}", oql);
        return new Query(oql, this).update();
    }

    public Criteria createCriteria(Class clz, String alias) {
        return new Criteria(clz, alias, this);
    }

    public Criteria createCriteria(Class clz) {
        return new Criteria(clz, this);
    }

    public void beginTransaction() {
        sendMessage("begin transaction");
        String response = (String) getResponse();
        if (!response.contains("started")) {
            throw new BeautifulException("begin transaction fail:" + response);
        }
    }

    public void commit() {
        sendMessage("commit");
        String response = (String) getResponse();
        if (!response.contains("successfully")) {
            throw new BeautifulException(response);
        }
    }

    public void rollBack() {
        sendMessage("roll back");
        String response = (String) getResponse();
        if (!response.contains("successfully")) {
            throw new BeautifulException(response);
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
        return (T) new BeautyProxy(this).bind(clz);
    }

    public Object createOql(String oql) {
        sendMessage(oql);
        return getResponse();
    }

    public int create(Class clz) {
        Field[] fields = clz.getDeclaredFields();
        String keyName = null;
        String proxy = null;
        for (Field field : fields) {
            Id id = field.getAnnotation(Id.class);
            if (id != null) {
                if (keyName != null) throw new BeautifulException("only supported one primary key");
                keyName = field.getName();
                Id.Policy value = id.value();
                if (value == null) proxy = "assign";
                else proxy = value.toString();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("create table ").append(StringUtils.uncapitalize(clz.getSimpleName())).append(" ");
        sb.append(getCreateList(clz));

        Class superclass = clz.getSuperclass();
        if (superclass.getClassLoader() != null) {
            sb.append("extends ").append(StringUtils.uncapitalize(superclass.getSimpleName()));
        }
        if (keyName != null) {
            sb.append("primary key(").append(keyName).append(")").append(proxy);
        }
        String oql = sb.toString();
        logger.info("create:{}", oql);
        return new Query(oql, this).update();
    }

    private String getCreateList(Class clz) {
        Field[] fields = clz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        String separator = "";
        for (Field field : fields) {
            sb.append(separator);
            sb.append(field.getName()).append(" ");
            sb.append(getFromField(field));
            separator = ",";
        }
        sb.append(")");
        return sb.toString();
    }

    private String getFromField(Field field) {
        StringBuilder sb = new StringBuilder();
        Class<?> type = field.getType();

        if (type == String.class) {
            Length lengthAnnotation = field.getAnnotation(Length.class);
            int length = 255;
            if (lengthAnnotation != null) length = lengthAnnotation.value();
            return getFromClass(type, length);
        }

        if (type == List.class) {
            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                Class listClass = (Class) parameterizedType.getActualTypeArguments()[0];
                Length lengthAnnotation = field.getAnnotation(Length.class);
                int length = 255;
                if (lengthAnnotation != null) length = lengthAnnotation.value();
                sb.append("listof(").append(getFromClass(listClass, length));
                Size sizeAnnotation = field.getAnnotation(Size.class);
                if (sizeAnnotation == null) throw new BeautifulException("unsupported list size");
                sb.append(",").append(sizeAnnotation.value()).append(")");
                return sb.toString();
            } else throw new BeautifulException("unsupported list type");
        }
        return getFromClass(type, 0);
    }

    private String getFromClass(Class type, int length) {
        StringBuilder sb = new StringBuilder();
        if (type.getClassLoader() != null) {
            sb.append("object").append(getCreateList(type));
            return sb.toString();
        }
        if (type == String.class) {
            sb.append("char(");
            sb.append(length).append(")");
            return sb.toString();
        }

        if (type == int.class || type == Integer.class) {
            sb.append("int");
            return sb.toString();
        }
        if (type == float.class || type == Float.class) {
            sb.append("float");
            return sb.toString();
        }
        throw new BeautifulException("unsupported operator");
    }

    public int drop(Class clz) {
        StringBuilder sb = new StringBuilder();
        sb.append("drop table ").append(StringUtils.uncapitalize(clz.getSimpleName()));
        String oql = sb.toString();
        logger.info("drop:{}", oql);
        return new Query(oql, this).update();
    }
}
