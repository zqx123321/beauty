package cn.ouctechnology.oodb.beauty;

import cn.ouctechnology.oodb.beauty.session.Predicate;
import cn.ouctechnology.oodb.beauty.session.Session;
import cn.ouctechnology.oodb.beauty.session.SessionFactory;
import cn.ouctechnology.oodb.beauty.test.Person;
import cn.ouctechnology.oodb.beauty.test.PersonDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 14:22
 * @description: TODO
 **/
public class PersonDaoTest extends SpringTest {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void list() {
        System.out.println(personDao.list());
    }

    @Test
    public void get() {
        System.out.println(personDao.get(55));
    }

    @Test
    public void update() {
        Person person = new Person();
        person.setId(55);
        person.setName("aaaaa");
        System.out.println(personDao.update(person));
    }

    @Test
    public void insert() {
        Person person = new Person();
        person.setId(55);
        person.setName("aaaaa");
        System.out.println(personDao.insert(person));
    }

    @Test
    public void testBaseBeauty() {
        System.out.println(personDao.selectList(null));
        System.out.println(personDao.findById(3));
    }

    @Test
    public void testSession() {
        Session session = sessionFactory.getSession();
        System.out.println(session.query(new Predicate<Person>() {
            @Override
            public boolean match(Person person) {
                return person.getDept().getId() == 1;
            }

            @Override
            public Class getGenericClass() {
                return Person.class;
            }
        }));
    }
}