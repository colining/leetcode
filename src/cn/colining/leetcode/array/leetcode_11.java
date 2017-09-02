package cn.colining.leetcode.array;

import java.util.Scanner;

/**
 * Created by colin on 2017/9/2.
 */
public class leetcode_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            maxArea(array);
        }
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxLeft = height[0], maxRight = height[height.length-1];
        int maxArea = Integer.MIN_VALUE;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(maxLeft, maxRight) * (j-i));
            if (maxLeft > maxRight) {
                j--;
                maxRight = Math.max(maxRight, height[j]);
            }else {
                i++;
                maxLeft = Math.max(maxLeft, height[i]);
            }
        }
        System.out.println(maxArea);
        return maxArea;
    }
}
