package cn.colining.leetcode.string;

import java.util.Scanner;

/**
 * Created by colin on 2017/8/15.
 */
public class leetcode_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            System.out.println(reverse(n));

        }
    }
    public static int reverse(int x) {
        Integer temp = x;
        char [] c = temp.toString().toCharArray();
        int flag = 1;
        if (c[0] == '-') {
            flag = -1;
        } else if (c[0] != '+') {
            flag = c[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = c.length-1; i >0  ; i--) {
            if (c[i] == '0' && stringBuilder.length() == 0) {
                continue;
            }
            stringBuilder.append(c[i]);
        }
        try {


            if (flag == 1 || flag == -1) {
                return Integer.parseInt(stringBuilder.toString()) * flag;
            }
            return Integer.parseInt(stringBuilder.append(c[0]).toString());
        } catch (Exception e) {
            return 0;
        }
    }
}
