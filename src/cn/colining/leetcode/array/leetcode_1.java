package cn.colining.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by colin on 2017/7/9.
 */
public class leetcode_1 {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 2, 6, 3, 5, 8, 9, 7};
        int [] a = twoSum1(array, 8);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 其实就是找到和为target的两个数的位置；
     * 而且假设只有那么一组，最先想到其实是排序，然后头尾指针
     * 我认为时间会更多；结果居然比使用hashmap还要快。。。。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 使用hashmap 可以做到一层循环出结果
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
