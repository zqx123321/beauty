package cn.ouctechnology.oodb.beautiful;

import cn.ouctechnology.oodb.beautiful.criteria.Criteria;
import cn.ouctechnology.oodb.beautiful.criteria.Criterion;
import cn.ouctechnology.oodb.beautiful.criteria.Joins;
import cn.ouctechnology.oodb.beautiful.criteria.Restrictions;
import cn.ouctechnology.oodb.beautiful.session.BeautifulHandler;
import cn.ouctechnology.oodb.beautiful.session.Predicate;
import cn.ouctechnology.oodb.beautiful.session.Session;
import cn.ouctechnology.oodb.beautiful.session.SessionFactory;
import cn.ouctechnology.oodb.test.Dept;
import cn.ouctechnology.oodb.test.User;
import cn.ouctechnology.oodb.test.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 12:25
 * @description: TODO
 **/
public class SessionFactoryTest {

    private Session session;


    @Before
    public void init() {
        SessionFactory.loadXml("classpath:oodb.xml");
        SessionFactory sessionFactory = SessionFactory.getSessionFactory();
        this.session = sessionFactory.getSession();
    }

    @After
    public void close() {
        if (session != null) session.close();
    }

    @Test
    public void getSessionFactory() {

        UserDao userDao = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[]{UserDao.class}, new BeautifulHandler(session));
        List<User> list = userDao.list();
        System.out.println(list);
        session.close();
        //        Query query = session.createQuery("select a from user a");
//        System.out.println(query.list());
//        List<User> users = query.list(User.class);
//        users.forEach(System.out::println);
//        Query query = session.createQuery("insert into user values(4,'ff',(5,'dew'))");
//        int update = query.update();
//        System.out.println(update);

//        Query query = session.createQuery("select a from user a");
//        System.out.println(query.firstResult(User.class));
    }

    @Test
    public void testSave() {
        User user = new User();
        Dept dept = new Dept();
        dept.setName("fef");
        dept.setId(434);
        user.setId(444);
        user.setName("ded");
        user.setDept(dept);
        System.out.println(session.save(user));
    }

    @Test
    public void testCriteria() {
        Criteria criteria = session.createCriteria(User.class);
        Criterion criterion = Restrictions.disjunction(
                Restrictions.eq("name", "dd")
                , Restrictions.gt("id", 2));
        criteria.add(criterion);

        System.out.println(criteria.list());
    }

    @Test
    public void testProject() {
        Criteria criteria = session.createCriteria(User.class);
        criteria.setDistinct();
        System.out.println(criteria.list());
        System.out.println(criteria.getOql());
    }

    @Test
    public void testJoin() {
        Criteria criteria = session.createCriteria(User.class, "u");
        criteria.addJoinCondition(Joins.none(Dept.class, "d"));
        System.out.println(criteria.getOql());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        Dept dept = new Dept();
        dept.setName("fef");
        dept.setId(434);
        user.setId(444);
        user.setName("ded");
        user.setDept(dept);
        session.update(user, Restrictions.eq("id", 1));
    }

    @Test
    public void testDelete() {
        session.delete(User.class, Restrictions.or(Restrictions.eq("id", 1)
                , Restrictions.ge("name", "dsad")));
    }

    @Test
    public void testQbe() {
        User user = new User();
        user.setId(1);
        System.out.println(session.queryByExample(user));
    }

    @Test
    public void testPredicate() {
        List<User> query = session.query(new Predicate<User>() {
            @Override
            public boolean match(User user) {
                return user.getId() == 1;
            }

            @Override
            public Class getGenericClass() {
                return User.class;
            }
        });
        System.out.println(query);
    }

    @Test
    public void testGetBeautiful() {
        UserDao beautiful = session.getBeautiful(UserDao.class);
        User user = new User();
        user.setId(1);
        Dept dept = new Dept();
        dept.setId(1);
        user.setDept(dept);
        System.out.println(beautiful.get(1));
    }


}