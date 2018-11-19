package cn.ouctechnology.oodb.beauty;

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
        person.setName("dsdsd");
        System.out.println(personDao.insert(person));
    }

    @Test
    public void testBaseBeauty() {
        // Session session = sessionFactory.getSession();

//        System.out.println(session.drop(Person.class));
//        System.out.println(session.create(Person.class));
        // System.out.println(personDao.selectList(null));
//        for (int i = 0; i < 10; i++) {
//            Person person = new Person();
//            person.setName("hh" + i);
//            System.out.println(personDao.save(person));
//        }

        System.out.println(personDao.selectList(null));
        Person person = new Person();
        person.setName("hhhhh");
        person.setId(33);
        personDao.insert(person);
        System.out.println(personDao.selectList(null));

        //System.out.println(personDao.findByNameOrId("hh2", 6));

        //System.out.println(personDao.deleteById(3));

//        Person person = new Person();
//        person.setName("rrr");
//        System.out.println(personDao.updateByIdOrName(person, "hh1", 5));
//        System.out.println(personDao.selectList(null));

        //  System.out.println(personDao.findById(1));
        // System.out.println(personDao.findByNameOrIdGreater("hh1", 5));

    }
}