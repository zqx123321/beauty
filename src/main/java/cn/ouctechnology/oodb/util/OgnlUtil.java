package cn.ouctechnology.oodb.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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

    public static String getLeftField(String ognl) {
        return ognl.substring(ognl.indexOf(".") + 1);
    }

    public static Object eval(String expr) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = null;
        try {
            result = engine.eval(expr);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        if (result instanceof Double) {
            double doubleValue = (double) result;
            return (float) doubleValue;
        }
        return result;
    }

}
