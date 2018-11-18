import java.util.*;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-16 18:43
 * @description: TODO
 **/
@SuppressWarnings("all")
public class TextTable {

    public final static String SEP = "\n";

    private String[] header;

    private String[][] rows;


    public TextTable(List<Map<String, Object>> data) {
        Map<String, Object> firstData = data.get(0);
        header = new String[5];
        rows = new String[5][5];
        buildHeaders(firstData, 0, "");

        buildRows(data);
    }


    private void buildHeaders(Map<String, Object> firstData, int count, String parent) {
        for (Map.Entry<String, Object> data : firstData.entrySet()) {
            if (!(data.getValue() instanceof Map)) header[count++] = parent + data.getKey();
            else buildHeaders((Map<String, Object>) data.getValue(), count, data.getKey() + ".");
        }
    }

    private void buildRows(List<Map<String, Object>> data) {
        for (int i = 0; i < data.size(); i++) {
            Map<String, Object> aData = data.get(i);
            buildRow(aData, i, 0);
        }
    }

    private void buildRow(Map<String, Object> aData, int row, int count) {
        for (Map.Entry<String, Object> data : aData.entrySet()) {
            if (!(data.getValue() instanceof Map)) rows[row][count++] = data.getValue().toString();
            else buildRow((Map<String, Object>) data.getValue(), row, count);
        }
    }

    private int getLength(String key, Object data) {
        if (!(data instanceof Map)) return Math.max(key.length(), data.toString().length());
        Map<String, Object> dataMap = (Map<String, Object>) data;
        int length = 0;
        for (Map.Entry<String, Object> objectEntry : dataMap.entrySet()) {
            length += (getLength(objectEntry.getKey(), objectEntry.getValue()) + 3);
        }
        return length - 3;
    }

    class Item {
        int start;
        Map<String, Object> dataMap;

        public Item(int start, Map<String, Object> dataMap) {
            this.start = start;
            this.dataMap = dataMap;
        }
    }

    private String printHeader(Map<String, Object> firstData) {
        StringBuilder sb = new StringBuilder();
        //画表头第一条线
        int length = getLength("", firstData);
        String splitLine = buildFirstLine(length);
        append(sb, splitLine);

        StringBuilder separateLine = new StringBuilder();
        LinkedList<Item> queue = new LinkedList<>();
        queue.push(new Item(0, firstData));
        //记录下一层的大小
        int size = queue.size();
        //记录前一个对象的偏移
        int pre = 0;
        while (!queue.isEmpty()) {
            Item item = queue.pop();
            size--;

            //画当前层的表头
            String polishing = polishing(null, item.start);
            sb.append(polishing);
            sb.append("|");
            separateLine.append(polishing);
            separateLine.append("-");
            int index = item.start;
            for (Map.Entry<String, Object> objectEntry : item.dataMap.entrySet()) {
                Object value = objectEntry.getValue();
                String key = objectEntry.getKey();
                length = getLength(key, value);
                sb.append(" ");
                sb.append(polishing(key, length));
                sb.append(" |");


                if (value instanceof Map) {
                    queue.push(new Item(index, (Map<String, Object>) value));
                    separateLine.append(" ");
                    separateLine.append(buildStrWithFixCharAndLength('-', length));
                    separateLine.append(" -");
                } else {
                    separateLine.append(" ");
                    separateLine.append(buildStrWithFixCharAndLength(' ', length));
                    separateLine.append(" -");
                }
                index += (length + 3);
            }
            //记录偏移量
            pre = index;
            if (size == 0) {
                sb.append(SEP);
                append(sb, separateLine.toString());
                separateLine = new StringBuilder(polishing);
                size = queue.size();
            }
        }
        return sb.toString();
    }

    private void printBlank(int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(" ");
        }
    }


    public TextTable(String[] header, String[][] rows) {
        this.header = header;
        this.rows = rows;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public String[][] getRows() {
        return rows;
    }

    public void setRows(String[][] rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();

        // calc length of every column
        int[] lens = calcLenOfColumn(header, rows);

        // build split line
        String splitLine = buildSplitLine(lens);

        // print split line
        append(buff, splitLine);

        // print header
        append(buff, buildArray(lens, header));

        // print split line
        append(buff, splitLine);

        for (String[] row : rows) {
            append(buff, buildArray(lens, row));
            append(buff, splitLine);
        }
        return buff.toString();
    }

    private void append(StringBuffer buff, String line) {
        buff.append(line).append(SEP);
    }

    private void append(StringBuilder buff, String line) {
        buff.append(line).append(SEP);
    }

    private String buildSplitLine(int[] lens) {
        StringBuilder buff = new StringBuilder();
        buff.append("+");
        for (int len : lens) {
            buff.append(buildStrWithFixCharAndLength('-', len + 2));
            buff.append("+");
        }
        return buff.toString();
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


    private String buildArray(int[] lens, String[] row) {
        StringBuilder buff = new StringBuilder();
        buff.append("|");
        for (int i = 0; i < header.length; i++) {
            String s = null;
            if (i < row.length) {
                s = row[i];
            }
            buff.append(" ");
            buff.append(polishing(s, lens[i]));
            buff.append(" |");
        }
        return buff.toString();
    }


    /**
     * 计算每列的宽度（所有宽度里面取最大的）
     */
    private int[] calcLenOfColumn(String[] header, String[][] rows) {
        int[] lens = new int[header.length];
        Arrays.fill(lens, 0);
        for (int i = 0; i < header.length; i++) {
            lens[i] = Math.max(stringLen(header[i]), lens[i]);
        }
        for (String[] row : rows) {
            for (int i = 0; i < header.length; i++) {
                if (i < row.length) {
                    lens[i] = Math.max(stringLen(row[i]), lens[i]);
                }
            }
        }
        return lens;
    }

    /**
     * calc string length
     *
     * @param s
     * @return
     */
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

    private String buildStrWithFixCharAndLength(char c, int len) {
        char[] cs = new char[len];
        Arrays.fill(cs, c);
        return new String(cs);
    }

    /**
     * polish blank after string with max length
     *
     * @param str
     * @param destLength
     * @return
     */
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

    public static void main(String[] args) {
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> aData = new HashMap<>();
            aData.put("name", "dad" + i);
            aData.put("id", i);
            Map<String, Object> sunData = new HashMap<>();
            sunData.put("name", "son" + i);
            sunData.put("id", i + 9);
            sunData.put("age", i + 9.1);
//            Map<String, Object> subData = new HashMap<>();
//            subData.put("name", "son" + i);
//            subData.put("id", i + 9);
//            sunData.put("sub", subData);
            aData.put("dept", sunData);
            data.add(aData);
        }
        TextTable textTable = new TextTable(data);
        System.out.println(textTable.printHeader(data.get(0)));
    }
}
