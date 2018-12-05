package cn.ouctechnology.oodb.reocrd;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-29 21:14
 * @description: 字段类型
 **/
public class Field {
    private String name;

    public Field(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
