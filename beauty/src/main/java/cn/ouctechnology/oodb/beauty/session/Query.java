package cn.ouctechnology.oodb.beauty.session;


import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 15:17
 * @description: Query对象
 **/
public class Query {
    private Logger logger = LoggerFactory.getLogger(Query.class);
    private String oql;
    private Session session;

    Query(String oql, Session session) {
        this.oql = oql;
        this.session = session;
    }

    public String getOql() {
        return oql;
    }

    /**
     * 将查询结果转化为不带有泛型的List
     *
     * @param cache 是否缓存查询结果，若不缓存则传入一个false
     * @return
     */
    public List list(boolean... cache) {
        if (!oql.startsWith("select")) throw new BeautifulException("the list must be select statement");
        if (cache != null && cache.length > 0 && !cache[0]) {
            Object value = session.createOqlNoCache(this.oql);
            return (List) value;
        }
        Object value = session.createOql(this.oql);
        return (List) value;
    }

    /**
     * 执行更新操作
     *
     * @param flush 是否刷新缓存，若不刷新则传入一个false
     * @return
     */
    public int update(boolean... flush) {
        if (oql.startsWith("select")) throw new BeautifulException("the list must not be select statement");
        String response = null;
        if (flush != null && flush.length > 0 && !flush[0]) response = (String) session.createOqlNoFlush(oql);
        else response = (String) session.createOql(oql);
        String rows = response.substring(0, response.indexOf(" "));
        return Integer.parseInt(rows);
    }

    /**
     * 获取查询结果的第一个元素，不带有泛型
     *
     * @param cache
     * @return
     */
    public Object firstResult(boolean... cache) {
        Map<String, Object> firstMap = (Map<String, Object>) list(cache).get(0);
        return firstMap.entrySet().iterator().next().getValue();
    }

    /**
     * 获取查询结果的第一个元素，带有泛型
     *
     * @param clz
     * @param cache
     * @param <T>
     * @return
     */
    public <T> T firstResult(Class<T> clz, boolean... cache) {
        List<T> list = list(clz, cache);
        if (list == null || list.size() == 0) return null;
        return list.get(0);
    }

    /**
     * 将查询结果转化为带有泛型的List
     *
     * @param clz
     * @param cache
     * @param <T>
     * @return
     */
    public <T> List<T> list(Class<T> clz, boolean... cache) {
        //获取list对象
        List<Map<String, Object>> resMaps = list(cache);
        //获取setter方法
        return resMaps.stream().map(r -> {
            Map<String, Object> newMap = new HashMap<>();
            r.forEach((k, v) -> {
                newMap.put(k.substring(k.indexOf(".") + 1), v);
            });
            return populate(clz, newMap);
        }).collect(Collectors.toList());
    }

    /**
     * 自定义populate方法，将Map转化为对象，可以处理对象列表无限嵌套的情况
     *
     * @param clz
     * @param newMap
     * @param <T>
     * @return
     */
    private <T> T populate(Class<T> clz, Map<String, Object> newMap) {
        try {
            T obj = clz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clz);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Method writeMethod = pd.getWriteMethod();
                if (writeMethod == null) continue;
                String name = pd.getName();
                Object value = newMap.get(name);
                //处理嵌套对象
                if (value instanceof Map) {
                    Object subObj = populate(pd.getPropertyType(), (Map<String, Object>) value);
                    writeMethod.invoke(obj, subObj);
                } else if (pd.getPropertyType() == List.class) {
                    //处理嵌套list类型
                    String pdName = pd.getName();
                    Field field = clz.getDeclaredField(pdName);
                    //获取List的泛型
                    Type type = field.getGenericType();
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Class listClass = (Class) parameterizedType.getActualTypeArguments()[0];
                        //使用classLoader!=null来判断是简单类型还是自定义类型
                        if (listClass.getClassLoader() != null) {
                            List mapList = (List) value;
                            List realList = new ArrayList();
                            //自定义类型，再次递归
                            for (Object map : mapList) {
                                realList.add(populate(listClass, (Map<String, Object>) map));
                            }
                            writeMethod.invoke(obj, realList);
                        } else {
                            writeMethod.invoke(obj, value);
                        }
                        continue;
                    }
                    throw new BeautifulException("the list type is error");
                } else {
                    writeMethod.invoke(obj, value);
                }
            }
            return obj;
        } catch (IntrospectionException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
