package cn.ouctechnology.oodb.beauty.conections;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-19 14:34
 * @description: TODO
 **/

import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import cn.ouctechnology.oodb.beauty.session.Session;
import cn.ouctechnology.oodb.beauty.session.SessionFactory;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 自定义简易数据库连接池
 */
public class SessionPool implements InitializingBean, BeanDefinitionRegistryPostProcessor {
    private volatile static SessionPool instance;
    private final LinkedList<Session> sessionList = new LinkedList<>();// 储存空闲Connection链接的集合和(涉及多次添加、删除操作、故而用LinkedList)
    private Logger logger = LoggerFactory.getLogger(SessionPool.class);
    private int initialSize;// 最小连接数
    private int maxActive;// 最大连接数
    private int maxIdle;//最大空闲时间
    private SessionFactory sessionFactory;//创建连接的sessionFactory

    public SessionPool() {
        initialSize = 1;
        maxActive = 5;
        maxIdle = 60000;
    }

    public SessionPool(SessionFactory sessionFactory, int initialSize, int maxActive, int maxIdle) {
        this.initialSize = initialSize;
        this.maxActive = maxActive;
        this.maxIdle = maxIdle;
        this.sessionFactory = sessionFactory;
    }

    /**
     * 根据xml创建sessionFactory,全局单例
     *
     * @param path
     * @return
     */
    @SuppressWarnings("all")
    public static SessionPool getPoolByXml(String path, SessionFactory sessionFactory) {
        if (instance != null) return instance;
        InputStream inputStream;
        if (path.startsWith("classpath:")) {
            inputStream = ClassLoader.getSystemResourceAsStream(path.replaceAll("classpath:", ""));
        } else {
            try {
                inputStream = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new BeautifulException(e);
            }
        }
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        try {
            int initialSize = 1;
            int maxActiveSize = 5;
            int maxIdleSize = 60000;
            Document document = reader.read(inputStream);
            //获取根节点元素对象
            Element node = document.getRootElement();
            Element server = node.element("pool");
            if (server == null) throw new BeautifulException("the xml error");
            Element initialSizeElement = server.element("initialSize");
            if (initialSizeElement != null) {
                initialSize = Integer.parseInt(initialSizeElement.getText());
            }
            Element maxActiveElement = server.element("maxActive");
            if (maxActiveElement != null) {
                maxActiveSize = Integer.parseInt(maxActiveElement.getText());
            }

            Element maxIdleElement = server.element("maxIdle");
            if (maxIdleElement != null) {
                maxIdleSize = Integer.parseInt(maxIdleElement.getText());
            }
            IOUtils.closeQuietly(inputStream);
            //创建单例对象
            if (instance == null) {
                synchronized (SessionFactory.class) {
                    if (instance == null) {
                        SessionPool sessionPool = new SessionPool(sessionFactory, initialSize, maxActiveSize, maxIdleSize);
                        sessionPool.init();
                        return sessionPool;
                    }
                }
            }
            return instance;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
        }
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void init() {
        for (int i = 0; i < initialSize; i++) {
            sessionList.add(sessionFactory.getSession());
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    int current = sessionList.size();
                    if (current > initialSize) {
                        logger.info("clear {} idle session.....", current - initialSize);
                        for (int i = 0; i < current - initialSize; i++) {
                            Session session = getSession();
                            session.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, maxIdle);
    }

    @Override
    public void afterPropertiesSet() {
        if (sessionFactory.getClass() == SessionFactory.class)
            init();
    }

    public Session getSession(long timeoutTime) throws InterruptedException {
        synchronized (sessionList) {
            if (timeoutTime <= 0) {
                while (sessionList.isEmpty()) {
                    if (sessionList.size() < maxActive) {
                        addSession();
                    } else {
                        sessionList.wait();
                    }
                }
                return sessionList.removeFirst();
            }
            long future = System.currentTimeMillis() + timeoutTime;
            long remaining = timeoutTime;
            while (sessionList.isEmpty() && remaining > 0) {
                sessionList.wait(remaining);
                remaining = future - System.currentTimeMillis();
            }
            Session result = null;
            if (!sessionList.isEmpty()) {
                result = sessionList.removeFirst();
            }
            return result;
        }
    }

    public Session getSession() throws InterruptedException {
        synchronized (sessionList) {
            while (sessionList.isEmpty()) {
                if (sessionList.size() < maxActive) {
                    addSession();
                } else {
                    sessionList.wait();
                }
            }
            return sessionList.removeFirst();
        }
    }

    public void addSession() {
        if (sessionList.size() > maxActive) throw new BeautifulException("the session count has reach the max size");
        synchronized (sessionList) {
            Session session = sessionFactory.getSession();
            sessionList.add(session);
        }
    }

    public void closeSession(Session conn) {
        if (conn != null) {
            synchronized (sessionList) {
                sessionList.addLast(conn);
                sessionList.notifyAll();
            }
        }
    }

    public void close() {
        instance = null;
        sessionList.clear();
    }


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //删除原来的定义
        beanDefinitionRegistry.removeBeanDefinition("sessionFactory");
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(FactoryDecorator.class);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        definition.getPropertyValues().add("sessionPool", this);
        definition.setBeanClass(FactoryDecorator.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        // 注册bean名,一般为类名首字母小写
        beanDefinitionRegistry.registerBeanDefinition(StringUtils.uncapitalize(SessionFactory.class.getSimpleName()), definition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
