package cn.ouctechnology.oodb.beauty.session;

import cn.ouctechnology.oodb.beauty.annotation.*;
import cn.ouctechnology.oodb.beauty.criteria.Criteria;
import cn.ouctechnology.oodb.beauty.criteria.Criterion;
import cn.ouctechnology.oodb.beauty.criteria.Restrictions;
import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import cn.ouctechnology.oodb.beauty.util.BeanUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 20:52
 * @description: Beauty的InvocationHandler，描述如何代理
 **/
public class BeautyProxy implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(BeautyProxy.class);
    private Session session;

    private Map<String, Object> columnValueMap;

    private Class genericClz;

    private Set<Method> methodSet;

    private Set<String> fieldSet;


    public BeautyProxy(Session session) {
        this.session = session;
    }

    /**
     * 生产代理类
     *
     * @param clz
     * @return
     */
    public Object bind(Class<?> clz) {
        //判断是否继承BaseBeauty
        Type[] genericInterfaces = clz.getGenericInterfaces();
        if (genericInterfaces != null && genericInterfaces.length > 0) {
            Type genericInterface = clz.getGenericInterfaces()[0];
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType baseBeautyType = (ParameterizedType) genericInterface;
                genericClz = (Class) baseBeautyType.getActualTypeArguments()[0];
                //获取泛型类的所有属性
                fieldSet = Arrays.stream(genericClz.getDeclaredFields()).map(Field::getName).collect(Collectors.toSet());
                methodSet = new HashSet<>();
                //获取BeseBeauty上的所有方法
                methodSet.addAll(Arrays.asList(clz.getDeclaredMethods()));
            }
        }
        return Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, this);
    }

    /**
     * 对每个方法进行代理
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        //垃圾回收的时候关闭session
        if (method.getName().toLowerCase().equals("finalize")) {
            session.close();
            return null;
        }
        //调用父类上的方法
        if (genericClz != null && !methodSet.contains(method)) {
            return invokeBase(genericClz, session, method, args);
        }
        //初始化参数-值的对应map
        initMap(method, args);
        //获取注解
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
        if (oql == null) {
            //处理Query By Properties
            String methodName = method.getName();
            if (methodName.startsWith("findBy") || methodName.startsWith("updateBy") || methodName.startsWith("deleteBy")) {
                return invokeProperty(genericClz, session, method, args);
            }
            return null;
        }

        List<String> paramList = new ArrayList<>();
        //填充OQL参数
        oql = transferOqlParams(oql, paramList);
        oql = fillParams(oql, paramList);
        //执行查询
        if (isSelect) return doSelect(method, oql);
        return doUpdate(method, oql);
    }

    //填充参数
    private String fillParams(String oql, List<String> paramList) {
        Object[] values = new Object[paramList.size()];
        for (int i = 0; i < paramList.size(); i++) {
            String param = paramList.get(i);
            Object value;
            if (columnValueMap.containsKey(param)) {
                value = columnValueMap.get(param);
            } else if (columnValueMap.containsKey(null)) {
                //利用hashMap能存储一个null值来尝试直接使用参数
                value = columnValueMap.get(null);
            } else {
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
            //如果有param注解，则优先使用
            Param param = parameter.getAnnotation(Param.class);
            if (param != null) {
                String column = param.value();
                columnList.add(column);
                valueList.add(args[i]);
            }
            //使用对象的属性
            else if (args[i].getClass().getClassLoader() != null) {
                columnList.addAll(BeanUtil.getColumnList(args[i], ""));
                valueList.addAll(BeanUtil.getValueList(args[i]));
            }
            //尝试直接使用该对象
            else {
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

    /**
     * 执行查询操作
     *
     * @param method
     * @param oql
     * @return
     */
    private Object doSelect(Method method, String oql) {
        NoCached noCached = method.getAnnotation(NoCached.class);
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
                if (noCached != null) return query.list(clz, true);
                return query.list(clz);
            }
            if (noCached != null) return query.list(true);
            return query.list();
        }
        //单值类型
        //复杂类型
        Class<?> returnType = method.getReturnType();
        if (returnType.getClassLoader() != null) {
            if (noCached != null) return query.firstResult(returnType, true);
            return query.firstResult(returnType);
        }
        //简单类型
        if (noCached != null) return query.firstResult(true);
        return query.firstResult();
    }

    /**
     * 执行更新操作
     *
     * @param method
     * @param oql
     * @return
     */
    private Object doUpdate(Method method, String oql) {
        NoFlush noFlush = method.getAnnotation(NoFlush.class);
        logger.info("update:{}", oql);
        int update = 0;
        if (noFlush != null) update = session.createQuery(oql).update(true);
        else update = session.createQuery(oql).update();
        Class<?> returnType = method.getReturnType();
        if (returnType == Integer.class || returnType == int.class) {
            return update;
        }
        return null;
    }


    /**
     * 触发父类中的方法
     *
     * @param genericClz
     * @param session
     * @param method
     * @param args
     * @return
     */
    private Object invokeBase(Class genericClz, Session session, Method method, Object[] args) {
        String methodName = method.getName();
        if (methodName.equals("save")) {
            return session.save(args[0]);
        }
        if (methodName.equals("delete")) {
            return session.delete(genericClz, (Criterion) args[0]);
        }
        if (methodName.equals("update")) {
            return session.update(args[0], (Criterion) args[1]);
        }
        if (methodName.equals("get")) {
            return session.createCriteria(genericClz).add((Criterion) args[0]).uniqueResult();
        }
        if (methodName.equals("selectList")) {
            return session.createCriteria(genericClz).add((Criterion) args[0]).list(genericClz);
        }
        return null;
    }

    /**
     * 处理Query By Property
     *
     * @param genericClz
     * @param session
     * @param method
     * @param args
     * @return
     */
    private Object invokeProperty(Class genericClz, Session session, Method method, Object[] args) {
        String methodName = method.getName();
        if (methodName.startsWith("findBy")) {
            String suffix = methodName.substring("findBy".length());
            Criteria criteria = session.createCriteria(genericClz).add(getCriterion(suffix));
            Class<?> returnType = method.getReturnType();
            if (returnType == List.class)
                return criteria.list(genericClz);
            return criteria.uniqueResult(genericClz);
        } else if (methodName.startsWith("deleteBy")) {
            String suffix = methodName.substring("deleteBy".length());
            return session.delete(genericClz, getCriterion(suffix));
        } else if (methodName.startsWith("updateBy")) {
            String suffix = methodName.substring("updateBy".length());
            Object object = args[0];
            if (object.getClass() != genericClz)
                throw new BeautifulException("the update's first param must be the object");
            return session.update(object, getCriterion(suffix));
        }
        return null;
    }

    private Criterion getCriterion(String suffix) {
        if (fieldSet.size() == 0) return null;
        int and = suffix.indexOf("And");
        int or = suffix.indexOf("Or");
        if (and != -1) return getAndCriterion(suffix, and);
        if (or != -1) return getOrCriterion(suffix, or);
        return getOneCriterion(StringUtils.uncapitalize(suffix));
    }


    private Criterion getAndCriterion(String suffix, int op) {
        String first = StringUtils.uncapitalize(suffix.substring(0, op));
        String second = StringUtils.uncapitalize(suffix.substring(op + 3));
        return Restrictions.and(getOneCriterion(first), getOneCriterion(second));
    }

    private Criterion getOrCriterion(String suffix, int op) {
        String first = StringUtils.uncapitalize(suffix.substring(0, op));
        String second = StringUtils.uncapitalize(suffix.substring(op + 2));
        return Restrictions.or(getOneCriterion(first), getOneCriterion(second));
    }


    private Criterion getOneCriterion(String first) {
        if (first.endsWith("Greater")) {
            first = first.substring(0, first.length() - "Greater".length());
            if (!fieldSet.contains(first)) throw new BeautifulException("the property not found");
            Object value = columnValueMap.get(first);
            if (value == null) throw new BeautifulException("the value not found");
            return Restrictions.gt(first, value);
        }
        if (first.endsWith("GreaterOrEqual")) {
            first = first.substring(0, first.length() - "GreaterOrEqual".length());
            if (!fieldSet.contains(first)) throw new BeautifulException("the property not found");
            Object value = columnValueMap.get(first);
            if (value == null) throw new BeautifulException("the value not found");
            return Restrictions.ge(first, value);
        }
        if (first.endsWith("Lesser")) {
            first = first.substring(0, first.length() - "Lesser".length());
            if (!fieldSet.contains(first)) throw new BeautifulException("the property not found");
            Object value = columnValueMap.get(first);
            if (value == null) throw new BeautifulException("the value not found");
            return Restrictions.lt(first, value);
        }
        if (first.endsWith("LesserOrEqual")) {
            first = first.substring(0, first.length() - "LesserOrEqual".length());
            if (!fieldSet.contains(first)) throw new BeautifulException("the property not found");
            Object value = columnValueMap.get(first);
            if (value == null) throw new BeautifulException("the value not found");
            return Restrictions.le(first, value);
        }
        if (!fieldSet.contains(first)) throw new BeautifulException("the property not found");
        Object value = columnValueMap.get(first);
        if (value == null) throw new BeautifulException("the value not found");
        return Restrictions.eq(first, value);
    }
}
