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
 * @description: session工厂，用于生产session
 **/
public class SessionFactory {

    private volatile static SessionFactory instance;
    private String server;
    private int port;
    //sessionFactory上的二级缓存
    private BeautyCache cache;


    //默认值
    public SessionFactory() {
        this.server = "localhost";
        this.port = 9999;
    }

    public SessionFactory(String server, int port) {
        this.server = server;
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
            String server = "localhost";
            int port = 9999;
            Document document = reader.read(inputStream);
            //获取根节点元素对象
            Element node = document.getRootElement();
            Element beauty = node.element("beauty");
            if (beauty == null) throw new BeautifulException("the xml error");
            Element serverElement = beauty.element("server");
            if (serverElement != null) {
                server = serverElement.getText();
            }
            Element portElement = beauty.element("port");
            if (portElement != null) {
                port = Integer.parseInt(portElement.getText());
            }
            IOUtils.closeQuietly(inputStream);
            //创建单例对象
            if (instance == null) {
                synchronized (SessionFactory.class) {
                    if (instance == null) {
                        return new SessionFactory(server, port);
                    }
                }
            }
            return instance;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
        }

    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void close() {
        instance = null;
        cache = null;
    }

    public Session getSession() {
        return new Session(server, port, this);
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

    public void setCache(BeautyCache cache) {
        this.cache = cache;
    }

    /**
     * 刷新所有的二级缓存
     */
    public void clearCache() {
        cache.clear();
    }

    /**
     * 刷新指定表的二级缓存
     *
     * @param tableName
     */
    public void clearCache(String tableName) {
        Map<String, Object> objectMap = cache.get(tableName);
        if (objectMap != null) objectMap.clear();
    }
}
