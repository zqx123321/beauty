package cn.ouctechnology.oodb.beauty.criteria;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-13 09:45
 * @description: 多条件OR操作
 **/
public class Disjunction extends Junction {
    /**
     * Constructs a Disjunction
     */
    protected Disjunction() {
        super(Nature.OR);
    }

    Disjunction(Criterion[] conditions) {
        super(Nature.OR, conditions);
    }
}