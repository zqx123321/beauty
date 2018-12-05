package cn.ouctechnology.oodb.beauty;

import cn.ouctechnology.oodb.beauty.criteria.*;
import cn.ouctechnology.oodb.beauty.session.BeautyProxy;
import cn.ouctechnology.oodb.beauty.session.Predicate;
import cn.ouctechnology.oodb.beauty.session.Session;
import cn.ouctechnology.oodb.beauty.session.SessionFactory;
import cn.ouctechnology.oodb.beauty.test.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
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
        SessionFactory sessionFactory = SessionFactory.getFactoryByXml("classpath:oodb.xml");
        this.session = sessionFactory.getSession();
    }

    @After
    public void close() {
        if (session != null) session.close();
    }

    @Test
    public void getSessionFactory() {

        UserDao userDao = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[]{UserDao.class}, new BeautyProxy(session));
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
                return user.getId() == 1 && user.getName().equals("tom");
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

    @Test
    public void testCreate() {
        System.out.println(session.drop(Teacher.class));
        System.out.println(session.create(Teacher.class));
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("ddd");
        List<Integer> students = new ArrayList<>();
        students.add(1);
        students.add(2);
        students.add(3);
        students.add(4);
        students.add(5);

        teacher.setStudents(students);
        System.out.println(session.save(teacher));
        List<Teacher> teacherList = session.createQuery("select a from teacher a").list(Teacher.class);
        for (Teacher t : teacherList) {
            System.out.println(t);
        }

    }

    @Test
    public void testPolicy() {
        session.drop(Person.class);
        session.create(Person.class);
        System.out.println(session.createOql("show tables"));


    }


    @Test
    public void testPaper() {
//        List<User> list = session.createCriteria(User.class)
//                .setProjection(Projections.projectionList()
//                        .add(Projections.property("id"))
//                        .add(Projections.property("name"))
//                )
//                .list();


        Object count = session.createCriteria(User.class)
                .setProjection(Projections.count("id")).uniqueResult(Integer.class);

//        Object max = session.createCriteria(User.class)
//                .setProjection(Projections.max("id")).uniqueResult();


        UserDao userDao = session.getBeautiful(UserDao.class);

    }


}