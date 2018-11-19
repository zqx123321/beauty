package cn.ouctechnology.oodb.beauty.test;

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
    private int id;

    @Length(20)
    private String name;

    @Size(5)
    private List<Float> student;

    @Size(5)
    private List<Dept> dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Float> getStudent() {
        return student;
    }

    public void setStudent(List<Float> student) {
        this.student = student;
    }

    public List<Dept> getDept() {
        return dept;
    }

    public void setDept(List<Dept> dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", dept=" + dept +
                '}';
    }
}
