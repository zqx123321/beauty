package cn.ouctechnology.oodb.beauty.test;

import cn.ouctechnology.oodb.beauty.annotation.Beauty;
import cn.ouctechnology.oodb.beauty.annotation.Insert;
import cn.ouctechnology.oodb.beauty.annotation.Select;
import cn.ouctechnology.oodb.beauty.annotation.Update;

import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 14:18
 * @description: TODO
 **/
@Beauty
public interface PersonDao {

    @Select("select a from person a")
    List<Person> list();

    @Select("select a from person a where a.id=#{id}")
    Person get(int id);

    @Update("update person a set a.name=#{name} where a.id=#{id}")
    int update(Person person);

    @Insert("insert into person values(#{id}, #{name})")
    int insert(Person person);

}
