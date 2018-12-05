import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-18 09:51
 * @description: 嵌套表格打印系统
 * @todo 此类性能有待提高
 **/
@SuppressWarnings("all")
public class PrintTable {

    private char[][] header;

    private List<Integer> lens;

    private List<List<String>> rows;

    private String splitLine;

    private Map<String, Integer> lensMap;

    private int maxDeep;


    public PrintTable(List<Map<String, Object>> data) {
        lens = new ArrayList<>();
        Map<String, Object> firstData = data.get(0);
        buildLength(firstData);
        rows = new ArrayList<>();
        buildRows(data);
        lensMap = new HashMap<>();
        buildLensMap(firstData, "", new AtomicInteger(0));


        int length = getLength("", firstData);
        maxDeep = Integer.MIN_VALUE;
        getDeep(firstData, 1);
        header = new char[1 + 2 * maxDeep][length + 5];
        for (int i = 0; i < header.length; i++) {
            Arrays.fill(header[i], ' ');
        }
        //画第一条线
        char[] chars = buildFirstLine(length).toCharArray();
        splitLine = new String(chars);
        System.arraycopy(chars, 0, header[0], 0, chars.length);
        fillHeader(firstData);
        System.arraycopy(chars, 0, header[header.length - 1], 0, chars.length);
        compeleteHeader();

    }

    private static int stringLen(String s) {
        if (s == null) {
            return 0;
        }
        int len = 0;
        String ch = "[\u0391-\uFFE5]";
        String ch2 = "[\u00B7]";
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i, i + 1);
            if (tmp.matches(ch) || tmp.matches(ch2)) {
                len += 2;
            } else
                len += 1;
        }
        return len;
    }

    private void buildLensMap(Map<String, Object> aData, String parent, AtomicInteger count) {
        for (Map.Entry<String, Object> data : aData.entrySet()) {
            String son = buildSon(parent, data.getKey());
            Object value = data.getValue();
            if (value instanceof Map) {
                buildLensMap((Map<String, Object>) value, son, count);
            } else if (value instanceof List)
                buildLensMap((List) value, son, count);
            else lensMap.put(son, lens.get(count.getAndIncrement()));
        }
    }

    private void buildLensMap(List list, String parent, AtomicInteger count) {
        for (int i = 0; i < list.size(); i++) {
            String son = buildSon(parent, i + "");
            Object object = list.get(i);
            if (object instanceof Map) buildLensMap((Map<String, Object>) object, son, count);
            else if (object instanceof List) buildLensMap((List) object, son, count);
            else lensMap.put(son, lens.get(count.getAndIncrement()));
        }
    }

    private String buildSon(String parent, String key) {
        if (parent.equals(""))
            return key;
        return parent + "." + key;
    }

    private void buildLength(Map<String, Object> aData) {
        for (Map.Entry<String, Object> data : aData.entrySet()) {
            Object value = data.getValue();
            if (value instanceof Map) buildLength((Map<String, Object>) value);
            else if (value instanceof List) buildLength((List) value);
            else lens.add(stringLen(data.getKey()));
        }
    }

    private void buildLength(List list) {
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            if (object instanceof Map) buildLength((Map<String, Object>) object);
            else if (object instanceof List) buildLength((List) object);
            else lens.add("0".length());
        }
    }

    private int getLength(String key, Object data) {
        if (data instanceof Map) {
            Map<String, Object> dataMap = (Map<String, Object>) data;
            int length = 0;
            for (Map.Entry<String, Object> objectEntry : dataMap.entrySet()) {
                String son = buildSon(key, objectEntry.getKey());
                length += (getLength(son, objectEntry.getValue()) + 3);
            }
            return length - 3;
        }
        if (data instanceof List) {
            List list = (List) data;
            int length = 0;
            for (int i = 0; i < list.size(); i++) {
                Object object = list.get(i);
                String son = buildSon(key, i + "");
                length += (getLength(son, object) + 3);
            }
            return length - 3;
        }
        return lensMap.get(key);
    }

    private void getDeep(Map<String, Object> data, int deep) {
        maxDeep = Math.max(maxDeep, deep);
        for (Map.Entry<String, Object> objectEntry : data.entrySet()) {
            Object value = objectEntry.getValue();
            if (value instanceof Map) {
                getDeep((Map<String, Object>) value, deep + 1);
            }
            if (value instanceof List) {
                List list = (List) value;
                getDeep(list, deep + 1);
            }
        }
    }

    private void getDeep(List list, int deep) {
        maxDeep = Math.max(maxDeep, deep);
        Object obj = list.get(0);
        if (obj instanceof Map) getDeep((Map<String, Object>) obj, deep + 1);
        else if (obj instanceof List) getDeep((List) obj, deep + 1);
    }

    private void fillHeader(Map<String, Object> data) {

        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(0, "", data));
        //记录下一层的大小
        int size = queue.size();
        int row = 1;

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            size--;

            int index = item.start;
            header[row][index] = '|';
            Object value = item.data;
            if (value instanceof Map) index = dealWithMap(queue, (Map<String, Object>) value, index, row, item.parent);
            else if (value instanceof List) index = dealWithList(queue, (List) value, index, row, item.parent);
            if (size == 0) {
                row += 2;
                size = queue.size();
            }
        }
    }

    private int dealWithMap(Queue<Item> queue, Map<String, Object> data, int index, int row, String parent) {
        for (Map.Entry<String, Object> objectEntry : data.entrySet()) {
            Object value = objectEntry.getValue();
            String key = objectEntry.getKey();
            int length;
            String son = buildSon(parent, key);
            length = getLength(son, value);
            String str = printItemCenter(key, length);
            System.arraycopy(str.toCharArray(), 0, header[row], index + 1, str.length());
            header[row][index + length + 3] = '|';
            if (value instanceof Map || value instanceof List) {
                son = buildSon(parent, key);
                queue.offer(new Item(index, son, value));
                str = buildStrWithFixCharAndLength('-', length + 2);
                System.arraycopy(str.toCharArray(), 0, header[row + 1], index + 1, str.length());
            }
            index += (length + 3);
        }
        return index;
    }

    private int dealWithList(Queue<Item> queue, List data, int index, int row, String parent) {
        for (int i = 0; i < data.size(); i++) {
            Object value = data.get(i);
            String key = i + "";
            int length;
            String son = buildSon(parent, key);
            length = getLength(son, value);
            String str = printItemCenter(key, length);
            System.arraycopy(str.toCharArray(), 0, header[row], index + 1, str.length());
            header[row][index + length + 3] = '|';
            if (value instanceof Map || value instanceof List) {
                son = buildSon(parent, key);
                queue.offer(new Item(index, son, value));
                str = buildStrWithFixCharAndLength('-', length + 2);
                System.arraycopy(str.toCharArray(), 0, header[row + 1], index + 1, str.length());
            }
            index += (length + 3);
        }
        return index;
    }

    private void compeleteHeader() {
        for (int i = 1; i < header.length - 1; i++) {
            for (int j = 0; j < header[i].length; j++) {
                char c = header[i][j];
                if (c == '|') {
                    if (header[i + 1][j] == ' ') header[i + 1][j] = '|';
                }

                if (checkItem(c) && header[i - 1][j] == '-') {
                    int count = 0;
                    while (true) {
                        count++;
                        if (header[i + count][j] == '-') break;
                    }
                    int dis = (count - 1) / 2;
                    header[i][j] = ' ';
                    header[i + dis][j] = c;
                }
            }
        }
    }

    private void buildRows(List<Map<String, Object>> data) {
        for (Map<String, Object> aData : data) {
            List<String> row = new ArrayList<>();
            rows.add(row);
            buildRow(aData, row);
        }
    }

    private void buildRow(Map<String, Object> aData, List<String> row) {
        for (Map.Entry<String, Object> data : aData.entrySet()) {
            Object value = data.getValue();
            if (value instanceof Map) buildRow((Map<String, Object>) value, row);
            else if (value instanceof List) {
                buildRow((List) value, row);
            } else {
                String str = value.toString();
                row.add(str);
                Integer length = lens.get(row.size() - 1);
                lens.set(row.size() - 1, Math.max(length, stringLen(str)));
            }
        }
    }

    private void buildRow(List list, List<String> row) {
        for (Object object : list) {
            if (object instanceof Map) buildRow((Map<String, Object>) object, row);
            else if (object instanceof List) buildRow((List) object, row);
            else {
                String str = object.toString();
                row.add(str);
                Integer length = lens.get(row.size() - 1);
                lens.set(row.size() - 1, Math.max(length, stringLen(str)));
            }
        }
    }

    private boolean checkItem(char c) {
        return c != '-' && c != '+' && c != +'|' && c != ' ';
    }

    private String buildArray(List<String> row) {
        StringBuilder buff = new StringBuilder();
        buff.append("|");
        for (int i = 0; i < lens.size(); i++) {
            String s = null;
            if (i < row.size()) {
                s = row.get(i);
            }
            buff.append(" ");
            buff.append(polishing(s, lens.get(i)));
            buff.append(" |");
        }
        return buff.toString();
    }


    private String printItemCenter(String item, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        String front = buildStrWithFixCharAndLength(' ', (length - item.length()) / 2);
        sb.append(front);
        sb.append(item);
        String back = buildStrWithFixCharAndLength(' ', (length - sb.length() + 1));
        sb.append(back);
        sb.append(" ");
        return sb.toString();
    }


    private String polishing(String str, int destLength) {
        if (str == null) {
            return buildStrWithFixCharAndLength(' ', destLength);
        }
        int len = stringLen(str);
        if (len < destLength) {
            int dif = destLength - len;
            char[] cs = new char[dif];
            Arrays.fill(cs, ' ');
            return str + new String(cs);
        } else if (len == destLength) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder();
            char[] cs = str.toCharArray();
            for (char c : cs) {
                if (stringLen(sb.toString() + c) >= destLength - 3) {
                    break;
                }
                sb.append(c);
            }
            String s = sb.toString() + "...";
            len = stringLen(s);
            if (len < destLength) {
                int dif = destLength - len;
                cs = new char[dif];
                Arrays.fill(cs, ' ');
                return s + new String(cs);
            }
            return s;
        }
    }

    private String buildSplitLine(int length) {
        return "|" +
                buildStrWithFixCharAndLength('-', length + 2) +
                "|";
    }

    private String buildFirstLine(int length) {
        return "+" +
                buildStrWithFixCharAndLength('-', length + 2) +
                "+";
    }

    private String buildStrWithFixCharAndLength(char c, int len) {
        char[] cs = new char[len];
        Arrays.fill(cs, c);
        return new String(cs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < header.length; i++) {
            sb.append(new String(header[i])).append('\n');
        }
        for (List<String> row : rows) {
            sb.append(buildArray(row)).append('\n');
            sb.append(splitLine).append('\n');
        }
        return sb.toString();
    }

    class Item {
        int start;
        String parent;
        Object data;

        public Item(int start, String parent, Object data) {
            this.start = start;
            this.parent = parent;
            this.data = data;
        }
    }

}
