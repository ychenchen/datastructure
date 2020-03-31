package com.ychenchen.sort;

import java.util.Random;

/**
 * @author alexis.yang
 * @date 2020/3/31 5:03 PM
 * @copyright https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Knuth.java.html
 */
public class KnuthShuffle {

    private KnuthShuffle() { }

    /**
     * 对Object数组中的元素均匀地洗牌
     * @param a the array to be shuffled
     */
    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
           int r = (int) (Math.random() * (i + 1));
           Object temp = a[r];
           a[r] = a[i];
           a[i] = temp;
        }
    }

    /**
     * 对Object数组中的元素均匀地洗牌
     * @param a the array to be shuffled
     */
    public static  void shuffleAltinate(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [i, n-1]
            int r = i + (int) (Math.random() * (n - i));
            Object temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        String[] a = {"hello", "world", "alexis", "good", "morning"};
        KnuthShuffle.shuffle(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        KnuthShuffle.shuffleAltinate(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
