package cn.ouctechnology.oodb.constant;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-07 10:50
 * @description: 封装常量类
 **/
public class Constants {
    //数据库文件存放目录
    public static final String DB_PATH = "db/";
    //目录文件后缀
    public static final String CATALOG_SUFFIX = ".catalog";
    public static final String NO_GROUPING = "NO_GROUPING";
    //存放模式信息的文件
    public static String TABLE_FILE_NAME = "table";
    //在CRUD过程中操作失败返回FAIL
    public static final int FAIL = -1;
    //在获取偏移量的时候没找到
    public static final int NOT_FOUND = -1;
    //一个缓冲区块的大小
    public static final int BLOCK_SIZE = 8 * 1024;
    //缓冲区中可容纳的最大区块数量
    public static final int MAX_NUM_OF_BLOCKS = 50;
    //INT类型所占字节数
    public static final int SIZE_INT = 4;
    //FLOAT类型所占字节数
    public static final int SIZE_FLOAT = 4;
    //空闲链表结尾标志
    public static final int FREE_LIST_EOF = 0;
    //数据文件后缀
    public static final String RECORD_SUFFIX = ".ood";
    //单条数据操作受影响
    public static final int SINGLE_AFFECTED = 1;
    //元组有效标志位
    public static final int TUPLE_AVAILABLE = -1;
    //返回受影响
    public static final String ROWS_AFFECTED = " ROWS AFFECTED";
}
