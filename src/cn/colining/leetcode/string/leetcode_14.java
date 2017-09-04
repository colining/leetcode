package cn.colining.leetcode.string;

import java.util.Scanner;

/**
 * Created by colin on 2017/9/4.
 */
public class leetcode_14 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            String[] strs = new String[n];
//            for (int i = 0; i < n; i++) {
//                strs[i] = scanner.next();
//            }
//            System.out.println(longestCommonPrefix(strs));
//        }
        String[] strings = new String[]{"", ""};
        longestCommonPrefix(null);
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strs==null || strs.length==0||strs[0] == null || strs[0].length() == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char a = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j] == null ||strs[j].length() == 0|| i>=strs[j].length()||strs[j].charAt(i) != a) {
                    return String.valueOf(stringBuilder);
                }
            }
            stringBuilder.append(a);
        }
        return String.valueOf(stringBuilder);
    }
}
