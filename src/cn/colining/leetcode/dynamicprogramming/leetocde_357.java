package cn.colining.leetcode.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by colin on 2017/8/7.
 */
public class leetocde_357 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int num = scanner.nextInt();
            System.out.println(countNumbersWithUniqueDigits(num));
        }
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n <= 0) {
            return 1;
        }
        int res = 10;
        int cur = 9;
        int num = 9;
        for (int i = 1; i < n && num >0; i++) {
            cur *= num;
            res += cur;
            num--;
        }
        return res;
    }
}
