package cn.ouctechnology.oodb.beautiful.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 09:45
 * @description: TODO
 **/
public class Conjunction extends Junction {
    /**
     * Constructs a Conjunction
     */
    public Conjunction() {
        super( Nature.AND );
    }

    Conjunction(Criterion... criterion) {
        super( Nature.AND, criterion );
    }
}
