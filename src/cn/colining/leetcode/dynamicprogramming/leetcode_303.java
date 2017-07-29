package cn.colining.leetcode.dynamicprogramming;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by colin on 2017/7/29.
 */
public class leetcode_303 {
    /*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    Example:
    Given nums = [-2, 0, 3, -5, 2, -1]

    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            System.out.println(obj.sumRange(i, j));
        }
    }
    /*
    一开始是想创建一个二维数组，后来发现会溢出
    然后就想到所有和都可以写成一个大和减去前面的元素
    紧接着就想到是大和减去小和。最后就得到结果了
     */
    static class NumArray {
        int[] array;

        public NumArray(int[] nums) {
            array = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                array[i] = i == 0 ? nums[i] : array[i - 1] + nums[i];
            }
        }


        public int sumRange(int i, int j) {

            return i==0? array[j]: array[j] - array[i-1];
        }
    }
}
