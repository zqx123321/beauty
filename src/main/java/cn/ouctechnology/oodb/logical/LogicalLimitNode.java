package cn.ouctechnology.oodb.logical;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-31 15:53
 * @description: TODO
 **/
public class LogicalLimitNode {
    private int start;
    private int size;

    public LogicalLimitNode(int start, int size) {
        this.start = start;
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }
}
