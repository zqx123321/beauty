package cn.ouctechnology.oodb.constant;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-07 10:50
 * @description: 封装常量类
 **/
public class Constants {
    /**
     * 以下为不可配置项
     */
    //目录文件后缀
    public static final String CATALOG_SUFFIX = ".catalog";
    public static final String NO_GROUPING = "NO_GROUPING";
    //在CRUD过程中操作失败返回FAIL
    public static final int FAIL = -1;
    //在获取偏移量的时候没找到
    public static final int NOT_FOUND = -1;
    //INT类型所占字节数
    public static final int SIZE_INT = 4;
    //FLOAT类型所占字节数
    public static final int SIZE_FLOAT = 4;
    //空闲链表结尾标志
    public static final int FREE_LIST_EOF = -1;
    //数据文件后缀
    public static final String RECORD_SUFFIX = ".beauty";
    //单条数据操作受影响
    public static final int SINGLE_AFFECTED = 1;
    //元组有效标志位
    public static final int TUPLE_AVAILABLE = -2;
    //返回受影响
    public static final String ROWS_AFFECTED = " ROWS AFFECTED";
    //索引文件后缀
    public static final String INDEX_SUFFIX = ".index";
    //用于读
    public static final int READ = 0;
    //用于写
    public static final int WRITE = 1;
    /**
     * 以下为可配置项目
     */
    //数据库文件存放目录
    public static String DB_PATH = "server/db/";
    //服务器支持的最大连接数
    public static int MAX_SOCKET_COUNT = 5;
    //服务器端口号
    public static int SERVER_PORT = 9999;
    //一个缓冲区块的大小
    public static int BLOCK_SIZE = 8 * 1024;
    //缓冲区中可容纳的最大区块数量
    public static int MAX_NUM_OF_BLOCKS = 50;
    //索引二级缓存中最大的索引块数量
    public static int MAX_NUM_OF_NODE = 50;
    //定时任务执行间隔
    public static long SYNC_PERIOD = 3000;
    //存放模式信息的文件
    public static String TABLE_FILE_NAME = "table";
}
