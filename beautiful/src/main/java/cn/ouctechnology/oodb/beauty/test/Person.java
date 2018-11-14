package cn.ouctechnology.oodb.beauty.test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 14:18
 * @description: TODO
 **/
public class Person extends Dept {

    private int id;

    private String name;


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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
