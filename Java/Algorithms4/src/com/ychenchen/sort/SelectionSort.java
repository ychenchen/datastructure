package com.ychenchen.sort;

import static com.ychenchen.sort.BasicMethod.*;

/**
 * @author alexis.yang
 * @date 2020/3/31 8:16 AM
 * @copyright www.ychenchen.com
 */
public class SelectionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 5, 3, 8, 4, 9, 2};
        sort(ints);
        show(ints);
    }

}

