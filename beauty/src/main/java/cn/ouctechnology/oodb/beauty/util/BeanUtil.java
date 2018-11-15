package cn.ouctechnology.oodb.beauty.util;

import cn.ouctechnology.oodb.beauty.exception.BeautifulException;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

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
}
