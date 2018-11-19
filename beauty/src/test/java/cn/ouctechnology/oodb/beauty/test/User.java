package cn.ouctechnology.oodb.beauty.test;

import cn.ouctechnology.oodb.beauty.annotation.Length;
import cn.ouctechnology.oodb.beauty.annotation.Size;

import java.util.List;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 10:35
 * @description: TODO
 **/
public class User {

    private int id;

    @Length(20)
    private String name;

    private Dept dept;

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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }
}
