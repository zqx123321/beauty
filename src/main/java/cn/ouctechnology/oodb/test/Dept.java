package cn.ouctechnology.oodb.test;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-12 19:29
 * @description: TODO
 **/
public class Dept {

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
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
