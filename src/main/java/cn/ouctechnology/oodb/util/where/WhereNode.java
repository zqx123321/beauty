package cn.ouctechnology.oodb.util.where;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-09 15:41
 * @description: TODO
 **/
public interface WhereNode {

    WhereNode getLeft();

    WhereNode getRight();
}
