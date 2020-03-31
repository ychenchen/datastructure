package com.ychenchen.sort;

/**
 * @author alexis.yang
 * @date 2020/3/31 8:25 AM
 * @copyright www.ychenchen.com
 */
public class BasicMethod {
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
           if (less(a[i], a[i - 1])) {
               return false;
           }
        }
        return true;
    }
}
