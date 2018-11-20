package cn.ouctechnology.oodb.beauty.conections;

import cn.ouctechnology.oodb.beauty.exception.BeautifulException;
import cn.ouctechnology.oodb.beauty.session.Session;
import cn.ouctechnology.oodb.beauty.session.SessionFactory;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-19 15:47
 * @description: TODO
 **/
public class FactoryDecorator extends SessionFactory {

    private SessionPool sessionPool;

    public SessionPool getSessionPool() {
        return sessionPool;
    }

    public void setSessionPool(SessionPool sessionPool) {
        this.sessionPool = sessionPool;
    }

    public FactoryDecorator(String server, int port) {
        super(server, port);
    }

    public FactoryDecorator() {
        super();
    }


    @Override
    public Session getSession() {
        try {
            return sessionPool.getSession();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new BeautifulException(e);
        }
    }

    @Override
    public void closeSession(Session session) {
        sessionPool.closeSession(session);
    }
}
