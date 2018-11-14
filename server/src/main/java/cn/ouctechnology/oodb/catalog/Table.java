package cn.ouctechnology.oodb.catalog;

import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.exception.DbException;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 19:26
 * @description: 封装数据库表类, FastJson通过getter来获取属性值
 **/
public class Table implements Cloneable {

    String tableName;//表名
    List<String> primaryKeys;//主键
    List<Attribute> attributes;//属性组
    List<Index> indexes;
    int tupleNum;//表中元组的数量
    int tupleLength;//一个元组的大小

    public Table() {
        primaryKeys = new ArrayList<>();
        attributes = new ArrayList<>();
        indexes = new ArrayList<>();
    }

    public Table(String tableName, List<String> primaryKeys, List<Attribute> attributes, List<Index> indexes, int tupleNum) {
        this.tableName = tableName;
        this.primaryKeys = primaryKeys;
        this.indexes = indexes;
        this.attributes = attributes;
        this.tupleNum = tupleNum;
        for (Attribute attribute : attributes) {
            this.tupleLength += attribute.getLength();
        }
    }

    public synchronized void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public synchronized void addPrimaryKey(String key) {
        primaryKeys.add(key);
    }

    public String getTableName() {
        return tableName;
    }

    public synchronized void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getPrimaryKeys() {
        return primaryKeys;
    }

    public synchronized void setPrimaryKeys(List<String> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public synchronized void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public int getTupleNum() {
        return tupleNum;
    }

    public synchronized void setTupleNum(int tupleNum) {
        this.tupleNum = tupleNum;
    }

    public int getTupleLength() {
        return tupleLength;
    }

    public synchronized void setTupleLength(int tupleLength) {
        this.tupleLength = tupleLength;
    }

    public List<Index> getIndexes() {
        return indexes;
    }

    //todo 完善clone方法
    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new DbException(e);
        }
    }
}
