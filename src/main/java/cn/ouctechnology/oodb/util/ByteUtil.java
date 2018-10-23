package cn.ouctechnology.oodb.util;

/**
 * @program: db
 * @description: 字节类型转化工具类
 * @author: ZQX
 * @create: 2018-09-10 17:10
 **/
public class ByteUtil {

    public static int getBytes(char data, byte[] bytes, int start) {
        bytes[start] = (byte) (data);
        bytes[start + 1] = (byte) (data >> 8);
        return start + 2;
    }

    public static int getBytes(int data, byte[] bytes, int start) {
        bytes[start] = (byte) (data & 0xff);
        bytes[start + 1] = (byte) ((data & 0xff00) >> 8);
        bytes[start + 2] = (byte) ((data & 0xff0000) >> 16);
        bytes[start + 3] = (byte) ((data & 0xff000000) >> 24);
        return start + 4;
    }

    public static int getBytes(long data, byte[] bytes, int start) {
        bytes[start] = (byte) (data & 0xff);
        bytes[start + 1] = (byte) ((data >> 8) & 0xff);
        bytes[start + 2] = (byte) ((data >> 16) & 0xff);
        bytes[start + 3] = (byte) ((data >> 24) & 0xff);
        bytes[start + 4] = (byte) ((data >> 32) & 0xff);
        bytes[start + 5] = (byte) ((data >> 40) & 0xff);
        bytes[start + 6] = (byte) ((data >> 48) & 0xff);
        bytes[start + 7] = (byte) ((data >> 56) & 0xff);
        return start + 8;
    }

    /**
     * @param len 创建表时设定的该字符串最大长度
     */
    public static int getBytes(String data, byte[] bytes, int start, int len) {
        if (data.length() > len) throw new RuntimeException("字符串：" + data + "长度超过设定上限：len");
        int res = start + 2 * len;
        int i = 0;
        for (; i < data.length(); i++) {
            char c = data.charAt(i);
            start = getBytes(c, bytes, start);
        }
        //清楚多余的字符填充
        for (int j = start; j < res; j++) {
            bytes[j] = 0;
        }
        return res;
    }

    public static int getBytes(float data, byte[] bytes, int start) {
        //方法返回根据IEEE754浮点“单一格式”位布局，返回指定浮点值的表示。
        int i = Float.floatToIntBits(data);
        return getBytes(i, bytes, start);
    }


    public static char getChar(byte[] bytes, int start) {
        return (char) ((0xff & bytes[start])
                | (0xff00 & (bytes[start + 1] << 8)));
    }

    public static int getInt(byte[] bytes, int start) {
        return (0xff & bytes[start])
                | (0xff00 & (bytes[start + 1] << 8))
                | (0xff0000 & (bytes[start + 2] << 16))
                | (0xff000000 & (bytes[start + 3] << 24));
    }

    public static long getLong(byte[] bytes, int start) {
        return (0xffL & (long) bytes[start])
                | (0xff00L & ((long) bytes[start + 1] << 8))
                | (0xff0000L & ((long) bytes[start + 2] << 16))
                | (0xff000000L & ((long) bytes[start + 3] << 24))
                | (0xff00000000L & ((long) bytes[start + 4] << 32))
                | (0xff0000000000L & ((long) bytes[start + 5] << 40))
                | (0xff000000000000L & ((long) bytes[start + 6] << 48))
                | (0xff00000000000000L & ((long) bytes[start + 7] << 56));
    }

    /**
     * @param len 创建表时设定的该字符串最大长度
     */
    public static String getString(byte[] bytes, int start, int len) {
        char[] str = new char[len];
        for (int i = 0; i < len; i++) {
            str[i] = getChar(bytes, start);
            start += 2;
        }
        //一定要trim一下
        return new String(str).trim();
    }

    public static float getFloat(byte[] bytes, int start) {
        return Float.intBitsToFloat(getInt(bytes, start));
    }
}
