package com.ychenchen.sort;

/**
 * {code KnuthShuffle}
 * 对输入字符串采用the Knuth (or Fisher-Yates) shuffling algorithm.进行洗牌.
 * 在保证Math.random()产生0到1之间独立均匀分布数字的前提下, 该算法可以保证结果序列
 * 均匀随机排列.
 *
 *  % more cardsUnicode.txt
 *  2♣ 3♣ 4♣ 5♣ 6♣ 7♣ 8♣ 9♣ 10♣ J♣ Q♣ K♣ A♣
 *  2♦ 3♦ 4♦ 5♦ 6♦ 7♦ 8♦ 9♦ 10♦ J♦ Q♦ K♦ A♦
 *  2♥ 3♥ 4♥ 5♥ 6♥ 7♥ 8♥ 9♥ 10♥ J♥ Q♥ K♥ A♥
 *  2♠ 3♠ 4♠ 5♠ 6♠ 7♠ 8♠ 9♠ 10♠ J♠ Q♠ K♠ A♠
 *
 * @author alexis.yang
 * @since  2020/3/31 5:03 PM
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
    public static  void shuffleAlternate(Object[] a) {
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
//        String[] a = {"hello", "world", "alexis", "good", "morning"};
        String[] a = {"5♦", "6♦", "7♦", "10♥", "J♥", "Q♥", "K♥", "A♥"};
        KnuthShuffle.shuffle(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        KnuthShuffle.shuffleAlternate(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
