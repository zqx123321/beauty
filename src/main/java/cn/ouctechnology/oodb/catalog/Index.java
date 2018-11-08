package cn.ouctechnology.oodb.catalog;

import cn.ouctechnology.oodb.btree.BTree;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-06 15:31
 * @description: TODO
 **/
public class Index {
    String tableName;
    String indexName;
    String columnName;
    Attribute attribute;
    BTree bTree;

    public Index(String tableName, String indexName, String columnName, int rootNo, int lastNo, Attribute attribute) {
        this.tableName = tableName;
        this.indexName = indexName;
        this.columnName = columnName;
        this.attribute = attribute;
        this.bTree = attribute.getType().createBTree(tableName + "." + indexName, attribute, lastNo, rootNo);
    }

    public String getTableName() {
        return tableName;
    }

    public String getIndexName() {
        return indexName;
    }

    public String getColumnName() {
        return columnName;
    }


    public Attribute getAttribute() {
        return attribute;
    }

    public BTree getbTree() {
        return bTree;
    }

    @Override
    public String toString() {
        return "{" +
                "indexName='" + indexName + '\'' +
                ", columnName='" + columnName + '\'' +
                '}';
    }
}
