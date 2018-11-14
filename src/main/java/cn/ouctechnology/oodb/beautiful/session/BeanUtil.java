package cn.ouctechnology.oodb.beautiful.session;

import cn.ouctechnology.oodb.exception.DbException;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
            throw new DbException(e);
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
                } else {
                    if (value instanceof String) {
                        valueList.add("'" + value + "'");
                    } else {
                        valueList.add(value);
                    }
                }
            }
            return valueList;
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new DbException(e);
        }
    }
}
