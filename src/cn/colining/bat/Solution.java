package cn.colining.bat;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by colin on 2017/8/11.
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{14, 11, 7, 2};
        System.out.println(findMaximumXOR(array));
    }
    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 3; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num & mask); // reserve Left bits and ignore Right bits
            }

            /* Use 0 to keep the bit, 1 to find XOR
             * 0 ^ 0 = 0
             * 0 ^ 1 = 1
             * 1 ^ 0 = 1
             * 1 ^ 1 = 0
             */
            int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}
