package cn.ouctechnology.oodb.test;

import cn.ouctechnology.oodb.beautiful.annotation.Beautiful;
import cn.ouctechnology.oodb.beautiful.annotation.Insert;
import cn.ouctechnology.oodb.beautiful.annotation.Select;

import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 10:35
 * @description: TODO
 **/
@Beautiful
public interface UserDao {

    @Insert("insert into user values(1,'dd',(2,'eee'))")
    int insert(User user);

    @Select("select a from user a")
    List<User> list();

    @Select("select a from user a where a.id=#{id}")
    User get(int id);

    @Select("select max(a.id) from user a")
    int getMax();


}
