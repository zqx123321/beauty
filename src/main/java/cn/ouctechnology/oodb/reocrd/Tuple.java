package cn.ouctechnology.oodb.reocrd;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-08 17:01
 * @description: 查询结果封装, 把查询结果当成无差别的Tuple
 **/
public class Tuple {
    private Logger logger = LoggerFactory.getLogger(Tuple.class);
    private Map<String, Object> values = new HashMap<>();

    public void add(String name, Object value) {
        values.put(name, value);
    }

    /**
     * 获取值，先尝试直接获取，失败后再用OGNL方式获取
     */
    public Object get(String name) {
        Object value = values.get(name);
        if (value == null && name.contains(".")) return getByOgnl(name);
        return value;
    }

    /**
     * OGNL对象导航语言获取值，可以直接调用tuple.get("dept.id")获取对象内部的值
     */
    public Object getByOgnl(String name) {
        if (name == null) return null;
        String[] partitions = name.trim().split("\\.");
        Object res = values.get(partitions[0]);
        for (int i = 1; i < partitions.length; i++) {
            res = ((Map) res).get(partitions[i]);
        }
        return res;
    }

    /**
     * 由tuple写入数据
     */
    public void write(Block block, String tableName) {
        int dataOffset = block.getDataOffset();
        Set<Map.Entry<String, Object>> entries = values.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String name = entry.getKey();
            Object value = entry.getValue();
            //重新归位
            Attribute attribute = Catalog.getAttribute(tableName, name);
            int attributeOffset = Catalog.getAttributeOffset(tableName, name);
            block.setDataOffset(dataOffset + attributeOffset);
            attribute.writeValue(block, value);
        }
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(values);
        } catch (JsonProcessingException e) {
            logger.error("convert tuple to json error:" + e.getMessage());
            return values.toString();
        }
    }

    public Map<String, Object> getValues() {
        return values;
    }
}
