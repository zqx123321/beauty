package cn.ouctechnology.oodb.util;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-07 11:44
 * @description: TODO
 **/
public class SearchUtil {


    public static <T extends Comparable<T>> int lowerBound(T[] array, int length, T value) {
        if (array[length - 1].compareTo(value) < 0) return length - 1;
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = (low + high) / 2;
            int res = value.compareTo(array[mid]);
            if (res <= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low > 0)
            return low;
        int res = array[low].compareTo(value);
        if (res <= 0) return 0;
        return -1;
    }

    public static <T extends Comparable<T>> int upperBound(T[] array, int length, T value) {
        if (array[0].compareTo(value) > 0) return 0;
        int low = 0;
        int high = length;
        while (low < high) {
            int mid = (low + high) / 2;
            int res = value.compareTo(array[mid]);
            if (res >= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low < length)
            return low;
        return -1;
    }
}
