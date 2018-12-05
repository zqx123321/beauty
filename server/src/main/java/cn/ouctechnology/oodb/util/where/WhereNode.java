package cn.ouctechnology.oodb.util.where;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-09 15:41
 * @description: 逻辑表达式树结构
 **/
public interface WhereNode {

    WhereNode getLeft();

    WhereNode getRight();
}
