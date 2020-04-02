package com.ychenchen.utils;

import java.util.Comparator;

/**
 * {@code IntComparator} int类型数据的比较器.
 * @author alexis.yang
 * @since  2020/4/2 10:51 AM
 */
public class IntComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer m, Integer n) {
        return m < n ? -1 : m > n ? 1 : 0;
    }
}
