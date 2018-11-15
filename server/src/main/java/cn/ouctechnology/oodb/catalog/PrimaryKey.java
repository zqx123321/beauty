package cn.ouctechnology.oodb.catalog;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-14 21:07
 * @description: TODO
 **/
public class PrimaryKey {
    String name;
    PrimaryKeyPolicy policy;

    public PrimaryKey(String name, PrimaryKeyPolicy policy) {
        this.name = name;
        this.policy = policy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrimaryKeyPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(PrimaryKeyPolicy policy) {
        this.policy = policy;
    }


    @Override
    public String toString() {
        return "PrimaryKey{" +
                "name='" + name + '\'' +
                ", policy=" + policy +
                '}';
    }

    public enum PrimaryKeyPolicy {
        ASSIGN, AUTO_INCREASE, UUID
    }
}
