package cn.ouctechnology.oodb.util;

/**
 * @program: oodb
 * @author: ZQX
 * @create: 2018-11-07 11:44
 * @description: TODO
 **/
public class SearchUtil {
    public static <T extends Comparable<T>> int lowerBound(T[] arr, int length, T key) {
        int half;
        int mid;
        int first = 0;
        while (length > 0) {
            half = length >> 1;
            mid = first + half;
            //in the right part
            if (arr[mid].compareTo(key) < 0) {
                first = mid + 1;
                //因为first=mid+1,所以这里的len需要在减去half的基础之上再减去1
                length = length - half - 1;
            } else {
                //in the left part
                length = half;
            }
        }
        return first;
    }

    public static <T extends Comparable<T>> int upperBound(T[] arr, int length, T key) {
        int mid;
        int first = 0;
        int half;
        while (length > 0) {
            half = length >> 1;
            mid = half + first;
            if (arr[mid].compareTo(key) > 0) {//in the left part
                length = half;
            } else {//if arr[mid]<= key ,in the right part
                first = mid + 1;
                length = length - half - 1;
            }
        }
        return first;
    }
}
