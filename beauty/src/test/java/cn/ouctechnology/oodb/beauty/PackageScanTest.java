package cn.ouctechnology.oodb.beauty;

import cn.ouctechnology.oodb.beauty.session.Session;
import cn.ouctechnology.oodb.beauty.session.SessionFactory;
import cn.ouctechnology.oodb.beauty.test.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 20:34
 * @description: TODO
 **/
public class PackageScanTest extends SpringTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDao userDao;


    @Test
    public void testSession() {
        Session session = sessionFactory.getSession();
        UserDao beautiful = session.getBeautiful(UserDao.class);
        System.out.println(beautiful.list());
        session.close();
    }

    @Test
    public void testScan() {
        System.out.println(userDao.list());
    }

}
