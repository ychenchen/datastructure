package com.ychenchen.sort;

import static com.ychenchen.sort.BasicMethod.*;

/**
 * @author alexis.yang
 * @date 2020/3/31 11:12 AM
 * @copyright www.ychenchen.com
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1)
        {
            // h-sort the array.
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] numbs = {1, 7, 5, 3, 8, 4, 9, 6, 2};
        sort(numbs);
        show(numbs);
    }
}
