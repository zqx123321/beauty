package cn.ouctechnology.oodb.reocrd;

import cn.ouctechnology.oodb.buffer.Block;
import cn.ouctechnology.oodb.catalog.Catalog;
import cn.ouctechnology.oodb.catalog.attribute.Attribute;
import cn.ouctechnology.oodb.exception.DbException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.*;

import static cn.ouctechnology.oodb.constant.Constants.NOT_FOUND;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-10-08 17:01
 * @description: 查询结果封装, 把查询结果当成无差别的Tuple
 **/
public class Tuple implements Serializable {
    transient private Logger logger = LoggerFactory.getLogger(Tuple.class);
    private Map<String, Object> values = new HashMap<>();

    public void add(String name, Object value) {
        values.put(name, value);
    }

    /**
     * 获取值，先尝试直接获取，失败后再用OGNL方式获取
     */
    public Object get(String name) {
        try {
            return get(values, name);
        } catch (Exception e) {
            throw new DbException("get value by name error", e);
        }
    }

    public Object get(Object object, String name) {
        if (object instanceof Map) return getFromMap((Map<String, Object>) object, name);
        if (object instanceof List) return getFromList((List) object, name);
        return object;
    }

    private Object getFromList(List object, String name) {
        if (!name.contains(".")) return object.get(Integer.parseInt(name));
        String indexStr = name.substring(0, name.indexOf("."));
        if (!indexStr.matches("^[0-9]*[1-9][0-9]*$")) return null;
        Integer index = Integer.parseInt(indexStr);
        Object value = object.get(index);
        String suffix = name.substring(name.indexOf(".") + 1);
        return get(value, suffix);
    }

    private Object getFromMap(Map<String, Object> values, String name) {
        Object value = values.get(name);
        if (value != null) return value;
        for (Map.Entry<String, Object> tupleEntity : this.values.entrySet()) {
            String key = tupleEntity.getKey();
            int index = name.indexOf(key);
            if (index != NOT_FOUND) {
                value = tupleEntity.getValue();
                String suffix = name.substring(index + key.length() + 1);
                Object res = get(value, suffix);
                if (res != null) return res;
            }
        }
        return null;
    }

    /**
     * 由tuple写入数据
     */
    public void write(Block block, String tableName) {
        int dataOffset = block.getDataOffset();
        Set<Map.Entry<String, Object>> entries = values.entrySet();
        //记录最大偏移 todo 若字段为空怎么办
        int maxOffset = Integer.MIN_VALUE;
        for (Map.Entry<String, Object> entry : entries) {
            String name = entry.getKey();
            Object value = entry.getValue();
            //重新归位
            Attribute attribute = Catalog.getAttribute(tableName, name);
            int attributeOffset = Catalog.getAttributeOffset(tableName, name);
            block.setDataOffset(dataOffset + attributeOffset);
            attribute.writeValue(block, value, attributeOffset);
            if (block.getDataOffset() > maxOffset) maxOffset = block.getDataOffset();
        }
        block.setDataOffset(maxOffset);
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

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return Objects.equals(values, tuple.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
