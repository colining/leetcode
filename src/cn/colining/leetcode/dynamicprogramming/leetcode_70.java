package cn.colining.leetcode.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by colin on 2017/7/29.
 */
public class leetcode_70 {
    /*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            System.out.println(climbStairs(i));
        }
    }
    /*
    变种斐波那契
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int i = 1;
        int j = 2;
        int temp;
        int time = 2;
        while ( time < n) {
            temp = i;
            i = j;
            j = temp+ j;
            time++;
        }
        return j;
    }
}
