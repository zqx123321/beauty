package cn.ouctechnology.oodb.beauty.session;

import cn.ouctechnology.oodb.beauty.annotation.Id;
import cn.ouctechnology.oodb.beauty.annotation.Length;
import cn.ouctechnology.oodb.beauty.annotation.Size;
import cn.ouctechnology.oodb.beauty.cache.Cache;
import cn.ouctechnology.oodb.beauty.cache.LRUCache;
import cn.ouctechnology.oodb.beauty.criteria.Criteria;
import cn.ouctechnology.oodb.beauty.criteria.Criterion;
import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import cn.ouctechnology.oodb.beauty.util.BeanUtil;
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
import java.util.Map;
import java.util.stream.Collectors;

import static cn.ouctechnology.oodb.beauty.util.BeanUtil.*;

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

    //生产该session的Factory
    private SessionFactory sessionFactory;

    //session 上的默认缓存实现
    private Cache<String, Map<String, Object>> cache = new LRUCache<>(10, 0);

    /**
     * 创建一个连接
     *
     * @param server         服务器ip或者域名
     * @param port           端口
     * @param sessionFactory session工厂
     */
    public Session(String server, int port, SessionFactory sessionFactory) {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(server, port));
            writeBuffer = ByteBuffer.allocate(1024 * 1024);
            readBuffer = ByteBuffer.allocate(1024 * 1024);
            this.sessionFactory = sessionFactory;
        } catch (IOException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
        }
    }

    /**
     * session核心方法，用于向服务器发送OQL，下面所有方法的最终归宿都是使用该方法发送OQL
     *
     * @param msg
     */
    private void sendMessage(String msg) {

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

    /**
     * session核心方法，用于从服务器获取响应数据，下面所有方法发送完OQL后都会调用此方法从服务器获取数据
     *
     * @return
     */
    private Object getResponse() {
        readBuffer.clear();
        try {
            //read方法是阻塞的，如果服务器没有传回数据，此方法会一直阻塞
            int bytesRead = socketChannel.read(readBuffer);
            if (bytesRead > 0) {
                readBuffer.flip();
                byte[] bytes = new byte[readBuffer.limit()];
                while (readBuffer.hasRemaining()) {
                    readBuffer.get(bytes);
                }
                //反序列化数据
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
        cache.clear();
        IOUtils.closeQuietly(socketChannel.socket());
        IOUtils.closeQuietly(socketChannel);
    }

    /**
     * 原生OQL查询
     *
     * @param oql
     * @return
     */
    public Object createOql(String oql) {
        String tableUpdate = null;
        if (oql.startsWith("select")) {
            Object fromCache = getFromCache(oql);
            if (fromCache != null) return fromCache;
        } else {
            tableUpdate = flushCache(oql, tableUpdate);
        }
        if (tableUpdate != null) {
            clearCache(tableUpdate);
            if (sessionFactory.isCached()) {
                sessionFactory.clearCache(tableUpdate);
            }
        }
        sendMessage(oql);
        return getResponse();
    }

    /**
     * 原生OQL查询，不缓存查询结果
     *
     * @param oql
     * @return
     */
    public Object createOqlNoCache(String oql) {
        String tableUpdate = null;
        if (oql.startsWith("select")) {
            sendMessage(oql);
            return getResponse();
        } else tableUpdate = flushCache(oql, tableUpdate);
        if (tableUpdate != null) {
            clearCache(tableUpdate);
            if (sessionFactory.isCached()) {
                sessionFactory.clearCache(tableUpdate);
            }
        }
        sendMessage(oql);
        return getResponse();
    }

    /**
     * 原生OQL查询，不刷新缓存
     *
     * @param oql
     * @return
     */
    public Object createOqlNoFlush(String oql) {
        if (oql.startsWith("select")) {
            Object fromCache = getFromCache(oql);
            if (fromCache != null) return fromCache;
        }

        sendMessage(oql);
        return getResponse();
    }

    /**
     * 原生OQL查询，既不缓存查询结果，也不刷新缓存
     *
     * @param oql
     * @return
     */
    public Object createOqlNoCacheAndFlush(String oql) {
        sendMessage(oql);
        return getResponse();
    }


    /**
     * 从缓存中获取数据
     *
     * @param oql
     * @return
     */
    private Object getFromCache(String oql) {
        String tableName = getTableNameFromSelect(oql);
        //可以利用缓存
        if (tableName != null) {
            //先查一级缓存
            Object sessionCache = BeanUtil.getFromCache(cache, tableName, oql);
            if (sessionCache != null) {
                logger.info("return from session cache...");
                return sessionCache;
            }
            //再查二级缓存
            if (sessionFactory.isCached()) {
                Object factoryCache = BeanUtil.getFromCache(sessionFactory.getCache(), tableName, oql);
                if (factoryCache != null) {
                    logger.info("return from factory cache...");
                    return factoryCache;
                }
            }
            sendMessage(oql);
            Object response = getResponse();
            //放入二级缓存
            if (sessionFactory.isCached()) {
                putIntoCache(sessionFactory.getCache(), tableName, oql, response);
            }
            //放入二级缓存
            putIntoCache(cache, tableName, oql, response);
            return response;
        }
        return null;
    }

    /**
     * 刷新缓存
     *
     * @param oql
     * @param tableUpdate
     * @return
     */
    private String flushCache(String oql, String tableUpdate) {
        if (oql.startsWith("delete")) {
            tableUpdate = BeanUtil.getTableNameFromDelete(oql);
        } else if (oql.startsWith("update")) {
            tableUpdate = BeanUtil.getTableNameFromUpdate(oql);
        } else if (oql.startsWith("insert")) {
            tableUpdate = BeanUtil.getTableNameFromInsert(oql);
        }
        return tableUpdate;
    }

    /**
     * 刷新所有缓存
     */
    public void clearCache() {
        cache.clear();
    }

    /**
     * 刷新指定表的缓存
     *
     * @param tableName
     */
    public void clearCache(String tableName) {
        Map<String, Object> objectMap = cache.get(tableName);
        if (objectMap != null) objectMap.clear();
    }

    /**
     * Query查询
     *
     * @param oql
     */
    public Query createQuery(String oql) {
        logger.info("create query:{}", oql);
        return new Query(oql, this);
    }

    /**
     * 建表
     *
     * @param clz
     * @return
     */
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

    /**
     * 删表
     *
     * @param clz
     * @return
     */
    public int drop(Class clz) {
        StringBuilder sb = new StringBuilder();
        sb.append("drop table ").append(StringUtils.uncapitalize(clz.getSimpleName()));
        String oql = sb.toString();
        logger.info("drop:{}", oql);
        return new Query(oql, this).update();
    }

    public Cache<String, Map<String, Object>> getCache() {
        return cache;
    }

    /**
     * 插入数据
     *
     * @param object
     * @return
     */
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

    /**
     * 更新数据
     *
     * @param object
     * @param criterion
     * @return
     */
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

    /**
     * 删除数据
     *
     * @param clz
     * @param criterion
     * @return
     */
    public int delete(Class clz, Criterion criterion) {
        String tableName = StringUtils.uncapitalize(clz.getSimpleName());
        String oql = "delete from " + tableName + " " + tableName;
        if (criterion != null) {
            oql += " where " + criterion.toOqlString(tableName);
        }
        logger.info("delete:{}", oql);
        return new Query(oql, this).update();
    }


    /**
     * 创建一个Criteria，指定别名
     *
     * @param clz
     * @param alias
     * @return
     */
    public Criteria createCriteria(Class clz, String alias) {
        return new Criteria(clz, alias, this);
    }

    /**
     * 创建一个Criteria，不指定别名
     *
     * @param clz
     * @return
     */
    public Criteria createCriteria(Class clz) {
        return new Criteria(clz, this);
    }

    /**
     * 开启事务
     */
    public void beginTransaction() {
        sendMessage("begin transaction");
        String response = (String) getResponse();
        if (!response.contains("started")) {
            throw new BeautifulException("begin transaction fail:" + response);
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        sendMessage("commit");
        String response = (String) getResponse();
        if (!response.contains("successfully")) {
            throw new BeautifulException(response);
        }
    }

    /**
     * 回滚事务
     */
    public void rollBack() {
        sendMessage("roll back");
        String response = (String) getResponse();
        if (!response.contains("successfully")) {
            throw new BeautifulException(response);
        }
    }

    /**
     * QBE查询
     *
     * @param example
     * @param <T>
     * @return
     */
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

    /**
     * Native Queries
     *
     * @param predicate
     * @param <T>
     * @return
     */
    public <T> List<T> query(Predicate<T> predicate) {
        Class<T> genericClass = predicate.getGenericClass();
        String tableName = StringUtils.uncapitalize(genericClass.getSimpleName());
        String oql = "select " + tableName + " from " + tableName + " " + tableName;
        logger.info("nq:{}", oql);
        Query query = new Query(oql, this);
        List<T> resList = query.list(genericClass);
        return resList.stream().filter(predicate::match).collect(Collectors.toList());
    }

    /**
     * 使用JDK动态代理进行包装，得到相应Beauty的代理类
     *
     * @param clz
     * @param <T>
     * @return
     */
    public <T> T getBeautiful(Class<T> clz) {
        return (T) new BeautyProxy(this).bind(clz);
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
