package cn.colining.leetcode.stack;

import java.util.Stack;

/**
 * Created by colin on 2017/7/13.
 */
public class leetcode_84 {
    /**
     * https://leetcode.com/problems/largest-rectangle-in-histogram/#/description
     */
    public static void main(String[] args) {
        int[] array = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(array));
    }

    /**
     * 数学分析 + 栈；
     * 通过分析，如果一个矩形没有后一个矩形高，那么终点肯定在后面
     * 如果一个矩形没有前面的高，说明前面的大矩形可以求和了；
     * @param array
     * @return
     */
    private static int largestRectangleArea(int[] array) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int length = array.length;
        for (int i = 0; i <= length; i++) {
            int h = (i == length) ? 0 : array[i];
            if (stack.isEmpty() || h >=array[stack.peek()]) {
                stack.push(i);
            }else {
                int tp = stack.pop();
                result = Math.max(result, array[tp] * (stack.isEmpty()?i: i - 1 - stack.peek()));
                i--;
            }
        }
        return result;
    }

    /**
     * 最土的办法，会TLE，不过怎么也是自己写的是吧
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }
        int result = 0;
        int[] nums = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            boolean flag = true;
            int j = i;
            int temp = i;
            while (j >= 0 && heights[i] <= heights[j]) {
                if (i != j && flag && heights[i] == heights[j]) {
                    i++;
                }else if (i!=j){
                    flag = false;
                }
                j--;
                nums[temp]++;
            }
            j = i;
            flag = true;
            while (j < heights.length && heights[i] <= heights[j]) {
                if (i != j && flag && heights[i] == heights[j]) {
                    i++;
                } else if (i!=j){
                    flag = false;
                }
                j++;
                nums[temp]++;
            }
            result = Math.max(result, (nums[temp]-1) * heights[temp]);
        }

        return result;
    }


    public static int largestRectangleArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }



}
