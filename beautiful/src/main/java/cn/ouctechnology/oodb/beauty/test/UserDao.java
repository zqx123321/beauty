package cn.ouctechnology.oodb.beauty.test;

import cn.ouctechnology.oodb.beauty.annotation.Beauty;
import cn.ouctechnology.oodb.beauty.annotation.Insert;
import cn.ouctechnology.oodb.beauty.annotation.Select;

import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 10:35
 * @description: TODO
 **/
@Beauty
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
