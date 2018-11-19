package cn.ouctechnology.oodb.beauty.util;

import cn.ouctechnology.oodb.beauty.cache.Cache;
import cn.ouctechnology.oodb.beauty.exception.BeautifulException;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 21:28
 * @description: TODO
 **/
public class BeanUtil {
    public static List<String> getColumnList(Object object, String parent) {
        Class<?> clz = object.getClass();
        List<String> columnList = new ArrayList<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clz);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Class<?> propertyType = pd.getPropertyType();
                Method writeMethod = pd.getWriteMethod();
                if (writeMethod == null) continue;
                Method readMethod = pd.getReadMethod();
                if (readMethod == null) continue;
                Object value = readMethod.invoke(object);
                //基本类型被null的bootstrap类加载器加载
                if (propertyType.getClassLoader() != null) {
                    if (value == null) value = propertyType.newInstance();
                    columnList.addAll(getColumnList(value, pd.getName() + "."));
                } else {
                    columnList.add(parent + pd.getName());
                }
            }
            return columnList;
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
        }
    }

    public static List<Object> getValueList(Object object) {
        Class<?> clz = object.getClass();
        List<Object> valueList = new ArrayList<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clz);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Class<?> propertyType = pd.getPropertyType();
                Method writeMethod = pd.getWriteMethod();
                if (writeMethod == null) continue;
                Method readMethod = pd.getReadMethod();
                if (readMethod == null) continue;
                Object value = readMethod.invoke(object);
                //基本类型被null的bootstrap类加载器加载
                if (propertyType.getClassLoader() != null) {
                    if (value == null) value = propertyType.newInstance();
                    valueList.addAll(getValueList(value));
                } else if (propertyType == List.class) {
                    String pdName = pd.getName();
                    Field field = clz.getDeclaredField(pdName);
                    Type type = field.getGenericType();
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Class listClass = (Class) parameterizedType.getActualTypeArguments()[0];
                        if (listClass.getClassLoader() != null) {
                            List mapList = (List) value;
                            StringBuilder sb = new StringBuilder();
                            sb.append("[");
                            String separator = "";
                            for (int i = 0; i < mapList.size(); i++) {
                                Object obj = mapList.get(i);
                                sb.append(separator);
                                List<String> columns = getColumnList(obj, field.getName() + "." + i + ".");
                                List<Object> values = getValueList(obj);
                                sb.append("(");
                                String subSeparator = "";
                                for (int j = 0; j < columns.size(); j++) {
                                    sb.append(subSeparator);
                                    String column = columns.get(j);
                                    Object subValue = values.get(j);
                                    sb.append(column).append(":");
                                    sb.append(subValue.toString());
                                    subSeparator = ",";
                                }
                                sb.append(")");
                                separator = ",";
                            }
                            sb.append("]");
                            valueList.add(sb.toString());
                        } else {
                            valueList.add(value);
                        }
                        continue;
                    }
                    throw new BeautifulException("list type error");
                } else {
                    if (value instanceof String) {
                        valueList.add("'" + value + "'");
                    } else {
                        valueList.add(value);
                    }
                }
            }
            return valueList;
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
        }
    }

    /**
     * 多表查询不做缓存
     */
    public static String getTableNameFromSelect(String oql) {
        if (!oql.startsWith("select")) return null;
        if (oql.contains("join")) return null;
        int from = oql.indexOf("from");
        oql = oql.substring(from + 5);
        int index = oql.indexOf(" ");
        String tableName = oql.substring(0, index);
        oql = oql.substring(index + 1);
        int where = oql.indexOf("where");
        int limit = oql.indexOf("limit");
        int order = oql.indexOf("order");
        int group = oql.indexOf("group");
        List<Integer> list = Arrays.asList(where, limit, order, group);
        Optional<Integer> min = list.stream().filter(l -> l != -1).min(Integer::compareTo);
        int minIndex = oql.length();
        if (min.isPresent()) {
            minIndex = min.get();
        }
        oql = oql.substring(0, minIndex);
        if (oql.contains(",")) return null;
        return tableName;
    }

    public static String getTableNameFromUpdate(String oql) {
        if (!oql.startsWith("update")) return null;
        oql = oql.substring(7);
        return oql.substring(0, oql.indexOf(" "));
    }

    public static String getTableNameFromDelete(String oql) {
        if (!oql.startsWith("delete")) return null;
        int from = oql.indexOf("from");
        oql = oql.substring(from + 5);
        int index = oql.indexOf(" ");
        return oql.substring(0, index);
    }

    public static String getTableNameFromInsert(String oql) {
        if (!oql.startsWith("insert")) return null;
        int from = oql.indexOf("into");
        oql = oql.substring(from + 5);
        int index = oql.indexOf(" ");
        return oql.substring(0, index);
    }

    public static Object getFromCache(Cache<String, Map<String, Object>> cache, String tableName, String oql) {
        Map<String, Object> objectMap = cache.get(tableName);
        if (objectMap != null) {
            Object value = objectMap.get(oql);
            //一级缓存有直接返回
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    public static void putIntoCache(Cache<String, Map<String, Object>> cache, String tableName, String oql, Object response) {
        Map<String, Object> objectMap = cache.get(tableName);
        if (objectMap == null) {
            objectMap = new HashMap<>();
            objectMap.put(oql, response);
            cache.put(tableName, objectMap);
        } else {
            objectMap.put(oql, response);
        }
    }

}
