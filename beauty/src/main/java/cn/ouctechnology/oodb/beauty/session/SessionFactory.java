package cn.ouctechnology.oodb.beauty.session;

import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 12:08
 * @description: TODO
 **/
public class SessionFactory {

    private String domain;

    private int port;

    private volatile static SessionFactory instance;


    //sessionFactory上的二级缓存
    private BeautyCache cache;


    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setCache(BeautyCache cache) {
        this.cache = cache;
    }

    //默认值
    public SessionFactory() {
        this.domain = "localhost";
        this.port = 9999;
    }

    public SessionFactory(String domain, int port) {
        this.domain = domain;
        this.port = port;
    }

    /**
     * 根据xml创建sessionFactory,全局单例
     *
     * @param path
     * @return
     */
    @SuppressWarnings("all")
    public static SessionFactory getFactoryByXml(String path) {
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
            Document document = reader.read(inputStream);
            //获取根节点元素对象
            Element node = document.getRootElement();
            Element server = node.element("server");
            if (server == null) throw new BeautifulException("the xml error");
            Element domainElement = server.element("domain");
            if (domainElement == null) throw new BeautifulException("the xml error");
            Element portElement = server.element("port");
            if (portElement == null) throw new BeautifulException("the xml error");
            String domain = domainElement.getText();
            int port = Integer.parseInt(portElement.getText());
            IOUtils.closeQuietly(inputStream);
            //创建单例对象
            if (instance == null) {
                synchronized (SessionFactory.class) {
                    if (instance == null) {
                        return new SessionFactory(domain, port);
                    }
                }
            }
            return instance;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
        }

    }

    public void close() {
        instance = null;
        cache = null;
    }

    public Session getSession() {
        return new Session(domain, port, this);
    }

    public void closeSession(Session session) {
        session.close();
    }

    public boolean isCached() {
        return cache != null;
    }

    public BeautyCache getCache() {
        return cache;
    }

    public void clearCache() {
        cache.clear();
    }

    public void clearCache(String tableName) {
        Map<String, Object> objectMap = cache.get(tableName);
        if (objectMap != null) objectMap.clear();
    }
}
