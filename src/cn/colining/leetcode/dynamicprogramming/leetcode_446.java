package cn.colining.leetcode.dynamicprogramming;

import java.util.HashMap;

/**
 * Created by colin on 2017/8/4.
 */
public class leetcode_446 {
    /*
    算数切片
    可以不相连的子序列
    Input: [2, 4, 6, 8, 10]

    Output: 7

    Explanation:
    All arithmetic subsequence slices are:
    [2,4,6]
    [4,6,8]
    [6,8,10]
    [2,4,6,8]
    [4,6,8,10]
    [2,4,6,8,10]
    [2,6,10]
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 7, 3, 4, 9, 11};
        System.out.println(numberOfArithmeticSlices(array));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        HashMap<Integer, Integer> map[] = new HashMap[A.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                int d = (int) diff;
                //num1 的用处是防止前面的值有相等的情况
                //比如 2,2,3,4  在i=3 的循环中；
                //j = 0 时，map[2]就被更改了；
                //1对应的值从0就变成了1
                //然后j=1时，这个值理应变成2
                int num1 = map[i].getOrDefault(d, 0);
                //num2 ：也就是map中的value是说差为d的对数前面有几个
                int num2 = map[j].getOrDefault(d, 0);
                res += num2;
                map[i].put(d, num1 + num2 + 1);
            }
        }
        return res;
    }
}
