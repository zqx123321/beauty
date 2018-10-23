package cn.ouctechnology.oodb.explain.drop;

import cn.ouctechnology.oodb.parser.OQLParser;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-19 15:46
 * @description: TODO
 **/
public class DropExplain {
    public int doDrop() {
        return 0;
    }

    public static DropExplain getDropStatContext(OQLParser.DropStatContext drop) {
        return new DropExplain();
    }
}
