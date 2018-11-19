package cn.ouctechnology.oodb.beauty.test;

import cn.ouctechnology.oodb.beauty.annotation.*;
import cn.ouctechnology.oodb.beauty.session.BaseBeauty;

import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 14:18
 * @description: TODO
 **/
@Beauty
public interface PersonDao extends BaseBeauty<Person> {

    @Select("select a from person a")
    List<Person> list();

    @NoCached
    @Select("select a from person a where a.id=#{id}")
    Person get(int id);

    @Update("update person a set a.name=#{name} where a.id=#{id}")
    int update(Person person);

    @NoFlush
    @Insert("insert into person values(#{id}, #{name})")
    int insert(Person person);

    List<Person> findByNameOrIdGreater(@Param("name") String name, @Param("id") Integer id);

    Person findById(@Param("id") Integer id);

    int deleteById(@Param("id") int id);

    int updateByIdOrName(Person person, @Param("name") String name, @Param("id") Integer id);

}
