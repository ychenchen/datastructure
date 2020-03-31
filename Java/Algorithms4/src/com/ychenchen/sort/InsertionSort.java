package com.ychenchen.sort;

import static com.ychenchen.sort.BasicMethod.*;

/**
 * @author alexis.yang
 * @date 2020/3/31 9:19 AM
 * @copyright www.ychenchen.com
 */
public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {   //i从1开始，每次循环完成第i个元素的向前插入排序
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 5, 3, 8, 4, 9, 2};
        sort(ints);
        show(ints);
    }
}
