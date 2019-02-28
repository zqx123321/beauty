package cn.ouctechnology.oodb.beauty.conections;

import cn.ouctechnology.oodb.beauty.SpringTest;
import cn.ouctechnology.oodb.beauty.criteria.Restrictions;
import cn.ouctechnology.oodb.beauty.session.Session;
import cn.ouctechnology.oodb.beauty.session.SessionFactory;
import cn.ouctechnology.oodb.beauty.test.Person;
import cn.ouctechnology.oodb.beauty.test.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-19 15:24
 * @description: TODO
 **/
public class SessionPoolTest extends SpringTest {


//    @Autowired
//    private SessionPool sessionPool;

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    public void getSession() throws InterruptedException {
//        Session session = sessionPool.getSession();
//        System.out.println(session);
//        sessionPool.closeSession(session);
//        System.out.println(sessionPool.getSession());
        System.out.println(sessionFactory);
        Session session = sessionFactory.getSession();
        System.out.println(session);
        sessionFactory.closeSession(session);
        System.out.println(sessionFactory.getSession());
    }

    @Test
    public void cacheSession() {
        Session session = sessionFactory.getSession();
        System.out.println(session.createCriteria(Person.class).add(Restrictions.eq("id", 2)).uniqueResult());
//        Person person = new Person();
//        person.setName("SAD");
//        session.update(person, Restrictions.eq("id", 5));

        System.out.println(session.createCriteria(Person.class).add(Restrictions.eq("id", 2)).uniqueResult(User.class));

        session = sessionFactory.getSession();
        System.out.println(session.createCriteria(Person.class).add(Restrictions.eq("id", 2)).uniqueResult());
    }
}