package com.ychenchen.utils;

import java.util.Comparator;

/**
 * @author alexis.yang
 * @date 2020/4/1 6:00 PM
 * @copyright www.ychenchen.com
 */
public class IntComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer m, Integer n) {
        return m < n ? -1 : m > n ? 1 : 0;
    }
}
