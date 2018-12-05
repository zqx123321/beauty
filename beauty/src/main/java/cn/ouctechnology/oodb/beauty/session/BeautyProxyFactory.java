package cn.ouctechnology.oodb.beauty.session;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 12:10
 * @description: Beauty的FactoryBean，用于产生JDK动态代理后的Beauty
 **/
public class BeautyProxyFactory<T> implements FactoryBean<T> {
    private Class<T> interfaceClass;
    private Session session;

    public Class<T> getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public T getObject() throws Exception {
        return (T) new BeautyProxy(session).bind(interfaceClass);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    @Override
    public boolean isSingleton() {
        // 单例模式
        return true;
    }
}
