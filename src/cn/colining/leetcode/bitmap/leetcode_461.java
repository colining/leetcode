package cn.colining.leetcode.bitmap;

import java.util.Scanner;

/**
 * Created by colin on 2017/8/7.
 */
public class leetcode_461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(hammingDistance(n, m));

    }
    public static int hammingDistance(int x, int y) {
        char [] a = Integer.toBinaryString(x ^ y).toCharArray();
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '1') {
                result++;
            }
        }
        return result;
    }
}
