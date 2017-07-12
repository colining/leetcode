package cn.colining.leetcode.array;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by colin on 2017/7/12.
 */
public class leetcode_128 {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     Your algorithm should run in O(n) complexity.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 2, 3, 1}));
    }

    /**
     * O(n) 很明显不能排序，那就肯定和hash有关系了；
     * 一种是使用hashset，要么就是使用hashmap，
     * hashmap算法上看上去稍微快一点，但是实际运行时，hashset更快。。。。
     * @param num
     * @return
     */
    public static int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();

        for (int i : num)
            set.add(i);

        int count;
        int result = 0;
        int i = 0;
        while (set.size() > 0) {
            int temp = num[i++];
            if (set.remove(temp)) {
                count = 1;
                int low = temp - 1;

                while (set.remove(low--))
                    count++;

                int high = temp + 1;
                while (set.remove(high++))
                    count++;

                result = Math.max(count, result);
            }
        }

        return result;
    }

    public static int longestConsecutive1(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : num) {
            if (!map.containsKey(i)) {
                int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
                int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;
                int sum = left + right + 1;

                map.put(i, sum);
                result = Math.max(sum, result);

                map.put(i - left, sum);
                map.put(i + right, sum);
            }
            else {
                continue;
            }
        }
        return result;
    }


}
