package cn.ouctechnology.oodb.beauty.session;

import cn.ouctechnology.oodb.beauty.annotation.*;
import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import cn.ouctechnology.oodb.beauty.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 20:52
 * @description: TODO
 **/
public class BeautyProxy implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(BeautyProxy.class);
    private Session session;

    private Map<String, Object> columnValueMap;

    public Object bind(Class<?> clz) {
        return Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }


    public BeautyProxy(Session session) {
        this.session = session;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Select select = method.getAnnotation(Select.class);
        Insert insert = method.getAnnotation(Insert.class);
        Update update = method.getAnnotation(Update.class);
        Delete delete = method.getAnnotation(Delete.class);
        boolean isSelect = false;
        String oql = null;
        if (select != null) {
            oql = select.value();
            isSelect = true;
        } else if (insert != null) {
            oql = insert.value();
        } else if (update != null) {
            oql = update.value();
        } else if (delete != null) {
            oql = delete.value();
        }
        if (oql == null) return null;
        List<String> paramList = new ArrayList<>();
        oql = transferOqlParams(oql, paramList);
        initMap(method, args);
        oql = fillParams(oql, paramList);

        if (isSelect) return doSelect(method, oql);
        return doUpdate(method, oql);
    }

    //填充参数
    private String fillParams(String oql, List<String> paramList) {
        Object[] values = new Object[paramList.size()];
        for (int i = 0; i < paramList.size(); i++) {
            String param = paramList.get(i);
            Object value = columnValueMap.get(param);
            if (value == null) {
                //利用hashMap能存储一个null值来尝试直接使用参数
                value = columnValueMap.get(null);
                if (value == null)
                    throw new BeautifulException("can not found the property");
            }
            values[i] = value;
        }
        return String.format(oql, values);
    }

    /**
     * 初始化map
     *
     * @param method
     * @param args
     */
    private void initMap(Method method, Object[] args) {
        columnValueMap = new HashMap<>();
        List<String> columnList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Param param = parameter.getAnnotation(Param.class);
            if (param != null) {
                String column = param.value();
                columnList.add(column);
                valueList.add(args[i]);
            } else if (args[i].getClass().getClassLoader() != null) {
                columnList.addAll(BeanUtil.getColumnList(args[i], ""));
                valueList.addAll(BeanUtil.getValueList(args[i]));
            } else {
                columnList.add(null);
                valueList.add(args[i]);
            }
        }
        for (int i = 0; i < columnList.size(); i++) {
            columnValueMap.put(columnList.get(i), valueList.get(i));
        }
    }

    /**
     * 解析sql,获取参数
     */
    private String transferOqlParams(String paramsOql, List<String> paramsList) {
        //加上？变成非贪婪模式
        //加上括号变成一个捕获组，这样能匹配去掉外面的花括号
        Pattern pattern = Pattern.compile("#\\{(.*?)}");
        Matcher matcher = pattern.matcher(paramsOql);
        while (matcher.find()) {
            String group = matcher.group(1);
            paramsList.add(group);
        }
        //替换
        return matcher.replaceAll("%s");
    }

    private Object doSelect(Method method, String oql) {
        logger.info("select:{}", oql);
        Query query = session.createQuery(oql);
        //返回值为list类型
        if (method.getReturnType() == List.class) {
            //检查list上是否携带泛型
            Type genericReturnType = method.getGenericReturnType();
            if (genericReturnType instanceof ParameterizedType) {
                ParameterizedType listGenericType = (ParameterizedType) method.getGenericReturnType();
                Type typeArgument = listGenericType.getActualTypeArguments()[0];
                Class clz = (Class) typeArgument;
                return query.list(clz);
            }
            return query.list();
        }
        //单值类型
        //复杂类型
        Class<?> returnType = method.getReturnType();
        if (returnType.getClassLoader() != null) {
            return query.firstResult(returnType);
        }
        //简单类型
        return query.firstResult();
    }

    private Object doUpdate(Method method, String oql) {
        logger.info("update:{}", oql);
        int update = session.createQuery(oql).update();
        Class<?> returnType = method.getReturnType();
        if (returnType == Integer.class || returnType == int.class) {
            return update;
        }
        return null;
    }
}
