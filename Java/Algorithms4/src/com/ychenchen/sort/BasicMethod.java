package com.ychenchen.sort;

import java.util.Comparator;

/**
 * {@code BasicMethod} 提供了一些排序算法中用到的通用工具类
 * @author alexis.yang
 * @since 2020/3/31 8:25 AM
 */
public class BasicMethod {
    // is v < w ?
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    public static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }
    // 交换数组中两个元素.
    public static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // 打印数组元素, 以空格分隔.
    public static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // 判断数组a[]是否已经排好序.
    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // 判断数组a[]从a[lo]到a[hi]是否已经排好序.
    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    // 判断数组a[]是否已经排好序.
    public static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    // 判断数组a[]是否已经h排好序.
    public static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h]))
                return false;
        return true;
    }

    // 判断数组a[]从a[lo]到a[hi]是否已经排好序.
    public static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i <= hi ; i++) {
            if (less(a[i], a[i-1], comparator))
                return false;
        }
        return true;
    }

}
