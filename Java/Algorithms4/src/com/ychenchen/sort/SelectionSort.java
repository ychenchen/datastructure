package com.ychenchen.sort;

import com.ychenchen.utils.IntComparator;

import java.util.Comparator;

import static com.ychenchen.sort.BasicMethod.*;

/**
 * {@code SelectionSort} 提供了一个静态方法，用来对数组做<em>选择排序</em>.
 * 对于长度为<em>n</em>的待排序数组,选择排序需要做~ &frac12; <em>n</em><sup>2</sup>次比较,
 * 因此它不适合对大容量数组进行排序.
 * 该实现的交换次数正好为<em>n</em>.
 * <p>
 * 选择排序不是稳定的排序. 它额外使用了&Theta;(1)的内存空间(不包括输入数组本身).
 * </p>
 *
 * @author alexis.yang
 * @since 2020/4/1 10:30 AM
 */
public class SelectionSort {
    private SelectionSort() {
    }

    /**
     * 使用自然顺序将数组元素升序排列.
     *
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /**
     * 使用Comparator对Object数组排序.
     * @param a 待排序数组
     * @param comparator 比较器
     */
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min], comparator)) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 5, 3, 8, 4, 9, 2};
        sort(integers);
        show(integers);
        System.out.println("**********");
        Object[] ints = {1, 5, 3, 8, 4, 9, 2};
        sort(ints, new IntComparator());
        show(ints);



    }

}