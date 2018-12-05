package cn.ouctechnology.oodb.beauty.conections;

import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import cn.ouctechnology.oodb.beauty.session.Session;
import cn.ouctechnology.oodb.beauty.session.SessionFactory;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-19 15:47
 * @description: SessionFactory装饰类，使其能够使用连接池
 **/
public class FactoryDecorator extends SessionFactory {

    private SessionPool sessionPool;

    public FactoryDecorator(String server, int port) {
        super(server, port);
    }

    public FactoryDecorator() {
        super();
    }

    public SessionPool getSessionPool() {
        return sessionPool;
    }

    public void setSessionPool(SessionPool sessionPool) {
        this.sessionPool = sessionPool;
    }

    /**
     * 覆写getSession方法，用于从连接池中获取session
     *
     * @return
     */
    @Override
    public Session getSession() {
        try {
            return sessionPool.getSession();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
        }
    }

    /**
     * 覆写closeSession方法，用于将session归还给连接池
     *
     * @param session
     */
    @Override
    public void closeSession(Session session) {
        sessionPool.closeSession(session);
    }
}
