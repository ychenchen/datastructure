package com.ychenchen.sort;

import java.util.Comparator;

import static com.ychenchen.sort.BasicMethod.*;

/**
 * {@code InsertionSort} 插入排序
 * 对于长度为<em>n</em>的待排序数组,插入排序需要做~ &frac12; <em>n</em><sup>2</sup>次比较
 * 和~ &frac12; <em>n</em><sup>2</sup>次交换, 因此插入排序不适合大容量数组的排序.
 * 准确的说, 交换的次数正好等于逆序对(inversions)的个数. 所以, 对于部分有序数组来说, 插入排序
 * 可以在线性时间内完成.
 * <p>
 * 插入排序是稳定的排序. 它额外使用了&Theta;(1)的内存空间(不包括输入数组本身).
 * </p>
 * @author alexis.yang
 * @since 2020/3/31 9:19 AM
 */
public class InsertionSort {

    private InsertionSort() { }
    
    /**
    * 使用自然顺序将数组元素升序排列.
    * @param a 待排序数组
    */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {   //i从1开始，每次循环完成第i个元素的向前插入排序
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * 使用自然顺序将数组元素a[lo..hi]升序排列.
     * @param a 待排序数组
     * @param lo 左侧边界(包含)
     * @param hi 右侧边界(不包含)
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo+1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]) ; j--) {
                exch(a, j, j-1);
            }
        }
        assert isSorted(a, lo, hi);
    }

    /**
     * 使用Comparator对Object数组排序.
     * @param a 待排序数组
     * @param comparator 比较器
     */
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1], comparator); j--) {
                exch(a, j, j-1);
            }
            assert isSorted(a, 0, i, comparator);
        }
        assert isSorted(a, comparator);
    }

    /**
     * 使用Comparator将数组元素a[lo..hi]升序排列.
     * @param a 待排序数组
     * @param lo 左侧边界(包含)
     * @param hi 右侧边界(不包含)
     * @param comparator 比较器
     */
    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--) {
                exch(a, j, j-1);
            }
        }
        assert isSorted(a, lo, hi, comparator);
    }

    public static int[] indexSort(Comparable[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++)
           index[i] = i;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--) {   // 注意这里比较的是a[index[j]], a[index[j-1],而不是a[j], a[j-1].
                exch(index, j, j-1);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 5, 3, 8, 4, 9, 2};
//        sort(ints);
//        show(ints);
        int[] ints1 = indexSort(ints);
        show(ints1);
    }
}
