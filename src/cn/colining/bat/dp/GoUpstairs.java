package cn.colining.bat.dp;

import java.util.Scanner;
import java.util.jar.JarEntry;

/**
 * Created by colin on 2017/7/30.
 */

public class GoUpstairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            System.out.println(countWays(n));

        }
    }
    public static int countWays(int n) {
//      return fun1(n);
        int[] map = new int[n+1];
        map[1] = 1;
        map[2] = 2;
        return fun2(n, map);
//        return func3(n);
    }


    private static int fun1(int n) {
        if (n  < 1) {
            return 0;
        }
        if (n <= 2) {
            return n == 1 ? 1 : 2;
        }
        else
            return fun1(n - 1) + fun1(n - 2);
    }

    private static int fun2(int n,int [] map) {
        if (n < 0) {
            return 0;
        }
        if (map[n] != 0) {
            return map[n];
        }
        int sum = fun2(n - 1, map)%1000000007 + fun2(n - 2, map)%1000000007;
        map[n] = sum;
        return sum;
    }

    private static int func3(int n) {
        int i = 1;
        int j = 2;
        if (n <= 1) {
            return n == 1 ? 1 : 2;
        }
        int temp;
        for (int k = 2; k < n; k++) {
            temp = i;
            i = j;
            j = (temp + j)%1000000007;
        }
        return j;
    }


}
