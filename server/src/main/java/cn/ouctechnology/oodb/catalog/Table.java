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
    PrimaryKey primaryKey;//主键
    List<Attribute> attributes;//属性组
    List<Index> indexes;//主键
    List<String> refs;//引用表
    List<String> extendTables;//继承表
    int tupleNum;//表中元组的数量
    int tupleLength;//一个元组的大小
    int maxId;

    public Table() {
        attributes = new ArrayList<>();
        refs = new ArrayList<>();
        extendTables = new ArrayList<>();
        indexes = new ArrayList<>();
        this.maxId = 0;
    }

    public Table(String tableName, PrimaryKey primaryKey, List<Attribute> attributes, List<String> refs, List<String> extendTables, List<Index> indexes, int tupleNum) {
        this.tableName = tableName;
        this.primaryKey = primaryKey;
        this.indexes = indexes;
        this.refs = refs;
        this.extendTables = extendTables;
        this.attributes = attributes;
        this.tupleNum = tupleNum;
        this.maxId = 0;
        for (Attribute attribute : attributes) {
            this.tupleLength += attribute.getLength();
        }
    }

    public synchronized void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public String getTableName() {
        return tableName;
    }

    public void setExtendTables(List<String> extendTables) {
        this.extendTables = extendTables;
    }

    public void setRefs(List<String> refs) {
        this.refs = refs;
    }

    public List<String> getRefs() {
        return refs;
    }

    public List<String> getExtendTables() {
        return extendTables;
    }

    public synchronized void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public PrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public synchronized void setPrimaryKey(PrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
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

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
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
