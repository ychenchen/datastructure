package com.ychenchen.sort;

import static com.ychenchen.sort.BasicMethod.*;

/**
 * {@code ShellSort} 希尔排序, 是快速排序的改进版, 用作者名字命名.
 * 采用<a href = "https://oeis.org/A003462"> Knuth's increment sequence</a>序列减少比较次数.
 * 对于长度为n的数组来说,最坏情况下需要做&Theta;(<em>n</em><sup>3/2</sup>)次比较和交换.
 * <p>
 * 选择排序不是稳定的排序. 它额外使用了&Theta;(1)的内存空间(不包括输入数组本身).
 * </p>
 * @author alexis.yang
 * @since  2020/3/31 11:12 AM
 */
public class ShellSort {
    private ShellSort() { }

    /**
     * 使用自然顺序将数组元素升序排列.
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        int n = a.length;

        // 3x+1递增序列: 1, 4, 13, 40, 121, 364, 1093, ...
        // 先找出对于待排序数组来说最大的h.
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;

        while (h >= 1)
        {
            // h-sort the array.
            for (int i = h; i < n; i++) { // 外层for循环需要做n-h次.
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            assert isHsorted(a, h);
            h = h / 3;
        }
        assert isSorted(a);
    }

    public static void main(String[] args) {
        Integer[] numbs = {1, 7, 5, 3, 8, 4, 9, 6, 2};
        sort(numbs);
        show(numbs);
    }
}
