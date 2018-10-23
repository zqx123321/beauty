package cn.ouctechnology.oodb.util;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-18 17:00
 * @description: TODO
 **/
public class OgnlUtil {
    /**
     * 获取ognl表达式的第index个字段
     *
     * @param ognl
     * @param index
     */
    public static String getField(String ognl, int index) {
        String[] split = ognl.split("\\.");
        return split[index];
    }

}
