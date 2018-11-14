package cn.ouctechnology.oodb.beauty.test;

import cn.ouctechnology.oodb.beauty.SpringTest;
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
}