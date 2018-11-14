package cn.ouctechnology.oodb.beautiful.session;

import cn.ouctechnology.oodb.beautiful.annotation.Beautiful;
import cn.ouctechnology.oodb.exception.DbException;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.reflections.Reflections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 12:08
 * @description: TODO
 **/
public class SessionFactory {

    private static String domain;

    private static int port;

    private static String scanPackage;

    private volatile static SessionFactory instance;

    //static Map<Class, Object> beautifulMap;

    private SessionFactory() {
        if (domain == null || port == 0 || scanPackage == null) throw new DbException("the xml has not be loaded");
       // beautifulMap = new HashMap<>();
//        Reflections reflections = new Reflections(scanPackage);
//        Set<Class<?>> beautifulSet = reflections.getTypesAnnotatedWith(Beautiful.class);
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null) {
            synchronized (SessionFactory.class) {
                if (instance == null) {
                    return new SessionFactory();
                }
            }
        }
        return instance;
    }

    public static void loadXml(String path) {
        if (instance != null) throw new DbException("the session factory has be opened");
        InputStream inputStream;
        if (path.startsWith("classpath:")) {
            inputStream = ClassLoader.getSystemResourceAsStream(path.replaceAll("classpath:", ""));
        } else {
            try {
                inputStream = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new DbException(e);
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
            if (server == null) throw new DbException("the xml error");
            Element domainElement = server.element("domain");
            if (domainElement == null) throw new DbException("the xml error");
            Element portElement = server.element("port");
            if (portElement == null) throw new DbException("the xml error");
            Element scanPackageElement = node.element("package");
            if (scanPackageElement == null) throw new DbException("the xml error");
            domain = domainElement.getText();
            port = Integer.parseInt(portElement.getText());
            scanPackage = scanPackageElement.getText();
            IOUtils.closeQuietly(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new DbException(e);
        }

    }

    public void close() {
        domain = null;
        port = 0;
        scanPackage = null;
        instance = null;
      //  beautifulMap = null;
    }

    public Session getSession() {
        return new Session(domain, port);
    }

}
