package cn.ouctechnology.oodb.beauty.test;

import cn.ouctechnology.oodb.beauty.annotation.Id;
import cn.ouctechnology.oodb.beauty.annotation.Length;
import cn.ouctechnology.oodb.beauty.annotation.Size;

import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 17:04
 * @description: TODO
 **/
public class Teacher {
    @Id(Id.Policy.AUTO_INCREMENT)
    private Integer id;

    @Length(20)
    private String name;

    @Size(5)
    private List<Integer> students;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getStudents() {
        return students;
    }

    public void setStudents(List<Integer> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
