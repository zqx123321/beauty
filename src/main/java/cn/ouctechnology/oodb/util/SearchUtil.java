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

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 3, 3, 4, 4, 6, 6, 7};
        //第一个小于某个数，应用于>=
//        System.out.println(lowerBound(a, 8, 1));
//        System.out.println(lowerBound(a, 8, 3));
        System.out.println(lowerBound(a, 8, 4));
//        System.out.println(lowerBound(a, 8, 5));
//        System.out.println(lowerBound(a, 8, 6));
//        System.out.println(lowerBound(a, 8, 0));
//        System.out.println(lowerBound(a, 8, 8));
        //第一个大于,应用于<=
   //     System.out.println(upperBound(a, 8, 5));
//        System.out.println(upperBound(a, 8, 3));
//        System.out.println(upperBound(a, 8, 4));
//        System.out.println(upperBound(a, 8, 5));
//        System.out.println(upperBound(a, 8, 6));
//        System.out.println(upperBound(a, 8, 0));
//        System.out.println(upperBound(a, 8, 8));
    }
}
