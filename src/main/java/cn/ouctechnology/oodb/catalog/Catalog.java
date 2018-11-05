package cn.ouctechnology.oodb.catalog;

import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.dbenum.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

import static cn.ouctechnology.oodb.constant.Constants.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-06 19:35
 * @description: 模式管理类
 **/
public class Catalog {
    private static Logger logger = LoggerFactory.getLogger(Catalog.class);
    private static Map<String, Table> tables = new HashMap<>();


    /**
     * 从文件中读取Catalog信息进内存中
     */
    public static void initialCatalog() throws IOException {
        initialTableCatalog();
    }

    /**
     * 将内存中的Catalog信息写入文件
     */
    public static void storeCatalog() throws IOException {
        storeTableCatalog();
    }

    /**
     * 显示Catalog信息
     */
    public static String showCatalog() {
        return showTableCatalog();
    }

    /**
     * 从文件中读取表的信息进内存中
     *
     * @throws IOException 抛出IOException，告知上层应用停止运行
     */
    private static void initialTableCatalog() throws IOException {
        File file = new File(DB_PATH + TABLE_FILE_NAME + CATALOG_SUFFIX);
        DataInputStream dis = null;
        try {
            if (!file.exists()) {
                return;
            }
            dis = new DataInputStream(new FileInputStream(file));
            while (dis.available() > 0) {
                List<String> primaryKeys = new ArrayList<>();
                String tableName = dis.readUTF();
                int primaryKeyNum = dis.readInt();
                for (int i = 0; i < primaryKeyNum; i++) {
                    primaryKeys.add(dis.readUTF());
                }
                List<Attribute> attributes = readAttributes(dis);
                int tupleNum = dis.readInt();
                tables.put(tableName, new Table(tableName, primaryKeys, attributes, tupleNum));
            }
        } catch (IOException e) {
            throw e;
        } finally {
            //关闭的时候只需要关闭包装流即可
            IOUtils.closeQuietly(dis);
        }
    }

    /**
     * 从文件中读取属性组
     *
     * @param dis
     * @throws IOException
     */
    public static List<Attribute> readAttributes(DataInputStream dis) throws IOException {
        int attributesNum = dis.readInt();
        List<Attribute> attributes = new ArrayList<>();
        for (int i = 0; i < attributesNum; i++) {
            //读取操作交给多态
            Type type = Type.values()[dis.readInt()];
            attributes.add(type.readAttribute(dis));
        }
        return attributes;
    }

    /**
     * 将内存中的表的信息写入文件
     *
     * @throws IOException 抛出IOException，告知上层应用停止运行
     */
    private static void storeTableCatalog() throws IOException {
        File file = new File(DB_PATH + TABLE_FILE_NAME + CATALOG_SUFFIX);
        DataOutputStream dos = null;
        try {
            //创建父目录
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) parentFile.mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }
            dos = new DataOutputStream(new FileOutputStream(file));
            Set<Map.Entry<String, Table>> entries = tables.entrySet();
            for (Map.Entry<String, Table> entry : entries) {
                Table v = entry.getValue();
                dos.writeUTF(v.tableName);
                dos.writeInt(v.primaryKeys.size());
                for (String s : v.primaryKeys) {
                    dos.writeUTF(s);
                }
                //写入属性
                writeAttributes(v.attributes, dos);
                dos.writeInt(v.tupleNum);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            //只需要关闭包装流
            IOUtils.closeQuietly(dos);
        }
    }

    public static void dropTable(String tableName) {
        getTable(tableName);
        tables.remove(tableName);
    }

    /**
     * 将表的属性组写入文件
     *
     * @param attributes
     * @param dos
     * @throws IOException
     */
    public static void writeAttributes(List<Attribute> attributes, DataOutputStream dos) throws IOException {
        dos.writeInt(attributes.size());
        for (Attribute attribute : attributes) {
            //将写入操作委托给Attribute
            attribute.writeAttribute(dos);
        }
    }


    /**
     * 显示表信息
     */
    private static String showTableCatalog() {
        StringBuilder sb = new StringBuilder();
        sb.append("There are ").append(tables.size()).append(" tables in the database: ").append('\n');
        Set<Map.Entry<String, Table>> entries = tables.entrySet();
        int count = 1;
        for (Map.Entry<String, Table> entry : entries) {
            Table v = entry.getValue();
            sb.append("\nTable ").append(count++).append('\n');
            sb.append("Table name: ").append(v.tableName).append('\n');
            sb.append("Length of tuple: ").append(v.tupleLength).append('\n');
            sb.append("Primary key: ").append(v.primaryKeys).append('\n');
            sb.append("Number of tuples: ").append(v.tupleNum).append('\n');
            sb.append("Attributes: ").append(v.attributes.size()).append('\n');
            //格式化打印属性组，使用Jackson
            ObjectMapper mapper = new ObjectMapper();
            try {
                sb.append(mapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(v.attributes)).append('\n');
            } catch (JsonProcessingException e) {
                logger.error("Print attribute error:" + e.getMessage());
            }
        }
        return sb.toString();
    }

    /**
     * 创建新的表
     *
     * @param table
     */
    public static void createTable(Table table) {
        if (tables.containsKey(table.tableName)) {
            throw new IllegalArgumentException("The table:" + table.tableName + " is already exited in the database!");
        }
        tables.put(table.tableName, table);
    }

    /**
     * 根据表名获取表
     */
    public static Table getTable(String tableName) {
        Table table = tables.get(tableName);
        if (table == null) throw new IllegalArgumentException("file:" + tableName + " not found");
        return table;
    }


    /**
     * 获取表tableName名字为name的属性
     */
    public static Attribute getAttribute(String tableName, String name) {
        Table table = getTable(tableName);
        return getAttribute(table.attributes, name);
    }

    public static Attribute getAttribute(List<Attribute> attributes, String name) {
        for (Attribute attribute : attributes) {
            Attribute res = attribute.getAttribute(name);
            if (res != null) return res;
        }
        throw new IllegalArgumentException("type of:" + name + " not found");
    }

    /**
     * 获取表tableName名字为name的属性在整个元组中的偏移量
     */
    public static int getAttributeOffset(String tableName, String attributeName) {
        Table table = getTable(tableName);
        return getAttributeOffset(table.getAttributes(), attributeName);
    }

    private static int getAttributeOffset(List<Attribute> attributes, String attributeName) {
        int offset = 0;
        for (Attribute attribute : attributes) {
            int res = attribute.getOffset(attributeName, offset);
            if (res != NOT_FOUND) return res;
            offset += attribute.getLength();
        }
        throw new IllegalArgumentException("type of:" + attributeName + " not found");
    }

    /**
     * 获取表tableName的第index个属性
     */
    public static Attribute getAttribute(String tableName, int index) {
        Table table = getTable(tableName);
        return table.attributes.get(index);
    }

    /**
     * 获取全部的属性
     */
    public static List<Attribute> getAttributes(String tableName) {
        Table table = getTable(tableName);
        return table.attributes;
    }

    public static int getAttributeNum(String tableName) {
        Table table = getTable(tableName);
        return table.attributes.size();
    }

    /**
     * 获取表元组的大小
     */
    public static int getTupleLength(String tableName) {
        Table table = getTable(tableName);
        return table.tupleLength;
    }

    /**
     * 获取表当前元组的数量
     */
    public static int getTupleNum(String tableName) {
        Table table = getTable(tableName);
        return table.tupleNum;
    }


    /**
     * 添加元组数量
     */
    public static void addTupleNum(String tableName) {
        Table table = getTable(tableName);
        table.tupleNum++;
    }

}


